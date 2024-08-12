package com.hd.daq.plugins.shike.adaptor.fan;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeServerControlFanDevice;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--智能电扇控制器服务器下发控制请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerControlFanDeviceData implements IMethodService, IServerToDeviceMessage {
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
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerControlFanDevice to() {
        return IeServerControlFanDevice.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .switchStatus(Integer.parseInt(switchStatus))
                .gear(Integer.parseInt(gear))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_CONTROL_FAN.getName();
    }
}
