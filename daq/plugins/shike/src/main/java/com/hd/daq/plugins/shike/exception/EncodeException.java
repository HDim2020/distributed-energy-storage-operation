package com.hd.daq.plugins.shike.exception;

/**
 * 编码异常
 * @author ymm
 */
public class EncodeException extends Exception {
    private static final long serialVersionUID = 1L;

    public EncodeException() {
        super("不支持编码操作");
    }
}
