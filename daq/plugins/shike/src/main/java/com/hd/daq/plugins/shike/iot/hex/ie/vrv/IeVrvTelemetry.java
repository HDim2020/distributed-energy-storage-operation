package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 多联机遥测数据上报信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeVrvTelemetry implements IInformationElement {
    /**
     * 设备类型码 1字节
     */
    private int deviceTypeCode;
    /**
     * 所有空调参数校验和 2字节
     */
    private int checkSum;
    /**
     * 总包数
     */
    private int totalPacketCount;
    /**
     * 分包序号
     */
    private int subPacketNumber;
    /**
     * 状态参数列表 1+8N字节
     */
    private List<VrvStatusParam> statusParamList;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeVrvTelemetry decode(byte[] buf) {
        if (buf.length < 7) {
            return null;
        }
        int count = Byte.toUnsignedInt(buf[6]);
        if (buf.length < 7 + 8 * count) {
            return null;
        }
        //解码空调状态参数
        List<VrvStatusParam> paramList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            paramList.add(VrvStatusParam.decode(buf, 7 + i * 8, 8));
        }
        return IeVrvTelemetry.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .checkSum((Byte.toUnsignedInt(buf[2]) << 8) | Byte.toUnsignedInt(buf[3]))
                .totalPacketCount(Byte.toUnsignedInt(buf[4]))
                .subPacketNumber(Byte.toUnsignedInt(buf[5]))
                .statusParamList(paramList)
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
        return DeviceCmdType.CMD_52.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_F1.getId();
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
        return PROPERTY_MSG | DEVICE_MSG;
    }
}
