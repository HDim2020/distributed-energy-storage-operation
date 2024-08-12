package com.hd.daq.plugins.shike.iot.hex.ie.ac;

import lombok.Builder;
import lombok.Getter;

/**
 * 空调组合指令
 *
 * @author ymm
 */
@Builder
@Getter
public class IeAirConditionCombinationCmd {
    /**
     * 组合命令方法名称
     */
    private int cmdCode;
    /**
     * 指令
     */
    private int instruct;
}
