package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class ImageProperties extends GenericJson {
    @Key
    private DominantColorsAnnotation dominantColors;

    public DominantColorsAnnotation getDominantColors() {
        return this.dominantColors;
    }

    public ImageProperties setDominantColors(DominantColorsAnnotation dominantColorsAnnotation) {
        this.dominantColors = dominantColorsAnnotation;
        return this;
    }

    public ImageProperties set(String str, Object obj) {
        return (ImageProperties) super.set(str, obj);
    }

    public ImageProperties clone() {
        return (ImageProperties) super.clone();
    }
}
