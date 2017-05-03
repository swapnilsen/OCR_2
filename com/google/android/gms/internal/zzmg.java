package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzw;
import org.json.JSONObject;

@zzme
public class zzmg extends zzpj implements com.google.android.gms.internal.zzmh.zza {
    private final Context mContext;
    zzjr zzKY;
    private zzmk zzLo;
    zzmn zzPS;
    private Runnable zzPT;
    private final Object zzPU;
    private final com.google.android.gms.internal.zzmf.zza zzRl;
    private final com.google.android.gms.internal.zzmk.zza zzRm;
    zzpq zzRn;

    /* renamed from: com.google.android.gms.internal.zzmg.1 */
    class C13151 implements Runnable {
        final /* synthetic */ zzmg zzRo;

        C13151(zzmg com_google_android_gms_internal_zzmg) {
            this.zzRo = com_google_android_gms_internal_zzmg;
        }

        public void run() {
            synchronized (this.zzRo.zzPU) {
                if (this.zzRo.zzRn == null) {
                    return;
                }
                this.zzRo.onStop();
                this.zzRo.zzd(2, "Timed out waiting for ad response.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmg.2 */
    class C13162 implements Runnable {
        final /* synthetic */ zzmg zzRo;
        final /* synthetic */ zzqp zzRp;

        C13162(zzmg com_google_android_gms_internal_zzmg, zzqp com_google_android_gms_internal_zzqp) {
            this.zzRo = com_google_android_gms_internal_zzmg;
            this.zzRp = com_google_android_gms_internal_zzqp;
        }

        public void run() {
            synchronized (this.zzRo.zzPU) {
                this.zzRo.zzRn = this.zzRo.zza(this.zzRo.zzRm.zzvn, this.zzRp);
                if (this.zzRo.zzRn == null) {
                    this.zzRo.zzd(0, "Could not start the ad request service.");
                    zzpo.zzXC.removeCallbacks(this.zzRo.zzPT);
                }
            }
        }
    }

    @zzme
    static final class zza extends Exception {
        private final int zzPY;

        public zza(String str, int i) {
            super(str);
            this.zzPY = i;
        }

        public int getErrorCode() {
            return this.zzPY;
        }
    }

    public zzmg(Context context, com.google.android.gms.internal.zzmk.zza com_google_android_gms_internal_zzmk_zza, com.google.android.gms.internal.zzmf.zza com_google_android_gms_internal_zzmf_zza) {
        this.zzPU = new Object();
        this.zzRl = com_google_android_gms_internal_zzmf_zza;
        this.mContext = context;
        this.zzRm = com_google_android_gms_internal_zzmk_zza;
    }

    private void zzd(int i, String str) {
        if (i == 3 || i == -1) {
            zzqf.zzbg(str);
        } else {
            zzqf.zzbh(str);
        }
        if (this.zzPS == null) {
            this.zzPS = new zzmn(i);
        } else {
            this.zzPS = new zzmn(i, this.zzPS.zzKL);
        }
        this.zzRl.zza(new com.google.android.gms.internal.zzpb.zza(this.zzLo != null ? this.zzLo : new zzmk(this.zzRm, -1, null, null, null), this.zzPS, this.zzKY, null, i, -1, this.zzPS.zzSr, null));
    }

    public void onStop() {
        synchronized (this.zzPU) {
            if (this.zzRn != null) {
                this.zzRn.cancel();
            }
        }
    }

    zzpq zza(zzqh com_google_android_gms_internal_zzqh, zzqp<zzmk> com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk) {
        return zzmh.zza(this.mContext, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzqp_com_google_android_gms_internal_zzmk, this);
    }

    public void zza(@NonNull zzmn com_google_android_gms_internal_zzmn) {
        zzqf.zzbf("Received ad response.");
        this.zzPS = com_google_android_gms_internal_zzmn;
        long elapsedRealtime = zzw.zzcS().elapsedRealtime();
        synchronized (this.zzPU) {
            this.zzRn = null;
        }
        zzw.zzcQ().zzd(this.mContext, this.zzPS.zzRV);
        if (((Boolean) zzgd.zzDc.get()).booleanValue()) {
            if (this.zzPS.zzSh) {
                zzw.zzcQ().zzk(this.mContext, this.zzLo.zzvl);
            } else {
                zzw.zzcQ().zzl(this.mContext, this.zzLo.zzvl);
            }
        }
        try {
            if (this.zzPS.errorCode == -2 || this.zzPS.errorCode == -3) {
                JSONObject jSONObject;
                zzjm();
                zzeg zzb = this.zzLo.zzvr.zzzA != null ? zzb(this.zzLo) : null;
                zzw.zzcQ().zzF(this.zzPS.zzSx);
                zzw.zzcQ().zzG(this.zzPS.zzSK);
                if (!TextUtils.isEmpty(this.zzPS.zzSv)) {
                    try {
                        jSONObject = new JSONObject(this.zzPS.zzSv);
                    } catch (Throwable e) {
                        zzqf.zzb("Error parsing the JSON for Active View.", e);
                    }
                    this.zzRl.zza(new com.google.android.gms.internal.zzpb.zza(this.zzLo, this.zzPS, this.zzKY, zzb, -2, elapsedRealtime, this.zzPS.zzSr, jSONObject));
                    zzpo.zzXC.removeCallbacks(this.zzPT);
                    return;
                }
                jSONObject = null;
                this.zzRl.zza(new com.google.android.gms.internal.zzpb.zza(this.zzLo, this.zzPS, this.zzKY, zzb, -2, elapsedRealtime, this.zzPS.zzSr, jSONObject));
                zzpo.zzXC.removeCallbacks(this.zzPT);
                return;
            }
            throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzPS.errorCode, this.zzPS.errorCode);
        } catch (zza e2) {
            zzd(e2.getErrorCode(), e2.getMessage());
            zzpo.zzXC.removeCallbacks(this.zzPT);
        }
    }

    protected zzeg zzb(zzmk com_google_android_gms_internal_zzmk) {
        int i;
        if (this.zzPS.zzzC) {
            for (zzeg com_google_android_gms_internal_zzeg : com_google_android_gms_internal_zzmk.zzvr.zzzA) {
                if (com_google_android_gms_internal_zzeg.zzzC) {
                    return new zzeg(com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzmk.zzvr.zzzA);
                }
            }
        }
        if (this.zzPS.zzSq == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzPS.zzSq.split("x");
        if (split.length != 2) {
            String str = "Invalid ad size format from the ad response: ";
            String valueOf = String.valueOf(this.zzPS.zzSq);
            throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zzeg com_google_android_gms_internal_zzeg2 : com_google_android_gms_internal_zzmk.zzvr.zzzA) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                i = com_google_android_gms_internal_zzeg2.width == -1 ? (int) (((float) com_google_android_gms_internal_zzeg2.widthPixels) / f) : com_google_android_gms_internal_zzeg2.width;
                int i2 = com_google_android_gms_internal_zzeg2.height == -2 ? (int) (((float) com_google_android_gms_internal_zzeg2.heightPixels) / f) : com_google_android_gms_internal_zzeg2.height;
                if (parseInt == i && parseInt2 == i2 && !com_google_android_gms_internal_zzeg2.zzzC) {
                    return new zzeg(com_google_android_gms_internal_zzeg2, com_google_android_gms_internal_zzmk.zzvr.zzzA);
                }
            }
            str = "The ad size from the ad response was not one of the requested sizes: ";
            valueOf = String.valueOf(this.zzPS.zzSq);
            throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        } catch (NumberFormatException e) {
            str = "Invalid ad size number from the ad response: ";
            valueOf = String.valueOf(this.zzPS.zzSq);
            throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
    }

    public void zzco() {
        zzqf.zzbf("AdLoaderBackgroundTask started.");
        this.zzPT = new C13151(this);
        zzpo.zzXC.postDelayed(this.zzPT, ((Long) zzgd.zzDL.get()).longValue());
        long elapsedRealtime = zzw.zzcS().elapsedRealtime();
        if (((Boolean) zzgd.zzDK.get()).booleanValue() && this.zzRm.zzRy.extras != null) {
            String string = this.zzRm.zzRy.extras.getString("_ad");
            if (string != null) {
                this.zzLo = new zzmk(this.zzRm, elapsedRealtime, null, null, null);
                zza(zznd.zza(this.mContext, this.zzLo, string));
                return;
            }
        }
        zzqp com_google_android_gms_internal_zzqq = new zzqq();
        zzpn.zza(new C13162(this, com_google_android_gms_internal_zzqq));
        String zzD = zzw.zzdl().zzD(this.mContext);
        String zzE = zzw.zzdl().zzE(this.mContext);
        String zzF = zzw.zzdl().zzF(this.mContext);
        zzw.zzdl().zzh(this.mContext, zzF);
        this.zzLo = new zzmk(this.zzRm, elapsedRealtime, zzD, zzE, zzF);
        com_google_android_gms_internal_zzqq.zzg(this.zzLo);
    }

    protected void zzjm() {
        if (this.zzPS.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzPS.body)) {
                throw new zza("No fill from ad server.", 3);
            }
            zzw.zzcQ().zzc(this.mContext, this.zzPS.zzRG);
            if (this.zzPS.zzSn) {
                try {
                    this.zzKY = new zzjr(this.zzPS.body);
                    zzw.zzcQ().zzH(this.zzKY.zzKJ);
                } catch (Throwable e) {
                    zzqf.zzb("Could not parse mediation config.", e);
                    String str = "Could not parse mediation config: ";
                    String valueOf = String.valueOf(this.zzPS.body);
                    throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
                }
            }
            zzw.zzcQ().zzH(this.zzPS.zzKJ);
            if (!TextUtils.isEmpty(this.zzPS.zzRW) && ((Boolean) zzgd.zzFb.get()).booleanValue()) {
                zzqf.zzbf("Received cookie from server. Setting webview cookie in CookieManager.");
                CookieManager zzX = zzw.zzcO().zzX(this.mContext);
                if (zzX != null) {
                    zzX.setCookie("googleads.g.doubleclick.net", this.zzPS.zzRW);
                }
            }
        }
    }
}
