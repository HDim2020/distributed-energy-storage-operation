package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 多联机服务器下发查询部分空调请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeVrvServerQuerySeveral implements IInformationElement {
    /**
     * 设备类型码
     */
    private final int deviceTypeCode = 0x7F;
    /**
     * 空调地址集合
     */
    private List<Integer> addressList;

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[4 + 2 * addressList.size()];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        buf[2] = (byte) (addressList.size() > 1 ? 0x0F : 0x01);
        buf[3] = (byte) addressList.size();
        int index = 4;
        for (Integer address : addressList) {
            buf[index++] = (byte) (address >> 8);
            buf[index++] = (byte) (address & 0xFF);
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
        return DeviceCmdType.CMD_50.getId();
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
