package com.hd.daq.plugins.shike.iot.hex.ie.universal;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.iot.hex.ie.DeviceType;
import com.hd.daq.plugins.shike.iot.hex.ie.door.DoorContactAttribute;
import com.hd.daq.plugins.shike.iot.hex.ie.elec.SmartElectricityAttribute;
import com.hd.daq.plugins.shike.iot.hex.ie.elecmeter.ElectricityMeterAttribute;
import com.hd.daq.plugins.shike.iot.hex.ie.human.HumanDetectionAttribute;
import com.hd.daq.plugins.shike.iot.hex.ie.panel.PanelAttribute;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 属性工具类
 *
 * @author ymm
 */
@Slf4j
public class AttributeUtils {
    /**
     * 解码属性
     *
     * @param buf    缓冲区
     * @param offset 偏移量
     * @param len    长度
     * @return 属性集合
     */
    public static <T extends Attribute> List<Attribute> decode(Class<T> cls, byte[] buf, int offset, int len) {
        List<Attribute> attributeList = new ArrayList<>();
        Attribute attribute;
        int index = offset;
        final int endIndex = offset + len;
        int step = 0;
        int defenseZoneNumber = -1;
        int attributeCount = -1;
        while (index < endIndex) {
            if (step == 0) {
                // 解析防区号
                defenseZoneNumber = Byte.toUnsignedInt(buf[index++]);
                attributeCount = -1;
                step = 1;
            } else if (step == 1) {
                // 解析属性个数
                attributeCount = Byte.toUnsignedInt(buf[index++]);
                step = 2;
            } else {
                //解析每个属性
                for (int i = 0; i < attributeCount; ++i) {
                    // 确保索引不溢出
                    if (index + 3 > endIndex) {
                        break;
                    }
                    // 属性ID
                    int id = ((Byte.toUnsignedInt(buf[index + 1]) >> 4) << 8) | Byte.toUnsignedInt(buf[index]);
                    // 属性内容长度
                    int contentLen = Byte.toUnsignedInt(buf[index + 1]) & 15;
                    // 属性内容偏移值
                    int contentOffset = 0;
                    if (contentLen == 0) {
                        contentLen = Byte.toUnsignedInt(buf[index + 2]);
                        contentOffset = 1;
                    }
                    //指向属性内容的首字节
                    index += 2 + contentOffset;
                    // 确保索引不溢出
                    if (index + contentLen > endIndex) {
                        break;
                    }
                    //解码属性内容
                    try {
                        attribute = cls.newInstance();
                    } catch (IllegalAccessException | InstantiationException e) {
                        log.debug("实例化子类{}异常:{}", cls.getName(), e.getCause().getMessage());
                        return attributeList;
                    }
                    attribute.setDefenseZoneNumber(defenseZoneNumber);
                    UniversalAttributeType attributeType = UniversalAttributeType.typeFor(id);
                    if (attributeType != null) {
                        attribute.setAttributeType(attributeType);
                        String value = attribute.decodeValue(buf, index, contentLen);
                        if (value != null) {
                            attribute.setValue(value);
                            attributeList.add(attribute);
                        }
                    }
                    index += contentLen;
                }
                step = 0;
            }
        }

        return attributeList;
    }

    /**
     * 将属性集合编码成字节列表
     *
     * @param attributeList 属性集合
     * @return 字节列表
     */
    public static ArrayList<Byte> encode(List<Attribute> attributeList) {
        // 将属性按照防区号分组并从小到大排列
        TreeMap<Integer, List<Attribute>> listMap = new TreeMap<>();
        for (Attribute attribute : attributeList) {
            List<Attribute> attributes = listMap.computeIfAbsent(attribute.getDefenseZoneNumber(), k -> new ArrayList<>());
            attributes.add(attribute);
        }
        ArrayList<Byte> dest = new ArrayList<>();
        for (Integer key : listMap.keySet()) {
            List<Attribute> attributes = listMap.get(key);
            dest.add(key.byteValue());
            dest.add((byte) attributes.size());
            for (Attribute attribute : attributes) {
                byte[] bytes = attribute.encode();
                for (byte b : bytes) {
                    dest.add(b);
                }
            }
        }

        return dest;
    }

    /**
     * TODO 增加新设备需要修改
     * 根据设备类型码获取属性的子类
     *
     * @param deviceTypeCode 设备类型码
     * @return 属性的子类
     */
    public static Class<? extends Attribute> getAttributeSubClass(int deviceTypeCode) {
        DeviceType deviceType = DeviceType.typeFor(deviceTypeCode);
        if (deviceType == null) {
            log.debug("未知的设备类型码:{}.", deviceTypeCode);
            return null;
        }
        switch (deviceType) {
            case SK_6100C:
            case SK_6100:
                return SmartElectricityAttribute.class;
            case ZHDT1B_H1:
                return DoorContactAttribute.class;
            case ZH120:
                return HumanDetectionAttribute.class;
            case ZH6410:
                return ElectricityMeterAttribute.class;
            default:
                if (PanelAttribute.isPanelDevice(deviceType)) {
                    return PanelAttribute.class;
                }
                log.debug("不支持的设备类型:{}.", deviceTypeCode);
                return null;
        }
    }

    /**
     * TODO 增加新设备需要修改
     * 获取消息存储类型
     *
     * @param ie 信息体
     * @return 消息存储类型的并集
     */
    public static int getMessageStorageType(IeUniversalMessage ie) {
        DeviceType deviceType = DeviceType.typeFor(ie.getDeviceTypeCode());
        if (deviceType == null) {
            return 0;
        }
        // 交互消息
        if (ie.getCmdCode() == DeviceCmdType.CMD_A1.getId() || ie.getCmdCode() == DeviceCmdType.CMD_A2.getId()) {
            if (PanelAttribute.isPanelDevice(deviceType) || deviceType == DeviceType.ZH6410) {
                return IInformationElement.SERVICE_MSG | IInformationElement.PROPERTY_MSG;
            }
            return IInformationElement.SERVICE_MSG;
        }
        int ret = 0;
        if (ie.getCmdCode() == DeviceCmdType.CMD_A3.getId()) {
            if (deviceType == DeviceType.SK_6100C || deviceType == DeviceType.SK_6100) {
                ret = IInformationElement.DEVICE_MSG;
                List<Attribute> attributeList = ie.getAttributeList();
                for (Attribute attribute : attributeList) {
                    // 有电压值的就认为是心跳数据，也即遥测数据
                    if (attribute.getAttributeType() == UniversalAttributeType.VOLTAGE) {
                        ret = IInformationElement.PROPERTY_MSG;
                        break;
                    }
                }
            } else {
                ret = IInformationElement.PROPERTY_MSG;
            }
        } else if (ie.getCmdCode() == DeviceCmdType.CMD_A4.getId()) {
            ret = IInformationElement.DEVICE_MSG;
            if (deviceType == DeviceType.ZHDT1B_H1 || deviceType == DeviceType.ZH120) {
                ret |= IInformationElement.PROPERTY_MSG;
            }
        }

        return ret;
    }
}
