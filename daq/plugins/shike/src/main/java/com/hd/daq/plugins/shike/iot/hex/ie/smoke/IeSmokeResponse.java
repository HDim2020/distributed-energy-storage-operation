package com.hd.daq.plugins.shike.iot.hex.ie.smoke;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.util.ByteArrayUtil;
import lombok.Builder;
import lombok.Getter;


/**
 * 烟感通用设置响应信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeSmokeResponse implements IInformationElement {
    /**
     * 设备类型
     */
    private int deviceTypeCode;
    /**
     * 硬件版本 1字节
     */
    private int hardwareVersion;
    /**
     * 协议版本 1字节
     */
    private int protocolVersion;
    /**
     * 事件ID 1字节
     */
    private int eventId;
    /**
     * 事件类型 1字节
     */
    private int eventType;
    /**
     * 固件版本 8字节
     */
    private String firmwareVersion;
    /**
     * 烟感状态 1字节 0--正常 1--报警
     */
    private int smokeStatus;
    /**
     * 烟感浓度 1字节
     */
    private int smokeDensity;
    /**
     * 烟雾阈值 1字节
     */
    private int smokeThreshold;
    /**
     * 温度状态 1字节 0--正常 1--超温报警 2--低温报警
     */
    private int tempStatus;
    /**
     * 温度 1字节
     */
    private int temperature;
    /**
     * 超温阈值 1字节 0xFF关闭
     */
    private int overTempThreshold;
    /**
     * 超温恢复阈值 1字节
     */
    private int overTempRecoveryThreshold;
    /**
     * 低温阈值 1字节 0xFF关闭
     */
    private int lowTempThreshold;
    /**
     * 低温恢复阈值 1字节
     */
    private int lowTempRecoveryThreshold;
    /**
     * 电池电压状态 1字节 0--正常 1--低压
     */
    private int batteryVoltageStatus;
    /**
     * 电池电压 2字节 mv
     */
    private int batteryVoltage;
    /**
     * 低压阈值 2字节 mv
     */
    private int lowVoltageThreshold;
    /**
     * 防拆状态 1字节 0--正常 1--防拆打开
     */
    private int tamperStatus;
    /**
     * 模式 1字节 0--正常 1--消音 2--暂停报警
     */
    private int mode;
    /**
     * 心跳间隔 1字节 小时
     */
    private int heartbeatInterval;


    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeSmokeResponse decode(byte[] buf) {
        if (buf.length < 35) {
            return null;
        }
        return IeSmokeResponse.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .hardwareVersion(Byte.toUnsignedInt(buf[1]))
                .protocolVersion(Byte.toUnsignedInt(buf[2]))
                .eventId(Byte.toUnsignedInt(buf[4]))
                .eventType(Byte.toUnsignedInt(buf[5]))
                .firmwareVersion(ByteArrayUtil.bytesToString(buf, 6, 8))
                .smokeStatus(Byte.toUnsignedInt(buf[14]))
                .smokeDensity(Byte.toUnsignedInt(buf[15]))
                .smokeThreshold(Byte.toUnsignedInt(buf[16]))
                .tempStatus(Byte.toUnsignedInt(buf[17]))
                .temperature(Byte.toUnsignedInt(buf[18]))
                .overTempThreshold(Byte.toUnsignedInt(buf[19]))
                .overTempRecoveryThreshold(Byte.toUnsignedInt(buf[20]))
                .lowTempThreshold(Byte.toUnsignedInt(buf[21]))
                .lowTempRecoveryThreshold(Byte.toUnsignedInt(buf[22]))
                .batteryVoltageStatus(Byte.toUnsignedInt(buf[23]))
                .batteryVoltage((Byte.toUnsignedInt(buf[24]) << 8) | Byte.toUnsignedInt(buf[25]))
                .lowVoltageThreshold((Byte.toUnsignedInt(buf[26]) << 8) | Byte.toUnsignedInt(buf[27]))
                .tamperStatus(Byte.toUnsignedInt(buf[28]))
                .mode(Byte.toUnsignedInt(buf[29]))
                .heartbeatInterval(Byte.toUnsignedInt(buf[30]))
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
        return DeviceCmdType.CMD_01.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_F0.getId();
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
