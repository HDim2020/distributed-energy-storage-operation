package com.hd.daq.transportapi.auth;

import lombok.Data;

/**
 * @author ymm
 */
@Data
public class TransportDeviceInfo {
    /**
     * 设备ID--guid
     */
    private String deviceId;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备型号
     */
    private String deviceModel;
    /**
     * 插件ID
     */
    private String pluginId;
    /**
     * 扩展信息
     */
    private Object extendInfo;

    public TransportDeviceInfo() {
        deviceId = "";
        deviceName = "";
        deviceModel = "";
        pluginId = "";
    }
}
