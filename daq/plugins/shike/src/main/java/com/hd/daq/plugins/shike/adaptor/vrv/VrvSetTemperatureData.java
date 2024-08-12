package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列消息data部分--多联机控制空调温度响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvSetTemperatureData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;

    /**
     * 创建实体对象
     *
     * @param rfData RfData实体对象
     * @return 实体对象
     */
    public static VrvSetTemperatureData from(RfData rfData) {
        return VrvSetTemperatureData.builder()
                .uid(rfData.getDeviceId())
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_VRV_CONTROL_AC.getName();
    }
}
