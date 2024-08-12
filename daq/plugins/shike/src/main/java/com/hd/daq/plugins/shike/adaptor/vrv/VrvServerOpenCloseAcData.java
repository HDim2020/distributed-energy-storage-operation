package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvServerOpenCloseAc;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列请求消息params部分--多联机服务器下发打开或关闭空调
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvServerOpenCloseAcData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 控制参数，1字节，0x01开，0x00关
     */
    private int instruct;
    /**
     * 空调地址集合，为空时表示控制全部
     */
    private List<String> dataList;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeVrvServerOpenCloseAc to() {
        List<Integer> itemList = new ArrayList<>(dataList.size());
        for (String address : dataList) {
            String[] items = address.split("-");
            if (items.length > 1) {
                itemList.add((Integer.parseInt(items[0]) << 8) | Integer.parseInt(items[1]));
            }
        }
        return IeVrvServerOpenCloseAc.builder()
                .instruct(instruct)
                .addressList(itemList)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_VRV_CLOSE_AC.getName();
    }
}