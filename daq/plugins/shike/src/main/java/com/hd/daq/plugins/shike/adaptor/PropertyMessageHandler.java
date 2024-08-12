package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.hex.*;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeControlFanDevice;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeLockEvent;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.IeSmokeEvent;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.DeviceType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionCompanionTelemetry;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionCompanionTelemetryQuery;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionControllerTelemetry;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionControllerTelemetryQuery;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeFanTelemetry;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeQueryFanDevice;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeLockTelemetry;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeCommonSocketMsg;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeSocketTelemetry;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.IeUniversalMessage;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalAttributeType;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalEventType;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvQueryAll;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvQuerySeveral;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvTelemetry;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.VrvStatusParam;
import com.hd.daq.transportapi.data.thing.PropertyEntry;
import com.hd.daq.transportapi.data.thing.PropertyMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性消息处理器
 *
 * @author ymm
 */
public class PropertyMessageHandler {
    /**
     * 转换成属性消息
     *
     * @param rfData      RfData实体对象
     * @param collectorId 网关ID
     * @return 属性消息实体对象
     */
    public static PropertyMsg convertToProperty(RfData rfData, String collectorId) {
        IInformationElement ie = rfData.getData();
        List<PropertyEntry> entryList = null;
        if (ie instanceof IeAirConditionCompanionTelemetry) {
            IeAirConditionCompanionTelemetry entity = (IeAirConditionCompanionTelemetry) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeAirConditionControllerTelemetry) {
            IeAirConditionControllerTelemetry entity = (IeAirConditionControllerTelemetry) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeSocketTelemetry) {
            IeSocketTelemetry entity = (IeSocketTelemetry) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeUniversalMessage) {
            IeUniversalMessage entity = (IeUniversalMessage) ie;
            boolean isHandled = false;
            if (entity.getCmdCode() == DeviceCmdType.CMD_A4.getId()) {
                DeviceType deviceType = DeviceType.typeFor(entity.getDeviceTypeCode());
                isHandled = true;
                switch (deviceType) {
                    case ZHDT1B_H1:
                        // 从门磁的事件包中提取出门磁状态，作为遥测数据
                        entryList = getDoorConcatPropertyEntryList(rfData.getDeviceId(), entity);
                        break;
                    case ZH120:
                        entryList = getHumanDetectionPropertyEntryList(rfData.getDeviceId(), entity);
                        break;
                    default:
                        isHandled = false;
                        break;
                }
            }
            if (!isHandled) {
                entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
            }
        } else if (ie instanceof IeVrvTelemetry) {
            IeVrvTelemetry entity = (IeVrvTelemetry) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeAirConditionCompanionTelemetryQuery) {
            IeAirConditionCompanionTelemetryQuery entity = (IeAirConditionCompanionTelemetryQuery) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeAirConditionControllerTelemetryQuery) {
            IeAirConditionControllerTelemetryQuery entity = (IeAirConditionControllerTelemetryQuery) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeCommonSocketMsg) {
            IeCommonSocketMsg entity = (IeCommonSocketMsg) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeVrvQuerySeveral) {
            IeVrvQuerySeveral entity = (IeVrvQuerySeveral) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeVrvQueryAll) {
            IeVrvQueryAll entity = (IeVrvQueryAll) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeFanTelemetry) {
            IeFanTelemetry entity = (IeFanTelemetry) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeQueryFanDevice) {
            IeQueryFanDevice entity = (IeQueryFanDevice) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeControlFanDevice) {
            IeControlFanDevice entity = (IeControlFanDevice) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeLockTelemetry) {
            IeLockTelemetry entity = (IeLockTelemetry) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeLockEvent) {
            IeLockEvent entity = (IeLockEvent) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else if (ie instanceof IeSmokeEvent) {
            IeSmokeEvent entity = (IeSmokeEvent) ie;
            entryList = getPropertyEntryList(rfData.getDeviceId(), entity);
        } else {
            return null;
        }
        PropertyMsg propertyMsg = new PropertyMsg();
        propertyMsg.setCollectorId(collectorId);
        propertyMsg.setParams(entryList);

        return propertyMsg;
    }

    /**
     * 空调伴侣遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   空调伴侣遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeAirConditionCompanionTelemetry entity) {
        List<PropertyEntry> entryList = new ArrayList<>(7);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "voltage")
                .propValue(Integer.toString(entity.getVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "electricCurrent")
                .propValue(Integer.toString(entity.getCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "powerFactor")
                .propValue(Integer.toString(entity.getPowerFactor()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "accumulatedPower")
                .propValue(Long.toString(entity.getEnergy()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "temperature")
                .propValue(Integer.toString(entity.getTemperature()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "humidity")
                .propValue(Integer.toString(entity.getHumidity()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());

        return entryList;
    }

    /**
     * 空调伴侣遥测数据查询结果转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   空调伴侣遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeAirConditionCompanionTelemetryQuery entity) {
        List<PropertyEntry> entryList = new ArrayList<>(7);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "voltage")
                .propValue(Integer.toString(entity.getVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "electricCurrent")
                .propValue(Integer.toString(entity.getCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "powerFactor")
                .propValue(Integer.toString(entity.getPowerFactor()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "accumulatedPower")
                .propValue(Long.toString(entity.getEnergy()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "temperature")
                .propValue(Integer.toString(entity.getTemperature()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "humidity")
                .propValue(Integer.toString(entity.getHumidity()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());

        return entryList;
    }

    /**
     * 空调控制器遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   空调控制器遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeAirConditionControllerTelemetry entity) {
        List<PropertyEntry> entryList = new ArrayList<>(11);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "voltage")
                .propValue(Integer.toString(entity.getVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "electricCurrent")
                .propValue(Integer.toString(entity.getCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "powerFactor")
                .propValue(Integer.toString(entity.getPowerFactor()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "accumulatedPower")
                .propValue(Long.toString(entity.getEnergy()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "temperature")
                .propValue(Integer.toString(entity.getTemperature()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "humidity")
                .propValue(Integer.toString(entity.getHumidity()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "oneElectricCurrent")
                .propValue(Integer.toString(entity.getResidualCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "twoTemperature")
                .propValue(Integer.toString(entity.getExtraTemperature1()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "threeTemperature")
                .propValue(Integer.toString(entity.getExtraTemperature2()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "airConditioningType")
                .propValue(Integer.toString(entity.getAirConditionType()))
                .build());

        return entryList;
    }

    /**
     * 空调控制器遥测数据查询结果转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   空调控制器遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeAirConditionControllerTelemetryQuery entity) {
        List<PropertyEntry> entryList = new ArrayList<>(11);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "voltage")
                .propValue(Integer.toString(entity.getVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "electricCurrent")
                .propValue(Integer.toString(entity.getCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "powerFactor")
                .propValue(Integer.toString(entity.getPowerFactor()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "accumulatedPower")
                .propValue(Long.toString(entity.getEnergy()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "temperature")
                .propValue(Integer.toString(entity.getTemperature()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "humidity")
                .propValue(Integer.toString(entity.getHumidity()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "oneElectricCurrent")
                .propValue(Integer.toString(entity.getResidualCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "twoTemperature")
                .propValue(Integer.toString(entity.getExtraTemperature1()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "threeTemperature")
                .propValue(Integer.toString(entity.getExtraTemperature2()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "airConditioningType")
                .propValue(Integer.toString(entity.getAirConditionType()))
                .build());

        return entryList;
    }

    /**
     * 插座遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   插座遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeSocketTelemetry entity) {
        List<PropertyEntry> entryList = new ArrayList<>(7);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "voltage")
                .propValue(Integer.toString(entity.getVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "electricCurrent")
                .propValue(Integer.toString(entity.getElectricCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "powerFactor")
                .propValue(Integer.toString(entity.getPowerFactor()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "accumulatedPower")
                .propValue(Long.toString(entity.getAccumulatedPower()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "temperature")
                .propValue(Integer.toString(entity.getTemperature()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "humidity")
                .propValue(Integer.toString(entity.getHumidity()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());

        return entryList;
    }

    /**
     * 插座通用上行消息数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   插座遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeCommonSocketMsg entity) {
        List<PropertyEntry> entryList = new ArrayList<>(7);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "voltage")
                .propValue(Integer.toString(entity.getVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "electricCurrent")
                .propValue(Integer.toString(entity.getElectricCurrent()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "powerFactor")
                .propValue(Integer.toString(entity.getPowerFactor()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "accumulatedPower")
                .propValue(Long.toString(entity.getAccumulatedPower()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "temperature")
                .propValue(Integer.toString(entity.getTemperature()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "humidity")
                .propValue(Integer.toString(entity.getHumidity()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());

        return entryList;
    }

    /**
     * 通用遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   通用协议遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeUniversalMessage entity) {
        List<PropertyEntry> entryList = new ArrayList<>();
        long ts = System.currentTimeMillis();
        for (Attribute attribute : entity.getAttributeList()) {
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(deviceId + String.format("%03d", attribute.getDefenseZoneNumber()) + attribute.getAttributeType().getName())
                    .propValue(attribute.getValue())
                    .build());
        }

        return entryList;
    }

    /**
     * 多联机遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   多联机遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeVrvTelemetry entity) {
        List<PropertyEntry> entryList = new ArrayList<>(entity.getStatusParamList().size() * 6);
        long ts = System.currentTimeMillis();
        for (VrvStatusParam param : entity.getStatusParamList()) {
            String address = String.format("%03d%03d", param.getOutdoorUnitAddress(), param.getIndoorUnitAddress());
            String prefix = deviceId + address;
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "switchStatus")
                    .propValue(param.isOpened() ? "1" : "0")
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acTemp")
                    .propValue(Integer.toString(param.getSettingTemperature()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acMode")
                    .propValue(Integer.toString(param.getMode()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acWindSpeed")
                    .propValue(Long.toString(param.getWindSpeed()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "temperature")
                    .propValue(Integer.toString(param.getIndoorTemperature()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "faultCodes")
                    .propValue(Integer.toString(param.getFaultCode()))
                    .build());
        }

        return entryList;
    }

    /**
     * 多联机查询空调响应数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   多联机遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeVrvQuerySeveral entity) {
        List<PropertyEntry> entryList = new ArrayList<>(entity.getStatusParamList().size() * 6);
        long ts = System.currentTimeMillis();
        for (VrvStatusParam param : entity.getStatusParamList()) {
            String address = String.format("%03d%03d", param.getOutdoorUnitAddress(), param.getIndoorUnitAddress());
            String prefix = deviceId + address;
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "switchStatus")
                    .propValue(param.isOpened() ? "1" : "0")
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acTemp")
                    .propValue(Integer.toString(param.getSettingTemperature()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acMode")
                    .propValue(Integer.toString(param.getMode()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acWindSpeed")
                    .propValue(Long.toString(param.getWindSpeed()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "temperature")
                    .propValue(Integer.toString(param.getIndoorTemperature()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "faultCodes")
                    .propValue(Integer.toString(param.getFaultCode()))
                    .build());
        }

        return entryList;
    }

    /**
     * 多联机查询网关上所有空调响应数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   多联机遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeVrvQueryAll entity) {
        List<PropertyEntry> entryList = new ArrayList<>(entity.getStatusParamList().size() * 6);
        long ts = System.currentTimeMillis();
        for (VrvStatusParam param : entity.getStatusParamList()) {
            String address = String.format("%03d%03d", param.getOutdoorUnitAddress(), param.getIndoorUnitAddress());
            String prefix = deviceId + address;
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "switchStatus")
                    .propValue(param.isOpened() ? "1" : "0")
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acTemp")
                    .propValue(Integer.toString(param.getSettingTemperature()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acMode")
                    .propValue(Integer.toString(param.getMode()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "acWindSpeed")
                    .propValue(Long.toString(param.getWindSpeed()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "temperature")
                    .propValue(Integer.toString(param.getIndoorTemperature()))
                    .build());
            entryList.add(PropertyEntry.builder()
                    .ts(ts)
                    .propId(prefix + "faultCodes")
                    .propValue(Integer.toString(param.getFaultCode()))
                    .build());
        }

        return entryList;
    }

    /**
     * 智能吊扇控制器遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   智能吊扇控制器遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeFanTelemetry entity) {
        List<PropertyEntry> entryList = new ArrayList<>(2);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "gear")
                .propValue(Integer.toString(entity.getGear()))
                .build());

        return entryList;
    }

    /**
     * 智能吊扇控制器查询响应转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   智能吊扇控制器查询响应实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeQueryFanDevice entity) {
        List<PropertyEntry> entryList = new ArrayList<>(2);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "gear")
                .propValue(Integer.toString(entity.getGear()))
                .build());

        return entryList;
    }

    /**
     * 智能吊扇控制器控制响应数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   智能吊扇控制器控制响应数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeControlFanDevice entity) {
        List<PropertyEntry> entryList = new ArrayList<>(2);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "gear")
                .propValue(Integer.toString(entity.getGear()))
                .build());

        return entryList;
    }

    /**
     * 办公锁遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   办公锁遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeLockTelemetry entity) {
        List<PropertyEntry> entryList = new ArrayList<>(3);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "batteryVoltage")
                .propValue(Integer.toString(entity.getBatteryVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "lowVoltage")
                .propValue(Integer.toString(entity.getLowVoltage()))
                .build());

        return entryList;
    }

    /**
     * 办公锁事件转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   办公锁事件实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeLockEvent entity) {
        List<PropertyEntry> entryList = new ArrayList<>(3);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "batteryVoltage")
                .propValue(Integer.toString(entity.getBatteryVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "switchStatus")
                .propValue(Integer.toString(entity.getSwitchStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "lowVoltage")
                .propValue(Integer.toString(entity.getLowVoltage()))
                .build());

        return entryList;
    }

    /**
     * 烟感遥测数据转换成PropertyEntry实体列表
     *
     * @param deviceId 设备uid
     * @param entity   烟感遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getPropertyEntryList(String deviceId, IeSmokeEvent entity) {
        List<PropertyEntry> entryList = new ArrayList<>(8);
        long ts = System.currentTimeMillis();
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "smokeStatus")
                .propValue(Integer.toString(entity.getSmokeStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "smokeDensity")
                .propValue(Integer.toString(entity.getSmokeDensity()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "tempStatus")
                .propValue(Integer.toString(entity.getTempStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "temperature")
                .propValue(Integer.toString(entity.getTemperature()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "batteryVoltageStatus")
                .propValue(Integer.toString(entity.getBatteryVoltageStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "batteryVoltage")
                .propValue(Integer.toString(entity.getBatteryVoltage()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "tamperStatus")
                .propValue(Integer.toString(entity.getTamperStatus()))
                .build());
        entryList.add(PropertyEntry.builder()
                .ts(ts)
                .propId(deviceId + "mode")
                .propValue(Integer.toString(entity.getMode()))
                .build());

        return entryList;
    }

    /**
     * 门磁事件转换成PropertyEntry实体列表
     * 目前只保存门磁状态
     *
     * @param deviceId 设备uid
     * @param entity   通用协议遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getDoorConcatPropertyEntryList(String deviceId, IeUniversalMessage entity) {
        List<PropertyEntry> entryList = new ArrayList<>(1);
        long ts = System.currentTimeMillis();
        for (Attribute attribute : entity.getAttributeList()) {
            if (attribute.getAttributeType() == UniversalAttributeType.DOOR_CONTACT_STATUS) {
                entryList.add(PropertyEntry.builder()
                        .ts(ts)
                        .propId(deviceId + String.format("%03d", attribute.getDefenseZoneNumber()) + attribute.getAttributeType().getName())
                        .propValue(attribute.getValue())
                        .build());
                break;
            }
        }

        return entryList;
    }

    /**
     * 人体感应模块事件转换成PropertyEntry实体列表
     * 目前保存温度、湿度、电池电压、2.4G信号强度、亮度、人体检测状态
     *
     * @param deviceId 设备uid
     * @param entity   通用协议遥测数据实体对象
     * @return PropertyEntry实体列表
     */
    private static List<PropertyEntry> getHumanDetectionPropertyEntryList(String deviceId, IeUniversalMessage entity) {
        List<PropertyEntry> entryList = new ArrayList<>(6);
        long ts = System.currentTimeMillis();
        for (Attribute attribute : entity.getAttributeList()) {
            switch (attribute.getAttributeType()) {
                case EVENT:
                    // 从事件中找出有人告警和无人恢复这两个事件进行存储
                    int eventId = (Integer.parseInt(attribute.getValue()) >> 8) & 0xFF;
                    UniversalEventType eventType = UniversalEventType.typeFor(eventId);
                    if (eventType != UniversalEventType.SOMEBODY_ALARM && eventType != UniversalEventType.NOBODY_RECOVERY) {
                        continue;
                    }
                    entryList.add(PropertyEntry.builder()
                            .ts(ts)
                            .propId(deviceId + String.format("%03d", attribute.getDefenseZoneNumber()) + "detectStatus")
                            .propValue(eventType == UniversalEventType.SOMEBODY_ALARM ? "1" : "0")
                            .build());
                    break;
                case TEMPERATURE_ONE_BYTE:
                case HUMIDITY:
                case BRIGHTNESS:
                case G24_SIGNAL:
                case BRIGHTNESS_VOLTAGE:
                    entryList.add(PropertyEntry.builder()
                            .ts(ts)
                            .propId(deviceId + String.format("%03d", attribute.getDefenseZoneNumber()) + attribute.getAttributeType().getName())
                            .propValue(attribute.getValue())
                            .build());
                    break;
                default:
                    break;
            }
        }

        return entryList;
    }
}
