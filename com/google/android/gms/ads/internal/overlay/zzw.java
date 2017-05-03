package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpo;
import java.util.concurrent.TimeUnit;

@zzme
@TargetApi(14)
public class zzw {
    private final long zzOk;
    private long zzOl;
    private boolean zzOm;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzw.1 */
    class C09231 implements Runnable {
        final /* synthetic */ zzi zzOn;

        C09231(zzw com_google_android_gms_ads_internal_overlay_zzw, zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.zzOn = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            this.zzOn.zzhY();
        }
    }

    zzw() {
        this.zzOk = TimeUnit.MILLISECONDS.toNanos(((Long) zzgd.zzBH.get()).longValue());
        this.zzOm = true;
    }

    public void zza(SurfaceTexture surfaceTexture, zzi com_google_android_gms_ads_internal_overlay_zzi) {
        if (com_google_android_gms_ads_internal_overlay_zzi != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzOm || Math.abs(timestamp - this.zzOl) >= this.zzOk) {
                this.zzOm = false;
                this.zzOl = timestamp;
                zzpo.zzXC.post(new C09231(this, com_google_android_gms_ads_internal_overlay_zzi));
            }
        }
    }

    public void zzhV() {
        this.zzOm = true;
    }
}
