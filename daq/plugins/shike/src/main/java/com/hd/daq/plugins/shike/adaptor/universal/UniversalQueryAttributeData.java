package com.hd.daq.plugins.shike.adaptor.universal;

import com.hd.daq.plugins.shike.adaptor.AttributeData;
import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.IeUniversalMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * 队列消息data部分--通用查询属性回复上行消息（设备上行）
 *
 * @author ymm
 */
@Slf4j
@Builder
@Getter
public class UniversalQueryAttributeData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 设备类型码
     */
    private String deviceType;
    /**
     * 属性集合
     */
    private List<AttributeData> dataList;


    /**
     * 创建实体对象
     *
     * @param rfData RfData实体对象
     * @return 实体对象
     */
    public static UniversalQueryAttributeData from(RfData rfData) {
        IeUniversalMessage ie = (IeUniversalMessage) rfData.getData();
        List<AttributeData> dataList = new ArrayList<>();
        for (Attribute attribute : ie.getAttributeList()) {
            dataList.add(
                    AttributeData
                            .builder()
                            .defenseZoneNumber(Integer.toString(attribute.getDefenseZoneNumber()))
                            .attributeId(Integer.toString(attribute.getAttributeType().getId()))
                            .value(attribute.getValue())
                            .build()
            );
        }
        return UniversalQueryAttributeData.builder()
                .uid(rfData.getDeviceId())
                .deviceType(ie.getDeviceTypeCode().toString())
                .dataList(dataList)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.GET_QUERY_UNIVERSAL_ATTRIBUTE.getName();
    }
}
