package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class LatLng extends GenericJson {
    @Key
    private Double latitude;
    @Key
    private Double longitude;

    public Double getLatitude() {
        return this.latitude;
    }

    public LatLng setLatitude(Double d) {
        this.latitude = d;
        return this;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public LatLng setLongitude(Double d) {
        this.longitude = d;
        return this;
    }

    public LatLng set(String str, Object obj) {
        return (LatLng) super.set(str, obj);
    }

    public LatLng clone() {
        return (LatLng) super.clone();
    }
}
