package com.hd.daq.plugins.shike.iot;

import com.hd.daq.plugins.shike.exception.EncodeException;

/**
 * 可编码接口
 *
 * @author ymm
 */
public interface IEncodable {
    /**
     * 编码实体对象为字节数组
     * @return 字节数组
     * @throws EncodeException 不支持编码操作时会抛出异常
     */
    byte[] encode() throws EncodeException;
}
