package com.hd.daq.plugins.hdlink.data;

import lombok.Builder;
import lombok.Getter;

/**
 * 控制请求
 * @author ymm
 */
@Builder
@Getter
public class HdServiceRequest {
    /**
     * 请求UUID
     */
    private String id;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 方法参数
     */
    private Object params;
}
