package com.hd.daq.plugins.shike.exception;

/**
 * @author ymm
 */
public class ParameterException extends Exception {
    private static final long serialVersionUID = 1L;

    public ParameterException() {
        super();
    }

    public ParameterException(String cause) {
        super(cause);
    }

    public ParameterException(Exception cause) {
        super(cause);
    }
}
