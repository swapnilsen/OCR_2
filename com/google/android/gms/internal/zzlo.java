package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzqx.zza;
import java.util.concurrent.atomic.AtomicBoolean;

@zzme
public abstract class zzlo implements zzpq<Void>, zza {
    protected final Context mContext;
    protected final zzqw zzIs;
    protected final zzlq.zza zzPQ;
    protected final zzpb.zza zzPR;
    protected zzmn zzPS;
    private Runnable zzPT;
    protected final Object zzPU;
    private AtomicBoolean zzPV;

    /* renamed from: com.google.android.gms.internal.zzlo.1 */
    class C12911 implements Runnable {
        final /* synthetic */ zzlo zzPW;

        C12911(zzlo com_google_android_gms_internal_zzlo) {
            this.zzPW = com_google_android_gms_internal_zzlo;
        }

        public void run() {
            if (this.zzPW.zzPV.get()) {
                zzqf.m4708e("Timed out waiting for WebView to finish loading.");
                this.zzPW.cancel();
            }
        }
    }

    protected zzlo(Context context, zzpb.zza com_google_android_gms_internal_zzpb_zza, zzqw com_google_android_gms_internal_zzqw, zzlq.zza com_google_android_gms_internal_zzlq_zza) {
        this.zzPU = new Object();
        this.zzPV = new AtomicBoolean(true);
        this.mContext = context;
        this.zzPR = com_google_android_gms_internal_zzpb_zza;
        this.zzPS = this.zzPR.zzWm;
        this.zzIs = com_google_android_gms_internal_zzqw;
        this.zzPQ = com_google_android_gms_internal_zzlq_zza;
    }

    private zzpb zzR(int i) {
        zzmk com_google_android_gms_internal_zzmk = this.zzPR.zzTi;
        return new zzpb(com_google_android_gms_internal_zzmk.zzRy, this.zzIs, this.zzPS.zzKF, i, this.zzPS.zzKG, this.zzPS.zzSp, this.zzPS.orientation, this.zzPS.zzKL, com_google_android_gms_internal_zzmk.zzRB, this.zzPS.zzSn, null, null, null, null, null, this.zzPS.zzSo, this.zzPR.zzvr, this.zzPS.zzSm, this.zzPR.zzWg, this.zzPS.zzSr, this.zzPS.zzSs, this.zzPR.zzWa, null, this.zzPS.zzSC, this.zzPS.zzSD, this.zzPS.zzSE, this.zzPS.zzSF, this.zzPS.zzSG, null, this.zzPS.zzKI, this.zzPS.zzSJ);
    }

    public void cancel() {
        if (this.zzPV.getAndSet(false)) {
            this.zzIs.stopLoading();
            zzw.zzcO().zzl(this.zzIs);
            zzQ(-1);
            zzpo.zzXC.removeCallbacks(this.zzPT);
        }
    }

    protected void zzQ(int i) {
        if (i != -2) {
            this.zzPS = new zzmn(i, this.zzPS.zzKL);
        }
        this.zzIs.zzlq();
        this.zzPQ.zzb(zzR(i));
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, boolean z) {
        int i = 0;
        zzqf.zzbf("WebView finished loading.");
        if (this.zzPV.getAndSet(false)) {
            if (z) {
                i = -2;
            }
            zzQ(i);
            zzpo.zzXC.removeCallbacks(this.zzPT);
        }
    }

    public final Void zziN() {
        zzac.zzdj("Webview render task needs to be called on UI thread.");
        this.zzPT = new C12911(this);
        zzpo.zzXC.postDelayed(this.zzPT, ((Long) zzgd.zzDM.get()).longValue());
        zziO();
        return null;
    }

    protected abstract void zziO();

    public /* synthetic */ Object zziP() {
        return zziN();
    }
}
