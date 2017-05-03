package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.LinkedList;

@zzme
class zzjb {
    private final LinkedList<zza> zzJd;
    private zzec zzJe;
    private final int zzJf;
    private boolean zzJg;
    private final String zzts;

    class zza {
        zzm zzJh;
        @Nullable
        zzec zzJi;
        zzix zzJj;
        long zzJk;
        boolean zzJl;
        boolean zzJm;
        final /* synthetic */ zzjb zzJn;

        zza(zzjb com_google_android_gms_internal_zzjb, zziw com_google_android_gms_internal_zziw) {
            this.zzJn = com_google_android_gms_internal_zzjb;
            this.zzJh = com_google_android_gms_internal_zziw.zzah(com_google_android_gms_internal_zzjb.zzts);
            this.zzJj = new zzix();
            this.zzJj.zzc(this.zzJh);
        }

        zza(zzjb com_google_android_gms_internal_zzjb, zziw com_google_android_gms_internal_zziw, zzec com_google_android_gms_internal_zzec) {
            this(com_google_android_gms_internal_zzjb, com_google_android_gms_internal_zziw);
            this.zzJi = com_google_android_gms_internal_zzec;
        }

        boolean load() {
            if (this.zzJl) {
                return false;
            }
            this.zzJm = this.zzJh.zzb(zziz.zzk(this.zzJi != null ? this.zzJi : this.zzJn.zzJe));
            this.zzJl = true;
            this.zzJk = zzw.zzcS().currentTimeMillis();
            return true;
        }
    }

    zzjb(zzec com_google_android_gms_internal_zzec, String str, int i) {
        zzac.zzw(com_google_android_gms_internal_zzec);
        zzac.zzw(str);
        this.zzJd = new LinkedList();
        this.zzJe = com_google_android_gms_internal_zzec;
        this.zzts = str;
        this.zzJf = i;
    }

    String getAdUnitId() {
        return this.zzts;
    }

    int getNetworkType() {
        return this.zzJf;
    }

    int size() {
        return this.zzJd.size();
    }

    void zza(zziw com_google_android_gms_internal_zziw, zzec com_google_android_gms_internal_zzec) {
        this.zzJd.add(new zza(this, com_google_android_gms_internal_zziw, com_google_android_gms_internal_zzec));
    }

    boolean zzb(zziw com_google_android_gms_internal_zziw) {
        zza com_google_android_gms_internal_zzjb_zza = new zza(this, com_google_android_gms_internal_zziw);
        this.zzJd.add(com_google_android_gms_internal_zzjb_zza);
        return com_google_android_gms_internal_zzjb_zza.load();
    }

    void zzgA() {
        this.zzJg = true;
    }

    boolean zzgB() {
        return this.zzJg;
    }

    zzec zzgx() {
        return this.zzJe;
    }

    int zzgy() {
        Iterator it = this.zzJd.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((zza) it.next()).zzJl ? i + 1 : i;
        }
        return i;
    }

    int zzgz() {
        Iterator it = this.zzJd.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((zza) it.next()).load() ? i + 1 : i;
        }
        return i;
    }

    zza zzo(@Nullable zzec com_google_android_gms_internal_zzec) {
        if (com_google_android_gms_internal_zzec != null) {
            this.zzJe = com_google_android_gms_internal_zzec;
        }
        return (zza) this.zzJd.remove();
    }
}
