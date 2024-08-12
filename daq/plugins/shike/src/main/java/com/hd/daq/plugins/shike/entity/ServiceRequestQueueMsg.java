package com.hd.daq.plugins.shike.entity;

import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.transportapi.data.thing.ServiceRequestMsg;
import lombok.Builder;
import lombok.Getter;

/**
 * 服务请求消息写入请求队列的实体类
 *
 * @author ymm
 */
@Builder
@Getter
public class ServiceRequestQueueMsg implements Comparable<ServiceRequestQueueMsg> {
    /**
     * 服务请求消息
     */
    ServiceRequestMsg msg;
    /**
     * 设备会话上下文
     */
    DeviceSessionCtx ctx;

    /**
     * 比较两个对象的优先级，按照优先级从小到到排序
     *
     * @param o 需要比较的实体
     * @return 优先级对比
     */
    @Override
    public int compareTo(ServiceRequestQueueMsg o) {
        return Integer.compare(this.msg.getPriority(), o.getMsg().getPriority());
    }
}
