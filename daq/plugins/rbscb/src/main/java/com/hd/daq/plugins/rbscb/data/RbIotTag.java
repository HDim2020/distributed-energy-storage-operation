package com.hd.daq.plugins.rbscb.data;

import lombok.Data;

/**
 * @author ymm
 */
@Data
public class RbIotTag {
    /**
     * 变量编码
     */
    private String tagId;
    /**
     * 描述
     */
    private String description;
    /**
     * 数值
     */
    private String tagVal;
    /**
     * 数据时间戳
     */
    private long ts;
}
