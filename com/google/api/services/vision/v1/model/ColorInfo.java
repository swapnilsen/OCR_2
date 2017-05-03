package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class ColorInfo extends GenericJson {
    @Key
    private Color color;
    @Key
    private Float pixelFraction;
    @Key
    private Float score;

    public Color getColor() {
        return this.color;
    }

    public ColorInfo setColor(Color color) {
        this.color = color;
        return this;
    }

    public Float getPixelFraction() {
        return this.pixelFraction;
    }

    public ColorInfo setPixelFraction(Float f) {
        this.pixelFraction = f;
        return this;
    }

    public Float getScore() {
        return this.score;
    }

    public ColorInfo setScore(Float f) {
        this.score = f;
        return this;
    }

    public ColorInfo set(String str, Object obj) {
        return (ColorInfo) super.set(str, obj);
    }

    public ColorInfo clone() {
        return (ColorInfo) super.clone();
    }
}
