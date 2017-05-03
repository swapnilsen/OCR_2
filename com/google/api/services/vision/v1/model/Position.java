package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class Position extends GenericJson {
    @Key
    private Float f4492x;
    @Key
    private Float f4493y;
    @Key
    private Float f4494z;

    public Float getX() {
        return this.f4492x;
    }

    public Position setX(Float f) {
        this.f4492x = f;
        return this;
    }

    public Float getY() {
        return this.f4493y;
    }

    public Position setY(Float f) {
        this.f4493y = f;
        return this;
    }

    public Float getZ() {
        return this.f4494z;
    }

    public Position setZ(Float f) {
        this.f4494z = f;
        return this;
    }

    public Position set(String str, Object obj) {
        return (Position) super.set(str, obj);
    }

    public Position clone() {
        return (Position) super.clone();
    }
}
