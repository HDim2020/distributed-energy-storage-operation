package com.hd.daq.plugins.shike.iot.json;

import java.util.HashMap;
import java.util.Map;

/**
 * JSON格式命令类型
 *
 * @author ymm
 */

public enum JsonCmdType {
    /**
     * 心跳
     */
    CMD_HEARTBEAT(1),
    /**
     * 请求同步时间
     */
    CMD_TIME_SYNC_REQUEST(10),
    /**
     * 回复同步时间
     */
    CMD_TIME_SYNC_RESPONSE(138);

    /**
     *
     */
    private final int id;
    private static final Map<Integer, JsonCmdType> ID_MAP = new HashMap<>();

    static {
        for (JsonCmdType enumInstance : JsonCmdType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    JsonCmdType(int id) {
        this.id = id;
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
     * 返回ID对应的枚举值
     *
     * @param id 方法ID
     * @return 实体
     */
    public static JsonCmdType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
