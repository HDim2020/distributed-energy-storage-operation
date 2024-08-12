package com.hd.daq.plugins.shike.iot;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 时刻心跳消息格式
 * @author ymm
 */
@Builder
@Data
public class HeartBeatMessage implements IDataContent {
    /**
     * 命令编码
     */
    @SerializedName("o")
    int cmd;
    /**
     * 状态
     */
    @SerializedName("s")
    List<Integer> status;
    /**
     * 联网状态
     */
    @SerializedName("L")
    List<Integer> link;
    /**
     * 信号强度
     */
    @SerializedName("i")
    List<Integer> signalIntensity;
    /**
     * 版本号
     */
    @SerializedName("V")
    String version;
    /**
     * 白名单校验
     */
    @SerializedName("WL")
    List<Integer> whiteList;

    /**
     * 解码成实体对象
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static HeartBeatMessage decode(byte[] buf) {
        String s = new String(buf, StandardCharsets.UTF_8);
        return new Gson().fromJson(s, HeartBeatMessage.class);
    }

    @Override
    public ContentType getContentType() {
        return ContentType.CT_HEARTBEAT;
    }
    /**
     * 编码成字节数组
     * @return 编码后的字节数组
     */
    @Override
    public byte[] encode() {
        return new Gson().toJson(this).getBytes(StandardCharsets.UTF_8);
    }
}
