package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class WebImage extends GenericJson {
    @Key
    private Float score;
    @Key
    private String url;

    public Float getScore() {
        return this.score;
    }

    public WebImage setScore(Float f) {
        this.score = f;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public WebImage setUrl(String str) {
        this.url = str;
        return this;
    }

    public WebImage set(String str, Object obj) {
        return (WebImage) super.set(str, obj);
    }

    public WebImage clone() {
        return (WebImage) super.clone();
    }
}
