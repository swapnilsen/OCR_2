package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzag.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzav extends zzau {
    private static final String TAG;

    static {
        TAG = zzav.class.getSimpleName();
    }

    protected zzav(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzav zza(String str, Context context, boolean z) {
        zzau.zza(context, z);
        return new zzav(context, str, z);
    }

    protected List<Callable<Void>> zzb(zzbd com_google_android_gms_internal_zzbd, zza com_google_android_gms_internal_zzag_zza, zzae.zza com_google_android_gms_internal_zzae_zza) {
        if (com_google_android_gms_internal_zzbd.zzaI() == null || !this.zzpU) {
            return super.zzb(com_google_android_gms_internal_zzbd, com_google_android_gms_internal_zzag_zza, com_google_android_gms_internal_zzae_zza);
        }
        int zzQ = com_google_android_gms_internal_zzbd.zzQ();
        List<Callable<Void>> arrayList = new ArrayList();
        arrayList.addAll(super.zzb(com_google_android_gms_internal_zzbd, com_google_android_gms_internal_zzag_zza, com_google_android_gms_internal_zzae_zza));
        arrayList.add(new zzbo(com_google_android_gms_internal_zzbd, zzaz.zzai(), zzaz.zzaj(), com_google_android_gms_internal_zzag_zza, zzQ, 24));
        return arrayList;
    }
}
