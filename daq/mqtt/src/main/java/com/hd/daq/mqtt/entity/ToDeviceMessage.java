package com.hd.daq.mqtt.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 发送给设备的消息结构
 * @author ymm
 */
@Builder
@Data
public class ToDeviceMessage {
    /**
     * 消息主题
     */
    private String topic;
    /**
     * 消息
     */
    private byte[] payload;
}
