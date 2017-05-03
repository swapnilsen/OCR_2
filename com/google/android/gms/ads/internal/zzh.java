package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqp.zzb;
import com.google.android.gms.internal.zzqp.zzc;
import com.google.android.gms.internal.zzqw;
import java.util.Map;
import org.json.JSONObject;

@zzme
public class zzh {
    private Context mContext;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.ads.internal.zzh.1 */
    class C09441 implements zzid {
        final /* synthetic */ Runnable zzsY;
        final /* synthetic */ zzh zzsZ;

        C09441(zzh com_google_android_gms_ads_internal_zzh, Runnable runnable) {
            this.zzsZ = com_google_android_gms_ads_internal_zzh;
            this.zzsY = runnable;
        }

        public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
            com_google_android_gms_internal_zzqw.zzb("/appSettingsFetched", (zzid) this);
            synchronized (this.zzsZ.zzrJ) {
                if (map != null) {
                    if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                        zzw.zzcQ().zzn(this.zzsZ.mContext, (String) map.get("appSettingsJson"));
                        try {
                            if (this.zzsY != null) {
                                this.zzsY.run();
                            }
                        } catch (Throwable th) {
                            zzw.zzcQ().zza(th, "ConfigLoader.maybeFetchNewAppSettings");
                            zzqf.zzc("ConfigLoader post task failed.", th);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzh.2 */
    class C09462 implements Runnable {
        final /* synthetic */ zzji zzta;
        final /* synthetic */ zzid zztb;
        final /* synthetic */ String zztc;
        final /* synthetic */ String zztd;
        final /* synthetic */ boolean zzte;
        final /* synthetic */ Context zztf;

        /* renamed from: com.google.android.gms.ads.internal.zzh.2.1 */
        class C09451 implements zzc<zzjj> {
            final /* synthetic */ C09462 zztg;

            C09451(C09462 c09462) {
                this.zztg = c09462;
            }

            public void zzb(zzjj com_google_android_gms_internal_zzjj) {
                com_google_android_gms_internal_zzjj.zza("/appSettingsFetched", this.zztg.zztb);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(this.zztg.zztc)) {
                        jSONObject.put("app_id", this.zztg.zztc);
                    } else if (!TextUtils.isEmpty(this.zztg.zztd)) {
                        jSONObject.put("ad_unit_id", this.zztg.zztd);
                    }
                    jSONObject.put("is_init", this.zztg.zzte);
                    jSONObject.put("pn", this.zztg.zztf.getPackageName());
                    com_google_android_gms_internal_zzjj.zza("AFMA_fetchAppSettings", jSONObject);
                } catch (Throwable e) {
                    com_google_android_gms_internal_zzjj.zzb("/appSettingsFetched", this.zztg.zztb);
                    zzqf.zzb("Error requesting application settings", e);
                }
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjj) obj);
            }
        }

        C09462(zzh com_google_android_gms_ads_internal_zzh, zzji com_google_android_gms_internal_zzji, zzid com_google_android_gms_internal_zzid, String str, String str2, boolean z, Context context) {
            this.zzta = com_google_android_gms_internal_zzji;
            this.zztb = com_google_android_gms_internal_zzid;
            this.zztc = str;
            this.zztd = str2;
            this.zzte = z;
            this.zztf = context;
        }

        public void run() {
            this.zzta.zzgO().zza(new C09451(this), new zzb());
        }
    }

    public zzh() {
        this.zzrJ = new Object();
    }

    private static boolean zza(@Nullable zzpd com_google_android_gms_internal_zzpd) {
        if (com_google_android_gms_internal_zzpd == null) {
            return true;
        }
        boolean z = (((zzw.zzcS().currentTimeMillis() - com_google_android_gms_internal_zzpd.zzkb()) > ((Long) zzgd.zzEL.get()).longValue() ? 1 : ((zzw.zzcS().currentTimeMillis() - com_google_android_gms_internal_zzpd.zzkb()) == ((Long) zzgd.zzEL.get()).longValue() ? 0 : -1)) > 0) || !com_google_android_gms_internal_zzpd.zzkc();
        return z;
    }

    public void zza(Context context, zzqh com_google_android_gms_internal_zzqh, String str, zzpd com_google_android_gms_internal_zzpd) {
        zza(context, com_google_android_gms_internal_zzqh, false, com_google_android_gms_internal_zzpd, com_google_android_gms_internal_zzpd != null ? null : com_google_android_gms_internal_zzpd.zzke(), str, null);
    }

    public void zza(Context context, zzqh com_google_android_gms_internal_zzqh, String str, @Nullable Runnable runnable) {
        zza(context, com_google_android_gms_internal_zzqh, true, null, str, null, runnable);
    }

    void zza(Context context, zzqh com_google_android_gms_internal_zzqh, boolean z, @Nullable zzpd com_google_android_gms_internal_zzpd, String str, @Nullable String str2, @Nullable Runnable runnable) {
        if (!zza(com_google_android_gms_internal_zzpd)) {
            return;
        }
        if (context == null) {
            zzqf.zzbh("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            zzqf.zzbh("App settings could not be fetched. Required parameters missing");
        } else {
            this.mContext = context;
            zzpo.zzXC.post(new C09462(this, zzw.zzcM().zzd(context, com_google_android_gms_internal_zzqh), new C09441(this, runnable), str, str2, z, context));
        }
    }
}
