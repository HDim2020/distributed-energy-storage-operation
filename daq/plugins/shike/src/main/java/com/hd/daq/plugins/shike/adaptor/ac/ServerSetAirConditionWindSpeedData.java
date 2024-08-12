package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeServerSetAirConditionWindSpeed;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--服务器下发设置空调风速指令
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerSetAirConditionWindSpeedData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 控制码
     */
    private String controlCode;
    /**
     * 指令 风速：0自动，1 1档，2 2档，3 3档，其余无效
     */
    private int instruct;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerSetAirConditionWindSpeed to() {
        return IeServerSetAirConditionWindSpeed.builder()
                .code(Integer.parseInt(controlCode))
                .windSpeed(instruct & 3)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_AC_WIND_SPEED.getName();
    }
}
