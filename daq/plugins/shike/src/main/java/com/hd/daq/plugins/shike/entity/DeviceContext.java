package com.hd.daq.plugins.shike.entity;

import lombok.Data;

/**
 * 设备上下文
 *
 * @author ymm
 */
@Data
public class DeviceContext {

    /**
     * 通信标号 1字节
     */
    private int communicationLabel;
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 类型码
     */
    private Integer typeCode;
    /**
     * 采集器编号
     */
    private String collectorId;

    public DeviceContext() {
        communicationLabel = -1;
        uid = "";
        typeCode = null;
        collectorId = "";
    }
}
