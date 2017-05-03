package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class LatLongRect extends GenericJson {
    @Key
    private LatLng maxLatLng;
    @Key
    private LatLng minLatLng;

    public LatLng getMaxLatLng() {
        return this.maxLatLng;
    }

    public LatLongRect setMaxLatLng(LatLng latLng) {
        this.maxLatLng = latLng;
        return this;
    }

    public LatLng getMinLatLng() {
        return this.minLatLng;
    }

    public LatLongRect setMinLatLng(LatLng latLng) {
        this.minLatLng = latLng;
        return this;
    }

    public LatLongRect set(String str, Object obj) {
        return (LatLongRect) super.set(str, obj);
    }

    public LatLongRect clone() {
        return (LatLongRect) super.clone();
    }
}
