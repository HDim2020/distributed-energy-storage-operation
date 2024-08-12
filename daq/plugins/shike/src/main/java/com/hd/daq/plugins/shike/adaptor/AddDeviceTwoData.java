package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.IeAddDeviceTwo;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列消息data部分--添加探头信息设备第二次上行
 *
 * @author ymm
 */
@Builder
@Getter
public class AddDeviceTwoData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 创建AddDeviceOneData实体对象
     *
     * @param rfData RfData实体对象
     * @return AddDeviceOneData实体对象
     */
    public static AddDeviceTwoData from(RfData rfData) {
        IeAddDeviceTwo ie = (IeAddDeviceTwo) rfData.getData();
        return AddDeviceTwoData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(Integer.toString(ie.getDeviceTypeCode()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_ADD_DEVICE_TWO.getName();
    }
}
