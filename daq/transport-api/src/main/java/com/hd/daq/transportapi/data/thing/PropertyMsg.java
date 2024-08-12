package com.hd.daq.transportapi.data.thing;

import lombok.Data;

import java.util.List;


/**
 * 属性类物消息
 * @author ymm
 */
@Data
public class PropertyMsg implements ThingMsg {
    /**
     * 采集器编号
     */
    private String collectorId;
    /**
     * 属性集合
     */
    private List<PropertyEntry> params;

    @Override
    public FunctionType getFunctionType() {
        return FunctionType.PROPERTY;
    }
}
