package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.adaptor.ac.*;
import com.hd.daq.plugins.shike.adaptor.door.DoorContactEventData;
import com.hd.daq.plugins.shike.adaptor.elec.SmartElectricityEventData;
import com.hd.daq.plugins.shike.adaptor.fan.ConfigFanDeviceData;
import com.hd.daq.plugins.shike.adaptor.fan.ControlFanDeviceData;
import com.hd.daq.plugins.shike.adaptor.fan.QueryFanDeviceData;
import com.hd.daq.plugins.shike.adaptor.human.HumanDetectionEventData;
import com.hd.daq.plugins.shike.adaptor.lock.*;
import com.hd.daq.plugins.shike.adaptor.smoke.SmokeConfigData;
import com.hd.daq.plugins.shike.adaptor.smoke.SmokeEventData;
import com.hd.daq.plugins.shike.adaptor.socket.*;
import com.hd.daq.plugins.shike.adaptor.universal.UniversalParamData;
import com.hd.daq.plugins.shike.adaptor.universal.UniversalQueryAttributeData;
import com.hd.daq.plugins.shike.adaptor.universal.UniversalSetAttributeData;
import com.hd.daq.plugins.shike.adaptor.vrv.*;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.DeviceType;
import com.hd.daq.plugins.shike.iot.hex.ie.IeAddDeviceTwo;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionCompanionTelemetryClear;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionCompanionTelemetryQuery;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeControlFanDevice;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.IeSmokeEvent;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.IeSmokeResponse;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeSocketLostAcPowerEvent;
import com.hd.daq.plugins.shike.util.UuidUtil;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.transportapi.data.thing.ResponseMsg;

import java.util.Objects;

/**
 * 设备上行除属性以外的消息处理器
 *
 * @author ymm
 */
public class ResponseMessageHandler {
    /**
     * 将RfData消息转换成队列响应消息
     *
     * @param collectorId 采集器ID
     * @param rfData      RfData实体对象
     * @return 响应消息实体对象
     */
    public static ResponseMsg convertRfDataToResponse(String collectorId, RfData rfData) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setId(UuidUtil.newId());
        responseMsg.setCollectorId(collectorId);
        responseMsg.setCode(ErrorCode.SUCCESS.getCode());
        responseMsg.setMessage(ErrorCode.SUCCESS.getMessage());
        responseMsg.setTimeStamp(System.currentTimeMillis());
        DeviceCmdType deviceCmdType = DeviceCmdType.typeFor(rfData.getCmd());
        if (deviceCmdType == null) {
            return null;
        }
        boolean ret = false;
        switch (deviceCmdType) {
            case CMD_B0:
                ret = convertToResponseForB0(responseMsg, rfData);
                break;
            case CMD_B1:
                ret = convertToResponseForB1(responseMsg, rfData);
                break;
            case CMD_B2:
                ret = convertToResponseForB2(responseMsg, rfData);
                break;
            case CMD_B6:
                ret = convertToResponseForB6(responseMsg, rfData);
                break;
            case CMD_F0:
                ret = convertToResponseForF0(responseMsg, rfData);
                break;
            case CMD_F1:
                ret = convertToResponseForF1(responseMsg, rfData);
                break;
            case CMD_F3:
                ret = convertToResponseForF3(responseMsg, rfData);
                break;
            default:
                break;
        }
        if (ret) {
            return responseMsg;
        }

        return null;
    }

    /**
     * B0命令码的RfData实体对象转换成队列响应消息实体对象
     *
     * @param responseMsg 队列响应消息实体对象
     * @param rfData      RfData实体对象
     * @return 转换是否成功
     */
    private static boolean convertToResponseForB0(ResponseMsg responseMsg, RfData rfData) {
        DeviceCmdType cmdCodeType = DeviceCmdType.typeFor(rfData.getData().getCmdCode());
        IInformationElement ie = rfData.getData();
        IMethodService methodService = null;
        switch (cmdCodeType) {
            case CMD_01:
                if (ie instanceof IeAddDeviceTwo) {
                    // 握手第三步
                    methodService = AddDeviceTwoData.from(rfData);
                } else if (ie instanceof IeControlFanDevice) {
                    // 智能吊扇控制器控制响应
                    methodService = ControlFanDeviceData.from(rfData);
                }
                break;
            case CMD_03:
                // 握手第一步
                methodService = AddDeviceOneData.from(rfData);
                break;
            case CMD_10:
                if (rfData.getData() instanceof IeSocketLostAcPowerEvent) {
                    // 插座市电掉电事件
                    methodService = SocketLostAcPowerEventData.from(rfData);
                } else {
                    // 插座普通事件
                    methodService = SocketCommonEventData.from(rfData);
                }
                break;
            default:
                break;
        }
        if (methodService != null) {
            responseMsg.setMethod(methodService.getMethodName());
            responseMsg.setData(methodService);
            return true;
        }
        return false;
    }

    /**
     * B1命令码的RfData实体对象转换成队列响应消息实体对象
     *
     * @param responseMsg 队列响应消息实体对象
     * @param rfData      RfData实体对象
     * @return 转换是否成功
     */
    private static boolean convertToResponseForB1(ResponseMsg responseMsg, RfData rfData) {
        IMethodService methodService = null;
        IInformationElement ie = rfData.getData();
        DeviceCmdType cmdCodeType = DeviceCmdType.typeFor(ie.getCmdCode());
        switch (cmdCodeType) {
            case CMD_0A:
                // 空调ID
                methodService = AirConditionIdData.from(rfData);
                break;
            case CMD_12:
                // 服务器下发查询功率/温度等信息的响应
                if (ie instanceof IeAirConditionCompanionTelemetryQuery) {
                    methodService = AirConditionCompanionQueryDeviceData.from(rfData);
                } else {
                    methodService = AirConditionControllerQueryDeviceData.from(rfData);
                }
                break;
            case CMD_13:
                // 服务器下发清空电量统计的响应
                if (ie instanceof IeAirConditionCompanionTelemetryClear) {
                    methodService = AirConditionCompanionClearElectricityData.from(rfData);
                } else {
                    methodService = AirConditionControllerClearElectricityData.from(rfData);
                }
                break;
            case CMD_B1:
                //空调控制的响应
                methodService = SetAirConditionData.from(rfData);
                break;
            default:
                break;
        }
        if (methodService != null) {
            responseMsg.setMethod(methodService.getMethodName());
            responseMsg.setData(methodService);
            return true;
        }
        return false;
    }

    /**
     * B2命令码的RfData实体对象转换成队列响应消息实体对象
     *
     * @param responseMsg 队列响应消息实体对象
     * @param rfData      RfData实体对象
     * @return 转换是否成功
     */
    private static boolean convertToResponseForB2(ResponseMsg responseMsg, RfData rfData) {
        DeviceCmdType cmdCodeType = DeviceCmdType.typeFor(rfData.getData().getCmdCode());
        IMethodService methodService = null;
        if (Objects.requireNonNull(cmdCodeType) == DeviceCmdType.CMD_00) {
            // 开机
            methodService = DeviceStartupData.from(rfData);
        }
        if (methodService != null) {
            responseMsg.setMethod(methodService.getMethodName());
            responseMsg.setData(methodService);
            return true;
        }
        return false;
    }

    /**
     * B6命令码的RfData实体对象转换成队列响应消息实体对象
     *
     * @param responseMsg 队列响应消息实体对象
     * @param rfData      RfData实体对象
     * @return 转换是否成功
     */
    private static boolean convertToResponseForB6(ResponseMsg responseMsg, RfData rfData) {
        DeviceCmdType cmdCodeType = DeviceCmdType.typeFor(rfData.getData().getCmdCode());
        IMethodService methodService = null;
        switch (cmdCodeType) {
            case CMD_12:
                // 开关插座或者查询的上行消息
                methodService = CommonSocketMsgData.from(rfData);
                break;
            case CMD_13:
                // 插座服务器下发清空电量统计上行消息
                methodService = ClearSocketElectricityData.from(rfData);
                break;
            case CMD_14:
                // 插座服务器下发设置参数上行消息
                methodService = SocketThresholdSettingsData.from(rfData);
                break;
            default:
                break;
        }
        if (methodService != null) {
            responseMsg.setMethod(methodService.getMethodName());
            responseMsg.setData(methodService);
            return true;
        }
        return false;
    }

    /**
     * F0命令码的RfData实体对象转换成队列响应消息实体对象
     *
     * @param responseMsg 队列响应消息实体对象
     * @param rfData      RfData实体对象
     * @return 转换是否成功
     */
    private static boolean convertToResponseForF0(ResponseMsg responseMsg, RfData rfData) {
        IInformationElement ie = rfData.getData();
        DeviceCmdType cmdCodeType = DeviceCmdType.typeFor(ie.getCmdCode());
        IMethodService methodService = null;
        switch (cmdCodeType) {
            case CMD_01:
                if (ie instanceof IeSmokeResponse) {
                    //烟感设置响应
                    methodService = SmokeConfigData.from(rfData);
                } else if (ie instanceof IeSmokeEvent) {
                    //烟感事件
                    methodService = SmokeEventData.from(rfData);
                }
                break;
            case CMD_02:
                // 办公锁事件上报
                methodService = LockEventData.from(rfData);
                break;
            case CMD_A3:
                methodService = universalCmdA3ToMethodService(rfData);
                break;
            case CMD_A4:
                // 设备产生事件主动上报
                methodService = universalCmdA4ToMethodService(rfData);
                break;
            default:
                break;
        }
        if (methodService != null) {
            responseMsg.setMethod(methodService.getMethodName());
            responseMsg.setData(methodService);
            return true;
        }
        return false;
    }

    /**
     * TODO 增加新设备需要修改
     * 通用二层命令A3的实体转换成IMethodService实体
     *
     * @param rfData RfData实体
     * @return IMethodService实例
     */
    private static IMethodService universalCmdA3ToMethodService(RfData rfData) {
        int deviceTypeCode = rfData.getData().getDeviceTypeCode();
        DeviceType deviceType = DeviceType.typeFor(deviceTypeCode);
        if (deviceType == null) {
            return null;
        }
        IMethodService methodService = null;
        if (deviceTypeCode == DeviceType.SK_6100C.getId() || deviceTypeCode == DeviceType.SK_6100.getId()) {
            //智慧用电终端参数改变主动上报
            methodService = UniversalParamData.from(rfData);
        }
        return methodService;
    }

    /**
     * TODO 增加新设备需要修改
     * 通用二层命令A4的实体转换成IMethodService实体
     *
     * @param rfData RfData实体
     * @return IMethodService实例
     */
    private static IMethodService universalCmdA4ToMethodService(RfData rfData) {
        int deviceTypeCode = rfData.getData().getDeviceTypeCode();
        DeviceType deviceType = DeviceType.typeFor(deviceTypeCode);
        if (deviceType == null) {
            return null;
        }
        IMethodService methodService = null;
        switch (deviceType) {
            case SK_6100C:
            case SK_6100:
                methodService = SmartElectricityEventData.from(rfData);
                break;
            case ZHDT1B_H1:
                methodService = DoorContactEventData.from(rfData);
                break;
            case ZH120:
                methodService = HumanDetectionEventData.from(rfData);
                break;
            default:
                break;
        }

        return methodService;
    }

    /**
     * F1命令码的RfData实体对象转换成队列响应消息实体对象
     *
     * @param responseMsg 队列响应消息实体对象
     * @param rfData      RfData实体对象
     * @return 转换是否成功
     */
    private static boolean convertToResponseForF1(ResponseMsg responseMsg, RfData rfData) {
        DeviceCmdType cmdCodeType = DeviceCmdType.typeFor(rfData.getData().getCmdCode());
        IMethodService methodService = null;
        switch (cmdCodeType) {
            case CMD_00:
                // 多联机开机上报
                methodService = VrvStartupData.from(rfData);
                break;
            case CMD_0B:
                // 多联机心跳上报
                methodService = VrvHeartbeatData.from(rfData);
                break;
            case CMD_52:
                // 多联机变化上报
                methodService = VrvDataChangedData.from(rfData);
                break;
            default:
                break;
        }
        if (methodService != null) {
            responseMsg.setMethod(methodService.getMethodName());
            responseMsg.setData(methodService);
            return true;
        }
        return false;
    }

    /**
     * F3命令码的RfData实体对象转换成队列响应消息实体对象
     *
     * @param responseMsg 队列响应消息实体对象
     * @param rfData      RfData实体对象
     * @return 转换是否成功
     */
    private static boolean convertToResponseForF3(ResponseMsg responseMsg, RfData rfData) {
        DeviceCmdType cmdCodeType = DeviceCmdType.typeFor(rfData.getData().getCmdCode());
        IMethodService methodService = null;
        switch (cmdCodeType) {
            case CMD_01:
                // 智能吊扇控制器查询响应
                methodService = QueryFanDeviceData.from(rfData);
                break;
            case CMD_02:
                // 智能吊扇控制器配置响应
                methodService = ConfigFanDeviceData.from(rfData);
                break;
            case CMD_03:
                // 办公锁查询响应
                methodService = QueryLockDeviceData.from(rfData);
                break;
            case CMD_08:
                // 办公锁中心远程开锁响应
                methodService = RemoteOpenLockData.from(rfData);
                break;
            case CMD_0A:
                // 办公锁中心删除用户响应
                methodService = LockDeleteUserData.from(rfData);
                break;
            case CMD_0D:
                // 办公锁中心设置用户密码或者卡号响应
                methodService = LockSetUserData.from(rfData);
                break;
            case CMD_0E:
                // 办公锁中心设置进入本地读卡模式响应
                methodService = LockLocalReadCardData.from(rfData);
                break;
            case CMD_0F:
                // 办公锁中心设置恢复出厂设置响应
                methodService = LockResetData.from(rfData);
                break;
            case CMD_A1:
                // 配置回复
                methodService = UniversalSetAttributeData.from(rfData);
                break;
            case CMD_A2:
                // 查询回复
                methodService = UniversalQueryAttributeData.from(rfData);
                break;
            case CMD_82:
                //多联机查询设备版本
                methodService = VrvQueryVersionData.from(rfData);
                break;
            case CMD_50:
                //多联机查询空调
                methodService = VrvQuerySeveralData.from(rfData);
                break;
            case CMD_51:
                //多联机查询网关下的所有空调
                methodService = VrvQueryAllData.from(rfData);
                break;
            case CMD_31:
                //多联机打开或关闭空调
                methodService = VrvOpenCloseAcData.from(rfData);
                break;
            case CMD_32:
                //多联机控制空调温度
                methodService = VrvSetTemperatureData.from(rfData);
                break;
            case CMD_33:
                //多联机控制运行模式
                methodService = VrvSetRunModeData.from(rfData);
                break;
            case CMD_34:
                //多联机控制空调风速
                methodService = VrvSetWindSpeedData.from(rfData);
                break;
            default:
                break;
        }
        if (methodService != null) {
            responseMsg.setMethod(methodService.getMethodName());
            responseMsg.setData(methodService);
            return true;
        }
        return false;
    }
}
