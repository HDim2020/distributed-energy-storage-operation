package com.hd.daq.plugins.rbscb.data;

/**
 * @author ymm
 */

public enum RbIotMsgType {
    /**
     * 网关发送网络心跳包
     */
    HEART_BEAT(0x20, "heartBeat"),
    /**
     * 网关上报网关信息
     */
    LINK_DEVICE_INFO(0X21, "linkInfo"),
    /**
     * 网关上报断路器设备基本信息
     */
    BROKER_DEVICE_INFO(0X22, "brokerInfo"),
    /**
     * 网关上报新增或者掉线断路器设备
     */
    BROKER_QUANTITY_CHANGED(0X23, "brokerQuantityChange"),
    /**
     * 网关上报断路器报警信息
     */
    BROKER_ALARM_INFO(0X24, "brokerAlarm"),
    /**
     * 服务器查询断路器功能投退设定信息
     */
    SERVER_QUERY_FUNC_ON_OFF_SETTING(0x40, "getOnOff"),
    /**
     * 服务器设置断路器开启/关闭常规投退功能
     */
    SERVER_SET_BROKER_FUNC_ON_OFF(0x41, "setOnOff"),
    /**
     * 服务器查询指定断路器设备参数
     */
    SERVER_QUERY_BROKER_PARAMETERS(0X42, "getBrokerParams"),
    /**
     * 服务器下发设置断路器设备参数
     */
    SERVER_SET_BROKER_PARAMETERS(0X43, "setBrokerParams"),
    /**
     * 服务器设置断路器开启/关闭过压保护功能
     */
    SERVER_SET_ON_OFF_OVER_VOLTAGE_PROTECTION(0x44, "setOverVoltageProtection"),
    /**
     * 服务器设置断路器开启/关闭低压保护功能
     */
    SERVER_SET_ON_OFF_LOW_VOLTAGE_PROTECTION(0x45, "setLowVoltageProtection"),
    /**
     * 服务器设置断路器开启/关闭过负荷保护功能
     */
    SERVER_SET_ON_OFF_OVERLOAD_PROTECTION(0x46, "setOverloadProtection"),
    /**
     * 服务器设置断路器开启/关闭端子过温保护功能
     */
    SERVER_SET_ON_OFF_OVER_TEMPERATURE_PROTECTION(0x47, "setOverTempProtection"),
    /**
     * 服务器设置断路器开启/关闭漏电流保护功能
     */
    SERVER_SET_ON_OFF_LEAKAGE_CURRENT_PROTECTION(0x48, "setLeakCurrentProtection"),
    /**
     * 服务器设置断路器开启/关闭恶性负载保护功能
     */
    SERVER_SET_ON_OFF_MALIGNANT_LOAD_PROTECTION(0x4A, "setMalignantLoadProtection"),
    /**
     * 服务下发智能用电遥控
     */
    SERVER_REMOTE_CONTROL_BROKER(0x4E, "controlBroker"),
    /**
     * 服务器指定断路器定时分合闸操作
     */
    SERVER_SET_BROKER_TIMED_ON_OFF(0x4F, "setBrokerTimedOnOff"),
    /**
     * 服务获取断路器遥测数据
     */
    SERVER_REQUEST_TELEMETRY_DATA(0x50, "telemetryData"),
    /**
     * 服务器读取定时上报遥测参数
     */
    SERVER_QUERY_TIMED_TRANSMIT_TELEMETRY_PARAM(0X51, "getTimedTelemetryParam"),
    /**
     * 服务器设置定时上报遥测参数
     */
    SERVER_SET_TIMED_TRANSMIT_TELEMETRY_PARAM(0X52, "setTimedTelemetryParam"),
    /**
     * 服务器下发设置值网关恢复出厂设置
     */
    SERVER_RESET_LINK(0X70, "reset");

    private final int id;
    private final String method;

    private RbIotMsgType(int id, String method) {
        this.id = id;
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public static RbIotMsgType typeFor(int id) {
        for(RbIotMsgType item : RbIotMsgType.values()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public static RbIotMsgType methodFor(String method) {
        for(RbIotMsgType item : RbIotMsgType.values()) {
            if (item.getMethod().equalsIgnoreCase(method)) {
                return item;
            }
        }
        return null;
    }
}
