package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class Page extends GenericJson {
    @Key
    private List<Block> blocks;
    @Key
    private Integer height;
    @Key
    private TextProperty property;
    @Key
    private Integer width;

    static {
        Data.m4898a(Block.class);
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public Page setBlocks(List<Block> list) {
        this.blocks = list;
        return this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Page setHeight(Integer num) {
        this.height = num;
        return this;
    }

    public TextProperty getProperty() {
        return this.property;
    }

    public Page setProperty(TextProperty textProperty) {
        this.property = textProperty;
        return this;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Page setWidth(Integer num) {
        this.width = num;
        return this;
    }

    public Page set(String str, Object obj) {
        return (Page) super.set(str, obj);
    }

    public Page clone() {
        return (Page) super.clone();
    }
}
