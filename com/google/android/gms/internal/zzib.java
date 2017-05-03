package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Map;

@zzme
public final class zzib implements zzid {
    private void zzc(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        String str = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_LABEL);
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzqf.zzbh("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            zzqf.zzbh("No timestamp given for CSI tick.");
        } else {
            try {
                long zzd = zzd(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                com_google_android_gms_internal_zzqw.zzlF().zza(str, str2, zzd);
            } catch (Throwable e) {
                zzqf.zzc("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private long zzd(long j) {
        return (j - zzw.zzcS().currentTimeMillis()) + zzw.zzcS().elapsedRealtime();
    }

    private void zzd(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        String str = (String) map.get(Param.VALUE);
        if (TextUtils.isEmpty(str)) {
            zzqf.zzbh("No value given for CSI experiment.");
            return;
        }
        zzgl zzfA = com_google_android_gms_internal_zzqw.zzlF().zzfA();
        if (zzfA == null) {
            zzqf.zzbh("No ticker for WebView, dropping experiment ID.");
        } else {
            zzfA.zzh("e", str);
        }
    }

    private void zze(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get(Param.VALUE);
        if (TextUtils.isEmpty(str2)) {
            zzqf.zzbh("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            zzqf.zzbh("No name given for CSI extra.");
        } else {
            zzgl zzfA = com_google_android_gms_internal_zzqw.zzlF().zzfA();
            if (zzfA == null) {
                zzqf.zzbh("No ticker for WebView, dropping extra parameter.");
            } else {
                zzfA.zzh(str, str2);
            }
        }
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            zzc(com_google_android_gms_internal_zzqw, map);
        } else if ("experiment".equals(str)) {
            zzd(com_google_android_gms_internal_zzqw, map);
        } else if ("extra".equals(str)) {
            zze(com_google_android_gms_internal_zzqw, map);
        }
    }
}
