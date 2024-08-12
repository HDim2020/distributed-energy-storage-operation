package com.hd.daq.plugins.shike.iot.hex;

import com.hd.daq.plugins.shike.exception.DecodeException;
import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.ContentType;
import com.hd.daq.plugins.shike.iot.IDataContent;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16进制报文内容
 * @author ymm
 */
@Builder
@Getter
public class HexDataContent implements IDataContent {
    /**
     * TLV结构集合
     */
    private List<Tlv> tlvList;
    /**
     * 解码成实体对象
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static HexDataContent decode(byte[] buf) throws DecodeException {
        // 得到TLV结构集合
        List<Tlv> tlvList = new ArrayList<>();
        int offset = 0;
        while (offset < buf.length) {
            Tlv tlv = Tlv.decode(buf, offset);
            if (tlv == null) {
                break;
            }
            offset += tlv.getTlvSize();
            tlvList.add(tlv);
        }
        return HexDataContent.builder().tlvList(tlvList).build();
    }
    /**
     * 获取内容类型
     *
     * @return 内容类型枚举值
     */
    @Override
    public ContentType getContentType() {
        return ContentType.CT_HEX_DATA;
    }
    /**
     * 编码数据内容为字符数组
     *
     * @return 字符数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        byte[] dest = null;
        for (Tlv tlv: tlvList) {
            byte[] bytes = tlv.encode();
            if (dest != null) {
                // 扩充缓冲区空间
                dest = Arrays.copyOf(dest, dest.length + bytes.length);
                // 拷贝数据到缓冲区尾部
                System.arraycopy(bytes, 0, dest, dest.length, bytes.length);
            } else {
                dest = bytes;
            }
        }
        return dest;
    }
}
