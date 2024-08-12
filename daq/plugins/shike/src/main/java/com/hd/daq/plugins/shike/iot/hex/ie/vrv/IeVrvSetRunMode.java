package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

/**
 * 多联机控制空调运行模式响应信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeVrvSetRunMode implements IInformationElement {
    /**
     * 设备类型码 1字节
     */
    private int deviceTypeCode;
    /**
     * 控制参数，1字节，01：制冷 02：除湿 04 ：送风 08：制暖
     */
    private int instruct;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeVrvSetRunMode decode(byte[] buf) {
        if (buf.length < 3) {
            return null;
        }
        return IeVrvSetRunMode.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .instruct(Byte.toUnsignedInt(buf[2]))
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
        return DeviceCmdType.CMD_33.getId();
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
