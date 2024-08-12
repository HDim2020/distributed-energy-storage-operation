package com.hd.daq.plugins.shike.iot.hex;

import java.util.HashMap;
import java.util.Map;

/**
 * 探头设备协议中定义的命令类型
 *
 * @author ymm
 */
public enum DeviceCmdType {
    /**
     * 红外控制器命令0x00
     */
    CMD_00(0X00),
    /**
     * 0x01--添加设备时，设备应答服务器
     */
    CMD_01(0X01),
    /**
     * 0x02--设备上行
     */
    CMD_02(0x02),
    /**
     * 0x03--添加设备
     */
    CMD_03(0X03),
    /**
     * 0x04--打开或关闭空调
     */
    CMD_04(0X04),
    /**
     * 0x05--控制空调运行模式
     */
    CMD_05(0X05),
    /**
     * 0x06--控制空调温度
     */
    CMD_06(0X06),
    /**
     * 0x07--控制空调风速
     */
    CMD_07(0X07),
    /**
     * 0x08--控制空调风向
     */
    CMD_08(0X08),
    /**
     * 0x09--控制空调多命令组合
     */
    CMD_09(0X09),
    /**
     * 0x0A--查询空调ID
     */
    CMD_0A(0X0A),
    /**
     * 0x0B--设置空调ID
     */
    CMD_0B(0X0B),
    /**
     * 0x0D--办公锁设置密码或卡号
     */
    CMD_0D(0X0D),
    /**
     * 0x0E--办公锁设置进入本地读卡模式
     */
    CMD_0E(0X0E),
    /**
     * 0x0F--办公锁设置恢复出厂设置
     */
    CMD_0F(0X0F),
    /**
     * 0x10--设备上报事件
     */
    CMD_10(0X10),
    /**
     * 0x11--设备上报遥测数据
     */
    CMD_11(0X11),
    /**
     * 0x12--服务器下发查询功率/温度等信息
     */
    CMD_12(0X12),
    /**
     * 0x13--服务器下发清空电量统计，重新计量
     */
    CMD_13(0X13),
    /**
     * 0x14--服务器下发设置参数（全部参数下发）
     */
    CMD_14(0X14),
    /**
     * 0x21--智慧用电，服务器下发属性配置
     */
    CMD_21(0X21),
    /**
     * 0x22--智慧用电，服务器下发属性查询
     */
    CMD_22(0X22),
    /**
     * 0X30--服务器下行
     */
    CMD_30(0x30),
    /**
     * 0X31--服务器下行或设备上行
     */
    CMD_31(0x31),
    /**
     * 0X32--服务器下行或设备上行
     */
    CMD_32(0x32),
    /**
     * 0X33--服务器下行或设备上行
     */
    CMD_33(0x33),
    /**
     * 0X34--服务器下行或设备上行
     */
    CMD_34(0x34),
    /**
     * 0X36--服务器下行
     */
    CMD_36(0x36),
    /**
     * 0X50--多联机查询空调
     */
    CMD_50(0x50),
    /**
     * 0X51--多联机查询网关上所有空调
     */
    CMD_51(0x51),
    /**
     * 0X52--设备上行
     */
    CMD_52(0x52),
    /**
     * 0x73--智慧用电，服务器下行
     */
    CMD_73(0X73),
    /**
     * 0X82--多联机查询设备版本
     */
    CMD_82(0x82),
    /**
     * 0XA1--智慧用电设备上行,配置回复
     */
    CMD_A1(0xA1),
    /**
     * 0XA2--智慧用电设备上行,查询回复
     */
    CMD_A2(0xA2),
    /**
     * 0XA3--智慧用电设备上行,主动上报
     */
    CMD_A3(0xA3),
    /**
     * 0XA4--智慧用电设备上行,事件上报
     */
    CMD_A4(0xA4),
    /**
     * 0XB0--设备上行
     */
    CMD_B0(0xB0),
    /**
     * 0XB1--设备上行
     */
    CMD_B1(0xB1),
    /**
     * 0XB2--设备上行
     */
    CMD_B2(0xB2),
    /**
     * 0XB6--设备上行
     */
    CMD_B6(0xB6),
    /**
     * 0XB7--设备上行
     */
    CMD_B7(0xB7),
    /**
     * 0XF0--智慧用电，设备主动上行
     */
    CMD_F0(0xF0),
    /**
     * 0XF1--VRV，设备主动上行
     */
    CMD_F1(0xF1),
    /**
     * 0XF3--智慧用电，设备应答上行
     */
    CMD_F3(0xF3);

    private final int id;
    private static final Map<Integer, DeviceCmdType> ID_MAP = new HashMap<>();

    static {
        for (DeviceCmdType enumInstance : DeviceCmdType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    DeviceCmdType(int id) {
        this.id = id;
    }

    /**
     * 返回ID
     *
     * @return 方法ID
     */
    public int getId() {
        return id;
    }

    /**
     * 返回ID对应的枚举值
     *
     * @param id 方法ID
     * @return 实体
     */
    public static DeviceCmdType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
