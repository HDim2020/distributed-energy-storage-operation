package com.hd.daq.plugins.shike.iot.hex.ie;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.iot.hex.TlvType;
import lombok.Builder;
import lombok.Getter;

/**
 * 清空白名单信息体元素（服务器下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerClearWhiteList implements IInformationElement {
    /**
     * 编码信息体元素
     *
     * @return 字符串数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        throw new EncodeException();
    }

    @Override
    public int getCmdCode() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TlvType getTlvType() {
        return TlvType.CLEAR_WHITELIST;
    }

    /**
     * 获取消息存储类型
     *
     * @return 多个存储类型的并集
     */
    @Override
    public int getMessageStorageType() {
        return 0;
    }
}
