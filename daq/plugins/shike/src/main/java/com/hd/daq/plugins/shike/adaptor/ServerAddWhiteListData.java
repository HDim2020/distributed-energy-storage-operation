package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.hex.TlvType;
import com.hd.daq.plugins.shike.iot.hex.ie.IeServerAddWhiteList;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 队列请求消息params部分--增加白名单请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerAddWhiteListData implements IMethodService, IServerToDeviceMessage {
    /**
     * 白名单列表
     */
    private List<String> whiteList;

    @Override
    public String getUid() {
        return "";
    }

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerAddWhiteList to() {
        return IeServerAddWhiteList.builder()
                .whiteList(whiteList)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_ADD_WHITE_LIST.getName();
    }

    /**
     * 获取TLV类型
     *
     * @return TLV类型
     */
    @Override
    public TlvType getTlvType() {
        return TlvType.ADD_WHITELIST;
    }
}
