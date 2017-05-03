package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer.zza;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhq;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqh;

@zzme
public class zzl extends zza {
    private final Context mContext;
    private final zze zzsv;
    private final zzka zzsz;
    private SimpleArrayMap<String, zzhs> zztA;
    private zzep zztk;
    private zzhc zztp;
    private zzex zztr;
    private final String zzts;
    private final zzqh zztt;
    private zzhp zztx;
    private zzhq zzty;
    private SimpleArrayMap<String, zzhr> zztz;

    public zzl(Context context, String str, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this.mContext = context;
        this.zzts = str;
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zztA = new SimpleArrayMap();
        this.zztz = new SimpleArrayMap();
        this.zzsv = com_google_android_gms_ads_internal_zze;
    }

    public void zza(zzhc com_google_android_gms_internal_zzhc) {
        this.zztp = com_google_android_gms_internal_zzhc;
    }

    public void zza(zzhp com_google_android_gms_internal_zzhp) {
        this.zztx = com_google_android_gms_internal_zzhp;
    }

    public void zza(zzhq com_google_android_gms_internal_zzhq) {
        this.zzty = com_google_android_gms_internal_zzhq;
    }

    public void zza(String str, zzhs com_google_android_gms_internal_zzhs, zzhr com_google_android_gms_internal_zzhr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zztA.put(str, com_google_android_gms_internal_zzhs);
        this.zztz.put(str, com_google_android_gms_internal_zzhr);
    }

    public void zzb(zzep com_google_android_gms_internal_zzep) {
        this.zztk = com_google_android_gms_internal_zzep;
    }

    public void zzb(zzex com_google_android_gms_internal_zzex) {
        this.zztr = com_google_android_gms_internal_zzex;
    }

    public zzeq zzck() {
        return new zzk(this.mContext, this.zzts, this.zzsz, this.zztt, this.zztk, this.zztx, this.zzty, this.zztA, this.zztz, this.zztp, this.zztr, this.zzsv);
    }
}
