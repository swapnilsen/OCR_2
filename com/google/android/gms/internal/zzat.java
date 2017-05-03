package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.zzag.zza;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzat extends zzau {
    private static final String TAG;
    private Info zzpR;

    static {
        TAG = zzat.class.getSimpleName();
    }

    protected zzat(Context context) {
        super(context, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }

    public static zzat zzc(Context context) {
        zzau.zza(context, true);
        return new zzat(context);
    }

    protected zza zza(Context context, View view) {
        return null;
    }

    public String zza(String str, String str2) {
        return zzao.zza(str, str2, true);
    }

    public void zza(Info info) {
        this.zzpR = info;
    }

    protected void zza(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza, zzae.zza com_google_android_gms_internal_zzae_zza) {
        if (!com_google_android_gms_internal_zzbd.zzaN()) {
            zza(zzb(com_google_android_gms_internal_zzbd, com_google_android_gms_internal_zzag_zza, com_google_android_gms_internal_zzae_zza));
        } else if (this.zzpR != null) {
            Object id = this.zzpR.getId();
            if (!TextUtils.isEmpty(id)) {
                com_google_android_gms_internal_zzag_zza.zzbW = zzbf.zzr(id);
                com_google_android_gms_internal_zzag_zza.zzbX = Integer.valueOf(5);
                com_google_android_gms_internal_zzag_zza.zzbY = Boolean.valueOf(this.zzpR.isLimitAdTrackingEnabled());
            }
            this.zzpR = null;
        }
    }

    protected List<Callable<Void>> zzb(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza, zzae.zza com_google_android_gms_internal_zzae_zza) {
        List<Callable<Void>> arrayList = new ArrayList();
        if (com_google_android_gms_internal_zzbd.zzaI() == null) {
            return arrayList;
        }
        zzbd com_google_android_gms_internal_zzbd2 = com_google_android_gms_internal_zzbd;
        arrayList.add(new zzbo(com_google_android_gms_internal_zzbd2, zzaz.zzai(), zzaz.zzaj(), com_google_android_gms_internal_zzag_zza, com_google_android_gms_internal_zzbd.zzQ(), 24));
        return arrayList;
    }
}
