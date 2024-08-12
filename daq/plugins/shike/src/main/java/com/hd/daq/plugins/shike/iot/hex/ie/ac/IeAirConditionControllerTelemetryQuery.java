package com.hd.daq.plugins.shike.iot.hex.ie.ac;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

/**
 * 大功率空调控制器查询遥测数据信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeAirConditionControllerTelemetryQuery implements IInformationElement {
    /**
     * 电压（2字节单位V）
     */
    private int voltage;
    /**
     * 电流（2字节，单位mA）
     */
    private int current;
    /**
     * 功率因数（1字节，0-100）
     */
    private int powerFactor;
    /**
     * 累计功耗（4字节，单位Wh）
     */
    private long energy;
    /**
     * 温度（1字节，单位℃，0xFF无效）
     */
    private int temperature;
    /**
     * 湿度（1字节，单位%RH （0-100）0xFF无效）
     */
    private int humidity;
    /**
     * 开关状态（1字节，开0x01,关0x00））
     */
    private int switchStatus;
    /**
     * 1路剩余电流（2字节，单位mA）
     */
    private int residualCurrent;
    /**
     * 扩展温度1（1字节，单位℃）
     */
    private int extraTemperature1;
    /**
     * 扩展温度2（1字节，单位℃）
     */
    private int extraTemperature2;
    /**
     * 空调类型(1字节，0单相1三相)
     */
    private int airConditionType;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeAirConditionControllerTelemetryQuery decode(byte[] buf) {
        if (buf.length < 18) {
            return null;
        }
        return IeAirConditionControllerTelemetryQuery.builder()
                .voltage((Byte.toUnsignedInt(buf[1]) << 8) | Byte.toUnsignedInt(buf[2]))
                .current((Byte.toUnsignedInt(buf[3]) << 8) | Byte.toUnsignedInt(buf[4]))
                .powerFactor(buf[5])
                .energy(((long) Byte.toUnsignedInt(buf[6]) << 24) | (Byte.toUnsignedInt(buf[7]) << 16) | (Byte.toUnsignedInt(buf[8]) << 8) | Byte.toUnsignedInt(buf[9]))
                .temperature(buf[10])
                .humidity(buf[11])
                .switchStatus(buf[12])
                .residualCurrent((Byte.toUnsignedInt(buf[13]) << 8) | Byte.toUnsignedInt(buf[14]))
                .extraTemperature1(buf[15])
                .extraTemperature2(buf[16])
                .airConditionType(buf[17])
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
        return DeviceCmdType.CMD_12.getId();
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
        return SERVICE_MSG | PROPERTY_MSG;
    }
}
