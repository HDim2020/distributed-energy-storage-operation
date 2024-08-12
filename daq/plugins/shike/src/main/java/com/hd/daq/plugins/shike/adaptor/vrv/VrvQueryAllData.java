package com.hd.daq.plugins.shike.adaptor.vrv;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.RfData;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.IeVrvQueryAll;
import com.hd.daq.plugins.shike.iot.hex.ie.vrv.VrvStatusParam;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


/**
 * 队列消息data部分--多联机查询网关下所有空调响应（设备上行）
 *
 * @author ymm
 */
@Builder
@Getter
public class VrvQueryAllData implements IMethodService {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 所有空调参数校验和
     */
    private String check;
    /**
     * 总包数
     */
    private String total;
    /**
     * 分包
     */
    private String subpackage;
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
    public static VrvQueryAllData from(RfData rfData) {
        IeVrvQueryAll ie = (IeVrvQueryAll) rfData.getData();
        List<VrvAcData> dataList = new ArrayList<>(ie.getStatusParamList().size());
        for (VrvStatusParam param : ie.getStatusParamList()) {
            dataList.add(VrvAcData.from(param));
        }
        return VrvQueryAllData.builder()
                .uid(rfData.getDeviceId())
                .check(Integer.toString(ie.getCheckSum()))
                .total(Integer.toString(ie.getTotalPacketCount()))
                .subpackage(Integer.toString(ie.getSubPacketNumber()))
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
        return MethodType.GET_VRV_QUERY_ALL_AC.getName();
    }
}
