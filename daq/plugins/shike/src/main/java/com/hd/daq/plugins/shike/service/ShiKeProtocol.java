package com.hd.daq.plugins.shike.service;

import com.gitee.starblues.annotation.Extract;
import com.hd.daq.mqtt.service.ProtocolPlugin;
import com.hd.daq.mqtt.session.DeviceSessionCtx;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.adaptor.ShiKeMessageAdaptor;
import com.hd.daq.plugins.shike.entity.*;
import com.hd.daq.plugins.shike.iot.ShiKeMessage;
import com.hd.daq.plugins.shike.iot.hex.*;
import com.hd.daq.plugins.shike.iot.hex.ie.DeviceType;
import com.hd.daq.plugins.shike.iot.hex.ie.IeAddDeviceOne;
import com.hd.daq.plugins.shike.iot.hex.ie.IeAddDeviceTwo;
import com.hd.daq.plugins.shike.iot.hex.ie.fan.IeControlFanDevice;
import com.hd.daq.plugins.shike.iot.json.JsonCmdType;
import com.hd.daq.plugins.shike.iot.json.JsonMessage;
import com.hd.daq.plugins.shike.iot.json.TimeSyncResponse;
import com.hd.daq.plugins.shike.util.ByteArrayUtil;
import com.hd.daq.plugins.shike.util.UuidUtil;
import com.hd.daq.transportapi.DataStorageService;
import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.transportapi.TransportServiceCallback;
import com.hd.daq.transportapi.data.thing.*;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 时刻协议
 *
 * @author ymm
 */
@Slf4j
@Extract(bus = "protocol", scene = "mqtt")
public class ShiKeProtocol implements ProtocolPlugin {
    private final ShiKeMessageAdaptor adaptor;
    private final Map<String, DeviceContext> deviceMap;
    private final Map<String, ServiceRequestQueueContext> serviceRequestQueue;
    private final ExecutorService executorService;

    public ShiKeProtocol(ShiKeMessageAdaptor adaptor) {
        this.adaptor = adaptor;
        deviceMap = new ConcurrentHashMap<>();
        serviceRequestQueue = new ConcurrentHashMap<>();
        executorService = Executors.newSingleThreadExecutor();
        executorService.execute(this::processServiceRequest);
    }

    /**
     * 处理设备上行消息
     *
     * @param ctx                设备会话上下文
     * @param msg                发布的消息
     * @param dataStorageService 存储服务
     * @param callback           回调函数，用来通知处理结果
     */
    @Override
    public void processDevicePublishMessage(DeviceSessionCtx ctx, MqttPublishMessage msg, DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        //topic格式: device/{网关型号}/{网关唯一编号}
        //举例：device/ZH202/3C37577E111CCD
        String topic = msg.variableHeader().topicName();
        String[] items = topic.split("/");
        if (items.length != 3) {
            if (callback != null) {
                callback.onError(new Exception("Invalid topic."));
            }
            return;
        }
        //得到网关型号
        String collectModel = items[1];
        //得到采集器ID
        String collectorId = items[2];
        byte[] packet = ByteBufUtil.getBytes(msg.payload());
        try {
            ShiKeMessage shiKeMessage = ShiKeMessage.decode(packet);
            if (shiKeMessage == null) {
                if (callback != null) {
                    callback.onError(new Exception("Decode packet failed."));
                }
                return;
            }
            //设置扩展参数
            ShiKeSessionExtendInfo extendInfo = checkAndGetExtendInfo(ctx);
            if (!extendInfo.getModel().equals(collectModel)) {
                extendInfo.setModel(collectModel);
            }
            switch (shiKeMessage.getHeader().getContentType()) {
                case CT_HEARTBEAT:
                    ResponseMsg responseMsg = adaptor.convertHeartBeatToResponse(shiKeMessage);
                    dataStorageService.processDeviceMsg(ctx.getSessionInfo(), responseMsg, callback);
                    log.info("网关{}--心跳包处理完成。", responseMsg.getCollectorId());
                    break;
                case CT_JSON_DATA:
                    JsonMessage jsonMessage = (JsonMessage) shiKeMessage.getData();
                    // 处理时间同步请求
                    if (jsonMessage.getCmd() == JsonCmdType.CMD_TIME_SYNC_REQUEST.getId()) {
                        ShiKeMessage newMsg = ShiKeMessage.createJsonTypeShiKeMessage(extendInfo.nextSequenceNumber(),
                                collectorId, new TimeSyncResponse());
                        byte[] bytes = newMsg.encode();
                        MqttPublishMessage mqttPublishMsg = adaptor.createMqttPublishMsg(ctx, adaptor.getServerToDeviceTopic(collectModel, collectorId), bytes);
                        publishMessage(ctx, mqttPublishMsg, callback);
                        log.info("网关{}--发布时间同步响应。", collectorId);
                    }
                    break;
                case CT_HEX_DATA:
                    processHexData(shiKeMessage, ctx, dataStorageService, callback);
                    break;
                default:
                    log.debug("未知内容类型。");
                    break;
            }
        } catch (Throwable e) {
            log.debug("主题:{};原始报文:{}.", topic, ByteArrayUtil.toHexString(packet, 0, packet.length));
            log.info("处理设备消息异常:", e);
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    /**
     * 处理服务器下发消息
     *
     * @param ctx                设备会话上下文
     * @param msg                服务请求消息
     * @param dataStorageService 存储服务
     * @param callback           回调函数，用来通知处理结果
     */
    @Override
    public void processServiceRequest(DeviceSessionCtx ctx, ServiceRequestMsg msg, DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        try {
            log.info("开始处理消息{}", msg.toString());
            //先处理不用发给网关的消息
            if (processNoSendMessage(ctx, msg)) {
                return;
            }
            ServiceRequestQueueContext context = serviceRequestQueue.get(msg.getCollectorId());
            if (context == null) {
                context = new ServiceRequestQueueContext(dataStorageService);
                serviceRequestQueue.put(msg.getCollectorId(), context);
            }
            context.getQueue().put(ServiceRequestQueueMsg.builder().msg(msg).ctx(ctx).build());
        } catch (Throwable e) {
            log.info("处理服务请求异常:", e);
            sendErrorServiceResponse(ctx, msg, dataStorageService, ErrorCode.FAIL, e.getMessage());
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    /**
     * 生成新的回调实例（有额外操作的时候才需要调用）
     *
     * @param callback 源回调实例
     * @param <T>      类型
     * @return 新回调实例
     */
    private <T> TransportServiceCallback<Void> getStorageCallback(TransportServiceCallback<Void> callback) {
        return new TransportServiceCallback<Void>() {
            @Override
            public void onSuccess(Void dummy) {
                //TODO 做其他的业务，比如要求回复，则在这里进行发布回复消息
                if (callback != null) {
                    callback.onSuccess(dummy);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }
        };
    }

    /**
     * 发送错误服务响应消息到kafka
     *
     * @param ctx                设备会话上下文
     * @param requestMsg         请求消息
     * @param dataStorageService 存储服务
     * @param errCode            错误码
     * @param errMsg            错误消息
     */
    private void sendErrorServiceResponse(DeviceSessionCtx ctx, ServiceRequestMsg requestMsg,
                                          DataStorageService dataStorageService, ErrorCode errCode, String errMsg) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setId(requestMsg.getId() == null ? "" : requestMsg.getId());
        responseMsg.setMethod(requestMsg.getMethod() == null ? "" : requestMsg.getMethod());
        responseMsg.setCollectorId(requestMsg.getCollectorId() == null ? "" : requestMsg.getCollectorId());
        responseMsg.setCode(errCode.getCode());
        responseMsg.setMessage(StringUtils.hasLength(errMsg) ? errMsg : errCode.getMessage());
        responseMsg.setData(new HashMap<String, String>(0));
        dataStorageService.processResponseMsg(ctx.getSessionInfo(), responseMsg, null);
    }

    /**
     * 发送成功服务响应消息到kafka
     *
     * @param ctx                设备会话上下文
     * @param dataStorageService 存储服务
     * @param methodName         方法名称
     * @param collectorId        采集器ID
     * @param data               数据（可选）
     */
    private void sendSuccessResponse(DeviceSessionCtx ctx, DataStorageService dataStorageService, String methodName,
                                     String collectorId, Object data) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setId(UuidUtil.newId());
        responseMsg.setMethod(methodName);
        responseMsg.setCollectorId(collectorId);
        responseMsg.setCode(ErrorCode.SUCCESS.getCode());
        responseMsg.setMessage(ErrorCode.SUCCESS.getMessage());
        if (data != null) {
            responseMsg.setData(data);
        } else {
            responseMsg.setData(new HashMap<String, String>(0));
        }
        dataStorageService.processResponseMsg(ctx.getSessionInfo(), responseMsg, null);
    }

    /**
     * 发布消息
     *
     * @param ctx      会话上下文
     * @param msg      待发布消息
     * @param callback 回调
     */
    private void publishMessage(DeviceSessionCtx ctx, MqttPublishMessage msg, TransportServiceCallback<Void> callback) {
        try {
            ctx.getChannel().writeAndFlush(msg);
            if (callback != null) {
                callback.onSuccess(null);
            }
        } catch (Throwable e) {
            if (callback != null) {
                callback.onError(e);
            }
        }
    }

    /**
     * 处理包类型为CT_HEX_DATA的消息
     *
     * @param shiKeMessage       时刻消息实体对象
     * @param ctx                设备会话上下文
     * @param dataStorageService 存储服务
     * @param callback           回调
     */
    private void processHexData(ShiKeMessage shiKeMessage, DeviceSessionCtx ctx,
                                DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        HexDataContent content = (HexDataContent) shiKeMessage.getData();
        String uid = "";
        for (Tlv tlv : content.getTlvList()) {
            TlvType tlvType = TlvType.typeFor(tlv.getType());
            if (tlvType == TlvType.RF_DATA) {
                uid = processRfData(tlv, shiKeMessage, ctx, dataStorageService, callback);
            } else if (tlvType == TlvType.RF_SIGNAL) {
                if (!"".equals(uid)) {
                    processRfSignal(tlv, shiKeMessage, uid, ctx, dataStorageService, callback);
                }
            }
        }
    }

    /**
     * 处理数据类型RF_DATA的消息
     *
     * @param tlv                tlv实体
     * @param shiKeMessage       时刻消息实体对象
     * @param ctx                设备会话上下文
     * @param dataStorageService 存储服务
     * @param callback           回调
     * @return 设备ID
     */
    private String processRfData(Tlv tlv, ShiKeMessage shiKeMessage, DeviceSessionCtx ctx,
                                 DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        RfData rfData = (RfData) tlv.getValue();
        if (rfData == null) {
            log.info("网关{}--RfData为null被抛弃。", shiKeMessage.getHeader().getCollectorId());
            return "";
        }
        IInformationElement ie = rfData.getData();
        //判断是否有效对码模式
        boolean isValidCodeMatchingMode = (checkAndGetExtendInfo(ctx).getMode() == ShiKeCollectorModeType.CODE_MATCHING) &&
                (checkAndGetExtendInfo(ctx).getCodeMatchingExpiredTime() >= System.currentTimeMillis());
        if (ie instanceof IeAddDeviceOne) {
            if (!isValidCodeMatchingMode) {
                log.debug("网关{}--拦截非对码模式的网关上行的对码报文[UID:{},通信标号:{}].", shiKeMessage.getHeader().getCollectorId(),
                        rfData.getDeviceId(), rfData.getSequenceNumber());
                return "";
            }
        } else if (ie instanceof IeAddDeviceTwo) {
            IeAddDeviceTwo entity = (IeAddDeviceTwo)ie;
            if (!isValidCodeMatchingMode) {
                if (entity.getDeviceTypeCode() == DeviceType.ZH109B.getId()) {
                    //是吊扇设备时，转换成控制响应信息体
                    rfData.setData(IeControlFanDevice.from(entity));
                } else {
                    log.debug("网关{}--拦截非对码模式的网关上行的对码报文[UID:{},通信标号:{}].", shiKeMessage.getHeader().getCollectorId(),
                            rfData.getDeviceId(), rfData.getSequenceNumber());
                    return "";
                }
            }
        }
        DeviceContext deviceContext = checkAndGetDeviceContext(rfData.getDeviceId());
        if (rfData.getSequenceNumber() == deviceContext.getCommunicationLabel()) {
            log.debug("网关{}--检测到重复的报文[UID:{},通信标号:{}].", shiKeMessage.getHeader().getCollectorId(),
                    rfData.getDeviceId(), rfData.getSequenceNumber());
            return "";
        }
        deviceContext.setCommunicationLabel(rfData.getSequenceNumber());
        // 更新设备类型码
        if (deviceContext.getTypeCode() == null) {
            if (rfData.getData().getDeviceTypeCode() != null) {
                deviceContext.setTypeCode(rfData.getData().getDeviceTypeCode());
            } else {
                Integer code = dataStorageService.getDeviceTypeCode(rfData.getDeviceId());
                if (code != null) {
                    deviceContext.setTypeCode(code);
                }
            }
        }
        if (adaptor.isPropertyMessage(rfData)) {
            // 处理设备上报的遥测数据
            PropertyMsg propertyMsg = adaptor.convertToProperty(rfData, shiKeMessage.getHeader().getCollectorId());
            dataStorageService.processPropertyMsg(ctx.getSessionInfo(), propertyMsg, callback);
            log.debug("网关{}--处理{}的遥测数据完成。", shiKeMessage.getHeader().getCollectorId(), rfData.getDeviceId());
        }
        if (adaptor.isDeviceMessage(rfData)) {
            // 处理设备主动上报的消息
            ResponseMsg responseMsg = adaptor.convertRfDataToResponse(shiKeMessage.getHeader().getCollectorId(), rfData);
            if (responseMsg != null) {
                dataStorageService.processDeviceMsg(ctx.getSessionInfo(), responseMsg, callback);
                log.debug("网关{}--处理{}的设备消息完成。", shiKeMessage.getHeader().getCollectorId(), rfData.getDeviceId());
            }
        }
        if (adaptor.isServiceMessage(rfData)) {
            // 处理设备上报的服务端请求的响应消息
            ResponseMsg responseMsg = adaptor.convertRfDataToResponse(shiKeMessage.getHeader().getCollectorId(), rfData);
            dataStorageService.processResponseMsg(ctx.getSessionInfo(), responseMsg, callback);
            log.debug("网关{}--处理{}的响应消息完成。", shiKeMessage.getHeader().getCollectorId(), rfData.getDeviceId());
        }

        return rfData.getDeviceId();
    }

    /**
     * @param tlv                tlv实体
     * @param shiKeMessage       时刻消息实体对象
     * @param uid                设备ID
     * @param ctx                设备会话上下文
     * @param dataStorageService 存储服务
     * @param callback           回调
     */
    private void processRfSignal(Tlv tlv, ShiKeMessage shiKeMessage, String uid, DeviceSessionCtx ctx,
                                 DataStorageService dataStorageService, TransportServiceCallback<Void> callback) {
        RfSignal rfSignal = (RfSignal) tlv.getValue();
        PropertyMsg propertyMsg = adaptor.convertRfSignalToProperty(shiKeMessage.getHeader().getCollectorId(), rfSignal, uid);
        if (propertyMsg != null) {
            dataStorageService.processPropertyMsg(ctx.getSessionInfo(), propertyMsg, callback);
            log.debug("网关{}--处理{}的RF信号完成。", shiKeMessage.getHeader().getCollectorId(), uid);
        }
    }

    /**
     * 验证扩展信息并返回扩展信息对象
     *
     * @param ctx 设备上下文
     * @return 扩展信息对象
     */
    private ShiKeSessionExtendInfo checkAndGetExtendInfo(DeviceSessionCtx ctx) {
        ShiKeSessionExtendInfo extendInfo = (ShiKeSessionExtendInfo) ctx.getDeviceInfo().getExtendInfo();
        if (extendInfo == null) {
            extendInfo = new ShiKeSessionExtendInfo();
            ctx.getDeviceInfo().setExtendInfo(extendInfo);
        }
        return extendInfo;
    }

    /**
     * 验证设备上下文并返回设备上下文对象
     *
     * @param uid 设备ID
     * @return 设备上下文对象
     */
    private DeviceContext checkAndGetDeviceContext(String uid) {
        DeviceContext ctx = deviceMap.get(uid);
        if (ctx == null) {
            ctx = new DeviceContext();
            ctx.setUid(uid);
            deviceMap.put(uid, ctx);
        }

        return ctx;
    }

    /**
     * 处理不需要发给网关的消息
     *
     * @param msg 服务端请求消息
     * @param ctx 会话上下文
     * @return 网关消息返回true，否则返回false
     */
    private boolean processNoSendMessage(DeviceSessionCtx ctx, ServiceRequestMsg msg) {
        MethodType methodType = MethodType.nameFor(msg.getMethod());
        ShiKeSessionExtendInfo extendInfo = checkAndGetExtendInfo(ctx);
        if (methodType == MethodType.SET_BIND_COLLECTOR) {
            extendInfo.setMode(ShiKeCollectorModeType.CODE_MATCHING);
            //重设对码模式过期时间
            extendInfo.setCodeMatchingExpiredTime(System.currentTimeMillis() + 60_000);
            return true;
        } else if (methodType == MethodType.SET_UNBIND_COLLECTOR) {
            extendInfo.setMode(ShiKeCollectorModeType.COMMON);
            extendInfo.setCodeMatchingExpiredTime(0);
            return true;
        }

        return false;
    }

    /**
     * 处理服务请求线程函数
     */
    private void processServiceRequest() {
        while (true) {
            try {
                boolean isEmpty = true;
                Iterator<Map.Entry<String, ServiceRequestQueueContext>> iterator = serviceRequestQueue.entrySet().iterator();
                while (iterator.hasNext()) {
                    ServiceRequestQueueContext context = iterator.next().getValue();
                    if (context.getQueue().isEmpty()) {
                        continue;
                    }
                    isEmpty = false;
                    if (context.getNextSendTime() <= System.currentTimeMillis()) {
                        ServiceRequestQueueMsg msg = context.getQueue().take();
                        context.setNextSendTime(System.currentTimeMillis() + 20);
                        try {
                            //处理需要发给网关的消息
                            MqttPublishMessage mqttPublishMessage = adaptor.toMqttPublishMessage(msg.getCtx(), msg.getMsg());
                            if (mqttPublishMessage != null) {
                                ChannelHandlerContext channel = msg.getCtx().getChannel();
                                channel.writeAndFlush(mqttPublishMessage);
                                log.info("网关{}--发布消息成功。", msg.getMsg().getCollectorId());
                                if (msg.getMsg().getMethod().equals(MethodType.SET_CLEAR_WHITE_LIST.getName())) {
                                    // 清空白名单指令，自动回应服务器，协议上是没有回应的
                                    sendSuccessResponse(msg.getCtx(), context.getStorage(), MethodType.GET_CLEAR_WHITE_LIST.getName(),
                                            msg.getMsg().getCollectorId(), msg.getMsg().getParams());
                                }
                            }
                        } catch (Throwable e) {
                            log.info("处理{}的{}方法出现异常:", msg.getMsg().getCollectorId(), msg.getMsg().getMethod(), e);
                            sendErrorServiceResponse(msg.getCtx(), msg.getMsg(), context.getStorage(), ErrorCode.FAIL, e.getMessage());
                        }
                    }
                }
                iterator = null;
                Thread.sleep(isEmpty ? 100 : 0);
            } catch (Throwable e) {
                log.info("处理服务请求队列消息异常:", e);
            }
        }
    }
}