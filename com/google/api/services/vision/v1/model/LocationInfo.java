package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class LocationInfo extends GenericJson {
    @Key
    private LatLng latLng;

    public LatLng getLatLng() {
        return this.latLng;
    }

    public LocationInfo setLatLng(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public LocationInfo set(String str, Object obj) {
        return (LocationInfo) super.set(str, obj);
    }

    public LocationInfo clone() {
        return (LocationInfo) super.clone();
    }
}
