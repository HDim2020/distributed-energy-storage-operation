package com.hd.daq.plugins.hdlink.service;

import com.google.gson.Gson;
import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.plugins.hdlink.data.HdServiceRequest;
import com.hd.daq.plugins.hdlink.data.MqttTopics;
import com.hd.daq.plugins.hdlink.exception.ParameterException;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 服务请求工厂类
 * @author ymm
 */
public class ServiceRequestFactory {

    private static final String SET_PROPERTY_METHOD = "setProperty";
    private static final String GET_PROPERTY_METHOD = "getProperty";
    private static final String PROPERTY = "property";
    private static final Gson GSON = new Gson();

    private static MqttPublishMessage createMqttPublishMsg(DeviceSessionCtx ctx, String topic, String message) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(MqttMessageType.PUBLISH, false, ctx.getQoSForTopic(topic), false, 0);
        MqttPublishVariableHeader header = new MqttPublishVariableHeader(topic, ctx.nextMsgId());
        ByteBuf payload = Unpooled.buffer();
        payload.writeBytes(message.getBytes(StandardCharsets.UTF_8));
        return new MqttPublishMessage(mqttFixedHeader, header, payload);
    }

    public static MqttPublishMessage toMqttPublishMessage(DeviceSessionCtx ctx, ServiceRequestMsg msg) throws ParameterException {
        HdServiceRequest request = null;
        if (SET_PROPERTY_METHOD.equalsIgnoreCase(msg.getMethod())) {
            request = setProperty(msg);
        } else if (GET_PROPERTY_METHOD.equalsIgnoreCase(msg.getMethod())) {
            request = getProperty(msg);
        } else {
            throw new ParameterException(String.format(ErrorCode.PARAM_INVALID.getMessage(), "method", msg.getMethod()));
        }
        if (request != null) {
            String topic = MqttTopics.getServiceRequestTopic(ctx.getDeviceInfo().getDeviceName());
            return createMqttPublishMsg(ctx, topic, GSON.toJson(request));
        }
        return null;
    }

    private static HdServiceRequest getProperty(ServiceRequestMsg msg) throws ParameterException {
        try {
            Map<String, String> map = validateMap(msg.getParams());
            String property = map.get(PROPERTY);
            if (!StringUtils.hasLength(property)) {
                throw new ParameterException(String.format(ErrorCode.PARAM_LOST.getMessage(), PROPERTY));
            }
            Map<String, String> params = new HashMap<>(1);
            params.put(PROPERTY, property);
            return HdServiceRequest.builder()
                    .id(msg.getId())
                    .method(GET_PROPERTY_METHOD)
                    .params(params)
                    .build();
        } catch (Throwable e) {
            throw new ParameterException(e.getMessage());
        }
    }

    /**
     * {
     * "id": "e6f5a6e3-e884-4895-9e49-cc512af131ba",
     * "method": "setProperty",
     * “params”: {
     *  "abc": "123",//abc代码属性编码
     *  }
     * }
     * @param msg
     * @return
     * @throws ParameterException
     */
    private static HdServiceRequest setProperty(ServiceRequestMsg msg) throws ParameterException {
        try {
            Map<String, String> map = validateMap(msg.getParams());
            if (map.size() != 1) {
                throw new ParameterException("Only one property can be set at a time");
            }
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            Map.Entry<String, String> entry = iterator.next();
            if (!StringUtils.hasLength(entry.getKey())) {
                throw new ParameterException("Key is empty");
            }
            if (!StringUtils.hasLength(entry.getValue())) {
                throw new ParameterException(String.format(ErrorCode.PARAM_LOST.getMessage(), entry.getKey()));
            }
            Map<String, String> params = new HashMap<>(1);
            params.put(entry.getKey(), entry.getValue());
            return HdServiceRequest.builder()
                    .id(msg.getId())
                    .method(SET_PROPERTY_METHOD)
                    .params(params)
                    .build();
        } catch (Throwable e) {
            throw new ParameterException(e.getMessage());
        }
    }

    private static Map<String, String> validateMap(Object obj) throws ParameterException {
        if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            Map<String, String> objectMap = new HashMap<>(map.size());
            map.forEach((k, v)->{
                objectMap.put(k.toString(), v.toString());
            });
            return objectMap;
        }
        throw new ParameterException("params is not a map!");
    }
}
