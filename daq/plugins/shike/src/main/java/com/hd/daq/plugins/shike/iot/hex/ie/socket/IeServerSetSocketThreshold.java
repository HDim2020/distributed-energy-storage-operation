package com.hd.daq.plugins.shike.iot.hex.ie.socket;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import com.hd.daq.plugins.shike.util.ByteArrayUtil;
import lombok.Builder;
import lombok.Getter;

/**
 * 插座服务器下发设置参数请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerSetSocketThreshold implements IInformationElement {
    /**
     * 过压保护 5字节
     */
    private String overVoltageProtection;
    /**
     * 欠压保护 5字节
     */
    private String underVoltageProtection;
    /**
     * 功率过载保护 5字节
     */
    private String overloadProtection;
    /**
     * 超温保护 3字节
     */
    private String overTempProtection;
    /**
     * 充电超时 1字节
     */
    private String chargingTimeout;
    /**
     * 功能控制项 1字节
     */
    private String functionControlItems;
    /**
     * 低功率保护 2字节
     */
    private String underPowerProtection;
    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        int underPowerLen = 0;
        if (underPowerProtection != null && !underPowerProtection.isEmpty()) {
            underPowerLen = 5;
        }
        byte[] buf = new byte[22 + underPowerLen];
        buf[0] = (byte) getCmdCode();
        // 1-5
        ByteArrayUtil.hexStringToBytes(overVoltageProtection, buf, 1);
        // 6-10
        ByteArrayUtil.hexStringToBytes(underVoltageProtection, buf, 6);
        // 11-15
        ByteArrayUtil.hexStringToBytes(overloadProtection, buf, 11);
        // 16-18
        ByteArrayUtil.hexStringToBytes(overTempProtection, buf, 16);
        //19-模式控制项
        if (underPowerLen < 1) {
            buf[19] = 1;
        }
        //20
        ByteArrayUtil.hexStringToBytes(chargingTimeout, buf, 20);
        // 21
        ByteArrayUtil.hexStringToBytes(functionControlItems, buf, 21);
        if (underPowerLen > 0) {
            //22-23
            ByteArrayUtil.hexStringToBytes(underPowerProtection, buf, 22);
            //24-26 保留
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
        return DeviceCmdType.CMD_14.getId();
    }

    /**
     * 获取RfData中cmd值
     *
     * @return 命令编码
     */
    @Override
    public int getRfDataCmdCode() {
        return DeviceCmdType.CMD_36.getId();
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
