package com.hd.daq.transportapi.util;

import com.hd.daq.transportapi.proto.TransportProtos.KeyValueProto;

public class KeyValueProtoUtil {
    public static String getValueString(KeyValueProto kv) {
        String valueString = "";
        switch (kv.getType()) {
            case BOOLEAN_V:
                valueString = kv.getBoolV() ? "1" : "0";
                break;
            case LONG_V:
                valueString = Long.toString(kv.getLongV());
                break;
            case DOUBLE_V:
                valueString = Double.toString(kv.getDoubleV());
                break;
            case STRING_V:
                valueString = kv.getStringV();
                break;
            case JSON_V:
                valueString = kv.getJsonV();
                break;
            default:
                break;
        }

        return valueString;
    }
}
