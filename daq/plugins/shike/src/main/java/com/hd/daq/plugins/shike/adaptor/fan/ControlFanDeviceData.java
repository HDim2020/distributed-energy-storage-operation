package com.hd.daq.plugins.shike.adaptor.fan;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeControlFanDevice;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--智能吊扇控制器控制响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class ControlFanDeviceData implements IMethodService {
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
     * 创建ControlFanDeviceData实体对象
     *
     * @param rfData RfData实体对象
     * @return ControlFanDeviceData实体对象
     */
    public static ControlFanDeviceData from(RfData rfData) {
        IeControlFanDevice ie = (IeControlFanDevice) rfData.getData();
        return ControlFanDeviceData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(Integer.toString(ie.getDeviceTypeCode()))
                .switchStatus(Integer.toString(ie.getSwitchStatus()))
                .gear(Integer.toString(ie.getGear()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_CONTROL_FAN.getName();
    }
}
