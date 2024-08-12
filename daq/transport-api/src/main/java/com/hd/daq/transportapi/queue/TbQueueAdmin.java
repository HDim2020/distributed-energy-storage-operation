package com.hd.daq.transportapi.queue;

public interface TbQueueAdmin {

    void createTopicIfNotExists(String topic);

    void destroy();
}
