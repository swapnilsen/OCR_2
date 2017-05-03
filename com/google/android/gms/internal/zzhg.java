package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;

@zzme
public class zzhg extends Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzGo;
    private final zzhf zzHq;

    public zzhg(zzhf com_google_android_gms_internal_zzhf) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.zzHq = com_google_android_gms_internal_zzhf;
        try {
            IObjectWrapper zzfP = this.zzHq.zzfP();
            if (zzfP != null) {
                drawable = (Drawable) zzd.zzF(zzfP);
                this.mDrawable = drawable;
                uri = this.zzHq.getUri();
                this.mUri = uri;
                d = 1.0d;
                d = this.zzHq.getScale();
                this.zzGo = d;
            }
        } catch (Throwable e) {
            zzqf.zzb("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.mDrawable = drawable;
        try {
            uri = this.zzHq.getUri();
        } catch (Throwable e2) {
            zzqf.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
        d = 1.0d;
        try {
            d = this.zzHq.getScale();
        } catch (Throwable e3) {
            zzqf.zzb("Failed to get scale.", e3);
        }
        this.zzGo = d;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public double getScale() {
        return this.zzGo;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
