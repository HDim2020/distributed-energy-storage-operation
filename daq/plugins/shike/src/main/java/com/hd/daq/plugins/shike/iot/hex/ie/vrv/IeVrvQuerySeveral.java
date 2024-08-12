package com.hd.daq.plugins.shike.iot.hex.ie.vrv;

import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 多联机查询部分空调响应信息体元素（设备上行）
 *
 * @author ymm
 */
@Builder
@Data
public class IeVrvQuerySeveral implements IInformationElement {
    /**
     * 设备类型码 1字节
     */
    private int deviceTypeCode;
    /**
     * 所有空调参数校验和 2字节
     */
    private int checkSum;
    /**
     * 状态参数集合
     */
    private List<VrvStatusParam> statusParamList;

    /**
     * 解码成实体对象
     *
     * @param buf 缓冲区
     * @return 实体对象
     */
    public static IeVrvQuerySeveral decode(byte[] buf) {
        if (buf.length < 6) {
            return null;
        }
        int count = Byte.toUnsignedInt(buf[5]);
        if (buf.length < 6 + 8 * count) {
            return null;
        }
        //解码空调状态参数
        List<VrvStatusParam> paramList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            paramList.add(VrvStatusParam.decode(buf, 6 + i * 8, 8));
        }
        return IeVrvQuerySeveral.builder()
                .deviceTypeCode(Byte.toUnsignedInt(buf[0]))
                .checkSum((Byte.toUnsignedInt(buf[3]) << 8) | Byte.toUnsignedInt(buf[4]))
                .statusParamList(paramList)
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
        return DeviceCmdType.CMD_F3.getId();
    }

    /**
     * 获取设备类型码
     *
     * @return 有支持时返回整数，不支持时返回null
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
        return SERVICE_MSG | PROPERTY_MSG;
    }
}
