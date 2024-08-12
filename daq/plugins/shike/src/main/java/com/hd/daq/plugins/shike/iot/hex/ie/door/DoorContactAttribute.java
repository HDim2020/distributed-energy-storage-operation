package com.hd.daq.plugins.shike.iot.hex.ie.door;

import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * 无线温湿度门磁属性实现类
 *
 * @author ymm
 */
@Slf4j
public class DoorContactAttribute extends Attribute {
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
            case TEMPERATURE:
            case BATTERY_VOLTAGE:
            case BATTERY_LOW_VOLTAGE_THRESHOLD:
            case VOLTAGE_VALUE:
                setValue = Integer.parseInt(value);
                setValue &= 0xFFFF;
                dest = new byte[4];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 2;
                dest[2] = (byte) (setValue >> 8);
                dest[3] = (byte) (setValue & 0xFF);
                break;
            // 1字节
            case BATTERY_VOLTAGE_STATUS:
            case HEARTBEAT_INTERVAL_MINUTE:
            case DOOR_CONTACT_STATUS:
            case HUMIDITY:
            case HEARTBEAT_INTERVAL_HOUR:
            case WATER_IMMERSION_STATUS:
                setValue = Integer.parseInt(value);
                setValue &= 0xFF;
                dest = new byte[3];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 1;
                dest[2] = (byte) setValue;
                break;
            // 8字节
            case VERSION:
                dest = new byte[9];
                dest[0] = (byte) attributeType.getId();
                break;
            default:
                log.warn("{}是只读的属性，不支持编码", attributeType.getId());
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
        String content = null;
        switch (attributeType) {
            case VERSION:
                content = new String(buf, offset, len, StandardCharsets.US_ASCII);
                break;
            case TEMPERATURE:
                int temp = toInt(buf, offset, len);
                int sign = 1;
                if (temp != 0xFFFF) {
                    if (temp > 0x7FFF) {
                        temp &= 0x7FFF;
                        sign = -1;
                    }
                    content = String.format("%.1f", temp * sign * 0.1);
                }
                break;
            case HUMIDITY:
                int humidity = toInt(buf, offset, len);
                if (humidity != 0XFF) {
                    content = Integer.toString(humidity);
                }
                break;
            default:
                content = Integer.toString(toInt(buf, offset, len));
                break;
        }
        return content;
    }
}
