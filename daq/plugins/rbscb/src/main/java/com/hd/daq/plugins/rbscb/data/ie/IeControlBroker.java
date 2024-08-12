package com.hd.daq.plugins.rbscb.data.ie;

import io.netty.buffer.ByteBuf;
import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;

/**
 * 智能用电遥控
 * @author ymm
 */
@Builder
public class IeControlBroker extends RbIotInformationElement {
    @Getter
    private int action;

    public static IeControlBroker decode(InputStream in) {
        try {
            byte[] data = new byte[2];
            int n = in.read(data);
            if (n < 2) {
                return null;
            }
            IeControlBroker obj = IeControlBroker.builder()
                    .action(Byte.toUnsignedInt(data[0]) << 8 + Byte.toUnsignedInt(data[1])).build();
            return obj;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public int encode(ByteBuf buffer) {
        buffer.writeShort(action);
        return 2;
    }

    @Override
    public String toString() {
        return "{action:0x" + Integer.toHexString(action) + "}";
    }
}
