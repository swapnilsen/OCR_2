package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class CropHint extends GenericJson {
    @Key
    private BoundingPoly boundingPoly;
    @Key
    private Float confidence;
    @Key
    private Float importanceFraction;

    public BoundingPoly getBoundingPoly() {
        return this.boundingPoly;
    }

    public CropHint setBoundingPoly(BoundingPoly boundingPoly) {
        this.boundingPoly = boundingPoly;
        return this;
    }

    public Float getConfidence() {
        return this.confidence;
    }

    public CropHint setConfidence(Float f) {
        this.confidence = f;
        return this;
    }

    public Float getImportanceFraction() {
        return this.importanceFraction;
    }

    public CropHint setImportanceFraction(Float f) {
        this.importanceFraction = f;
        return this;
    }

    public CropHint set(String str, Object obj) {
        return (CropHint) super.set(str, obj);
    }

    public CropHint clone() {
        return (CropHint) super.clone();
    }
}
