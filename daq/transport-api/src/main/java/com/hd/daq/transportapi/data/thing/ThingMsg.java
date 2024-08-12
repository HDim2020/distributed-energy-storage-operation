package com.hd.daq.transportapi.data.thing;

/**
 * @author ymm
 */
public interface ThingMsg {
    /**
     * 获取功能类型
     * @return
     */
    FunctionType getFunctionType();

    /**
     * 获取采集器ID
     * @return
     */
    String getCollectorId();

    /**
     * 设置采集器ID
     * @param id
     */
    void setCollectorId(String id);
}
