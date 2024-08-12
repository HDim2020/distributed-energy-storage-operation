package com.hd.daq.plugins.shike.adaptor.lock;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeServerLockDeleteUser;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 队列请求消息params部分--办公锁服务器下发删除用户请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerLockDeleteUserData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 用户列表
     */
    private List<String> dataList;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerLockDeleteUser to() {
        return IeServerLockDeleteUser.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .userList(dataList.stream().map(Integer::parseInt).collect(Collectors.toList()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_LOCK_DELETE_USER.getName();
    }
}
