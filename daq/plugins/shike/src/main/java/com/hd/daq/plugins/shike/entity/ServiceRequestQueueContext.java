package com.hd.daq.plugins.shike.entity;

import com.hd.daq.transportapi.DataStorageService;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 服务请求队列上下文
 *
 * @author ymm
 */

public class ServiceRequestQueueContext {
    /**
     * 优先级队列
     */
    @Getter
    private final PriorityBlockingQueue<ServiceRequestQueueMsg> queue;
    /**
     * 数据存储服务
     */
    @Getter
    private final DataStorageService storage;
    /**
     * 下一次发送时间
     */
    @Getter
    @Setter
    private long nextSendTime;

    public ServiceRequestQueueContext(DataStorageService storage) {
        queue = new PriorityBlockingQueue<>();
        this.storage = storage;
    }
}
