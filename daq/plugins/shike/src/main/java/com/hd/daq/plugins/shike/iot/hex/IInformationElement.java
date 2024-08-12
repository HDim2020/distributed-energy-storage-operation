package com.hd.daq.plugins.shike.iot.hex;

import com.hd.daq.plugins.shike.iot.IEncodable;

/**
 * 信息体元素接口
 *
 * @author ymm
 */
public interface IInformationElement extends IEncodable {
    /**
     * 属性消息
     */
    int PROPERTY_MSG = 1;
    /**
     * 设备消息
     */
    int DEVICE_MSG = 2;
    /**
     * 服务消息(有交互)
     */
    int SERVICE_MSG = 4;
    /**
     * 获取命令编码
     *
     * @return 命令编码
     */
    int getCmdCode();

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    int getRfDataCmdCode();

    /**
     * 获取TLV类型
     *
     * @return TLV类型
     */
    default TlvType getTlvType() {
        return TlvType.RF_DATA;
    }

    /**
     * 获取设备类型码
     *
     * @return 有支持时返回整数，不支持时返回null
     */
    default Integer getDeviceTypeCode() {
        return null;
    }

    /**
     * 获取消息存储类型
     * @return 多个存储类型的并集
     */
    int getMessageStorageType();
}
