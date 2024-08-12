package com.hd.daq.plugins.shike.iot.json;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.hd.daq.plugins.shike.exception.EncodeException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.nio.charset.StandardCharsets;

/**
 * 请求同步时间(设备上行)
 *
 * @author ymm
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TimeSyncRequest extends JsonMessage {
    @SerializedName("t")
    private long timestamp;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体
     */
    public static TimeSyncRequest decode(byte[] buf) {
        String s = new String(buf, StandardCharsets.UTF_8);
        return new Gson().fromJson(s, TimeSyncRequest.class);
    }

    /**
     * 编码成字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        throw new EncodeException();
    }
}
