package com.hd.daq.transportapi.service;

import com.hd.daq.transportapi.*;
import com.hd.daq.transportapi.auth.TransportDeviceInfo;
import com.hd.daq.transportapi.auth.ValidateDeviceCredentialsResponse;
import com.hd.daq.transportapi.data.thing.*;
import com.hd.daq.transportapi.queue.TbQueueConsumer;
import com.hd.daq.transportapi.queue.common.TbJsonQueueMsg;
import com.hd.daq.transportapi.data.PropertyDataEntity;
import com.hd.daq.transportapi.proto.TransportProtos;
import com.hd.daq.transportapi.queue.TbQueueCallback;
import com.hd.daq.transportapi.queue.TbQueueMsgMetadata;
import com.hd.daq.transportapi.queue.TbQueueProducer;
import com.hd.daq.transportapi.queue.common.TopicPartitionInfo;
import com.hd.daq.transportapi.queue.provider.TbTransportQueueFactory;
import com.hd.daq.transportapi.scheduler.SchedulerComponent;
import com.hd.daq.transportapi.util.NamedThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.security.sasl.AuthenticationException;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author ymm
 */
@Slf4j
@Service
public class DefaultTransportService implements TransportService {
    @Value("${transport.sessions.inactivity_timeout}")
    private long sessionInactivityTimeout;
    @Value("${transport.sessions.report_timeout}")
    private long sessionReportTimeout;
    @Value("${transport.client_side_rpc.timeout:60000}")
    private long clientSideRpcTimeout;
    @Value("${queue.transport.poll_interval:25}")
    private int serviceRequestPollDuration;

    private final SchedulerComponent scheduler;
    private final TbTransportQueueFactory transportQueueFactory;

    protected ExecutorService transportCallbackExecutor;
    private ExecutorService serviceRequestConsumerExecutor;
    protected TbQueueProducer<TbJsonQueueMsg<PropertyDataEntity>> propertyMsgProducer;
    protected TbQueueProducer<TbJsonQueueMsg<EventMsg>> eventMsgProducer;
    protected TbQueueProducer<TbJsonQueueMsg<ResponseMsg>> serviceResponseMsgProducer;
    protected TbQueueProducer<TbJsonQueueMsg<ResponseMsg>> deviceMsgProducer;
    protected TopicPartitionInfo propertyTopicPartitionInfo;
    protected TopicPartitionInfo eventTopicPartitionInfo;
    protected TopicPartitionInfo responseTopicPartitionInfo;
    protected TopicPartitionInfo deviceMessageTopicPartitionInfo;
    protected TbQueueConsumer<TbJsonQueueMsg<ServiceRequestMsg>> serviceRequestConsumer;

    private final ConcurrentMap<UUID, SessionMetaData> sessions = new ConcurrentHashMap<>();
    private final RedisTemplate<String, String> redisTemplete;

    private volatile boolean stopped = false;

    public DefaultTransportService(SchedulerComponent scheduler, TbTransportQueueFactory transportQueueFactory, RedisTemplate<String, String> redisTemplete) {
        this.scheduler = scheduler;
        this.transportQueueFactory = transportQueueFactory;
        this.redisTemplete = redisTemplete;
    }

    @PostConstruct
    public void init() {
        transportCallbackExecutor = Executors.newWorkStealingPool(20);
        scheduler.scheduleAtFixedRate(this::checkInactivityAndReportActivity, new Random().nextInt((int) sessionReportTimeout), sessionReportTimeout, TimeUnit.MILLISECONDS);
        propertyMsgProducer = transportQueueFactory.createPropertyMsgProducer();
        propertyMsgProducer.init();
        eventMsgProducer = transportQueueFactory.createEventMsgProducer();
        eventMsgProducer.init();
        serviceResponseMsgProducer = transportQueueFactory.createServiceResponseProducer();
        serviceResponseMsgProducer.init();
        deviceMsgProducer = transportQueueFactory.createDeviceMessageTopicProducer();
        deviceMsgProducer.init();
        serviceRequestConsumer = transportQueueFactory.createServiceRequestConsumer();
        serviceRequestConsumer.subscribe();
        //不分区
        propertyTopicPartitionInfo = new TopicPartitionInfo(propertyMsgProducer.getDefaultTopic(), null, true);
        eventTopicPartitionInfo = new TopicPartitionInfo(eventMsgProducer.getDefaultTopic(), null, true);
        responseTopicPartitionInfo = new TopicPartitionInfo(serviceResponseMsgProducer.getDefaultTopic(), null, true);
        deviceMessageTopicPartitionInfo = new TopicPartitionInfo(deviceMsgProducer.getDefaultTopic(), null, true);
        //处理服务请求
        serviceRequestConsumerExecutor = Executors.newSingleThreadExecutor(NamedThreadFactory.forName("service-request-consumer"));
        serviceRequestConsumerExecutor.execute(() -> {
            while (!stopped) {
                try {
                    //轮询通知消息
                    List<TbJsonQueueMsg<ServiceRequestMsg>> records = serviceRequestConsumer.poll(serviceRequestPollDuration);
                    if (records.size() == 0) {
                        continue;
                    }
                    records.forEach(record -> {
                        try {
                            processServiceRequest(record.getValue());
                        } catch (Throwable e) {
                            log.warn("Failed to process the service request.", e);
                        }
                    });
                } catch (Exception e) {
                    if (!stopped) {
                        log.warn("Failed to obtain messages from queue.", e);
                        try {
                            Thread.sleep(serviceRequestPollDuration);
                        } catch (InterruptedException e2) {
                            log.trace("Failed to wait until the server has capacity to handle new requests", e2);
                        }
                    }
                }
            }
        });
    }

    private void processServiceRequest(ServiceRequestMsg requestMsg) {
        SessionMetaData session = getSession(requestMsg.getCollectorId());
        if (session == null) {
            sendErrServiceResponse(requestMsg, ErrorCode.OFFLINE.getCode(), ErrorCode.OFFLINE.getMessage());
            return;
        }
        if (requestMsg.getExpiredTime() < System.currentTimeMillis()) {
            sendErrServiceResponse(requestMsg, ErrorCode.EXPIRED.getCode(), ErrorCode.EXPIRED.getMessage());
            return;
        }
        if (!StringUtils.hasLength(requestMsg.getId())) {
            sendErrServiceResponse(requestMsg, ErrorCode.PARAM_LOST.getCode(), String.format(ErrorCode.PARAM_LOST.getMessage(), "id"));
            return;
        }
        if (!StringUtils.hasLength(requestMsg.getCollectorId())) {
            sendErrServiceResponse(requestMsg, ErrorCode.PARAM_LOST.getCode(), String.format(ErrorCode.PARAM_LOST.getMessage(), "collectorId"));
            return;
        }
        if (!StringUtils.hasLength(requestMsg.getMethod())) {
            sendErrServiceResponse(requestMsg, ErrorCode.PARAM_LOST.getCode(), String.format(ErrorCode.PARAM_LOST.getMessage(), "method"));
            return;
        }
        if (session.getListener() != null) {
            transportCallbackExecutor.submit(()-> {
                session.getListener().onServiceRequest(requestMsg);
            });
        }
    }

    private void sendErrServiceResponse(ServiceRequestMsg requestMsg, int errCode, String message) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setId(requestMsg.getId() == null ? "" : requestMsg.getId());
        responseMsg.setMethod(requestMsg.getMethod() == null ? "" : requestMsg.getMethod());
        responseMsg.setCollectorId(requestMsg.getCollectorId() == null ? "" : requestMsg.getCollectorId());
        responseMsg.setCode(errCode);
        responseMsg.setMessage(message);
        responseMsg.setData(new HashMap<String, String>(0));
        processResponseMsg(null, responseMsg, null);
    }

    private SessionMetaData getSession(String deviceName) {
        SessionMetaData session = null;
        for (UUID uuid : sessions.keySet()) {
            session = sessions.get(uuid);
            if (session.getSessionInfo().getDeviceName().equalsIgnoreCase(deviceName)) {
                return session;
            }
        }
        return null;
    }


    @PreDestroy
    public void destroy() {
        stopped = true;
        if (serviceRequestConsumer != null) {
            serviceRequestConsumer.unsubscribe();
        }
        if (transportCallbackExecutor != null) {
            transportCallbackExecutor.shutdownNow();
        }
        if (serviceRequestConsumerExecutor != null) {
            serviceRequestConsumerExecutor.shutdownNow();
        }
        if (propertyMsgProducer != null) {
            propertyMsgProducer.stop();
        }
        if (eventMsgProducer != null) {
            eventMsgProducer.stop();
        }
        if (serviceResponseMsgProducer != null) {
            serviceResponseMsgProducer.stop();
        }
        if (deviceMsgProducer != null) {
            deviceMsgProducer.stop();
        }
    }

    @Override
    public SessionMetaData registerAsyncSession(TransportProtos.SessionInfoProto sessionInfo, SessionMsgListener listener) {
        SessionMetaData newValue = new SessionMetaData(sessionInfo, TransportProtos.SessionType.ASYNC, listener);
        SessionMetaData oldValue = sessions.putIfAbsent(toSessionId(sessionInfo), newValue);
        return oldValue != null ? oldValue : newValue;
    }

    @Override
    public void process(DeviceTransportType transportType, TransportProtos.ValidateDeviceTokenRequestMsg msg,
                        TransportServiceCallback<ValidateDeviceCredentialsResponse> callback) {
        log.trace("Processing msg: {}", msg);
        if (callback != null) {
            callback.onError(new UnsupportedOperationException("Unsupported"));
        }
    }

    @Override
    public void process(DeviceTransportType transportType, TransportProtos.ValidateBasicMqttCredRequestMsg msg,
                        TransportServiceCallback<ValidateDeviceCredentialsResponse> callback) {
        log.trace("Processing msg: {}", msg);
        transportCallbackExecutor.submit(()-> {
            HashOperations<String, String, String> hashOperations = redisTemplete.opsForHash();
            try {
                if (!StringUtils.hasLength(msg.getClientId())) {
                    if (callback != null) {
                        callback.onError(new AuthenticationException("Client id is empty!"));
                    }
                    return;
                }
                List<String> keyList = new ArrayList<>(3);
                keyList.add("id");
                keyList.add("verificationCode");
                keyList.add("deviceModel");
                keyList.add("userName");
                keyList.add("pluginId");
                List<String> valueList = hashOperations.multiGet("collect_equipment:" + msg.getClientId(), keyList);
                String deviceId = valueList.get(0);
                String verificationCode = valueList.get(1);
                String deviceModel = valueList.get(2);
                String userName =  valueList.get(3);
                String pluginId = valueList.get(4);
                String srcUserName = msg.getUserName();
                String srcPassword = msg.getPassword();
                if (srcUserName == null) {
                    srcUserName = "";
                }
                if (srcPassword == null) {
                    srcPassword = "";
                }
                if (deviceModel == null) {
                    deviceModel = "";
                } else {
                    deviceModel = trimCharacter(deviceModel, '\"');
                }
                if (pluginId == null) {
                    pluginId = "";
                } else {
                    pluginId = trimCharacter(pluginId, '\"');
                }
                if (deviceId == null) {
                    deviceId = "";
                } else {
                    deviceId = trimCharacter(deviceId, '\"');
                }
                if (userName == null) {
                    userName = "";
                } else {
                    userName = trimCharacter(userName, '\"');
                }
                if (verificationCode == null) {
                    verificationCode = "";
                } else {
                    verificationCode = trimCharacter(verificationCode, '\"');
                }
                boolean successful = false;
                if (!StringUtils.hasLength(userName) || userName.equals(srcUserName)) {
                    if (!StringUtils.hasLength(verificationCode) || verificationCode.equals(srcPassword)) {
                        if (StringUtils.hasLength(deviceId) && deviceId.length() == 32) {
                            successful = true;
                        }
                    }
                }
                if (successful) {
                    TransportDeviceInfo transportDeviceInfo = new TransportDeviceInfo();
                    transportDeviceInfo.setDeviceId(deviceId);
                    transportDeviceInfo.setDeviceName(msg.getClientId());
                    transportDeviceInfo.setDeviceModel(deviceModel);
                    transportDeviceInfo.setPluginId(pluginId);
                    checkTransportDeviceInfo(transportDeviceInfo);
                    ValidateDeviceCredentialsResponse response = ValidateDeviceCredentialsResponse.builder()
                            .deviceInfo(transportDeviceInfo)
                            .credentials("")
                            .build();
                    if (callback != null) {
                        callback.onSuccess(response);
                    }
                } else {
                    if (callback != null) {
                        callback.onError(new AuthenticationException("Authentication failed"));
                    }
                }
            } catch (Exception e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }
        });
    }

    @Override
    public void process(DeviceTransportType transportType, TransportProtos.ValidateDeviceX509CertRequestMsg msg, TransportServiceCallback<ValidateDeviceCredentialsResponse> callback) {
        log.trace("Processing msg: {}", msg);
        if (callback != null) {
            callback.onError(new UnsupportedOperationException("Unsupported"));
        }
    }

    @Override
    public void process(TransportProtos.SessionInfoProto sessionInfo, TransportProtos.SessionEventMsg msg, TransportServiceCallback<Void> callback) {
        if (checkLimits(sessionInfo, msg, callback)) {
            reportActivityInternal(sessionInfo);
            if (callback != null) {
                callback.onSuccess(null);
            }
        }
    }

    /**
     * 处理属性数据，最终发到kafka
     * @param sessionInfo 会话信息
     * @param msg 属性数据
     * @param callback 回调
     */
    @Override
    public void processPropertyMsg(TransportProtos.SessionInfoProto sessionInfo, PropertyMsg msg, TransportServiceCallback<Void> callback) {
        if (sessionInfo != null) {
            reportActivityInternal(sessionInfo);
        }
        int dataPoints = msg.getParams().size();
        List<TbJsonQueueMsg<PropertyDataEntity>> tbJsonQueueMsgList = new ArrayList<>(dataPoints);
        for (PropertyEntry entry : msg.getParams()) {
            PropertyDataEntity propertyDataEntity = PropertyDataEntity.builder()
                    .collectorId(msg.getCollectorId())
                    .ts(entry.getTs())
                    .tagId(entry.getPropId())
                    .tagVal(entry.getPropValue())
                    .build();
            tbJsonQueueMsgList.add(new TbJsonQueueMsg<>(UUID.randomUUID(), propertyDataEntity));
        }
        transportCallbackExecutor.submit(()-> propertyMsgProducer.send(propertyTopicPartitionInfo, tbJsonQueueMsgList, new TransportTbQueueCallback(callback)));
    }

    /**
     * 处理事件消息,最终发到kafka
     * @param sessionInfo 会话信息
     * @param msg 事件消息
     * @param callback 回调
     */
    @Override
    public void processEventMsg(TransportProtos.SessionInfoProto sessionInfo, EventMsg msg, TransportServiceCallback<Void> callback) {
        if (sessionInfo != null) {
            reportActivityInternal(sessionInfo);
        }
        transportCallbackExecutor.submit(()->eventMsgProducer.send(eventTopicPartitionInfo, new TbJsonQueueMsg<>(UUID.randomUUID(), msg), new TransportTbQueueCallback(callback)));
    }

    /**
     * 处理请求响应,最终发到kafka
     * @param sessionInfo 会话信息
     * @param msg 请求响应
     * @param callback 回调
     */
    @Override
    public void processResponseMsg(TransportProtos.SessionInfoProto sessionInfo, ResponseMsg msg, TransportServiceCallback<Void> callback) {
        if (sessionInfo != null) {
            reportActivityInternal(sessionInfo);
        }
        transportCallbackExecutor.submit(()->serviceResponseMsgProducer.send(responseTopicPartitionInfo, new TbJsonQueueMsg<>(UUID.randomUUID(), msg), new TransportTbQueueCallback(callback)));
    }

    /**
     * 处理设备消息(设备主动上行),最终发到kafka
     * @param sessionInfo 会话信息
     * @param msg 设备消息
     * @param callback 回调
     */
    @Override
    public void processDeviceMsg(TransportProtos.SessionInfoProto sessionInfo, ResponseMsg msg, TransportServiceCallback<Void> callback) {
        if (sessionInfo != null) {
            reportActivityInternal(sessionInfo);
        }
        transportCallbackExecutor.submit(()->deviceMsgProducer.send(deviceMessageTopicPartitionInfo, new TbJsonQueueMsg<>(UUID.randomUUID(), msg), new TransportTbQueueCallback(callback)));
    }

    /**
     * 获取设备类型码
     *
     * @param uid 设备ID
     * @return 设备类型码
     */
    @Override
    public Integer getDeviceTypeCode(String uid) {
        String key = String.join(":", "deviceRF", uid);
        Object obj = redisTemplete.opsForHash().get(key, "deviceType");
        if (obj == null) {
            return null;
        }
        String value = obj.toString().replace("\"", "");
        if (StringUtils.hasLength(value)) {
            return Integer.parseInt(value);
        }
        return null;
    }

    @Override
    public void reportActivity(TransportProtos.SessionInfoProto sessionInfo) {
        reportActivityInternal(sessionInfo);
    }

    private SessionMetaData reportActivityInternal(TransportProtos.SessionInfoProto sessionInfo) {
        UUID sessionId = toSessionId(sessionInfo);
        SessionMetaData sessionMetaData = sessions.get(sessionId);
        if (sessionMetaData != null) {
            sessionMetaData.updateLastActivityTime();
        }
        return sessionMetaData;
    }

    private void checkInactivityAndReportActivity() {
        long expTime = System.currentTimeMillis() - sessionInactivityTimeout;
        sessions.forEach((uuid, sessionMetaData) -> {
            long lastActivityTime = sessionMetaData.getLastActivityTime();
            TransportProtos.SessionInfoProto sessionInfo = sessionMetaData.getSessionInfo();
            if (sessionInfo.getGwSessionIdMSB() != 0 &&
                    sessionInfo.getGwSessionIdLSB() != 0) {
                SessionMetaData gwMetaData = sessions.get(new UUID(sessionInfo.getGwSessionIdMSB(), sessionInfo.getGwSessionIdLSB()));
                if (gwMetaData != null && gwMetaData.isOverwriteActivityTime()) {
                    lastActivityTime = Math.max(gwMetaData.getLastActivityTime(), lastActivityTime);
                }
            }
            if (lastActivityTime < expTime) {
                if (log.isDebugEnabled()) {
                    log.debug("[{}] Session has expired due to last activity time: {}", toSessionId(sessionInfo), lastActivityTime);
                }
                process(sessionInfo, getSessionEventMsg(TransportProtos.SessionEvent.CLOSED), null);
                sessions.remove(uuid);
                sessionMetaData.getListener().onRemoteSessionCloseCommand(TransportProtos.SessionCloseNotificationProto.getDefaultInstance());
            } else {
                if (lastActivityTime > sessionMetaData.getLastReportedActivityTime()) {
                    //TODO 上报状态到消息队列，暂时未实现
                    sessionMetaData.setLastReportedActivityTime(lastActivityTime);
                }
            }
        });
    }

    @Override
    public SessionMetaData registerSyncSession(TransportProtos.SessionInfoProto sessionInfo, SessionMsgListener listener, long timeout) {
        SessionMetaData currentSession = new SessionMetaData(sessionInfo, TransportProtos.SessionType.SYNC, listener);
        sessions.putIfAbsent(toSessionId(sessionInfo), currentSession);

        ScheduledFuture executorFuture = scheduler.schedule(() -> {
            listener.onRemoteSessionCloseCommand(TransportProtos.SessionCloseNotificationProto.getDefaultInstance());
            deregisterSession(sessionInfo);
        }, timeout, TimeUnit.MILLISECONDS);

        currentSession.setScheduledFuture(executorFuture);
        return currentSession;
    }

    @Override
    public void deregisterSession(TransportProtos.SessionInfoProto sessionInfo) {
        SessionMetaData currentSession = sessions.get(toSessionId(sessionInfo));
        if (currentSession != null && currentSession.hasScheduledFuture()) {
            log.debug("Stopping scheduler to avoid resending response if request has been ack.");
            currentSession.getScheduledFuture().cancel(false);
        }
        sessions.remove(toSessionId(sessionInfo));
    }

    private boolean checkLimits(TransportProtos.SessionInfoProto sessionInfo, Object msg, TransportServiceCallback<Void> callback) {
        return checkLimits(sessionInfo, msg, callback, 0);
    }

    private boolean checkLimits(TransportProtos.SessionInfoProto sessionInfo, Object msg, TransportServiceCallback<Void> callback, int dataPoints) {
        if (log.isTraceEnabled()) {
            log.trace("[{}] Processing msg: {}", toSessionId(sessionInfo), msg);
        }
        return true;
    }

    protected UUID toSessionId(TransportProtos.SessionInfoProto sessionInfo) {
        return new UUID(sessionInfo.getSessionIdMSB(), sessionInfo.getSessionIdLSB());
    }

    protected UUID getRoutingKey(TransportProtos.SessionInfoProto sessionInfo) {
        return new UUID(sessionInfo.getDeviceIdMSB(), sessionInfo.getDeviceIdLSB());
    }

    protected String getDeviceId(TransportProtos.SessionInfoProto sessionInfo) {
        return new UUID(sessionInfo.getDeviceIdMSB(), sessionInfo.getDeviceIdLSB()).toString();
    }

    public static TransportProtos.SessionEventMsg getSessionEventMsg(TransportProtos.SessionEvent event) {
        return TransportProtos.SessionEventMsg.newBuilder()
                .setSessionType(TransportProtos.SessionType.ASYNC)
                .setEvent(event).build();
    }

    private void checkTransportDeviceInfo(TransportDeviceInfo transportDeviceInfo) {
        if (transportDeviceInfo == null) {
            return;
        }
        String deviceId = transportDeviceInfo.getDeviceId();
        String sb = deviceId.substring(0, 8) + "-" + deviceId.substring(8, 12) + "-" + deviceId.substring(12, 16) + "-" +
                deviceId.substring(16, 20) + "-" + deviceId.substring(20, 32);
        transportDeviceInfo.setDeviceId(sb);
        if (StringUtils.hasLength(transportDeviceInfo.getDeviceName())) {
            if (transportDeviceInfo.getDeviceName().toLowerCase().startsWith("gateway")) {
                transportDeviceInfo.setExtendInfo("{\"gateway\":true,\"overwriteActivityTime\":false,\"description\":\"\"}");
            }
        }
    }

    /**
     * 去除字符串首尾的指定字符
     * @param str 原字符串
     * @param c 待去除的字符
     * @return 去除后的字符串
     */
    private String trimCharacter(String str, char c) {
        String dest = str;
        dest = StringUtils.trimLeadingCharacter(dest, c);
        dest = StringUtils.trimTrailingCharacter(dest, c);

        return dest;
    }

    private class TransportTbQueueCallback implements TbQueueCallback {
        private final TransportServiceCallback<Void> callback;

        private TransportTbQueueCallback(TransportServiceCallback<Void> callback) {
            this.callback = callback;
        }

        @Override
        public void onSuccess(TbQueueMsgMetadata metadata) {
            DefaultTransportService.this.transportCallbackExecutor.submit(() -> callback.onSuccess(null));
        }

        @Override
        public void onFailure(Throwable t) {
            DefaultTransportService.this.transportCallbackExecutor.submit(() -> callback.onError(t));
        }
    }
}
