package com.hd.daq.plugins.shike.adaptor.smoke;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.IeSmokeEvent;
import com.hd.daq.plugins.shike.iot.hex.ie.smoke.SmokeEventType;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * 队列消息data部分--烟感事件上行消息（设备上行）
 *
 * @author ymm
 */
@Slf4j
@Builder
@Getter
public class SmokeEventData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 事件信息
     */
    private String eventsInfo;


    /**
     * 创建SmokeEventData实体对象
     *
     * @param rfData RfData实体对象
     * @return SmokeEventData实体对象
     */
    public static SmokeEventData from(RfData rfData) {
        IeSmokeEvent ie = (IeSmokeEvent) rfData.getData();
        return SmokeEventData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(ie.getDeviceTypeCode().toString())
                .eventsInfo(getEventDescription(ie))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_SMOKE_EVENT.getName();
    }

    /**
     * 得到事件描述信息
     *
     * @param ie 烟感事件实体
     * @return 事件描述信息
     */
    private static String getEventDescription(IeSmokeEvent ie) {
        SmokeEventType type = SmokeEventType.typeFor(ie.getEventType());
        if (type == null) {
            log.debug("未知的烟感事件类型:{}.", ie.getEventType());
            return "";
        }
        return type.getName();
    }
}
