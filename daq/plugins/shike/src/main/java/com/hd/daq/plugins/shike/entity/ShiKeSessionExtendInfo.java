package com.hd.daq.plugins.shike.entity;


/**
 * 时刻会话扩展信息
 *
 * @author ymm
 */
public class ShiKeSessionExtendInfo {
    /**
     * 序列号 2字节
     */
    private int sequenceNumber;
    /**
     * 通信标号 1字节
     */
    private int communicationLabel;
    /**
     * 主机（网关）型号
     */
    private String model;
    /**
     * 网关模式
     */
    private ShiKeCollectorModeType mode;
    /**
     * 对码模式过期时间，在过期之前对码模式是有效的
     */
    private long codeMatchingExpiredTime;

    public ShiKeSessionExtendInfo() {
        model = "";
        mode = ShiKeCollectorModeType.COMMON;
        codeMatchingExpiredTime = Long.MAX_VALUE;
    }

    /**
     * 获取主机型号
     *
     * @return 主机型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置主机型号
     *
     * @param model 主机型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取序列号
     *
     * @return 序列号
     */
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * 获取下一个序列号
     *
     * @return 新序列号
     */
    public synchronized int nextSequenceNumber() {
        ++sequenceNumber;
        if (sequenceNumber > 65535) {
            sequenceNumber = 0;
        }
        return sequenceNumber;
    }

    /**
     * 获取通信标号
     *
     * @return 通信标号
     */
    public int getCommunicationLabel() {
        return communicationLabel;
    }

    /**
     * 获取下一个通信标号
     *
     * @return 新通信标号
     */
    public synchronized int nextCommunicationLabel() {
        ++communicationLabel;
        if (communicationLabel > 255) {
            communicationLabel = 0;
        }
        return communicationLabel;
    }

    /**
     * 获取网关模式
     *
     * @return 网关模式
     */
    public ShiKeCollectorModeType getMode() {
        return mode;
    }

    /**
     * 设置网关模式
     *
     * @param mode 网关模式
     */
    public void setMode(ShiKeCollectorModeType mode) {
        this.mode = mode;
    }

    /**
     * 获取对码模式过期时间
     *
     * @return 对码模式过期时间
     */
    public long getCodeMatchingExpiredTime() {
        return codeMatchingExpiredTime;
    }

    /**
     * 设置对码模式过期时间
     *
     * @param codeMatchingExpiredTime 过期时间
     */
    public void setCodeMatchingExpiredTime(long codeMatchingExpiredTime) {
        this.codeMatchingExpiredTime = codeMatchingExpiredTime;
    }
}
