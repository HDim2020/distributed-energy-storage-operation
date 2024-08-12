package com.hd.daq.plugins.shike.iot.hex;

import com.hd.daq.plugins.shike.exception.DecodeException;
import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.ValidateCode;
import com.hd.daq.plugins.shike.iot.hex.ie.*;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.*;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeConfigFanDevice;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeFanTelemetry;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeQueryFanDevice;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.*;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.IeSmokeCommon;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.*;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.AttributeUtils;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.IeUniversalMessage;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.*;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * RF数据格式
 *
 * @author ymm
 */
@Builder
@Data
@Slf4j
public class RfData implements ITlvValue {
    /**
     * 有效帧长度 1字节 通讯标号～校验，不包括本身
     */
    private int packetLength;
    /**
     * 通信标号 1字节
     */
    private int sequenceNumber;
    /**
     * 设备唯一标识+固定识别码 7个字节
     */
    private String deviceId;
    /**
     * 命令编码 1字节
     */
    private int cmd;
    /**
     * 数据 N字节
     */
    private IInformationElement data;
    /**
     * 校验码 1字节
     */
    private int checkCode;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static RfData decode(byte[] buf) throws DecodeException {
        // 验证缓冲区长度要满足最小值
        if (buf.length < 11) {
            throw new DecodeException("RfData报文不完整");
        }
        // 验证有效长度
        int packetLength = Byte.toUnsignedInt(buf[0]);
        if (packetLength + 1 != buf.length) {
            throw new DecodeException("RfData报文长度不正确");
        }
        // 验证校验码
        int calCheckCode = check(buf, 0, packetLength, TransportDirection.DEVICE_TO_SERVER);
        int checkCode = Byte.toUnsignedInt(buf[packetLength]);
        if (checkCode != calCheckCode) {
            throw new DecodeException("RfData校验码不正确");
        }
        // 开始解码
        int sequenceNumber = Byte.toUnsignedInt(buf[1]);
        // 有些大功率空调控制器以FF结尾，这里统一固定成FA
        buf[8] = (byte) 0xFA;
        String deviceId = String.format("%02X%02X%02X%02X%02X%02X%02X", buf[2], buf[3], buf[4], buf[5], buf[6], buf[7], buf[8]);
        int cmd = Byte.toUnsignedInt(buf[9]);
        RfData rfData = RfData.builder()
                .packetLength(packetLength)
                .sequenceNumber(sequenceNumber)
                .deviceId(deviceId)
                .cmd(cmd)
                .checkCode(checkCode)
                .build();
        IInformationElement ie = null;
        // 当数据部分不为空时，解码数据部分
        if (packetLength > 10) {
            byte[] data = Arrays.copyOfRange(buf, 10, packetLength);
            ie = decodeInformationElement(rfData, data);
        } else {
            ie = decodeInformationElement(rfData);
        }
        if (ie == null) {
            throw new DecodeException("RfData解码信息体失败");
        }
        rfData.setData(ie);
        return rfData;
    }

    /**
     * 没有数据部分的信息体解码
     *
     * @param rfData RfData实体对象
     * @return 信息体元素
     */
    private static IInformationElement decodeInformationElement(RfData rfData) {
        if (rfData.getCmd() == DeviceCmdType.CMD_B1.getId()) {
            return IeAirConditionCommonResponse.builder().build();
        }
        return null;
    }

    /**
     * 解码data部分为实体对象
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeInformationElement(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceCmdType cmdType = DeviceCmdType.typeFor(rfData.getCmd());
        if (cmdType == null) {
            log.debug("未知的命令码{}.", rfData.getCmd());
            return null;
        }
        switch (cmdType) {
            case CMD_B0:
                ie = decodeCmdB0(rfData, buf);
                break;
            case CMD_B1:
                ie = decodeCmdB1(rfData, buf);
                break;
            case CMD_B2:
                ie = decodeCmdB2(rfData, buf);
                break;
            case CMD_B6:
                ie = decodeCmdB6(rfData, buf);
                break;
            case CMD_B7:
                ie = decodeCmdB7(rfData, buf);
                break;
            case CMD_F0:
                ie = decodeCmdF0(rfData, buf);
                break;
            case CMD_F1:
                ie = decodeCmdF1(rfData, buf);
                break;
            case CMD_F3:
                ie = decodeCmdF3(rfData, buf);
                break;
            default:
                break;
        }

        return ie;
    }

    /**
     * 解码命令码为0xB0的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdB0(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[1]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[1]));
            return null;
        }
        switch (cmdType) {
            case CMD_01:
                // 握手第三步
                ie = IeAddDeviceTwo.decode(buf);
                break;
            case CMD_02:
                if (Byte.toUnsignedInt(buf[0]) == DeviceType.ZH109B.getId()) {
                    //智能吊扇控制器
                    ie = IeFanTelemetry.decode(buf);
                } else {
                    // 未知命令
                    ie = IeVrvUnknown.decode(buf);
                }
                break;
            case CMD_03:
                // 握手第一步
                ie = IeAddDeviceOne.decode(buf);
                break;
            case CMD_07:
                //未知命令
                ie = IeVrvUnknownCmdSeven.decode(buf);
                break;
            case CMD_10:
                if (buf.length == 3) {
                    // 插座失电事件
                    ie = IeSocketLostAcPowerEvent.decode(buf);
                } else {
                    // 插座普通事件
                    ie = IeSocketCommonEvent.decode(buf);
                }
                break;
            default:
                break;
        }
        return ie;
    }

    /**
     * 解码命令码为0xB1的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdB1(RfData rfData, byte[] buf) {
        // 数据有可能为空
        if (buf == null) {
            return null;
        }
        IInformationElement ie = null;
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[0]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[0]));
            return null;
        }
        switch (cmdType) {
            case CMD_0A:
                // 查询空调ID设备上行
                ie = IeAirConditionId.decode(buf);
                break;
            case CMD_12:
                // 服务器下发查询功率/温度等信息设备上行
                if (buf.length == 13) {
                    //空调伴侣响应
                    ie = IeAirConditionCompanionTelemetryQuery.decode(buf);
                } else if (buf.length == 18) {
                    // 大功率空调控制器响应
                    ie = IeAirConditionControllerTelemetryQuery.decode(buf);
                }
                break;
            case CMD_13:
                // 服务器下发清空电量统计，重新计量设备上行
                if (buf.length == 13) {
                    //空调伴侣响应
                    ie = IeAirConditionCompanionTelemetryClear.decode(buf);
                } else if (buf.length == 18) {
                    // 大功率空调控制器响应
                    ie = IeAirConditionControllerTelemetryClear.decode(buf);
                }
                break;
            default:
                break;
        }
        return ie;
    }

    /**
     * 解码命令码为0xB2的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdB2(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[0]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[1]));
            return null;
        }
        switch (cmdType) {
            case CMD_00:
                // 开机
                ie = IeDeviceStartup.decode(buf);
                break;
            case CMD_11:
                if (buf.length == 13) {
                    // 空调伴侣主动上报遥测数据
                    ie = IeAirConditionCompanionTelemetry.decode(buf);
                } else if (buf.length == 18) {
                    // 大功率空调控制器主动上报遥测数据
                    ie = IeAirConditionControllerTelemetry.decode(buf);
                }
                break;
            default:
                break;
        }
        return ie;
    }

    /**
     * 解码命令码为0xB6的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdB6(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[0]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[1]));
            return null;
        }
        switch (cmdType) {
            case CMD_12:
                // 开关插座或者查询的上行消息
                ie = IeCommonSocketMsg.decode(buf);
                break;
            case CMD_13:
                // 插座服务器下发清空电量统计上行消息
                ie = IeClearSocketElectricity.decode(buf);
                break;
            case CMD_14:
                // 插座服务器下发设置参数上行消息
                ie = IeSocketThresholdSettings.decode(buf);
                break;
            default:
                break;
        }
        return ie;
    }

    /**
     * 解码命令码为0xB7的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdB7(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[0]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[1]));
            return null;
        }
        if (cmdType == DeviceCmdType.CMD_11) {
            ie = IeSocketTelemetry.decode(buf);
        }

        return ie;
    }

    /**
     * 解码命令码为0xF0的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdF0(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceType deviceType = DeviceType.typeFor(Byte.toUnsignedInt(buf[0]));
        if (deviceType == null) {
            log.debug("未知的设备类型{}.", Byte.toUnsignedInt(buf[0]));
            return null;
        }
        // 处理通过设备类型来解析的协议
        if (deviceType == DeviceType.ZK_ZN13) {
            ie = IeSmokeCommon.decode(buf);
            return ie;
        }
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[1]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[1]));
            return null;
        }
        switch (cmdType) {
            case CMD_01:
                ie = IeLockTelemetry.decode(buf);
                break;
            case CMD_02:
                ie = IeLockEvent.decode(buf);
                break;
            case CMD_A3:
            case CMD_A4:
                ie = decodeUniversalAttribute(deviceType, rfData, buf);
                break;
            default:
                break;
        }

        return ie;
    }

    /**
     * 解码命令码为0xF1的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdF1(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[1]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[1]));
            return null;
        }
        switch (cmdType) {
            case CMD_00:
                ie = IeVrvStartup.decode(buf);
                break;
            case CMD_0B:
                ie = IeVrvHeartbeat.decode(buf);
                break;
            case CMD_52:
                ie = IeVrvTelemetry.decode(buf);
                break;
            default:
                break;
        }

        return ie;
    }

    /**
     * 解码命令码为0xF3的数据部分
     *
     * @param rfData RfData实体对象
     * @param buf    缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeCmdF3(RfData rfData, byte[] buf) {
        IInformationElement ie = null;
        DeviceType deviceType = DeviceType.typeFor(Byte.toUnsignedInt(buf[0]));
        if (deviceType == null) {
            log.debug("未知的设备类型{}.", Byte.toUnsignedInt(buf[0]));
            return null;
        }
        DeviceCmdType cmdType = DeviceCmdType.typeFor(Byte.toUnsignedInt(buf[1]));
        if (cmdType == null) {
            log.debug("未知的二层命令码{}.", Byte.toUnsignedInt(buf[1]));
            return null;
        }
        switch (cmdType) {
            case CMD_01:
                ie = IeQueryFanDevice.decode(buf);
                break;
            case CMD_02:
                ie = IeConfigFanDevice.decode(buf);
                break;
            case CMD_03:
                ie = IeQueryLockDevice.decode(buf);
                break;
            case CMD_08:
                ie = IeRemoteOpenLock.decode(buf);
                break;
            case CMD_0A:
                ie = IeLockDeleteUser.decode(buf);
                break;
            case CMD_0D:
                ie = IeLockSetUser.decode(buf);
                break;
            case CMD_0E:
                ie = IeLockLocalReadCard.decode(buf);
                break;
            case CMD_0F:
                ie = IeLockReset.decode(buf);
                break;
            case CMD_A1:
            case CMD_A2:
                ie = decodeUniversalAttribute(deviceType, rfData, buf);
                break;
            case CMD_82:
                ie = IeVrvQueryVersion.decode(buf);
                break;
            case CMD_50:
                ie = IeVrvQuerySeveral.decode(buf);
                break;
            case CMD_51:
                ie = IeVrvQueryAll.decode(buf);
                break;
            case CMD_31:
                ie = IeVrvOpenCloseAc.decode(buf);
                break;
            case CMD_32:
                ie = IeVrvSetTemperature.decode(buf);
                break;
            case CMD_33:
                ie = IeVrvSetRunMode.decode(buf);
                break;
            case CMD_34:
                ie = IeVrvSetWindSpeed.decode(buf);
                break;
            default:
                break;
        }

        return ie;
    }

    /**
     * 解码通用属性协议的数据部分
     *
     * @param deviceType 设备类型
     * @param rfData     RfData实体对象
     * @param buf        缓存区
     * @return 信息体元素
     */
    private static IInformationElement decodeUniversalAttribute(DeviceType deviceType, RfData rfData, byte[] buf) {
        int cmd = rfData.getCmd();
        IInformationElement ie = null;
        Class<? extends Attribute> cls = AttributeUtils.getAttributeSubClass(deviceType.getId());
        if (cls != null) {
            ie = IeUniversalMessage.decode(cls, cmd, buf);
        }
        return ie;
    }

    /**
     * 编码成字节数组
     *
     * @return 编码后的字节数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        //重新设定帧有效长度
        packetLength = 10;
        byte[] ieBytes = null;
        if (data != null) {
            ieBytes = data.encode();
            packetLength += ieBytes.length;
        }
        byte[] buf = new byte[packetLength + 1];
        buf[0] = (byte) packetLength;
        buf[1] = (byte) sequenceNumber;
        for (int i = 0; i < 7; i++) {
            buf[2 + i] = (byte) Integer.parseInt(deviceId.substring(2 * i, 2 * i + 2), 16);
        }
        buf[9] = (byte) data.getRfDataCmdCode();
        if (ieBytes != null) {
            System.arraycopy(ieBytes, 0, buf, 10, ieBytes.length);
        }
        buf[packetLength] = (byte) check(buf, 0, packetLength, TransportDirection.SERVER_TO_DEVICE);

        return buf;
    }

    /**
     * 计算校验码
     *
     * @param buf       缓冲区
     * @param offset    偏移量
     * @param len       长度
     * @param direction 方向
     * @return 校验码
     */
    private static int check(byte[] buf, int offset, int len, TransportDirection direction) {
        int ret = ValidateCode.checkSumOneByte(buf, offset, len);
        String salt = "sk";
        if (direction == TransportDirection.SERVER_TO_DEVICE) {
            salt = salt.toUpperCase();
        }
        byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);
        for (byte saltByte : saltBytes) {
            ret += Byte.toUnsignedInt(saltByte);
        }
        ret &= 0xFF;
        ret = ~ret;
        ret &= 0xFF;
        return ret;
    }

    /**
     * 获取TLV结构的类型码
     *
     * @return TLV类型
     */
    @Override
    public TlvType getTlvType() {
        return TlvType.RF_DATA;
    }
}
