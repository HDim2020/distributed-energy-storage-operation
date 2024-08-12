package com.hd.daq.transportapi.queue.kafka;



import com.hd.daq.transportapi.queue.TbQueueMsg;

import java.io.IOException;

/**
 * kafka消息解码器接口
 * @author ymm
 */
public interface TbKafkaDecoder<T> {
    /**
     * 将队列消息解码成实体
     * @param msg 队列消息
     * @return 实体
     * @throws IOException
     */
    T decode(TbQueueMsg msg) throws IOException;
}
