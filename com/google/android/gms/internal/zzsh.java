package com.google.android.gms.internal;

public class zzsh extends zzsa {
    private final zzrk zzacl;

    zzsh(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
        this.zzacl = new zzrk();
    }

    protected void zzmS() {
        zznU().zzmP().zza(this.zzacl);
        zzmw();
    }

    public void zzmw() {
        zztn zzmB = zzmB();
        String zzmY = zzmB.zzmY();
        if (zzmY != null) {
            this.zzacl.setAppName(zzmY);
        }
        String zzmZ = zzmB.zzmZ();
        if (zzmZ != null) {
            this.zzacl.setAppVersion(zzmZ);
        }
    }

    public zzrk zzoy() {
        zzob();
        return this.zzacl;
    }
}
