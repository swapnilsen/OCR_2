package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzjv.zza;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public class zzju implements zza {
    private final Context mContext;
    private final String zzKW;
    private final long zzKX;
    private final zzjr zzKY;
    private final zzjq zzKZ;
    private final boolean zzLa;
    private zzkb zzLb;
    private int zzLc;
    private zzkd zzLd;
    private final Object zzrJ;
    private final zzka zzsz;
    private final zzhc zztp;
    private final List<String> zztq;
    private final zzqh zztt;
    private zzec zzum;
    private final zzeg zzus;
    private final boolean zzwf;

    /* renamed from: com.google.android.gms.internal.zzju.1 */
    class C12661 implements Runnable {
        final /* synthetic */ zzjt zzLe;
        final /* synthetic */ zzju zzLf;

        C12661(zzju com_google_android_gms_internal_zzju, zzjt com_google_android_gms_internal_zzjt) {
            this.zzLf = com_google_android_gms_internal_zzju;
            this.zzLe = com_google_android_gms_internal_zzjt;
        }

        public void run() {
            synchronized (this.zzLf.zzrJ) {
                if (this.zzLf.zzLc != -2) {
                    return;
                }
                this.zzLf.zzLb = this.zzLf.zzgX();
                if (this.zzLf.zzLb == null) {
                    this.zzLf.zzF(4);
                } else if (!this.zzLf.zzgY() || this.zzLf.zzG(1)) {
                    this.zzLe.zza(this.zzLf);
                    this.zzLf.zza(this.zzLe);
                } else {
                    String zzf = this.zzLf.zzKW;
                    zzqf.zzbh(new StringBuilder(String.valueOf(zzf).length() + 56).append("Ignoring adapter ").append(zzf).append(" as delayed impression is not supported").toString());
                    this.zzLf.zzF(2);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzju.2 */
    class C12672 extends zzkd.zza {
        final /* synthetic */ int zzLg;

        C12672(int i) {
            this.zzLg = i;
        }

        public int zzha() {
            return this.zzLg;
        }
    }

    public zzju(Context context, String str, zzka com_google_android_gms_internal_zzka, zzjr com_google_android_gms_internal_zzjr, zzjq com_google_android_gms_internal_zzjq, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, zzqh com_google_android_gms_internal_zzqh, boolean z, boolean z2, zzhc com_google_android_gms_internal_zzhc, List<String> list) {
        this.zzrJ = new Object();
        this.zzLc = -2;
        this.mContext = context;
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zzKZ = com_google_android_gms_internal_zzjq;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzKW = zzgV();
        } else {
            this.zzKW = str;
        }
        this.zzKY = com_google_android_gms_internal_zzjr;
        this.zzKX = com_google_android_gms_internal_zzjr.zzKE != -1 ? com_google_android_gms_internal_zzjr.zzKE : 10000;
        this.zzum = com_google_android_gms_internal_zzec;
        this.zzus = com_google_android_gms_internal_zzeg;
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zzwf = z;
        this.zzLa = z2;
        this.zztp = com_google_android_gms_internal_zzhc;
        this.zztq = list;
    }

    private boolean zzG(int i) {
        try {
            Bundle zzhf = this.zzwf ? this.zzLb.zzhf() : this.zzus.zzzz ? this.zzLb.getInterstitialAdapterInfo() : this.zzLb.zzhe();
            if (zzhf == null) {
                return false;
            }
            return (zzhf.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            zzqf.zzbh("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static zzkd zzH(int i) {
        return new C12672(i);
    }

    private long zza(long j, long j2, long j3, long j4) {
        while (this.zzLc == -2) {
            zzb(j, j2, j3, j4);
        }
        return zzw.zzcS().elapsedRealtime() - j;
    }

    private void zza(zzjt com_google_android_gms_internal_zzjt) {
        String zzap = zzap(this.zzKZ.zzKv);
        try {
            if (this.zztt.zzYX < 4100000) {
                if (this.zzus.zzzz) {
                    this.zzLb.zza(zzd.zzA(this.mContext), this.zzum, zzap, com_google_android_gms_internal_zzjt);
                } else {
                    this.zzLb.zza(zzd.zzA(this.mContext), this.zzus, this.zzum, zzap, (zzkc) com_google_android_gms_internal_zzjt);
                }
            } else if (this.zzwf) {
                this.zzLb.zza(zzd.zzA(this.mContext), this.zzum, zzap, this.zzKZ.zzKn, com_google_android_gms_internal_zzjt, this.zztp, this.zztq);
            } else if (this.zzus.zzzz) {
                this.zzLb.zza(zzd.zzA(this.mContext), this.zzum, zzap, this.zzKZ.zzKn, (zzkc) com_google_android_gms_internal_zzjt);
            } else if (!this.zzLa) {
                this.zzLb.zza(zzd.zzA(this.mContext), this.zzus, this.zzum, zzap, this.zzKZ.zzKn, com_google_android_gms_internal_zzjt);
            } else if (this.zzKZ.zzKy != null) {
                this.zzLb.zza(zzd.zzA(this.mContext), this.zzum, zzap, this.zzKZ.zzKn, com_google_android_gms_internal_zzjt, new zzhc(zzaq(this.zzKZ.zzKC)), this.zzKZ.zzKB);
            } else {
                this.zzLb.zza(zzd.zzA(this.mContext), this.zzus, this.zzum, zzap, this.zzKZ.zzKn, com_google_android_gms_internal_zzjt);
            }
        } catch (Throwable e) {
            zzqf.zzc("Could not request ad from mediation adapter.", e);
            zzF(5);
        }
    }

    private String zzap(String str) {
        if (!(str == null || !zzgY() || zzG(2))) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                str = jSONObject.toString();
            } catch (JSONException e) {
                zzqf.zzbh("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private static NativeAdOptions zzaq(String str) {
        Builder builder = new Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            builder.setImageOrientation(zzar(jSONObject.optString("native_image_orientation", "any")));
        } catch (Throwable e) {
            zzqf.zzc("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private static int zzar(String str) {
        return "landscape".equals(str) ? 2 : "portrait".equals(str) ? 1 : 0;
    }

    private void zzb(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            zzqf.zzbg("Timed out waiting for adapter.");
            this.zzLc = 3;
            return;
        }
        try {
            this.zzrJ.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.zzLc = -1;
        }
    }

    private String zzgV() {
        try {
            if (!TextUtils.isEmpty(this.zzKZ.zzKr)) {
                return this.zzsz.zzat(this.zzKZ.zzKr) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            zzqf.zzbh("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzkd zzgW() {
        if (this.zzLc != 0 || !zzgY()) {
            return null;
        }
        try {
            if (!(!zzG(4) || this.zzLd == null || this.zzLd.zzha() == 0)) {
                return this.zzLd;
            }
        } catch (RemoteException e) {
            zzqf.zzbh("Could not get cpm value from MediationResponseMetadata");
        }
        return zzH(zzgZ());
    }

    private zzkb zzgX() {
        String str = "Instantiating mediation adapter: ";
        String valueOf = String.valueOf(this.zzKW);
        zzqf.zzbg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (!this.zzwf) {
            if (((Boolean) zzgd.zzDI.get()).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzKW)) {
                return zza(new AdMobAdapter());
            }
            if (((Boolean) zzgd.zzDJ.get()).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.zzKW)) {
                return zza(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.zzKW)) {
                return new zzkh(new zzkp());
            }
        }
        try {
            return this.zzsz.zzas(this.zzKW);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Could not instantiate mediation adapter: ";
            valueOf = String.valueOf(this.zzKW);
            zzqf.zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return null;
        }
    }

    private boolean zzgY() {
        return this.zzKY.zzKO != -1;
    }

    private int zzgZ() {
        if (this.zzKZ.zzKv == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzKZ.zzKv);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzKW)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = zzG(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            zzqf.zzbh("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public void cancel() {
        synchronized (this.zzrJ) {
            try {
                if (this.zzLb != null) {
                    this.zzLb.destroy();
                }
            } catch (Throwable e) {
                zzqf.zzc("Could not destroy mediation adapter.", e);
            }
            this.zzLc = -1;
            this.zzrJ.notify();
        }
    }

    public void zzF(int i) {
        synchronized (this.zzrJ) {
            this.zzLc = i;
            this.zzrJ.notify();
        }
    }

    public zzjv zza(long j, long j2) {
        zzjv com_google_android_gms_internal_zzjv;
        synchronized (this.zzrJ) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzjt com_google_android_gms_internal_zzjt = new zzjt();
            zzpo.zzXC.post(new C12661(this, com_google_android_gms_internal_zzjt));
            zzjt com_google_android_gms_internal_zzjt2 = com_google_android_gms_internal_zzjt;
            com_google_android_gms_internal_zzjv = new zzjv(this.zzKZ, this.zzLb, this.zzKW, com_google_android_gms_internal_zzjt2, this.zzLc, zzgW(), zza(elapsedRealtime, this.zzKX, j, j2));
        }
        return com_google_android_gms_internal_zzjv;
    }

    protected zzkb zza(MediationAdapter mediationAdapter) {
        return new zzkh(mediationAdapter);
    }

    public void zza(int i, zzkd com_google_android_gms_internal_zzkd) {
        synchronized (this.zzrJ) {
            this.zzLc = i;
            this.zzLd = com_google_android_gms_internal_zzkd;
            this.zzrJ.notify();
        }
    }
}
