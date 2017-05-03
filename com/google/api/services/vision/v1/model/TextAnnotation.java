package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class TextAnnotation extends GenericJson {
    @Key
    private List<Page> pages;
    @Key
    private String text;

    public List<Page> getPages() {
        return this.pages;
    }

    public TextAnnotation setPages(List<Page> list) {
        this.pages = list;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public TextAnnotation setText(String str) {
        this.text = str;
        return this;
    }

    public TextAnnotation set(String str, Object obj) {
        return (TextAnnotation) super.set(str, obj);
    }

    public TextAnnotation clone() {
        return (TextAnnotation) super.clone();
    }
}
