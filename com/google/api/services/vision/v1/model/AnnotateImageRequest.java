package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class AnnotateImageRequest extends GenericJson {
    @Key
    private List<Feature> features;
    @Key
    private Image image;
    @Key
    private ImageContext imageContext;

    static {
        Data.m4898a(Feature.class);
    }

    public List<Feature> getFeatures() {
        return this.features;
    }

    public AnnotateImageRequest setFeatures(List<Feature> list) {
        this.features = list;
        return this;
    }

    public Image getImage() {
        return this.image;
    }

    public AnnotateImageRequest setImage(Image image) {
        this.image = image;
        return this;
    }

    public ImageContext getImageContext() {
        return this.imageContext;
    }

    public AnnotateImageRequest setImageContext(ImageContext imageContext) {
        this.imageContext = imageContext;
        return this;
    }

    public AnnotateImageRequest set(String str, Object obj) {
        return (AnnotateImageRequest) super.set(str, obj);
    }

    public AnnotateImageRequest clone() {
        return (AnnotateImageRequest) super.clone();
    }
}
