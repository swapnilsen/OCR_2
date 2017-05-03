package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class Paragraph extends GenericJson {
    @Key
    private BoundingPoly boundingBox;
    @Key
    private TextProperty property;
    @Key
    private List<Word> words;

    static {
        Data.m4898a(Word.class);
    }

    public BoundingPoly getBoundingBox() {
        return this.boundingBox;
    }

    public Paragraph setBoundingBox(BoundingPoly boundingPoly) {
        this.boundingBox = boundingPoly;
        return this;
    }

    public TextProperty getProperty() {
        return this.property;
    }

    public Paragraph setProperty(TextProperty textProperty) {
        this.property = textProperty;
        return this;
    }

    public List<Word> getWords() {
        return this.words;
    }

    public Paragraph setWords(List<Word> list) {
        this.words = list;
        return this;
    }

    public Paragraph set(String str, Object obj) {
        return (Paragraph) super.set(str, obj);
    }

    public Paragraph clone() {
        return (Paragraph) super.clone();
    }
}
