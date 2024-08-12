package com.hd.daq.plugins.rbscb.data;

import com.hd.daq.plugins.rbscb.data.ie.IeExecuteResult;
import com.hd.daq.plugins.rbscb.data.ie.IeSinglePhaseBreaker;
import com.hd.daq.plugins.rbscb.data.ie.IeThreePhaseBreaker;
import com.hd.daq.plugins.rbscb.data.ie.RbIotInformationElement;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

/**
 * @author ymm
 */
@Slf4j
public class RbIotInformationObject {
    @Getter
    private final RbIotInformationElement[] informationElements;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (RbIotInformationElement ie : informationElements) {
            builder.append(ie.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    public RbIotInformationObject(RbIotInformationElement... informationElement) {
        this.informationElements = informationElement;
    }

    public static RbIotInformationObject decode(InputStream in, int control, int type, int id) {
        if (control != RbIotControlType.LINK_TO_SERVER.getId()) {
            return null;
        }
        try {
            RbIotMsgType msgType = RbIotMsgType.typeFor(type);
            if (msgType == null) {
                return null;
            }
            RbIotInformationElement[] informationElements;
            switch (msgType) {
                case SERVER_REQUEST_TELEMETRY_DATA: {
                    informationElements = new RbIotInformationElement[in.read() + in.read()];
                    int i = 0;
                    while (in.available() > 0) {
                        in.mark(0);
                        in.read();
                        int devType = in.read();
                        in.reset();
                        if (devType == BreakerType.SINGLE_PHASE.getId()) {
                            informationElements[i] = IeSinglePhaseBreaker.decode(in);
                        } else {
                            informationElements[i] = IeThreePhaseBreaker.decode(in);
                        }
                        ++i;
                    }
                }
                break;
                case SERVER_REMOTE_CONTROL_BROKER:
                    informationElements = new RbIotInformationElement[1];
                    informationElements[0] = IeExecuteResult.decode(in);
                    break;
                default:
                    log.debug("unkown function code:" + msgType.getId());
                    return null;
            }
            return new RbIotInformationObject(informationElements);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 编码信息体对象
     * @param buffer 缓冲区
     * @return 编码后的长度
     */
    public int encode(ByteBuf buffer) {
        int count = 0;
        for (RbIotInformationElement ie : informationElements) {
            count += ie.encode(buffer);
        }

        return count;
    }
}
