package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeServerSetAirConditionTemp;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--服务器下发设置空调温度指令
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerSetAirConditionTempData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 控制码
     */
    private String controlCode;
    /**
     * 指令 温度值：16-31度，其余无效
     */
    private int instruct;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerSetAirConditionTemp to() {
        return IeServerSetAirConditionTemp.builder()
                .code(Integer.parseInt(controlCode))
                .temperature(instruct)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_AC_TEMP.getName();
    }
}
