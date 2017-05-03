package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzme
public class zzll implements InAppPurchaseResult {
    private final zzlh zzPP;

    public zzll(zzlh com_google_android_gms_internal_zzlh) {
        this.zzPP = com_google_android_gms_internal_zzlh;
    }

    public void finishPurchase() {
        try {
            this.zzPP.finishPurchase();
        } catch (Throwable e) {
            zzqf.zzc("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.zzPP.getProductId();
        } catch (Throwable e) {
            zzqf.zzc("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.zzPP.getPurchaseData();
        } catch (Throwable e) {
            zzqf.zzc("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.zzPP.getResultCode();
        } catch (Throwable e) {
            zzqf.zzc("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.zzPP.isVerified();
        } catch (Throwable e) {
            zzqf.zzc("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
