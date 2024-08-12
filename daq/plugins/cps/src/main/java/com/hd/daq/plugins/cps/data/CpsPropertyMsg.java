package com.hd.daq.plugins.cps.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 采集数据上报
 * @author ymm
 */
@Data
public class CpsPropertyMsg {
    private Long ts;
    private Map<String, BigDecimal> d;
}
