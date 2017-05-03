package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.zzt;

@zzme
public class zzlq {

    public interface zza {
        void zzb(zzpb com_google_android_gms_internal_zzpb);
    }

    public zzpq zza(Context context, com.google.android.gms.ads.internal.zza com_google_android_gms_ads_internal_zza, com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzaw com_google_android_gms_internal_zzaw, @Nullable zzqw com_google_android_gms_internal_zzqw, zzka com_google_android_gms_internal_zzka, zza com_google_android_gms_internal_zzlq_zza, zzgl com_google_android_gms_internal_zzgl) {
        zzmn com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzpb_zza.zzWm;
        zzpq com_google_android_gms_internal_zzlu = com_google_android_gms_internal_zzmn.zzSn ? new zzlu(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzka, com_google_android_gms_internal_zzlq_zza, com_google_android_gms_internal_zzgl, com_google_android_gms_internal_zzqw) : (com_google_android_gms_internal_zzmn.zzzB || (com_google_android_gms_ads_internal_zza instanceof zzs)) ? (com_google_android_gms_internal_zzmn.zzzB && (com_google_android_gms_ads_internal_zza instanceof zzs)) ? new zzlv(context, (zzs) com_google_android_gms_ads_internal_zza, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzlq_zza, com_google_android_gms_internal_zzgl) : new zzls(com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzlq_zza) : (((Boolean) zzgd.zzCu.get()).booleanValue() && zzt.zzzl() && !zzt.zzzn() && com_google_android_gms_internal_zzqw != null && com_google_android_gms_internal_zzqw.zzbC().zzzz) ? new zzlt(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzqw, com_google_android_gms_internal_zzlq_zza) : new zzlr(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzqw, com_google_android_gms_internal_zzlq_zza);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(com_google_android_gms_internal_zzlu.getClass().getName());
        zzqf.zzbf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        com_google_android_gms_internal_zzlu.zziP();
        return com_google_android_gms_internal_zzlu;
    }

    public zzpq zza(Context context, com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzns com_google_android_gms_internal_zzns) {
        zzpq com_google_android_gms_internal_zzok = new zzok(context, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzns);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(com_google_android_gms_internal_zzok.getClass().getName());
        zzqf.zzbf(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        com_google_android_gms_internal_zzok.zziP();
        return com_google_android_gms_internal_zzok;
    }
}
