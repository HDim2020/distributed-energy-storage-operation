package com.hd.daq.plugins.shike.iot;

import java.util.HashMap;
import java.util.Map;

/**
 * 包类型
 *
 * @author ymm
 */

public enum ContentType {
    /**
     * 心跳包
     */
    CT_HEARTBEAT(0),
    /**
     * 应用数据（UTF8编码的JSON）
     */
    CT_JSON_DATA(24),
    /**
     * 应用数据（十六进制，应用在透传接收和控制前端设备）
     */
    CT_HEX_DATA(25);

    private final int id;
    private static final Map<Integer, ContentType> ID_MAP = new HashMap<>();

    static {
        for (ContentType enumInstance : ContentType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    ContentType(int id) {
        this.id = id;
    }

    /**
     * 返回ID
     *
     * @return 类型ID
     */
    public int getId() {
        return id;
    }

    /**
     * 返回ID对应的枚举值
     *
     * @param id 类型ID
     * @return 实体
     */
    public static ContentType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
