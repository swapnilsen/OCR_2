package com.google.android.gms.internal;

public abstract class zzsa extends zzrz {
    private boolean zzadP;

    protected zzsa(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
    }

    public void initialize() {
        zzmS();
        this.zzadP = true;
    }

    public boolean isInitialized() {
        return this.zzadP;
    }

    protected abstract void zzmS();

    protected void zzob() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
