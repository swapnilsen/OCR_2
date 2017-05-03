package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzru extends zzf<zzru> {
    private String zzado;
    private int zzadp;
    private int zzadq;
    private String zzadr;
    private String zzads;
    private boolean zzadt;
    private boolean zzadu;

    public zzru() {
        this(false);
    }

    public zzru(boolean z) {
        this(z, zznA());
    }

    public zzru(boolean z, int i) {
        zzac.zzcX(i);
        this.zzadp = i;
        this.zzadu = z;
    }

    static int zznA() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public void setScreenName(String str) {
        this.zzado = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.zzado);
        hashMap.put("interstitial", Boolean.valueOf(this.zzadt));
        hashMap.put("automatic", Boolean.valueOf(this.zzadu));
        hashMap.put("screenId", Integer.valueOf(this.zzadp));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzadq));
        hashMap.put("referrerScreenName", this.zzadr);
        hashMap.put("referrerUri", this.zzads);
        return zzf.zzj(hashMap);
    }

    public void zzU(boolean z) {
        this.zzadu = z;
    }

    public void zzV(boolean z) {
        this.zzadt = z;
    }

    public void zza(zzru com_google_android_gms_internal_zzru) {
        if (!TextUtils.isEmpty(this.zzado)) {
            com_google_android_gms_internal_zzru.setScreenName(this.zzado);
        }
        if (this.zzadp != 0) {
            com_google_android_gms_internal_zzru.zzaF(this.zzadp);
        }
        if (this.zzadq != 0) {
            com_google_android_gms_internal_zzru.zzaG(this.zzadq);
        }
        if (!TextUtils.isEmpty(this.zzadr)) {
            com_google_android_gms_internal_zzru.zzbH(this.zzadr);
        }
        if (!TextUtils.isEmpty(this.zzads)) {
            com_google_android_gms_internal_zzru.zzbI(this.zzads);
        }
        if (this.zzadt) {
            com_google_android_gms_internal_zzru.zzV(this.zzadt);
        }
        if (this.zzadu) {
            com_google_android_gms_internal_zzru.zzU(this.zzadu);
        }
    }

    public void zzaF(int i) {
        this.zzadp = i;
    }

    public void zzaG(int i) {
        this.zzadq = i;
    }

    public /* synthetic */ void zzb(zzf com_google_android_gms_analytics_zzf) {
        zza((zzru) com_google_android_gms_analytics_zzf);
    }

    public void zzbH(String str) {
        this.zzadr = str;
    }

    public void zzbI(String str) {
        if (TextUtils.isEmpty(str)) {
            this.zzads = null;
        } else {
            this.zzads = str;
        }
    }

    public String zznB() {
        return this.zzado;
    }

    public int zznC() {
        return this.zzadp;
    }

    public String zznD() {
        return this.zzads;
    }
}
