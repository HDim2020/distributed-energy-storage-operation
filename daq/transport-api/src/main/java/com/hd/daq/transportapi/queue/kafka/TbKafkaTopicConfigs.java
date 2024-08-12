package com.hd.daq.transportapi.queue.kafka;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ymm
 */
@Component
public class TbKafkaTopicConfigs {
    @Value("${queue.kafka.topic-properties.transport-api}")
    private String transportApiProperties;


    @Getter
    private Map<String, String> transportApiConfigs;

    @PostConstruct
    private void init() {
        transportApiConfigs = getConfigs(transportApiProperties);
    }

    private Map<String, String> getConfigs(String properties) {
        Map<String, String> configs = new HashMap<>();
        for (String property : properties.split(";")) {
            int delimiterPosition = property.indexOf(":");
            String key = property.substring(0, delimiterPosition);
            String value = property.substring(delimiterPosition + 1);
            configs.put(key, value);
        }
        return configs;
    }
}
