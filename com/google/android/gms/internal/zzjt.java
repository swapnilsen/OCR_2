package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzkc.zza;

@zzme
public final class zzjt extends zza {
    private zzjv.zza zzKU;
    private zzjs zzKV;
    private final Object zzrJ;

    public zzjt() {
        this.zzrJ = new Object();
    }

    public void onAdClicked() {
        synchronized (this.zzrJ) {
            if (this.zzKV != null) {
                this.zzKV.zzbP();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.zzrJ) {
            if (this.zzKV != null) {
                this.zzKV.zzbQ();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.zzrJ) {
            if (this.zzKU != null) {
                this.zzKU.zzF(i == 3 ? 1 : 2);
                this.zzKU = null;
            }
        }
    }

    public void onAdImpression() {
        synchronized (this.zzrJ) {
            if (this.zzKV != null) {
                this.zzKV.zzbU();
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.zzrJ) {
            if (this.zzKV != null) {
                this.zzKV.zzbR();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.zzrJ) {
            if (this.zzKU != null) {
                this.zzKU.zzF(0);
                this.zzKU = null;
                return;
            }
            if (this.zzKV != null) {
                this.zzKV.zzbT();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.zzrJ) {
            if (this.zzKV != null) {
                this.zzKV.zzbS();
            }
        }
    }

    public void zza(@Nullable zzjs com_google_android_gms_internal_zzjs) {
        synchronized (this.zzrJ) {
            this.zzKV = com_google_android_gms_internal_zzjs;
        }
    }

    public void zza(zzjv.zza com_google_android_gms_internal_zzjv_zza) {
        synchronized (this.zzrJ) {
            this.zzKU = com_google_android_gms_internal_zzjv_zza;
        }
    }

    public void zza(zzkd com_google_android_gms_internal_zzkd) {
        synchronized (this.zzrJ) {
            if (this.zzKU != null) {
                this.zzKU.zza(0, com_google_android_gms_internal_zzkd);
                this.zzKU = null;
                return;
            }
            if (this.zzKV != null) {
                this.zzKV.zzbT();
            }
        }
    }
}
