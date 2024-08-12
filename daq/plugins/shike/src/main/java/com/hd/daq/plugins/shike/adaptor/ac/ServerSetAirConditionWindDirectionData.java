package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeServerSetAirConditionWindDirection;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--服务器下发设置空调风向指令
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerSetAirConditionWindDirectionData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 控制码
     */
    private String controlCode;
    /**
     * 指令  风向： 0自动摆风 1手动摆风 其余无效
     */
    private int instruct;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerSetAirConditionWindDirection to() {
        return IeServerSetAirConditionWindDirection.builder()
                .code(Integer.parseInt(controlCode))
                .windDirection(instruct & 1)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_AC_WIND_DIRECTION.getName();
    }
}
