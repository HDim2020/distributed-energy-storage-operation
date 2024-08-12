package com.hd.daq.transportapi.data;

import lombok.Builder;
import lombok.Data;

/**
 * @author ymm
 */
@Data
@Builder
public class PropertyDataEntity {
    /**
     * 采集器编号
     */
    private String collectorId;
    /**
     * 变量编码
     */
    private String tagId;
    /**
     * 数据时间戳
     */
    private long ts;
    /**
     * 数值
     */
    private String tagVal;
}
