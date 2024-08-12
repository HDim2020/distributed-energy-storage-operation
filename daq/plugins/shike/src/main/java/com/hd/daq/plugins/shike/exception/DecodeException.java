package com.hd.daq.plugins.shike.exception;

/**
 * 时刻消息解码异常
 * @author ymm
 */
public class DecodeException extends Exception {
    private static final long serialVersionUID = 1L;

    public DecodeException() {
        super("未知错误");
    }

    public DecodeException(String cause) {
        super(cause);
    }
}
