package com.hd.daq.mqtt.session;

import com.hd.daq.mqtt.MqttTransportContext;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DeviceSessionCtx extends MqttDeviceAwareSessionContext {

    @Getter
    private ChannelHandlerContext channel;

    @Getter
    private MqttTransportContext context;

    private final AtomicInteger msgIdSeq = new AtomicInteger(0);

    public DeviceSessionCtx(UUID sessionId, ConcurrentMap<MqttTopicMatcher, Integer> mqttQoSMap, MqttTransportContext context) {
        super(sessionId, mqttQoSMap);
        this.context = context;
    }

    public void setChannel(ChannelHandlerContext channel) {
        this.channel = channel;
    }

    @Override
    public int nextMsgId() {
        return msgIdSeq.incrementAndGet();
    }
}




