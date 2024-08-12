package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 多联机服务器下发控制空调运行模式请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeVrvServerSetRunMode implements IInformationElement {
    /**
     * 设备类型码
     */
    private final int deviceTypeCode = 0x7F;
    /**
     * 控制参数，01：制冷 02：除湿 04 ：送风 08：制暖
     */
    private int instruct;
    /**
     * 空调地址集合，为空时表示控制全部
     */
    private List<Integer> addressList;

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        int len = 6;
        int count = 0xFF;
        if (addressList.size() > 0) {
            len = 4 + 2 * addressList.size();
            count = addressList.size();
        }
        byte[] buf = new byte[len];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        buf[2] = (byte) instruct;
        buf[3] = (byte) count;
        int index = 4;
        if (addressList.size() > 0) {
            for (Integer address : addressList) {
                buf[index++] = (byte) (address >> 8);
                buf[index++] = (byte) (address & 0xFF);
            }
        } else {
            buf[4] = (byte) 0xFF;
            buf[5] = (byte) 0xFF;
        }

        return buf;
    }

    /**
     * 获取命令编码
     *
     * @return 命令编码
     */
    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_33.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_73.getId();
    }

    /**
     * 获取设备类型码
     *
     * @return 设备类型码
     */
    @Override
    public Integer getDeviceTypeCode() {
        return deviceTypeCode;
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
