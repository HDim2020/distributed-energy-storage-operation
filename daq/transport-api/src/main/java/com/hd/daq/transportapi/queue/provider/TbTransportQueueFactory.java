package com.hd.daq.transportapi.queue.provider;

import com.hd.daq.transportapi.queue.common.TbJsonQueueMsg;
import com.hd.daq.transportapi.data.PropertyDataEntity;
import com.hd.daq.transportapi.data.thing.EventMsg;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import com.hd.daq.transportapi.data.thing.ResponseMsg;
import com.hd.daq.transportapi.queue.TbQueueConsumer;
import com.hd.daq.transportapi.queue.TbQueueProducer;

/**
 * @author ymm
 */
public interface TbTransportQueueFactory {

    /** 创建属性消息生产者
     * @return 生产者实例
     */
    TbQueueProducer<TbJsonQueueMsg<PropertyDataEntity>> createPropertyMsgProducer();

    /**
     * 创建事件消息生产者
     * @return 生产者实例
     */
    TbQueueProducer<TbJsonQueueMsg<EventMsg>> createEventMsgProducer();

    /**
     * 创建服务响应生产者
     * @return 生产者实例
     */
    TbQueueProducer<TbJsonQueueMsg<ResponseMsg>> createServiceResponseProducer();

    /**
     * 创建设备消息主题生产者
     * @return 生产者实例
     */
    TbQueueProducer<TbJsonQueueMsg<ResponseMsg>> createDeviceMessageTopicProducer();

    /**
     * 创建服务请求消费者
     * @return
     */
    TbQueueConsumer<TbJsonQueueMsg<ServiceRequestMsg>> createServiceRequestConsumer();
}
