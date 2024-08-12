package com.hd.daq.plugins.shike.iot.json;

import com.google.gson.annotations.SerializedName;
import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.ContentType;
import com.hd.daq.plugins.shike.iot.IDataContent;
import lombok.Data;

/**
 * JSON类型消息基类
 * @author ymm
 */
@Data
public class JsonMessage implements IDataContent {
    /**
     * 命令码
     */
    @SerializedName("o")
    protected int cmd;

    /**
     * 获取内容类型
     *
     * @return 内容类型枚举值
     */
    @Override
    public ContentType getContentType() {
        return ContentType.CT_JSON_DATA;
    }

    /**
     * 编码数据内容为字符数组
     *
     * @return 字符数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        throw new EncodeException();
    }
}
