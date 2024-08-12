package com.hd.daq.plugins.shike.adaptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法名称
 *
 * @author ymm
 */

public enum MethodType {
    /**
     * 心跳
     */
    GET_HEARTBEAT(0, "getHeartbeat"),
    /**
     * 设备添加，设备第一次发送平台
     */
    GET_ADD_DEVICE_ONE(1, "getAddDeviceOne"),
    /**
     * 设备添加，服务器回复
     */
    SET_ADD_DEVICE_ONE(2, "setAddDeviceOne"),
    /**
     * 设备添加，设备第二次发送平台
     */
    GET_ADD_DEVICE_TWO(3, "getAddDeviceTwo"),
    /**
     * 空调设置命令响应
     */
    GET_CONTROL_AC(4, "getControlAC"),
    /**
     * 设备开机
     */
    GET_DEVICE_OPEN(5, "getDeviceOpen"),
    /**
     * 查询空调ID响应
     */
    GET_QUERY_AC_ID(6, "getQueryACId"),
    /**
     * 打开或关闭空调请求
     */
    SET_OPEN_CLOSE_AC(7, "setOpenOrCloseAC"),
    /**
     * 控制空调运行模式请求
     */
    SET_AC_OPERATING_MODE(8, "setACOperatingMode"),
    /**
     * 控制空调温度请求
     */
    SET_AC_TEMP(9, "setACTemp"),
    /**
     * 控制空调风速请求
     */
    SET_AC_WIND_SPEED(10, "setACWindSpeed"),
    /**
     * 控制空调风向请求
     */
    SET_AC_WIND_DIRECTION(11, "setACWindDirection"),
    /**
     * 服务器下发查询功率/温度等信息请求--空调伴侣
     */
    SET_AC_QUERY_DEVICE(12, "setQueryDevice"),
    /**
     * 服务器下发清空电量统计请求--空调伴侣
     */
    SET_AC_CLEAR_ELECTRICITY(13, "setClearElectricity"),
    /**
     * 查询空调ID请求
     */
    SET_QUERY_AC_ID(14, "setQueryACId"),
    /**
     * 设置空调ID请求
     */
    SET_AC_ID(15, "setACId"),
    /**
     * 服务器下发查询功率/温度等信息的响应--空调伴侣
     */
    GET_AC_QUERY_DEVICE(16, "getQueryDevice"),
    /**
     * 服务器下发清空电量统计的响应--空调伴侣
     */
    GET_AC_CLEAR_ELECTRICITY(17, "getClearElectricity"),
    /**
     * 服务器下发查询功率/温度等信息请求---插座
     */
    SET_SOCKET_QUERY_DEVICE(18, "setQuerySocketDevice"),
    /**
     * 服务器下发清空电量统计请求--插座
     */
    SET_SOCKET_CLEAR_ELECTRICITY(19, "setClearSocketElectricity"),
    /**
     * 打开或关闭插座请求--插座
     */
    SET_OPEN_CLOSE_SOCKET(20, "setOpenOrCloseSocket"),
    /**
     * 服务器下发设置参数请求--插座
     */
    SET_SOCKET_THRESHOLD_SETTINGS(21, "setEsThresholdSettings"),
    /**
     * 服务器下发查询或者控制开或关的响应--插座
     */
    GET_SOCKET_COMMON(22, "getCommonSocket"),
    /**
     * 服务器下发清空电量统计的响应--插座
     */
    GET_SOCKET_CLEAR_ELECTRICITY(23, "getClearSocketElectricity"),
    /**
     * 服务器下发设置参数响应--插座
     */
    GET_SOCKET_THRESHOLD_SETTINGS(24, "getEsThresholdSettings"),
    /**
     * 设备事件上报--插座
     */
    GET_SOCKET_DEVICE_EVENT(25, "getDeviceEvent"),
    /**
     * 清空白名单请求
     */
    SET_CLEAR_WHITE_LIST(26, "setClearWhiteList"),
    /**
     * 移除白名单
     */
    SET_REMOVE_WHITE_LIST(27, "setRemoveWhiteList"),
    /**
     * 增加白名单请求
     */
    SET_ADD_WHITE_LIST(28, "setAddWhiteList"),
    /**
     * 清空白名单响应
     */
    GET_CLEAR_WHITE_LIST(29, "getClearWhiteList"),
    /**
     * 通用属性设置
     */
    SET_UNIVERSAL_ATTRIBUTE(30, "setAttribute"),
    /**
     * 通用属性设置回复
     */
    GET_UNIVERSAL_ATTRIBUTE(31, "getAttribute"),
    /**
     * 通用属性查询
     */
    SET_QUERY_UNIVERSAL_ATTRIBUTE(32, "setAttributeQuery"),
    /**
     * 通用属性查询回复
     */
    GET_QUERY_UNIVERSAL_ATTRIBUTE(33, "getAttributeQuery"),
    /**
     * RF信号
     */
    GET_RF_SIGNAL(34, "getRfSignal"),
    /**
     * 心跳
     */
    GET_VRV_HEARTBEAT(35, "getDeviceOpenByCascade"),
    /**
     * 设备开机
     */
    GET_VRV_DEVICE_OPEN(36, "getDeviceOpenByCascade"),
    /**
     * 查询设备版本请求
     */
    SET_VRV_QUERY_VERSION(37, "setVrvQueryVersion"),
    /**
     * 查询设备版本响应
     */
    GET_VRV_QUERY_VERSION(38, "getVrvQueryVersion"),
    /**
     * 查询空调请求
     */
    SET_VRV_QUERY_AC(39, "setQueryACCascade"),
    /**
     * 查询空调响应
     */
    GET_VRV_QUERY_AC(40, "getQueryACCascade"),
    /**
     * 查询网关上所有空调请求
     */
    SET_VRV_QUERY_ALL_AC(41, "setQueryACCascadeALL"),
    /**
     * 查询网关上所有空调响应
     */
    GET_VRV_QUERY_ALL_AC(42, "getQueryACCascadeALL"),
    /**
     * 打开或关闭空调请求
     */
    SET_VRV_CLOSE_AC(43, "setOpenOrCloseACCascade"),
    /**
     * 控制空调温度请求
     */
    SET_VRV_SET_TEMP(44, "setACTempCascade"),
    /**
     * 控制空调运行模式请求
     */
    SET_VRV_RUN_MODE(45, "setACOperatingModeCascade"),
    /**
     * 控制空调风速请求
     */
    SET_VRV_WIND_SPEED(46, "setACWindSpeedCascade"),
    /**
     * 控制空调统一的响应
     */
    GET_VRV_CONTROL_AC(47, "getControlACCascade"),
    /**
     * 通用设备事件上报，智慧用电终端协议通用版
     */
    GET_DEVICE_EVENT_UPDATE_DB(48, "getDeviceEventUpdateDB"),
    /**
     * 通用设备参数改变主动上报，智慧用电终端协议通用版
     */
    GET_UNIVERSAL_DEVICE_PARAM(49, "getDeviceEventParam"),
    /**
     * 空调发送组合命令
     */
    SET_AC_COMBINATION(50, "setCombinationAC"),
    /**
     * 多联机空调数据改变主动上报
     */
    GET_VRV_DATA_CHANGED(51, "getDeviceEventCascade"),
    /**
     * 智能吊扇控制器查询请求
     */
    SET_QUERY_FAN(52, "setQueryFan"),
    /**
     * 智能吊扇控制器查询响应
     */
    GET_QUERY_FAN(53, "getQueryFan"),
    /**
     * 智能吊扇控制器设置请求
     */
    SET_CONFIG_FAN(54, "setConfigFan"),
    /**
     * 智能吊扇控制器设置响应
     */
    GET_CONFIG_FAN(55, "getConfigFan"),
    /**
     * 办公锁上传事件
     */
    GET_LOCK_EVENT(56, "getLockEvent"),
    /**
     * 办公锁查询状态请求
     */
    SET_QUERY_LOCK(57, "setQueryLock"),
    /**
     * 办公锁查询状态响应
     */
    GET_QUERY_LOCK(58, "getQueryLock"),
    /**
     * 办公锁中心远程开锁请求
     */
    SET_REMOTE_OPEN_LOCK(59, "setRemoteOpenLock"),
    /**
     * 办公锁中心远程开锁响应
     */
    GET_REMOTE_OPEN_LOCK(60, "getRemoteOpenLock"),
    /**
     * 办公锁中心删除用户请求
     */
    SET_LOCK_DELETE_USER(61, "setLockDeleteUser"),
    /**
     * 办公锁中心删除用户响应
     */
    GET_LOCK_DELETE_USER(62, "getLockDeleteUser"),
    /**
     * 办公锁中心设置指定ID授权密码或者卡号请求
     */
    SET_LOCK_SET_USER(63, "setLockSetUser"),
    /**
     * 办公锁中心设置指定ID授权密码或者卡号响应
     */
    GET_LOCK_SET_USER(64, "getLockSetUser"),
    /**
     * 办公锁中心设置进入本地读卡模式请求
     */
    SET_LOCK_LOCAL_READ_CARD(65, "setLockLocalReadCard"),
    /**
     * 办公锁中心设置设置进入本地读卡模式响应
     */
    GET_LOCK_LOCAL_READ_CARD(66, "getLockLocalReadCard"),
    /**
     * 办公锁中心设置恢复出厂设置请求
     */
    SET_LOCK_RESET(67, "setLockReset"),
    /**
     * 办公锁中心设置设置恢复出厂设置响应
     */
    GET_LOCK_RESET(68, "getLockReset"),
    /**
     * 烟感中心设置参数请求
     */
    SET_SMOKE_CONFIG(69, "setSmokeConfig"),
    /**
     * 烟感中心设置参数响应
     */
    GET_SMOKE_CONFIG(70, "getSmokeConfig"),
    /**
     * 烟感事件
     */
    GET_SMOKE_EVENT(71, "getSmokeEvent"),
    /**
     * 绑定网关
     */
    SET_BIND_COLLECTOR(72, "setBindCollector"),
    /**
     * 解除绑定网关
     */
    SET_UNBIND_COLLECTOR(73, "setUnbindCollector"),
    /**
     * 智能吊扇控制器控制请求
     */
    SET_CONTROL_FAN(74, "setControlFan"),
    /**
     * 智能吊扇控制器控制响应
     */
    GET_CONTROL_FAN(75, "getControlFan");

    /**
     * 方法ID
     */
    private final int id;
    /**
     * 方法名称
     */
    private final String name;
    private static final Map<Integer, MethodType> ID_MAP = new HashMap<>();

    static {
        for (MethodType enumInstance : MethodType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    MethodType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 返回ID
     *
     * @return 方法ID
     */
    public int getId() {
        return id;
    }

    /**
     * 返回方法名称
     *
     * @return 方法名称
     */
    public String getName() {
        return name;
    }

    /**
     * 返回ID对应的枚举值
     *
     * @param id 方法ID
     * @return 实体
     */
    public static MethodType typeFor(int id) {
        return ID_MAP.get(id);
    }

    /**
     * 返回方法名称对应的枚举值
     *
     * @param name 方法名称
     * @return 实体
     */
    public static MethodType nameFor(String name) {
        MethodType methodType = null;
        for (Integer id : ID_MAP.keySet()) {
            methodType = ID_MAP.get(id);
            if (methodType.getName().equalsIgnoreCase(name)) {
                return methodType;
            }
        }

        return null;
    }
}
