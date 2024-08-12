package com.hd.daq.plugins.shike.adaptor.human;

import com.hd.daq.plugins.shike.adaptor.AttributeData;
import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.IeUniversalMessage;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalAttributeType;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalEventType;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * 队列消息data部分--ZH166人体检测模块事件上行消息（设备上行）
 *
 * @author ymm
 */
@Slf4j
@Builder
@Getter
public class HumanDetectionEventData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 事件ID
     */
    private String eventsInfo;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 属性集合
     */
    private List<AttributeData> dataList;


    /**
     * 创建实体对象
     *
     * @param rfData RfData实体对象
     * @return 实体对象
     */
    public static HumanDetectionEventData from(RfData rfData) {
        IeUniversalMessage ie = (IeUniversalMessage) rfData.getData();
        String eventsInfo = "";
        List<AttributeData> dataList = new ArrayList<>();
        for (Attribute attribute : ie.getAttributeList()) {
            if (attribute.getAttributeType() == UniversalAttributeType.EVENT) {
                int value = Integer.parseInt(attribute.getValue());
                eventsInfo = getEventDescription(value >> 8, attribute.getDefenseZoneNumber());
            } else {
                dataList.add(
                        AttributeData
                                .builder()
                                .defenseZoneNumber(Integer.toString(attribute.getDefenseZoneNumber()))
                                .attributeId(Integer.toString(attribute.getAttributeType().getId()))
                                .value(attribute.getValue())
                                .build()
                );
            }
        }
        return HumanDetectionEventData.builder()
                .uid(rfData.getDeviceId())
                .eventsInfo(eventsInfo)
                .deviceType(ie.getDeviceTypeCode().toString())
                .dataList(dataList)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_DEVICE_EVENT_UPDATE_DB.getName();
    }

    /**
     * 得到事件描述信息
     * @param eventId 事件ID
     * @param defenseZoneNumber 防区号
     * @return 事件描述信息
     */
    private static String getEventDescription(int eventId, int defenseZoneNumber) {
        UniversalEventType eventType = UniversalEventType.typeFor(eventId);
        if (eventType == null) {
            log.debug("未知的事件ID:{}.", eventId);
            return "";
        }
        String dest = "";
        if (defenseZoneNumber > 0) {
            dest = defenseZoneNumber + "路防区";
        }
        dest += eventType.getName();

        return dest;
    }
}
