package com.hd.daq.plugins.shike.iot.hex.ie.universal;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 通用消息信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeUniversalMessage implements IInformationElement {
    /**
     * 设备类型码
     */
    private int deviceTypeCode;
    /**
     * 设备属性集合
     */
    private List<Attribute> attributeList;
    /**
     * 二层命令码
     */
    private int cmdCode;
    /**
     * RfData中cmd值
     */
    private int rfDataCmdCode;

    /**
     * 解码为实体对象
     * @param cls 属性实体类
     * @param rfDataCmdCode 一层命令码
     * @param buf 缓冲区
     * @param <T> 属性的子类
     * @return 实体对象
     */
    public static <T extends Attribute> IeUniversalMessage decode(Class<T> cls, int rfDataCmdCode, byte[] buf) {
        if (buf.length < 6) {
            return null;
        }
        List<Attribute> attributeList = AttributeUtils.decode(cls, buf, 2, buf.length - 2);
        if (attributeList.size() == 0) {
            return null;
        }
        return IeUniversalMessage.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .cmdCode(Byte.toUnsignedInt(buf[1]))
                .rfDataCmdCode(rfDataCmdCode)
                .attributeList(attributeList)
                .build();
    }

    /**
     * 编码信息体元素(设备上行，不需要编码)
     *
     * @return 字符串数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        throw new EncodeException();
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
        return AttributeUtils.getMessageStorageType(this);
    }
}
