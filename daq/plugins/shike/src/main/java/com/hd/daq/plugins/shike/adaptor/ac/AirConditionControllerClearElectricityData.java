package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionControllerTelemetryClear;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--大功率空调控制器对服务器下发清空电量统计的响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class AirConditionControllerClearElectricityData implements IMethodService {
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
     * 剩余电流
     */
    private String oneElectricCurrent;
    /**
     * 扩展温度1
     */
    private String twoTemperature;
    /**
     * 扩展温度2
     */
    private String threeTemperature;
    /**
     * 空调类型
     */
    private String airConditioningType;

    /**
     * 创建AirConditionIdData实体对象
     *
     * @param rfData RfData实体对象
     * @return AirConditionIdData实体对象
     */
    public static AirConditionControllerClearElectricityData from(RfData rfData) {
        IeAirConditionControllerTelemetryClear ie = (IeAirConditionControllerTelemetryClear) rfData.getData();
        return AirConditionControllerClearElectricityData.builder()
                .uid(rfData.getDeviceId())
                .voltage(Integer.toString(ie.getVoltage()))
                .electricCurrent(Integer.toString(ie.getCurrent()))
                .powerFactor(Integer.toString(ie.getPowerFactor()))
                .accumulatedPower(Long.toString(ie.getEnergy()))
                .temperature(Integer.toString(ie.getTemperature()))
                .humidity(Integer.toString(ie.getHumidity()))
                .switchStatus(ie.getSwitchStatus())
                .oneElectricCurrent(Integer.toString(ie.getResidualCurrent()))
                .twoTemperature(Integer.toString(ie.getExtraTemperature1()))
                .threeTemperature(Integer.toString(ie.getExtraTemperature2()))
                .airConditioningType(Integer.toString(ie.getAirConditionType()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_AC_CLEAR_ELECTRICITY.getName();
    }
}
