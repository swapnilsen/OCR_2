package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzm;

@zzme
public class zziw {
    private final Context mContext;
    private final zze zzsv;
    private final zzka zzsz;
    private final zzqh zztt;

    zziw(Context context, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this.mContext = context;
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zzsv = com_google_android_gms_ads_internal_zze;
    }

    public Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public zzm zzag(String str) {
        return new zzm(this.mContext, new zzeg(), str, this.zzsz, this.zztt, this.zzsv);
    }

    public zzm zzah(String str) {
        return new zzm(this.mContext.getApplicationContext(), new zzeg(), str, this.zzsz, this.zztt, this.zzsv);
    }

    public zziw zzgu() {
        return new zziw(getApplicationContext(), this.zzsz, this.zztt, this.zzsv);
    }
}
