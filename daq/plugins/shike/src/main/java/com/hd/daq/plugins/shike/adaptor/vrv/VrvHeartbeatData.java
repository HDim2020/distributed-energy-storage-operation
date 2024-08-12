package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvHeartbeat;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列消息data部分--多联机心跳（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvHeartbeatData implements IMethodService {
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
    public static VrvHeartbeatData from(RfData rfData) {
        IeVrvHeartbeat ie = (IeVrvHeartbeat) rfData.getData();
        return VrvHeartbeatData.builder()
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
        return MethodType.GET_VRV_HEARTBEAT.getName();
    }
}
