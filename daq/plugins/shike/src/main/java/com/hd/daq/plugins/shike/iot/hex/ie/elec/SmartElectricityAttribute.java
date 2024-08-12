package com.hd.daq.plugins.shike.iot.hex.ie.elec;

import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * 智慧用电终端属性实现类
 *
 * @author ymm
 */
@Slf4j
public class SmartElectricityAttribute extends Attribute {
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
            case VOLTAGE:
            case OVER_VOLTAGE_THRESHOLD:
            case UNDER_VOLTAGE_THRESHOLD:
            case CURRENT:
            case RESIDUAL_CURRENT:
            case RESIDUAL_CURRENT_OVER_CURRENT_THRESHOLD:
            case CT:
            case TEMPERATURE:
            case HEARTBEAT_INTERVAL_SECOND:
            case EVENT:
                setValue = Integer.parseInt(value);
                setValue &= 0xFFFF;
                dest = new byte[4];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 2;
                dest[2] = (byte) (setValue >> 8);
                dest[3] = (byte) (setValue & 0xFF);
                break;
            case OVER_CURRENT_THRESHOLD:
                setValue = Integer.parseInt(value);
                // 转换成10mA的单位
                setValue /= 10;
                setValue &= 0xFFFF;
                dest = new byte[4];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 2;
                dest[2] = (byte) (setValue >> 8);
                dest[3] = (byte) (setValue & 0xFF);
                break;
            // 1字节
            case VOLTAGE_STATUS:
            case ENABLE_VOLTAGE_ALARM:
            case CURRENT_STATUS:
            case ENABLE_CURRENT_ALARM:
            case RESIDUAL_CURRENT_STATUS:
            case ENABLE_RESIDUAL_CURRENT_ALARM:
            case TEMPERATURE_STATUS:
            case OVER_TEMPERATURE_THRESHOLD:
            case ENABLE_TEMPERATURE_ALARM:
            case POWER_FACTOR:
            case OUTPUT_DEFENCE_AREA_STATUS:
            case ENABLE_OUTPUT_DEFENCE_AREA_LINKAGE:
            case ALARM_MAIN_SWITCH:
            case DEVICE_ALARM_STATUS:
            case BUZZER_STATUS:
            case ENABLE_BUZZER:
            case AC_STATUS:
                setValue = Integer.parseInt(value);
                setValue &= 0xFF;
                dest = new byte[3];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 1;
                dest[2] = (byte) setValue;
                break;
            //4字节
            case ACCUMULATED_POWER:
                setValue = (int) Long.parseLong(value);
                dest = new byte[6];
                dest[0] = (byte) attributeType.getId();
                dest[1] = 4;
                dest[2] = (byte) (setValue >> 24);
                dest[3] = (byte) ((setValue & 0xFF0000) >> 16);
                dest[4] = (byte) ((setValue & 0xFF00) >> 8);
                dest[5] = (byte) (setValue & 0xFF);
                break;
            //8字节
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
            case CURRENT:
            case OVER_CURRENT_THRESHOLD:
                content = Integer.toString(toInt(buf, offset, len) * 10);
                break;
            case TEMPERATURE:
                int temp = toInt(buf, offset, len);
                if (temp != 0xFFFF) {
                    content = String.format("%.1f", temp * 0.1);
                }
                break;
            case ACCUMULATED_POWER:
                content = Long.toString(toLong(buf, offset, len));
                break;
            default:
                content = Integer.toString(toInt(buf, offset, len));
                break;
        }
        return content;
    }
}
