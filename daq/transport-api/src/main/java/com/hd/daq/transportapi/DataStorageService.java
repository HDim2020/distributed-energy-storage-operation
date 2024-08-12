package com.hd.daq.transportapi;

import com.hd.daq.transportapi.data.thing.EventMsg;
import com.hd.daq.transportapi.data.thing.PropertyMsg;
import com.hd.daq.transportapi.data.thing.ResponseMsg;
import com.hd.daq.transportapi.proto.TransportProtos;

/**
 * 数据存储服务接口
 *
 * @author ymm
 */
public interface DataStorageService {
    /**
     * 处理属性消息
     *
     * @param sessionInfo 会话信息实体对象
     * @param msg         属性消息实体对象
     * @param callback    回调
     */
    void processPropertyMsg(TransportProtos.SessionInfoProto sessionInfo, PropertyMsg msg, TransportServiceCallback<Void> callback);

    /**
     * 处理事件消息
     *
     * @param sessionInfo 会话信息实体对象
     * @param msg         事件消息实体对象
     * @param callback    回调
     */
    void processEventMsg(TransportProtos.SessionInfoProto sessionInfo, EventMsg msg, TransportServiceCallback<Void> callback);

    /**
     * 处理响应消息(设备上行)
     *
     * @param sessionInfo 会话信息实体对象
     * @param msg         响应消息
     * @param callback    回调
     */
    void processResponseMsg(TransportProtos.SessionInfoProto sessionInfo, ResponseMsg msg, TransportServiceCallback<Void> callback);

    /**
     * 处理设备消息(设备主动上行)
     *
     * @param sessionInfo 会话信息实体对象
     * @param msg         设备消息
     * @param callback    回调
     */
    void processDeviceMsg(TransportProtos.SessionInfoProto sessionInfo, ResponseMsg msg, TransportServiceCallback<Void> callback);

    /**
     * 获取设备类型码
     *
     * @param uid 设备ID
     * @return 设备类型码
     */
    Integer getDeviceTypeCode(String uid);
}
