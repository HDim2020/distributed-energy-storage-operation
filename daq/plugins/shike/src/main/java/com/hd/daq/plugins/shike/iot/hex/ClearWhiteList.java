package com.hd.daq.plugins.shike.iot.hex;

import lombok.Builder;
import lombok.Getter;

/**
 * 清除白名单格式
 *
 * @author ymm
 */
@Builder
@Getter
public class ClearWhiteList implements ITlvValue {
    /**
     * 获取TLV结构的类型码
     *
     * @return
     */
    @Override
    public TlvType getTlvType() {
        return TlvType.CLEAR_WHITELIST;
    }

    /**
     * 编码实体对象为字节数组（服务器下行）
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
