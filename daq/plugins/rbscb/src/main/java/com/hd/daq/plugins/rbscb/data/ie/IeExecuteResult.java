package com.hd.daq.plugins.rbscb.data.ie;

import io.netty.buffer.ByteBuf;
import lombok.Builder;
import lombok.Data;

import java.io.InputStream;

/**
 * 执行结果反馈
 * @author ymm
 */
@Builder
@Data
public class IeExecuteResult extends RbIotInformationElement {
    private int errorCode;

    public static IeExecuteResult decode(InputStream in) {
        int code = 0;
        try {
            code = in.read();
        } catch (Exception ignored) {
            return null;
        }
        if (code < 0) {
            return null;
        }
        IeExecuteResult obj = IeExecuteResult.builder().errorCode(code).build();
        return obj;
    }

    @Override
    public int encode(ByteBuf buffer) {
        buffer.writeByte(errorCode);
        return 1;
    }

    @Override
    public String toString() {
        return "{errorCode:" + errorCode + "}";
    }
}
