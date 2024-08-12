package com.hd.daq.transportapi.auth;

import com.hd.daq.transportapi.TransportContext;
import com.hd.daq.transportapi.proto.TransportProtos;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @author ymm
 */
@Slf4j
public class SessionInfoCreator {

    public static TransportProtos.SessionInfoProto create(ValidateDeviceCredentialsResponse msg, TransportContext context, UUID sessionId) {
        UUID deviceId = UUID.fromString(msg.getDeviceInfo().getDeviceId());
        return TransportProtos.SessionInfoProto.newBuilder()
                .setSessionIdMSB(sessionId.getMostSignificantBits())
                .setSessionIdLSB(sessionId.getLeastSignificantBits())
                .setDeviceIdMSB(deviceId.getMostSignificantBits())
                .setDeviceIdLSB(deviceId.getLeastSignificantBits())
                .setDeviceName(msg.getDeviceInfo().getDeviceName())
                .setDeviceType(msg.getDeviceInfo().getDeviceModel())
                .build();
    }

}
