package com.hd.daq.transportapi.queue.provider;

import com.google.gson.Gson;
import com.hd.daq.transportapi.queue.TbQueueMsg;
import com.hd.daq.transportapi.queue.common.TbJsonQueueMsg;
import com.hd.daq.transportapi.data.PropertyDataEntity;
import com.hd.daq.transportapi.data.thing.EventMsg;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import com.hd.daq.transportapi.data.thing.ResponseMsg;
import com.hd.daq.transportapi.queue.TbQueueAdmin;
import com.hd.daq.transportapi.queue.TbQueueConsumer;
import com.hd.daq.transportapi.queue.TbQueueProducer;
import com.hd.daq.transportapi.queue.kafka.*;
import com.hd.daq.transportapi.queue.settings.TbQueueTransportApiSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ymm
 */
@Component
@Slf4j
public class KafkaTbTransportQueueFactory implements TbTransportQueueFactory {
    private final TbKafkaSettings kafkaSettings;
    private final TbQueueTransportApiSettings transportApiSettings;

    private final TbQueueAdmin transportApiAdmin;

    public KafkaTbTransportQueueFactory(TbKafkaSettings kafkaSettings,
                                        TbQueueTransportApiSettings transportApiSettings,
                                        TbKafkaTopicConfigs kafkaTopicConfigs) {
        this.kafkaSettings = kafkaSettings;
        this.transportApiSettings = transportApiSettings;

        this.transportApiAdmin = new TbKafkaAdmin(kafkaSettings, kafkaTopicConfigs.getTransportApiConfigs());
    }
    @Override
    public TbQueueProducer<TbJsonQueueMsg<PropertyDataEntity>> createPropertyMsgProducer() {
        TbKafkaProducerTemplate.TbKafkaProducerTemplateBuilder<TbJsonQueueMsg<PropertyDataEntity>> requestBuilder = TbKafkaProducerTemplate.builder();
        requestBuilder.settings(kafkaSettings);
        requestBuilder.clientId("transport-api-property");
        requestBuilder.defaultTopic(transportApiSettings.getPropertyTopic());
        requestBuilder.admin(transportApiAdmin);
        return requestBuilder.build();
    }

    @Override
    public TbQueueProducer<TbJsonQueueMsg<EventMsg>> createEventMsgProducer() {
        TbKafkaProducerTemplate.TbKafkaProducerTemplateBuilder<TbJsonQueueMsg<EventMsg>> requestBuilder = TbKafkaProducerTemplate.builder();
        requestBuilder.settings(kafkaSettings);
        requestBuilder.clientId("transport-api-event");
        requestBuilder.defaultTopic(transportApiSettings.getEventTopic());
        requestBuilder.admin(transportApiAdmin);
        return requestBuilder.build();
    }

    @Override
    public TbQueueProducer<TbJsonQueueMsg<ResponseMsg>> createServiceResponseProducer() {
        TbKafkaProducerTemplate.TbKafkaProducerTemplateBuilder<TbJsonQueueMsg<ResponseMsg>> requestBuilder = TbKafkaProducerTemplate.builder();
        requestBuilder.settings(kafkaSettings);
        requestBuilder.clientId("transport-api-service-response");
        requestBuilder.defaultTopic(transportApiSettings.getServiceResponseTopic());
        requestBuilder.admin(transportApiAdmin);
        return requestBuilder.build();
    }

    @Override
    public TbQueueProducer<TbJsonQueueMsg<ResponseMsg>> createDeviceMessageTopicProducer() {
        TbKafkaProducerTemplate.TbKafkaProducerTemplateBuilder<TbJsonQueueMsg<ResponseMsg>> requestBuilder = TbKafkaProducerTemplate.builder();
        requestBuilder.settings(kafkaSettings);
        requestBuilder.clientId("transport-api-device-message");
        requestBuilder.defaultTopic(transportApiSettings.getDeviceMessageTopic());
        requestBuilder.admin(transportApiAdmin);
        return requestBuilder.build();
    }

    @Override
    public TbQueueConsumer<TbJsonQueueMsg<ServiceRequestMsg>> createServiceRequestConsumer() {
        TbKafkaConsumerTemplate.TbKafkaConsumerTemplateBuilder<TbJsonQueueMsg<ServiceRequestMsg>> responseBuilder = TbKafkaConsumerTemplate.builder();
        responseBuilder.settings(kafkaSettings);
        responseBuilder.topic(transportApiSettings.getServiceRequestTopic());
        responseBuilder.clientId("transport-api-service-request");
        responseBuilder.groupId("transport-node-mqtt");
        responseBuilder.decoder(new TbKafkaDecoder<TbJsonQueueMsg<ServiceRequestMsg>>() {
            @Override
            public TbJsonQueueMsg<ServiceRequestMsg> decode(TbQueueMsg msg) throws IOException {
                Gson gson = new Gson();
                String json = new String(msg.getData(), StandardCharsets.UTF_8);
                ServiceRequestMsg serviceMsg = gson.fromJson(json, ServiceRequestMsg.class);
                return new TbJsonQueueMsg<>(msg.getKey(), serviceMsg, msg.getHeaders());
            }
        });
        responseBuilder.admin(transportApiAdmin);
        return responseBuilder.build();
    }
}
