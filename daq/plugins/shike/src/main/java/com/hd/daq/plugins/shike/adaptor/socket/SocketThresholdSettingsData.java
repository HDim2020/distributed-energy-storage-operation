package com.hd.daq.plugins.shike.adaptor.socket;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeSocketThresholdSettings;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--插座设置参数响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class SocketThresholdSettingsData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 过压保护
     */
    private String ovp;
    /**
     * 欠压保护
     */
    private String uvp;
    /**
     * 过载保护
     */
    private String olp;
    /**
     * 温度保护
     */
    private String tpp;
    /**
     * 低功率保护
     */
    private String upp;
    /**
     * 充电超时
     */
    private String othTimeoutClose;
    /**
     * 功能控制项
     */
    private String othLocalSwitch;

    /**
     * 创建SocketThresholdSettingsData实体对象
     *
     * @param rfData RfData实体对象
     * @return SocketThresholdSettingsData实体对象
     */
    public static SocketThresholdSettingsData from(RfData rfData) {
        IeSocketThresholdSettings ie = (IeSocketThresholdSettings) rfData.getData();
        return SocketThresholdSettingsData.builder()
                .uid(rfData.getDeviceId())
                .ovp(ie.getOverVoltageProtection())
                .uvp(ie.getUnderVoltageProtection())
                .olp(ie.getOverloadProtection())
                .tpp(ie.getOverTempProtection())
                .upp(ie.getUnderPowerProtection())
                .othTimeoutClose(ie.getChargingTimeout())
                .othLocalSwitch(ie.getFunctionControlItems())
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_SOCKET_THRESHOLD_SETTINGS.getName();
    }
}
