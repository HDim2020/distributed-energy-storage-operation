package com.hd.daq.mqtt.util;

public interface MqttTopicFilter {

    boolean filter(String topic);

}
