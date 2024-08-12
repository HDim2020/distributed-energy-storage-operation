package com.hd.daq.transportapi.data.thing;

import lombok.Data;

/**
 * 物联回复消息
 * @author ymm
 */
@Data
public class ResponseMsg implements ThingMsg {
    /**
     * 消息ID
     */
    private String id;
    /**
     * 采集器编号
     */
    private String collectorId;
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误消息
     */
    private String message;
    /**
     * 方法名
     */
    private String method;
    /**
     * 时间戳
     */
    private long timeStamp;
    /**
     * 要返回的数据
     */
    private Object data;

    public ResponseMsg() {
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public FunctionType getFunctionType() {
        return FunctionType.SERVICE;
    }
}
