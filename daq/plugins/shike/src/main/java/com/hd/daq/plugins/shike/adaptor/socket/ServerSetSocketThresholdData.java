package com.hd.daq.plugins.shike.adaptor.socket;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeServerSetSocketThreshold;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--插座服务器下发设置参数指令
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerSetSocketThresholdData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 过压保护 5字节
     */
    private String ovp;
    /**
     * 欠压保护 5字节
     */
    private String uvp;
    /**
     * 过载保护 5字节
     */
    private String olp;
    /**
     * 温度保护 3字节
     */
    private String tpp;
    /**
     * 低功率保护 2字节
     */
    private String upp;
    /**
     * 充电超时 1字节
     */
    private String othTimeoutClose;
    /**
     * 功能控制项 1字节
     */
    private String othLocalSwitch;
    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerSetSocketThreshold to() {
        return IeServerSetSocketThreshold.builder()
                .overVoltageProtection(ovp)
                .underVoltageProtection(uvp)
                .overloadProtection(olp)
                .overTempProtection(tpp)
                .underPowerProtection(upp)
                .chargingTimeout(othTimeoutClose)
                .functionControlItems(othLocalSwitch)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_SOCKET_THRESHOLD_SETTINGS.getName();
    }
}
