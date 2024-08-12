package com.hd.daq.transportapi.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidateDeviceCredentialsResponse {

    private final TransportDeviceInfo deviceInfo;
    private final String credentials;

    public boolean hasDeviceInfo() {
        return deviceInfo != null;
    }
}
