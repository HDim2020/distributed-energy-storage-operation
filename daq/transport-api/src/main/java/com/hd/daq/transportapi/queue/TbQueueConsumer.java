package com.hd.daq.transportapi.queue;

import com.hd.daq.transportapi.queue.common.TopicPartitionInfo;

import java.util.List;
import java.util.Set;

/**
 * 队列消费者接口
 * @author ymm
 */
public interface TbQueueConsumer<T extends TbQueueMsg> {

    String getTopic();

    void subscribe();

    void subscribe(Set<TopicPartitionInfo> partitions);

    void unsubscribe();

    List<T> poll(long durationInMillis);

    void commit();

}
