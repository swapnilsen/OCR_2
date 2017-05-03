package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class WebDetection extends GenericJson {
    @Key
    private List<WebImage> fullMatchingImages;
    @Key
    private List<WebPage> pagesWithMatchingImages;
    @Key
    private List<WebImage> partialMatchingImages;
    @Key
    private List<WebImage> visuallySimilarImages;
    @Key
    private List<WebEntity> webEntities;

    static {
        Data.m4898a(WebEntity.class);
    }

    public List<WebImage> getFullMatchingImages() {
        return this.fullMatchingImages;
    }

    public WebDetection setFullMatchingImages(List<WebImage> list) {
        this.fullMatchingImages = list;
        return this;
    }

    public List<WebPage> getPagesWithMatchingImages() {
        return this.pagesWithMatchingImages;
    }

    public WebDetection setPagesWithMatchingImages(List<WebPage> list) {
        this.pagesWithMatchingImages = list;
        return this;
    }

    public List<WebImage> getPartialMatchingImages() {
        return this.partialMatchingImages;
    }

    public WebDetection setPartialMatchingImages(List<WebImage> list) {
        this.partialMatchingImages = list;
        return this;
    }

    public List<WebImage> getVisuallySimilarImages() {
        return this.visuallySimilarImages;
    }

    public WebDetection setVisuallySimilarImages(List<WebImage> list) {
        this.visuallySimilarImages = list;
        return this;
    }

    public List<WebEntity> getWebEntities() {
        return this.webEntities;
    }

    public WebDetection setWebEntities(List<WebEntity> list) {
        this.webEntities = list;
        return this;
    }

    public WebDetection set(String str, Object obj) {
        return (WebDetection) super.set(str, obj);
    }

    public WebDetection clone() {
        return (WebDetection) super.clone();
    }
}
