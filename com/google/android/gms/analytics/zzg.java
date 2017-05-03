package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzg<T extends zzg> {
    private final zzh zzace;
    protected final zze zzacf;
    private final List<Object> zzacg;

    protected zzg(zzh com_google_android_gms_analytics_zzh, zze com_google_android_gms_common_util_zze) {
        zzac.zzw(com_google_android_gms_analytics_zzh);
        this.zzace = com_google_android_gms_analytics_zzh;
        this.zzacg = new ArrayList();
        zze com_google_android_gms_analytics_zze = new zze(this, com_google_android_gms_common_util_zze);
        com_google_android_gms_analytics_zze.zzmM();
        this.zzacf = com_google_android_gms_analytics_zze;
    }

    protected void zza(zze com_google_android_gms_analytics_zze) {
    }

    protected void zzd(zze com_google_android_gms_analytics_zze) {
        Iterator it = this.zzacg.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    protected zzh zzmK() {
        return this.zzace;
    }

    public zze zzmN() {
        return this.zzacf;
    }

    public List<zzi> zzmO() {
        return this.zzacf.zzmE();
    }

    public zze zzmo() {
        zze zzmC = this.zzacf.zzmC();
        zzd(zzmC);
        return zzmC;
    }
}
