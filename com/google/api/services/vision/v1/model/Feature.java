package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class Feature extends GenericJson {
    @Key
    private Integer maxResults;
    @Key
    private String type;

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public Feature setMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Feature setType(String str) {
        this.type = str;
        return this;
    }

    public Feature set(String str, Object obj) {
        return (Feature) super.set(str, obj);
    }

    public Feature clone() {
        return (Feature) super.clone();
    }
}
