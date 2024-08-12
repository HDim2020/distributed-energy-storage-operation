package com.hd.daq.plugins.shike.iot.hex.ie.human;

import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalAttributeType;
import lombok.extern.slf4j.Slf4j;

/**
 * ZH120微波人体检测模块属性实现类
 *
 * @author ymm
 */
@Slf4j
public class HumanDetectionAttribute extends Attribute {
    /**
     * 编码属性对象
     *
     * @return 编码后的字节数组
     */
    @Override
    public byte[] encode() {
        byte[] dest = null;
        int setValue;
        switch (attributeType) {
            // 2字节
            case EVENT:
            case HEARTBEAT_INTERVAL_SECOND:
            case NOBODY_DETECTION_TIME:
            case LINKAGE_TIME_START:
            case LINKAGE_TIME_END:
            case BRIGHTNESS_VOLTAGE:
                setValue = Integer.parseInt(value);
                setValue &= 0xFFFF;
                dest = new byte[4];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 2;
                dest[2] = (byte) (setValue >> 8);
                dest[3] = (byte) (setValue & 0xFF);
                break;
            // 1字节
            case TEMPERATURE_ONE_BYTE:
            case HUMIDITY:
            case BRIGHTNESS:
            case G24_SIGNAL:
            case BRIGHTNESS_THRESHOLD:
                setValue = Integer.parseInt(value);
                setValue &= 0xFF;
                dest = new byte[3];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 1;
                dest[2] = (byte) setValue;
                break;
            default:
                log.warn("属性{}不支持编码", attributeType.getId());
                break;
        }

        return dest;
    }

    /**
     * 解码属性值
     *
     * @param buf    缓冲区
     * @param offset 偏移量
     * @param len    长度
     * @return 属性值字符串
     */
    @Override
    protected String decodeValue(byte[] buf, int offset, int len) {
        if (attributeType == UniversalAttributeType.TEMPERATURE_ONE_BYTE) {
            //温度是有符号的
            return Integer.toString(buf[offset]);
        } else {
            return Integer.toString(toInt(buf, offset, len));
        }
    }
}
