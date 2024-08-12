package com.hd.daq.plugins.cps.adaptor;

import com.google.gson.Gson;
import com.hd.daq.mqtt.session.MqttDeviceAwareSessionContext;
import com.hd.daq.plugins.cps.data.CpsPropertyMsg;
import com.hd.daq.plugins.cps.data.CpsServiceRequest;
import com.hd.daq.plugins.cps.exception.ParameterException;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.transportapi.data.thing.PropertyEntry;
import com.hd.daq.transportapi.data.thing.PropertyMsg;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 用来处理CPS消息
 * @author ymm
 */
@Component
public class CpsMessageAdaptor {
    protected static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final Gson GSON = new Gson();
    private static final String SET_PROPERTY_METHOD = "setProperty";

    public PropertyMsg convertToProperty(MqttDeviceAwareSessionContext ctx, MqttPublishMessage inbound) {
        String payload = inbound.payload().toString(UTF8);
        CpsPropertyMsg cpsPropertyMsg = GSON.fromJson(payload, CpsPropertyMsg.class);
        if (cpsPropertyMsg == null) {
            return null;
        }
        if (cpsPropertyMsg.getTs() == null) {
            return null;
        }
        if (cpsPropertyMsg.getD() == null) {
            return null;
        }
        if (cpsPropertyMsg.getD().size() < 1) {
            return null;
        }
        List<PropertyEntry> entryList = new ArrayList<>(cpsPropertyMsg.getD().size());
        cpsPropertyMsg.getD().forEach((k, v) -> {
            PropertyEntry entry = PropertyEntry.builder()
                    .ts(cpsPropertyMsg.getTs())
                    .propId(k)
                    .propValue(v.toString())
                    .build();
            entryList.add(entry);
        });
        PropertyMsg propertyMsg = new PropertyMsg();
        propertyMsg.setCollectorId(ctx.getDeviceInfo().getDeviceName());
        propertyMsg.setParams(entryList);

        return propertyMsg;
    }

    public MqttPublishMessage toMqttPublishMessage(MqttDeviceAwareSessionContext ctx, ServiceRequestMsg msg) throws ParameterException {
        if (!StringUtils.hasLength((String) ctx.getDeviceInfo().getExtendInfo())) {
            throw new ParameterException("Extend info is empty.");
        }
        if (!SET_PROPERTY_METHOD.equalsIgnoreCase(msg.getMethod())) {
            throw new ParameterException(String.format(ErrorCode.PARAM_INVALID.getMessage(), "method", msg.getMethod()));
        }
        CpsServiceRequest request = setProperty(msg);
        if (request != null) {
            String topic = getCmdTopic((String) ctx.getDeviceInfo().getExtendInfo(), ctx.getDeviceInfo().getDeviceName());
            return createMqttPublishMsg(ctx, topic, GSON.toJson(request));
        }
        return null;
    }

    private MqttPublishMessage createMqttPublishMsg(MqttDeviceAwareSessionContext ctx, String topic, String message) {
        MqttFixedHeader mqttFixedHeader =
                new MqttFixedHeader(MqttMessageType.PUBLISH, false, ctx.getQoSForTopic(topic), false, 0);
        MqttPublishVariableHeader header = new MqttPublishVariableHeader(topic, ctx.nextMsgId());
        ByteBuf payload = Unpooled.buffer();
        payload.writeBytes(message.getBytes(StandardCharsets.UTF_8));
        return new MqttPublishMessage(mqttFixedHeader, header, payload);
    }

    /**
     * {
     * "method": "setProperty",
     * “params”: {
     *  "slave1_tp_spt_set": "26",
     *  "slave4_ch_wtr_tp_in_spt_set": "7.5"
     *  }
     * }
     * @param msg
     * @return
     * @throws ParameterException
     */
    private CpsServiceRequest setProperty(ServiceRequestMsg msg) throws ParameterException {
        try {
            Map<String, BigDecimal> map = validateMap(msg.getParams());
            if (map.size() == 0) {
                throw new ParameterException("None property will be set.");
            }
            return CpsServiceRequest.builder()
                    .ts(System.currentTimeMillis())
                    .w(map)
                    .build();
        } catch (Throwable e) {
            throw new ParameterException(e.getMessage());
        }
    }

    private Map<String, BigDecimal> validateMap(Object obj) throws ParameterException {
        if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            Map<String, BigDecimal> objectMap = new HashMap<>(map.size());
            map.forEach((k, v)->{
                objectMap.put(k.toString(), new BigDecimal(v.toString()));
            });
            return objectMap;
        }
        throw new ParameterException("params is not a map!");
    }

    private String getCmdTopic(String extendInfo, String collectorId) {
        //topic格式: cmd/{渠道}/{collectorId}
        return "cmd/" + extendInfo + "/" + collectorId;
    }
}
