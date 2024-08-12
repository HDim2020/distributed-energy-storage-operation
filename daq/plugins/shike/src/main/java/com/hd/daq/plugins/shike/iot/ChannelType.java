package com.hd.daq.plugins.shike.iot;

import java.util.HashMap;
import java.util.Map;

/**
 * 通道类型
 *
 * @author ymm
 */

public enum ChannelType {

    /**
     * GPRS
     */
    GPRS(0),
    /**
     * WIFI
     */
    WIFI(1),
    /**
     * 有线
     */
    WIRED(2),
    /**
     * NBIOT
     */
    NBIOT(3),
    /**
     * 4G
     */
    G4(4),
    /**
     * 5G
     */
    G5(5);

    private final int id;
    private static final Map<Integer, ChannelType> ID_MAP = new HashMap<>();

    static {
        for (ChannelType enumInstance : ChannelType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    ChannelType(int id) {
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
    public static ChannelType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
