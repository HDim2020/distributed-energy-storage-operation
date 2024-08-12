package com.hd.daq.plugins.shike.iot.hex.ie.ac;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

/**
 * 空调伴侣或大功率空调控制器空调ID信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeAirConditionId implements IInformationElement {
    /**
     * 空调控制码 2字节
     */
    private int controlCode;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeAirConditionId decode(byte[] buf) {
        //TODO 协议上是3字节，而实际上是10字节
        if (buf.length < 3) {
            return null;
        }
        return IeAirConditionId.builder()
                .controlCode((Byte.toUnsignedInt(buf[1]) << 8) | Byte.toUnsignedInt(buf[2]))
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
        return DeviceCmdType.CMD_0A.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_B1.getId();
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
