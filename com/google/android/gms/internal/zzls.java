package com.google.android.gms.internal;

import com.google.android.gms.internal.zzlq.zza;

@zzme
public class zzls extends zzpj {
    private final zza zzPQ;
    private final zzpb.zza zzPR;
    private final zzmn zzPS;

    /* renamed from: com.google.android.gms.internal.zzls.1 */
    class C12941 implements Runnable {
        final /* synthetic */ zzpb zzPZ;
        final /* synthetic */ zzls zzQa;

        C12941(zzls com_google_android_gms_internal_zzls, zzpb com_google_android_gms_internal_zzpb) {
            this.zzQa = com_google_android_gms_internal_zzls;
            this.zzPZ = com_google_android_gms_internal_zzpb;
        }

        public void run() {
            this.zzQa.zzPQ.zzb(this.zzPZ);
        }
    }

    public zzls(zzpb.zza com_google_android_gms_internal_zzpb_zza, zza com_google_android_gms_internal_zzlq_zza) {
        this.zzPR = com_google_android_gms_internal_zzpb_zza;
        this.zzPS = this.zzPR.zzWm;
        this.zzPQ = com_google_android_gms_internal_zzlq_zza;
    }

    private zzpb zzS(int i) {
        return new zzpb(this.zzPR.zzTi.zzRy, null, null, i, null, null, this.zzPS.orientation, this.zzPS.zzKL, this.zzPR.zzTi.zzRB, false, null, null, null, null, null, this.zzPS.zzSo, this.zzPR.zzvr, this.zzPS.zzSm, this.zzPR.zzWg, this.zzPS.zzSr, this.zzPS.zzSs, this.zzPR.zzWa, null, null, null, null, this.zzPR.zzWm.zzSF, this.zzPR.zzWm.zzSG, null, null, null);
    }

    public void onStop() {
    }

    public void zzco() {
        zzpo.zzXC.post(new C12941(this, zzS(0)));
    }
}
