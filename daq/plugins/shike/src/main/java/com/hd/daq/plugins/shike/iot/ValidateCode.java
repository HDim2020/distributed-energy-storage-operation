package com.hd.daq.plugins.shike.iot;

/**
 * 校验码生成
 * @author ymm
 */
public class ValidateCode {
    /**
     * 计算校验码
     * @param buf 缓冲区
     * @param offset 偏移量
     * @param len 长度
     * @return 1字节校验和
     */
    public static int checkSumOneByte(byte[] buf, int offset, int len) {
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += Byte.toUnsignedInt(buf[offset + i]);
        }
        //取字节
        sum = sum & 255;
        return sum;
    }
}
