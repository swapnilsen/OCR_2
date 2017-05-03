package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class ImageContext extends GenericJson {
    @Key
    private CropHintsParams cropHintsParams;
    @Key
    private List<String> languageHints;
    @Key
    private LatLongRect latLongRect;

    public CropHintsParams getCropHintsParams() {
        return this.cropHintsParams;
    }

    public ImageContext setCropHintsParams(CropHintsParams cropHintsParams) {
        this.cropHintsParams = cropHintsParams;
        return this;
    }

    public List<String> getLanguageHints() {
        return this.languageHints;
    }

    public ImageContext setLanguageHints(List<String> list) {
        this.languageHints = list;
        return this;
    }

    public LatLongRect getLatLongRect() {
        return this.latLongRect;
    }

    public ImageContext setLatLongRect(LatLongRect latLongRect) {
        this.latLongRect = latLongRect;
        return this;
    }

    public ImageContext set(String str, Object obj) {
        return (ImageContext) super.set(str, obj);
    }

    public ImageContext clone() {
        return (ImageContext) super.clone();
    }
}
