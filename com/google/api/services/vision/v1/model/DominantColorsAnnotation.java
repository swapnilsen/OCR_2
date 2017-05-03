package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class DominantColorsAnnotation extends GenericJson {
    @Key
    private List<ColorInfo> colors;

    public List<ColorInfo> getColors() {
        return this.colors;
    }

    public DominantColorsAnnotation setColors(List<ColorInfo> list) {
        this.colors = list;
        return this;
    }

    public DominantColorsAnnotation set(String str, Object obj) {
        return (DominantColorsAnnotation) super.set(str, obj);
    }

    public DominantColorsAnnotation clone() {
        return (DominantColorsAnnotation) super.clone();
    }
}
