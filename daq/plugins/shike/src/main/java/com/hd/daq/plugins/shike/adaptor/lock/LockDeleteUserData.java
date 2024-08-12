package com.hd.daq.plugins.shike.adaptor.lock;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeLockDeleteUser;
import lombok.Builder;
import lombok.Getter;

/**
 * 队列请求消息params部分--办公锁远程开锁响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class LockDeleteUserData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 反馈信息
     */
    private String result;

    /**
     * 创建LockDeleteUserData实体对象
     *
     * @param rfData RfData实体对象
     * @return LockDeleteUserData实体对象
     */
    public static LockDeleteUserData from(RfData rfData) {
        IeLockDeleteUser ie = (IeLockDeleteUser) rfData.getData();
        return LockDeleteUserData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(Integer.toString(ie.getDeviceTypeCode()))
                .result(Integer.toString(ie.getResult()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_LOCK_DELETE_USER.getName();
    }
}
