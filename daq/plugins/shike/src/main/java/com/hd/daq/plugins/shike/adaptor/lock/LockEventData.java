package com.hd.daq.plugins.shike.adaptor.lock;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.lock.IeLockEvent;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * 队列消息data部分--办公锁事件上行消息（设备上行）
 *
 * @author ymm
 */
@Slf4j
@Builder
@Getter
public class LockEventData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 电池电压 mv 2字节
     */
    private String batteryVoltage;
    /**
     * 锁状态 Bit0
     */
    private String switchStatus;
    /**
     * 低压标识符，Bit2
     */
    private String lowVoltage;
    /**
     * 事件ID
     */
    private String eventsInfo;


    /**
     * 创建LockEventData实体对象
     *
     * @param rfData RfData实体对象
     * @return LockEventData实体对象
     */
    public static LockEventData from(RfData rfData) {
        IeLockEvent ie = (IeLockEvent) rfData.getData();
        return LockEventData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(ie.getDeviceTypeCode().toString())
                .switchStatus(Integer.toString(ie.getSwitchStatus()))
                .batteryVoltage(Integer.toString(ie.getBatteryVoltage()))
                .lowVoltage(Integer.toString(ie.getLowVoltage()))
                .eventsInfo(getEventDescription(ie.getEventId(), ie.getSubEventId(), ie.getEventData()))
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_LOCK_EVENT.getName();
    }

    /**
     * 获取事件描述信息
     *
     * @param eventId    事件ID
     * @param subEventId 子事件ID
     * @param eventData  事件数据
     * @return 事件描述信息
     */
    private static String getEventDescription(int eventId, int subEventId, String eventData) {
        String dest = "";
        switch (eventId) {
            case 0x01:
                dest = getOpenLockEventDescription(subEventId, eventData);
                break;
            case 0x03:
                dest = getRemindEventDescription(subEventId, eventData);
                break;
            case 0x06:
                dest = getLocalReadCardEventDescription(subEventId, eventData);
                break;
            default:
                break;
        }

        return dest;
    }

    /**
     * 获取开锁事件描述信息
     *
     * @param subEventId 开锁子事件ID
     * @param eventData  事件数据
     * @return 事件描述信息
     */
    private static String getOpenLockEventDescription(int subEventId, String eventData) {
        String type = "";
        switch (subEventId) {
            case 0x00:
                type = "默认用户";
                break;
            case 0x02:
                type = "密码用户";
                break;
            case 0x03:
                type = "卡用户";
                break;
            case 0x04:
                type = "钥匙用户";
                break;
            case 0x05:
                type = "手机(微信)用户";
                break;
            case 0x06:
                type = "临时密码用户";
                break;
            case 0x07:
                type = "临时卡用户";
                break;
            default:
                break;
        }
        return type + "[" + eventData + "]开锁";
    }

    /**
     * 获取提醒事件描述信息
     *
     * @param subEventId 提醒子事件ID
     * @param eventData  事件数据
     * @return 事件描述信息
     */
    private static String getRemindEventDescription(int subEventId, String eventData) {
        String type = "";
        switch (subEventId) {
            case 0x02:
                type = "电池电量低";
                break;
            case 0x04:
                type = "恢复出厂设置";
                break;
            default:
                break;
        }
        return "提醒:" + type;
    }

    /**
     * 获取本地读卡事件描述信息
     *
     * @param subEventId 本地读卡子事件ID
     * @param eventData  事件数据
     * @return 事件描述信息
     */
    private static String getLocalReadCardEventDescription(int subEventId, String eventData) {
        String type = "";
        switch (subEventId) {
            case 0x01:
                type = "读卡[" + eventData + "]成功";
                break;
            case 0x03:
                type = "超时失败";
                break;
            case 0x04:
                type = "退出读卡";
                break;
            default:
                break;
        }
        return "本地读卡:" + type;
    }
}
