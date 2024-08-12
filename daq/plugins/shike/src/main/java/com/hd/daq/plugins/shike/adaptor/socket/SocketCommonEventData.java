package com.hd.daq.plugins.shike.adaptor.socket;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeSocketCommonEvent;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--插座普通事件上行消息（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class SocketCommonEventData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 事件ID
     */
    private String eventsInfo;
    /**
     * 电压
     */
    private int voltage;
    /**
     * 电流
     */
    private int electricCurrent;
    /**
     * 功率因数
     */
    private int powerFactor;
    /**
     * 累计功耗
     */
    private long accumulatedPower;
    /**
     * 温度
     */
    private int temperature;
    /**
     * 湿度
     */
    private int humidity;
    /**
     * 开关状态
     */
    private int switchStatus;

    /**
     * 创建SocketCommonEventData实体对象
     *
     * @param rfData RfData实体对象
     * @return SocketCommonEventData实体对象
     */
    public static SocketCommonEventData from(RfData rfData) {
        IeSocketCommonEvent ie = (IeSocketCommonEvent) rfData.getData();
        return SocketCommonEventData.builder()
                .uid(rfData.getDeviceId())
                .eventsInfo(SocketEventType.getEventName(ie.getEventId()))
                .voltage(ie.getVoltage())
                .electricCurrent(ie.getElectricCurrent())
                .powerFactor(ie.getPowerFactor())
                .accumulatedPower(ie.getAccumulatedPower())
                .temperature(ie.getTemperature())
                .humidity(ie.getHumidity())
                .switchStatus(ie.getSwitchStatus())
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_SOCKET_DEVICE_EVENT.getName();
    }
}
