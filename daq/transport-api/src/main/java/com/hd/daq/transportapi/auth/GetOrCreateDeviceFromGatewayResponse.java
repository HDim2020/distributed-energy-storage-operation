package com.hd.daq.transportapi.auth;

import lombok.Builder;
import lombok.Data;

/**
 * @author ymm
 */
@Data
@Builder
public class GetOrCreateDeviceFromGatewayResponse {
    private TransportDeviceInfo deviceInfo;
}
