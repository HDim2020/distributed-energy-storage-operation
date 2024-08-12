package com.hd.daq.plugins.shike.iot;

import com.google.gson.Gson;
import com.hd.daq.plugins.shike.exception.DecodeException;
import com.hd.daq.plugins.shike.exception.EncodeException;
import com.hd.daq.plugins.shike.iot.hex.*;
import com.hd.daq.plugins.shike.iot.hex.ie.IeServerAddWhiteList;
import com.hd.daq.plugins.shike.iot.hex.ie.IeServerRemoveWhiteList;
import com.hd.daq.plugins.shike.iot.json.JsonCmdType;
import com.hd.daq.plugins.shike.iot.json.JsonMessage;
import com.hd.daq.plugins.shike.iot.json.TimeSyncRequest;
import com.hd.daq.plugins.shike.util.ByteArrayUtil;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 时刻消息格式
 *
 * @author ymm
 */
@Slf4j
@Builder
@Data
public class ShiKeMessage implements IEncodable {
    /**
     * 固定头部
     */
    protected FixedHeader header;
    /**
     * 可变数据部分
     */
    protected IDataContent data;

    public static ShiKeMessage decode(byte[] buf) throws DecodeException {
        int offset = 0;
        while (offset < buf.length) {
            offset = ByteArrayUtil.indexOf(buf, offset, (byte) 0xFF);
            if (offset < 0) {
                throw new DecodeException("未找到固定包头");
            }
            // 解码包头
            FixedHeader header = FixedHeader.decode(buf, offset);
            if (header == null) {
                throw new DecodeException("解析包头失败");
            }
            // 验证包长度
            if (header.getDataLength() + 16 + offset != buf.length) {
                offset += 1;
                continue;
            }
            // 验证校验和
            // 先把校验和置为0，再计算校验和
            buf[3 + offset] = 0;
            // 对整个包的所有字节（除自身字节外）进行算术和的结果
            int checkSum = ValidateCode.checkSumOneByte(buf, offset, buf.length - offset);
            buf[3 + offset] = (byte) header.getCheckSum();
            if (checkSum != header.getCheckSum()) {
                offset += 1;
                continue;
            }
            // 下面开始对数据部分进行解码
            byte[] data = Arrays.copyOfRange(buf, 16 + offset, buf.length);
            IDataContent content = null;
            switch (header.getContentType()) {
                case CT_HEARTBEAT:
                    content = HeartBeatMessage.decode(data);
                    break;
                case CT_JSON_DATA:
                    content = decodeJson(data);
                    break;
                case CT_HEX_DATA:
                    content = HexDataContent.decode(data);
                    break;
                default:
                    break;
            }
            if (content == null) {
                throw new DecodeException("不能解码内容");
            }
            return ShiKeMessage.builder()
                    .header(header)
                    .data(content)
                    .build();
        }
        throw new DecodeException("解码报文失败");
    }

    /**
     * 解码包类型是CT_JSON_DATA的数据部分
     *
     * @param data 缓冲区
     * @return 实体对象
     */
    private static IDataContent decodeJson(byte[] data) {
        String s = new String(data, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        JsonMessage base = gson.fromJson(s, JsonMessage.class);
        JsonCmdType cmdType = JsonCmdType.typeFor(base.getCmd());
        if (cmdType == null) {
            return null;
        }
        IDataContent content = null;
        switch (cmdType) {
            case CMD_TIME_SYNC_REQUEST:
                content = gson.fromJson(s, TimeSyncRequest.class);
                break;
            default:
                break;
        }

        return content;
    }

    /**
     * 编码实体对象为字节数组
     *
     * @return 字节数组
     */
    @Override
    public byte[] encode() throws EncodeException {
        // 解码数据部分成字符数组
        byte[] dataBytes = data.encode();
        // 修改头部中的部分参数
        header.setContentType(data.getContentType());
        header.setDataLength(dataBytes.length);
        header.setCheckSum(0);
        // 解码头部部分成字符数组
        byte[] headerBytes = header.encode();
        // 分配新空间
        byte[] destBytes = Arrays.copyOf(headerBytes, headerBytes.length + dataBytes.length);
        System.arraycopy(dataBytes, 0, destBytes, headerBytes.length, dataBytes.length);
        // 更新校验和
        destBytes[3] = (byte) ValidateCode.checkSumOneByte(destBytes, 0, destBytes.length);
        return destBytes;
    }

    /**
     * 创建json类型时刻消息实体对象
     *
     * @param sequenceNumber 序列号
     * @param collectorId    网关ID
     * @param jsonMessage    json消息
     * @return 时刻消息实体
     */
    public static ShiKeMessage createJsonTypeShiKeMessage(int sequenceNumber, String collectorId, JsonMessage jsonMessage) {
        FixedHeader header = FixedHeader.create(sequenceNumber, collectorId);
        return ShiKeMessage.builder().header(header).data(jsonMessage).build();
    }

    /**
     * 创建Hex类型时刻消息实体对象
     *
     * @param sequenceNumber 序列号
     * @param collectorId    网关ID
     * @param ie             信息体元素实例
     * @return 时刻消息实体
     */
    public static ShiKeMessage createHexTypeShiKeMessage(int sequenceNumber, int commFlag,
                                                               String collectorId, String deviceId, IInformationElement ie) {
        FixedHeader header = FixedHeader.create(sequenceNumber, collectorId);
        Tlv tlv;
        ITlvValue tlvValue = null;
        switch (ie.getTlvType()) {
            case RF_DATA:
                tlvValue = RfData.builder()
                        .sequenceNumber(commFlag)
                        .deviceId(deviceId)
                        .cmd(ie.getRfDataCmdCode())
                        .data(ie)
                        .build();
                break;
            case CLEAR_WHITELIST:
                tlvValue = ClearWhiteList.builder().build();
                break;
            case ADD_WHITELIST:
                IeServerAddWhiteList ieServerAddWhiteList = (IeServerAddWhiteList) ie;
                tlvValue = AddWhiteList.builder()
                        .whiteList(ieServerAddWhiteList.getWhiteList())
                        .build();
                break;
            case REMOVE_WHITELIST:
                IeServerRemoveWhiteList ieServerRemoveWhiteList = (IeServerRemoveWhiteList) ie;
                tlvValue = RemoveWhiteList.builder()
                        .whiteList(ieServerRemoveWhiteList.getWhiteList())
                        .build();
                break;
            default:
                break;
        }
        if (tlvValue == null) {
            return null;
        }
        tlv = Tlv.builder()
                .type(ie.getTlvType().getId())
                .length(0)
                .value(tlvValue)
                .build();
        List<Tlv> tlvList = new ArrayList<>(1);
        tlvList.add(tlv);
        HexDataContent content = HexDataContent.builder()
                .tlvList(tlvList)
                .build();
        return ShiKeMessage.builder()
                .header(header)
                .data(content).build();
    }
}
