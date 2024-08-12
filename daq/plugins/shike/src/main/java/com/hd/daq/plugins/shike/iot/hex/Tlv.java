package com.hd.daq.plugins.shike.iot.hex;

import com.hd.daq.plugins.shike.exception.DecodeException;
import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.IEncodable;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

/**
 * TLV格式
 *
 * @author ymm
 */
@Builder
@Getter
public class Tlv implements IEncodable {
    /**
     * 类型 1字节
     */
    private int type;
    /**
     * 长度 2字节
     */
    private int length;
    /**
     * 数值
     */
    private ITlvValue value;

    /**
     * 获取TLV结构的字节数
     *
     * @return TLV结构的字节数
     */
    public int getTlvSize() {
        return length + 3;
    }

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体
     */
    public static Tlv decode(byte[] buf, int offset) throws DecodeException {
        //判断缓冲区长度是否够
        if (buf.length - offset < 3) {
            throw new DecodeException("TLV长度不够");
        }
        int type = Byte.toUnsignedInt(buf[offset]);
        int len = (Byte.toUnsignedInt(buf[offset + 1]) << 8) | Byte.toUnsignedInt(buf[offset + 2]);
        //再次判断缓冲区长度是否够
        if (len + 3 + offset > buf.length) {
            throw new DecodeException("TLV长度不够");
        }
        //获取TlvType
        TlvType tlvType = TlvType.typeFor(type);
        if (tlvType == null) {
            throw new DecodeException("未知的TLV类型");
        }
        // 解码value部分 不包含to的位置
        byte[] value = Arrays.copyOfRange(buf, offset + 3, offset + len + 3);
        ITlvValue tlvValue = decodeValue(tlvType, value);

        return Tlv.builder()
                .type(type)
                .length(len)
                .value(tlvValue)
                .build();
    }

    /**
     * 解码value部分
     *
     * @param tlvType tlv类型枚举
     * @param buf     缓冲区
     * @return 实体对象
     */
    private static ITlvValue decodeValue(TlvType tlvType, byte[] buf) throws DecodeException {
        ITlvValue tlvValue = null;
        switch (tlvType) {
            case RF_DATA:
                tlvValue = RfData.decode(buf);
                break;
            case RF_SIGNAL:
                tlvValue = RfSignal.decode(buf);
                break;
            default:
                break;
        }

        return tlvValue;
    }

    /**
     * 编码成字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        byte[] valContent = value.encode();
        length = valContent.length;
        byte[] buf = new byte[length + 3];
        buf[0] = (byte) type;
        buf[1] = (byte) (length >> 8);
        buf[2] = (byte) (length & 255);
        // length可以为0
        if (length > 0) {
            System.arraycopy(valContent, 0, buf, 3, length);
        }

        return buf;
    }
}
