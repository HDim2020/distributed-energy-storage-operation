package com.hd.daq.mqtt;

import com.gitee.starblues.spring.extract.ExtractCoordinate;
import com.gitee.starblues.spring.extract.ExtractFactory;
import com.hd.daq.mqtt.service.ProtocolPlugin;
import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.mqtt.session.MqttTopicMatcher;
import com.hd.daq.mqtt.util.EncryptionUtil;
import com.hd.daq.mqtt.util.SslUtil;
import com.hd.daq.transportapi.DeviceTransportType;
import com.hd.daq.transportapi.SessionMsgListener;
import com.hd.daq.transportapi.TransportService;
import com.hd.daq.transportapi.TransportServiceCallback;
import com.hd.daq.transportapi.auth.SessionInfoCreator;
import com.hd.daq.transportapi.auth.ValidateDeviceCredentialsResponse;
import com.hd.daq.transportapi.data.thing.*;
import com.hd.daq.transportapi.proto.TransportProtos;
import com.hd.daq.transportapi.service.DefaultTransportService;
import com.hd.daq.transportapi.service.SessionMetaData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.mqtt.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.security.cert.X509Certificate;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static io.netty.handler.codec.mqtt.MqttConnectReturnCode.CONNECTION_ACCEPTED;
import static io.netty.handler.codec.mqtt.MqttConnectReturnCode.CONNECTION_REFUSED_NOT_AUTHORIZED;
import static io.netty.handler.codec.mqtt.MqttMessageType.*;
import static io.netty.handler.codec.mqtt.MqttQoS.*;

/**
 * 每个连接会实例化一次
 *
 * @author ymm
 */
@Slf4j
public class MqttTransportHandler extends ChannelInboundHandlerAdapter implements GenericFutureListener<Future<? super Void>>, SessionMsgListener {
    private static final MqttQoS MAX_SUPPORTED_QOS_LVL = AT_LEAST_ONCE;

    private final UUID sessionId;
    private final MqttTransportContext context;
    private final TransportService transportService;
    private final SslHandler sslHandler;
    private final ConcurrentMap<MqttTopicMatcher, Integer> mqttQoSMap;

    private final DeviceSessionCtx deviceSessionCtx;
    private volatile InetSocketAddress address;

    MqttTransportHandler(MqttTransportContext context, SslHandler sslHandler) {
        this.sessionId = UUID.randomUUID();
        this.context = context;
        this.transportService = context.getTransportService();
        this.sslHandler = sslHandler;
        this.mqttQoSMap = new ConcurrentHashMap<>();
        this.deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, context);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.trace("[{}] Processing msg: {}", sessionId, msg);
        try {
            if (msg instanceof MqttMessage) {
                MqttMessage message = (MqttMessage) msg;
                if (message.decoderResult().isSuccess()) {
                    processMqttMsg(ctx, message);
                } else {
                    log.info("{}", message);
                    log.error("[{}] Client [{}] message processing failed: {}", sessionId, ctx.channel().remoteAddress().toString(),
                            message.decoderResult().cause().getMessage());
                    //TODO 忽略错误消息
                    //processDisconnect(ctx);
                }
            } else {
                processDisconnect(ctx);
            }
        } finally {
            ReferenceCountUtil.safeRelease(msg);
        }
    }

    private void processMqttMsg(ChannelHandlerContext ctx, MqttMessage msg) {
        address = (InetSocketAddress) ctx.channel().remoteAddress();
        if (msg.fixedHeader() == null) {
            log.info("[{}:{}] Invalid message received", address.getHostName(), address.getPort());
            processDisconnect(ctx);
            return;
        }
        deviceSessionCtx.setChannel(ctx);
        if (CONNECT.equals(msg.fixedHeader().messageType())) {
            processConnect(ctx, (MqttConnectMessage) msg);
        } else {
            processRegularSessionMsg(ctx, msg);
        }
    }

    private void processRegularSessionMsg(ChannelHandlerContext ctx, MqttMessage msg) {
        switch (msg.fixedHeader().messageType()) {
            case PUBLISH:
                processPublish(ctx, (MqttPublishMessage) msg);
                break;
            case SUBSCRIBE:
                processSubscribe(ctx, (MqttSubscribeMessage) msg);
                break;
            case UNSUBSCRIBE:
                processUnsubscribe(ctx, (MqttUnsubscribeMessage) msg);
                break;
            case PINGREQ:
                if (checkConnected(ctx, msg)) {
                    ctx.writeAndFlush(new MqttMessage(new MqttFixedHeader(PINGRESP, false, AT_MOST_ONCE, false, 0)));
                    transportService.reportActivity(deviceSessionCtx.getSessionInfo());
                }
                break;
            case DISCONNECT:
                if (checkConnected(ctx, msg)) {
                    processDisconnect(ctx);
                }
                break;
            default:
                break;
        }
    }

    private void processPublish(ChannelHandlerContext ctx, MqttPublishMessage mqttMsg) {
        //判断设备是否已登录
        if (!checkConnected(ctx, mqttMsg)) {
            return;
        }
        transportService.reportActivity(deviceSessionCtx.getSessionInfo());
        String topicName = mqttMsg.variableHeader().topicName();
        int msgId = mqttMsg.variableHeader().packetId();
        log.trace("[{}][{}] Processing publish msg [{}][{}]!", sessionId, deviceSessionCtx.getDeviceInfo().getDeviceName(), topicName, msgId);
        processDevicePublish(ctx, mqttMsg, topicName, msgId);
    }

    /**
     * 处理设备发布消息
     *
     * @param ctx       上下文
     * @param mqttMsg   mqtt消息
     * @param topicName 主题
     * @param msgId     消息ID
     */
    private void processDevicePublish(ChannelHandlerContext ctx, MqttPublishMessage mqttMsg, String topicName, int msgId) {
        try {
            ack(ctx, msgId);
            String pluginId = deviceSessionCtx.getDeviceInfo().getPluginId();
            if (!StringUtils.hasLength(pluginId)) {
                log.debug("Plugin id of {} is empty.", deviceSessionCtx.getDeviceInfo().getDeviceName());
                return;
            }
            ProtocolPlugin plugin = ExtractFactory.getInstant().getExtractByCoordinate(pluginId, ExtractCoordinate.build("protocol", "mqtt"));
            if (plugin == null) {
                log.debug("Can not find plugin who's id is '{}'.", pluginId);
                return;
            }
            plugin.processDevicePublishMessage(deviceSessionCtx, mqttMsg, transportService, getPubAckCallback(ctx, msgId, mqttMsg));
        } catch (Exception e) {
            log.warn("[{}] Failed to process publish msg [{}][{}]", sessionId, topicName, msgId, e);
            log.info("[{}] Closing current session due to invalid publish msg [{}][{}]", sessionId, topicName, msgId);
            processDisconnect(ctx);
        }
    }

    private void ack(ChannelHandlerContext ctx, int msgId) {
        if (msgId > 0) {
            ctx.writeAndFlush(createMqttPubAckMsg(msgId));
        }
    }

    private <T> TransportServiceCallback<Void> getPubAckCallback(final ChannelHandlerContext ctx, final int msgId, final T msg) {
        return new TransportServiceCallback<Void>() {
            @Override
            public void onSuccess(Void dummy) {
                log.trace("[{}] Published msg: {}", sessionId, msg);
            }

            @Override
            public void onError(Throwable e) {
                log.trace("[{}] Failed to publish msg: {}", sessionId, msg, e);
                //processDisconnect(ctx);
            }
        };
    }

    /**
     * 处理订阅主题
     *
     * @param ctx     netty的通道处理上下文
     * @param mqttMsg mqtt订阅消息
     */
    private void processSubscribe(ChannelHandlerContext ctx, MqttSubscribeMessage mqttMsg) {
        if (!checkConnected(ctx, mqttMsg)) {
            return;
        }
        log.trace("[{}] Processing subscription [{}]!", sessionId, mqttMsg.variableHeader().messageId());
        List<Integer> grantedQosList = new ArrayList<>();
        for (MqttTopicSubscription subscription : mqttMsg.payload().topicSubscriptions()) {
            String topic = subscription.topicName();
            MqttQoS reqQoS = subscription.qualityOfService();
            registerSubQoS(topic, grantedQosList, reqQoS);
        }
        transportService.reportActivity(deviceSessionCtx.getSessionInfo());
        ctx.writeAndFlush(createSubAckMessage(mqttMsg.variableHeader().messageId(), grantedQosList));
    }

    private void registerSubQoS(String topic, List<Integer> grantedQoSList, MqttQoS reqQoS) {
        grantedQoSList.add(getMinSupportedQos(reqQoS));
        mqttQoSMap.put(new MqttTopicMatcher(topic), getMinSupportedQos(reqQoS));
    }

    private void processUnsubscribe(ChannelHandlerContext ctx, MqttUnsubscribeMessage mqttMsg) {
        if (!checkConnected(ctx, mqttMsg)) {
            return;
        }
        log.trace("[{}] Processing subscription [{}]!", sessionId, mqttMsg.variableHeader().messageId());
        for (String topicName : mqttMsg.payload().topics()) {
            mqttQoSMap.remove(new MqttTopicMatcher(topicName));
        }
        transportService.reportActivity(deviceSessionCtx.getSessionInfo());
        ctx.writeAndFlush(createUnSubAckMessage(mqttMsg.variableHeader().messageId()));
    }

    private MqttMessage createUnSubAckMessage(int msgId) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(UNSUBACK, false, AT_MOST_ONCE, false, 0);
        MqttMessageIdVariableHeader mqttMessageIdVariableHeader = MqttMessageIdVariableHeader.from(msgId);
        return new MqttMessage(mqttFixedHeader, mqttMessageIdVariableHeader);
    }

    private void processConnect(ChannelHandlerContext ctx, MqttConnectMessage msg) {
        log.info("[{}] Processing connect msg for client: {}!", sessionId, msg.payload().clientIdentifier());
        X509Certificate cert;
        if (sslHandler != null && (cert = getX509Certificate()) != null) {
            processX509CertConnect(ctx, cert, msg);
        } else {
            processAuthTokenConnect(ctx, msg);
        }
    }

    private void processAuthTokenConnect(ChannelHandlerContext ctx, MqttConnectMessage connectMessage) {
        String userName = connectMessage.payload().userName();
        log.info("[{}] Processing connect msg for client[{}] with user name: {}!", sessionId, ctx.channel().remoteAddress().toString(), userName);
        TransportProtos.ValidateBasicMqttCredRequestMsg.Builder request = TransportProtos.ValidateBasicMqttCredRequestMsg.newBuilder()
                .setClientId(connectMessage.payload().clientIdentifier());
        if (userName != null) {
            request.setUserName(userName);
        }
        byte[] bytePassword = connectMessage.payload().passwordInBytes();
        if (bytePassword != null) {
            request.setPassword(new String(bytePassword, CharsetUtil.UTF_8));
        }
        //process方法只负责把请求发送到请求队列中
        transportService.process(DeviceTransportType.MQTT, request.build(),
                new TransportServiceCallback<ValidateDeviceCredentialsResponse>() {
                    @Override
                    public void onSuccess(ValidateDeviceCredentialsResponse msg) {
                        //验证登录请求的响应
                        onValidateDeviceResponse(msg, ctx, connectMessage);
                    }

                    @Override
                    public void onError(Throwable e) {
                        log.trace("[{}] Failed to process credentials: {}, reason:{}.", address, userName, e.getMessage());
                        ctx.writeAndFlush(createMqttConnAckMsg(MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE, connectMessage));
                        processDisconnect(ctx);
                    }
                });
    }

    private void processX509CertConnect(ChannelHandlerContext ctx, X509Certificate cert, MqttConnectMessage connectMessage) {
        try {
            if (!context.isSkipValidityCheckForClientCert()) {
                cert.checkValidity();
            }
            String strCert = SslUtil.getX509CertificateString(cert);
            String sha3Hash = EncryptionUtil.getSha3Hash(strCert);
            transportService.process(DeviceTransportType.MQTT, TransportProtos.ValidateDeviceX509CertRequestMsg.newBuilder().setHash(sha3Hash).build(),
                    new TransportServiceCallback<ValidateDeviceCredentialsResponse>() {
                        @Override
                        public void onSuccess(ValidateDeviceCredentialsResponse msg) {
                            onValidateDeviceResponse(msg, ctx, connectMessage);
                        }

                        @Override
                        public void onError(Throwable e) {
                            log.trace("[{}] Failed to process credentials: {}", address, sha3Hash, e);
                            ctx.writeAndFlush(createMqttConnAckMsg(MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE, connectMessage));
                            processDisconnect(ctx);
                        }
                    });
        } catch (Exception e) {
            ctx.writeAndFlush(createMqttConnAckMsg(CONNECTION_REFUSED_NOT_AUTHORIZED, connectMessage));
            processDisconnect(ctx);
        }
    }

    private X509Certificate getX509Certificate() {
        try {
            X509Certificate[] certChain = sslHandler.engine().getSession().getPeerCertificateChain();
            if (certChain.length > 0) {
                return certChain[0];
            }
        } catch (SSLPeerUnverifiedException e) {
            log.warn(e.getMessage());
            return null;
        }
        return null;
    }

    private void processDisconnect(ChannelHandlerContext ctx) {
        ctx.close();
        log.info("[{}] Client [{};{}] disconnected!", sessionId, ctx.channel().remoteAddress().toString(),
                deviceSessionCtx.getDeviceInfo() != null ? deviceSessionCtx.getDeviceInfo().getDeviceName() : "未知");
        doDisconnect();
    }

    private MqttConnAckMessage createMqttConnAckMsg(MqttConnectReturnCode returnCode, MqttConnectMessage msg) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(CONNACK, false, AT_MOST_ONCE, false, 0);
        MqttConnAckVariableHeader mqttConnAckVariableHeader =
                new MqttConnAckVariableHeader(returnCode, !msg.variableHeader().isCleanSession());
        return new MqttConnAckMessage(mqttFixedHeader, mqttConnAckVariableHeader);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("[{}] Unexpected Exception", sessionId, cause);
        processDisconnect(ctx);
    }

    private static MqttSubAckMessage createSubAckMessage(Integer msgId, List<Integer> grantedQoSList) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(SUBACK, false, AT_MOST_ONCE, false, 0);
        MqttMessageIdVariableHeader mqttMessageIdVariableHeader = MqttMessageIdVariableHeader.from(msgId);
        MqttSubAckPayload mqttSubAckPayload = new MqttSubAckPayload(grantedQoSList);
        return new MqttSubAckMessage(mqttFixedHeader, mqttMessageIdVariableHeader, mqttSubAckPayload);
    }

    private static int getMinSupportedQos(MqttQoS reqQoS) {
        return Math.min(reqQoS.value(), MAX_SUPPORTED_QOS_LVL.value());
    }

    public static MqttPubAckMessage createMqttPubAckMsg(int requestId) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(PUBACK, false, AT_MOST_ONCE, false, 0);
        MqttMessageIdVariableHeader mqttMsgIdVariableHeader =
                MqttMessageIdVariableHeader.from(requestId);
        return new MqttPubAckMessage(mqttFixedHeader, mqttMsgIdVariableHeader);
    }

    private boolean checkConnected(ChannelHandlerContext ctx, MqttMessage msg) {
        if (deviceSessionCtx.isConnected()) {
            return true;
        } else {
            log.info("[{}] Closing current session due to invalid msg order: {}", sessionId, msg);
            processDisconnect(ctx);
            return false;
        }
    }

    @Override
    public void operationComplete(Future<? super Void> future) throws Exception {
        doDisconnect();
    }

    private void doDisconnect() {
        if (deviceSessionCtx.isConnected()) {
            transportService.process(deviceSessionCtx.getSessionInfo(), DefaultTransportService.getSessionEventMsg(TransportProtos.SessionEvent.CLOSED), null);
            transportService.deregisterSession(deviceSessionCtx.getSessionInfo());
            deviceSessionCtx.setDisconnected();
        }
        // 集合里是自己时才删除
        context.getDeviceSessionCtxMap().remove(deviceSessionCtx.getDeviceInfo().getDeviceName(), deviceSessionCtx);
    }


    private void onValidateDeviceResponse(ValidateDeviceCredentialsResponse msg, ChannelHandlerContext ctx, MqttConnectMessage connectMessage) {
        if (!msg.hasDeviceInfo()) {
            //没有找到这个设备(系统中不存在这个名称的设备)
            ctx.writeAndFlush(createMqttConnAckMsg(CONNECTION_REFUSED_NOT_AUTHORIZED, connectMessage));
            processDisconnect(ctx);
        } else {
            deviceSessionCtx.setDeviceInfo(msg.getDeviceInfo());
            deviceSessionCtx.setSessionInfo(SessionInfoCreator.create(msg, context, sessionId));
            // 保存新会话并返回先前会话对象
            DeviceSessionCtx oldDeviceSessionCtx = context.getDeviceSessionCtxMap().put(msg.getDeviceInfo().getDeviceName(), deviceSessionCtx);
            if (oldDeviceSessionCtx != null && oldDeviceSessionCtx.getSessionId() != sessionId) {
                // 注销旧会话并关闭socket连接
                oldDeviceSessionCtx.getChannel().close();
                log.info("[{}] old client [{};{}] disconnected!", oldDeviceSessionCtx.getSessionId(), oldDeviceSessionCtx.getChannel().channel().remoteAddress().toString(),
                        oldDeviceSessionCtx.getDeviceInfo() != null ? oldDeviceSessionCtx.getDeviceInfo().getDeviceName() : "未知");
                if (oldDeviceSessionCtx.isConnected()) {
                    oldDeviceSessionCtx.getContext().getTransportService().process(oldDeviceSessionCtx.getSessionInfo(),
                            DefaultTransportService.getSessionEventMsg(TransportProtos.SessionEvent.CLOSED), null);
                    oldDeviceSessionCtx.getContext().getTransportService().deregisterSession(oldDeviceSessionCtx.getSessionInfo());
                    oldDeviceSessionCtx.setDisconnected();
                }
            }
            //发送会话打开事件消息
            transportService.process(deviceSessionCtx.getSessionInfo(), DefaultTransportService.getSessionEventMsg(TransportProtos.SessionEvent.OPEN), new TransportServiceCallback<Void>() {
                @Override
                public void onSuccess(Void msg) {
                    //注册session，并设置通知消息监听器(接受到通知消息时相应函数会被回调)
                    SessionMetaData sessionMetaData = transportService.registerAsyncSession(deviceSessionCtx.getSessionInfo(), MqttTransportHandler.this);
                    ctx.writeAndFlush(createMqttConnAckMsg(CONNECTION_ACCEPTED, connectMessage));
                    log.info("[{}] Client [{};{}] connected!", sessionId, ctx.channel().remoteAddress().toString(),
                            deviceSessionCtx.getDeviceInfo() != null ? deviceSessionCtx.getDeviceInfo().getDeviceName() : "未知");
                }

                @Override
                public void onError(Throwable e) {
                    log.warn("[{}] Failed to submit session event", sessionId, e);
                    ctx.writeAndFlush(createMqttConnAckMsg(MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE, connectMessage));
                    processDisconnect(ctx);
                }
            });
        }
    }

    /**
     * 远程会话关闭命令，关闭与设备的连接
     *
     * @param sessionCloseNotification
     */
    @Override
    public void onRemoteSessionCloseCommand(TransportProtos.SessionCloseNotificationProto sessionCloseNotification) {
        log.trace("[{}] Received the remote command to close the session", sessionId);
        processDisconnect(deviceSessionCtx.getChannel());
    }

    /**
     * 处理平台发给设备的服务请求
     *
     * @param msg 服务请求
     */
    @Override
    public void onServiceRequest(ServiceRequestMsg msg) {
        log.trace("[{}] Received service request to device", sessionId);
        try {
            String pluginId = deviceSessionCtx.getDeviceInfo().getPluginId();
            if (!StringUtils.hasLength(pluginId)) {
                log.debug("Plugin id of {} is empty.", deviceSessionCtx.getDeviceInfo().getDeviceName());
                return;
            }
            ProtocolPlugin plugin = ExtractFactory.getInstant().getExtractByCoordinate(pluginId, ExtractCoordinate.build("protocol", "mqtt"));
            if (plugin == null) {
                log.debug("Can not find plugin who's id is '{}'.", pluginId);
                return;
            }
            plugin.processServiceRequest(deviceSessionCtx, msg, transportService, getServiceRequestCallback(deviceSessionCtx, msg));
        } catch (Exception e) {
            log.trace("[{}] Failed to convert device RPC command to MQTT msg", sessionId, e);
        }
    }

    private <T> TransportServiceCallback<Void> getServiceRequestCallback(final DeviceSessionCtx deviceSessionCtx, final T msg) {
        return new TransportServiceCallback<Void>() {
            @Override
            public void onSuccess(Void dummy) {
                log.trace("[{}] publish msg:'{}' successful.", deviceSessionCtx.getDeviceInfo().getDeviceName(), msg);
            }

            @Override
            public void onError(Throwable e) {
                log.trace("[{}] publish msg:'{}' failed.", deviceSessionCtx.getDeviceInfo().getDeviceName(), msg, e);
                //processDisconnect(ctx);
            }
        };
    }
}
