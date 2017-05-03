package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class Block extends GenericJson {
    @Key
    private String blockType;
    @Key
    private BoundingPoly boundingBox;
    @Key
    private List<Paragraph> paragraphs;
    @Key
    private TextProperty property;

    public String getBlockType() {
        return this.blockType;
    }

    public Block setBlockType(String str) {
        this.blockType = str;
        return this;
    }

    public BoundingPoly getBoundingBox() {
        return this.boundingBox;
    }

    public Block setBoundingBox(BoundingPoly boundingPoly) {
        this.boundingBox = boundingPoly;
        return this;
    }

    public List<Paragraph> getParagraphs() {
        return this.paragraphs;
    }

    public Block setParagraphs(List<Paragraph> list) {
        this.paragraphs = list;
        return this;
    }

    public TextProperty getProperty() {
        return this.property;
    }

    public Block setProperty(TextProperty textProperty) {
        this.property = textProperty;
        return this;
    }

    public Block set(String str, Object obj) {
        return (Block) super.set(str, obj);
    }

    public Block clone() {
        return (Block) super.clone();
    }
}
