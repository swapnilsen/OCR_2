package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;
import java.util.Map;

public final class Status extends GenericJson {
    @Key
    private Integer code;
    @Key
    private List<Map<String, Object>> details;
    @Key
    private String message;

    public Integer getCode() {
        return this.code;
    }

    public Status setCode(Integer num) {
        this.code = num;
        return this;
    }

    public List<Map<String, Object>> getDetails() {
        return this.details;
    }

    public Status setDetails(List<Map<String, Object>> list) {
        this.details = list;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Status setMessage(String str) {
        this.message = str;
        return this;
    }

    public Status set(String str, Object obj) {
        return (Status) super.set(str, obj);
    }

    public Status clone() {
        return (Status) super.clone();
    }
}
