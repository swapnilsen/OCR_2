package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzac;
import com.google.api.client.http.ExponentialBackOffPolicy;
import java.util.Map;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;

@zzme
public class zzji {
    private final Context mContext;
    private final String zzJK;
    private zzpt<zzjf> zzJL;
    private zzpt<zzjf> zzJM;
    @Nullable
    private zzd zzJN;
    private int zzJO;
    private final Object zzrJ;
    private final zzqh zztt;

    /* renamed from: com.google.android.gms.internal.zzji.1 */
    class C12561 implements Runnable {
        final /* synthetic */ zzaw zzJP;
        final /* synthetic */ zzd zzJQ;
        final /* synthetic */ zzji zzJR;

        /* renamed from: com.google.android.gms.internal.zzji.1.1 */
        class C12511 implements com.google.android.gms.internal.zzjf.zza {
            final /* synthetic */ zzjf zzJS;
            final /* synthetic */ C12561 zzJT;

            /* renamed from: com.google.android.gms.internal.zzji.1.1.1 */
            class C12501 implements Runnable {
                final /* synthetic */ C12511 zzJU;

                /* renamed from: com.google.android.gms.internal.zzji.1.1.1.1 */
                class C12491 implements Runnable {
                    final /* synthetic */ C12501 zzJV;

                    C12491(C12501 c12501) {
                        this.zzJV = c12501;
                    }

                    public void run() {
                        this.zzJV.zzJU.zzJS.destroy();
                    }
                }

                C12501(C12511 c12511) {
                    this.zzJU = c12511;
                }

                public void run() {
                    synchronized (this.zzJU.zzJT.zzJR.zzrJ) {
                        if (this.zzJU.zzJT.zzJQ.getStatus() == -1 || this.zzJU.zzJT.zzJQ.getStatus() == 1) {
                            return;
                        }
                        this.zzJU.zzJT.zzJQ.reject();
                        zzw.zzcM().runOnUiThread(new C12491(this));
                        zzpk.m4709v("Could not receive loaded message in a timely manner. Rejecting.");
                    }
                }
            }

            C12511(C12561 c12561, zzjf com_google_android_gms_internal_zzjf) {
                this.zzJT = c12561;
                this.zzJS = com_google_android_gms_internal_zzjf;
            }

            public void zzgN() {
                zzpo.zzXC.postDelayed(new C12501(this), (long) zza.zzKa);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzji.1.2 */
        class C12522 implements zzid {
            final /* synthetic */ zzjf zzJS;
            final /* synthetic */ C12561 zzJT;

            C12522(C12561 c12561, zzjf com_google_android_gms_internal_zzjf) {
                this.zzJT = c12561;
                this.zzJS = com_google_android_gms_internal_zzjf;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                synchronized (this.zzJT.zzJR.zzrJ) {
                    if (this.zzJT.zzJQ.getStatus() == -1 || this.zzJT.zzJQ.getStatus() == 1) {
                        return;
                    }
                    this.zzJT.zzJR.zzJO = 0;
                    this.zzJT.zzJR.zzJL.zzd(this.zzJS);
                    this.zzJT.zzJQ.zzg(this.zzJS);
                    this.zzJT.zzJR.zzJN = this.zzJT.zzJQ;
                    zzpk.m4709v("Successfully loaded JS Engine.");
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzji.1.3 */
        class C12533 implements zzid {
            final /* synthetic */ zzjf zzJS;
            final /* synthetic */ C12561 zzJT;
            final /* synthetic */ zzqa zzJW;

            C12533(C12561 c12561, zzjf com_google_android_gms_internal_zzjf, zzqa com_google_android_gms_internal_zzqa) {
                this.zzJT = c12561;
                this.zzJS = com_google_android_gms_internal_zzjf;
                this.zzJW = com_google_android_gms_internal_zzqa;
            }

            public void zza(zzqw com_google_android_gms_internal_zzqw, Map<String, String> map) {
                synchronized (this.zzJT.zzJR.zzrJ) {
                    zzqf.zzbg("JS Engine is requesting an update");
                    if (this.zzJT.zzJR.zzJO == 0) {
                        zzqf.zzbg("Starting reload.");
                        this.zzJT.zzJR.zzJO = 2;
                        this.zzJT.zzJR.zzb(this.zzJT.zzJP);
                    }
                    this.zzJS.zzb("/requestReload", (zzid) this.zzJW.get());
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzji.1.4 */
        class C12554 implements Runnable {
            final /* synthetic */ zzjf zzJS;
            final /* synthetic */ C12561 zzJT;

            /* renamed from: com.google.android.gms.internal.zzji.1.4.1 */
            class C12541 implements Runnable {
                final /* synthetic */ C12554 zzJX;

                C12541(C12554 c12554) {
                    this.zzJX = c12554;
                }

                public void run() {
                    this.zzJX.zzJS.destroy();
                }
            }

            C12554(C12561 c12561, zzjf com_google_android_gms_internal_zzjf) {
                this.zzJT = c12561;
                this.zzJS = com_google_android_gms_internal_zzjf;
            }

            public void run() {
                synchronized (this.zzJT.zzJR.zzrJ) {
                    if (this.zzJT.zzJQ.getStatus() == -1 || this.zzJT.zzJQ.getStatus() == 1) {
                        return;
                    }
                    this.zzJT.zzJQ.reject();
                    zzw.zzcM().runOnUiThread(new C12541(this));
                    zzpk.m4709v("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }

        C12561(zzji com_google_android_gms_internal_zzji, zzaw com_google_android_gms_internal_zzaw, zzd com_google_android_gms_internal_zzji_zzd) {
            this.zzJR = com_google_android_gms_internal_zzji;
            this.zzJP = com_google_android_gms_internal_zzaw;
            this.zzJQ = com_google_android_gms_internal_zzji_zzd;
        }

        public void run() {
            zzjf zza = this.zzJR.zza(this.zzJR.mContext, this.zzJR.zztt, this.zzJP);
            zza.zza(new C12511(this, zza));
            zza.zza("/jsLoaded", new C12522(this, zza));
            zzqa com_google_android_gms_internal_zzqa = new zzqa();
            zzid c12533 = new C12533(this, zza, com_google_android_gms_internal_zzqa);
            com_google_android_gms_internal_zzqa.set(c12533);
            zza.zza("/requestReload", c12533);
            if (this.zzJR.zzJK.endsWith(".js")) {
                zza.zzam(this.zzJR.zzJK);
            } else if (this.zzJR.zzJK.startsWith("<html>")) {
                zza.zzao(this.zzJR.zzJK);
            } else {
                zza.zzan(this.zzJR.zzJK);
            }
            zzpo.zzXC.postDelayed(new C12554(this, zza), (long) zza.zzJZ);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzji.2 */
    class C12572 implements com.google.android.gms.internal.zzqp.zzc<zzjf> {
        final /* synthetic */ zzji zzJR;
        final /* synthetic */ zzd zzJY;

        C12572(zzji com_google_android_gms_internal_zzji, zzd com_google_android_gms_internal_zzji_zzd) {
            this.zzJR = com_google_android_gms_internal_zzji;
            this.zzJY = com_google_android_gms_internal_zzji_zzd;
        }

        public void zza(zzjf com_google_android_gms_internal_zzjf) {
            synchronized (this.zzJR.zzrJ) {
                this.zzJR.zzJO = 0;
                if (!(this.zzJR.zzJN == null || this.zzJY == this.zzJR.zzJN)) {
                    zzpk.m4709v("New JS engine is loaded, marking previous one as destroyable.");
                    this.zzJR.zzJN.zzgR();
                }
                this.zzJR.zzJN = this.zzJY;
            }
        }

        public /* synthetic */ void zzd(Object obj) {
            zza((zzjf) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzji.3 */
    class C12583 implements com.google.android.gms.internal.zzqp.zza {
        final /* synthetic */ zzji zzJR;
        final /* synthetic */ zzd zzJY;

        C12583(zzji com_google_android_gms_internal_zzji, zzd com_google_android_gms_internal_zzji_zzd) {
            this.zzJR = com_google_android_gms_internal_zzji;
            this.zzJY = com_google_android_gms_internal_zzji_zzd;
        }

        public void run() {
            synchronized (this.zzJR.zzrJ) {
                this.zzJR.zzJO = 1;
                zzpk.m4709v("Failed loading new engine. Marking new engine destroyable.");
                this.zzJY.zzgR();
            }
        }
    }

    static class zza {
        static int zzJZ;
        static int zzKa;

        static {
            zzJZ = ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS;
            zzKa = AbstractSpiCall.DEFAULT_TIMEOUT;
        }
    }

    public static class zzb<T> implements zzpt<T> {
        public void zzd(T t) {
        }
    }

    public static class zzc extends zzqq<zzjj> {
        private final zzd zzKb;
        private boolean zzKc;
        private final Object zzrJ;

        /* renamed from: com.google.android.gms.internal.zzji.zzc.1 */
        class C12591 implements com.google.android.gms.internal.zzqp.zzc<zzjj> {
            C12591(zzc com_google_android_gms_internal_zzji_zzc) {
            }

            public void zzb(zzjj com_google_android_gms_internal_zzjj) {
                zzpk.m4709v("Ending javascript session.");
                ((zzjk) com_google_android_gms_internal_zzjj).zzgT();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjj) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzji.zzc.2 */
        class C12602 implements com.google.android.gms.internal.zzqp.zzc<zzjj> {
            final /* synthetic */ zzc zzKd;

            C12602(zzc com_google_android_gms_internal_zzji_zzc) {
                this.zzKd = com_google_android_gms_internal_zzji_zzc;
            }

            public void zzb(zzjj com_google_android_gms_internal_zzjj) {
                zzpk.m4709v("Releasing engine reference.");
                this.zzKd.zzKb.zzgQ();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjj) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzji.zzc.3 */
        class C12613 implements com.google.android.gms.internal.zzqp.zza {
            final /* synthetic */ zzc zzKd;

            C12613(zzc com_google_android_gms_internal_zzji_zzc) {
                this.zzKd = com_google_android_gms_internal_zzji_zzc;
            }

            public void run() {
                this.zzKd.zzKb.zzgQ();
            }
        }

        public zzc(zzd com_google_android_gms_internal_zzji_zzd) {
            this.zzrJ = new Object();
            this.zzKb = com_google_android_gms_internal_zzji_zzd;
        }

        public void release() {
            synchronized (this.zzrJ) {
                if (this.zzKc) {
                    return;
                }
                this.zzKc = true;
                zza(new C12591(this), new com.google.android.gms.internal.zzqp.zzb());
                zza(new C12602(this), new C12613(this));
            }
        }
    }

    public static class zzd extends zzqq<zzjf> {
        private zzpt<zzjf> zzJM;
        private boolean zzKe;
        private int zzKf;
        private final Object zzrJ;

        /* renamed from: com.google.android.gms.internal.zzji.zzd.1 */
        class C12621 implements com.google.android.gms.internal.zzqp.zzc<zzjf> {
            final /* synthetic */ zzc zzKg;

            C12621(zzd com_google_android_gms_internal_zzji_zzd, zzc com_google_android_gms_internal_zzji_zzc) {
                this.zzKg = com_google_android_gms_internal_zzji_zzc;
            }

            public void zza(zzjf com_google_android_gms_internal_zzjf) {
                zzpk.m4709v("Getting a new session for JS Engine.");
                this.zzKg.zzg(com_google_android_gms_internal_zzjf.zzgM());
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzjf) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzji.zzd.2 */
        class C12632 implements com.google.android.gms.internal.zzqp.zza {
            final /* synthetic */ zzc zzKg;

            C12632(zzd com_google_android_gms_internal_zzji_zzd, zzc com_google_android_gms_internal_zzji_zzc) {
                this.zzKg = com_google_android_gms_internal_zzji_zzc;
            }

            public void run() {
                zzpk.m4709v("Rejecting reference for JS Engine.");
                this.zzKg.reject();
            }
        }

        /* renamed from: com.google.android.gms.internal.zzji.zzd.3 */
        class C12653 implements com.google.android.gms.internal.zzqp.zzc<zzjf> {
            final /* synthetic */ zzd zzKh;

            /* renamed from: com.google.android.gms.internal.zzji.zzd.3.1 */
            class C12641 implements Runnable {
                final /* synthetic */ zzjf zzKi;
                final /* synthetic */ C12653 zzKj;

                C12641(C12653 c12653, zzjf com_google_android_gms_internal_zzjf) {
                    this.zzKj = c12653;
                    this.zzKi = com_google_android_gms_internal_zzjf;
                }

                public void run() {
                    this.zzKj.zzKh.zzJM.zzd(this.zzKi);
                    this.zzKi.destroy();
                }
            }

            C12653(zzd com_google_android_gms_internal_zzji_zzd) {
                this.zzKh = com_google_android_gms_internal_zzji_zzd;
            }

            public void zza(zzjf com_google_android_gms_internal_zzjf) {
                zzw.zzcM().runOnUiThread(new C12641(this, com_google_android_gms_internal_zzjf));
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzjf) obj);
            }
        }

        public zzd(zzpt<zzjf> com_google_android_gms_internal_zzpt_com_google_android_gms_internal_zzjf) {
            this.zzrJ = new Object();
            this.zzJM = com_google_android_gms_internal_zzpt_com_google_android_gms_internal_zzjf;
            this.zzKe = false;
            this.zzKf = 0;
        }

        public zzc zzgP() {
            zzc com_google_android_gms_internal_zzji_zzc = new zzc(this);
            synchronized (this.zzrJ) {
                zza(new C12621(this, com_google_android_gms_internal_zzji_zzc), new C12632(this, com_google_android_gms_internal_zzji_zzc));
                zzac.zzaw(this.zzKf >= 0);
                this.zzKf++;
            }
            return com_google_android_gms_internal_zzji_zzc;
        }

        protected void zzgQ() {
            boolean z = true;
            synchronized (this.zzrJ) {
                if (this.zzKf < 1) {
                    z = false;
                }
                zzac.zzaw(z);
                zzpk.m4709v("Releasing 1 reference for JS Engine");
                this.zzKf--;
                zzgS();
            }
        }

        public void zzgR() {
            boolean z = true;
            synchronized (this.zzrJ) {
                if (this.zzKf < 0) {
                    z = false;
                }
                zzac.zzaw(z);
                zzpk.m4709v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzKe = true;
                zzgS();
            }
        }

        protected void zzgS() {
            synchronized (this.zzrJ) {
                zzac.zzaw(this.zzKf >= 0);
                if (this.zzKe && this.zzKf == 0) {
                    zzpk.m4709v("No reference is left (including root). Cleaning up engine.");
                    zza(new C12653(this), new com.google.android.gms.internal.zzqp.zzb());
                } else {
                    zzpk.m4709v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public static class zze extends zzqq<zzjj> {
        private zzc zzKk;

        public zze(zzc com_google_android_gms_internal_zzji_zzc) {
            this.zzKk = com_google_android_gms_internal_zzji_zzc;
        }

        public void finalize() {
            this.zzKk.release();
            this.zzKk = null;
        }

        public int getStatus() {
            return this.zzKk.getStatus();
        }

        public void reject() {
            this.zzKk.reject();
        }

        public void zza(com.google.android.gms.internal.zzqp.zzc<zzjj> com_google_android_gms_internal_zzqp_zzc_com_google_android_gms_internal_zzjj, com.google.android.gms.internal.zzqp.zza com_google_android_gms_internal_zzqp_zza) {
            this.zzKk.zza(com_google_android_gms_internal_zzqp_zzc_com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zzqp_zza);
        }

        public /* synthetic */ void zzg(Object obj) {
            zzj((zzjj) obj);
        }

        public void zzj(zzjj com_google_android_gms_internal_zzjj) {
            this.zzKk.zzg(com_google_android_gms_internal_zzjj);
        }
    }

    public zzji(Context context, zzqh com_google_android_gms_internal_zzqh, String str) {
        this.zzrJ = new Object();
        this.zzJO = 1;
        this.zzJK = str;
        this.mContext = context.getApplicationContext();
        this.zztt = com_google_android_gms_internal_zzqh;
        this.zzJL = new zzb();
        this.zzJM = new zzb();
    }

    public zzji(Context context, zzqh com_google_android_gms_internal_zzqh, String str, zzpt<zzjf> com_google_android_gms_internal_zzpt_com_google_android_gms_internal_zzjf, zzpt<zzjf> com_google_android_gms_internal_zzpt_com_google_android_gms_internal_zzjf2) {
        this(context, com_google_android_gms_internal_zzqh, str);
        this.zzJL = com_google_android_gms_internal_zzpt_com_google_android_gms_internal_zzjf;
        this.zzJM = com_google_android_gms_internal_zzpt_com_google_android_gms_internal_zzjf2;
    }

    private zzd zza(@Nullable zzaw com_google_android_gms_internal_zzaw) {
        zzd com_google_android_gms_internal_zzji_zzd = new zzd(this.zzJM);
        zzw.zzcM().runOnUiThread(new C12561(this, com_google_android_gms_internal_zzaw, com_google_android_gms_internal_zzji_zzd));
        return com_google_android_gms_internal_zzji_zzd;
    }

    protected zzjf zza(Context context, zzqh com_google_android_gms_internal_zzqh, @Nullable zzaw com_google_android_gms_internal_zzaw) {
        return new zzjh(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzaw, null);
    }

    protected zzd zzb(@Nullable zzaw com_google_android_gms_internal_zzaw) {
        zzd zza = zza(com_google_android_gms_internal_zzaw);
        zza.zza(new C12572(this, zza), new C12583(this, zza));
        return zza;
    }

    public zzc zzc(@Nullable zzaw com_google_android_gms_internal_zzaw) {
        zzc zzgP;
        synchronized (this.zzrJ) {
            if (this.zzJN == null || this.zzJN.getStatus() == -1) {
                this.zzJO = 2;
                this.zzJN = zzb(com_google_android_gms_internal_zzaw);
                zzgP = this.zzJN.zzgP();
            } else if (this.zzJO == 0) {
                zzgP = this.zzJN.zzgP();
            } else if (this.zzJO == 1) {
                this.zzJO = 2;
                zzb(com_google_android_gms_internal_zzaw);
                zzgP = this.zzJN.zzgP();
            } else if (this.zzJO == 2) {
                zzgP = this.zzJN.zzgP();
            } else {
                zzgP = this.zzJN.zzgP();
            }
        }
        return zzgP;
    }

    public zzc zzgO() {
        return zzc(null);
    }
}
