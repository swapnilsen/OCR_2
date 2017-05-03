package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzqx.zza;
import org.json.JSONObject;

@zzme
public class zzjh implements zzjf {
    private final zzqw zzIs;

    /* renamed from: com.google.android.gms.internal.zzjh.1 */
    class C12431 implements Runnable {
        final /* synthetic */ String zzJE;
        final /* synthetic */ JSONObject zzJF;
        final /* synthetic */ zzjh zzJG;

        C12431(zzjh com_google_android_gms_internal_zzjh, String str, JSONObject jSONObject) {
            this.zzJG = com_google_android_gms_internal_zzjh;
            this.zzJE = str;
            this.zzJF = jSONObject;
        }

        public void run() {
            this.zzJG.zzIs.zza(this.zzJE, this.zzJF);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjh.2 */
    class C12442 implements Runnable {
        final /* synthetic */ String zzJE;
        final /* synthetic */ zzjh zzJG;
        final /* synthetic */ String zzJH;

        C12442(zzjh com_google_android_gms_internal_zzjh, String str, String str2) {
            this.zzJG = com_google_android_gms_internal_zzjh;
            this.zzJE = str;
            this.zzJH = str2;
        }

        public void run() {
            this.zzJG.zzIs.zzj(this.zzJE, this.zzJH);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjh.3 */
    class C12453 implements Runnable {
        final /* synthetic */ zzjh zzJG;
        final /* synthetic */ String zzJI;

        C12453(zzjh com_google_android_gms_internal_zzjh, String str) {
            this.zzJG = com_google_android_gms_internal_zzjh;
            this.zzJI = str;
        }

        public void run() {
            this.zzJG.zzIs.loadData(this.zzJI, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjh.4 */
    class C12464 implements Runnable {
        final /* synthetic */ zzjh zzJG;
        final /* synthetic */ String zzJI;

        C12464(zzjh com_google_android_gms_internal_zzjh, String str) {
            this.zzJG = com_google_android_gms_internal_zzjh;
            this.zzJI = str;
        }

        public void run() {
            this.zzJG.zzIs.loadData(this.zzJI, "text/html", "UTF-8");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjh.5 */
    class C12475 implements Runnable {
        final /* synthetic */ String zzJB;
        final /* synthetic */ zzjh zzJG;

        C12475(zzjh com_google_android_gms_internal_zzjh, String str) {
            this.zzJG = com_google_android_gms_internal_zzjh;
            this.zzJB = str;
        }

        public void run() {
            this.zzJG.zzIs.loadUrl(this.zzJB);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjh.6 */
    class C12486 implements zza {
        final /* synthetic */ zzjf.zza zzJJ;

        C12486(zzjh com_google_android_gms_internal_zzjh, zzjf.zza com_google_android_gms_internal_zzjf_zza) {
            this.zzJJ = com_google_android_gms_internal_zzjf_zza;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, boolean z) {
            this.zzJJ.zzgN();
        }
    }

    public zzjh(Context context, zzqh com_google_android_gms_internal_zzqh, @Nullable zzaw com_google_android_gms_internal_zzaw, zze com_google_android_gms_ads_internal_zze) {
        this.zzIs = zzw.zzcN().zza(context, new zzeg(), false, false, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzqh, null, null, com_google_android_gms_ads_internal_zze);
        this.zzIs.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzel.zzeT().zzlj()) {
            runnable.run();
        } else {
            zzpo.zzXC.post(runnable);
        }
    }

    public void destroy() {
        this.zzIs.destroy();
    }

    public void zza(zzdx com_google_android_gms_internal_zzdx, zzh com_google_android_gms_ads_internal_overlay_zzh, zzhz com_google_android_gms_internal_zzhz, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, zzif com_google_android_gms_internal_zzif, zzih com_google_android_gms_internal_zzih, zzf com_google_android_gms_ads_internal_zzf, zzkx com_google_android_gms_internal_zzkx) {
        this.zzIs.zzlv().zza(com_google_android_gms_internal_zzdx, com_google_android_gms_ads_internal_overlay_zzh, com_google_android_gms_internal_zzhz, com_google_android_gms_ads_internal_overlay_zzq, z, com_google_android_gms_internal_zzif, com_google_android_gms_internal_zzih, new zzf(this.zzIs.getContext(), false), com_google_android_gms_internal_zzkx, null);
    }

    public void zza(zzjf.zza com_google_android_gms_internal_zzjf_zza) {
        this.zzIs.zzlv().zza(new C12486(this, com_google_android_gms_internal_zzjf_zza));
    }

    public void zza(String str, zzid com_google_android_gms_internal_zzid) {
        this.zzIs.zzlv().zza(str, com_google_android_gms_internal_zzid);
    }

    public void zza(String str, JSONObject jSONObject) {
        runOnUiThread(new C12431(this, str, jSONObject));
    }

    public void zzam(String str) {
        runOnUiThread(new C12453(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public void zzan(String str) {
        runOnUiThread(new C12475(this, str));
    }

    public void zzao(String str) {
        runOnUiThread(new C12464(this, str));
    }

    public void zzb(String str, zzid com_google_android_gms_internal_zzid) {
        this.zzIs.zzlv().zzb(str, com_google_android_gms_internal_zzid);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzIs.zzb(str, jSONObject);
    }

    public zzjk zzgM() {
        return new zzjl(this);
    }

    public void zzj(String str, String str2) {
        runOnUiThread(new C12442(this, str, str2));
    }
}
