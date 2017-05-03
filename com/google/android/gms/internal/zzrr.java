package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;

public final class zzrr extends zzf<zzrr> {
    private String mCategory;
    private String zzadb;
    private String zzadc;
    private long zzadd;

    public String getAction() {
        return this.zzadb;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getLabel() {
        return this.zzadc;
    }

    public long getValue() {
        return this.zzadd;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.mCategory);
        hashMap.put("action", this.zzadb);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzadc);
        hashMap.put(Param.VALUE, Long.valueOf(this.zzadd));
        return zzf.zzj(hashMap);
    }

    public void zza(zzrr com_google_android_gms_internal_zzrr) {
        if (!TextUtils.isEmpty(this.mCategory)) {
            com_google_android_gms_internal_zzrr.zzbB(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzadb)) {
            com_google_android_gms_internal_zzrr.zzbC(this.zzadb);
        }
        if (!TextUtils.isEmpty(this.zzadc)) {
            com_google_android_gms_internal_zzrr.zzbD(this.zzadc);
        }
        if (this.zzadd != 0) {
            com_google_android_gms_internal_zzrr.zzr(this.zzadd);
        }
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrr) com_google_android_gms_analytics_zzf);
    }

    public void zzbB(String str) {
        this.mCategory = str;
    }

    public void zzbC(String str) {
        this.zzadb = str;
    }

    public void zzbD(String str) {
        this.zzadc = str;
    }

    public void zzr(long j) {
        this.zzadd = j;
    }
}
