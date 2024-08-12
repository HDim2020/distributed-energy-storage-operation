package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

/**
 * 多联机未知的上报信息体元素（设备上行）
 * 主要是为了不在日志中记录错误，因为经常出现
 *
 * @author ymm
 */
@Builder
@Data
public class IeVrvUnknown implements IInformationElement {
    /**
     * 设备类型码 1字节
     */
    private int deviceTypeCode;
    /**
     * 未知数据 1字节
     */
    private int data;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeVrvUnknown decode(byte[] buf) {
        if (buf.length < 3) {
            return null;
        }
        return IeVrvUnknown.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .data(Byte.toUnsignedInt(buf[2]))
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
        return DeviceCmdType.CMD_02.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_B0.getId();
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

    /**
     * 获取消息存储类型
     *
     * @return 多个存储类型的并集
     */
    @Override
    public int getMessageStorageType() {
        // 为了不处理这个信息体元素，这里设置成0
        return 0;
    }
}
