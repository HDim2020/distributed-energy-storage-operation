package com.hd.daq.plugins.shike.adaptor.socket;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.socket.IeSocketLostAcPowerEvent;
import lombok.Builder;
import lombok.Getter;


/**
 * 队列消息data部分--插座市电掉电上行消息（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class SocketLostAcPowerEventData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 事件ID
     */
    private String eventsInfo;

    /**
     * 创建SocketLostACPowerEventData实体对象
     *
     * @param rfData RfData实体对象
     * @return SocketLostACPowerEventData实体对象
     */
    public static SocketLostAcPowerEventData from(RfData rfData) {
        IeSocketLostAcPowerEvent ie = (IeSocketLostAcPowerEvent) rfData.getData();
        return SocketLostAcPowerEventData.builder()
                .uid(rfData.getDeviceId())
                .eventsInfo(SocketEventType.getEventName(ie.getEventId()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_SOCKET_DEVICE_EVENT.getName();
    }
}
