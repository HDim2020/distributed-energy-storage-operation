package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--设置空调响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class SetAirConditionData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;

    /**
     * 创建SetAirConditionData实体对象
     *
     * @param rfData RfData实体对象
     * @return SetAirConditionData实体对象
     */
    public static SetAirConditionData from(RfData rfData) {
        return SetAirConditionData.builder()
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
        return MethodType.GET_CONTROL_AC.getName();
    }
}
