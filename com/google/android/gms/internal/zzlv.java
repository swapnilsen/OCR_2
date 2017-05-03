package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.zzlq.zza;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzme
public class zzlv extends zzpj {
    private final zza zzPQ;
    private final zzpb.zza zzPR;
    private final zzmn zzPS;
    private final zzlx zzQi;
    private Future<zzpb> zzQj;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.internal.zzlv.1 */
    class C12961 implements Runnable {
        final /* synthetic */ zzlv zzQk;
        final /* synthetic */ zzpb zzsX;

        C12961(zzlv com_google_android_gms_internal_zzlv, zzpb com_google_android_gms_internal_zzpb) {
            this.zzQk = com_google_android_gms_internal_zzlv;
            this.zzsX = com_google_android_gms_internal_zzpb;
        }

        public void run() {
            this.zzQk.zzPQ.zzb(this.zzsX);
        }
    }

    public zzlv(Context context, zzs com_google_android_gms_ads_internal_zzs, zzpb.zza com_google_android_gms_internal_zzpb_zza, zzaw com_google_android_gms_internal_zzaw, zza com_google_android_gms_internal_zzlq_zza, zzgl com_google_android_gms_internal_zzgl) {
        this(com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzlq_zza, new zzlx(context, com_google_android_gms_ads_internal_zzs, new zzpv(context), com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzpb_zza, com_google_android_gms_internal_zzgl));
    }

    zzlv(zzpb.zza com_google_android_gms_internal_zzpb_zza, zza com_google_android_gms_internal_zzlq_zza, zzlx com_google_android_gms_internal_zzlx) {
        this.zzrJ = new Object();
        this.zzPR = com_google_android_gms_internal_zzpb_zza;
        this.zzPS = com_google_android_gms_internal_zzpb_zza.zzWm;
        this.zzPQ = com_google_android_gms_internal_zzlq_zza;
        this.zzQi = com_google_android_gms_internal_zzlx;
    }

    private zzpb zzS(int i) {
        return new zzpb(this.zzPR.zzTi.zzRy, null, null, i, null, null, this.zzPS.orientation, this.zzPS.zzKL, this.zzPR.zzTi.zzRB, false, null, null, null, null, null, this.zzPS.zzSo, this.zzPR.zzvr, this.zzPS.zzSm, this.zzPR.zzWg, this.zzPS.zzSr, this.zzPS.zzSs, this.zzPR.zzWa, null, null, null, null, this.zzPR.zzWm.zzSF, this.zzPR.zzWm.zzSG, null, null, this.zzPS.zzSJ);
    }

    public void onStop() {
        synchronized (this.zzrJ) {
            if (this.zzQj != null) {
                this.zzQj.cancel(true);
            }
        }
    }

    public void zzco() {
        zzpb com_google_android_gms_internal_zzpb;
        int i;
        try {
            synchronized (this.zzrJ) {
                this.zzQj = zzpn.zza(this.zzQi);
            }
            com_google_android_gms_internal_zzpb = (zzpb) this.zzQj.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzqf.zzbh("Timed out waiting for native ad.");
            this.zzQj.cancel(true);
            i = 2;
            com_google_android_gms_internal_zzpb = null;
        } catch (ExecutionException e2) {
            com_google_android_gms_internal_zzpb = null;
            i = 0;
        } catch (InterruptedException e3) {
            com_google_android_gms_internal_zzpb = null;
            i = 0;
        } catch (CancellationException e4) {
            com_google_android_gms_internal_zzpb = null;
            i = 0;
        }
        if (com_google_android_gms_internal_zzpb == null) {
            com_google_android_gms_internal_zzpb = zzS(i);
        }
        zzpo.zzXC.post(new C12961(this, com_google_android_gms_internal_zzpb));
    }
}
