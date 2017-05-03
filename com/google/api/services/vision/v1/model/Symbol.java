package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class Symbol extends GenericJson {
    @Key
    private BoundingPoly boundingBox;
    @Key
    private TextProperty property;
    @Key
    private String text;

    public BoundingPoly getBoundingBox() {
        return this.boundingBox;
    }

    public Symbol setBoundingBox(BoundingPoly boundingPoly) {
        this.boundingBox = boundingPoly;
        return this;
    }

    public TextProperty getProperty() {
        return this.property;
    }

    public Symbol setProperty(TextProperty textProperty) {
        this.property = textProperty;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public Symbol setText(String str) {
        this.text = str;
        return this;
    }

    public Symbol set(String str, Object obj) {
        return (Symbol) super.set(str, obj);
    }

    public Symbol clone() {
        return (Symbol) super.clone();
    }
}
