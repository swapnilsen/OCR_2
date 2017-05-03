package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrp extends zzf<zzrp> {
    public int zzMy;
    public int zzMz;
    private String zzacX;
    public int zzacY;
    public int zzacZ;
    public int zzada;

    public String getLanguage() {
        return this.zzacX;
    }

    public void setLanguage(String str) {
        this.zzacX = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.zzacX);
        hashMap.put("screenColors", Integer.valueOf(this.zzacY));
        hashMap.put("screenWidth", Integer.valueOf(this.zzMy));
        hashMap.put("screenHeight", Integer.valueOf(this.zzMz));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzacZ));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzada));
        return zzf.zzj(hashMap);
    }

    public void zza(zzrp com_google_android_gms_internal_zzrp) {
        if (this.zzacY != 0) {
            com_google_android_gms_internal_zzrp.zzaA(this.zzacY);
        }
        if (this.zzMy != 0) {
            com_google_android_gms_internal_zzrp.zzaB(this.zzMy);
        }
        if (this.zzMz != 0) {
            com_google_android_gms_internal_zzrp.zzaC(this.zzMz);
        }
        if (this.zzacZ != 0) {
            com_google_android_gms_internal_zzrp.zzaD(this.zzacZ);
        }
        if (this.zzada != 0) {
            com_google_android_gms_internal_zzrp.zzaE(this.zzada);
        }
        if (!TextUtils.isEmpty(this.zzacX)) {
            com_google_android_gms_internal_zzrp.setLanguage(this.zzacX);
        }
    }

    public void zzaA(int i) {
        this.zzacY = i;
    }

    public void zzaB(int i) {
        this.zzMy = i;
    }

    public void zzaC(int i) {
        this.zzMz = i;
    }

    public void zzaD(int i) {
        this.zzacZ = i;
    }

    public void zzaE(int i) {
        this.zzada = i;
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrp) com_google_android_gms_analytics_zzf);
    }

    public int zznk() {
        return this.zzacY;
    }

    public int zznl() {
        return this.zzMy;
    }

    public int zznm() {
        return this.zzMz;
    }

    public int zznn() {
        return this.zzacZ;
    }

    public int zzno() {
        return this.zzada;
    }
}
