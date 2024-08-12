package com.hd.daq.plugins.shike.adaptor.fan;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeServerConfigFanDevice;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--智能电扇控制器服务器下发配置请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerConfigFanDeviceData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 自动关闭间隔， 1-254有效，其他情况需要设置成0xFF表示不自动关
     */
    private String autoCloseInterval;
    /**
     * 多跳次数，1-15之间有效，超出范围表示禁用多跳转发
     */
    private String multipleHops;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerConfigFanDevice to() {
        return IeServerConfigFanDevice.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .autoCloseInterval(Integer.parseInt(autoCloseInterval))
                .multipleHops(Integer.parseInt(multipleHops))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_CONFIG_FAN.getName();
    }
}
