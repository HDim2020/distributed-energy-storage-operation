package com.hd.daq.plugins.cps.service;

import com.gitee.starblues.annotation.Extract;
import com.hd.daq.mqtt.service.ProtocolPlugin;
import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.plugins.cps.adaptor.CpsMessageAdaptor;
import com.hd.daq.transportapi.DataStorageService;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.transportapi.TransportServiceCallback;
import com.hd.daq.transportapi.data.thing.PropertyMsg;
import com.hd.daq.transportapi.data.thing.ResponseMsg;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author ymm
 */
@Slf4j
@Extract(bus = "protocol", scene = "mqtt")
public class CpsProtocol implements ProtocolPlugin {
    private static final String DATA_TOPIC_PREFIX = "data";
    private static final String CMD_TOPIC_PREFIX = "cmd";
    private final CpsMessageAdaptor adaptor;

    public CpsProtocol(CpsMessageAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    @Override
    public void processDevicePublishMessage(DeviceSessionCtx ctx, MqttPublishMessage msg, DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        //topic格式: data/{渠道}/{collectorId}
        String topic = msg.variableHeader().topicName();
        String collectorId = ctx.getDeviceInfo().getDeviceName();
        String[] items = topic.split("/");
        if (items.length != 3) {
            if (callback != null) {
                callback.onError(new Exception("Invalid topic."));
            }
            return;
        }
        try {
            if (DATA_TOPIC_PREFIX.equalsIgnoreCase(items[0]) && collectorId.equalsIgnoreCase(items[2])) {
                //设置渠道
                Object extendInfoObj = ctx.getDeviceInfo().getExtendInfo();
                if (extendInfoObj == null || !extendInfoObj.equals(items[1])) {
                    ctx.getDeviceInfo().setExtendInfo(items[1]);
                }
                PropertyMsg propertyMsg = adaptor.convertToProperty(ctx, msg);
                if (propertyMsg == null) {
                    if (callback != null) {
                        callback.onError(new Exception("Parse data failed."));
                    }
                    return;
                }
                dataStorageService.processPropertyMsg(ctx.getSessionInfo(), propertyMsg, getStorageCallback(callback));
            } else {
                if (callback != null) {
                    callback.onError(new Exception("Invalid topic."));
                }
            }
        } catch (Throwable e) {
            log.debug("{}", e.getMessage());
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    @Override
    public void processServiceRequest(DeviceSessionCtx ctx, ServiceRequestMsg msg,
                                      DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        try {
            MqttPublishMessage mqttPublishMessage = adaptor.toMqttPublishMessage(ctx, msg);
            if (mqttPublishMessage != null) {
                ctx.getChannel().writeAndFlush(mqttPublishMessage);
            }
            if (callback != null) {
                callback.onSuccess(null);
            }
        } catch (Throwable e) {
            sendErrorServiceResponse(ctx, msg, dataStorageService, ErrorCode.FAIL.getCode(), e.getMessage());
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    private <T> TransportServiceCallback<Void> getStorageCallback(TransportServiceCallback<Void> callback) {
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

    private void sendErrorServiceResponse(DeviceSessionCtx ctx, ServiceRequestMsg requestMsg,
                                          DataStorageService dataStorageService, int errCode, String message) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setId(requestMsg.getId() == null ? "" : requestMsg.getId());
        responseMsg.setMethod(requestMsg.getMethod() == null ? "" : requestMsg.getMethod());
        responseMsg.setCollectorId(requestMsg.getCollectorId() == null ? "" : requestMsg.getCollectorId());
        responseMsg.setCode(errCode);
        responseMsg.setMessage(message);
        responseMsg.setData(new HashMap<String, String>(0));
        dataStorageService.processResponseMsg(ctx.getSessionInfo(), responseMsg, null);
    }
}
