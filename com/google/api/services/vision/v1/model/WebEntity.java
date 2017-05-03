package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class WebEntity extends GenericJson {
    @Key
    private String description;
    @Key
    private String entityId;
    @Key
    private Float score;

    public String getDescription() {
        return this.description;
    }

    public WebEntity setDescription(String str) {
        this.description = str;
        return this;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public WebEntity setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public Float getScore() {
        return this.score;
    }

    public WebEntity setScore(Float f) {
        this.score = f;
        return this;
    }

    public WebEntity set(String str, Object obj) {
        return (WebEntity) super.set(str, obj);
    }

    public WebEntity clone() {
        return (WebEntity) super.clone();
    }
}
