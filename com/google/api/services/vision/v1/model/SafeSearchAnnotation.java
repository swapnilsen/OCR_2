package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class SafeSearchAnnotation extends GenericJson {
    @Key
    private String adult;
    @Key
    private String medical;
    @Key
    private String spoof;
    @Key
    private String violence;

    public String getAdult() {
        return this.adult;
    }

    public SafeSearchAnnotation setAdult(String str) {
        this.adult = str;
        return this;
    }

    public String getMedical() {
        return this.medical;
    }

    public SafeSearchAnnotation setMedical(String str) {
        this.medical = str;
        return this;
    }

    public String getSpoof() {
        return this.spoof;
    }

    public SafeSearchAnnotation setSpoof(String str) {
        this.spoof = str;
        return this;
    }

    public String getViolence() {
        return this.violence;
    }

    public SafeSearchAnnotation setViolence(String str) {
        this.violence = str;
        return this;
    }

    public SafeSearchAnnotation set(String str, Object obj) {
        return (SafeSearchAnnotation) super.set(str, obj);
    }

    public SafeSearchAnnotation clone() {
        return (SafeSearchAnnotation) super.clone();
    }
}
