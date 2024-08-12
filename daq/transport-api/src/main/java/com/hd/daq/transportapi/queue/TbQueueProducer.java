package com.hd.daq.transportapi.queue;

import com.hd.daq.transportapi.queue.common.TopicPartitionInfo;

import java.util.List;

/**
 * @author ymm
 */
public interface TbQueueProducer<T extends TbQueueMsg> {

    void init();

    String getDefaultTopic();

    void send(TopicPartitionInfo tpi, T msg, TbQueueCallback callback);
    void send(TopicPartitionInfo tpi, List<T> msgList, TbQueueCallback callback);

    void stop();
}
