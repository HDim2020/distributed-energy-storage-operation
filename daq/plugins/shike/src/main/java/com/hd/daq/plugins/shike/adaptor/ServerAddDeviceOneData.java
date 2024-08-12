package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.hex.ie.IeServerAddDeviceOne;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--服务器响应添加探头信息设备第一次上行消息
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerAddDeviceOneData implements IMethodService, IServerToDeviceMessage {
    /**
     * 通信标号
     */
    private String label;
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 信息
     */
    private String information;
    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerAddDeviceOne to() {
        return IeServerAddDeviceOne.builder()
                .deviceTypeCode(Integer.parseInt(information.substring(0, 2), 16))
                .randomNumber(Integer.parseInt(information.substring(4, 6), 16))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_ADD_DEVICE_ONE.getName();
    }
}
