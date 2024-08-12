package com.hd.daq.transportapi.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hd.daq.transportapi.proto.TransportProtos.KeyValueProto;

import java.util.List;

public class JsonUtils {

    private static final JsonParser jsonParser = new JsonParser();

    public static JsonObject getJsonObject(List<KeyValueProto> tsKv) {
        JsonObject json = new JsonObject();
        for (KeyValueProto kv : tsKv) {
            switch (kv.getType()) {
                case BOOLEAN_V:
                    json.addProperty(kv.getKey(), kv.getBoolV());
                    break;
                case LONG_V:
                    json.addProperty(kv.getKey(), kv.getLongV());
                    break;
                case DOUBLE_V:
                    json.addProperty(kv.getKey(), kv.getDoubleV());
                    break;
                case STRING_V:
                    json.addProperty(kv.getKey(), kv.getStringV());
                    break;
                case JSON_V:
                    json.add(kv.getKey(), jsonParser.parse(kv.getJsonV()));
                    break;
            }
        }
        return json;
    }

    public static JsonElement parse(String params) {
        return jsonParser.parse(params);
    }
}
