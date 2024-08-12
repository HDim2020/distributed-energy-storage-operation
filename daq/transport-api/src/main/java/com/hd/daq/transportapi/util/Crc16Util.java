package com.hd.daq.transportapi.util;

/**
 * @author ymm
 */
public class Crc16Util {
    private static final int POLY = 0xA001;
    private static int[] crc16Table;

    /**
     * 初始化CRC16表
     */
    private static void initCrc16Table()
    {
        int crc, c;

        if (crc16Table == null)
        {
            crc16Table = new int[256];
            for (int ii = 0; ii < 256; ii++)
            {
                crc = 0;
                c = ii;
                for (int jj = 0; jj < 8; jj++)
                {
                    if (((crc ^ c) & 0x0001) == 0x0001) {
                        crc = (crc >> 1) ^ POLY;
                    } else {
                        crc = crc >> 1;
                    }
                    c = c >> 1;
                }
                crc16Table[ii] = crc;
            }
        }
    }

    /**
     * 计算CRC16
     * @param buffer 字节数组
     * @param offset 偏移量
     * @param length 长度
     * @return CRC16值
     */
    public static int calcCrc16(byte[] buffer, int offset, int length)
    {
        int crc = 0xFFFF;
        int temp = 0;
        initCrc16Table();
        for (int ii = 0; ii < length; ii++) {
            temp = crc ^ Byte.toUnsignedInt(buffer[offset + ii]);
            crc = (crc >> 8) ^ crc16Table[temp & 0xff];
        }
        return crc;
    }
}

