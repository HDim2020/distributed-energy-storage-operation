package com.hd.daq.transportapi;

/**
 * 错误码定义
 * @author ymm
 */

public enum ErrorCode {
    /**
     * 成功
     */
    SUCCESS(0, "success"),
    /**
     * 失败
     */
    FAIL(1, "fail"),
    TIMEOUT(2, "timeout"),
    OFFLINE(3, "collector offline"),
    EXPIRED(4, "request expired"),
    PARAM_LOST(5, "lost parameter [%s]"),
    PARAM_INVALID(6, "invalid [%s] value [%s]");

    private final int code;
    private final String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorCode typeFor(int code) {
        for(ErrorCode v : ErrorCode.values()) {
            if (v.getCode() == code) {
                return v;
            }
        }
        return null;
    }
}
