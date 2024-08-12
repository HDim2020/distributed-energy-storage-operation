package com.hd.daq.plugins.shike.adaptor.socket;

import java.util.HashMap;
import java.util.Map;

/**
 * 插座事件类型
 *
 * @author ymm
 */

public enum SocketEventType {
    /**
     * 掉电
     */
    LOST_AC(2, "掉电"),
    /**
     * 欠压报警
     */
    UNDER_VOLTAGE_ALARM(3, "欠压报警"),
    /**
     * 欠压恢复
     */
    UNDER_VOLTAGE_RECOVERY(4, "欠压恢复"),
    /**
     * 过压报警
     */
    OVER_VOLTAGE_ALARM(5, "过压报警"),
    /**
     * 过压恢复
     */
    OVER_VOLTAGE_RECOVERY(6, "过压恢复"),
    /**
     * 功率过载报警
     */
    OVER_POWER_ALARM(7, "功率过载报警"),
    /**
     * 功率过载恢复
     */
    OVER_POWER_RECOVERY(8, "功率过载恢复"),
    /**
     * 超温报警
     */
    OVER_TEMP_ALARM(9, "超温报警"),
    /**
     * 超温恢复
     */
    OVER_TEMP_RECOVERY(10, "超温恢复"),
    /**
     * 充电开始
     */
    CHARGING_START(11, "充电开始"),
    /**
     * 充电结束
     */
    CHARGING_END(12, "充电结束"),
    /**
     * 空载断电
     */
    NO_LOAD_POWER_OUTAGE(13, "空载断电"),
    /**
     * 充满断电
     */
    FULL_POWER_OUTAGE(14, "充满断电"),
    /**
     * 低功率运行报警
     */
    UNDER_POWER_ALARM(15, "低功率运行报警"),
    /**
     * 低功率运行恢复
     */
    UNDER_POWER_RECOVERY(16, "低功率运行恢复");

    /**
     * 方法ID
     */
    private final int id;
    /**
     * 方法名称
     */
    private final String name;
    private static final Map<Integer, SocketEventType> ID_MAP = new HashMap<>();

    static {
        for (SocketEventType enumInstance : SocketEventType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    SocketEventType(int id, String name) {
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
    public static SocketEventType typeFor(int id) {
        return ID_MAP.get(id);
    }

    /**
     * 获取事件ID对应的名称
     *
     * @param eventId 事件ID
     * @return 事件名称
     */
    public static String getEventName(int eventId) {
        SocketEventType type = SocketEventType.typeFor(eventId);
        if (type != null) {
            return type.getName();
        } else {
            return "未知事件[" + eventId + "]";
        }
    }
}
