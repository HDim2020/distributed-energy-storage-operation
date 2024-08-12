package com.hd.daq.plugins.rbscb.data.ie;

import io.netty.buffer.ByteBuf;

/**
 * 信息体元素抽象类
 * @author ymm
 */
public abstract class RbIotInformationElement {
    /**
     * 编码
     * @param buffer 缓冲区
     * @return 编码后的长度
     */
    public abstract int encode(ByteBuf buffer);
    @Override
    public abstract String toString();
}
