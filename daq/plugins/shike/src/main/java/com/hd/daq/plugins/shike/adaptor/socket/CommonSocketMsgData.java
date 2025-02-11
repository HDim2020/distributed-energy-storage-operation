package com.hd.daq.plugins.shike.adaptor.socket;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeCommonSocketMsg;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--插座通用上行消息（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class CommonSocketMsgData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 电压
     */
    private String voltage;
    /**
     * 电流
     */
    private String electricCurrent;
    /**
     * 功率因数
     */
    private String powerFactor;
    /**
     * 累计功耗
     */
    private String accumulatedPower;
    /**
     * 温度
     */
    private String temperature;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 开关状态
     */
    private int switchStatus;

    /**
     * 创建CommonSocketMsgData实体对象
     *
     * @param rfData RfData实体对象
     * @return CommonSocketMsgData实体对象
     */
    public static CommonSocketMsgData from(RfData rfData) {
        IeCommonSocketMsg ie = (IeCommonSocketMsg) rfData.getData();
        return CommonSocketMsgData.builder()
                .uid(rfData.getDeviceId())
                .voltage(Integer.toString(ie.getVoltage()))
                .electricCurrent(Integer.toString(ie.getElectricCurrent()))
                .powerFactor(Integer.toString(ie.getPowerFactor()))
                .accumulatedPower(Long.toString(ie.getAccumulatedPower()))
                .temperature(Integer.toString(ie.getTemperature()))
                .humidity(Integer.toString(ie.getHumidity()))
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
        return MethodType.GET_SOCKET_COMMON.getName();
    }
}
