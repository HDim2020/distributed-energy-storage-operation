package com.hd.daq.plugins.shike.iot;


import lombok.Builder;
import lombok.Data;

/**
 * 固定头部，共16字节
 *
 * @author ymm
 */
@Builder
@Data
public class FixedHeader {
    /**
     * 协议号 第2字节
     */
    private byte protocolNumber;
    /**
     * 主版本号 第3字节5-7位
     */
    private byte majorVersion;
    /**
     * 次版本号 第3字节的3-4位
     */
    private byte minorVersion;
    /**
     * 网络通道 第3字节的0-2位
     */
    private ChannelType channel;
    /**
     * 校验和 第4字节
     */
    private int checkSum;
    /**
     * 序列号 第5和6字节
     */
    private int sequenceNumber;
    /**
     * 标识 第7字节
     */
    private byte flag;
    /**
     * 是否加密 第8字节的第7位
     */
    private boolean encrypted;
    /**
     * 包类型 第8字节的2-6位
     */
    private ContentType contentType;
    /**
     * 数据部分长度 第8字节的0-1位(最高位) + 第9字节的8位组成
     */
    private int dataLength;
    /**
     * 网关主机ID 第10-16字节
     */
    private String collectorId;

    /**
     * 构建新的实体对象
     *
     * @param sequenceNumber 序列号
     * @param collectorId    网关ID
     * @return 新的实体对象
     */
    public static FixedHeader create(int sequenceNumber, String collectorId) {
        return FixedHeader.builder()
                .sequenceNumber(sequenceNumber)
                .collectorId(collectorId)
                .majorVersion((byte) 1)
                .minorVersion((byte) 0)
                .flag((byte) 0x20)
                .channel(ChannelType.WIRED)
                .encrypted(false)
                .build();
    }

    /**
     * 解码成实体
     *
     * @param buf    缓冲区
     * @param offset 偏移量
     * @return 对象实例
     */
    public static FixedHeader decode(byte[] buf, int offset) {
        if (buf.length - offset < 16) {
            return null;
        }
        if (Byte.toUnsignedInt(buf[offset]) != 0xFF) {
            return null;
        }
        byte majorVersion = (byte) (Byte.toUnsignedInt(buf[2 + offset]) >> 5);
        byte minorVersion = (byte) ((Byte.toUnsignedInt(buf[2 + offset]) & 31) >> 3);
        int channelNo = Byte.toUnsignedInt(buf[2 + offset]) & 7;
        int sequenceNumber = (Byte.toUnsignedInt(buf[4 + offset]) << 8) | Byte.toUnsignedInt(buf[5 + offset]);
        boolean encrypted = Byte.toUnsignedInt(buf[7 + offset]) > 127;
        int contentTypeId = (Byte.toUnsignedInt(buf[7 + offset]) & 127) >> 2;
        int dataLength = ((Byte.toUnsignedInt(buf[7 + offset]) & 3) << 8) | Byte.toUnsignedInt(buf[8 + offset]);
        String collectorId = String.format("%02X%02X%02X%02X%02X%02X%02X", buf[9 + offset], buf[10 + offset], buf[11 + offset],
                buf[12 + offset], buf[13 + offset], buf[14 + offset], buf[15 + offset]);

        return FixedHeader.builder()
                .protocolNumber(buf[1 + offset])
                .majorVersion(majorVersion)
                .minorVersion(minorVersion)
                .channel(ChannelType.typeFor(channelNo))
                .checkSum(Byte.toUnsignedInt(buf[3 + offset]))
                .sequenceNumber(sequenceNumber)
                .flag(buf[6 + offset])
                .encrypted(encrypted)
                .contentType(ContentType.typeFor(contentTypeId))
                .dataLength(dataLength)
                .collectorId(collectorId)
                .build();
    }

    /**
     * 编码成字节数组
     *
     * @return 编码后的字节数组
     */
    public byte[] encode() {
        byte[] buf = new byte[16];
        buf[0] = (byte) 255;
        buf[1] = protocolNumber;
        buf[2] = (byte) ((majorVersion << 5) | (minorVersion << 3) | channel.getId());
        buf[3] = (byte) checkSum;
        buf[4] = (byte) (sequenceNumber >> 8);
        buf[5] = (byte) (sequenceNumber & 255);
        buf[6] = flag;
        buf[7] = (byte) ((encrypted ? (1 << 7) : 0) | (contentType.getId() << 2) | (dataLength >> 8));
        buf[8] = (byte) (dataLength & 255);
        for (int i = 0; i < 7; i++) {
            buf[9 + i] = (byte) Integer.parseInt(collectorId.substring(2 * i, 2 * i + 2), 16);
        }

        return buf;
    }
}
