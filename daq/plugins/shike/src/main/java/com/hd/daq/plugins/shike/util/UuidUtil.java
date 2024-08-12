package com.hd.daq.plugins.shike.util;

import java.util.UUID;

/**
 * UUID帮助类
 * @author ymm
 */
public class UuidUtil {
    /**
     * 生成新的ID
     * @return 新ID
     */
    public static String newId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
