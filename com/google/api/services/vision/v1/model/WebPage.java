package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class WebPage extends GenericJson {
    @Key
    private Float score;
    @Key
    private String url;

    public Float getScore() {
        return this.score;
    }

    public WebPage setScore(Float f) {
        this.score = f;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public WebPage setUrl(String str) {
        this.url = str;
        return this;
    }

    public WebPage set(String str, Object obj) {
        return (WebPage) super.set(str, obj);
    }

    public WebPage clone() {
        return (WebPage) super.clone();
    }
}
