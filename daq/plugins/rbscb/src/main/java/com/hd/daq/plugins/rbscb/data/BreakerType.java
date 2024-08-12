package com.hd.daq.plugins.rbscb.data;

/**
 * @author ymm
 */

public enum BreakerType {
    /**
     * 单相断路器
     */
    SINGLE_PHASE(0),
    /**
     * 三相断路器
     */
    THREE_PHASE(1);

    private final int id;

    private BreakerType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static BreakerType typeFor(int id) {
        for(BreakerType type : BreakerType.values()) {
            if (type.getId() == id) {
                return type;
            }
        }

        return null;
    }
}
