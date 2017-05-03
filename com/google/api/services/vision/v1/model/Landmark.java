package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class Landmark extends GenericJson {
    @Key
    private Position position;
    @Key
    private String type;

    public Position getPosition() {
        return this.position;
    }

    public Landmark setPosition(Position position) {
        this.position = position;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Landmark setType(String str) {
        this.type = str;
        return this;
    }

    public Landmark set(String str, Object obj) {
        return (Landmark) super.set(str, obj);
    }

    public Landmark clone() {
        return (Landmark) super.clone();
    }
}
