package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvStartup;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列消息data部分--多联机开机（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvStartupData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 所有空调参数校验和
     */
    private String check;
    /**
     * 版本信息
     */
    private String version;

    /**
     * 创建实体对象
     *
     * @param rfData RfData实体对象
     * @return 实体对象
     */
    public static VrvStartupData from(RfData rfData) {
        IeVrvStartup ie = (IeVrvStartup) rfData.getData();
        return VrvStartupData.builder()
                .uid(rfData.getDeviceId())
                .check(Integer.toString(ie.getCheckSum()))
                .version(ie.getVersion())
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_VRV_DEVICE_OPEN.getName();
    }
}
