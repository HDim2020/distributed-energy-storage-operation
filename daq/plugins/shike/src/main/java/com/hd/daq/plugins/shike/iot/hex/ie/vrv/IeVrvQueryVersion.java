package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * 多联机查询设备版本响应信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeVrvQueryVersion implements IInformationElement {
    /**
     * 设备类型码 1字节
     */
    private int deviceTypeCode;
    /**
     * 固件版本 8字节
     */
    private String firmwareVersion;
    /**
     * 子设备接收网关2.4G信号强度 1字节
     */
    private int deviceSignal;
    /**
     * 网关接收子设备2.4G信号强度 1字节
     */
    private int gatewaySignal;
    /**
     * 所有空调参数校验和 2字节
     */
    private int checkSum;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeVrvQueryVersion decode(byte[] buf) {
        if (buf.length < 18) {
            return null;
        }
        return IeVrvQueryVersion.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .firmwareVersion(new String(buf, 2, 8, StandardCharsets.US_ASCII))
                .deviceSignal(buf[10])
                .gatewaySignal(buf[11])
                .checkSum((Byte.toUnsignedInt(buf[12]) << 8) | Byte.toUnsignedInt(buf[13]))
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
        return DeviceCmdType.CMD_82.getId();
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
        return SERVICE_MSG;
    }
}
