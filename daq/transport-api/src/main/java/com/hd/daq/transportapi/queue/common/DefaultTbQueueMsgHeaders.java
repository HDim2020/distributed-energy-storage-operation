package com.hd.daq.transportapi.queue.common;


import com.hd.daq.transportapi.queue.TbQueueMsgHeaders;

import java.util.HashMap;
import java.util.Map;

public class DefaultTbQueueMsgHeaders implements TbQueueMsgHeaders {

    protected final Map<String, byte[]> data = new HashMap<>();

    @Override
    public byte[] put(String key, byte[] value) {
        return data.put(key, value);
    }

    @Override
    public byte[] get(String key) {
        return data.get(key);
    }

    @Override
    public Map<String, byte[]> getData() {
        return data;
    }
}
