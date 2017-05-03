package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class CropHintsAnnotation extends GenericJson {
    @Key
    private List<CropHint> cropHints;

    static {
        Data.m4898a(CropHint.class);
    }

    public List<CropHint> getCropHints() {
        return this.cropHints;
    }

    public CropHintsAnnotation setCropHints(List<CropHint> list) {
        this.cropHints = list;
        return this;
    }

    public CropHintsAnnotation set(String str, Object obj) {
        return (CropHintsAnnotation) super.set(str, obj);
    }

    public CropHintsAnnotation clone() {
        return (CropHintsAnnotation) super.clone();
    }
}
