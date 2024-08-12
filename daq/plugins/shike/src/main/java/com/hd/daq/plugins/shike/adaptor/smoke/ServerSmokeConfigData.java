package com.hd.daq.plugins.shike.adaptor.smoke;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.IeServerSmokeConfig;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 队列请求消息params部分--烟感服务器下发设置参数通用请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerSmokeConfigData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 指令
     */
    private String instruct;
    /**
     * 数据集合
     */
    private List<String> dataList;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerSmokeConfig to() {
        return IeServerSmokeConfig.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .instruct(Integer.parseInt(instruct))
                .dataList(dataList.stream().map(Integer::parseInt).collect(Collectors.toList()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_SMOKE_CONFIG.getName();
    }
}
