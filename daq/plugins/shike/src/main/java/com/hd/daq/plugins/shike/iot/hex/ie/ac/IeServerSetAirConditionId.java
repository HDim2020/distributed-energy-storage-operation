package com.hd.daq.plugins.shike.iot.hex.ie.ac;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

/**
 * 服务器请求设置空调ID信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerSetAirConditionId implements IInformationElement {
    /**
     * 空调控制码 2字节
     */
    private int code;
    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[3];
        buf[0] = (byte) getCmdCode();
        buf[1] = (byte) (code >> 8);
        buf[2] = (byte) (code & 255);

        return buf;
    }

    /**
     * 获取命令编码
     *
     * @return 命令编码
     */
    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_0B.getId();
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
