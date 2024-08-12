package com.hd.daq.plugins.shike.iot.hex.ie.universal;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 属性对象
 *
 * @author ymm
 */
@Slf4j
@Data
public abstract class Attribute {
    /**
     * 防区号
     */
    protected int defenseZoneNumber;
    /**
     * 属性类型
     */
    protected UniversalAttributeType attributeType;
    /**
     * 属性值
     */
    protected String value;

    /**
     * 编码属性对象
     *
     * @return 编码后的字节数组
     */
    public abstract byte[] encode();

    /**
     * 解码属性值
     *
     * @param buf    缓冲区
     * @param offset 偏移量
     * @param len    长度
     * @return 属性值字符串
     */
    protected abstract String decodeValue(byte[] buf, int offset, int len);

    /**
     * 将字节数组转换成整数
     *
     * @param buf    缓冲区
     * @param offset 偏移量
     * @param len    长度
     * @return 整数
     */
    public int toInt(byte[] buf, int offset, int len) {
        int ret = 0;
        for (int i = offset; i < offset + len; ++i) {
            ret *= 256;
            ret += Byte.toUnsignedInt(buf[i]);
        }

        return ret;
    }

    /**
     * 将字节数组转换成长整数
     *
     * @param buf    缓冲区
     * @param offset 缓冲区
     * @param len    长度
     * @return 长整数
     */
    public long toLong(byte[] buf, int offset, int len) {
        long ret = 0;
        for (int i = offset; i < offset + len; ++i) {
            ret *= 256;
            ret += Byte.toUnsignedInt(buf[i]);
        }

        return ret;
    }

    /**
     * 把半字节BCD码数组转换成字符串
     *
     * @param buf    缓冲区
     * @param offset 缓冲区
     * @param len    长度
     * @return 字符串
     */
    public String convertBcdToString(byte[] buf, int offset, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = offset; i < offset + len; ++i) {
            sb.append((buf[i] >> 4) & 0x0F);
            sb.append(buf[i] & 0x0F);
        }
        return sb.toString();
    }
}
