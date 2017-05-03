package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.zzji.zzb;
import com.google.android.gms.internal.zzji.zze;
import com.google.android.gms.internal.zzqp.zzc;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

@zzme
public class zzlw {
    private static final long zzQl;
    private static boolean zzQm;
    private static zzji zzQn;
    private static final Object zztX;
    private final Context mContext;
    private final zzs zzGJ;
    private final zzaw zzGP;
    private zzjg zzQo;
    private zze zzQp;
    private zzjf zzQq;
    private boolean zzQr;
    private final zzqh zzuc;

    public static abstract class zza {
        public abstract void zze(zzjj com_google_android_gms_internal_zzjj);

        public void zzjd() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlw.1 */
    class C12971 implements zzc<zzjj> {
        final /* synthetic */ zza zzQs;

        C12971(zzlw com_google_android_gms_internal_zzlw, zza com_google_android_gms_internal_zzlw_zza) {
            this.zzQs = com_google_android_gms_internal_zzlw_zza;
        }

        public void zzb(zzjj com_google_android_gms_internal_zzjj) {
            this.zzQs.zze(com_google_android_gms_internal_zzjj);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjj) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlw.2 */
    class C12982 implements com.google.android.gms.internal.zzqp.zza {
        final /* synthetic */ zza zzQs;

        C12982(zzlw com_google_android_gms_internal_zzlw, zza com_google_android_gms_internal_zzlw_zza) {
            this.zzQs = com_google_android_gms_internal_zzlw_zza;
        }

        public void run() {
            this.zzQs.zzjd();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlw.3 */
    class C12993 implements zzpt<zzjf> {
        final /* synthetic */ zzlw zzQt;

        C12993(zzlw com_google_android_gms_internal_zzlw) {
            this.zzQt = com_google_android_gms_internal_zzlw;
        }

        public void zza(zzjf com_google_android_gms_internal_zzjf) {
            zzs com_google_android_gms_ads_internal_zzs = (zzs) new WeakReference(this.zzQt.zzGJ).get();
            com_google_android_gms_internal_zzjf.zza(com_google_android_gms_ads_internal_zzs, com_google_android_gms_ads_internal_zzs, com_google_android_gms_ads_internal_zzs, com_google_android_gms_ads_internal_zzs, false, null, null, null, null);
        }

        public /* synthetic */ void zzd(Object obj) {
            zza((zzjf) obj);
        }
    }

    static {
        zzQl = TimeUnit.SECONDS.toMillis(60);
        zztX = new Object();
        zzQm = false;
        zzQn = null;
    }

    public zzlw(Context context, zzs com_google_android_gms_ads_internal_zzs, zzaw com_google_android_gms_internal_zzaw, zzqh com_google_android_gms_internal_zzqh) {
        this.zzQr = false;
        this.mContext = context;
        this.zzGJ = com_google_android_gms_ads_internal_zzs;
        this.zzGP = com_google_android_gms_internal_zzaw;
        this.zzuc = com_google_android_gms_internal_zzqh;
        this.zzQr = ((Boolean) zzgd.zzEm.get()).booleanValue();
    }

    public zzlw(Context context, com.google.android.gms.internal.zzpb.zza com_google_android_gms_internal_zzpb_zza, zzs com_google_android_gms_ads_internal_zzs, zzaw com_google_android_gms_internal_zzaw) {
        zzqh com_google_android_gms_internal_zzqh = (com_google_android_gms_internal_zzpb_zza == null || com_google_android_gms_internal_zzpb_zza.zzTi == null) ? null : com_google_android_gms_internal_zzpb_zza.zzTi.zzvn;
        this(context, com_google_android_gms_ads_internal_zzs, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzqh);
    }

    private void zziV() {
        synchronized (zztX) {
            if (!zzQm) {
                zzQn = new zzji(this.mContext.getApplicationContext() != null ? this.mContext.getApplicationContext() : this.mContext, this.zzuc, (String) zzgd.zzEj.get(), new C12993(this), new zzb());
                zzQm = true;
            }
        }
    }

    private void zziW() {
        this.zzQp = new zze(zzjb().zzc(this.zzGP));
    }

    private void zziX() {
        this.zzQo = new zzjg();
    }

    private void zziY() {
        this.zzQq = (zzjf) zziZ().zza(this.mContext, this.zzuc, (String) zzgd.zzEj.get(), this.zzGP, this.zzGJ.zzby()).get(zzQl, TimeUnit.MILLISECONDS);
        this.zzQq.zza(this.zzGJ, this.zzGJ, this.zzGJ, this.zzGJ, false, null, null, null, null);
    }

    public void zza(zza com_google_android_gms_internal_zzlw_zza) {
        if (this.zzQr) {
            zze zzjc = zzjc();
            if (zzjc == null) {
                zzqf.zzbh("SharedJavascriptEngine not initialized");
                return;
            } else {
                zzjc.zza(new C12971(this, com_google_android_gms_internal_zzlw_zza), new C12982(this, com_google_android_gms_internal_zzlw_zza));
                return;
            }
        }
        zzjj zzja = zzja();
        if (zzja == null) {
            zzqf.zzbh("JavascriptEngine not initialized");
        } else {
            com_google_android_gms_internal_zzlw_zza.zze(zzja);
        }
    }

    public void zziT() {
        if (this.zzQr) {
            zziV();
        } else {
            zziX();
        }
    }

    public void zziU() {
        if (this.zzQr) {
            zziW();
        } else {
            zziY();
        }
    }

    protected zzjg zziZ() {
        return this.zzQo;
    }

    protected zzjf zzja() {
        return this.zzQq;
    }

    protected zzji zzjb() {
        return zzQn;
    }

    protected zze zzjc() {
        return this.zzQp;
    }
}
