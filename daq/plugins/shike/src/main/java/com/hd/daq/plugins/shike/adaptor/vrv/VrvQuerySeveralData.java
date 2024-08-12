package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvQuerySeveral;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.VrvStatusParam;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


/**
 * 队列消息data部分--多联机查询空调响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvQuerySeveralData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 所有空调参数校验和
     */
    private String check;
    /**
     * 状态参数集合
     */
    private List<VrvAcData> dataList;

    /**
     * 创建实体对象
     *
     * @param rfData RfData实体对象
     * @return 实体对象
     */
    public static VrvQuerySeveralData from(RfData rfData) {
        IeVrvQuerySeveral ie = (IeVrvQuerySeveral) rfData.getData();
        List<VrvAcData> dataList = new ArrayList<>(ie.getStatusParamList().size());
        for (VrvStatusParam param : ie.getStatusParamList()) {
            dataList.add(VrvAcData.from(param));
        }
        return VrvQuerySeveralData.builder()
                .uid(rfData.getDeviceId())
                .check(Integer.toString(ie.getCheckSum()))
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
        return MethodType.GET_VRV_QUERY_AC.getName();
    }
}
