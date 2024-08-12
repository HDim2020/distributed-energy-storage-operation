package com.hd.daq.plugins.shike.iot.hex.ie.ac;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 控制空调风速信息体元素（服务器下行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeServerSetAirConditionCombination implements IInformationElement {
    /**
     * 空调控制码 2字节
     */
    private int code;
    /**
     * 风速（1字节，00=自动 01=1档 02=2档 03=3档 其余无效）
     */
    private List<IeAirConditionCombinationCmd> cmdList;

    /**
     * 编码信息体元素
     *
     * @return 字符串数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[4 + cmdList.size() * 2];
        buf[0] = (byte) getCmdCode();
        buf[1] = (byte) (code >> 8);
        buf[2] = (byte) (code & 255);
        buf[3] = (byte) cmdList.size();
        int index = 4;
        for (IeAirConditionCombinationCmd cmd : cmdList) {
            buf[index++] = (byte) cmd.getCmdCode();
            buf[index++] = (byte) cmd.getInstruct();
        }

        return buf;
    }

    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_09.getId();
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
