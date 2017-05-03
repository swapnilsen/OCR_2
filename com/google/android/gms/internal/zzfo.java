package com.google.android.gms.internal;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zznu.zza;

public class zzfo extends zza {
    private zznw zzAF;

    /* renamed from: com.google.android.gms.internal.zzfo.1 */
    class C11781 implements Runnable {
        final /* synthetic */ zzfo zzAG;

        C11781(zzfo com_google_android_gms_internal_zzfo) {
            this.zzAG = com_google_android_gms_internal_zzfo;
        }

        public void run() {
            if (this.zzAG.zzAF != null) {
                try {
                    this.zzAG.zzAF.onRewardedVideoAdFailedToLoad(1);
                } catch (Throwable e) {
                    zzqf.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void destroy() {
    }

    public boolean isLoaded() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setUserId(String str) {
    }

    public void show() {
    }

    public void zza(zznw com_google_android_gms_internal_zznw) {
        this.zzAF = com_google_android_gms_internal_zznw;
    }

    public void zza(zzoa com_google_android_gms_internal_zzoa) {
        zzqf.m4708e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzqe.zzYP.post(new C11781(this));
    }

    public void zzf(IObjectWrapper iObjectWrapper) {
    }

    public void zzg(IObjectWrapper iObjectWrapper) {
    }

    public void zzh(IObjectWrapper iObjectWrapper) {
    }
}
