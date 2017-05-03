package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae.zza;
import com.google.firebase.messaging.SendException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;

public class zzbk extends zzca {
    private static final Object zzqS;
    private static volatile zzan zzqT;
    private zza zzqU;

    static {
        zzqT = null;
        zzqS = new Object();
    }

    public zzbk(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zzag.zza com_google_android_gms_internal_zzag_zza, int i, int i2, zza com_google_android_gms_internal_zzae_zza) {
        super(com_google_android_gms_internal_zzbd, str, str2, com_google_android_gms_internal_zzag_zza, i, i2);
        this.zzqU = null;
        this.zzqU = com_google_android_gms_internal_zzae_zza;
    }

    public static Boolean zza(zza com_google_android_gms_internal_zzae_zza) {
        boolean z = false;
        if (!zzbf.zzs(zzb(com_google_android_gms_internal_zzae_zza))) {
            return Boolean.valueOf(false);
        }
        if (!(com_google_android_gms_internal_zzae_zza == null || com_google_android_gms_internal_zzae_zza.zzaK == null || com_google_android_gms_internal_zzae_zza.zzaK.zzaM.intValue() != 3)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static String zzb(zza com_google_android_gms_internal_zzae_zza) {
        return (com_google_android_gms_internal_zzae_zza == null || com_google_android_gms_internal_zzae_zza.zzaL == null || zzbf.zzs(com_google_android_gms_internal_zzae_zza.zzaL.zzaN)) ? null : com_google_android_gms_internal_zzae_zza.zzaL.zzaN;
    }

    private boolean zzbe() {
        return zzqT == null || zzbf.zzs(zzqT.zzaN) || zzqT.zzaN.equals("E");
    }

    private int zzbf() {
        return !zzbf.zzs(zzb(this.zzqU)) ? 4 : (zza(this.zzqU).booleanValue() && zzbg()) ? 3 : 2;
    }

    private boolean zzbg() {
        return this.zzpz.zzaQ() && ((Boolean) zzgd.zzDW.get()).booleanValue() && ((Boolean) zzgd.zzDX.get()).booleanValue() && ((Boolean) zzgd.zzDV.get()).booleanValue();
    }

    private String zzbh() {
        try {
            if (this.zzpz.zzaS() != null) {
                this.zzpz.zzaS().get();
            }
            zzag.zza zzaR = this.zzpz.zzaR();
            if (!(zzaR == null || zzaR.zzaN == null)) {
                return zzaR.zzaN;
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
        }
        return null;
    }

    private void zze(int i) {
        boolean z = false;
        Method method = this.zzre;
        Object[] objArr = new Object[2];
        objArr[0] = this.zzpz.getContext();
        if (i == 2) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        zzqT = new zzan((String) method.invoke(null, objArr));
        if (zzbf.zzs(zzqT.zzaN) || zzqT.zzaN.equals("E")) {
            switch (i) {
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    String zzbh = zzbh();
                    if (!zzbf.zzs(zzbh)) {
                        zzqT.zzaN = zzbh;
                    }
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    zzqT.zzaN = this.zzqU.zzaL.zzaN;
                default:
            }
        }
    }

    protected void zzbd() {
        if (zzbe()) {
            synchronized (zzqS) {
                int zzbf = zzbf();
                if (zzbf == 3) {
                    this.zzpz.zzaV();
                }
                zze(zzbf);
            }
        }
        synchronized (this.zzqV) {
            if (zzqT != null) {
                this.zzqV.zzaN = zzqT.zzaN;
                this.zzqV.zzbA = Long.valueOf(zzqT.zzlE);
                this.zzqV.zzaP = zzqT.zzaP;
                this.zzqV.zzaQ = zzqT.zzaQ;
                this.zzqV.zzaR = zzqT.zzaR;
            }
        }
    }
}
