package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class DetectedBreak extends GenericJson {
    @Key
    private Boolean isPrefix;
    @Key
    private String type;

    public Boolean getIsPrefix() {
        return this.isPrefix;
    }

    public DetectedBreak setIsPrefix(Boolean bool) {
        this.isPrefix = bool;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public DetectedBreak setType(String str) {
        this.type = str;
        return this;
    }

    public DetectedBreak set(String str, Object obj) {
        return (DetectedBreak) super.set(str, obj);
    }

    public DetectedBreak clone() {
        return (DetectedBreak) super.clone();
    }
}
