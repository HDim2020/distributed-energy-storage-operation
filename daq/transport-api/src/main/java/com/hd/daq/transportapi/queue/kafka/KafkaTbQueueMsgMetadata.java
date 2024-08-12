package com.hd.daq.transportapi.queue.kafka;

import com.hd.daq.transportapi.queue.TbQueueMsgMetadata;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Kafka队列消息元数据
 * @author ymm
 */
@Data
@AllArgsConstructor
public class KafkaTbQueueMsgMetadata implements TbQueueMsgMetadata {
    private RecordMetadata metadata;
}
