package com.hd.daq.plugins.shike.iot.hex.ie.smoke;

import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.IInformationElement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 烟感服务器下发设置参数请求信息体元素（服务下行）
 *
 * @author ymm
 */
@Builder
@Getter
public class IeServerSmokeConfig implements IInformationElement {
    /**
     * 设备类型码
     */
    private int deviceTypeCode;
    /**
     * 指令
     */
    private int instruct;
    /**
     * 数据集合
     */
    private List<Integer> dataList;

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() {
        byte[] data = null;
        switch (instruct) {
            case 0x81:
            case 0x82:
            case 0x86:
                if (dataList.size() > 0) {
                    data = new byte[1];
                    data[0] = dataList.get(0).byteValue();
                }
                break;
            case 0x83:
                if (dataList.size() > 0) {
                    data = new byte[2];
                    data[0] = (byte) ((dataList.get(0) >> 8) & 0xFF);
                    data[1] = (byte) (dataList.get(0) & 0xFF);
                }
                break;
            case 0x84:
            case 0x85:
                if (dataList.size() > 1) {
                    data = new byte[2];
                    data[0] = (byte) (dataList.get(0) & 0xFF);
                    data[1] = (byte) (dataList.get(1) & 0xFF);
                }
                break;
            case 0x8F:
                if (dataList.size() > 6) {
                    data = new byte[12];
                    data[0] = (byte) (dataList.get(0) & 0xFF);
                    data[1] = (byte) ((dataList.get(1) >> 8) & 0xFF);
                    data[2] = (byte) (dataList.get(1) & 0xFF);
                    data[3] = (byte) (dataList.get(2) & 0xFF);
                    data[4] = (byte) (dataList.get(3) & 0xFF);
                    data[5] = (byte) (dataList.get(4) & 0xFF);
                    data[6] = (byte) (dataList.get(5) & 0xFF);
                    data[7] = (byte) (dataList.get(6) & 0xFF);
                }
                break;
            default:
                break;
        }
        if (data == null) {
            return null;
        }
        byte[] buf = new byte[3 + data.length];
        buf[0] = (byte) deviceTypeCode;
        buf[1] = (byte) getCmdCode();
        buf[2] = (byte) instruct;
        System.arraycopy(data, 0, buf, 3, data.length);

        return buf;
    }

    /**
     * 获取命令编码
     *
     * @return 命令编码
     */
    @Override
    public int getCmdCode() {
        return DeviceCmdType.CMD_01.getId();
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
