package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzpb.zza;

@zzme
public class zzoe extends zzpj implements zzog, zzoj {
    private final Context mContext;
    private final String zzKW;
    private final zza zzPR;
    private int zzPY;
    private final zzol zzVr;
    private final zzoj zzVs;
    private final String zzVt;
    private final zzjq zzVu;
    private final long zzVv;
    private int zzVw;
    private zzof zzVx;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.internal.zzoe.1 */
    class C13391 implements Runnable {
        final /* synthetic */ zzkb zzVy;
        final /* synthetic */ zzoe zzVz;
        final /* synthetic */ zzec zztv;

        C13391(zzoe com_google_android_gms_internal_zzoe, zzec com_google_android_gms_internal_zzec, zzkb com_google_android_gms_internal_zzkb) {
            this.zzVz = com_google_android_gms_internal_zzoe;
            this.zztv = com_google_android_gms_internal_zzec;
            this.zzVy = com_google_android_gms_internal_zzkb;
        }

        public void run() {
            this.zzVz.zza(this.zztv, this.zzVy);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzoe.2 */
    class C13402 implements Runnable {
        final /* synthetic */ zzoi zzVA;
        final /* synthetic */ zzkb zzVy;
        final /* synthetic */ zzoe zzVz;
        final /* synthetic */ zzec zztv;

        C13402(zzoe com_google_android_gms_internal_zzoe, zzkb com_google_android_gms_internal_zzkb, zzec com_google_android_gms_internal_zzec, zzoi com_google_android_gms_internal_zzoi) {
            this.zzVz = com_google_android_gms_internal_zzoe;
            this.zzVy = com_google_android_gms_internal_zzkb;
            this.zztv = com_google_android_gms_internal_zzec;
            this.zzVA = com_google_android_gms_internal_zzoi;
        }

        public void run() {
            try {
                this.zzVy.zza(zzd.zzA(this.zzVz.mContext), this.zztv, null, this.zzVA, this.zzVz.zzVt);
            } catch (Throwable e) {
                Throwable th = e;
                String str = "Fail to initialize adapter ";
                String valueOf = String.valueOf(this.zzVz.zzKW);
                zzqf.zzc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
                this.zzVz.zza(this.zzVz.zzKW, 0);
            }
        }
    }

    public zzoe(Context context, String str, String str2, zzjq com_google_android_gms_internal_zzjq, zza com_google_android_gms_internal_zzpb_zza, zzol com_google_android_gms_internal_zzol, zzoj com_google_android_gms_internal_zzoj, long j) {
        this.zzVw = 0;
        this.zzPY = 3;
        this.mContext = context;
        this.zzKW = str;
        this.zzVt = str2;
        this.zzVu = com_google_android_gms_internal_zzjq;
        this.zzPR = com_google_android_gms_internal_zzpb_zza;
        this.zzVr = com_google_android_gms_internal_zzol;
        this.zzrJ = new Object();
        this.zzVs = com_google_android_gms_internal_zzoj;
        this.zzVv = j;
    }

    private void zza(zzec com_google_android_gms_internal_zzec, zzkb com_google_android_gms_internal_zzkb) {
        this.zzVr.zzjO().zza((zzoj) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzKW)) {
                com_google_android_gms_internal_zzkb.zza(com_google_android_gms_internal_zzec, this.zzVt, this.zzVu.zzKn);
            } else {
                com_google_android_gms_internal_zzkb.zzd(com_google_android_gms_internal_zzec, this.zzVt);
            }
        } catch (Throwable e) {
            zzqf.zzc("Fail to load ad from adapter.", e);
            zza(this.zzKW, 0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzk(long r6) {
        /*
        r5 = this;
    L_0x0000:
        r1 = r5.zzrJ;
        monitor-enter(r1);
        r0 = r5.zzVw;	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x003c;
    L_0x0007:
        r0 = new com.google.android.gms.internal.zzof$zza;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        r2 = com.google.android.gms.ads.internal.zzw.zzcS();	 Catch:{ all -> 0x0070 }
        r2 = r2.elapsedRealtime();	 Catch:{ all -> 0x0070 }
        r2 = r2 - r6;
        r2 = r0.zzl(r2);	 Catch:{ all -> 0x0070 }
        r0 = 1;
        r3 = r5.zzVw;	 Catch:{ all -> 0x0070 }
        if (r0 != r3) goto L_0x0039;
    L_0x001e:
        r0 = 6;
    L_0x001f:
        r0 = r2.zzae(r0);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzKW;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaP(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzVu;	 Catch:{ all -> 0x0070 }
        r2 = r2.zzKq;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaQ(r2);	 Catch:{ all -> 0x0070 }
        r0 = r0.zzjK();	 Catch:{ all -> 0x0070 }
        r5.zzVx = r0;	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
    L_0x0038:
        return;
    L_0x0039:
        r0 = r5.zzPY;	 Catch:{ all -> 0x0070 }
        goto L_0x001f;
    L_0x003c:
        r0 = r5.zzf(r6);	 Catch:{ all -> 0x0070 }
        if (r0 != 0) goto L_0x0073;
    L_0x0042:
        r0 = new com.google.android.gms.internal.zzof$zza;	 Catch:{ all -> 0x0070 }
        r0.<init>();	 Catch:{ all -> 0x0070 }
        r2 = r5.zzPY;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzae(r2);	 Catch:{ all -> 0x0070 }
        r2 = com.google.android.gms.ads.internal.zzw.zzcS();	 Catch:{ all -> 0x0070 }
        r2 = r2.elapsedRealtime();	 Catch:{ all -> 0x0070 }
        r2 = r2 - r6;
        r0 = r0.zzl(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzKW;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaP(r2);	 Catch:{ all -> 0x0070 }
        r2 = r5.zzVu;	 Catch:{ all -> 0x0070 }
        r2 = r2.zzKq;	 Catch:{ all -> 0x0070 }
        r0 = r0.zzaQ(r2);	 Catch:{ all -> 0x0070 }
        r0 = r0.zzjK();	 Catch:{ all -> 0x0070 }
        r5.zzVx = r0;	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0038;
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        throw r0;
    L_0x0073:
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoe.zzk(long):void");
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
        synchronized (this.zzrJ) {
            this.zzVw = 2;
            this.zzPY = i;
            this.zzrJ.notify();
        }
    }

    public void zzaO(String str) {
        synchronized (this.zzrJ) {
            this.zzVw = 1;
            this.zzrJ.notify();
        }
    }

    public void zzad(int i) {
        zza(this.zzKW, 0);
    }

    public void zzco() {
        if (this.zzVr != null && this.zzVr.zzjO() != null && this.zzVr.zzjN() != null) {
            zzoi zzjO = this.zzVr.zzjO();
            zzjO.zza(null);
            zzjO.zza((zzog) this);
            zzec com_google_android_gms_internal_zzec = this.zzPR.zzTi.zzRy;
            zzkb zzjN = this.zzVr.zzjN();
            try {
                if (zzjN.isInitialized()) {
                    zzqe.zzYP.post(new C13391(this, com_google_android_gms_internal_zzec, zzjN));
                } else {
                    zzqe.zzYP.post(new C13402(this, zzjN, com_google_android_gms_internal_zzec, zzjO));
                }
            } catch (Throwable e) {
                zzqf.zzc("Fail to check if adapter is initialized.", e);
                zza(this.zzKW, 0);
            }
            zzk(zzw.zzcS().elapsedRealtime());
            zzjO.zza(null);
            zzjO.zza(null);
            if (this.zzVw == 1) {
                this.zzVs.zzaO(this.zzKW);
            } else {
                this.zzVs.zza(this.zzKW, this.zzPY);
            }
        }
    }

    protected boolean zzf(long j) {
        long elapsedRealtime = this.zzVv - (zzw.zzcS().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            this.zzPY = 4;
            return false;
        }
        try {
            this.zzrJ.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.zzPY = 5;
            return false;
        }
    }

    public zzof zzjH() {
        zzof com_google_android_gms_internal_zzof;
        synchronized (this.zzrJ) {
            com_google_android_gms_internal_zzof = this.zzVx;
        }
        return com_google_android_gms_internal_zzof;
    }

    public zzjq zzjI() {
        return this.zzVu;
    }

    public void zzjJ() {
        zza(this.zzPR.zzTi.zzRy, this.zzVr.zzjN());
    }
}
