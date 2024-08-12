package com.hd.daq.plugins.shike.adaptor.fan;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeConfigFanDevice;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--智能吊扇控制器配置响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class ConfigFanDeviceData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 开关状态 Bit3
     */
    private String switchStatus;
    /**
     * 档位，Bit0-2 1-5档
     */
    private String gear;
    /**
     * 自动关闭间隔， 1-254有效，其他情况需要设置成0xFF表示不自动关
     */
    private String autoCloseInterval;
    /**
     * 多跳次数，1-15之间有效，超出范围表示禁用多跳转发
     */
    private String multipleHops;

    /**
     * 创建ConfigFanDeviceData实体对象
     *
     * @param rfData RfData实体对象
     * @return ConfigFanDeviceData实体对象
     */
    public static ConfigFanDeviceData from(RfData rfData) {
        IeConfigFanDevice ie = (IeConfigFanDevice) rfData.getData();
        return ConfigFanDeviceData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(Integer.toString(ie.getDeviceTypeCode()))
                .switchStatus(Integer.toString(ie.getSwitchStatus()))
                .gear(Integer.toString(ie.getGear()))
                .autoCloseInterval(Integer.toString(ie.getAutoCloseInterval()))
                .multipleHops(Integer.toString(ie.getMultipleHops()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_CONFIG_FAN.getName();
    }
}
