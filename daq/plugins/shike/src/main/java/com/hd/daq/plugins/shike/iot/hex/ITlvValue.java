package com.hd.daq.plugins.shike.iot.hex;

import com.hd.daq.plugins.shike.iot.IEncodable;

/**
 * TLV结构的Value接口
 * @author ymm
 */
public interface ITlvValue extends IEncodable {
    /**
     * 获取TLV结构的类型码
     * @return
     */
    TlvType getTlvType();
}
