package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.IeAddDeviceOne;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列消息data部分--添加探头信息设备第一次上行
 *
 * @author ymm
 */
@Builder
@Getter
public class AddDeviceOneData implements IMethodService {
    /**
     * 通信标号
     */
    private String label;
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 信息
     */
    private String information;
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
    public static AddDeviceOneData from(RfData rfData) {
        IeAddDeviceOne ie = (IeAddDeviceOne) rfData.getData();
        return AddDeviceOneData.builder()
                .label(Integer.toString(rfData.getSequenceNumber()))
                .uid(rfData.getDeviceId())
                .information(String.format("%02X%02X%02X", ie.getDeviceTypeCode(), ie.getCmdCode(), ie.getRandomNumber()))
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
        return MethodType.GET_ADD_DEVICE_ONE.getName();
    }
}
