package com.hd.daq.plugins.shike.adaptor.smoke;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.IeSmokeResponse;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--烟感设置响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class SmokeConfigData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 硬件版本 1字节
     */
    private String hardwareVersion;
    /**
     * 协议版本 1字节
     */
    private String protocolVersion;
    /**
     * 事件ID 1字节
     */
    private String eventId;
    /**
     * 指令（事件类型） 1字节
     */
    private String instruct;
    /**
     * 固件版本 8字节
     */
    private String firmwareVersion;
    /**
     * 烟感状态 1字节 0--正常 1--报警
     */
    private String smokeStatus;
    /**
     * 烟感浓度 1字节
     */
    private String smokeDensity;
    /**
     * 烟雾阈值 1字节
     */
    private String smokeThreshold;
    /**
     * 温度状态 1字节 0--正常 1--超温报警 2--低温报警
     */
    private String tempStatus;
    /**
     * 温度 1字节
     */
    private String temperature;
    /**
     * 超温阈值 1字节 0xFF关闭
     */
    private String overTempThreshold;
    /**
     * 超温恢复阈值 1字节
     */
    private String overTempRecoveryThreshold;
    /**
     * 低温阈值 1字节 0xFF关闭
     */
    private String lowTempThreshold;
    /**
     * 低温恢复阈值 1字节
     */
    private String lowTempRecoveryThreshold;
    /**
     * 电池电压状态 1字节 0--正常 1--低压
     */
    private String batteryVoltageStatus;
    /**
     * 电池电压 2字节 mv
     */
    private String batteryVoltage;
    /**
     * 低压阈值 2字节 mv
     */
    private String lowVoltageThreshold;
    /**
     * 防拆状态 1字节 0--正常 1--防拆打开
     */
    private String tamperStatus;
    /**
     * 模式 1字节 0--正常 1--消音 2--暂停报警
     */
    private String mode;
    /**
     * 心跳间隔 1字节 小时
     */
    private String heartbeatInterval;

    /**
     * 创建SmokeConfigData实体对象
     *
     * @param rfData RfData实体对象
     * @return SmokeConfigData实体对象
     */
    public static SmokeConfigData from(RfData rfData) {
        IeSmokeResponse ie = (IeSmokeResponse) rfData.getData();
        return SmokeConfigData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(ie.getDeviceTypeCode().toString())
                .hardwareVersion(Integer.toString(ie.getHardwareVersion()))
                .protocolVersion(Integer.toString(ie.getProtocolVersion()))
                .eventId(Integer.toString(ie.getEventId()))
                .instruct(Integer.toString(ie.getEventType() & 0xBF))
                .firmwareVersion(ie.getFirmwareVersion())
                .smokeStatus(Integer.toString(ie.getSmokeStatus()))
                .smokeDensity(Integer.toString(ie.getSmokeDensity()))
                .smokeThreshold(Integer.toString(ie.getSmokeThreshold()))
                .tempStatus(Integer.toString(ie.getTempStatus()))
                .temperature(Integer.toString(ie.getTemperature()))
                .overTempThreshold(Integer.toString(ie.getOverTempThreshold()))
                .overTempRecoveryThreshold(Integer.toString(ie.getOverTempRecoveryThreshold()))
                .lowTempThreshold(Integer.toString(ie.getLowTempThreshold()))
                .lowTempRecoveryThreshold(Integer.toString(ie.getLowTempRecoveryThreshold()))
                .batteryVoltageStatus(Integer.toString(ie.getBatteryVoltageStatus()))
                .batteryVoltage(Integer.toString(ie.getBatteryVoltage()))
                .lowVoltageThreshold(Integer.toString(ie.getLowVoltageThreshold()))
                .tamperStatus(Integer.toString(ie.getTamperStatus()))
                .mode(Integer.toString(ie.getMode()))
                .heartbeatInterval(Integer.toString(ie.getHeartbeatInterval()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_SMOKE_CONFIG.getName();
    }
}
