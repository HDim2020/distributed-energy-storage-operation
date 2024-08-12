package com.hd.daq.plugins.shike.adaptor.socket;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeServerQuerySocketDevice;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--插座服务器下发发查询功率/温度等信息
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerQuerySocketDeviceData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerQuerySocketDevice to() {
        return IeServerQuerySocketDevice.builder()
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_SOCKET_QUERY_DEVICE.getName();
    }
}
