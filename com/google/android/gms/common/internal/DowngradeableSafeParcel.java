package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class DowngradeableSafeParcel extends zza implements ReflectedParcelable {
    private static final Object zzaFG;
    private static ClassLoader zzaFH;
    private static Integer zzaFI;
    private boolean zzaFJ;

    static {
        zzaFG = new Object();
        zzaFH = null;
        zzaFI = null;
    }

    public DowngradeableSafeParcel() {
        this.zzaFJ = false;
    }

    protected static boolean zzdl(String str) {
        zzxU();
        return true;
    }

    protected static ClassLoader zzxU() {
        synchronized (zzaFG) {
        }
        return null;
    }

    protected static Integer zzxV() {
        synchronized (zzaFG) {
        }
        return null;
    }
}
