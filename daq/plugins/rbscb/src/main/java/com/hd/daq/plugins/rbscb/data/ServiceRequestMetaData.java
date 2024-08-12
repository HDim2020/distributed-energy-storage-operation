package com.hd.daq.plugins.rbscb.data;

import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.transportapi.DataStorageService;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import lombok.Builder;
import lombok.Getter;

/**
 * 服务请求元数据
 * @author ymm
 */
@Builder
@Getter
public class ServiceRequestMetaData {
    private ServiceRequestMsg serviceRequestMsg;
    private DeviceSessionCtx deviceSessionCtx;
    private DataStorageService dataStorageService;
}
