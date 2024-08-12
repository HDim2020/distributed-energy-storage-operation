package com.hd.daq.plugins.shike.iot.hex;

import com.hd.daq.plugins.shike.exception.DecodeException;
import com.hd.daq.plugins.shike.exception.EncodeException;
import lombok.Builder;
import lombok.Getter;

/**
 * RF信号格式
 *
 * @author ymm
 */
@Builder
@Getter
public class RfSignal implements ITlvValue {
    /**
     * 是否蓝牙信号
     */
    private boolean bleSignal;
    /**
     * 2.4G多跳次数（bleSignal为true时有效）
     */
    private int multipleHopsCount;
    /**
     * LORA信噪比（bleSignal为false时有效）
     */
    private int snr;
    /**
     * 信号强度
     */
    private int rssi;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static RfSignal decode(byte[] buf) throws DecodeException {
        if (buf.length != 2) {
            throw new DecodeException("RfSignal数据长度错误");
        }
        boolean bleSignal = false;
        int multipleHopsCount = 0;
        int snr = 0;
        int rssi = 0;
        int b1 = Byte.toUnsignedInt(buf[0]);
        int b2 = Byte.toUnsignedInt(buf[1]);
        if (b1 > 127) {
            bleSignal = true;
            multipleHopsCount = b1 & 0x7F;
        } else {
            snr = b1;
        }
        rssi = b2 > 127 ? (b2 & 0x7F) - 200 : b2 - 100;

        return RfSignal.builder()
                .bleSignal(bleSignal)
                .multipleHopsCount(multipleHopsCount)
                .snr(snr)
                .rssi(rssi)
                .build();
    }

    /**
     * 获取TLV结构的类型码
     *
     * @return
     */
    @Override
    public TlvType getTlvType() {
        return TlvType.RF_SIGNAL;
    }

    /**
     * 编码实体对象为字节数组（设备上行不需要编码）
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        throw new EncodeException();
    }
}
