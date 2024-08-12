package com.hd.daq.plugins.shike.iot.hex.ie.ac;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

/**
 * 控制空调温度信息体元素（服务器下行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeServerSetAirConditionTemp implements IInformationElement {
    /**
     * 空调控制码 2字节
     */
    private int code;
    /**
     * 温度值（1字节，范围：10H - 1EH  （ 16-31 度）其余无效）
     */
    private int temperature;

    /**
     * 编码信息体元素
     *
     * @return 字符串数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[4];
        buf[0] = (byte) getCmdCode();
        buf[1] = (byte) (code >> 8);
        buf[2] = (byte) (code & 255);
        buf[3] = (byte) temperature;

        return buf;
    }

    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_06.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_31.getId();
    }

    /**
     * 获取消息存储类型
     *
     * @return 多个存储类型的并集
     */
    @Override
    public int getMessageStorageType() {
        return 0;
    }
}
