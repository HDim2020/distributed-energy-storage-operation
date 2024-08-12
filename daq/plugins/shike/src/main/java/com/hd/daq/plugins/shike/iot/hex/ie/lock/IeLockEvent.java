package com.hd.daq.plugins.shike.iot.hex.ie.lock;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;


/**
 * 办公锁事件信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeLockEvent implements IInformationElement {
    /**
     * 设备类型
     */
    private int deviceTypeCode;
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
     * 事件ID
     */
    private int eventId;
    /**
     * 子事件类型
     */
    private int subEventId;
    /**
     * 事件关联数据
     */
    private String eventData;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeLockEvent decode(byte[] buf) {
        if (buf.length < 7) {
            return null;
        }
        int eventId = Byte.toUnsignedInt(buf[5]);
        int subEventId = Byte.toUnsignedInt(buf[6]);
        String eventData = "";
        // 解析出事件关联数据（如果有的话）
        if (eventId == 0x01) {
            //开锁事件
            if (buf.length < 9) {
                return null;
            }
            int userId = (Byte.toUnsignedInt(buf[7]) << 8) | Byte.toUnsignedInt(buf[8]);
            userId &= 0x3FF;
            eventData = Integer.toString(userId);
        } else if (eventId == 0x06 && subEventId == 0x01) {
            if (buf.length < 8) {
                return null;
            }
            int cardIdLength = Byte.toUnsignedInt(buf[7]);
            if (cardIdLength < 1) {
                return null;
            }
            if (buf.length < 8 + cardIdLength) {
                return null;
            }
            eventData = new String(buf, 8, cardIdLength);
        }
        return IeLockEvent.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .batteryVoltage((Byte.toUnsignedInt(buf[2]) << 8) | Byte.toUnsignedInt(buf[3]))
                .switchStatus(Byte.toUnsignedInt(buf[4]) & 0x01)
                .lowVoltage(((Byte.toUnsignedInt(buf[4]) & 0x04)) >> 2)
                .eventId(eventId)
                .subEventId(subEventId)
                .eventData(eventData)
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
        return DeviceCmdType.CMD_F0.getId();
    }

    /**
     * 获取消息存储类型
     *
     * @return 多个存储类型的并集
     */
    @Override
    public int getMessageStorageType() {
        return DEVICE_MSG | PROPERTY_MSG;
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
