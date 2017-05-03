package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Base64;
import com.google.api.client.p082b.Key;

public final class Image extends GenericJson {
    @Key
    private String content;
    @Key
    private ImageSource source;

    public String getContent() {
        return this.content;
    }

    public byte[] decodeContent() {
        return Base64.m4885a(this.content);
    }

    public Image setContent(String str) {
        this.content = str;
        return this;
    }

    public Image encodeContent(byte[] bArr) {
        this.content = Base64.m4886b(bArr);
        return this;
    }

    public ImageSource getSource() {
        return this.source;
    }

    public Image setSource(ImageSource imageSource) {
        this.source = imageSource;
        return this;
    }

    public Image set(String str, Object obj) {
        return (Image) super.set(str, obj);
    }

    public Image clone() {
        return (Image) super.clone();
    }
}
