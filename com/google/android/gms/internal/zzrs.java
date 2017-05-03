package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.Map;

public final class zzrs extends zzf<zzrs> {
    public String zzade;
    public boolean zzadf;

    public String getDescription() {
        return this.zzade;
    }

    public void setDescription(String str) {
        this.zzade = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzade);
        hashMap.put("fatal", Boolean.valueOf(this.zzadf));
        return zzf.zzj(hashMap);
    }

    public void zzR(boolean z) {
        this.zzadf = z;
    }

    public void zza(zzrs com_google_android_gms_internal_zzrs) {
        if (!TextUtils.isEmpty(this.zzade)) {
            com_google_android_gms_internal_zzrs.setDescription(this.zzade);
        }
        if (this.zzadf) {
            com_google_android_gms_internal_zzrs.zzR(this.zzadf);
        }
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzrs) com_google_android_gms_analytics_zzf);
    }

    public boolean zznt() {
        return this.zzadf;
    }
}
