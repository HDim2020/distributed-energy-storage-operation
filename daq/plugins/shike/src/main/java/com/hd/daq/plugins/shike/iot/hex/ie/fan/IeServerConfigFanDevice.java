package com.hd.daq.plugins.shike.iot.hex.ie.fan;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

/**
 * 智能吊扇控制器配置请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerConfigFanDevice implements IInformationElement {
    /**
     * 设备类型码
     */
    private int deviceTypeCode;
    /**
     * 自动关闭间隔， 1-254有效，其他情况需要设置成0xFF表示不自动关
     */
    private int autoCloseInterval;
    /**
     * 多跳次数，1-15之间有效，超出范围表示禁用多跳转发
     */
    private int multipleHops;

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[11];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        if (autoCloseInterval < 1 || autoCloseInterval > 254) {
            buf[2] = (byte) 0xFF;
        } else {
            buf[2] = (byte) autoCloseInterval;
        }
        //Bit6-4设置成101
        int temp = 0x50;
        if (multipleHops >= 1 && multipleHops <= 15) {
            // Bit7设置成1
            temp |= 0x80;
            // Bit3-Bit0设置成多跳次数
            temp |= multipleHops;
        }
        buf[3] = (byte) temp;
        // 预留
        for (int i = 4; i < 11; i++) {
            buf[i] = (byte) 0xFF;
        }

        return buf;
    }

    /**
     * 获取命令编码
     *
     * @return 命令编码
     */
    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_02.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_73.getId();
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
