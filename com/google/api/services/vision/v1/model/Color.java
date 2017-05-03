package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class Color extends GenericJson {
    @Key
    private Float alpha;
    @Key
    private Float blue;
    @Key
    private Float green;
    @Key
    private Float red;

    public Float getAlpha() {
        return this.alpha;
    }

    public Color setAlpha(Float f) {
        this.alpha = f;
        return this;
    }

    public Float getBlue() {
        return this.blue;
    }

    public Color setBlue(Float f) {
        this.blue = f;
        return this;
    }

    public Float getGreen() {
        return this.green;
    }

    public Color setGreen(Float f) {
        this.green = f;
        return this;
    }

    public Float getRed() {
        return this.red;
    }

    public Color setRed(Float f) {
        this.red = f;
        return this;
    }

    public Color set(String str, Object obj) {
        return (Color) super.set(str, obj);
    }

    public Color clone() {
        return (Color) super.clone();
    }
}
