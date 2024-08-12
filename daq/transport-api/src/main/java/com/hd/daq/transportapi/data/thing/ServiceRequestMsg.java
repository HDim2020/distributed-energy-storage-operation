package com.hd.daq.transportapi.data.thing;

import lombok.Data;

/**
 * 服务数据
 * @author ymm
 */
@Data
public class ServiceRequestMsg implements ThingMsg {
    /**
     * UUID
     */
    private String id;
    /**
     * 采集器编号
     */
    private String collectorId;
    /**
     * 方法名(用来区别不同的服务请求)
     */
    private String method;
    /**
     * 参数
     */
    private Object params;
    /**
     * 过期时间
     */
    private long expiredTime;
    /**
     * 优先级值，默认是0，优先级值越小越优先
     */
    private int priority;

    @Override
    public FunctionType getFunctionType() {
        return FunctionType.SERVICE;
    }
}
