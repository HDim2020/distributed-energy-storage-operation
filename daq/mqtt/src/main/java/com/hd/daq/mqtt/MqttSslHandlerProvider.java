package com.hd.daq.mqtt;

import com.google.common.io.Resources;
import com.hd.daq.mqtt.util.EncryptionUtil;
import com.hd.daq.mqtt.util.SslUtil;
import com.hd.daq.transportapi.DeviceTransportType;
import com.hd.daq.transportapi.TransportService;
import com.hd.daq.transportapi.TransportServiceCallback;
import com.hd.daq.transportapi.auth.ValidateDeviceCredentialsResponse;
import com.hd.daq.transportapi.proto.TransportProtos;
import io.netty.handler.ssl.SslHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author ymm
 */
@Slf4j
@Component("MqttSslHandlerProvider")
@ConditionalOnProperty(prefix = "transport.mqtt.ssl", value = "enabled", havingValue = "true")
public class MqttSslHandlerProvider {
    @Value("${transport.mqtt.ssl.protocol}")
    private String sslProtocol;
    @Value("${transport.mqtt.ssl.key_store}")
    private String keyStoreFile;
    @Value("${transport.mqtt.ssl.key_store_password}")
    private String keyStorePassword;
    @Value("${transport.mqtt.ssl.key_password}")
    private String keyPassword;
    @Value("${transport.mqtt.ssl.key_store_type}")
    private String keyStoreType;

    private final TransportService transportService;

    public MqttSslHandlerProvider(TransportService transportService) {
        this.transportService = transportService;
    }

    public SslHandler getSslHandler() {
        try {
            URL ksUrl = Resources.getResource(keyStoreFile);
            File ksFile = new File(ksUrl.toURI());
            URL tsUrl = Resources.getResource(keyStoreFile);
            File tsFile = new File(tsUrl.toURI());

            TrustManagerFactory tmFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore trustStore = KeyStore.getInstance(keyStoreType);
            try (InputStream tsFileInputStream = new FileInputStream(tsFile)) {
                trustStore.load(tsFileInputStream, keyStorePassword.toCharArray());
            }
            tmFactory.init(trustStore);

            KeyStore ks = KeyStore.getInstance(keyStoreType);
            try (InputStream ksFileInputStream = new FileInputStream(ksFile)) {
                ks.load(ksFileInputStream, keyStorePassword.toCharArray());
            }
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks, keyPassword.toCharArray());

            KeyManager[] km = kmf.getKeyManagers();
            TrustManager x509wrapped = getX509TrustManager(tmFactory);
            TrustManager[] tm = {x509wrapped};
            if (!StringUtils.hasLength(sslProtocol)) {
                sslProtocol = "TLS";
            }
            SSLContext sslContext = SSLContext.getInstance(sslProtocol);
            sslContext.init(km, tm, null);
            SSLEngine sslEngine = sslContext.createSSLEngine();
            sslEngine.setUseClientMode(false);
            sslEngine.setNeedClientAuth(false);
            sslEngine.setWantClientAuth(true);
            sslEngine.setEnabledProtocols(sslEngine.getSupportedProtocols());
            sslEngine.setEnabledCipherSuites(sslEngine.getSupportedCipherSuites());
            sslEngine.setEnableSessionCreation(true);
            return new SslHandler(sslEngine);
        } catch (Exception e) {
            log.error("Unable to set up SSL context. Reason: " + e.getMessage(), e);
            throw new RuntimeException("Failed to get SSL handler", e);
        }
    }

    private TrustManager getX509TrustManager(TrustManagerFactory tmf) throws Exception {
        X509TrustManager x509Tm = null;
        for (TrustManager tm : tmf.getTrustManagers()) {
            if (tm instanceof X509TrustManager) {
                x509Tm = (X509TrustManager) tm;
                break;
            }
        }
        return new ThingsboardMqttX509TrustManager(x509Tm, transportService);
    }

    static class ThingsboardMqttX509TrustManager implements X509TrustManager {

        private final X509TrustManager trustManager;
        private TransportService transportService;

        ThingsboardMqttX509TrustManager(X509TrustManager trustManager, TransportService transportService) {
            this.trustManager = trustManager;
            this.transportService = transportService;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return trustManager.getAcceptedIssuers();
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain,
                                       String authType) throws CertificateException {
            trustManager.checkServerTrusted(chain, authType);
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain,
                                       String authType) throws CertificateException {
            String credentialsBody = null;
            for (X509Certificate cert : chain) {
                try {
                    String strCert = SslUtil.getX509CertificateString(cert);
                    String sha3Hash = EncryptionUtil.getSha3Hash(strCert);
                    final String[] credentialsBodyHolder = new String[1];
                    CountDownLatch latch = new CountDownLatch(1);
                    transportService.process(DeviceTransportType.MQTT, TransportProtos.ValidateDeviceX509CertRequestMsg.newBuilder().setHash(sha3Hash).build(),
                            new TransportServiceCallback<ValidateDeviceCredentialsResponse>() {
                                @Override
                                public void onSuccess(ValidateDeviceCredentialsResponse msg) {
                                    if (StringUtils.hasLength(msg.getCredentials())) {
                                        credentialsBodyHolder[0] = msg.getCredentials();
                                    }
                                    latch.countDown();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    log.error(e.getMessage(), e);
                                    latch.countDown();
                                }
                            });
                    latch.await(10, TimeUnit.SECONDS);
                    if (strCert.equals(credentialsBodyHolder[0])) {
                        credentialsBody = credentialsBodyHolder[0];
                        break;
                    }
                } catch (InterruptedException | IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            if (credentialsBody == null) {
                throw new CertificateException("Invalid Device Certificate");
            }
        }
    }
}
