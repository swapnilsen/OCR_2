package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zzc;
import com.google.android.gms.internal.zzaj.zzd;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzal {
    private static void zza(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaj_zzd) {
        for (zza zze : com_google_android_gms_internal_zzaj_zzd.zzkA) {
            dataLayer.zzha(zzdl.zze(zze));
        }
    }

    public static void zza(DataLayer dataLayer, zzi com_google_android_gms_internal_zzaj_zzi) {
        if (com_google_android_gms_internal_zzaj_zzi.zzlp == null) {
            zzbo.zzbh("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, com_google_android_gms_internal_zzaj_zzi.zzlp);
        zzb(dataLayer, com_google_android_gms_internal_zzaj_zzi.zzlp);
        zzc(dataLayer, com_google_android_gms_internal_zzaj_zzi.zzlp);
    }

    private static void zzb(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaj_zzd) {
        for (zza zzc : com_google_android_gms_internal_zzaj_zzd.zzkz) {
            Map zzc2 = zzc(zzc);
            if (zzc2 != null) {
                dataLayer.push(zzc2);
            }
        }
    }

    private static Map<String, Object> zzc(zza com_google_android_gms_internal_zzak_zza) {
        Object zzj = zzdl.zzj(com_google_android_gms_internal_zzak_zza);
        if (zzj instanceof Map) {
            return (Map) zzj;
        }
        String valueOf = String.valueOf(zzj);
        zzbo.zzbh(new StringBuilder(String.valueOf(valueOf).length() + 36).append("value: ").append(valueOf).append(" is not a map value, ignored.").toString());
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaj_zzd) {
        for (zzc com_google_android_gms_internal_zzaj_zzc : com_google_android_gms_internal_zzaj_zzd.zzkB) {
            if (com_google_android_gms_internal_zzaj_zzc.zzaB == null) {
                zzbo.zzbh("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(com_google_android_gms_internal_zzaj_zzc.zzaB);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = com_google_android_gms_internal_zzaj_zzc.zzkv;
                long j2 = com_google_android_gms_internal_zzaj_zzc.zzkw;
                if (!com_google_android_gms_internal_zzaj_zzc.zzkx || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbo.zzbh("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.zzha(com_google_android_gms_internal_zzaj_zzc.zzaB);
                Map zzo = dataLayer.zzo(com_google_android_gms_internal_zzaj_zzc.zzaB, obj);
                if (com_google_android_gms_internal_zzaj_zzc.zzky > 0) {
                    if (zzo.containsKey("gtm")) {
                        Object obj2 = zzo.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(com_google_android_gms_internal_zzaj_zzc.zzky));
                        } else {
                            zzbo.zzbh("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        zzo.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(com_google_android_gms_internal_zzaj_zzc.zzky)));
                    }
                }
                dataLayer.push(zzo);
            }
        }
    }
}
