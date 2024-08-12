package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.iot.hex.ie.vrv.VrvStatusParam;
import lombok.Builder;
import lombok.Getter;

/**
 * 多联机空调数据
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvAcData {
    /**
     * 室外机地址
     */
    private String externalMachine;
    /**
     * 室内机地址
     */
    private String internalMachine;
    /**
     * 开关状态
     */
    private String switchStatus;
    /**
     * 设定温度
     */
    private String acTemp;
    /**
     * 模式
     */
    private String acMode;
    /**
     * 风速
     */
    private String acWindSpeed;
    /**
     * 室内温度
     */
    private String temperature;
    /**
     * 故障代码
     */
    private String faultCodes;

    /**
     * 构建实体对象
     *
     * @param param 空调状态参数实体对象
     * @return 实体对象
     */
    public static VrvAcData from(VrvStatusParam param) {
        return VrvAcData.builder()
                .externalMachine(Integer.toString(param.getOutdoorUnitAddress()))
                .internalMachine(Integer.toString(param.getIndoorUnitAddress()))
                .switchStatus(param.isOpened() ? "1" : "0")
                .acTemp(Integer.toString(param.getSettingTemperature()))
                .acMode(Integer.toString(param.getMode()))
                .acWindSpeed(Integer.toString(param.getWindSpeed()))
                .temperature(Integer.toString(param.getIndoorTemperature()))
                .faultCodes(Integer.toString(param.getFaultCode()))
                .build();
    }
}
