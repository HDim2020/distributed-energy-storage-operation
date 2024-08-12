package com.hd.daq.plugins.shike.iot.hex.ie.universal;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用事件类型
 *
 * @author ymm
 */

public enum UniversalEventType {
    /**
     * 市电掉电
     */
    AC_LOST(0x02, "市电掉电"),
    /**
     * 电压欠压
     */
    UNDER_RECOVERY(0x03, "电压欠压"),
    /**
     * 电压过压
     */
    OVER_RECOVERY(0x05, "电压过压"),
    /**
     * 温度告警
     */
    TEMPERATURE_ALARM(0x09, "温度告警"),
    /**
     * 剩余电流断路故障
     */
    RESIDUAL_CURRENT_OPEN_CIRCUIT_FAULT(0x11, "剩余电流断路故障"),
    /**
     * 开机
     */
    POWER_ON(0x12, "开机"),
    /**
     * 自检
     */
    SELF_TEST(0x13, "自检"),
    /**
     * 温度短路故障
     */
    TEMPERATURE_SHORT_CIRCUIT_FAULT(0x14, "温度短路故障"),
    /**
     * 温度断路故障
     */
    TEMPERATURE_OPEN_CIRCUIT_FAULT(0x15, "温度断路故障"),
    /**
     * 输出防区开
     */
    OUTPUT_DEFENCE_AREA_OPEN(0x16, "输出防区开"),
    /**
     * 输出防区关
     */
    OUTPUT_DEFENCE_AREA_CLOSE(0x17, "输出防区关"),
    /**
     * 市电通电
     */
    AC_ON(0x18, "市电通电"),
    /**
     * 电池低压
     */
    BATTERY_LOW_VOLTAGE(0x19, "电池低压"),
    /**
     * 接警
     */
    ALARM_RESPONSE(0x1A, "接警"),
    /**
     * 消音
     */
    MUTE(0x1B, "消音"),
    /**
     * 关机
     */
    POWER_OFF(0x1C, "关机"),
    /**
     * 恢复出厂
     */
    RESET(0x1D, "恢复出厂"),
    /**
     * 门磁开
     */
    DOOR_CONTACT_OPEN(0x21, "门磁开"),
    /**
     * 门磁关
     */
    DOOR_CONTACT_CLOSE(0x22, "门磁关"),
    /**
     * 水浸恢复
     */
    WATER_IMMERSION_RECOVERY(0x24, "水浸恢复"),
    /**
     * 水浸报警
     */
    WATER_IMMERSION_ALARM(0x25, "水浸报警"),
    /**
     * 电流恢复
     */
    CURRENT_RECOVERY(0x26, "电流恢复"),
    /**
     * 电流告警
     */
    CURRENT_ALARM(0x27, "电流告警"),
    /**
     * 电流短路故障
     */
    CURRENT_SHORT_CIRCUIT_FAULT(0x28, "电流短路故障"),
    /**
     * 电流断路故障
     */
    CURRENT_OPEN_CIRCUIT_FAULT(0x29, "电流断路故障"),
    /**
     * 剩余电流恢复
     */
    RESIDUAL_CURRENT_RECOVERY(0x2A, "剩余电流恢复"),
    /**
     * 剩余电流告警
     */
    RESIDUAL_CURRENT_ALARM(0x2B, "剩余电流告警"),
    /**
     * 剩余电流短路故障
     */
    RESIDUAL_CURRENT_SHORT_CIRCUIT_FAULT(0x2C, "剩余电流短路故障"),
    /**
     * 电压恢复
     */
    VOLTAGE_RECOVERY(0x2D, "电压恢复"),
    /**
     * 温度恢复
     */
    TEMPERATURE_RECOVERY(0x2E, "温度恢复"),
    /**
     * 有人告警
     */
    SOMEBODY_ALARM(0x30, "有人告警"),
    /**
     * 无人恢复
     */
    NOBODY_RECOVERY(0x31, "无人恢复"),
    /**
     * 防拆恢复
     */
    TAMPER_RECOVERY(0x32, "防拆恢复");

    UniversalEventType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Getter
    private final int id;
    @Getter
    private final String name;
    private static final Map<Integer, UniversalEventType> ID_MAP = new HashMap<>();

    static {
        for (UniversalEventType enumInstance : UniversalEventType.values()) {
            ID_MAP.put(enumInstance.getId(), enumInstance);
        }
    }

    /**
     * 返回ID对应的枚举值
     *
     * @param id 类型ID
     * @return 实体
     */
    public static UniversalEventType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
