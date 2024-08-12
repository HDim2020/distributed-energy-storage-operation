package com.hd.daq.transportapi.session;

import com.hd.daq.transportapi.auth.TransportDeviceInfo;
import com.hd.daq.transportapi.proto.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public abstract class DeviceAwareSessionContext implements SessionContext {

    @Getter
    protected final UUID sessionId;
    @Getter
    private volatile String deviceId;
    @Getter
    protected volatile TransportDeviceInfo deviceInfo;
    @Getter
    @Setter
    private volatile TransportProtos.SessionInfoProto sessionInfo;

    private volatile boolean connected;

    public void setDeviceInfo(TransportDeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
        this.connected = true;
        this.deviceId = deviceInfo.getDeviceId();
    }

    public boolean isConnected() {
        return connected;
    }

    public void setDisconnected() {
        this.connected = false;
    }
}
