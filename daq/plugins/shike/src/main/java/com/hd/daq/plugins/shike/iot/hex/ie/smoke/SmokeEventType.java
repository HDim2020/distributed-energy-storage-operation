package com.hd.daq.plugins.shike.iot.hex.ie.smoke;

import java.util.HashMap;
import java.util.Map;

/**
 * 烟感事件类型
 *
 * @author ymm
 */

public enum SmokeEventType {
    /**
     * 心跳
     */
    HEARTBEAT(0x01, "心跳"),
    /**
     * 烟感报警
     */
    SMOKE_ALARM(0x02, "烟感报警"),
    /**
     * 烟感报警恢复
     */
    SMOKE_ALARM_RECOVERY(0x03, "烟感报警恢复"),
    /**
     * 测试
     */
    TEST(0x04, "测试"),
    /**
     * 超温报警
     */
    OVER_TEMP_ALARM(0x05, "超温报警"),
    /**
     * 超温报警恢复
     */
    OVER_TEMP_RECOVERY(0x06, "超温报警恢复"),
    /**
     * 低压报警
     */
    LOW_VOLTAGE_ALARM(0x07, "低压报警"),
    /**
     * 低压报警恢复
     */
    LOW_VOLTAGE_RECOVERY(0x08, "低压报警恢复"),
    /**
     * 开机报告
     */
    STARTUP(0x09, "开机报告"),
    /**
     * 低温报警
     */
    LOW_TEMP_ALARM(0x0A, "低温报警"),
    /**
     * 低温恢复
     */
    LOW_TEMP_RECOVERY(0x0B, "超温恢复"),
    /**
     * 防拆报警
     */
    TAMPER_ALARM(0x0C, "防拆报警"),
    /**
     * 防拆恢复
     */
    TAMPER_RECOVERY(0x0D, "防拆恢复"),
    /**
     * 消音/暂停报警
     */
    PAUSE_ALARM(0xC1, "消音/暂停报警"),
    /**
     * 烟感阈值
     */
    SMOKE_THRESHOLD(0xC2, "烟感阈值"),
    /**
     * 低压阈值
     */
    LOW_VOLTAGE_THRESHOLD(0xC3, "低压阈值"),
    /**
     * 超温阈值
     */
    OVER_TEMP_THRESHOLD(0xC4, "超温阈值"),
    /**
     * 低温阈值
     */
    LOW_TEMP_THRESHOLD(0xC5, "低温阈值"),
    /**
     * 心跳间隔
     */
    HEARTBEAT_INTERVAL(0xC6, "心跳间隔"),
    /**
     * 设置全部参数
     */
    SET_ALL(0xCF, "设置全部参数");


    /**
     * 方法ID
     */
    private final int id;
    /**
     * 方法名称
     */
    private final String name;
    private static final Map<Integer, SmokeEventType> ID_MAP = new HashMap<>();

    static {
        for (SmokeEventType enumInstance : SmokeEventType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    SmokeEventType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 返回ID
     *
     * @return 方法ID
     */
    public int getId() {
        return id;
    }

    /**
     * 返回方法名称
     *
     * @return 方法名称
     */
    public String getName() {
        return name;
    }

    /**
     * 返回ID对应的枚举值
     *
     * @param id 方法ID
     * @return 实体
     */
    public static SmokeEventType typeFor(int id) {
        return ID_MAP.get(id);
    }

    /**
     * 获取事件ID对应的名称
     *
     * @param eventId 事件ID
     * @return 事件名称
     */
    public static String getEventName(int eventId) {
        SmokeEventType type = SmokeEventType.typeFor(eventId);
        if (type != null) {
            return type.getName();
        } else {
            return "未知事件[" + eventId + "]";
        }
    }
}
