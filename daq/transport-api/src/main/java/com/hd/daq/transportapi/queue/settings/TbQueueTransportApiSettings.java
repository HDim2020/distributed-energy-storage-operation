package com.hd.daq.transportapi.queue.settings;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ymm
 */
@Data
@Component
public class TbQueueTransportApiSettings {

    @Value("${queue.transport_api.service_request_topic}")
    private String serviceRequestTopic;

    @Value("${queue.transport_api.service_response_topic}")
    private String serviceResponseTopic;

    @Value("${queue.transport_api.property_topic}")
    private String propertyTopic;

    @Value("${queue.transport_api.event_topic}")
    private String eventTopic;

    @Value("${queue.transport_api.device_message_topic}")
    private String deviceMessageTopic;

    @Value("${queue.transport_api.max_pending_requests}")
    private int maxPendingRequests;

    @Value("${queue.transport_api.max_requests_timeout}")
    private int maxRequestsTimeout;

    @Value("${queue.transport_api.max_callback_threads}")
    private int maxCallbackThreads;

    @Value("${queue.transport_api.request_poll_interval}")
    private long requestPollInterval;

    @Value("${queue.transport_api.response_poll_interval}")
    private long responsePollInterval;
}
