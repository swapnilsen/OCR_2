package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzca implements Callable {
    protected final String TAG;
    protected final String className;
    protected final zzbd zzpz;
    protected final zza zzqV;
    protected final String zzrc;
    protected Method zzre;
    protected final int zzri;
    protected final int zzrj;

    public zzca(zzbd com_google_android_gms_internal_zzbd, String str, String str2, zza com_google_android_gms_internal_zzag_zza, int i, int i2) {
        this.TAG = getClass().getSimpleName();
        this.zzpz = com_google_android_gms_internal_zzbd;
        this.className = str;
        this.zzrc = str2;
        this.zzqV = com_google_android_gms_internal_zzag_zza;
        this.zzri = i;
        this.zzrj = i2;
    }

    public /* synthetic */ Object call() {
        return zzbk();
    }

    protected abstract void zzbd();

    public Void zzbk() {
        try {
            long nanoTime = System.nanoTime();
            this.zzre = this.zzpz.zzc(this.className, this.zzrc);
            if (this.zzre != null) {
                zzbd();
                zzaq zzaP = this.zzpz.zzaP();
                if (!(zzaP == null || this.zzri == RtlSpacingHelper.UNDEFINED)) {
                    zzaP.zza(this.zzrj, this.zzri, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }
}
