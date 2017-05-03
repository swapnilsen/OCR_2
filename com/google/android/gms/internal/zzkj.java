package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzke.zza;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzkj extends zza {
    private final NativeAppInstallAdMapper zzLG;

    public zzkj(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzLG = nativeAppInstallAdMapper;
    }

    public String getBody() {
        return this.zzLG.getBody();
    }

    public String getCallToAction() {
        return this.zzLG.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzLG.getExtras();
    }

    public String getHeadline() {
        return this.zzLG.getHeadline();
    }

    public List getImages() {
        List<Image> images = this.zzLG.getImages();
        if (images == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : images) {
            arrayList.add(new zzgu(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    public boolean getOverrideClickHandling() {
        return this.zzLG.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzLG.getOverrideImpressionRecording();
    }

    public String getPrice() {
        return this.zzLG.getPrice();
    }

    public double getStarRating() {
        return this.zzLG.getStarRating();
    }

    public String getStore() {
        return this.zzLG.getStore();
    }

    public void recordImpression() {
        this.zzLG.recordImpression();
    }

    public zzfa zzbF() {
        return this.zzLG.getVideoController() != null ? this.zzLG.getVideoController().zzbs() : null;
    }

    public zzhf zzfQ() {
        Image icon = this.zzLG.getIcon();
        return icon != null ? new zzgu(icon.getDrawable(), icon.getUri(), icon.getScale()) : null;
    }

    public IObjectWrapper zzhh() {
        View adChoicesContent = this.zzLG.getAdChoicesContent();
        return adChoicesContent == null ? null : zzd.zzA(adChoicesContent);
    }

    public void zzl(IObjectWrapper iObjectWrapper) {
        this.zzLG.handleClick((View) zzd.zzF(iObjectWrapper));
    }

    public void zzm(IObjectWrapper iObjectWrapper) {
        this.zzLG.trackView((View) zzd.zzF(iObjectWrapper));
    }

    public void zzn(IObjectWrapper iObjectWrapper) {
        this.zzLG.untrackView((View) zzd.zzF(iObjectWrapper));
    }
}
