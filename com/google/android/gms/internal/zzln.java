package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzli.zza;

@zzme
public final class zzln extends zza {
    private final PlayStorePurchaseListener zzAr;

    public zzln(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzAr = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String str) {
        return this.zzAr.isValidPurchase(str);
    }

    public void zza(zzlh com_google_android_gms_internal_zzlh) {
        this.zzAr.onInAppPurchaseFinished(new zzll(com_google_android_gms_internal_zzlh));
    }
}
