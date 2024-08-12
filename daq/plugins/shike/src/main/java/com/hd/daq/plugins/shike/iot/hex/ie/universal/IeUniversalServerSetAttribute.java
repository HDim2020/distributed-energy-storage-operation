package com.hd.daq.plugins.shike.iot.hex.ie.universal;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务器下发通用设置属性请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeUniversalServerSetAttribute implements IInformationElement {
    /**
     * 设备类型码
     */
    private int deviceTypeCode;

    /**
     * 属性集合
     */
    private List<Attribute> attributeList;

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        ArrayList<Byte> byteArrayList = AttributeUtils.encode(attributeList);
        byte[] buf = new byte[2 + byteArrayList.size()];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        int i = 2;
        for (Byte b : byteArrayList) {
            buf[i++] = b;
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
        return DeviceCmdType.CMD_21.getId();
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