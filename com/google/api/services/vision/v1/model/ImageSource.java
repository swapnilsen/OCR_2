package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;

public final class ImageSource extends GenericJson {
    @Key
    private String gcsImageUri;
    @Key
    private String imageUri;

    public String getGcsImageUri() {
        return this.gcsImageUri;
    }

    public ImageSource setGcsImageUri(String str) {
        this.gcsImageUri = str;
        return this;
    }

    public String getImageUri() {
        return this.imageUri;
    }

    public ImageSource setImageUri(String str) {
        this.imageUri = str;
        return this;
    }

    public ImageSource set(String str, Object obj) {
        return (ImageSource) super.set(str, obj);
    }

    public ImageSource clone() {
        return (ImageSource) super.clone();
    }
}
