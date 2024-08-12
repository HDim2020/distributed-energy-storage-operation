package com.hd.daq.plugins.shike.iot.hex.ie.fan;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

/**
 * 智能吊扇控制器查询响应数据信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeQueryFanDevice implements IInformationElement {
    /**
     * 设备类型
     */
    private int deviceTypeCode;
    /**
     * 开关状态 Bit3
     */
    private int switchStatus;
    /**
     * 档位，Bit0-2 1-5档
     */
    private int gear;
    /**
     * 自动关闭间隔， 1-254有效，其他情况需要设置成0xFF表示不自动关
     */
    private int autoCloseInterval;
    /**
     * 多跳次数，1-15之间有效，超出范围表示禁用多跳转发
     */
    private int multipleHops;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeQueryFanDevice decode(byte[] buf) {
        if (buf.length != 12) {
            return null;
        }
        int autoCloseInterval = Byte.toUnsignedInt(buf[3]);
        if (autoCloseInterval == 0xFF) {
            autoCloseInterval = 0;
        }
        int multipleHops = Byte.toUnsignedInt(buf[4]);
        // Bit7为0表示禁用，多跳次数设置成0
        if ((multipleHops & 0x80) == 0) {
            multipleHops = 0;
        } else {
            // Bit0-3表示多跳次数
            multipleHops &= 0xF;
        }
        return IeQueryFanDevice.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .switchStatus((Byte.toUnsignedInt(buf[2]) & 0x08) >> 3)
                .gear((Byte.toUnsignedInt(buf[2]) & 0x07) + 1)
                .autoCloseInterval(autoCloseInterval)
                .multipleHops(multipleHops)
                .build();
    }

    /**
     * 编码信息体元素(设备上行，不需要编码)
     *
     * @return 字符串数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        throw new EncodeException();
    }

    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_01.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_F3.getId();
    }

    /**
     * 获取消息存储类型
     *
     * @return 多个存储类型的并集
     */
    @Override
    public int getMessageStorageType() {
        return PROPERTY_MSG | SERVICE_MSG;
    }

    /**
     * 获取设备类型码
     *
     * @return 有支持时返回整数，不支持时返回null
     */
    @Override
    public Integer getDeviceTypeCode() {
        return deviceTypeCode;
    }
}
