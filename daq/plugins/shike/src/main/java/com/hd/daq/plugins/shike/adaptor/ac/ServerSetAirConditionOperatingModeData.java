package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeServerSetAirConditionOperatingMode;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--服务器下发设置空调运行模式指令
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerSetAirConditionOperatingModeData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 控制码
     */
    private String controlCode;
    /**
     * 指令 0-自动，1--制冷，2--除湿， 3--送风， 4--制暖
     */
    private int instruct;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerSetAirConditionOperatingMode to() {
        return IeServerSetAirConditionOperatingMode.builder()
                .code(Integer.parseInt(controlCode))
                .mode(instruct & 7)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_AC_OPERATING_MODE.getName();
    }
}
