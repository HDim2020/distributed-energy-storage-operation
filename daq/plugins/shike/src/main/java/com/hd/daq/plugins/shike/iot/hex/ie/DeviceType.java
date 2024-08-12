package com.hd.daq.plugins.shike.iot.hex.ie;

import java.util.HashMap;
import java.util.Map;

/**
 * 探头设备类型
 *
 * @author ymm
 */
public enum DeviceType {
    /**
     * 智能开关/面板（3个开关，零火）
     */
    ZH101_01(0X01),
    /**
     * 智能开关/面板（1个开关，零火）
     */
    ZH101_09(0X09),
    /**
     * 智能开关/面板（2个开关，零火）
     */
    ZH101_0A(0X0A),
    /**
     * 智能开关/面板（4个开关，零火）
     */
    ZH101_0B(0X0B),
    /**
     * 智能开关/面板（1个开关，单火）
     */
    ZH101_0C(0X0C),
    /**
     * 智能开关/面板（2个开关，单火）
     */
    ZH101_0D(0X0D),
    /**
     * 智能开关/面板（3个开关，单火）
     */
    ZH101_0E(0X0E),
    /**
     * 智能开关/面板（4个开关，单火）
     */
    ZH101_0F(0X0F),
    /**
     * 空调伴侣
     */
    ZH107_16(0x1B),
    /**
     * 计量插座
     */
    ZH102(0x1C),
    /**
     * 导轨开关
     */
    ZH103(0x1D),
    /**
     * 大功率空调控制器
     */
    ZH107_65(0X1E),
    /**
     * 办公锁
     */
    ZHKB14(0x1F),
    /**
     * 充电桩
     */
    CHARGING_STATION(0X21),
    /**
     * 智能吊扇控制器
     */
    ZH109B(0X24),
    /**
     * 微波人体感应模块
     */
    ZH120(0X2A),
    /**
     * 智慧用电终端
     */
    SK_6100C(0x36),
    /**
     * 组合式电气火灾监控探测器（单相）
     */
    SK_6100(0x37),
    /**
     * 空调集中控制器(多联机)
     */
    ZH240(0X7F),
    /**
     * 无线烟感探测器
     */
    ZK_ZN13(0x81),
    /**
     * 未知
     */
    ZHDT1B_6(0x82),
    /**
     * 未知
     */
    ZHDV1B_1(0x83),
    /**
     * 无线温湿度门磁
     */
    ZHDT1B_H1(0x84),
    /**
     * 水浸
     */
    ZH153B(0x85),
    /**
     * 红外抄表模块
     */
    ZH6410(0x8F);

    private final int id;
    private static final Map<Integer, DeviceType> ID_MAP = new HashMap<>();

    static {
        for (DeviceType enumInstance : DeviceType.values()) {
            if (ID_MAP.put(enumInstance.getId(), enumInstance) != null) {
                throw new IllegalArgumentException("duplicate ID: " + enumInstance.getId());
            }
        }
    }

    DeviceType(int id) {
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
    public static DeviceType typeFor(int id) {
        return ID_MAP.get(id);
    }
}
