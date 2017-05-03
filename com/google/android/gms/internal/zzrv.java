package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrv extends zzf<zzrv> {
    public String zzadb;
    public String zzadv;
    public String zzadw;

    public String getAction() {
        return this.zzadb;
    }

    public String getTarget() {
        return this.zzadw;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.zzadv);
        hashMap.put("action", this.zzadb);
        hashMap.put("target", this.zzadw);
        return zzf.zzj(hashMap);
    }

    public void zza(zzrv com_google_android_gms_internal_zzrv) {
        if (!TextUtils.isEmpty(this.zzadv)) {
            com_google_android_gms_internal_zzrv.zzbJ(this.zzadv);
        }
        if (!TextUtils.isEmpty(this.zzadb)) {
            com_google_android_gms_internal_zzrv.zzbC(this.zzadb);
        }
        if (!TextUtils.isEmpty(this.zzadw)) {
            com_google_android_gms_internal_zzrv.zzbK(this.zzadw);
        }
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrv) com_google_android_gms_analytics_zzf);
    }

    public void zzbC(String str) {
        this.zzadb = str;
    }

    public void zzbJ(String str) {
        this.zzadv = str;
    }

    public void zzbK(String str) {
        this.zzadw = str;
    }

    public String zznE() {
        return this.zzadv;
    }
}
