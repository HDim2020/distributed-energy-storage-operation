package com.hd.daq.mqtt.service;

import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.transportapi.DataStorageService;
import com.hd.daq.transportapi.TransportServiceCallback;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import com.hd.daq.transportapi.data.thing.ThingMsg;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttPublishMessage;

import java.util.Optional;


/**
 * 协议插件接口
 * @author ymm
 * @version 1.0
 * @since 2022-09-21
 */
public interface ProtocolPlugin {
    /**
     * 处理设备到平台的消息
     * @param ctx 设备会话上下文
     * @param msg 发布的消息
     * @param dataStorageService 存储服务
     * @param callback 回调函数，用来通知处理结果
     */
    void processDevicePublishMessage(DeviceSessionCtx ctx, MqttPublishMessage msg, DataStorageService dataStorageService, TransportServiceCallback<Void> callback);

    /**
     * 处理服务请求
     * @param ctx 设备会话上下文
     * @param msg 服务请求消息
     * @param dataStorageService 存储服务
     * @param callback 回调函数，用来通知处理结果
     */
    void processServiceRequest(DeviceSessionCtx ctx, ServiceRequestMsg msg, DataStorageService dataStorageService, TransportServiceCallback<Void> callback);

}
