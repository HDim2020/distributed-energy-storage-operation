package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeDeviceStartup;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列消息data部分--空调伴侣或控制器开机（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class DeviceStartupData implements IMethodService {
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
    public static DeviceStartupData from(RfData rfData) {
        IeDeviceStartup ie = (IeDeviceStartup) rfData.getData();
        return DeviceStartupData.builder()
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
        return MethodType.GET_DEVICE_OPEN.getName();
    }
}
