package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamite.DynamiteModule;

public class zzbnq {
    private static zzbnq zzbZm;
    private DynamiteModule zzbZl;

    public static class zza extends Exception {
        private zza(Throwable th) {
            super(th);
        }
    }

    private zzbnq() {
    }

    public static zzbnq zzWD() {
        zzbnq com_google_android_gms_internal_zzbnq;
        synchronized (zzbnq.class) {
            if (zzbZm != null) {
                com_google_android_gms_internal_zzbnq = zzbZm;
            } else {
                zzbZm = new zzbnq();
                com_google_android_gms_internal_zzbnq = zzbZm;
            }
        }
        return com_google_android_gms_internal_zzbnq;
    }

    public zzbnp zzWE() {
        zzac.zzw(this.zzbZl);
        try {
            return com.google.android.gms.internal.zzbnp.zza.zzfM(this.zzbZl.zzdT("com.google.firebase.crash.internal.api.FirebaseCrashApiImpl"));
        } catch (Throwable e) {
            throw new zza(null);
        }
    }

    public void zzaG(Context context) {
        synchronized (zzbnq.class) {
            if (this.zzbZl != null) {
                return;
            }
            try {
                this.zzbZl = DynamiteModule.zza(context, DynamiteModule.zzaRW, "com.google.android.gms.crash");
            } catch (Throwable e) {
                throw new zza(null);
            }
        }
    }
}
