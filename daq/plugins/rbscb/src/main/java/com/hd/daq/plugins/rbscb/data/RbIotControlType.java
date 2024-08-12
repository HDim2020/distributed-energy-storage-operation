package com.hd.daq.plugins.rbscb.data;

/**
 * @author ymm
 */

public enum RbIotControlType {
    /**
     * 服务器发送
     */
    SERVER_TO_LINK(0X80),
    /**
     * 网关发送
     */
    LINK_TO_SERVER(0X81);

    private final int id;

    private RbIotControlType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static RbIotControlType typeFor(int id) {
        for (RbIotControlType type : RbIotControlType.values()) {
            if (type.getId() == id) {
                return type;
            }
        }

        return null;
    }
}
