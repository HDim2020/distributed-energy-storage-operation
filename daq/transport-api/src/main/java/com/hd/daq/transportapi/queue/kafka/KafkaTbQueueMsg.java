package com.hd.daq.transportapi.queue.kafka;

import com.hd.daq.transportapi.queue.TbQueueMsg;
import com.hd.daq.transportapi.queue.TbQueueMsgHeaders;
import com.hd.daq.transportapi.queue.common.DefaultTbQueueMsgHeaders;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.util.UUID;

/** Kafka队列消息
 * @author ymm
 */
public class KafkaTbQueueMsg implements TbQueueMsg {
    private final UUID key;
    private final TbQueueMsgHeaders headers;
    private final byte[] data;

    public KafkaTbQueueMsg(ConsumerRecord<String, byte[]> record) {
        UUID tempKey;
        try {
            tempKey = UUID.fromString(record.key());
        } catch (Throwable ignored) {
            tempKey = UUID.randomUUID();
        }
        this.key = tempKey;
        TbQueueMsgHeaders headers = new DefaultTbQueueMsgHeaders();
        record.headers().forEach(header -> {
            headers.put(header.key(), header.value());
        });
        this.headers = headers;
        this.data = record.value();
    }

    @Override
    public UUID getKey() {
        return key;
    }

    @Override
    public TbQueueMsgHeaders getHeaders() {
        return headers;
    }

    @Override
    public byte[] getData() {
        return data;
    }
}
