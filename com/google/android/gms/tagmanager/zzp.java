package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzaaf;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzbje;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzp extends zzaaf<ContainerHolder> {
    private final Context mContext;
    private final String zzbEU;
    private long zzbEZ;
    private final TagManager zzbFg;
    private final zzd zzbFj;
    private final zzcl zzbFk;
    private final int zzbFl;
    private final zzq zzbFm;
    private zzf zzbFn;
    private zzbje zzbFo;
    private volatile zzo zzbFp;
    private volatile boolean zzbFq;
    private zzj zzbFr;
    private String zzbFs;
    private zze zzbFt;
    private zza zzbFu;
    private final Looper zzrs;
    private final com.google.android.gms.common.util.zze zzuP;

    interface zze extends Releasable {
        void zza(zzbn<zzj> com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzaj_zzj);

        void zzf(long j, String str);

        void zzgZ(String str);
    }

    interface zzf extends Releasable {
        void zzQp();

        void zza(zzbn<com.google.android.gms.internal.zzbjd.zza> com_google_android_gms_tagmanager_zzbn_com_google_android_gms_internal_zzbjd_zza);

        void zzb(com.google.android.gms.internal.zzbjd.zza com_google_android_gms_internal_zzbjd_zza);

        com.google.android.gms.internal.zzbjf.zzc zznz(int i);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzp.1 */
    class C14601 {
    }

    /* renamed from: com.google.android.gms.tagmanager.zzp.2 */
    class C14612 implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp zzbFv;

        C14612(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbFv = com_google_android_gms_tagmanager_zzp;
        }

        public String zzQh() {
            return this.zzbFv.zzQh();
        }

        public void zzQj() {
            zzbo.zzbh("Refresh ignored: container loaded as default only.");
        }

        public void zzgW(String str) {
            this.zzbFv.zzgW(str);
        }
    }

    interface zza {
        boolean zzb(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzp.3 */
    class C14623 implements zza {
        final /* synthetic */ zzp zzbFv;
        private Long zzbFw;
        final /* synthetic */ boolean zzbFx;

        C14623(zzp com_google_android_gms_tagmanager_zzp, boolean z) {
            this.zzbFv = com_google_android_gms_tagmanager_zzp;
            this.zzbFx = z;
        }

        private long zzQo() {
            if (this.zzbFw == null) {
                this.zzbFw = Long.valueOf(this.zzbFv.zzbFm.zzQq());
            }
            return this.zzbFw.longValue();
        }

        public boolean zzb(Container container) {
            return this.zzbFx ? container.getLastRefreshTime() + zzQo() >= this.zzbFv.zzuP.currentTimeMillis() : !container.isDefault();
        }
    }

    private class zzb implements zzbn<com.google.android.gms.internal.zzbjd.zza> {
        final /* synthetic */ zzp zzbFv;

        private zzb(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbFv = com_google_android_gms_tagmanager_zzp;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            zza((com.google.android.gms.internal.zzbjd.zza) obj);
        }

        public void zza(com.google.android.gms.internal.zzbjd.zza com_google_android_gms_internal_zzbjd_zza) {
            zzj com_google_android_gms_internal_zzaj_zzj;
            if (com_google_android_gms_internal_zzbjd_zza.zzbNf != null) {
                com_google_android_gms_internal_zzaj_zzj = com_google_android_gms_internal_zzbjd_zza.zzbNf;
            } else {
                com.google.android.gms.internal.zzaj.zzf com_google_android_gms_internal_zzaj_zzf = com_google_android_gms_internal_zzbjd_zza.zzlr;
                com_google_android_gms_internal_zzaj_zzj = new zzj();
                com_google_android_gms_internal_zzaj_zzj.zzlr = com_google_android_gms_internal_zzaj_zzf;
                com_google_android_gms_internal_zzaj_zzj.zzlq = null;
                com_google_android_gms_internal_zzaj_zzj.zzls = com_google_android_gms_internal_zzaj_zzf.version;
            }
            this.zzbFv.zza(com_google_android_gms_internal_zzaj_zzj, com_google_android_gms_internal_zzbjd_zza.zzbNe, true);
        }

        public void zza(com.google.android.gms.tagmanager.zzbn.zza com_google_android_gms_tagmanager_zzbn_zza) {
            if (!this.zzbFv.zzbFq) {
                this.zzbFv.zzay(0);
            }
        }
    }

    private class zzc implements zzbn<zzj> {
        final /* synthetic */ zzp zzbFv;

        private zzc(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbFv = com_google_android_gms_tagmanager_zzp;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            zzb((zzj) obj);
        }

        public void zza(com.google.android.gms.tagmanager.zzbn.zza com_google_android_gms_tagmanager_zzbn_zza) {
            if (com_google_android_gms_tagmanager_zzbn_zza == com.google.android.gms.tagmanager.zzbn.zza.SERVER_UNAVAILABLE_ERROR) {
                this.zzbFv.zzbFm.zzQs();
            }
            synchronized (this.zzbFv) {
                if (!this.zzbFv.isReady()) {
                    if (this.zzbFv.zzbFp != null) {
                        this.zzbFv.zzb(this.zzbFv.zzbFp);
                    } else {
                        this.zzbFv.zzb(this.zzbFv.zzbN(Status.zzazA));
                    }
                }
            }
            this.zzbFv.zzay(this.zzbFv.zzbFm.zzQr());
        }

        public void zzb(zzj com_google_android_gms_internal_zzaj_zzj) {
            this.zzbFv.zzbFm.zzQt();
            synchronized (this.zzbFv) {
                if (com_google_android_gms_internal_zzaj_zzj.zzlr == null) {
                    if (this.zzbFv.zzbFr.zzlr == null) {
                        zzbo.m4711e("Current resource is null; network resource is also null");
                        this.zzbFv.zzay(this.zzbFv.zzbFm.zzQr());
                        return;
                    }
                    com_google_android_gms_internal_zzaj_zzj.zzlr = this.zzbFv.zzbFr.zzlr;
                }
                this.zzbFv.zza(com_google_android_gms_internal_zzaj_zzj, this.zzbFv.zzuP.currentTimeMillis(), false);
                zzbo.m4712v("setting refresh time to current time: " + this.zzbFv.zzbEZ);
                if (!this.zzbFv.zzQn()) {
                    this.zzbFv.zza(com_google_android_gms_internal_zzaj_zzj);
                }
            }
        }
    }

    private class zzd implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp zzbFv;

        private zzd(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbFv = com_google_android_gms_tagmanager_zzp;
        }

        public String zzQh() {
            return this.zzbFv.zzQh();
        }

        public void zzQj() {
            if (this.zzbFv.zzbFk.zzpV()) {
                this.zzbFv.zzay(0);
            }
        }

        public void zzgW(String str) {
            this.zzbFv.zzgW(str);
        }
    }

    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf com_google_android_gms_tagmanager_zzp_zzf, zze com_google_android_gms_tagmanager_zzp_zze, zzbje com_google_android_gms_internal_zzbje, com.google.android.gms.common.util.zze com_google_android_gms_common_util_zze, zzcl com_google_android_gms_tagmanager_zzcl, zzq com_google_android_gms_tagmanager_zzq) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzbFg = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzrs = looper;
        this.zzbEU = str;
        this.zzbFl = i;
        this.zzbFn = com_google_android_gms_tagmanager_zzp_zzf;
        this.zzbFt = com_google_android_gms_tagmanager_zzp_zze;
        this.zzbFo = com_google_android_gms_internal_zzbje;
        this.zzbFj = new zzd();
        this.zzbFr = new zzj();
        this.zzuP = com_google_android_gms_common_util_zze;
        this.zzbFk = com_google_android_gms_tagmanager_zzcl;
        this.zzbFm = com_google_android_gms_tagmanager_zzq;
        if (zzQn()) {
            zzgW(zzcj.zzRe().zzRg());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzt com_google_android_gms_tagmanager_zzt) {
        zzcv com_google_android_gms_tagmanager_zzcv = new zzcv(context, str);
        zzcu com_google_android_gms_tagmanager_zzcu = new zzcu(context, str, com_google_android_gms_tagmanager_zzt);
        Context context2 = context;
        TagManager tagManager2 = tagManager;
        Looper looper2 = looper;
        String str2 = str;
        int i2 = i;
        zzcv com_google_android_gms_tagmanager_zzcv2 = com_google_android_gms_tagmanager_zzcv;
        zzcu com_google_android_gms_tagmanager_zzcu2 = com_google_android_gms_tagmanager_zzcu;
        zzbm com_google_android_gms_tagmanager_zzbm = new zzbm(1, 5, 900000, 5000, "refreshing", zzi.zzzc());
        this(context2, tagManager2, looper2, str2, i2, com_google_android_gms_tagmanager_zzcv2, com_google_android_gms_tagmanager_zzcu2, new zzbje(context), zzi.zzzc(), r5, new zzq(context, str));
        this.zzbFo.zzig(com_google_android_gms_tagmanager_zzt.zzQv());
    }

    private boolean zzQn() {
        zzcj zzRe = zzcj.zzRe();
        return (zzRe.zzRf() == zza.CONTAINER || zzRe.zzRf() == zza.CONTAINER_DEBUG) && this.zzbEU.equals(zzRe.getContainerId());
    }

    private synchronized void zza(zzj com_google_android_gms_internal_zzaj_zzj) {
        if (this.zzbFn != null) {
            com.google.android.gms.internal.zzbjd.zza com_google_android_gms_internal_zzbjd_zza = new com.google.android.gms.internal.zzbjd.zza();
            com_google_android_gms_internal_zzbjd_zza.zzbNe = this.zzbEZ;
            com_google_android_gms_internal_zzbjd_zza.zzlr = new com.google.android.gms.internal.zzaj.zzf();
            com_google_android_gms_internal_zzbjd_zza.zzbNf = com_google_android_gms_internal_zzaj_zzj;
            this.zzbFn.zzb(com_google_android_gms_internal_zzbjd_zza);
        }
    }

    private synchronized void zza(zzj com_google_android_gms_internal_zzaj_zzj, long j, boolean z) {
        if (z) {
            boolean z2 = this.zzbFq;
        }
        if (!(isReady() && this.zzbFp == null)) {
            this.zzbFr = com_google_android_gms_internal_zzaj_zzj;
            this.zzbEZ = j;
            long zzQq = this.zzbFm.zzQq();
            zzay(Math.max(0, Math.min(zzQq, (this.zzbEZ + zzQq) - this.zzuP.currentTimeMillis())));
            Container container = new Container(this.mContext, this.zzbFg.getDataLayer(), this.zzbEU, j, com_google_android_gms_internal_zzaj_zzj);
            if (this.zzbFp == null) {
                this.zzbFp = new zzo(this.zzbFg, this.zzrs, container, this.zzbFj);
            } else {
                this.zzbFp.zza(container);
            }
            if (!isReady() && this.zzbFu.zzb(container)) {
                zzb(this.zzbFp);
            }
        }
    }

    private void zzaR(boolean z) {
        this.zzbFn.zza(new zzb());
        this.zzbFt.zza(new zzc());
        com.google.android.gms.internal.zzbjf.zzc zznz = this.zzbFn.zznz(this.zzbFl);
        if (zznz != null) {
            this.zzbFp = new zzo(this.zzbFg, this.zzrs, new Container(this.mContext, this.zzbFg.getDataLayer(), this.zzbEU, 0, zznz), this.zzbFj);
        }
        this.zzbFu = new C14623(this, z);
        if (zzQn()) {
            this.zzbFt.zzf(0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
        } else {
            this.zzbFn.zzQp();
        }
    }

    private synchronized void zzay(long j) {
        if (this.zzbFt == null) {
            zzbo.zzbh("Refresh requested, but no network load scheduler.");
        } else {
            this.zzbFt.zzf(j, this.zzbFr.zzls);
        }
    }

    synchronized String zzQh() {
        return this.zzbFs;
    }

    public void zzQk() {
        com.google.android.gms.internal.zzbjf.zzc zznz = this.zzbFn.zznz(this.zzbFl);
        if (zznz != null) {
            zzb(new zzo(this.zzbFg, this.zzrs, new Container(this.mContext, this.zzbFg.getDataLayer(), this.zzbEU, 0, zznz), new C14612(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            zzbo.m4711e(str);
            zzb(zzbN(new Status(10, str, null)));
        }
        this.zzbFt = null;
        this.zzbFn = null;
    }

    public void zzQl() {
        zzaR(false);
    }

    public void zzQm() {
        zzaR(true);
    }

    protected ContainerHolder zzbN(Status status) {
        if (this.zzbFp != null) {
            return this.zzbFp;
        }
        if (status == Status.zzazA) {
            zzbo.m4711e("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    protected /* synthetic */ Result zzc(Status status) {
        return zzbN(status);
    }

    synchronized void zzgW(String str) {
        this.zzbFs = str;
        if (this.zzbFt != null) {
            this.zzbFt.zzgZ(str);
        }
    }
}
