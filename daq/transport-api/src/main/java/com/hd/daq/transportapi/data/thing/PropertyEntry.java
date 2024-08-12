package com.hd.daq.transportapi.data.thing;

import lombok.Builder;
import lombok.Data;

/**
 * 属性记录
 * @author ymm
 */
@Builder
@Data
public class PropertyEntry {
    /**
     * 属性编码
     */
    private String propId;
    /**
     * 数据时间戳
     */
    private long ts;
    /**
     * 属性值
     */
    private String propValue;
}
