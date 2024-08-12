package com.hd.daq.plugins.shike.adaptor.ac;

import com.hd.daq.plugins.shike.adaptor.IMethodService;
import com.hd.daq.plugins.shike.adaptor.IServerToDeviceMessage;
import com.hd.daq.plugins.shike.adaptor.MethodType;
import com.hd.daq.plugins.shike.iot.hex.DeviceCmdType;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeAirConditionCombinationCmd;
import com.hd.daq.plugins.shike.iot.hex.ie.ac.IeServerSetAirConditionCombination;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列请求消息params部分--服务器下发设置空调多组合命令
 *
 * @author ymm
 */
@Builder
@Getter
public class ServerSetAirConditionCombinationData implements IMethodService, IServerToDeviceMessage {
    /**
     * 设备ID
     */
    private String uid;
    /**
     * 控制码
     */
    private String controlCode;
    /**
     * 组合指令集合
     */
    private List<AirConditionCombinationCmd> dataList;

    /**
     * 创建信息体实体对象
     *
     * @return 信息体实体对象
     */
    @Override
    public IeServerSetAirConditionCombination to() {
        return IeServerSetAirConditionCombination.builder()
                .code(Integer.parseInt(controlCode))
                .cmdList(convert())
                .build();
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    @Override
    public String getMethodName() {
        return MethodType.SET_AC_COMBINATION.getName();
    }

    /**
     * 转换成IeAirConditionCombinationCmd集合
     * @return IeAirConditionCombinationCmd集合
     */
    List<IeAirConditionCombinationCmd> convert() {
        List<IeAirConditionCombinationCmd> cmdList = new ArrayList<>();
        cmdList.add(IeAirConditionCombinationCmd.builder().cmdCode(DeviceCmdType.CMD_04.getId()).instruct(0XFF).build());
        for (AirConditionCombinationCmd cmd : dataList) {
            int cmdCode = -1;
            if (cmd.getCombinationMethod().equalsIgnoreCase(MethodType.SET_AC_OPERATING_MODE.getName())) {
                cmdCode = DeviceCmdType.CMD_05.getId();
            } else if (cmd.getCombinationMethod().equalsIgnoreCase(MethodType.SET_AC_TEMP.getName())) {
                cmdCode = DeviceCmdType.CMD_06.getId();
            } else if (cmd.getCombinationMethod().equalsIgnoreCase(MethodType.SET_AC_WIND_SPEED.getName())) {
                cmdCode = DeviceCmdType.CMD_07.getId();
            } else if (cmd.getCombinationMethod().equalsIgnoreCase(MethodType.SET_AC_WIND_DIRECTION.getName())) {
                cmdCode = DeviceCmdType.CMD_08.getId();
            }
            if (cmdCode > 0) {
                cmdList.add(IeAirConditionCombinationCmd.builder().cmdCode(cmdCode).instruct(cmd.getInstruct()).build());
            }
        }

        return cmdList;
    }
}
