package com.hd.daq.plugins.rbscb.service;

import com.hd.daq.transportapi.ErrorCode;
import com.hd.daq.plugins.rbscb.data.*;
import com.hd.daq.plugins.rbscb.data.ie.IeExecuteResult;
import com.hd.daq.plugins.rbscb.data.ie.IeSinglePhaseBreaker;
import com.hd.daq.plugins.rbscb.data.ie.IeThreePhaseBreaker;
import com.hd.daq.plugins.rbscb.data.ie.RbIotInformationElement;
import com.hd.daq.transportapi.data.thing.PropertyMsg;
import com.hd.daq.transportapi.data.thing.PropertyEntry;
import com.hd.daq.transportapi.data.thing.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

/**
 * 瑞邦断路器消息转换器
 * @author ymm
 */
@Slf4j
public class RbIotConverter {
    /**
     * 把IOT消息转换成平台侧属性数据
     * @param msg 瑞邦遥测数据消息
     * @return 平台侧属性数据
     */
    public static PropertyMsg convertToPropertyData(RbIotMessage msg) {
        if (msg == null || msg.getControl() != RbIotControlType.LINK_TO_SERVER.getId() ||
                msg.getType() != RbIotMsgType.SERVER_REQUEST_TELEMETRY_DATA.getId()) {
            return null;
        }
        RbIotInformationElement[] informationElements = msg.getInformationObject().getInformationElements();
        if (informationElements == null || informationElements.length == 0) {
            return null;
        }
        PropertyMsg propertyData = new PropertyMsg();
        List<PropertyEntry> params = new ArrayList<>(getRbIotTagCount(informationElements));
        for (RbIotInformationElement ie : informationElements) {
            List<RbIotTag> rbIotTagList = null;
            if (ie instanceof IeSinglePhaseBreaker) {
                rbIotTagList = ((IeSinglePhaseBreaker) ie).getRbIotTagList();
            } else if (ie instanceof IeThreePhaseBreaker) {
                rbIotTagList = ((IeThreePhaseBreaker) ie).getRbIotTagList();
            }
            if (rbIotTagList != null) {
                rbIotTagList.forEach((tag)->{
                    PropertyEntry entry = PropertyEntry.builder()
                            .propId(tag.getTagId())
                            .propValue(tag.getTagVal())
                            .ts(tag.getTs())
                            .build();
                    params.add(entry);
                });
            }
        }
        propertyData.setParams(params);

        return propertyData;
    }

    /**
     * 获取遥测数据的数量
     * @param informationElements 信息体数组
     * @return 遥测数量
     */
    private static int getRbIotTagCount(RbIotInformationElement[] informationElements) {
        int count = 0;
        for (RbIotInformationElement ie : informationElements) {
            List<RbIotTag> rbIotTagList = null;
            if (ie instanceof IeSinglePhaseBreaker) {
                rbIotTagList = ((IeSinglePhaseBreaker) ie).getRbIotTagList();
            } else if (ie instanceof IeThreePhaseBreaker) {
                rbIotTagList = ((IeThreePhaseBreaker) ie).getRbIotTagList();
            }
            if (rbIotTagList != null) {
                count += rbIotTagList.size();
            }
        }

        return count;
    }

    /**
     * 把IOT消息转成平台侧服务响应消息
     * @param msg IOT消息
     * @return 平台侧服务响应消息
     */
    public static ResponseMsg convertToServiceResponse(RbIotMessage msg) {
        if (msg == null || msg.getControl() != RbIotControlType.LINK_TO_SERVER.getId() || msg.getInformationObject() == null) {
            return null;
        }
        RbIotInformationElement[] informationElements = msg.getInformationObject().getInformationElements();
        if (informationElements == null || informationElements.length == 0) {
            return null;
        }
        RbIotMsgType msgType = RbIotMsgType.typeFor(msg.getType());
        if (msgType == null) {
            return null;
        }
        ResponseMsg responseMsg = null;
        switch (msgType) {
            case SERVER_REMOTE_CONTROL_BROKER:
                IeExecuteResult ieExecuteResult = (IeExecuteResult)informationElements[0];
                if (ieExecuteResult != null) {
                    responseMsg = new ResponseMsg();
                    responseMsg.setCode(ieExecuteResult.getErrorCode() == 1 ? ErrorCode.SUCCESS.getCode() : ErrorCode.FAIL.getCode());
                    responseMsg.setMessage(ieExecuteResult.getErrorCode() == 1 ? ErrorCode.SUCCESS.getMessage() : ErrorCode.FAIL.getMessage());
                    responseMsg.setMethod(msgType.getMethod());
                    responseMsg.setData(new HashMap<String, String>(0));
                }
                break;
            default:
                break;
        }

        return responseMsg;
    }
}
