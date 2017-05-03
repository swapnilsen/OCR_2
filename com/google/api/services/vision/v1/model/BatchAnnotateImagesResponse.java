package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class BatchAnnotateImagesResponse extends GenericJson {
    @Key
    private List<AnnotateImageResponse> responses;

    static {
        Data.m4898a(AnnotateImageResponse.class);
    }

    public List<AnnotateImageResponse> getResponses() {
        return this.responses;
    }

    public BatchAnnotateImagesResponse setResponses(List<AnnotateImageResponse> list) {
        this.responses = list;
        return this;
    }

    public BatchAnnotateImagesResponse set(String str, Object obj) {
        return (BatchAnnotateImagesResponse) super.set(str, obj);
    }

    public BatchAnnotateImagesResponse clone() {
        return (BatchAnnotateImagesResponse) super.clone();
    }
}
