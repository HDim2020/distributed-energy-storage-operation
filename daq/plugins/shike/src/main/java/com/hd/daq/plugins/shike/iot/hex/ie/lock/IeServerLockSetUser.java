package com.hd.daq.plugins.shike.iot.hex.ie.lock;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.util.ByteArrayUtil;
import com.hd.daq.plugins.shike.util.ByteUtil;
import lombok.Builder;
import lombok.Getter;

/**
 * 办公锁服务器下发设置指定ID授权密码/卡号请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerLockSetUser implements IInformationElement {
    /**
     * 设备类型码
     */
    private int deviceTypeCode;
    /**
     * 授权类型 0x01--密码 0x02--卡号
     */
    private int authorizationType;
    /**
     * 密码或者卡号
     */
    private String passwordOrCardId;
    /**
     * 过期时间，unix时间4字节 -1表示不过期
     */
    private int expiredTime;
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        byte[] buf = new byte[10 + passwordOrCardId.length()];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        buf[2] = (byte) authorizationType;
        int len = passwordOrCardId.length();
        buf[3] = (byte) len;
        ByteArrayUtil.stringToBytes(passwordOrCardId, buf, 4);
        byte[] bytes = ByteUtil.intToBytes(expiredTime);
        System.arraycopy(bytes, 0, buf, 4 + len, 4);
        bytes = ByteUtil.shortToBytes((short) userId);
        System.arraycopy(bytes, 0, buf, 8 + len, 2);

        return buf;
    }

    /**
     * 获取命令编码
     *
     * @return 命令编码
     */
    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_0D.getId();
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
