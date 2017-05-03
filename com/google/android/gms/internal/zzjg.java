package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import java.util.concurrent.Future;

@zzme
public class zzjg {

    /* renamed from: com.google.android.gms.internal.zzjg.1 */
    class C12411 implements Runnable {
        final /* synthetic */ zze zzJA;
        final /* synthetic */ String zzJB;
        final /* synthetic */ zzjg zzJC;
        final /* synthetic */ zzqh zzJx;
        final /* synthetic */ zza zzJy;
        final /* synthetic */ zzaw zzJz;
        final /* synthetic */ Context zztf;

        C12411(zzjg com_google_android_gms_internal_zzjg, Context context, zzqh com_google_android_gms_internal_zzqh, zza com_google_android_gms_internal_zzjg_zza, zzaw com_google_android_gms_internal_zzaw, zze com_google_android_gms_ads_internal_zze, String str) {
            this.zzJC = com_google_android_gms_internal_zzjg;
            this.zztf = context;
            this.zzJx = com_google_android_gms_internal_zzqh;
            this.zzJy = com_google_android_gms_internal_zzjg_zza;
            this.zzJz = com_google_android_gms_internal_zzaw;
            this.zzJA = com_google_android_gms_ads_internal_zze;
            this.zzJB = str;
        }

        public void run() {
            this.zzJC.zza(this.zztf, this.zzJx, this.zzJy, this.zzJz, this.zzJA).zzan(this.zzJB);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjg.2 */
    class C12422 implements com.google.android.gms.internal.zzjf.zza {
        final /* synthetic */ zza zzJy;

        C12422(zzjg com_google_android_gms_internal_zzjg, zza com_google_android_gms_internal_zzjg_zza) {
            this.zzJy = com_google_android_gms_internal_zzjg_zza;
        }

        public void zzgN() {
            this.zzJy.zzh((zzjf) this.zzJy.zzJD);
        }
    }

    private static class zza<JavascriptEngine> extends zzqj<JavascriptEngine> {
        JavascriptEngine zzJD;

        private zza() {
        }
    }

    private zzjf zza(Context context, zzqh com_google_android_gms_internal_zzqh, zza<zzjf> com_google_android_gms_internal_zzjg_zza_com_google_android_gms_internal_zzjf, zzaw com_google_android_gms_internal_zzaw, zze com_google_android_gms_ads_internal_zze) {
        zzjf com_google_android_gms_internal_zzjh = new zzjh(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzaw, com_google_android_gms_ads_internal_zze);
        com_google_android_gms_internal_zzjg_zza_com_google_android_gms_internal_zzjf.zzJD = com_google_android_gms_internal_zzjh;
        com_google_android_gms_internal_zzjh.zza(new C12422(this, com_google_android_gms_internal_zzjg_zza_com_google_android_gms_internal_zzjf));
        return com_google_android_gms_internal_zzjh;
    }

    public Future<zzjf> zza(Context context, zzqh com_google_android_gms_internal_zzqh, String str, zzaw com_google_android_gms_internal_zzaw, zze com_google_android_gms_ads_internal_zze) {
        Future com_google_android_gms_internal_zzjg_zza = new zza();
        zzpo.zzXC.post(new C12411(this, context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzjg_zza, com_google_android_gms_internal_zzaw, com_google_android_gms_ads_internal_zze, str));
        return com_google_android_gms_internal_zzjg_zza;
    }
}
