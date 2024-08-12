package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvQueryVersion;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--多联机查询设备版本响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvQueryVersionData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 固件版本
     */
    private String firmwareVersion;
    /**
     * 子设备接收网关2.4G信号强度
     */
    private String deviceSignal;
    /**
     * 网关接收子设备2.4G信号强度
     */
    private String gatewaySignal;
    /**
     * 所有空调参数校验和
     */
    private String checkSum;

    /**
     * 创建实体对象
     *
     * @param rfData RfData实体对象
     * @return 实体对象
     */
    public static VrvQueryVersionData from(RfData rfData) {
        IeVrvQueryVersion ie = (IeVrvQueryVersion) rfData.getData();
        return VrvQueryVersionData.builder()
                .uid(rfData.getDeviceId())
                .firmwareVersion(ie.getFirmwareVersion())
                .deviceSignal(Integer.toString(ie.getDeviceSignal()))
                .gatewaySignal(Integer.toString(ie.getGatewaySignal()))
                .checkSum(Integer.toString(ie.getCheckSum()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_VRV_QUERY_VERSION.getName();
    }
}
