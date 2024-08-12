package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.hex.TlvType;
import com.hd.daq.plugins.shike.iot.hex.ie.IeServerClearWhiteList;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--清空白名单请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerClearWhiteListData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;

    /**
     * 绑定标志位
     */
    private int bindFlag;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerClearWhiteList to() {
        return IeServerClearWhiteList.builder()
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_AC_CLEAR_ELECTRICITY.getName();
    }

    /**
     * 获取TLV类型
     *
     * @return TLV类型
     */
    @Override
    public TlvType getTlvType() {
        return TlvType.CLEAR_WHITELIST;
    }
}
