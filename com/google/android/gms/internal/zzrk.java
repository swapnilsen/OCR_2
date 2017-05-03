package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrk extends zzf<zzrk> {
    private String mAppId;
    private String zzacL;
    private String zzacM;
    private String zzacN;

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setAppInstallerId(String str) {
        this.zzacN = str;
    }

    public void setAppName(String str) {
        this.zzacL = str;
    }

    public void setAppVersion(String str) {
        this.zzacM = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.zzacL);
        hashMap.put("appVersion", this.zzacM);
        hashMap.put("appId", this.mAppId);
        hashMap.put("appInstallerId", this.zzacN);
        return zzf.zzj(hashMap);
    }

    public void zza(zzrk com_google_android_gms_internal_zzrk) {
        if (!TextUtils.isEmpty(this.zzacL)) {
            com_google_android_gms_internal_zzrk.setAppName(this.zzacL);
        }
        if (!TextUtils.isEmpty(this.zzacM)) {
            com_google_android_gms_internal_zzrk.setAppVersion(this.zzacM);
        }
        if (!TextUtils.isEmpty(this.mAppId)) {
            com_google_android_gms_internal_zzrk.setAppId(this.mAppId);
        }
        if (!TextUtils.isEmpty(this.zzacN)) {
            com_google_android_gms_internal_zzrk.setAppInstallerId(this.zzacN);
        }
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrk) com_google_android_gms_analytics_zzf);
    }

    public String zzke() {
        return this.mAppId;
    }

    public String zzmY() {
        return this.zzacL;
    }

    public String zzmZ() {
        return this.zzacM;
    }

    public String zzna() {
        return this.zzacN;
    }
}
