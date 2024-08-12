package com.hd.daq.plugins.shike.iot.hex.ie.universal;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用属性类型
 *
 * @author ymm
 */

public enum UniversalAttributeType {
    /**
     * 事件上报 2字节
     */
    EVENT(0, "eventReporting", AttributeClass.READ_ONLY),
    /**
     * 固件版本日期 如221103.1 8字节
     */
    VERSION(4, "firmwareVersionDate", AttributeClass.READ_ONLY),
    /**
     * 心跳间隔 单位：分钟 1字节
     */
    HEARTBEAT_INTERVAL_MINUTE(5, "heartbeatIntervalDoorContact", AttributeClass.READ_WRITE),
    /**
     * 心跳间隔 单位：小时 1字节
     */
    HEARTBEAT_INTERVAL_HOUR(6, "heartbeatIntervalHour", AttributeClass.READ_ONLY),
    /**
     * 开关状态 1字节
     */
    SWITCH_STATUS(7, "switchStatus", AttributeClass.READ_WRITE),
    /**
     * 温度值 单位：℃ 1字节 有符号
     */
    TEMPERATURE_ONE_BYTE(8, "temperature", AttributeClass.READ_ONLY),
    /**
     * 湿度 单位：% 1字节
     */
    HUMIDITY(0x0C, "humidity", AttributeClass.READ_ONLY),
    /**
     * 电池电压 单位：mv 2字节
     */
    BATTERY_VOLTAGE(0x13, "batteryVoltage", AttributeClass.READ_ONLY),
    /**
     * 电池低压阈值 单位：mv 2字节
     */
    BATTERY_LOW_VOLTAGE_THRESHOLD(0x14, "batteryLow", AttributeClass.READ_WRITE),
    /**
     * 相电压，单位:V 2字节
     */
    VOLTAGE(0x15, "voltage", AttributeClass.READ_ONLY),
    /**
     * 功率因数，百分比：0~100 1字节
     */
    POWER_FACTOR(0x18, "powerFactor", AttributeClass.READ_ONLY),
    /**
     * 累计功耗，无符号4字节，单位：wh
     */
    ACCUMULATED_POWER(0x19, "accumulatedPower", AttributeClass.READ_WRITE),
    /**
     * 电压值 单位：mv 2字节
     */
    VOLTAGE_VALUE(0x28, "voltage", AttributeClass.READ_ONLY),
    /**
     * 相电压状态，0：正常；1:过压；2：欠压 1字节
     */
    VOLTAGE_STATUS(0x29, "voltageStatus", AttributeClass.READ_ONLY),
    /**
     * 过压阈值，单位:V 2字节
     */
    OVER_VOLTAGE_THRESHOLD(0x2E, "ovpOvervoltageThreshold", AttributeClass.READ_WRITE),
    /**
     * 欠压阈值，单位:V 2字节
     */
    UNDER_VOLTAGE_THRESHOLD(0x31, "uvpUndervoltageThreshold", AttributeClass.READ_WRITE),
    /**
     * 过温阈值，单位:℃ 1字节
     */
    OVER_TEMPERATURE_THRESHOLD(0x37, "tppTempThreshold", AttributeClass.READ_WRITE),
    /**
     * 剩余电流，单位：mA 2字节
     */
    RESIDUAL_CURRENT(0x3E, "residueElectric", AttributeClass.READ_ONLY),
    /**
     * 相电压告警开关，1:开，0:关 1字节
     */
    ENABLE_VOLTAGE_ALARM(0x43, "voltageAlarm", AttributeClass.READ_WRITE),
    /**
     * 相电流，单位:10mA 2字节
     */
    CURRENT(0x44, "electricCurrent", AttributeClass.READ_ONLY),
    /**
     * 相电流状态，0：正常;1:告警；2：短路；3：断路 1字节
     */
    CURRENT_STATUS(0x45, "electricCurrentStatus", AttributeClass.READ_ONLY),
    /**
     * 相电流过流阈值，单位:10mA 2字节
     */
    OVER_CURRENT_THRESHOLD(0x46, "electricCurrentThreshold", AttributeClass.READ_WRITE),
    /**
     * 相电流告警开关，1字节
     */
    ENABLE_CURRENT_ALARM(0x47, "electricCurrentAlarm", AttributeClass.READ_WRITE),
    /**
     * 剩余电流状态，0：正常;1:告警；2：短路；3：断路 1字节
     */
    RESIDUAL_CURRENT_STATUS(0x48, "residueElectricStatus", AttributeClass.READ_ONLY),
    /**
     * 温度值，单位:0.1℃ ,0xffff表示温度故障 2字节
     */
    TEMPERATURE(0x49, "temperature", AttributeClass.READ_ONLY),
    /**
     * 剩余电流告警开关，1:开，0:关 1字节
     */
    ENABLE_RESIDUAL_CURRENT_ALARM(0x4A, "residueElectricCurrentAlarm", AttributeClass.READ_WRITE),
    /**
     * 相电流互感器比例系数，2字节
     */
    CT(0x4B, "electricCurrentScale", AttributeClass.READ_WRITE),
    /**
     * 剩余电流过流阈值，单位:mA 2字节
     */
    RESIDUAL_CURRENT_OVER_CURRENT_THRESHOLD(0x4C, "residueElectricCurrentThreshold", AttributeClass.READ_WRITE),
    /**
     * 温度状态，0：正常；1：报警；2：短路；3：断路 1字节
     */
    TEMPERATURE_STATUS(0x4D, "tempStatus", AttributeClass.READ_ONLY),
    /**
     * 温度告警开关，1:开，0:关 1字节
     */
    ENABLE_TEMPERATURE_ALARM(0x4F, "tempAlarm", AttributeClass.READ_WRITE),
    /**
     * 输出防区状态 1:开;0:关 1字节
     */
    OUTPUT_DEFENCE_AREA_STATUS(0x51, "defenseZoneStatus", AttributeClass.READ_WRITE),
    /**
     * 告警总开关 1:开;0:关 1字节
     */
    ALARM_MAIN_SWITCH(0x53, "alarmSwitch", AttributeClass.READ_WRITE),
    /**
     * 整机告警状态 1:告警；2：故障；3：故障&告警；0：正常 1字节
     */
    DEVICE_ALARM_STATUS(0x54, "alarmStatus", AttributeClass.READ_WRITE),
    /**
     * 蜂鸣器状态 1:开;0:关 1字节
     */
    BUZZER_STATUS(0x55, "buzzerStatus", AttributeClass.READ_WRITE),
    /**
     * 蜂鸣器使能 1:使能;0:关 1字节
     */
    ENABLE_BUZZER(0x56, "buzzerEnable", AttributeClass.READ_WRITE),
    /**
     * 心跳间隔 单位：秒 2字节
     */
    HEARTBEAT_INTERVAL_SECOND(0x57, "heartbeatInterval", AttributeClass.READ_WRITE),
    /**
     * 市电状态 1：通电；0:断电 1字节
     */
    AC_STATUS(0x58, "mainsStatus", AttributeClass.READ_ONLY),
    /**
     * 电池电压状态 1：低压；0:正常 1字节
     */
    BATTERY_VOLTAGE_STATUS(0x59, "batteryStatus", AttributeClass.READ_ONLY),
    /**
     * 门磁状态 1：开；0:关 1字节
     */
    DOOR_CONTACT_STATUS(0x5A, "doorContactStatus", AttributeClass.READ_ONLY),
    /**
     * 水浸状态 1：水浸；0:正常 1字节
     */
    WATER_IMMERSION_STATUS(0x5B, "waterImmersionStatus", AttributeClass.READ_ONLY),
    /**
     * 输出防区联动使能 1:联动;0:不联动 1字节
     */
    ENABLE_OUTPUT_DEFENCE_AREA_LINKAGE(0x5C, "defenseZoneLinkage", AttributeClass.READ_WRITE),
    /**
     * 亮度 单位：无 1字节
     */
    BRIGHTNESS(0x5E, "brightness", AttributeClass.READ_ONLY),
    /**
     * 无人检测时间 单位：秒 2字节
     */
    NOBODY_DETECTION_TIME(0x5F, "nobodyDetectionTime", AttributeClass.READ_WRITE),
    /**
     * 联动时间(关闭) 单位：秒 2字节
     */
    LINKAGE_TIME_END(0x60, "linkageTimeEnd", AttributeClass.READ_WRITE),
    /**
     * 联动时间(开启) 单位：秒 2字节
     */
    LINKAGE_TIME_START(0x61, "linkageTimeStart", AttributeClass.READ_WRITE),
    /**
     * 2.4G信号强度 单位：% 1字节
     */
    G24_SIGNAL(0x62, "g24Signal", AttributeClass.READ_ONLY),
    /**
     * 亮度电压 单位：mv 2字节
     */
    BRIGHTNESS_VOLTAGE(0x66, "brightnessVoltage", AttributeClass.READ_ONLY),
    /**
     * 亮度正常阈值（百分比） 1字节
     */
    BRIGHTNESS_THRESHOLD(0x68, "brightnessThreshold", AttributeClass.READ_WRITE),
    /**
     * 电表类型 1字节
     * Bit0: 单相/三相  0-单相 1-三相
     * Bit1:  不加密/加密 0-不加密 1-加密
     */
    ELECTRICITY_METER_TYPE(0x70, "electricityMeterType", AttributeClass.READ_ONLY),
    /**
     * 电表表号 6字节 BCD码
     * 如 0x32 22 90 01 12 04, 表示表号为322290011204
     */
    ELECTRICITY_METER_NUMBER(0x71, "electricityMeterNumber", AttributeClass.READ_ONLY);

    UniversalAttributeType(int id, String name, AttributeClass attributeClass) {
        this.id = id;
        this.name = name;
        this.attributeClass = attributeClass;
    }

    /**
     * ID
     */
    @Getter
    private final int id;
    /**
     * 属性编码
     */
    @Getter
    private final String name;
    /**
     * 属性分类
     */
    @Getter
    private final AttributeClass attributeClass;

    private static final Map<Integer, UniversalAttributeType> ID_MAP = new HashMap<>();

    static {
        for (UniversalAttributeType enumInstance : UniversalAttributeType.values()) {
            ID_MAP.put(enumInstance.getId(), enumInstance);
        }
    }

    /**
     * 返回ID对应的枚举值
     *
     * @param id 类型ID
     * @return 实体
     */
    public static UniversalAttributeType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
