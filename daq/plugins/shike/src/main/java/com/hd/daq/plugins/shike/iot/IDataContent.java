package com.hd.daq.plugins.shike.iot;

import com.hd.daq.plugins.shike.exception.EncodeException;

/**
 * 数据内容接口
 *
 * @author ymm
 */
public interface IDataContent {
    /**
     * 获取内容类型
     *
     * @return 内容类型枚举值
     */
    ContentType getContentType();

    /**
     * 编码数据内容为字符数组
     *
     * @return 字符数组
     */
    byte[] encode() throws EncodeException;
}
