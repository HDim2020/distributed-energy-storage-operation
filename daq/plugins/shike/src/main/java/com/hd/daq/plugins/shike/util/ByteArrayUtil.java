package com.hd.daq.plugins.shike.util;

import java.nio.charset.StandardCharsets;

/**
 * 字节数组工具类
 *
 * @author ymm
 */
public final class ByteArrayUtil {
    /**
     * 16进制字符串转换成字节数组
     *
     * @param hexStr 16进制字符串
     * @return 字节数组
     */
    public static byte[] hexStringToBytes(String hexStr) {
        if (hexStr == null || hexStr.length() == 0) {
            return null;
        }
        String temp = hexStr.trim();
        if (temp.length() == 0) {
            return null;
        }
        // 不是偶数个字符，前面补0
        if ((temp.length() % 2) > 0) {
            temp = "0" + temp;
        }
        byte[] dest = new byte[temp.length() / 2];
        for (int i = 0; i < dest.length; ++i) {
            dest[i] = (byte) Integer.parseInt(temp.substring(2 * i, 2 * i + 2), 16);
        }

        return dest;
    }

    /**
     * 16进制字符串转换成字节数组
     *
     * @param hexStr 16进制字符串
     * @param dest   目标数组
     * @param offset 目标数组的偏移量
     * @return 是否成功
     */
    public static boolean hexStringToBytes(String hexStr, byte[] dest, int offset) {
        byte[] bytes = hexStringToBytes(hexStr);
        if (bytes == null) {
            return false;
        }
        if (offset + bytes.length > dest.length) {
            return false;
        }
        System.arraycopy(bytes, 0, dest, offset, bytes.length);
        return true;
    }

    /**
     * 将字节数组转换成16进制字符串
     *
     * @param buf    字节数组
     * @param offset 偏移量
     * @param len    长度
     * @return 16进制字符串
     */
    public static String toHexString(byte[] buf, int offset, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(String.format("%02X", buf[offset + i]));
        }
        return sb.toString();
    }

    /**
     * 查找key在数组中的下标
     *
     * @param buf    待搜索字节数组
     * @param offset 起始搜索位置
     * @param key    查找字节
     * @return 在数组中的下标, 没找到时返回-1
     */
    public static int indexOf(byte[] buf, int offset, byte key) {
        for (int i = offset; i < buf.length; i++) {
            if (buf[i] == key) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 字节数组转换成字符串
     *
     * @param buf    字节数组
     * @param offset 偏移量
     * @param len    长度
     * @return 字符串
     */
    public static String bytesToString(byte[] buf, int offset, int len) {
        return new String(buf, offset, len, StandardCharsets.UTF_8);
    }

    /**
     * 字符串转成字节数组
     *
     * @param str    字符串
     * @param dest   字节数组
     * @param offset 偏移量
     */
    public static void stringToBytes(String str, byte[] dest, int offset) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.arraycopy(bytes, 0, dest, offset, bytes.length);
    }
}
