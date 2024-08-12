package com.hd.daq.plugins.cps.data;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 控制数据下发请求
 * @author ymm
 */
@Builder
@Getter
public class CpsServiceRequest {
    private long ts;
    Map<String, BigDecimal> w;
}
