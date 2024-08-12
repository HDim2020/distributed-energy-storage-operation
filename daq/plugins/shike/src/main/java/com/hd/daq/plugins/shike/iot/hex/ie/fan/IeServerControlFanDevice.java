package com.hd.daq.plugins.shike.iot.hex.ie.fan;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

/**
 * 智能吊扇控制器控制请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerControlFanDevice implements IInformationElement {
    /**
     * 设备类型码
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
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[3];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        buf[2] = (byte) (((switchStatus & 1) << 3) | ((gear - 1) & 0x07));

        return buf;
    }

    /**
     * 获取命令编码
     *
     * @return 命令编码
     */
    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_04.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_30.getId();
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
