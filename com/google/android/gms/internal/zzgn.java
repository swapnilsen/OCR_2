package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.zzd;

@zzme
public class zzgn implements CustomRenderedAd {
    private final zzgo zzFW;

    public zzgn(zzgo com_google_android_gms_internal_zzgo) {
        this.zzFW = com_google_android_gms_internal_zzgo;
    }

    public String getBaseUrl() {
        try {
            return this.zzFW.zzfG();
        } catch (Throwable e) {
            zzqf.zzc("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzFW.getContent();
        } catch (Throwable e) {
            zzqf.zzc("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzFW.zzi(view != null ? zzd.zzA(view) : null);
        } catch (Throwable e) {
            zzqf.zzc("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzFW.recordClick();
        } catch (Throwable e) {
            zzqf.zzc("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzFW.recordImpression();
        } catch (Throwable e) {
            zzqf.zzc("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
