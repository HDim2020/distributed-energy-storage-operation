package com.hd.daq.plugins.rbscb.service;

import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.plugins.rbscb.data.RbIotControlType;
import com.hd.daq.plugins.rbscb.data.RbIotInformationObject;
import com.hd.daq.plugins.rbscb.data.RbIotMessage;
import com.hd.daq.plugins.rbscb.data.RbIotMsgType;
import com.hd.daq.plugins.rbscb.data.ie.IeControlBroker;
import com.hd.daq.plugins.rbscb.data.ie.RbIotInformationElement;
import com.hd.daq.plugins.rbscb.exception.ParameterException;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务请求工厂类
 * @author ymm
 */
public class ServiceRequestFactory {

    private static MqttPublishMessage createMqttPublishMsg(DeviceSessionCtx ctx, String topic, RbIotMessage message) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(MqttMessageType.PUBLISH, false, ctx.getQoSForTopic(topic), false, 0);
        MqttPublishVariableHeader header = new MqttPublishVariableHeader(topic, ctx.nextMsgId());
        ByteBuf payload = Unpooled.buffer();
        payload.writeBytes(message.encode());
        return new MqttPublishMessage(mqttFixedHeader, header, payload);
    }

    public static MqttPublishMessage toMqttPublishMessage(DeviceSessionCtx ctx, RbIotMsgType msgType, ServiceRequestMsg msg) throws ParameterException {
        RbIotMessage rbIotMessage = null;
        switch (msgType) {
            case SERVER_QUERY_FUNC_ON_OFF_SETTING:
                break;
            case SERVER_SET_BROKER_FUNC_ON_OFF:
                rbIotMessage = setBrokerOnOff(msgType, msg.getParams());
                break;
            case SERVER_REMOTE_CONTROL_BROKER:
                rbIotMessage = controlBroker(msgType, msg.getParams());
                break;
            default:
                break;
        }
        if (rbIotMessage != null) {
            String topic = "RBIOT/SERVERtoLINK/" + ctx.getDeviceInfo().getDeviceName();
            return createMqttPublishMsg(ctx, topic, rbIotMessage);
        }
        return null;
    }

    private static RbIotMessage setBrokerOnOff(RbIotMsgType msgType, Object params) throws ParameterException {
        return null;
    }

    /**
     * “params”: {
     *  "devId": "1",//设备ID，可选项：1-32(断路器ID)，gateway(网关),ignore(无意义，应忽略),all(所有断路器)
     *  "data": {
     *      "action": "on" // on--合闸 off-分闸 clearElec--清除电量 clearAlarm--清除报警 testLeak--测试漏电 releaseLock--解除漏电锁定
     *  } //数据，具体格式与method有关。
     *  }
     * @param params
     * @return
     * @throws ParameterException
     */
    private static RbIotMessage controlBroker(RbIotMsgType msgType, Object params) throws ParameterException {
        try {
            Map<String, Object> map = validateMap(params);
            Object objDevId = map.get("devId");
            if (objDevId == null) {
                throw new ParameterException("lost devId field!");
            }
            Object objData = map.get("data");
            if (objData == null) {
                throw new ParameterException("lost data field!");
            }
            Map<String, Object> dataMap = validateMap(objData);
            Object objAction = dataMap.get("action");
            if (objAction == null) {
                throw new ParameterException("lost data.action field!");
            }
            RbIotMessage iotMessage = new RbIotMessage();
            iotMessage.setId(getDevId(objDevId.toString()));
            iotMessage.setControl(RbIotControlType.SERVER_TO_LINK.getId());
            iotMessage.setType(msgType.getId());
            RbIotInformationElement element = IeControlBroker.builder().action(getActionCode(objAction.toString())).build();
            iotMessage.setInformationObject(new RbIotInformationObject(element));
            return iotMessage;
        } catch (Throwable e) {
            throw new ParameterException(e.getMessage());
        }
    }

    private static Map<String, Object> validateMap(Object obj) throws ParameterException {
        if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            Map<String, Object> objectMap = new HashMap<>(map.size());
            map.forEach((k, v)->{
                objectMap.put(k.toString(), v);
            });
            return objectMap;
        }
        throw new ParameterException("params is not a map!");
    }

    /**
     * 获取设备地址码
     * @param devId 设备地址名称
     * @return 地址码
     */
    private static int getDevId(String devId) {
        if ("gateway".equalsIgnoreCase(devId)) {
            return 0xAA;
        }
        if ("ignore".equalsIgnoreCase(devId)) {
            return 0xAF;
        }
        if ("all".equalsIgnoreCase(devId)) {
            return 0xFF;
        }
        return Integer.parseInt(devId);
    }

    /**
     * 获取控制动作代码值
     * @param action 动作名称
     * @return 代码值
     * @throws ParameterException 参数异常
     */
    private static int getActionCode(String action) throws ParameterException {
        if ("on".equalsIgnoreCase(action)) {
            return 0x55AA;
        }
        if ("off".equalsIgnoreCase(action)) {
            return 0x55CC;
        }
        if ("clearElec".equalsIgnoreCase(action)) {
            return 0x55DB;
        }
        if ("clearAlarm".equalsIgnoreCase(action)) {
            return 0x5555;
        }
        if ("testLeak".equalsIgnoreCase(action)) {
            return 0x5566;
        }
        if ("releaseLock".equalsIgnoreCase(action)) {
            return 0x5588;
        }
        throw new ParameterException("invalid data.action!");
    }
}
