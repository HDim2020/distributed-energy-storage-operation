package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionId;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--空调伴侣或控制器查询空调ID（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class AirConditionIdData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 空调控制码
     */
    private String controlCode;

    /**
     * 创建AirConditionIdData实体对象
     *
     * @param rfData RfData实体对象
     * @return AirConditionIdData实体对象
     */
    public static AirConditionIdData from(RfData rfData) {
        IeAirConditionId ie = (IeAirConditionId) rfData.getData();
        return AirConditionIdData.builder()
                .uid(rfData.getDeviceId())
                .controlCode(Integer.toString(ie.getControlCode()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_QUERY_AC_ID.getName();
    }
}
