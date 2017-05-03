package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class AnnotateImageResponse extends GenericJson {
    @Key
    private CropHintsAnnotation cropHintsAnnotation;
    @Key
    private Status error;
    @Key
    private List<FaceAnnotation> faceAnnotations;
    @Key
    private TextAnnotation fullTextAnnotation;
    @Key
    private ImageProperties imagePropertiesAnnotation;
    @Key
    private List<EntityAnnotation> labelAnnotations;
    @Key
    private List<EntityAnnotation> landmarkAnnotations;
    @Key
    private List<EntityAnnotation> logoAnnotations;
    @Key
    private SafeSearchAnnotation safeSearchAnnotation;
    @Key
    private List<EntityAnnotation> textAnnotations;
    @Key
    private WebDetection webDetection;

    public CropHintsAnnotation getCropHintsAnnotation() {
        return this.cropHintsAnnotation;
    }

    public AnnotateImageResponse setCropHintsAnnotation(CropHintsAnnotation cropHintsAnnotation) {
        this.cropHintsAnnotation = cropHintsAnnotation;
        return this;
    }

    public Status getError() {
        return this.error;
    }

    public AnnotateImageResponse setError(Status status) {
        this.error = status;
        return this;
    }

    public List<FaceAnnotation> getFaceAnnotations() {
        return this.faceAnnotations;
    }

    public AnnotateImageResponse setFaceAnnotations(List<FaceAnnotation> list) {
        this.faceAnnotations = list;
        return this;
    }

    public TextAnnotation getFullTextAnnotation() {
        return this.fullTextAnnotation;
    }

    public AnnotateImageResponse setFullTextAnnotation(TextAnnotation textAnnotation) {
        this.fullTextAnnotation = textAnnotation;
        return this;
    }

    public ImageProperties getImagePropertiesAnnotation() {
        return this.imagePropertiesAnnotation;
    }

    public AnnotateImageResponse setImagePropertiesAnnotation(ImageProperties imageProperties) {
        this.imagePropertiesAnnotation = imageProperties;
        return this;
    }

    public List<EntityAnnotation> getLabelAnnotations() {
        return this.labelAnnotations;
    }

    public AnnotateImageResponse setLabelAnnotations(List<EntityAnnotation> list) {
        this.labelAnnotations = list;
        return this;
    }

    public List<EntityAnnotation> getLandmarkAnnotations() {
        return this.landmarkAnnotations;
    }

    public AnnotateImageResponse setLandmarkAnnotations(List<EntityAnnotation> list) {
        this.landmarkAnnotations = list;
        return this;
    }

    public List<EntityAnnotation> getLogoAnnotations() {
        return this.logoAnnotations;
    }

    public AnnotateImageResponse setLogoAnnotations(List<EntityAnnotation> list) {
        this.logoAnnotations = list;
        return this;
    }

    public SafeSearchAnnotation getSafeSearchAnnotation() {
        return this.safeSearchAnnotation;
    }

    public AnnotateImageResponse setSafeSearchAnnotation(SafeSearchAnnotation safeSearchAnnotation) {
        this.safeSearchAnnotation = safeSearchAnnotation;
        return this;
    }

    public List<EntityAnnotation> getTextAnnotations() {
        return this.textAnnotations;
    }

    public AnnotateImageResponse setTextAnnotations(List<EntityAnnotation> list) {
        this.textAnnotations = list;
        return this;
    }

    public WebDetection getWebDetection() {
        return this.webDetection;
    }

    public AnnotateImageResponse setWebDetection(WebDetection webDetection) {
        this.webDetection = webDetection;
        return this;
    }

    public AnnotateImageResponse set(String str, Object obj) {
        return (AnnotateImageResponse) super.set(str, obj);
    }

    public AnnotateImageResponse clone() {
        return (AnnotateImageResponse) super.clone();
    }
}
