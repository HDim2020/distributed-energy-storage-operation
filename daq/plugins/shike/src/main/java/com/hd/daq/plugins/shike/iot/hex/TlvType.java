package com.hd.daq.plugins.shike.iot.hex;

import java.util.HashMap;
import java.util.Map;

/**
 * TLV类型码
 * @author ymm
 */

public enum TlvType {
    /**
     * RF数据 0xA1
     */
    RF_DATA(0xA1),
    /**
     * RF信号 0xA2
     */
    RF_SIGNAL(0xA2),
    /**
     * 清空白名单 0xB1
     */
    CLEAR_WHITELIST(0xB1),
    /**
     * 增加白名单 0xB2
     */
    ADD_WHITELIST(0xB2),
    /**
     * 移除白名单 0xB3
     */
    REMOVE_WHITELIST(0xB3);

    private final int id;
    private static final Map<Integer, TlvType> ID_MAP = new HashMap<>();

    static {
        for (TlvType enumInstance : TlvType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    TlvType(int id) {
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
    public static TlvType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
