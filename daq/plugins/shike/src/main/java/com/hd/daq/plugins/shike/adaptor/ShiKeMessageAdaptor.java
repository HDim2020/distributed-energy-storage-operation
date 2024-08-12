package com.hd.daq.plugins.shike.adaptor;

import com.google.gson.Gson;
import com.hd.daq.mqtt.session.MqttDeviceAwareSessionContext;
import com.hd.daq.plugins.shike.entity.ShiKeSessionExtendInfo;
import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.HeartBeatMessage;
import com.hd.daq.plugins.shike.iot.ShiKeMessage;
import com.hd.daq.plugins.shike.iot.hex.*;
import com.hd.daq.plugins.shike.util.UuidUtil;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.transportapi.data.thing.PropertyEntry;
import com.hd.daq.transportapi.data.thing.PropertyMsg;
import com.hd.daq.transportapi.data.thing.ResponseMsg;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息适配器，用于时刻消息实体对象与队列消息实体对象之间的相互转换
 *
 * @author ymm
 */
@Slf4j
@Component
public class ShiKeMessageAdaptor {
    private static final Gson GSON = new Gson();

    /**
     * 转换成属性消息
     *
     * @param rfData      RfData实体对象
     * @param collectorId 网关ID
     * @return 属性消息实体对象
     */
    public PropertyMsg convertToProperty(RfData rfData, String collectorId) {
        return PropertyMessageHandler.convertToProperty(rfData, collectorId);
    }

    /**
     * 转换心跳包实体对象为队列响应消息实体对象
     *
     * @param msg 心跳包实体对象
     * @return 队列响应消息实体对象
     */
    public ResponseMsg convertHeartBeatToResponse(ShiKeMessage msg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setId(UuidUtil.newId());
        responseMsg.setCollectorId(msg.getHeader().getCollectorId());
        responseMsg.setCode(ErrorCode.SUCCESS.getCode());
        responseMsg.setMessage(ErrorCode.SUCCESS.getMessage());
        responseMsg.setTimeStamp(System.currentTimeMillis());
        HeartBeatMessage heartBeatMessage = (HeartBeatMessage) msg.getData();
        HeartBeatData heartBeatData = HeartBeatData.from(heartBeatMessage);
        responseMsg.setMethod(heartBeatData.getMethodName());
        responseMsg.setData(heartBeatData);

        return responseMsg;
    }

    /**
     * RF信号转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   RF信号数据实体对象
     * @return PropertyEntry实体列表
     */
    private List<PropertyEntry> getPropertyEntryList(String deviceId, RfSignal entity) {
        List<PropertyEntry> entryList = new ArrayList<>(4);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "bluetoothSignal")
                .propValue(entity.isBleSignal() ? "1" : "0")
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "multipleHopsCount")
                .propValue(Integer.toString(entity.getMultipleHopsCount()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "snr")
                .propValue(Integer.toString(entity.getSnr()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "rssi")
                .propValue(Long.toString(entity.getRssi()))
                .build());

        return entryList;
    }

    /**
     * 转换RF信号实体对象为队列响应消息实体对象
     *
     * @param collectorId 采集器ID
     * @param rfSignal    RF信号实体对象
     * @param uid         设备ID
     * @return 队列响应消息实体对象
     */
    public PropertyMsg convertRfSignalToProperty(String collectorId, RfSignal rfSignal, String uid) {
        List<PropertyEntry> entryList = getPropertyEntryList(uid, rfSignal);
        PropertyMsg propertyMsg = new PropertyMsg();
        propertyMsg.setCollectorId(collectorId);
        propertyMsg.setParams(entryList);

        return propertyMsg;
    }

    /**
     * 将RfData消息转换成队列响应消息
     *
     * @param collectorId 采集器ID
     * @param rfData      RfData实体对象
     * @return 响应消息实体对象
     */
    public ResponseMsg convertRfDataToResponse(String collectorId, RfData rfData) {
        return ResponseMessageHandler.convertRfDataToResponse(collectorId, rfData);
    }

    /**
     * 根据队列请求消息构造mqtt发布消息
     *
     * @param ctx 设备会话上下文
     * @param msg 队列请求消息
     * @return mqtt发布消息
     */
    public MqttPublishMessage toMqttPublishMessage(MqttDeviceAwareSessionContext ctx, ServiceRequestMsg msg) {
        ShiKeSessionExtendInfo extendInfo = (ShiKeSessionExtendInfo) ctx.getDeviceInfo().getExtendInfo();
        MethodType methodType = MethodType.nameFor(msg.getMethod());
        if (methodType == null) {
            log.info("未知的方法名称{}.", msg.getMethod());
            return null;
        }
        int sequenceNumber = 1;
        int commFlag = 1;
        if (extendInfo != null) {
            sequenceNumber = extendInfo.nextSequenceNumber();
            commFlag = extendInfo.nextCommunicationLabel();
        }
        String topic = getServerToDeviceTopic(ctx.getDeviceInfo().getDeviceModel(), msg.getCollectorId());
        String strParams = GSON.toJson(msg.getParams());
        IServerToDeviceMessage toDeviceMessage = ServerMessageHandler.toServerToDeviceMessage(strParams, methodType);
        if (toDeviceMessage == null) {
            return null;
        }
        ShiKeMessage shiKeMessage = ShiKeMessage.createHexTypeShiKeMessage(sequenceNumber, commFlag,
                msg.getCollectorId(), toDeviceMessage.getUid(), toDeviceMessage.to());
        if (shiKeMessage == null) {
            return null;
        }
        try {
            byte[] bytes = shiKeMessage.encode();
            return createMqttPublishMsg(ctx, topic, bytes);
        } catch (EncodeException e) {
            log.debug("{}", e.getCause().getMessage());
        }
        return null;
    }


    /**
     * 创建mqtt发布消息实体对象
     *
     * @param ctx     设备会话上下文
     * @param topic   发布主题
     * @param message 带发布消息
     * @return mqtt发布消息实体对象
     */
    public MqttPublishMessage createMqttPublishMsg(MqttDeviceAwareSessionContext ctx, String topic, byte[] message) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(MqttMessageType.PUBLISH, false, ctx.getQoSForTopic(topic), false, 0);
        MqttPublishVariableHeader header = new MqttPublishVariableHeader(topic, ctx.nextMsgId());
        ByteBuf payload = Unpooled.buffer();
        payload.writeBytes(message);
        return new MqttPublishMessage(mqttFixedHeader, header, payload);
    }

    /**
     * 获得服务器下行主题
     *
     * @param model       网关型号
     * @param collectorId 网关ID
     * @return 服务器下行主题
     */
    public String getServerToDeviceTopic(String model, String collectorId) {
        return String.join("/", "server", model, collectorId);
    }

    /**
     * 判断是否是属性消息
     *
     * @param rfData RfData实体
     * @return 是否属性消息
     */
    public boolean isPropertyMessage(RfData rfData) {
        int storageType = rfData.getData().getMessageStorageType();
        return (storageType & IInformationElement.PROPERTY_MSG) > 0;
    }

    /**
     * 判断是否是设备消息
     *
     * @param rfData RfData实体
     * @return 是否设备消息
     */
    public boolean isDeviceMessage(RfData rfData) {
        int storageType = rfData.getData().getMessageStorageType();
        return (storageType & IInformationElement.DEVICE_MSG) > 0;
    }

    /**
     * 判断是否是服务消息
     *
     * @param rfData RfData实体
     * @return 是否服务消息
     */
    public boolean isServiceMessage(RfData rfData) {
        int storageType = rfData.getData().getMessageStorageType();
        return (storageType & IInformationElement.SERVICE_MSG) > 0;
    }
}
