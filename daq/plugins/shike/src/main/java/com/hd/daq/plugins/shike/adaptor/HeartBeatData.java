package com.hd.daq.plugins.shike.adaptor;

import com.hd.daq.plugins.shike.iot.HeartBeatMessage;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列消息data部分--心跳数据
 *
 * @author ymm
 */
@Builder
@Getter
public class HeartBeatData implements IMethodService {
    /**
     * 市电状态 0--市电掉电 1--市电供电
     */
    private int cityElectricityStatus;
    /**
     * 电池电压 单位100mV
     */
    private int batteryVoltage;
    /**
     * 4G联网状态 0--掉线 1--在线
     */
    private int fourG;
    /**
     * WIFI 联网状态，0--掉线 1--在线
     */
    private int wifi;
    /**
     * IP 联网状态，0--掉线 1--在线
     */
    private int ip;
    /**
     * 4G信号强度 0--5
     */
    private int fourGSignal;
    /**
     * wifi信号强度 0--5
     */
    private int wifiSignal;
    /**
     * 主机软件版本号
     */
    private String version;
    /**
     * 白名单个数
     */
    private int whitelistNumber;
    /**
     * 白名单UID+类型算术和
     */
    private int whitelistCount;

    /**
     * 创建HeartBeatData实体对象
     *
     * @param msg HeartBeatMessage实体对象
     * @return HeartBeatData实体对象
     */
    public static HeartBeatData from(HeartBeatMessage msg) {
        return HeartBeatData.builder()
                .cityElectricityStatus(msg.getStatus().get(0))
                .batteryVoltage(msg.getStatus().get(1))
                .fourG(msg.getLink().get(0))
                .wifi(msg.getLink().get(1))
                .ip(msg.getLink().get(2))
                .fourGSignal(msg.getSignalIntensity().get(0))
                .wifiSignal(msg.getSignalIntensity().get(1))
                .version(msg.getVersion())
                .whitelistNumber(msg.getWhiteList().get(0))
                .whitelistCount(msg.getWhiteList().get(1))
                .build();
    }

    /**
     * 创建HeartBeatMessage实体对象
     *
     * @return HeartBeatMessage实体对象
     */
    public HeartBeatMessage to() {
        List<Integer> status = new ArrayList<>(4);
        status.add(cityElectricityStatus);
        status.add(batteryVoltage);
        status.add(0);
        status.add(0);
        List<Integer> link = new ArrayList<>(3);
        link.add(fourG);
        link.add(wifi);
        link.add(ip);
        List<Integer> signalIntensity = new ArrayList<>(2);
        signalIntensity.add(fourGSignal);
        signalIntensity.add(wifiSignal);
        List<Integer> whiteList = new ArrayList<>(2);
        whiteList.add(whitelistNumber);
        whiteList.add(whitelistCount);

        return HeartBeatMessage.builder()
                .cmd(1)
                .status(status)
                .link(link)
                .signalIntensity(signalIntensity)
                .version(version)
                .whiteList(whiteList)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_HEARTBEAT.getName();
    }
}
