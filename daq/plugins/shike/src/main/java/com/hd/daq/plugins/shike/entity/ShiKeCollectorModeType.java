package com.hd.daq.plugins.shike.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 时刻网关模式类型
 *
 * @author ymm
 */
public enum ShiKeCollectorModeType {
    /**
     * 正常模式
     */
    COMMON(1),
    /**
     * 对码模式
     */
    CODE_MATCHING(2);
    private final int id;
    private static final Map<Integer, ShiKeCollectorModeType> ID_MAP = new HashMap<>();

    static {
        for (ShiKeCollectorModeType enumInstance : ShiKeCollectorModeType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    ShiKeCollectorModeType(int id) {
        this.id = id;
    }

    /**
     * 返回ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 返回ID对应的枚举值
     *
     * @param id
     * @return
     */
    public static ShiKeCollectorModeType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
