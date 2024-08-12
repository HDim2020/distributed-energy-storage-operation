package com.hd.daq.transportapi.queue.common;

import com.google.gson.Gson;
import com.hd.daq.transportapi.queue.TbQueueMsg;
import com.hd.daq.transportapi.queue.TbQueueMsgHeaders;

import java.util.UUID;

/**JSON格式队列消息包装类
 * @author ymm
 */
public class TbJsonQueueMsg<T> implements TbQueueMsg {
    private static final Gson GSON = new Gson();
    private final UUID key;
    protected final T value;
    private final TbQueueMsgHeaders headers;

    public TbJsonQueueMsg(UUID key, T value) {
        this(key, value, new DefaultTbQueueMsgHeaders());
    }

    public TbJsonQueueMsg(UUID key, T value, TbQueueMsgHeaders headers) {
        this.key = key;
        this.value = value;
        this.headers = headers;
    }

    public T getValue() {
        return value;
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
        return GSON.toJson(value).getBytes();
    }
}
