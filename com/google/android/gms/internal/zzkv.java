package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzku.zza;
import java.util.Map;

@zzme
public class zzkv extends zzkw implements zzid {
    private final Context mContext;
    private final zzqw zzIs;
    private int zzMA;
    int zzMB;
    int zzMC;
    int zzMD;
    int zzME;
    private final zzfv zzMw;
    private float zzMx;
    int zzMy;
    int zzMz;
    DisplayMetrics zzwY;
    private final WindowManager zzwo;

    public zzkv(zzqw com_google_android_gms_internal_zzqw, Context context, zzfv com_google_android_gms_internal_zzfv) {
        super(com_google_android_gms_internal_zzqw);
        this.zzMy = -1;
        this.zzMz = -1;
        this.zzMB = -1;
        this.zzMC = -1;
        this.zzMD = -1;
        this.zzME = -1;
        this.zzIs = com_google_android_gms_internal_zzqw;
        this.mContext = context;
        this.zzMw = com_google_android_gms_internal_zzfv;
        this.zzwo = (WindowManager) context.getSystemService("window");
    }

    private void zzhp() {
        this.zzwY = new DisplayMetrics();
        Display defaultDisplay = this.zzwo.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzwY);
        this.zzMx = this.zzwY.density;
        this.zzMA = defaultDisplay.getRotation();
    }

    private void zzhu() {
        int[] iArr = new int[2];
        this.zzIs.getLocationOnScreen(iArr);
        zzf(zzel.zzeT().zzc(this.mContext, iArr[0]), zzel.zzeT().zzc(this.mContext, iArr[1]));
    }

    private zzku zzhx() {
        return new zza().zzu(this.zzMw.zzfl()).zzt(this.zzMw.zzfm()).zzv(this.zzMw.zzfp()).zzw(this.zzMw.zzfn()).zzx(true).zzho();
    }

    public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
        zzhs();
    }

    public void zzf(int i, int i2) {
        int i3 = this.mContext instanceof Activity ? zzw.zzcM().zzk((Activity) this.mContext)[0] : 0;
        if (this.zzIs.zzbC() == null || !this.zzIs.zzbC().zzzz) {
            this.zzMD = zzel.zzeT().zzc(this.mContext, this.zzIs.getMeasuredWidth());
            this.zzME = zzel.zzeT().zzc(this.mContext, this.zzIs.getMeasuredHeight());
        }
        zzc(i, i2 - i3, this.zzMD, this.zzME);
        this.zzIs.zzlv().zze(i, i2);
    }

    void zzhq() {
        this.zzMy = zzel.zzeT().zzb(this.zzwY, this.zzwY.widthPixels);
        this.zzMz = zzel.zzeT().zzb(this.zzwY, this.zzwY.heightPixels);
        Activity zzlr = this.zzIs.zzlr();
        if (zzlr == null || zzlr.getWindow() == null) {
            this.zzMB = this.zzMy;
            this.zzMC = this.zzMz;
            return;
        }
        int[] zzh = zzw.zzcM().zzh(zzlr);
        this.zzMB = zzel.zzeT().zzb(this.zzwY, zzh[0]);
        this.zzMC = zzel.zzeT().zzb(this.zzwY, zzh[1]);
    }

    void zzhr() {
        if (this.zzIs.zzbC().zzzz) {
            this.zzMD = this.zzMy;
            this.zzME = this.zzMz;
            return;
        }
        this.zzIs.measure(0, 0);
    }

    public void zzhs() {
        zzhp();
        zzhq();
        zzhr();
        zzhv();
        zzhw();
        zzhu();
        zzht();
    }

    void zzht() {
        if (zzqf.zzak(2)) {
            zzqf.zzbg("Dispatching Ready Event.");
        }
        zzaA(this.zzIs.zzly().zzba);
    }

    void zzhv() {
        zza(this.zzMy, this.zzMz, this.zzMB, this.zzMC, this.zzMx, this.zzMA);
    }

    void zzhw() {
        this.zzIs.zzb("onDeviceFeaturesReceived", zzhx().toJson());
    }
}
