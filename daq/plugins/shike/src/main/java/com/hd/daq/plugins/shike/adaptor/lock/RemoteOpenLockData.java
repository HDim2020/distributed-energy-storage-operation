package com.hd.daq.plugins.shike.adaptor.lock;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeRemoteOpenLock;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--办公锁远程开锁响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class RemoteOpenLockData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
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
     * 创建RemoteOpenLockData实体对象
     *
     * @param rfData RfData实体对象
     * @return RemoteOpenLockData实体对象
     */
    public static RemoteOpenLockData from(RfData rfData) {
        IeRemoteOpenLock ie = (IeRemoteOpenLock) rfData.getData();
        return RemoteOpenLockData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(Integer.toString(ie.getDeviceTypeCode()))
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
        return MethodType.GET_REMOTE_OPEN_LOCK.getName();
    }
}
