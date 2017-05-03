package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.internal.zzw;
import java.util.concurrent.Callable;

@zzme
public class zzqy {

    /* renamed from: com.google.android.gms.internal.zzqy.1 */
    class C13871 implements Callable<zzqw> {
        final /* synthetic */ zzaw zzJP;
        final /* synthetic */ zzqh zzJx;
        final /* synthetic */ zzeg zzZR;
        final /* synthetic */ boolean zzZS;
        final /* synthetic */ boolean zzZT;
        final /* synthetic */ zzqy zzZU;
        final /* synthetic */ Context zztf;

        C13871(zzqy com_google_android_gms_internal_zzqy, Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, zzaw com_google_android_gms_internal_zzaw, zzqh com_google_android_gms_internal_zzqh) {
            this.zzZU = com_google_android_gms_internal_zzqy;
            this.zztf = context;
            this.zzZR = com_google_android_gms_internal_zzeg;
            this.zzZS = z;
            this.zzZT = z2;
            this.zzJP = com_google_android_gms_internal_zzaw;
            this.zzJx = com_google_android_gms_internal_zzqh;
        }

        public /* synthetic */ Object call() {
            return zzma();
        }

        public zzqw zzma() {
            return this.zzZU.zza(this.zztf, this.zzZR, this.zzZS, this.zzZT, this.zzJP, this.zzJx, null, null, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqy.2 */
    class C13882 implements Callable<zzqw> {
        final /* synthetic */ zze zzJA;
        final /* synthetic */ zzaw zzJP;
        final /* synthetic */ zzqh zzJx;
        final /* synthetic */ boolean zzZS;
        final /* synthetic */ boolean zzZT;
        final /* synthetic */ zzgl zzZV;
        final /* synthetic */ zzu zzZW;
        final /* synthetic */ Context zztf;
        final /* synthetic */ zzeg zzzO;

        C13882(zzqy com_google_android_gms_internal_zzqy, Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, zzaw com_google_android_gms_internal_zzaw, zzqh com_google_android_gms_internal_zzqh, zzgl com_google_android_gms_internal_zzgl, zzu com_google_android_gms_ads_internal_zzu, zze com_google_android_gms_ads_internal_zze) {
            this.zztf = context;
            this.zzzO = com_google_android_gms_internal_zzeg;
            this.zzZS = z;
            this.zzZT = z2;
            this.zzJP = com_google_android_gms_internal_zzaw;
            this.zzJx = com_google_android_gms_internal_zzqh;
            this.zzZV = com_google_android_gms_internal_zzgl;
            this.zzZW = com_google_android_gms_ads_internal_zzu;
            this.zzJA = com_google_android_gms_ads_internal_zze;
        }

        public /* synthetic */ Object call() {
            return zzma();
        }

        public zzqw zzma() {
            zzqw com_google_android_gms_internal_zzqz = new zzqz(zzra.zzb(this.zztf, this.zzzO, this.zzZS, this.zzZT, this.zzJP, this.zzJx, this.zzZV, this.zzZW, this.zzJA));
            com_google_android_gms_internal_zzqz.setWebViewClient(zzw.zzcO().zzb(com_google_android_gms_internal_zzqz, this.zzZT));
            com_google_android_gms_internal_zzqz.setWebChromeClient(zzw.zzcO().zzn(com_google_android_gms_internal_zzqz));
            return com_google_android_gms_internal_zzqz;
        }
    }

    public zzqw zza(Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable zzaw com_google_android_gms_internal_zzaw, zzqh com_google_android_gms_internal_zzqh) {
        return (zzqw) zzqb.zzb(new C13871(this, context, com_google_android_gms_internal_zzeg, z, z2, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzqh));
    }

    public zzqw zza(Context context, zzeg com_google_android_gms_internal_zzeg, boolean z, boolean z2, @Nullable zzaw com_google_android_gms_internal_zzaw, zzqh com_google_android_gms_internal_zzqh, zzgl com_google_android_gms_internal_zzgl, zzu com_google_android_gms_ads_internal_zzu, zze com_google_android_gms_ads_internal_zze) {
        return (zzqw) zzqb.zzb(new C13882(this, context, com_google_android_gms_internal_zzeg, z, z2, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzgl, com_google_android_gms_ads_internal_zzu, com_google_android_gms_ads_internal_zze));
    }
}
