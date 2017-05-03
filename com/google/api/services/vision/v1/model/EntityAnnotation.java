package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class EntityAnnotation extends GenericJson {
    @Key
    private BoundingPoly boundingPoly;
    @Key
    private Float confidence;
    @Key
    private String description;
    @Key
    private String locale;
    @Key
    private List<LocationInfo> locations;
    @Key
    private String mid;
    @Key
    private List<Property> properties;
    @Key
    private Float score;
    @Key
    private Float topicality;

    static {
        Data.m4898a(LocationInfo.class);
        Data.m4898a(Property.class);
    }

    public BoundingPoly getBoundingPoly() {
        return this.boundingPoly;
    }

    public EntityAnnotation setBoundingPoly(BoundingPoly boundingPoly) {
        this.boundingPoly = boundingPoly;
        return this;
    }

    public Float getConfidence() {
        return this.confidence;
    }

    public EntityAnnotation setConfidence(Float f) {
        this.confidence = f;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public EntityAnnotation setDescription(String str) {
        this.description = str;
        return this;
    }

    public String getLocale() {
        return this.locale;
    }

    public EntityAnnotation setLocale(String str) {
        this.locale = str;
        return this;
    }

    public List<LocationInfo> getLocations() {
        return this.locations;
    }

    public EntityAnnotation setLocations(List<LocationInfo> list) {
        this.locations = list;
        return this;
    }

    public String getMid() {
        return this.mid;
    }

    public EntityAnnotation setMid(String str) {
        this.mid = str;
        return this;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public EntityAnnotation setProperties(List<Property> list) {
        this.properties = list;
        return this;
    }

    public Float getScore() {
        return this.score;
    }

    public EntityAnnotation setScore(Float f) {
        this.score = f;
        return this;
    }

    public Float getTopicality() {
        return this.topicality;
    }

    public EntityAnnotation setTopicality(Float f) {
        this.topicality = f;
        return this;
    }

    public EntityAnnotation set(String str, Object obj) {
        return (EntityAnnotation) super.set(str, obj);
    }

    public EntityAnnotation clone() {
        return (EntityAnnotation) super.clone();
    }
}
