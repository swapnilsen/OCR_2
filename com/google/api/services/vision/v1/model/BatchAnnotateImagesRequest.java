package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class BatchAnnotateImagesRequest extends GenericJson {
    @Key
    private List<AnnotateImageRequest> requests;

    public List<AnnotateImageRequest> getRequests() {
        return this.requests;
    }

    public BatchAnnotateImagesRequest setRequests(List<AnnotateImageRequest> list) {
        this.requests = list;
        return this;
    }

    public BatchAnnotateImagesRequest set(String str, Object obj) {
        return (BatchAnnotateImagesRequest) super.set(str, obj);
    }

    public BatchAnnotateImagesRequest clone() {
        return (BatchAnnotateImagesRequest) super.clone();
    }
}
