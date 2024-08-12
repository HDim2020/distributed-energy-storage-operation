package com.hd.daq.transportapi.data.thing;

import lombok.Data;

/**
 * 事件数据
 * @author ymm
 */
@Data
public class EventMsg implements ThingMsg {
    /**
     * 消息ID
     */
    private String id;
    /**
     * 采集器编码
     */
    private String collectorId;
    /**
     * 事件标识
     */
    private String eventId;
    /**
     * 参数
     */
    private Object params;

    @Override
    public FunctionType getFunctionType() {
        return FunctionType.EVENT;
    }
}
