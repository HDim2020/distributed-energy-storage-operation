package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvServerQueryAll;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--多联机服务器下发查询网关下所有空调信息
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvServerQueryAllData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 总包数
     */
    private String total;
    /**
     * 分包序号
     */
    private String subpackage;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeVrvServerQueryAll to() {
        return IeVrvServerQueryAll.builder()
                .totalPacketCount(Integer.parseInt(total))
                .subPacketNumber(Integer.parseInt(subpackage))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_VRV_QUERY_ALL_AC.getName();
    }
}
