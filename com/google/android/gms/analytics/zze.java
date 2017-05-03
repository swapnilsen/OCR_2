package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zze {
    private final zzg zzabU;
    private boolean zzabV;
    private long zzabW;
    private long zzabX;
    private long zzabY;
    private long zzabZ;
    private long zzaca;
    private boolean zzacb;
    private final Map<Class<? extends zzf>, zzf> zzacc;
    private final List<zzi> zzacd;
    private final com.google.android.gms.common.util.zze zzuP;

    zze(zze com_google_android_gms_analytics_zze) {
        this.zzabU = com_google_android_gms_analytics_zze.zzabU;
        this.zzuP = com_google_android_gms_analytics_zze.zzuP;
        this.zzabW = com_google_android_gms_analytics_zze.zzabW;
        this.zzabX = com_google_android_gms_analytics_zze.zzabX;
        this.zzabY = com_google_android_gms_analytics_zze.zzabY;
        this.zzabZ = com_google_android_gms_analytics_zze.zzabZ;
        this.zzaca = com_google_android_gms_analytics_zze.zzaca;
        this.zzacd = new ArrayList(com_google_android_gms_analytics_zze.zzacd);
        this.zzacc = new HashMap(com_google_android_gms_analytics_zze.zzacc.size());
        for (Entry entry : com_google_android_gms_analytics_zze.zzacc.entrySet()) {
            zzf zzc = zzc((Class) entry.getKey());
            ((zzf) entry.getValue()).zzb(zzc);
            this.zzacc.put((Class) entry.getKey(), zzc);
        }
    }

    zze(zzg com_google_android_gms_analytics_zzg, com.google.android.gms.common.util.zze com_google_android_gms_common_util_zze) {
        zzac.zzw(com_google_android_gms_analytics_zzg);
        zzac.zzw(com_google_android_gms_common_util_zze);
        this.zzabU = com_google_android_gms_analytics_zzg;
        this.zzuP = com_google_android_gms_common_util_zze;
        this.zzabZ = 1800000;
        this.zzaca = 3024000000L;
        this.zzacc = new HashMap();
        this.zzacd = new ArrayList();
    }

    private static <T extends zzf> T zzc(Class<T> cls) {
        try {
            return (zzf) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public <T extends zzf> T zza(Class<T> cls) {
        return (zzf) this.zzacc.get(cls);
    }

    public void zza(zzf com_google_android_gms_analytics_zzf) {
        zzac.zzw(com_google_android_gms_analytics_zzf);
        Class cls = com_google_android_gms_analytics_zzf.getClass();
        if (cls.getSuperclass() != zzf.class) {
            throw new IllegalArgumentException();
        }
        com_google_android_gms_analytics_zzf.zzb(zzb(cls));
    }

    public <T extends zzf> T zzb(Class<T> cls) {
        zzf com_google_android_gms_analytics_zzf = (zzf) this.zzacc.get(cls);
        if (com_google_android_gms_analytics_zzf != null) {
            return com_google_android_gms_analytics_zzf;
        }
        T zzc = zzc(cls);
        this.zzacc.put(cls, zzc);
        return zzc;
    }

    public zze zzmC() {
        return new zze(this);
    }

    public Collection<zzf> zzmD() {
        return this.zzacc.values();
    }

    public List<zzi> zzmE() {
        return this.zzacd;
    }

    public long zzmF() {
        return this.zzabW;
    }

    public void zzmG() {
        zzmK().zze(this);
    }

    public boolean zzmH() {
        return this.zzabV;
    }

    void zzmI() {
        this.zzabY = this.zzuP.elapsedRealtime();
        if (this.zzabX != 0) {
            this.zzabW = this.zzabX;
        } else {
            this.zzabW = this.zzuP.currentTimeMillis();
        }
        this.zzabV = true;
    }

    zzg zzmJ() {
        return this.zzabU;
    }

    zzh zzmK() {
        return this.zzabU.zzmK();
    }

    boolean zzmL() {
        return this.zzacb;
    }

    void zzmM() {
        this.zzacb = true;
    }

    public void zzq(long j) {
        this.zzabX = j;
    }
}
