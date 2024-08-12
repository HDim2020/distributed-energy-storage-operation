package com.hd.daq.plugins.shike.adaptor;

import com.google.gson.Gson;
import com.hd.daq.plugins.shike.adaptor.ac.*;
import com.hd.daq.plugins.shike.adaptor.fan.ServerConfigFanDeviceData;
import com.hd.daq.plugins.shike.adaptor.fan.ServerControlFanDeviceData;
import com.hd.daq.plugins.shike.adaptor.fan.ServerQueryFanDeviceData;
import com.hd.daq.plugins.shike.adaptor.lock.*;
import com.hd.daq.plugins.shike.adaptor.smoke.ServerSmokeConfigData;
import com.hd.daq.plugins.shike.adaptor.socket.ServerClearSocketElectricityData;
import com.hd.daq.plugins.shike.adaptor.socket.ServerOpenOrCloseSocketData;
import com.hd.daq.plugins.shike.adaptor.socket.ServerQuerySocketDeviceData;
import com.hd.daq.plugins.shike.adaptor.socket.ServerSetSocketThresholdData;
import com.hd.daq.plugins.shike.adaptor.universal.UniversalServerQueryAttributeData;
import com.hd.daq.plugins.shike.adaptor.universal.UniversalServerSetAttributeData;
import com.hd.daq.plugins.shike.adaptor.vrv.*;

/**
 * 服务器下发消息处理器
 *
 * @author ymm
 */
public class ServerMessageHandler {
    private static final Gson GSON = new Gson();

    /**
     * 转换成服务器到设备消息实体,每个函数最多20个分支
     *
     * @param strParams  JSON格式消息
     * @param methodType 方法类型
     * @return 消息实体
     */
    public static IServerToDeviceMessage toServerToDeviceMessage(String strParams, MethodType methodType) {
        IServerToDeviceMessage data;
        switch (methodType) {
            case SET_ADD_DEVICE_ONE:
                data = GSON.fromJson(strParams, ServerAddDeviceOneData.class);
                break;
            case SET_OPEN_CLOSE_AC:
                // 打开或关闭空调
                data = GSON.fromJson(strParams, ServerOpenOrCloseAirConditionData.class);
                break;
            case SET_AC_OPERATING_MODE:
                // 设置空调运行模式
                data = GSON.fromJson(strParams, ServerSetAirConditionOperatingModeData.class);
                break;
            case SET_AC_TEMP:
                // 设置空调温度
                data = GSON.fromJson(strParams, ServerSetAirConditionTempData.class);
                break;
            case SET_AC_WIND_SPEED:
                // 设置空调风速
                data = GSON.fromJson(strParams, ServerSetAirConditionWindSpeedData.class);
                break;
            case SET_AC_WIND_DIRECTION:
                // 设置空调风速
                data = GSON.fromJson(strParams, ServerSetAirConditionWindDirectionData.class);
                break;
            case SET_AC_COMBINATION:
                // 设置空调多组合命令
                data = GSON.fromJson(strParams, ServerSetAirConditionCombinationData.class);
                break;
            case SET_AC_QUERY_DEVICE:
                // 服务器下发查询功率/温度等信息
                data = GSON.fromJson(strParams, ServerQueryDeviceData.class);
                break;
            case SET_AC_CLEAR_ELECTRICITY:
                // 服务器下发清空电量统计
                data = GSON.fromJson(strParams, ServerClearElectricityData.class);
                break;
            case SET_QUERY_AC_ID:
                // 查询空调ID
                data = GSON.fromJson(strParams, ServerQueryAirConditionIdData.class);
                break;
            case SET_AC_ID:
                // 设置空调ID
                data = GSON.fromJson(strParams, ServerSetAirConditionIdData.class);
                break;
            case SET_SOCKET_THRESHOLD_SETTINGS:
                // 插座服务器下发设置参数
                data = GSON.fromJson(strParams, ServerSetSocketThresholdData.class);
                break;
            case SET_OPEN_CLOSE_SOCKET:
                // 插座打开关闭
                data = GSON.fromJson(strParams, ServerOpenOrCloseSocketData.class);
                break;
            case SET_SOCKET_QUERY_DEVICE:
                // 插座服务器下发查询功率/温度等信息
                data = GSON.fromJson(strParams, ServerQuerySocketDeviceData.class);
                break;
            case SET_SOCKET_CLEAR_ELECTRICITY:
                // 插座服务器下发清空电量统计
                data = GSON.fromJson(strParams, ServerClearSocketElectricityData.class);
                break;
            case SET_CLEAR_WHITE_LIST:
                // 清空白名单
                data = GSON.fromJson(strParams, ServerClearWhiteListData.class);
                break;
            case SET_ADD_WHITE_LIST:
                // 增加白名单
                data = GSON.fromJson(strParams, ServerAddWhiteListData.class);
                break;
            case SET_REMOVE_WHITE_LIST:
                // 移除白名单
                data = GSON.fromJson(strParams, ServerRemoveWhiteListData.class);
                break;
            case SET_UNIVERSAL_ATTRIBUTE:
                //通用设置属性
                data = GSON.fromJson(strParams, UniversalServerSetAttributeData.class);
                break;
            case SET_QUERY_UNIVERSAL_ATTRIBUTE:
                //通用查询属性
                data = GSON.fromJson(strParams, UniversalServerQueryAttributeData.class);
                break;
            default:
                data = toServerToDeviceMessageOne(strParams, methodType);
                break;
        }

        return data;
    }

    /**
     * 转换成服务器到设备消息实体,每个函数最多20个分支
     *
     * @param strParams  JSON格式消息
     * @param methodType 方法类型
     * @return 消息实体
     */
    private static IServerToDeviceMessage toServerToDeviceMessageOne(String strParams, MethodType methodType) {
        IServerToDeviceMessage data;
        switch (methodType) {
            case SET_VRV_QUERY_VERSION:
                //多联机查询设备版本
                data = GSON.fromJson(strParams, VrvServerQueryVersionData.class);
                break;
            case SET_VRV_QUERY_AC:
                //多联机查询空调
                data = GSON.fromJson(strParams, VrvServerQuerySeveralData.class);
                break;
            case SET_VRV_QUERY_ALL_AC:
                //多联机查询网关上所有空调
                data = GSON.fromJson(strParams, VrvServerQueryAllData.class);
                break;
            case SET_VRV_CLOSE_AC:
                //多联机打开或关闭空调
                data = GSON.fromJson(strParams, VrvServerOpenCloseAcData.class);
                break;
            case SET_VRV_SET_TEMP:
                //多联机控制空调温度
                data = GSON.fromJson(strParams, VrvServerSetTemperatureData.class);
                break;
            case SET_VRV_RUN_MODE:
                //多联机控制空调运行模式
                data = GSON.fromJson(strParams, VrvServerSetRunModeData.class);
                break;
            case SET_VRV_WIND_SPEED:
                //多联机控制空调风速
                data = GSON.fromJson(strParams, VrvServerSetWindSpeedData.class);
                break;
            case SET_QUERY_FAN:
                //智能吊扇控制器查询
                data = GSON.fromJson(strParams, ServerQueryFanDeviceData.class);
                break;
            case SET_CONFIG_FAN:
                //智能吊扇控制器配置
                data = GSON.fromJson(strParams, ServerConfigFanDeviceData.class);
                break;
            case SET_CONTROL_FAN:
                //智能吊扇控制器控制
                data = GSON.fromJson(strParams, ServerControlFanDeviceData.class);
                break;
            case SET_QUERY_LOCK:
                //办公锁查询
                data = GSON.fromJson(strParams, ServerQueryLockDeviceData.class);
                break;
            case SET_REMOTE_OPEN_LOCK:
                //办公锁远程开锁
                data = GSON.fromJson(strParams, ServerRemoteOpenLockData.class);
                break;
            case SET_LOCK_DELETE_USER:
                //办公锁删除用户
                data = GSON.fromJson(strParams, ServerLockDeleteUserData.class);
                break;
            case SET_LOCK_SET_USER:
                //办公锁设置用户密码或卡号
                data = GSON.fromJson(strParams, ServerLockSetUserData.class);
                break;
            case SET_LOCK_LOCAL_READ_CARD:
                //办公锁设置进入本地读卡模式
                data = GSON.fromJson(strParams, ServerLockLocalReadCardData.class);
                break;
            case SET_LOCK_RESET:
                //办公锁设置恢复出厂设置
                data = GSON.fromJson(strParams, ServerLockResetData.class);
                break;
            case SET_SMOKE_CONFIG:
                //烟感设置参数
                data = GSON.fromJson(strParams, ServerSmokeConfigData.class);
                break;
            default:
                data = null;
                break;
        }

        return data;
    }
}
