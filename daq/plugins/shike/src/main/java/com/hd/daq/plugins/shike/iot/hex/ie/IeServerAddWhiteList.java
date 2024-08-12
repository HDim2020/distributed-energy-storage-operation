package com.hd.daq.plugins.shike.iot.hex.ie;

import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.iot.hex.TlvType;
import com.hd.daq.plugins.shike.util.ByteArrayUtil;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 增加白名单信息体元素（服务器下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerAddWhiteList implements IInformationElement {
    /**
     * 白名单列表
     * 每项：7B设备ID+1B类型码
     */
    List<String> whiteList;

    /**
     * 编码信息体元素
     *
     * @return 字符串数组
     */
    @Override
    public byte[] encode() {
        byte[] dest = new byte[whiteList.size() * 8];
        int offset = 0;
        for (String item : whiteList) {
            ByteArrayUtil.hexStringToBytes(item, dest, offset);
            offset += 8;
        }

        return dest;
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

    /**
     * 获取TLV类型
     *
     * @return TLV类型
     */
    @Override
    public TlvType getTlvType() {
        return TlvType.ADD_WHITELIST;
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
