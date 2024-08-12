package com.hd.daq.plugins.shike.iot.hex.ie.elecmeter;

import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalAttributeType;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * ZH6410红外抄表模块属性实现类
 *
 * @author ymm
 */
@Slf4j
public class ElectricityMeterAttribute extends Attribute {
    /**
     * 编码属性对象
     *
     * @return 编码后的字节数组
     */
    @Override
    public byte[] encode() {
        byte[] dest = null;
        int setValue;
        // 2字节
        if (Objects.requireNonNull(attributeType) == UniversalAttributeType.HEARTBEAT_INTERVAL_SECOND) {
            setValue = Integer.parseInt(value);
            setValue &= 0xFFFF;
            dest = new byte[4];
            dest[0] = (byte) attributeType.getId();
            dest[1] = 2;
            dest[2] = (byte) (setValue >> 8);
            dest[3] = (byte) (setValue & 0xFF);
        } else {
            log.warn("属性{}不支持编码", attributeType.getId());
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
            case ELECTRICITY_METER_NUMBER:
                content = convertBcdToString(buf, offset, len);
                break;
            default:
                content = Integer.toString(toInt(buf, offset, len));
                break;
        }
        return content;
    }
}
