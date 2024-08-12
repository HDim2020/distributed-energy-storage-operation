package com.hd.daq.plugins.shike.iot.hex.ie.lock;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

/**
 * 办公锁查询响应信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeQueryLockDevice implements IInformationElement {
    /**
     * 设备类型 1字节
     */
    private int deviceTypeCode;
    /**
     * 固件版本 8字节
     */
    private String firmwareVersion;
    /**
     * 电池电压 mv 2字节
     */
    private int batteryVoltage;
    /**
     * 锁状态 Bit0
     */
    private int switchStatus;
    /**
     * 低压标识符，Bit2
     */
    private int lowVoltage;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeQueryLockDevice decode(byte[] buf) {
        if (buf.length < 15) {
            return null;
        }
        return IeQueryLockDevice.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .firmwareVersion(new String(buf, 2, 8))
                .batteryVoltage((Byte.toUnsignedInt(buf[10]) << 8) | Byte.toUnsignedInt(buf[11]))
                .switchStatus(Byte.toUnsignedInt(buf[12]) & 0x01)
                .lowVoltage(((Byte.toUnsignedInt(buf[12]) & 0x04)) >> 2)
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
        return DeviceCmdType.CMD_03.getId();
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
        return SERVICE_MSG;
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
