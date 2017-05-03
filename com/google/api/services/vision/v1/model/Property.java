package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.p082b.Key;
import java.math.BigInteger;

public final class Property extends GenericJson {
    @Key
    private String name;
    @Key
    @JsonString
    private BigInteger uint64Value;
    @Key
    private String value;

    public String getName() {
        return this.name;
    }

    public Property setName(String str) {
        this.name = str;
        return this;
    }

    public BigInteger getUint64Value() {
        return this.uint64Value;
    }

    public Property setUint64Value(BigInteger bigInteger) {
        this.uint64Value = bigInteger;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public Property setValue(String str) {
        this.value = str;
        return this;
    }

    public Property set(String str, Object obj) {
        return (Property) super.set(str, obj);
    }

    public Property clone() {
        return (Property) super.clone();
    }
}
