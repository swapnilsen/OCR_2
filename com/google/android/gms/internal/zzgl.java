package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzme
public class zzgl {
    private final List<zzgj> zzFO;
    private final Map<String, String> zzFP;
    private String zzFQ;
    private zzgj zzFR;
    @Nullable
    private zzgl zzFS;
    boolean zzFx;
    private final Object zzrJ;

    public zzgl(boolean z, String str, String str2) {
        this.zzFO = new LinkedList();
        this.zzFP = new LinkedHashMap();
        this.zzrJ = new Object();
        this.zzFx = z;
        this.zzFP.put("action", str);
        this.zzFP.put("ad_format", str2);
    }

    public void zzX(String str) {
        if (this.zzFx) {
            synchronized (this.zzrJ) {
                this.zzFQ = str;
            }
        }
    }

    public boolean zza(zzgj com_google_android_gms_internal_zzgj, long j, String... strArr) {
        synchronized (this.zzrJ) {
            for (String com_google_android_gms_internal_zzgj2 : strArr) {
                this.zzFO.add(new zzgj(j, com_google_android_gms_internal_zzgj2, com_google_android_gms_internal_zzgj));
            }
        }
        return true;
    }

    public boolean zza(@Nullable zzgj com_google_android_gms_internal_zzgj, String... strArr) {
        return (!this.zzFx || com_google_android_gms_internal_zzgj == null) ? false : zza(com_google_android_gms_internal_zzgj, zzw.zzcS().elapsedRealtime(), strArr);
    }

    @Nullable
    public zzgj zzc(long j) {
        return !this.zzFx ? null : new zzgj(j, null, null);
    }

    public void zzc(@Nullable zzgl com_google_android_gms_internal_zzgl) {
        synchronized (this.zzrJ) {
            this.zzFS = com_google_android_gms_internal_zzgl;
        }
    }

    public zzgj zzfB() {
        return zzc(zzw.zzcS().elapsedRealtime());
    }

    public void zzfC() {
        synchronized (this.zzrJ) {
            this.zzFR = zzfB();
        }
    }

    public String zzfD() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.zzrJ) {
            for (zzgj com_google_android_gms_internal_zzgj : this.zzFO) {
                long time = com_google_android_gms_internal_zzgj.getTime();
                String zzfy = com_google_android_gms_internal_zzgj.zzfy();
                zzgj com_google_android_gms_internal_zzgj2 = com_google_android_gms_internal_zzgj2.zzfz();
                if (com_google_android_gms_internal_zzgj2 != null && time > 0) {
                    stringBuilder2.append(zzfy).append('.').append(time - com_google_android_gms_internal_zzgj2.getTime()).append(',');
                }
            }
            this.zzFO.clear();
            if (!TextUtils.isEmpty(this.zzFQ)) {
                stringBuilder2.append(this.zzFQ);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    Map<String, String> zzfE() {
        Map<String, String> map;
        synchronized (this.zzrJ) {
            zzgf zzkk = zzw.zzcQ().zzkk();
            if (zzkk == null || this.zzFS == null) {
                map = this.zzFP;
            } else {
                map = zzkk.zza(this.zzFP, this.zzFS.zzfE());
            }
        }
        return map;
    }

    public zzgj zzfF() {
        zzgj com_google_android_gms_internal_zzgj;
        synchronized (this.zzrJ) {
            com_google_android_gms_internal_zzgj = this.zzFR;
        }
        return com_google_android_gms_internal_zzgj;
    }

    public void zzh(String str, String str2) {
        if (this.zzFx && !TextUtils.isEmpty(str2)) {
            zzgf zzkk = zzw.zzcQ().zzkk();
            if (zzkk != null) {
                synchronized (this.zzrJ) {
                    zzkk.zzV(str).zza(this.zzFP, str, str2);
                }
            }
        }
    }
}
