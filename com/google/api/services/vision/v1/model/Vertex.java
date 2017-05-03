package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class Vertex extends GenericJson {
    @Key
    private Integer f4495x;
    @Key
    private Integer f4496y;

    public Integer getX() {
        return this.f4495x;
    }

    public Vertex setX(Integer num) {
        this.f4495x = num;
        return this;
    }

    public Integer getY() {
        return this.f4496y;
    }

    public Vertex setY(Integer num) {
        this.f4496y = num;
        return this;
    }

    public Vertex set(String str, Object obj) {
        return (Vertex) super.set(str, obj);
    }

    public Vertex clone() {
        return (Vertex) super.clone();
    }
}
