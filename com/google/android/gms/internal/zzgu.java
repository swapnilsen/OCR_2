package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzhf.zza;

@zzme
public class zzgu extends zza {
    private final Uri mUri;
    private final Drawable zzGn;
    private final double zzGo;

    public zzgu(Drawable drawable, Uri uri, double d) {
        this.zzGn = drawable;
        this.mUri = uri;
        this.zzGo = d;
    }

    public double getScale() {
        return this.zzGo;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public IObjectWrapper zzfP() {
        return zzd.zzA(this.zzGn);
    }
}
