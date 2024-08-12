package com.hd.daq.plugins.rbscb.data.ie;

import io.netty.buffer.ByteBuf;
import lombok.Builder;

import java.io.InputStream;

/**
 * 空信息体元素
 * @author ymm
 */
@Builder
public class IeEmpty extends RbIotInformationElement {

    public static IeEmpty encode(InputStream in) {
        return IeEmpty.builder().build();
    }

    @Override
    public int encode(ByteBuf buffer) {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
