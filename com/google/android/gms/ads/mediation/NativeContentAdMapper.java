package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper extends NativeAdMapper {
    private VideoController zzAl;
    private String zzGC;
    private String zzGp;
    private List<Image> zzGq;
    private String zzGr;
    private String zzGt;
    private Image zzaaQ;

    public final String getAdvertiser() {
        return this.zzGC;
    }

    public final String getBody() {
        return this.zzGr;
    }

    public final String getCallToAction() {
        return this.zzGt;
    }

    public final String getHeadline() {
        return this.zzGp;
    }

    public final List<Image> getImages() {
        return this.zzGq;
    }

    public final Image getLogo() {
        return this.zzaaQ;
    }

    public final VideoController getVideoController() {
        return this.zzAl;
    }

    public final void setAdvertiser(String str) {
        this.zzGC = str;
    }

    public final void setBody(String str) {
        this.zzGr = str;
    }

    public final void setCallToAction(String str) {
        this.zzGt = str;
    }

    public final void setHeadline(String str) {
        this.zzGp = str;
    }

    public final void setImages(List<Image> list) {
        this.zzGq = list;
    }

    public final void setLogo(Image image) {
        this.zzaaQ = image;
    }

    public final void zza(VideoController videoController) {
        this.zzAl = videoController;
    }
}
