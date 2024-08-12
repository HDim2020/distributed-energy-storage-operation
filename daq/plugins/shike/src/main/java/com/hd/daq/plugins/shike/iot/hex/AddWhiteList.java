package com.hd.daq.plugins.shike.iot.hex;

import com.hd.daq.plugins.shike.util.ByteArrayUtil;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 增加白名单格式
 *
 * @author ymm
 */
@Builder
@Getter
public class AddWhiteList implements ITlvValue {
    /**
     * 白名单列表
     * 每项：7B设备ID+1B类型码
     */
    List<String> whiteList;

    /**
     * 获取TLV结构的类型码
     *
     * @return
     */
    @Override
    public TlvType getTlvType() {
        return TlvType.ADD_WHITELIST;
    }

    /**
     * 编码实体对象为字节数组（服务器下行）
     *
     * @return 字节数组
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
}
