package com.hd.daq.plugins.hdlink.data;

import lombok.Data;

@Data
public class HdServiceResponse {
    /**
     * 请求ID
     */
    private String id;
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误消息
     */
    private String message;
    /**
     * 服务名称
     */
    private String method;
    /**
     * 返回数据
     */
    private Object data;
}
