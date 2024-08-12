package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.iot.hex.TlvType;

/**
 * 服务器发送给设备的消息
 *
 * @author ymm
 */
public interface IServerToDeviceMessage {
    /**
     * 获取设备ID
     *
     * @return
     */
    String getUid();

    /**
     * 转换成信息体元素对象
     *
     * @return 信息体元素对象
     */
    IInformationElement to();

    /**
     * 获取TLV类型
     *
     * @return TLV类型
     */
    default TlvType getTlvType() {
        return TlvType.RF_DATA;
    }
}
