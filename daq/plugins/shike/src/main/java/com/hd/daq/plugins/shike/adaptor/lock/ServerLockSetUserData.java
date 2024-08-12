package com.hd.daq.plugins.shike.adaptor.lock;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeServerLockSetUser;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 队列请求消息params部分--办公锁服务器下发设置指定ID授权密码或卡号请求
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerLockSetUserData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 授权类型 0x01--密码 0x02--卡号
     */
    private String authorizationType;
    /**
     * 密码或者卡号
     */
    private String passwordOrCardId;
    /**
     * 过期时间，为空表示不会过期 yyyy-MM-dd HH:mm:ss
     */
    private String expiredTime;
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerLockSetUser to() {
        long seconds = -1;
        if (expiredTime != null && !expiredTime.isEmpty()) {
            LocalDateTime dt = LocalDateTime.parse(expiredTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            seconds = dt.toInstant(ZoneOffset.ofHours(8)).getEpochSecond();
        }
        return IeServerLockSetUser.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .authorizationType(Integer.parseInt(authorizationType))
                .passwordOrCardId(passwordOrCardId)
                .expiredTime((int) seconds)
                .userId(Integer.parseInt(userId))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_LOCK_SET_USER.getName();
    }
}
