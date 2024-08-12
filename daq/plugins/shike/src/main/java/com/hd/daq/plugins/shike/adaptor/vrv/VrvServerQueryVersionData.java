package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeServerQueryDevice;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvQueryVersion;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvServerQueryVersion;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--多联机服务器下发查询设备版本信息
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvServerQueryVersionData implements IMethodService, IServerToDeviceMessage {
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
    public IeVrvServerQueryVersion to() {
        return IeVrvServerQueryVersion.builder()
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_VRV_QUERY_VERSION.getName();
    }
}
