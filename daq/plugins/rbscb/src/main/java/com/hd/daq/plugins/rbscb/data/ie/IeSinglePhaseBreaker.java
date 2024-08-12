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
 * 单相断路器
 * @author ymm
 */
@Builder
public class IeSinglePhaseBreaker extends RbIotInformationElement {
    private static final int DATA_LEN = 72;
    private static final int DEV_TYPE = BreakerType.SINGLE_PHASE.getId();
    @Getter
    private List<RbIotTag> rbIotTagList;
    @Getter
    private int address;

    public static IeSinglePhaseBreaker decode(InputStream in) {
        byte[] data = new byte[DATA_LEN];
        try {
            int n = in.read(data);
            if (n < DATA_LEN) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN);
        int address = byteBuffer.get(0);
        long ts = byteBuffer.getInt(68) * 1000L;
        double tagVal = byteBuffer.getShort(2) * 0.1;
        List<RbIotTag> tagList = new ArrayList<>(18);
        addRbIotTag(tagList, String.format("D%03dA0001", address), "零线端子温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(4) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0002", address), "火线端子温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(6) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0003", address), "芯片温度", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(8) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0004", address), "测量电压", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(10) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0005", address), "测量电流", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(12) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0006", address), "有功功率", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(16) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0007", address), "无功功率", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(20) * 0.1;
        addRbIotTag(tagList, String.format("D%03dA0008", address), "测量频率", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getInt(22) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0009", address), "有功电度量", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getInt(26) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0010", address), "无功电度量", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(30) * 0.01;
        addRbIotTag(tagList, String.format("D%03dA0011", address), "功率因数", String.format("%.2f", tagVal), ts);
        tagVal = byteBuffer.getShort(32);
        addRbIotTag(tagList, String.format("D%03dA0012", address), "开关状态", String.format("%d", (int)tagVal), ts);
        // tagVal = byteBuffer.getShort(34);
        // addRbIotTag(tagList, String.format("D%03dA0013", address), "1区复制低字节", String.format("%d", (int)tagVal), ts);
        // tagVal = byteBuffer.getShort(36);
        // addRbIotTag(tagList, String.format("D%03dA0014", address), "1区复制02高字节", String.format("%d", (int)tagVal), ts);
        // tagVal = byteBuffer.getInt(38) * 0.1;
        // addRbIotTag(tagList, String.format("D%03dA0015", address), "视在功率", String.format("%.1f", tagVal), ts);
        tagVal = byteBuffer.getShort(42);
        addRbIotTag(tagList, String.format("D%03dA0016", address), "过流发生时过流值", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(44);
        addRbIotTag(tagList, String.format("D%03dA0017", address), "电流谐波比率当前值", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(46);
        addRbIotTag(tagList, String.format("D%03dA0018", address), "漏电发生时漏电值", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(48);
        addRbIotTag(tagList, String.format("D%03dA0019", address), "漏电流", String.format("%d", (int)tagVal), ts);
        // tagVal = byteBuffer.getShort(50);
        // addRbIotTag(tagList, String.format("D%03dA0020", address), "拨动按钮位置", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(56);
        addRbIotTag(tagList, String.format("D%03dA0023", address), "电流谐波当前值", String.format("%d", (int)tagVal), ts);
        tagVal = byteBuffer.getShort(66);
        addRbIotTag(tagList, String.format("D%03dA0028", address), "分合闸日志", String.format("%d", (int)tagVal), ts);

        return IeSinglePhaseBreaker.builder().address(address).rbIotTagList(tagList).build();
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
