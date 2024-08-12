package com.hd.daq.transportapi.queue.kafka;

import com.hd.daq.transportapi.queue.TbQueueCallback;
import com.hd.daq.transportapi.queue.TbQueueAdmin;
import com.hd.daq.transportapi.queue.TbQueueMsg;
import com.hd.daq.transportapi.queue.TbQueueProducer;
import com.hd.daq.transportapi.queue.common.TopicPartitionInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author ymm
 */
@Slf4j
public class TbKafkaProducerTemplate<T extends TbQueueMsg> implements TbQueueProducer<T> {

    private final KafkaProducer<String, byte[]> producer;

    @Getter
    private final String defaultTopic;

    @Getter
    private final TbKafkaSettings settings;

    private final TbQueueAdmin admin;

    private final Set<TopicPartitionInfo> topics;

    @Builder
    private TbKafkaProducerTemplate(TbKafkaSettings settings, String defaultTopic, String clientId, TbQueueAdmin admin) {
        Properties props = settings.toProducerProps();

        if (StringUtils.hasLength(clientId)) {
            props.put(ProducerConfig.CLIENT_ID_CONFIG, clientId);
        }
        this.settings = settings;
        this.producer = new KafkaProducer<>(props);
        this.defaultTopic = defaultTopic;
        this.admin = admin;
        topics = ConcurrentHashMap.newKeySet();
    }

    @Override
    public void init() {
    }

    @Override
    public void send(TopicPartitionInfo tpi, T msg, TbQueueCallback callback) {
        createTopicIfNotExist(tpi);
        String key = msg.getKey().toString();
        byte[] data = msg.getData();
        ProducerRecord<String, byte[]> record;
        record = new ProducerRecord<>(tpi.getFullTopicName(), key, data);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                if (callback != null) {
                    callback.onSuccess(new KafkaTbQueueMsgMetadata(metadata));
                }
            } else {
                if (callback != null) {
                    callback.onFailure(exception);
                } else {
                    log.warn("Producer template failure: {}", exception.getMessage(), exception);
                }
            }
        });
    }

    @Override
    public void send(TopicPartitionInfo tpi, List<T> msgList, TbQueueCallback callback) {
        boolean success = true;
        Throwable throwable = null;
        createTopicIfNotExist(tpi);
        for (T msg : msgList) {
            ProducerRecord<String, byte[]> record = new ProducerRecord<>(tpi.getFullTopicName(), msg.getKey().toString(), msg.getData());
            Future<RecordMetadata> future = producer.send(record, null);
            try {
                future.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                success = false;
                throwable = e;
                break;
            }
        }
        if (callback != null) {
            if (success)
            {
                callback.onSuccess(null);
            } else {
                callback.onFailure(throwable);
            }
        }
    }

    private void createTopicIfNotExist(TopicPartitionInfo tpi) {
        if (topics.contains(tpi)) {
            return;
        }
        admin.createTopicIfNotExists(tpi.getFullTopicName());
        topics.add(tpi);
    }

    @Override
    public void stop() {
        if (producer != null) {
            producer.close();
        }
    }
}
