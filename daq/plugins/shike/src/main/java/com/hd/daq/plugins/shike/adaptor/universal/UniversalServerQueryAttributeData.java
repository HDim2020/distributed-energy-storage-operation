package com.hd.daq.plugins.shike.adaptor.universal;

import com.hd.daq.plugins.shike.adaptor.AttributeData;
import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.UniversalAttributeType;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.Attribute;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.AttributeUtils;
import com.hd.daq.plugins.shike.iot.hex.ie.universal.IeUniversalServerQueryAttribute;
import lombok.Builder;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列请求消息params部分--服务器下发通用查询属性
 *
 * @author ymm
 */
@Builder
@Getter
public class UniversalServerQueryAttributeData implements IMethodService, IServerToDeviceMessage {
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
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @SneakyThrows
    @Override
    public IeUniversalServerQueryAttribute to() {
        List<Attribute> attributeList = null;
        if (dataList != null && dataList.size() > 0) {
            attributeList = new ArrayList<>(dataList.size());
            int code = Integer.parseInt(deviceType);
            Class<? extends Attribute> cls = AttributeUtils.getAttributeSubClass(code);
            if (cls == null) {
                return null;
            }
            Attribute attribute;
            for (AttributeData data : dataList) {
                attribute = cls.newInstance();
                attribute.setDefenseZoneNumber(Integer.parseInt(data.getDefenseZoneNumber()));
                attribute.setAttributeType(UniversalAttributeType.typeFor(Integer.parseInt(data.getAttributeId())));
                attribute.setValue(data.getValue());
                attributeList.add(attribute);
            }
        }
        return IeUniversalServerQueryAttribute.builder()
                .deviceTypeCode(Integer.parseInt(deviceType))
                .attributeList(attributeList)
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_QUERY_UNIVERSAL_ATTRIBUTE.getName();
    }
}
