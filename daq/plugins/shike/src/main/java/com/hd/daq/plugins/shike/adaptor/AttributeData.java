package com.hd.daq.plugins.shike.adaptor;

import lombok.Builder;
import lombok.Getter;

/**
 * 属性实体类
 *
 * @author ymm
 */
@Builder
@Getter
public class AttributeData {
    /**
     * 防区号
     */
    private String defenseZoneNumber;
    /**
     * 属性ID
     */
    private String attributeId;
    /**
     * 属性值
     */
    private String value;
}
