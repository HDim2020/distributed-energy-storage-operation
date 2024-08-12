package com.hd.daq.plugins.shike.adaptor.ac;

import lombok.Data;

/**
 * 空调组合指令
 *
 * @author ymm
 */
@Data
public class AirConditionCombinationCmd {
    /**
     * 组合命令方法名称
     */
    private String combinationMethod;
    /**
     * 指令
     */
    private int instruct;
}
