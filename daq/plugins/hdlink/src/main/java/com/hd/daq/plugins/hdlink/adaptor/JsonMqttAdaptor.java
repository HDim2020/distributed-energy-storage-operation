package com.hd.daq.plugins.hdlink.adaptor;

import com.google.gson.*;
import com.hd.daq.mqtt.session.MqttDeviceAwareSessionContext;
import com.hd.daq.plugins.hdlink.data.HdServiceResponse;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.transportapi.data.thing.PropertyMsg;
import com.hd.daq.transportapi.data.thing.PropertyEntry;
import com.hd.daq.transportapi.data.thing.ResponseMsg;
import com.hd.daq.transportapi.proto.TransportProtos;
import com.hd.daq.transportapi.util.KeyValueProtoUtil;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.mqtt.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author ymm
 */
@Component
@Slf4j
public class JsonMqttAdaptor {

    protected static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final Gson GSON = new Gson();

    public PropertyMsg convertToProperty(MqttDeviceAwareSessionContext ctx, MqttPublishMessage inbound) throws AdaptorException {
        String payload = validatePayload(ctx.getSessionId(), inbound.payload(), false);
        try {
            TransportProtos.PostTelemetryMsg msg = JsonConverter.convertToTelemetryProto(JsonParser.parseString(payload));
            int dataPoints = 0;
            for (TransportProtos.TsKvListProto tsKv : msg.getTsKvListList()) {
                dataPoints += tsKv.getKvCount();
            }
            PropertyMsg propertyData = new PropertyMsg();
            List<PropertyEntry> entryList = new ArrayList<>(dataPoints);
            for (TransportProtos.TsKvListProto tsKv : msg.getTsKvListList()) {
                for (TransportProtos.KeyValueProto keyValueProto : tsKv.getKvList()) {
                    PropertyEntry entry = PropertyEntry.builder()
                            .ts(tsKv.getTs())
                            .propId(keyValueProto.getKey())
                            .propValue(KeyValueProtoUtil.getValueString(keyValueProto))
                            .build();
                    entryList.add(entry);
                }
            }
            propertyData.setCollectorId(ctx.getDeviceInfo().getDeviceName());
            propertyData.setParams(entryList);
            return propertyData;
        } catch (IllegalStateException | JsonSyntaxException ex) {
            throw new AdaptorException(ex);
        }
    }

    public ResponseMsg convertToServiceResponse(MqttDeviceAwareSessionContext ctx, MqttPublishMessage inbound) throws AdaptorException {
        HdServiceResponse hdServiceResponse = processServiceResponseMsg(inbound);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCollectorId(ctx.getDeviceInfo().getDeviceName());
        responseMsg.setId(hdServiceResponse.getId());
        responseMsg.setData(hdServiceResponse.getData());
        responseMsg.setMethod(hdServiceResponse.getMethod());
        if (hdServiceResponse.getCode() == 0) {
            responseMsg.setCode(ErrorCode.SUCCESS.getCode());
            responseMsg.setMessage(ErrorCode.SUCCESS.getMessage());
        } else {
            responseMsg.setCode(ErrorCode.FAIL.getCode());
            responseMsg.setMessage(hdServiceResponse.getMessage());
        }

        return responseMsg;
    }

    protected HdServiceResponse processServiceResponseMsg(MqttPublishMessage inbound) throws AdaptorException {
        try {
            String payload = inbound.payload().toString(UTF8);
            return GSON.fromJson(payload, HdServiceResponse.class);
        } catch (RuntimeException e) {
            log.warn("Failed to decode Rpc response", e);
            throw new AdaptorException(e);
        }
    }

    private static String validatePayload(UUID sessionId, ByteBuf payloadData, boolean isEmptyPayloadAllowed) throws AdaptorException {
        String payload = payloadData.toString(UTF8);
        if (payload == null) {
            log.warn("[{}] Payload is empty!", sessionId);
            if (!isEmptyPayloadAllowed) {
                throw new AdaptorException(new IllegalArgumentException("Payload is empty!"));
            }
        }
        return payload;
    }
}
