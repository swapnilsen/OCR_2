package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class TextProperty extends GenericJson {
    @Key
    private DetectedBreak detectedBreak;
    @Key
    private List<DetectedLanguage> detectedLanguages;

    static {
        Data.m4898a(DetectedLanguage.class);
    }

    public DetectedBreak getDetectedBreak() {
        return this.detectedBreak;
    }

    public TextProperty setDetectedBreak(DetectedBreak detectedBreak) {
        this.detectedBreak = detectedBreak;
        return this;
    }

    public List<DetectedLanguage> getDetectedLanguages() {
        return this.detectedLanguages;
    }

    public TextProperty setDetectedLanguages(List<DetectedLanguage> list) {
        this.detectedLanguages = list;
        return this;
    }

    public TextProperty set(String str, Object obj) {
        return (TextProperty) super.set(str, obj);
    }

    public TextProperty clone() {
        return (TextProperty) super.clone();
    }
}
