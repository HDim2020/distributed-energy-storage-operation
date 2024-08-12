package com.hd.daq.transportapi.data.kv;

import java.util.Objects;
import java.util.Optional;

/**
 * @author ymm
 */
public class JsonDataEntry extends BasicKvEntry {
    private final String value;

    public JsonDataEntry(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public DataType getDataType() {
        return DataType.JSON;
    }

    @Override
    public Optional<String> getJsonValue() {
        return Optional.ofNullable(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JsonDataEntry)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        JsonDataEntry that = (JsonDataEntry) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    @Override
    public String toString() {
        return "JsonDataEntry{" +
                "value=" + value +
                "} " + super.toString();
    }

    @Override
    public String getValueAsString() {
        return value;
    }
}

