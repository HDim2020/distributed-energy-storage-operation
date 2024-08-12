package com.hd.daq.mqtt;

import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.transportapi.TransportContext;
import io.netty.handler.ssl.SslHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ymm
 */
@Slf4j
@Component
public class MqttTransportContext extends TransportContext {
    @Getter
    @Autowired(required = false)
    private MqttSslHandlerProvider sslHandlerProvider;

    @Getter
    @Value("${transport.mqtt.netty.max_payload_size}")
    private Integer maxPayloadSize;

    @Getter
    @Value("${transport.mqtt.netty.skip_validity_check_for_client_cert:false}")
    private boolean skipValidityCheckForClientCert;

    @Getter
    @Setter
    private SslHandler sslHandler;

    @Getter
    private final Map<String, DeviceSessionCtx> deviceSessionCtxMap = new ConcurrentHashMap<>();
}
