package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class DetectedLanguage extends GenericJson {
    @Key
    private Float confidence;
    @Key
    private String languageCode;

    public Float getConfidence() {
        return this.confidence;
    }

    public DetectedLanguage setConfidence(Float f) {
        this.confidence = f;
        return this;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public DetectedLanguage setLanguageCode(String str) {
        this.languageCode = str;
        return this;
    }

    public DetectedLanguage set(String str, Object obj) {
        return (DetectedLanguage) super.set(str, obj);
    }

    public DetectedLanguage clone() {
        return (DetectedLanguage) super.clone();
    }
}
