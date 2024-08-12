package com.hd.daq.plugins.hdlink.data;

public class MqttTopics {

    private static final String REQUEST = "/post";
    private static final String RESPONSE = "/reply";
    private static final String SERVICE = "/service";
    private static final String EVENT = "/event";
    private static final String PROPERTY = "/property";
    private static final String COLLECTOR_ID = "{collectorId}";

    private static final String PROPERTY_REQUEST = PROPERTY + REQUEST;
    private static final String PROPERTY_RESPONSE = PROPERTY + RESPONSE;

    private static final String EVENT_REQUEST = EVENT  +  REQUEST;
    private static final String EVENT_RESPONSE = EVENT + RESPONSE;

    private static final String SERVICE_REQUEST = SERVICE  + REQUEST;
    private static final String SERVICE_RESPONSE = SERVICE + RESPONSE;


    // V1_JSON topics

    private static final String BASE_DEVICE_API_TOPIC = "v1/hdgw/" + COLLECTOR_ID;

    private static final String DEVICE_PROPERTY_REQUESTS_TOPIC = BASE_DEVICE_API_TOPIC + PROPERTY_REQUEST;
    private static final String DEVICE_PROPERTY_REQUESTS_TOPIC_PREFIX = BASE_DEVICE_API_TOPIC + EVENT + PROPERTY;
    private static final String DEVICE_PROPERTY_RESPONSE_TOPIC = BASE_DEVICE_API_TOPIC + PROPERTY_RESPONSE;
    private static final String DEVICE_EVENT_REQUESTS_TOPIC = BASE_DEVICE_API_TOPIC + EVENT_REQUEST;
    private static final String DEVICE_EVENT_RESPONSE_TOPIC = BASE_DEVICE_API_TOPIC + EVENT_RESPONSE;
    private static final String DEVICE_SERVICE_REQUESTS_TOPIC = BASE_DEVICE_API_TOPIC + SERVICE_REQUEST;
    private static final String DEVICE_SERVICE_RESPONSE_TOPIC = BASE_DEVICE_API_TOPIC + SERVICE_RESPONSE;

    /**
     * 判断是否属性请求主题
     * @param topic 待判断主题
     * @param collectorId 采集器ID
     * @return 是否属性主题
     */
    public static boolean isPropertyRequest(String topic, String collectorId) {
        String propertyTopic = DEVICE_PROPERTY_REQUESTS_TOPIC.replace(COLLECTOR_ID, collectorId);
        return propertyTopic.equals(topic);
    }

    public static boolean isEventRequest(String topic, String collectorId) {
        String eventTopic = DEVICE_EVENT_REQUESTS_TOPIC.replace(COLLECTOR_ID, collectorId);
        return eventTopic.equals(topic);
    }

    public static boolean isServiceResponse(String topic, String collectorId) {
        String serviceTopic = DEVICE_SERVICE_RESPONSE_TOPIC.replace(COLLECTOR_ID, collectorId);
        return serviceTopic.equals(topic);
    }

    public static String getServiceRequestTopic(String collectorId) {
        return DEVICE_SERVICE_REQUESTS_TOPIC.replace(COLLECTOR_ID, collectorId);
    }

    private MqttTopics() {
    }
}
