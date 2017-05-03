package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;

@zzme
public class zziq extends zzpj {
    final zzqw zzIs;
    final zzis zzIw;
    private final String zzIx;

    /* renamed from: com.google.android.gms.internal.zziq.1 */
    class C12131 implements Runnable {
        final /* synthetic */ zziq zzIy;

        C12131(zziq com_google_android_gms_internal_zziq) {
            this.zzIy = com_google_android_gms_internal_zziq;
        }

        public void run() {
            zzw.zzdj().zzb(this.zzIy);
        }
    }

    zziq(zzqw com_google_android_gms_internal_zzqw, zzis com_google_android_gms_internal_zzis, String str) {
        this.zzIs = com_google_android_gms_internal_zzqw;
        this.zzIw = com_google_android_gms_internal_zzis;
        this.zzIx = str;
        zzw.zzdj().zza(this);
    }

    public void onStop() {
        this.zzIw.abort();
    }

    public void zzco() {
        try {
            this.zzIw.zzad(this.zzIx);
        } finally {
            zzpo.zzXC.post(new C12131(this));
        }
    }
}
