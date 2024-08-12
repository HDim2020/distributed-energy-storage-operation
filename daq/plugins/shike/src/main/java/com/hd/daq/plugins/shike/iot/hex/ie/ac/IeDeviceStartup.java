package com.hd.daq.plugins.shike.iot.hex.ie.ac;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * 空调伴侣或大功率空调控制器开机信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeDeviceStartup implements IInformationElement {
    /**
     * 固件版本 8字节
     */
    private String firmwareVersion;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeDeviceStartup decode(byte[] buf) {
        if (buf.length != 11) {
            return null;
        }
        return IeDeviceStartup.builder()
                .firmwareVersion(new String(buf, 1, 8, StandardCharsets.US_ASCII))
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
        return DeviceCmdType.CMD_00.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_B2.getId();
    }

    /**
     * 获取消息存储类型
     *
     * @return 多个存储类型的并集
     */
    @Override
    public int getMessageStorageType() {
        return DEVICE_MSG;
    }
}
