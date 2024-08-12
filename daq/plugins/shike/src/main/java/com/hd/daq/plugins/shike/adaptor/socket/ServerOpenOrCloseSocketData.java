package com.hd.daq.plugins.shike.adaptor.socket;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeServerOpenOrCloseSocket;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--服务器下发打开或关闭空调指令
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerOpenOrCloseSocketData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型
     */
    private String deviceType;
    /**
     * 指令 1-开，0--关
     */
    private int instruct;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerOpenOrCloseSocket to() {
        return IeServerOpenOrCloseSocket.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .openOrClose(instruct & 1)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_OPEN_CLOSE_SOCKET.getName();
    }
}
