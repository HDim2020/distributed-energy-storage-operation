package com.hd.daq.plugins.rbscb.data;

import com.hd.daq.transportapi.util.Crc16Util;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * @author ymm
 */
@Slf4j
public class RbIotMessage {
    private static final byte START_CHAR = 0x68;
    private static final byte END_CHAR = 0x16;
    @Getter
    @Setter
    private int length;
    @Getter
    @Setter
    private int control;
    @Getter
    @Setter
    private int type;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private RbIotInformationObject informationObject;

    /**
     * 原始数据报文解码成消息
     * @param payload 原始报文
     * @return 瑞邦断路器消息
     */
    public static RbIotMessage decode(byte[] payload) {
        if (payload == null || payload.length < 6) {
            return null;
        }
        // 验证起始符
        if (payload[0] != START_CHAR) {
            return null;
        }
        // 除了起始符和长度以外的其他域总长度
        int len = Byte.toUnsignedInt(payload[1]) << 8 | Byte.toUnsignedInt(payload[2]);
        // 数据域长度
        int dataLen = len - 6;
        // 验证数据包长度
        if (payload.length != len + 3) {
            return null;
        }
        // 验证终止符
        if (payload[len + 2] != END_CHAR) {
            return null;
        }
        // 验证校验码
        int calcCrc16 = Crc16Util.calcCrc16(payload, 0, len);
        int rawCrc16 = Byte.toUnsignedInt(payload[len]) << 8 | Byte.toUnsignedInt(payload[len + 1]);
        if (calcCrc16 != rawCrc16) {
            log.debug("CRC check sum is not equal, calc:{}, raw:{}.", calcCrc16, rawCrc16);
            return null;
        }
        RbIotMessage rbIotMessage = new RbIotMessage();
        rbIotMessage.setControl(Byte.toUnsignedInt(payload[3]));
        rbIotMessage.setType(Byte.toUnsignedInt(payload[4]));
        rbIotMessage.setId(Byte.toUnsignedInt(payload[5]));
        ByteArrayInputStream in = new ByteArrayInputStream(Arrays.copyOfRange(payload, 6, 6 + dataLen));
        RbIotInformationObject rbIo = RbIotInformationObject.decode(in, rbIotMessage.getControl(),
                rbIotMessage.getType(), rbIotMessage.getId());
        if (rbIo != null) {
            rbIotMessage.setInformationObject(rbIo);
            return rbIotMessage;
        }
        return null;
    }

    /**
     * 编码成报文
     * @return 报文数组
     */
    public byte[] encode() {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(START_CHAR);
        buffer.writeShort(0);
        buffer.writeByte(control);
        buffer.writeByte(type);
        buffer.writeByte(id);
        int dataLen = informationObject.encode(buffer);
        //crc
        buffer.writeShort(0);
        buffer.writeByte(END_CHAR);
        //更新长度
        length = 6 + dataLen;
        buffer.setShort(1, length);
        byte[] packet = ByteBufUtil.getBytes(buffer);
        int crc = Crc16Util.calcCrc16(packet, 0, length);
        //更新crc值
        packet[length] = (byte) (crc >> 8);
        packet[length + 1] = (byte)crc;
        return packet;
    }
}
