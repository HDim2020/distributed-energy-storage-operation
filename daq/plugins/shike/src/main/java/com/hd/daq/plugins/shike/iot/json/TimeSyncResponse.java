package com.hd.daq.plugins.shike.iot.json;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.nio.charset.StandardCharsets;

/**
 * 响应同步时间(服务器下行)
 *
 * @author ymm
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class TimeSyncResponse extends JsonMessage {
    @SerializedName("t")
    private long timestamp;

    /**
     * 默认构造器
     */
    public TimeSyncResponse() {
        this(System.currentTimeMillis());
    }

    /**
     * 构造器
     *
     * @param timestamp 时间戳
     */
    public TimeSyncResponse(long timestamp) {
        this.cmd = JsonCmdType.CMD_TIME_SYNC_RESPONSE.getId();
        this.timestamp = timestamp / 1000;
    }

    /**
     * 编码成字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        return new Gson().toJson(this).getBytes(StandardCharsets.UTF_8);
    }
}
