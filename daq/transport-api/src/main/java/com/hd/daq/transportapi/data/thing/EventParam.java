package com.hd.daq.transportapi.data.thing;

import lombok.Data;

import java.util.Map;

/**
 * 事件参数
 * @author ymm
 */
@Data
public class EventParam {
    private Map<String, String> value;
    private long ts;
}
