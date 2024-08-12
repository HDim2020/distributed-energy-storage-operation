package com.hd.daq.plugins.shike.iot.hex.ie.lock;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 办公锁服务器下发删除用户请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerLockDeleteUser implements IInformationElement {
    /**
     * 设备类型码
     */
    private int deviceTypeCode;
    /**
     * 待删除用户列表
     */
    private List<Integer> userList;

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[3 + userList.size() * 2];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        buf[2] = (byte) userList.size();
        int i = 0;
        for (Integer id : userList) {
            buf[3 + 2 * i] = (byte) (id.shortValue() >> 8);
            buf[4 + 2 * i] = (byte) (id.shortValue() & 0xFF);
            ++i;
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
        return DeviceCmdType.CMD_0A.getId();
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
     * 获取消息存储类型
     *
     * @return 多个存储类型的并集
     */
    @Override
    public int getMessageStorageType() {
        return 0;
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
}
