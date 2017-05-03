package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzle.zza;

@zzme
public final class zzlj extends zza {
    private final InAppPurchaseListener zzAp;

    public zzlj(InAppPurchaseListener inAppPurchaseListener) {
        this.zzAp = inAppPurchaseListener;
    }

    public void zza(zzld com_google_android_gms_internal_zzld) {
        this.zzAp.onInAppPurchaseRequested(new zzlm(com_google_android_gms_internal_zzld));
    }
}
