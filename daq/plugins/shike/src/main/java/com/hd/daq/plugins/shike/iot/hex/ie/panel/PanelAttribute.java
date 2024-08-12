package com.hd.daq.plugins.shike.iot.hex.ie.panel;

import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalAttributeType;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.DeviceType;
import lombok.extern.slf4j.Slf4j;

/**
 * 智能开关面板属性实现类
 *
 * @author ymm
 */
@Slf4j
public class PanelAttribute extends Attribute {
    /**
     * 编码属性对象
     *
     * @return 编码后的字节数组
     */
    @Override
    public byte[] encode() {
        byte[] dest = null;
        int setValue;
        if (attributeType == UniversalAttributeType.SWITCH_STATUS) {
            setValue = Integer.parseInt(value);
            setValue &= 1;
            dest = new byte[3];
            dest[0] = (byte) attributeType.getId();
            dest[1] = 1;
            dest[2] = (byte) setValue;
        } else {
            log.warn("{}是未知的属性，不支持编码", attributeType.getId());
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
        if (attributeType == UniversalAttributeType.SWITCH_STATUS) {
            content = Integer.toString(toInt(buf, offset, len));
        } else {
            log.warn("{}是未知的属性，不支持解码", attributeType.getId());
        }
        return content;
    }

    /**
     * 判断是否是开关面板设备
     *
     * @param deviceType 设备类型枚举
     * @return 是否开关面板设备
     */
    public static boolean isPanelDevice(DeviceType deviceType) {
        if (deviceType == null) {
            return false;
        }
        switch (deviceType) {
            case ZH101_01:
            case ZH101_09:
            case ZH101_0A:
            case ZH101_0B:
            case ZH101_0C:
            case ZH101_0D:
            case ZH101_0E:
            case ZH101_0F:
                return true;
            default:
                return false;
        }
    }
}
