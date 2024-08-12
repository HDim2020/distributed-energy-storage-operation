package com.hd.daq.plugins.shike.adaptor.lock;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeQueryLockDevice;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--办公锁查询响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class QueryLockDeviceData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 固件版本 8字节
     */
    private String firmwareVersion;
    /**
     * 电池电压 mv 2字节
     */
    private String batteryVoltage;
    /**
     * 锁状态 Bit0
     */
    private String switchStatus;
    /**
     * 低压标识符，Bit2
     */
    private String lowVoltage;

    /**
     * 创建QueryLockDeviceData实体对象
     *
     * @param rfData RfData实体对象
     * @return QueryLockDeviceData实体对象
     */
    public static QueryLockDeviceData from(RfData rfData) {
        IeQueryLockDevice ie = (IeQueryLockDevice) rfData.getData();
        return QueryLockDeviceData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(Integer.toString(ie.getDeviceTypeCode()))
                .firmwareVersion(ie.getFirmwareVersion())
                .batteryVoltage(Integer.toString(ie.getBatteryVoltage()))
                .switchStatus(Integer.toString(ie.getSwitchStatus()))
                .lowVoltage(Integer.toString(ie.getLowVoltage()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_QUERY_LOCK.getName();
    }
}
