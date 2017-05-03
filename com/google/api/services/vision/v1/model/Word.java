package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class Word extends GenericJson {
    @Key
    private BoundingPoly boundingBox;
    @Key
    private TextProperty property;
    @Key
    private List<Symbol> symbols;

    public BoundingPoly getBoundingBox() {
        return this.boundingBox;
    }

    public Word setBoundingBox(BoundingPoly boundingPoly) {
        this.boundingBox = boundingPoly;
        return this;
    }

    public TextProperty getProperty() {
        return this.property;
    }

    public Word setProperty(TextProperty textProperty) {
        this.property = textProperty;
        return this;
    }

    public List<Symbol> getSymbols() {
        return this.symbols;
    }

    public Word setSymbols(List<Symbol> list) {
        this.symbols = list;
        return this;
    }

    public Word set(String str, Object obj) {
        return (Word) super.set(str, obj);
    }

    public Word clone() {
        return (Word) super.clone();
    }
}
