package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.Map;

public final class zzrw extends zzf<zzrw> {
    public String mCategory;
    public String zzadc;
    public String zzadx;
    public long zzady;

    public String getCategory() {
        return this.mCategory;
    }

    public String getLabel() {
        return this.zzadc;
    }

    public long getTimeInMillis() {
        return this.zzady;
    }

    public void setTimeInMillis(long j) {
        this.zzady = j;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.zzadx);
        hashMap.put("timeInMillis", Long.valueOf(this.zzady));
        hashMap.put("category", this.mCategory);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzadc);
        return zzf.zzj(hashMap);
    }

    public void zza(zzrw com_google_android_gms_internal_zzrw) {
        if (!TextUtils.isEmpty(this.zzadx)) {
            com_google_android_gms_internal_zzrw.zzbL(this.zzadx);
        }
        if (this.zzady != 0) {
            com_google_android_gms_internal_zzrw.setTimeInMillis(this.zzady);
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            com_google_android_gms_internal_zzrw.zzbB(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzadc)) {
            com_google_android_gms_internal_zzrw.zzbD(this.zzadc);
        }
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrw) com_google_android_gms_analytics_zzf);
    }

    public void zzbB(String str) {
        this.mCategory = str;
    }

    public void zzbD(String str) {
        this.zzadc = str;
    }

    public void zzbL(String str) {
        this.zzadx = str;
    }

    public String zznF() {
        return this.zzadx;
    }
}
