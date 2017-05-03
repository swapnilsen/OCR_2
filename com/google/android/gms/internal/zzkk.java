package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzkf.zza;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzkk extends zza {
    private final NativeContentAdMapper zzLH;

    public zzkk(NativeContentAdMapper nativeContentAdMapper) {
        this.zzLH = nativeContentAdMapper;
    }

    public String getAdvertiser() {
        return this.zzLH.getAdvertiser();
    }

    public String getBody() {
        return this.zzLH.getBody();
    }

    public String getCallToAction() {
        return this.zzLH.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzLH.getExtras();
    }

    public String getHeadline() {
        return this.zzLH.getHeadline();
    }

    public List getImages() {
        List<Image> images = this.zzLH.getImages();
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
        return this.zzLH.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzLH.getOverrideImpressionRecording();
    }

    public void recordImpression() {
        this.zzLH.recordImpression();
    }

    public zzfa zzbF() {
        return this.zzLH.getVideoController() != null ? this.zzLH.getVideoController().zzbs() : null;
    }

    public zzhf zzfV() {
        Image logo = this.zzLH.getLogo();
        return logo != null ? new zzgu(logo.getDrawable(), logo.getUri(), logo.getScale()) : null;
    }

    public IObjectWrapper zzhh() {
        View adChoicesContent = this.zzLH.getAdChoicesContent();
        return adChoicesContent == null ? null : zzd.zzA(adChoicesContent);
    }

    public void zzl(IObjectWrapper iObjectWrapper) {
        this.zzLH.handleClick((View) zzd.zzF(iObjectWrapper));
    }

    public void zzm(IObjectWrapper iObjectWrapper) {
        this.zzLH.trackView((View) zzd.zzF(iObjectWrapper));
    }

    public void zzn(IObjectWrapper iObjectWrapper) {
        this.zzLH.untrackView((View) zzd.zzF(iObjectWrapper));
    }
}
