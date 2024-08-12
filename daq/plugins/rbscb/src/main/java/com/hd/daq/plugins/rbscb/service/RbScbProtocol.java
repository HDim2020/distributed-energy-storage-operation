package com.hd.daq.plugins.rbscb.service;

import com.gitee.starblues.annotation.Extract;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.mqtt.service.ProtocolPlugin;
import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.plugins.rbscb.data.RbIotMessage;
import com.hd.daq.plugins.rbscb.data.RbIotMsgType;
import com.hd.daq.plugins.rbscb.data.ServiceRequestMetaData;
import com.hd.daq.plugins.rbscb.exception.ParameterException;
import com.hd.daq.transportapi.DataStorageService;
import com.hd.daq.transportapi.TransportServiceCallback;
import com.hd.daq.transportapi.data.thing.*;
import com.hd.daq.transportapi.util.NamedThreadFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * 瑞邦智能断路器插件
 * 仅有一个实例，需要考虑多个同型号设备的情况
 * @author ymm
 */
@Slf4j
@Extract(bus = "protocol", scene = "mqtt")
public class RbScbProtocol implements ProtocolPlugin {
    private ConcurrentMap<String, ServiceRequestMetaData> pendingServiceRequests = new ConcurrentHashMap<>();
    private ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60,
            TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), NamedThreadFactory.forName("rbscb"));
    private volatile boolean busy = false;

    /**
     * 启动检测服务请求超时任务
     */
    public void startCheckRequestTimeoutTask() {
        // 只有在空闲的时候才会启动任务，保证在有请求的时候才会启动检测任务，避免资源浪费
        if (!busy) {
            executorService.execute(this::processTimeoutRequest);
        }
    }

    @PreDestroy
    public void shutdown() {
        executorService.shutdown();
    }

    /**
     * 处理过期的服务请求
     */
    private void processTimeoutRequest() {
        busy = true;
        try {
            while (pendingServiceRequests.size() > 0) {
                Iterator<Map.Entry<String, ServiceRequestMetaData>> it = pendingServiceRequests.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, ServiceRequestMetaData> entry = it.next();
                    ServiceRequestMsg requestMsg = entry.getValue().getServiceRequestMsg();
                    if (requestMsg.getExpiredTime() < System.currentTimeMillis()) {
                        it.remove();
                        try {
                            sendErrorServiceResponse(entry.getValue(), ErrorCode.TIMEOUT.getCode(), ErrorCode.TIMEOUT.getMessage());
                        } catch (Exception ignored) {
                        }
                    }
                }
                if (pendingServiceRequests.size() == 0) {
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            log.debug("exception:", e);
        }
        busy = false;
    }

    /**
     * 处理网关发来的IOT消息
     * @param msg IOT消息
     * @return 物消息
     */
    private ThingMsg handleIotMessage(RbIotMessage msg) {
        RbIotMsgType msgType = RbIotMsgType.typeFor(msg.getType());
        if (msgType == null) {
            return null;
        }
        ThingMsg thingMsg = null;
        switch (msgType) {
            case SERVER_REQUEST_TELEMETRY_DATA:
                thingMsg = RbIotConverter.convertToPropertyData(msg);
                break;
            case SERVER_REMOTE_CONTROL_BROKER:
                thingMsg = RbIotConverter.convertToServiceResponse(msg);
                break;
            default:
                break;
        }
        return thingMsg;
    }

    /**
     * params域包括devId、funcCode、data
     * 例如：
     * “params”: {
     *     "devId": "1",//设备ID，可选项：1-32(断路器ID)，gateway(网关),ignore(无意义，应忽略),all(所有断路器)
     *     "data": {} //数据，具体格式与method有关。
     * }
     * @param ctx 设备会话上下文
     * @param msg 平台侧消息
     * @return
     */
    @Override
    public void processDevicePublishMessage(DeviceSessionCtx ctx, MqttPublishMessage msg, DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        ByteBuf byteBuf = msg.payload();
        if (byteBuf.readableBytes() == 0) {
            log.debug("read 0 bytes.");
            onError(callback, "read 0 bytes.");
            return;
        }
        byte[] bytMsg = ByteBufUtil.getBytes(byteBuf);
        RbIotMessage rbIotMessage = RbIotMessage.decode(bytMsg);
        if (rbIotMessage == null) {
            log.debug("RbIotMessage decode failed.");
            onError(callback, "RbIotMessage decode failed.");
            return;
        }
        ThingMsg thingMsg = handleIotMessage(rbIotMessage);
        if (thingMsg == null) {
            log.debug("Convert to thing msg failed.");
            onError(callback, "Convert to thing msg failed.");
            return;
        }
        thingMsg.setCollectorId(ctx.getDeviceInfo().getDeviceName());
        if (thingMsg.getFunctionType() == FunctionType.PROPERTY) {
            dataStorageService.processPropertyMsg(ctx.getSessionInfo(), (PropertyMsg)thingMsg, getPubAckCallback(callback));
        } else if(thingMsg.getFunctionType() == FunctionType.EVENT) {
            dataStorageService.processEventMsg(ctx.getSessionInfo(), (EventMsg)thingMsg, getPubAckCallback(callback));
        } else if(thingMsg.getFunctionType() == FunctionType.SERVICE) {
            ResponseMsg responseMsg = (ResponseMsg)thingMsg;
            //响应去匹配请求，把响应ID设置成请求ID
            ServiceRequestMetaData metaData = pendingServiceRequests.remove(createKey(ctx.getDeviceInfo().getDeviceName(), rbIotMessage.getType()));
            if (metaData != null) {
                responseMsg.setId(metaData.getServiceRequestMsg().getId());
            } else {
                responseMsg.setId(UUID.randomUUID().toString().replace("-", ""));
            }
            dataStorageService.processResponseMsg(ctx.getSessionInfo(), responseMsg, getPubAckCallback(callback));
        }
    }

    @Override
    public void processServiceRequest(DeviceSessionCtx ctx, ServiceRequestMsg msg, DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        ServiceRequestMetaData metaData = ServiceRequestMetaData.builder().serviceRequestMsg(msg)
                .deviceSessionCtx(ctx).dataStorageService(dataStorageService).build();
        String errMsg;
        RbIotMsgType rbIotMsgType = RbIotMsgType.methodFor(msg.getMethod());
        if (rbIotMsgType == null) {
            errMsg = String.format(ErrorCode.PARAM_INVALID.getMessage(), "method", msg.getMethod());
            sendErrorServiceResponse(metaData, ErrorCode.PARAM_INVALID.getCode(), errMsg);
            onError(callback, errMsg);
            return;
        }
        //判断同类型的请求是否已经存在
        String key = createKey(ctx.getDeviceInfo().getDeviceName(), rbIotMsgType.getId());
        ServiceRequestMetaData preMeta = pendingServiceRequests.get(key);
        if (preMeta != null) {
            if (preMeta.getServiceRequestMsg().getExpiredTime() < System.currentTimeMillis()) {
                //消息已经过期
                pendingServiceRequests.remove(key);
            } else {
                errMsg = "Another message is executing";
                sendErrorServiceResponse(metaData, ErrorCode.FAIL.getCode(), errMsg);
                onError(callback, errMsg);
                return;
            }
        }
        try {
            MqttMessage mqttMessage = ServiceRequestFactory.toMqttPublishMessage(ctx, rbIotMsgType, msg);
            if (mqttMessage == null) {
                errMsg = "Unsupported request";
                sendErrorServiceResponse(metaData, ErrorCode.FAIL.getCode(), errMsg);
                onError(callback, errMsg);
                return;
            }
            ctx.getChannel().writeAndFlush(mqttMessage);
            pendingServiceRequests.put(key, metaData);
            startCheckRequestTimeoutTask();
            if (callback != null) {
                callback.onSuccess(null);
            }
        } catch (ParameterException e) {
            onError(callback, e.getMessage());
        }
    }

    private <T> TransportServiceCallback<Void> getPubAckCallback(TransportServiceCallback<Void> callback) {
        return new TransportServiceCallback<Void>() {
            @Override
            public void onSuccess(Void dummy) {
                //TODO 做其他的业务，比如要求回复，则在这里进行发布回复消息
                if (callback != null) {
                    callback.onSuccess(dummy);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }
        };
    }

    private void onError(TransportServiceCallback<Void> callback, String errMsg) {
        if (callback != null) {
            callback.onError(new ParameterException(errMsg));
        }
    }

    private void sendErrorServiceResponse(ServiceRequestMetaData requestMetaData, int errCode, String message) {
        ResponseMsg responseMsg = new ResponseMsg();
        ServiceRequestMsg requestMsg = requestMetaData.getServiceRequestMsg();
        responseMsg.setId(requestMsg.getId() == null ? "" : requestMsg.getId());
        responseMsg.setMethod(requestMsg.getMethod() == null ? "" : requestMsg.getMethod());
        responseMsg.setCollectorId(requestMsg.getCollectorId() == null ? "" : requestMsg.getCollectorId());
        responseMsg.setCode(errCode);
        responseMsg.setMessage(message);
        responseMsg.setData(new HashMap<String, String>(0));
        requestMetaData.getDataStorageService().processResponseMsg(requestMetaData.getDeviceSessionCtx().getSessionInfo(), responseMsg, null);
    }

    private String createKey(String collectorId, int id) {
        return collectorId + ":" + id;
    }
}
