package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzeq.zza;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhq;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzme
public class zzk extends zza {
    private final Context mContext;
    private final Object zzrJ;
    private final zze zzsv;
    private final zzka zzsz;
    private final zzep zztk;
    @Nullable
    private final zzhp zztl;
    @Nullable
    private final zzhq zztm;
    private final SimpleArrayMap<String, zzhs> zztn;
    private final SimpleArrayMap<String, zzhr> zzto;
    private final zzhc zztp;
    private final List<String> zztq;
    private final zzex zztr;
    private final String zzts;
    private final zzqh zztt;
    @Nullable
    private WeakReference<zzs> zztu;

    /* renamed from: com.google.android.gms.ads.internal.zzk.1 */
    class C09471 implements Runnable {
        final /* synthetic */ zzec zztv;
        final /* synthetic */ zzk zztw;

        C09471(zzk com_google_android_gms_ads_internal_zzk, zzec com_google_android_gms_internal_zzec) {
            this.zztw = com_google_android_gms_ads_internal_zzk;
            this.zztv = com_google_android_gms_internal_zzec;
        }

        public void run() {
            synchronized (this.zztw.zzrJ) {
                zzs zzcj = this.zztw.zzcj();
                this.zztw.zztu = new WeakReference(zzcj);
                zzcj.zzb(this.zztw.zztl);
                zzcj.zzb(this.zztw.zztm);
                zzcj.zza(this.zztw.zztn);
                zzcj.zza(this.zztw.zztk);
                zzcj.zzb(this.zztw.zzto);
                zzcj.zzb(this.zztw.zzci());
                zzcj.zzb(this.zztw.zztp);
                zzcj.zza(this.zztw.zztr);
                zzcj.zzb(this.zztv);
            }
        }
    }

    zzk(Context context, String str, zzka com_google_android_gms_internal_zzka, zzqh com_google_android_gms_internal_zzqh, zzep com_google_android_gms_internal_zzep, zzhp com_google_android_gms_internal_zzhp, zzhq com_google_android_gms_internal_zzhq, SimpleArrayMap<String, zzhs> simpleArrayMap, SimpleArrayMap<String, zzhr> simpleArrayMap2, zzhc com_google_android_gms_internal_zzhc, zzex com_google_android_gms_internal_zzex, zze com_google_android_gms_ads_internal_zze) {
        this.zzrJ = new Object();
        this.mContext = context;
        this.zzts = str;
        this.zzsz = com_google_android_gms_internal_zzka;
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zztk = com_google_android_gms_internal_zzep;
        this.zztm = com_google_android_gms_internal_zzhq;
        this.zztl = com_google_android_gms_internal_zzhp;
        this.zztn = simpleArrayMap;
        this.zzto = simpleArrayMap2;
        this.zztp = com_google_android_gms_internal_zzhc;
        this.zztq = zzci();
        this.zztr = com_google_android_gms_internal_zzex;
        this.zzsv = com_google_android_gms_ads_internal_zze;
    }

    private List<String> zzci() {
        List<String> arrayList = new ArrayList();
        if (this.zztm != null) {
            arrayList.add("1");
        }
        if (this.zztl != null) {
            arrayList.add("2");
        }
        if (this.zztn.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    @Nullable
    public String getMediationAdapterClassName() {
        synchronized (this.zzrJ) {
            if (this.zztu != null) {
                zzs com_google_android_gms_ads_internal_zzs = (zzs) this.zztu.get();
                String mediationAdapterClassName = com_google_android_gms_ads_internal_zzs != null ? com_google_android_gms_ads_internal_zzs.getMediationAdapterClassName() : null;
                return mediationAdapterClassName;
            }
            return null;
        }
    }

    public boolean isLoading() {
        synchronized (this.zzrJ) {
            if (this.zztu != null) {
                zzs com_google_android_gms_ads_internal_zzs = (zzs) this.zztu.get();
                boolean isLoading = com_google_android_gms_ads_internal_zzs != null ? com_google_android_gms_ads_internal_zzs.isLoading() : false;
                return isLoading;
            }
            return false;
        }
    }

    protected void runOnUiThread(Runnable runnable) {
        zzpo.zzXC.post(runnable);
    }

    protected zzs zzcj() {
        return new zzs(this.mContext, this.zzsv, zzeg.zzk(this.mContext), this.zzts, this.zzsz, this.zztt);
    }

    public void zzf(zzec com_google_android_gms_internal_zzec) {
        runOnUiThread(new C09471(this, com_google_android_gms_internal_zzec));
    }
}
