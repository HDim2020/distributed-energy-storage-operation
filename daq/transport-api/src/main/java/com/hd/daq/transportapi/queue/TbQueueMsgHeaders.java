package com.hd.daq.transportapi.queue;

import java.util.Map;

/**
 * @author ymm
 */
public interface TbQueueMsgHeaders {

    byte[] put(String key, byte[] value);

    byte[] get(String key);

    Map<String, byte[]> getData();
}
