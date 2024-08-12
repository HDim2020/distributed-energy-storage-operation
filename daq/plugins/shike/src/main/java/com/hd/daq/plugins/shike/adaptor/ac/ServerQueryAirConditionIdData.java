package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeServerQueryAirConditionId;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--服务器请求查询空调ID
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerQueryAirConditionIdData implements IMethodService, IServerToDeviceMessage {
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
    public IeServerQueryAirConditionId to() {
        return IeServerQueryAirConditionId.builder()
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_QUERY_AC_ID.getName();
    }
}
