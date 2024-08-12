package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import lombok.Builder;
import lombok.Getter;

/**
 * 多联机空调状态参数
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvStatusParam {
    /**
     * 室外机地址 1字节
     */
    private int outdoorUnitAddress;
    /**
     * 室内机地址 1字节
     */
    private int indoorUnitAddress;
    /**
     * 是否开机 1字节 0x01 开机，0x00 关机
     */
    private boolean opened;
    /**
     * 设定温度 1字节 16~30 ℃
     */
    private int settingTemperature;
    /**
     * 模式 1字节 0x01 设定制冷，0x02 设定除湿，0x04 设定送风，0x08 设定制热
     */
    private int mode;
    /**
     * 风速 1字节 0x01 设定高速，0x02 设定中速，0x03 设定中高速，0x04 设定低速，0x05 设定中低速
     */
    private int windSpeed;
    /**
     * 室内温度 1字节 ℃
     */
    private int indoorTemperature;
    /**
     * 故障代码 1字节
     */
    private int faultCode;

    /**
     * 解码成实体对象
     * @param buf 缓冲区
     * @param offset 偏移量
     * @param len 长度
     * @return 实体对象
     */
    public static VrvStatusParam decode(byte[] buf, int offset, int len) {
        if (len < 8) {
            return null;
        }
        return VrvStatusParam.builder()
                .outdoorUnitAddress(Byte.toUnsignedInt(buf[offset]))
                .indoorUnitAddress(Byte.toUnsignedInt(buf[offset + 1]))
                .opened(Byte.toUnsignedInt(buf[offset + 2]) > 0)
                .settingTemperature(Byte.toUnsignedInt(buf[offset + 3]))
                .mode(Byte.toUnsignedInt(buf[offset + 4]))
                .windSpeed(Byte.toUnsignedInt(buf[offset + 5]))
                .indoorTemperature(Byte.toUnsignedInt(buf[offset + 6]))
                .faultCode(Byte.toUnsignedInt(buf[offset + 7]))
                .build();
    }
}
