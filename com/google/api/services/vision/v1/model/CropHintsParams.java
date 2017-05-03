package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class CropHintsParams extends GenericJson {
    @Key
    private List<Float> aspectRatios;

    public List<Float> getAspectRatios() {
        return this.aspectRatios;
    }

    public CropHintsParams setAspectRatios(List<Float> list) {
        this.aspectRatios = list;
        return this;
    }

    public CropHintsParams set(String str, Object obj) {
        return (CropHintsParams) super.set(str, obj);
    }

    public CropHintsParams clone() {
        return (CropHintsParams) super.clone();
    }
}
