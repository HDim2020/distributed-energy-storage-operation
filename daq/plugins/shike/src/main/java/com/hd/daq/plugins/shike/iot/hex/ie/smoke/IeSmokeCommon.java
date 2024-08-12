package com.hd.daq.plugins.shike.iot.hex.ie.smoke;

import com.hd.daq.plugins.shike.iot.hex.IInformationElement;


/**
 * 烟感通用数据解析信息体元素（设备上行）
 *
 * @author ymm
 */
public class IeSmokeCommon {
    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IInformationElement decode(byte[] buf) {
        if (buf.length < 35) {
            return null;
        }
        SmokeEventType eventType = SmokeEventType.typeFor(Byte.toUnsignedInt(buf[5]));
        switch (eventType) {
            //上传事件
            case HEARTBEAT:
            case SMOKE_ALARM:
            case SMOKE_ALARM_RECOVERY:
            case TEST:
            case OVER_TEMP_ALARM:
            case OVER_TEMP_RECOVERY:
            case LOW_VOLTAGE_ALARM:
            case LOW_VOLTAGE_RECOVERY:
            case STARTUP:
            case LOW_TEMP_ALARM:
            case LOW_TEMP_RECOVERY:
            case TAMPER_ALARM:
            case TAMPER_RECOVERY:
                return IeSmokeEvent.decode(buf);
                //设置响应
            default:
                return IeSmokeResponse.decode(buf);
        }
    }
}
