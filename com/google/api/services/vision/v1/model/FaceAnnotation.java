package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class FaceAnnotation extends GenericJson {
    @Key
    private String angerLikelihood;
    @Key
    private String blurredLikelihood;
    @Key
    private BoundingPoly boundingPoly;
    @Key
    private Float detectionConfidence;
    @Key
    private BoundingPoly fdBoundingPoly;
    @Key
    private String headwearLikelihood;
    @Key
    private String joyLikelihood;
    @Key
    private Float landmarkingConfidence;
    @Key
    private List<Landmark> landmarks;
    @Key
    private Float panAngle;
    @Key
    private Float rollAngle;
    @Key
    private String sorrowLikelihood;
    @Key
    private String surpriseLikelihood;
    @Key
    private Float tiltAngle;
    @Key
    private String underExposedLikelihood;

    static {
        Data.m4898a(Landmark.class);
    }

    public String getAngerLikelihood() {
        return this.angerLikelihood;
    }

    public FaceAnnotation setAngerLikelihood(String str) {
        this.angerLikelihood = str;
        return this;
    }

    public String getBlurredLikelihood() {
        return this.blurredLikelihood;
    }

    public FaceAnnotation setBlurredLikelihood(String str) {
        this.blurredLikelihood = str;
        return this;
    }

    public BoundingPoly getBoundingPoly() {
        return this.boundingPoly;
    }

    public FaceAnnotation setBoundingPoly(BoundingPoly boundingPoly) {
        this.boundingPoly = boundingPoly;
        return this;
    }

    public Float getDetectionConfidence() {
        return this.detectionConfidence;
    }

    public FaceAnnotation setDetectionConfidence(Float f) {
        this.detectionConfidence = f;
        return this;
    }

    public BoundingPoly getFdBoundingPoly() {
        return this.fdBoundingPoly;
    }

    public FaceAnnotation setFdBoundingPoly(BoundingPoly boundingPoly) {
        this.fdBoundingPoly = boundingPoly;
        return this;
    }

    public String getHeadwearLikelihood() {
        return this.headwearLikelihood;
    }

    public FaceAnnotation setHeadwearLikelihood(String str) {
        this.headwearLikelihood = str;
        return this;
    }

    public String getJoyLikelihood() {
        return this.joyLikelihood;
    }

    public FaceAnnotation setJoyLikelihood(String str) {
        this.joyLikelihood = str;
        return this;
    }

    public Float getLandmarkingConfidence() {
        return this.landmarkingConfidence;
    }

    public FaceAnnotation setLandmarkingConfidence(Float f) {
        this.landmarkingConfidence = f;
        return this;
    }

    public List<Landmark> getLandmarks() {
        return this.landmarks;
    }

    public FaceAnnotation setLandmarks(List<Landmark> list) {
        this.landmarks = list;
        return this;
    }

    public Float getPanAngle() {
        return this.panAngle;
    }

    public FaceAnnotation setPanAngle(Float f) {
        this.panAngle = f;
        return this;
    }

    public Float getRollAngle() {
        return this.rollAngle;
    }

    public FaceAnnotation setRollAngle(Float f) {
        this.rollAngle = f;
        return this;
    }

    public String getSorrowLikelihood() {
        return this.sorrowLikelihood;
    }

    public FaceAnnotation setSorrowLikelihood(String str) {
        this.sorrowLikelihood = str;
        return this;
    }

    public String getSurpriseLikelihood() {
        return this.surpriseLikelihood;
    }

    public FaceAnnotation setSurpriseLikelihood(String str) {
        this.surpriseLikelihood = str;
        return this;
    }

    public Float getTiltAngle() {
        return this.tiltAngle;
    }

    public FaceAnnotation setTiltAngle(Float f) {
        this.tiltAngle = f;
        return this;
    }

    public String getUnderExposedLikelihood() {
        return this.underExposedLikelihood;
    }

    public FaceAnnotation setUnderExposedLikelihood(String str) {
        this.underExposedLikelihood = str;
        return this;
    }

    public FaceAnnotation set(String str, Object obj) {
        return (FaceAnnotation) super.set(str, obj);
    }

    public FaceAnnotation clone() {
        return (FaceAnnotation) super.clone();
    }
}
