package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzj;

@zzme
public final class zzmh {

    public interface zza {
        void zza(zzmn com_google_android_gms_internal_zzmn);
    }

    interface zzb {
        boolean zza(zzqh com_google_android_gms_internal_zzqh);
    }

    /* renamed from: com.google.android.gms.internal.zzmh.1 */
    class C13171 implements zzb {
        final /* synthetic */ Context zztf;

        C13171(Context context) {
            this.zztf = context;
        }

        public boolean zza(zzqh com_google_android_gms_internal_zzqh) {
            return com_google_android_gms_internal_zzqh.zzYY || (zzj.zzbb(this.zztf) && !((Boolean) zzgd.zzBU.get()).booleanValue());
        }
    }

    public static zzpq zza(Context context, zzqh com_google_android_gms_internal_zzqh, zzqp<zzmk> com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, zza com_google_android_gms_internal_zzmh_zza) {
        return zza(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, com_google_android_gms_internal_zzmh_zza, new C13171(context));
    }

    static zzpq zza(Context context, zzqh com_google_android_gms_internal_zzqh, zzqp<zzmk> com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, zza com_google_android_gms_internal_zzmh_zza, zzb com_google_android_gms_internal_zzmh_zzb) {
        return com_google_android_gms_internal_zzmh_zzb.zza(com_google_android_gms_internal_zzqh) ? zza(context, com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, com_google_android_gms_internal_zzmh_zza) : zzb(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, com_google_android_gms_internal_zzmh_zza);
    }

    private static zzpq zza(Context context, zzqp<zzmk> com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, zza com_google_android_gms_internal_zzmh_zza) {
        zzqf.zzbf("Fetching ad response from local ad request service.");
        zzpq com_google_android_gms_internal_zzmi_zza = new com.google.android.gms.internal.zzmi.zza(context, com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, com_google_android_gms_internal_zzmh_zza);
        com_google_android_gms_internal_zzmi_zza.zziP();
        return com_google_android_gms_internal_zzmi_zza;
    }

    private static zzpq zzb(Context context, zzqh com_google_android_gms_internal_zzqh, zzqp<zzmk> com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, zza com_google_android_gms_internal_zzmh_zza) {
        zzqf.zzbf("Fetching ad response from remote ad request service.");
        if (zzel.zzeT().zzaf(context)) {
            return new com.google.android.gms.internal.zzmi.zzb(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, com_google_android_gms_internal_zzmh_zza);
        }
        zzqf.zzbh("Failed to connect to remote ad request service.");
        return null;
    }
}
