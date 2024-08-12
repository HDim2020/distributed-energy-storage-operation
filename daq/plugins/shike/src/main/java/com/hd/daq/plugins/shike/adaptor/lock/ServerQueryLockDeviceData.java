package com.hd.daq.plugins.shike.adaptor.lock;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeServerQueryLockDevice;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--办公锁服务器下发查询请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerQueryLockDeviceData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerQueryLockDevice to() {
        return IeServerQueryLockDevice.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_QUERY_LOCK.getName();
    }
}