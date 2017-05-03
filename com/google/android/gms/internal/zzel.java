package com.google.android.gms.internal;

@zzme
public class zzel {
    private static final Object zztX;
    private static zzel zzzT;
    private final zzqe zzzU;
    private final zzek zzzV;

    static {
        zztX = new Object();
        zza(new zzel());
    }

    protected zzel() {
        this.zzzU = new zzqe();
        this.zzzV = new zzek(new zzeb(), new zzea(), new zzfj(), new zzht(), new zzny(), new zzlk(), new zzky());
    }

    protected static void zza(zzel com_google_android_gms_internal_zzel) {
        synchronized (zztX) {
            zzzT = com_google_android_gms_internal_zzel;
        }
    }

    private static zzel zzeS() {
        zzel com_google_android_gms_internal_zzel;
        synchronized (zztX) {
            com_google_android_gms_internal_zzel = zzzT;
        }
        return com_google_android_gms_internal_zzel;
    }

    public static zzqe zzeT() {
        return zzeS().zzzU;
    }

    public static zzek zzeU() {
        return zzeS().zzzV;
    }
}
