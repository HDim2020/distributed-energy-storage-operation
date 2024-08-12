package com.hd.daq.plugins.rbscb.data.ie;

import com.hd.daq.plugins.rbscb.data.BreakerType;
import com.hd.daq.plugins.rbscb.data.RbIotTag;
import io.netty.buffer.ByteBuf;
import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * 三相断路器
 * @author ymm
 */
@Builder
public class IeThreePhaseBreaker extends RbIotInformationElement {
    private static final int DATA_LEN = 140;
    private static final int DEV_TYPE = BreakerType.THREE_PHASE.getId();
    @Getter
    private List<RbIotTag> rbIotTagList;
    @Getter
    private int address;

    public static IeThreePhaseBreaker decode(InputStream in) {
        byte[] data = new byte[DATA_LEN];
        try {
            int n = in.read(data);
            if (n < DATA_LEN) {
                return null;
            }
        } catch (Exception ignored) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN);
        int address = byteBuffer.get(0);
        long ts = byteBuffer.getInt(128) * 1000L;
        double tagVal = byteBuffer.getShort(2) * 0.1;
        List<RbIotTag> tagList = new ArrayList<>(39);
        addRbIotTag(tagList, String.format("D%03dA0001", address), "芯片温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(4) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0002", address), "N相端子温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(6) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0003", address), "C相端子温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(8) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0004", address), "B相端子温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(10) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0005", address), "A相端子温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(12) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0006", address), "电压Ua", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(14) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0007", address), "电压Ub", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(16) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0008", address), "电压Uc", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(18) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0009", address), "电流Ia", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(20) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0010", address), "电流Ib", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(22) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0011", address), "电流Ic", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(24);
        addRbIotTag(tagList, String.format("D%03dA0012", address), "电流In", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getInt(26) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0013", address), "有功功率Pa", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(30) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0014", address), "有功功率Pb", String.format("%.1f", tagVal), ts);
        // tagVal = byteBuffer.getShort(34);
        // addRbIotTag(String.format("D%03dA0015", address), "1区复制低字节", String.format("%d", (int)tagVal), ts);
        // tagVal = byteBuffer.getShort(36);
        // addRbIotTag(String.format("D%03dA0016", address), "1区复制高字节", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getInt(38) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0017", address), "有功功率Pc", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(42) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0018", address), "有功电度Epa", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(46) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0019", address), "有功电度Epb", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(50);
        addRbIotTag(tagList, String.format("D%03dA0020", address), "有功电度Epc", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(54);
        addRbIotTag(tagList, String.format("D%03dA0021", address), "有功电度Ept", String.format("%.2f", tagVal), ts);
        // tagVal = byteBuffer.getShort(58);
        // addRbIotTag(String.format("D%03dA0022", address), "拨动按钮状态", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(60);
        addRbIotTag(tagList, String.format("D%03dA0023", address), "开关状态", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getInt(62) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0024", address), "有功功率Pt", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(66) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0025", address), "测量频率", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(68) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0026", address), "功率因数Pfa", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(70) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0027", address), "功率因数Pfb", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(72) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0028", address), "功率因数Pfc", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(74) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0029", address), "功率因数Pft", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(76) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0030", address), "无功功率Qa", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(80) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0031", address), "无功功率Qb", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(84) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0032", address), "无功功率Qc", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(88) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0033", address), "无功功率Qt", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(92) * 0.1;
        // addRbIotTag(tagList, String.format("D%03dA0034", address), "视在功率Sa", String.format("%.1f", tagVal), ts);
        // tagVal = byteBuffer.getInt(96) * 0.1;
        // addRbIotTag(tagList, String.format("D%03dA0035", address), "视在功率Sb", String.format("%.1f", tagVal), ts);
        // tagVal = byteBuffer.getInt(100) * 0.1;
        // addRbIotTag(tagList, String.format("D%03dA0036", address), "视在功率Sc", String.format("%.1f", tagVal), ts);
        // tagVal = byteBuffer.getInt(104) * 0.1;
        // addRbIotTag(tagList, String.format("D%03dA0037", address), "视在功率St", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(108) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0038", address), "无功电度Eqa", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(112) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0039", address), "无功电度Eqb", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(116) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0040", address), "无功电度Eqc", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(120) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0041", address), "无功电度Eqt", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(124);
        addRbIotTag(tagList, String.format("D%03dA0042", address), "过流发生时过流值", String.format("%d", (int)tagVal), ts);
        // tagVal = byteBuffer.getShort(126);
        // addRbIotTag(tagList, String.format("D%03dA0043", address), "分合闸日志", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(132);
        addRbIotTag(tagList, String.format("D%03dA0046", address), "Ia谐波", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(134);
        addRbIotTag(tagList, String.format("D%03dA0047", address), "Ib谐波", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(136);
        addRbIotTag(tagList, String.format("D%03dA0048", address), "Ic谐波", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(138);
        addRbIotTag(tagList, String.format("D%03dA0049", address), "漏电发生时漏电值", String.format("%d", (int)tagVal), ts);

        return IeThreePhaseBreaker.builder().address(address).rbIotTagList(tagList).build();
    }

    private static void addRbIotTag(List<RbIotTag> tagList, String tagId, String description, String tagVal, long ts) {
        RbIotTag tag = new RbIotTag();
        tag.setTagId(tagId);
        tag.setDescription(description);
        tag.setTagVal(tagVal);
        tag.setTs(ts);
        tagList.add(tag);
    }

    @Override
    public int encode(ByteBuf buffer) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (RbIotTag tag : rbIotTagList) {
            sb.append(tag.getDescription());
            sb.append("-");
            sb.append(tag.getTagId());
            sb.append(":");
            sb.append(tag.getTagVal());
            sb.append(";");
        }
        sb.append("}");
        return sb.toString();
    }
}
