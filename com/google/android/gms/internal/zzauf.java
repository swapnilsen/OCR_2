package com.google.android.gms.internal;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzy;
import com.google.android.gms.common.zzg;
import com.google.android.gms.common.zzh;
import com.google.android.gms.internal.zzatt.zza;
import com.google.android.gms.measurement.AppMeasurement.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzauf extends zza {
    private final zzaue zzbqc;
    private Boolean zzbuJ;
    @Nullable
    private String zzbuK;

    /* renamed from: com.google.android.gms.internal.zzauf.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzatq zzbuQ;

        AnonymousClass10(zzauf com_google_android_gms_internal_zzauf, zzatq com_google_android_gms_internal_zzatq, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuQ = com_google_android_gms_internal_zzatq;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzb(this.zzbuQ, this.zzbuL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzatq zzbuQ;

        AnonymousClass11(zzauf com_google_android_gms_internal_zzauf, zzatq com_google_android_gms_internal_zzatq, String str) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuQ = com_google_android_gms_internal_zzatq;
            this.zzbkW = str;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzb(this.zzbuQ, this.zzbkW);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.12 */
    class AnonymousClass12 implements Callable<byte[]> {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzatq zzbuQ;

        AnonymousClass12(zzauf com_google_android_gms_internal_zzauf, zzatq com_google_android_gms_internal_zzatq, String str) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuQ = com_google_android_gms_internal_zzatq;
            this.zzbkW = str;
        }

        public /* synthetic */ Object call() {
            return zzMO();
        }

        public byte[] zzMO() {
            this.zzbuM.zzbqc.zzML();
            return this.zzbuM.zzbqc.zza(this.zzbuQ, this.zzbkW);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.13 */
    class AnonymousClass13 implements Runnable {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzauq zzbuR;

        AnonymousClass13(zzauf com_google_android_gms_internal_zzauf, zzauq com_google_android_gms_internal_zzauq, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuR = com_google_android_gms_internal_zzauq;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzc(this.zzbuR, this.zzbuL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.14 */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzauq zzbuR;

        AnonymousClass14(zzauf com_google_android_gms_internal_zzauf, zzauq com_google_android_gms_internal_zzauq, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuR = com_google_android_gms_internal_zzauq;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzb(this.zzbuR, this.zzbuL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.15 */
    class AnonymousClass15 implements Callable<List<zzaus>> {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;

        AnonymousClass15(zzauf com_google_android_gms_internal_zzauf, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public /* synthetic */ Object call() {
            return zzMN();
        }

        public List<zzaus> zzMN() {
            this.zzbuM.zzbqc.zzML();
            return this.zzbuM.zzbqc.zzKg().zzft(this.zzbuL.packageName);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.16 */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;

        AnonymousClass16(zzauf com_google_android_gms_internal_zzauf, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zze(this.zzbuL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.17 */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ String zzbuS;
        final /* synthetic */ String zzbuT;
        final /* synthetic */ long zzbuU;

        AnonymousClass17(zzauf com_google_android_gms_internal_zzauf, String str, String str2, String str3, long j) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuS = str;
            this.zzbkW = str2;
            this.zzbuT = str3;
            this.zzbuU = j;
        }

        public void run() {
            if (this.zzbuS == null) {
                this.zzbuM.zzbqc.zzKe().zza(this.zzbkW, null);
                return;
            }
            zzf com_google_android_gms_measurement_AppMeasurement_zzf = new zzf();
            com_google_android_gms_measurement_AppMeasurement_zzf.zzbqf = this.zzbuT;
            com_google_android_gms_measurement_AppMeasurement_zzf.zzbqg = this.zzbuS;
            com_google_android_gms_measurement_AppMeasurement_zzf.zzbqh = this.zzbuU;
            this.zzbuM.zzbqc.zzKe().zza(this.zzbkW, com_google_android_gms_measurement_AppMeasurement_zzf);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.1 */
    class C10731 implements Runnable {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;

        C10731(zzauf com_google_android_gms_internal_zzauf, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzd(this.zzbuL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.2 */
    class C10742 implements Runnable {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzatg zzbuN;

        C10742(zzauf com_google_android_gms_internal_zzauf, zzatg com_google_android_gms_internal_zzatg, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuN = com_google_android_gms_internal_zzatg;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzc(this.zzbuN, this.zzbuL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.3 */
    class C10753 implements Runnable {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzatg zzbuN;

        C10753(zzauf com_google_android_gms_internal_zzauf, zzatg com_google_android_gms_internal_zzatg, zzatd com_google_android_gms_internal_zzatd) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuN = com_google_android_gms_internal_zzatg;
            this.zzbuL = com_google_android_gms_internal_zzatd;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzb(this.zzbuN, this.zzbuL);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.4 */
    class C10764 implements Runnable {
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzatg zzbuN;

        C10764(zzauf com_google_android_gms_internal_zzauf, zzatg com_google_android_gms_internal_zzatg) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuN = com_google_android_gms_internal_zzatg;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zze(this.zzbuN);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.5 */
    class C10775 implements Runnable {
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ zzatg zzbuN;

        C10775(zzauf com_google_android_gms_internal_zzauf, zzatg com_google_android_gms_internal_zzatg) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuN = com_google_android_gms_internal_zzatg;
        }

        public void run() {
            this.zzbuM.zzbqc.zzML();
            this.zzbuM.zzbqc.zzd(this.zzbuN);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.6 */
    class C10786 implements Callable<List<zzaus>> {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;

        C10786(zzauf com_google_android_gms_internal_zzauf, zzatd com_google_android_gms_internal_zzatd, String str, String str2) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuL = com_google_android_gms_internal_zzatd;
            this.zzbuO = str;
            this.zzbuP = str2;
        }

        public /* synthetic */ Object call() {
            return zzMN();
        }

        public List<zzaus> zzMN() {
            this.zzbuM.zzbqc.zzML();
            return this.zzbuM.zzbqc.zzKg().zzk(this.zzbuL.packageName, this.zzbuO, this.zzbuP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.7 */
    class C10797 implements Callable<List<zzaus>> {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;

        C10797(zzauf com_google_android_gms_internal_zzauf, String str, String str2, String str3) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbkW = str;
            this.zzbuO = str2;
            this.zzbuP = str3;
        }

        public /* synthetic */ Object call() {
            return zzMN();
        }

        public List<zzaus> zzMN() {
            this.zzbuM.zzbqc.zzML();
            return this.zzbuM.zzbqc.zzKg().zzk(this.zzbkW, this.zzbuO, this.zzbuP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.8 */
    class C10808 implements Callable<List<zzatg>> {
        final /* synthetic */ zzatd zzbuL;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;

        C10808(zzauf com_google_android_gms_internal_zzauf, zzatd com_google_android_gms_internal_zzatd, String str, String str2) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbuL = com_google_android_gms_internal_zzatd;
            this.zzbuO = str;
            this.zzbuP = str2;
        }

        public /* synthetic */ Object call() {
            return zzMN();
        }

        public List<zzatg> zzMN() {
            this.zzbuM.zzbqc.zzML();
            return this.zzbuM.zzbqc.zzKg().zzl(this.zzbuL.packageName, this.zzbuO, this.zzbuP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzauf.9 */
    class C10819 implements Callable<List<zzatg>> {
        final /* synthetic */ String zzbkW;
        final /* synthetic */ zzauf zzbuM;
        final /* synthetic */ String zzbuO;
        final /* synthetic */ String zzbuP;

        C10819(zzauf com_google_android_gms_internal_zzauf, String str, String str2, String str3) {
            this.zzbuM = com_google_android_gms_internal_zzauf;
            this.zzbkW = str;
            this.zzbuO = str2;
            this.zzbuP = str3;
        }

        public /* synthetic */ Object call() {
            return zzMN();
        }

        public List<zzatg> zzMN() {
            this.zzbuM.zzbqc.zzML();
            return this.zzbuM.zzbqc.zzKg().zzl(this.zzbkW, this.zzbuO, this.zzbuP);
        }
    }

    public zzauf(zzaue com_google_android_gms_internal_zzaue) {
        this(com_google_android_gms_internal_zzaue, null);
    }

    public zzauf(zzaue com_google_android_gms_internal_zzaue, @Nullable String str) {
        zzac.zzw(com_google_android_gms_internal_zzaue);
        this.zzbqc = com_google_android_gms_internal_zzaue;
        this.zzbuK = str;
    }

    @BinderThread
    private void zzb(zzatd com_google_android_gms_internal_zzatd, boolean z) {
        zzac.zzw(com_google_android_gms_internal_zzatd);
        zzm(com_google_android_gms_internal_zzatd.packageName, z);
        this.zzbqc.zzKh().zzga(com_google_android_gms_internal_zzatd.zzbqL);
    }

    @BinderThread
    private void zzm(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zzbqc.zzKl().zzLY().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            zzn(str, z);
        } catch (SecurityException e) {
            this.zzbqc.zzKl().zzLY().zzj("Measurement Service called with invalid calling package. appId", zzatx.zzfE(str));
            throw e;
        }
    }

    @BinderThread
    public List<zzauq> zza(zzatd com_google_android_gms_internal_zzatd, boolean z) {
        Object e;
        zzb(com_google_android_gms_internal_zzatd, false);
        try {
            List<zzaus> list = (List) this.zzbqc.zzKk().zzd(new AnonymousClass15(this, com_google_android_gms_internal_zzatd)).get();
            List<zzauq> arrayList = new ArrayList(list.size());
            for (zzaus com_google_android_gms_internal_zzaus : list) {
                if (z || !zzaut.zzgd(com_google_android_gms_internal_zzaus.mName)) {
                    arrayList.add(new zzauq(com_google_android_gms_internal_zzaus));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzbqc.zzKl().zzLY().zze("Failed to get user attributes. appId", zzatx.zzfE(com_google_android_gms_internal_zzatd.packageName), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.zzbqc.zzKl().zzLY().zze("Failed to get user attributes. appId", zzatx.zzfE(com_google_android_gms_internal_zzatd.packageName), e);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.BinderThread
    public java.util.List<com.google.android.gms.internal.zzatg> zza(java.lang.String r4, java.lang.String r5, com.google.android.gms.internal.zzatd r6) {
        /*
        r3 = this;
        r0 = 0;
        r3.zzb(r6, r0);
        r0 = r3.zzbqc;
        r0 = r0.zzKk();
        r1 = new com.google.android.gms.internal.zzauf$8;
        r1.<init>(r3, r6, r4, r5);
        r0 = r0.zzd(r1);
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x001a, ExecutionException -> 0x002f }
        r0 = (java.util.List) r0;	 Catch:{ InterruptedException -> 0x001a, ExecutionException -> 0x002f }
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = move-exception;
    L_0x001b:
        r1 = r3.zzbqc;
        r1 = r1.zzKl();
        r1 = r1.zzLY();
        r2 = "Failed to get conditional user properties";
        r1.zzj(r2, r0);
        r0 = java.util.Collections.emptyList();
        goto L_0x0019;
    L_0x002f:
        r0 = move-exception;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzauf.zza(java.lang.String, java.lang.String, com.google.android.gms.internal.zzatd):java.util.List<com.google.android.gms.internal.zzatg>");
    }

    @BinderThread
    public List<zzauq> zza(String str, String str2, String str3, boolean z) {
        Object e;
        zzm(str, true);
        try {
            List<zzaus> list = (List) this.zzbqc.zzKk().zzd(new C10797(this, str, str2, str3)).get();
            List<zzauq> arrayList = new ArrayList(list.size());
            for (zzaus com_google_android_gms_internal_zzaus : list) {
                if (z || !zzaut.zzgd(com_google_android_gms_internal_zzaus.mName)) {
                    arrayList.add(new zzauq(com_google_android_gms_internal_zzaus));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzbqc.zzKl().zzLY().zze("Failed to get user attributes. appId", zzatx.zzfE(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.zzbqc.zzKl().zzLY().zze("Failed to get user attributes. appId", zzatx.zzfE(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public List<zzauq> zza(String str, String str2, boolean z, zzatd com_google_android_gms_internal_zzatd) {
        Object e;
        zzb(com_google_android_gms_internal_zzatd, false);
        try {
            List<zzaus> list = (List) this.zzbqc.zzKk().zzd(new C10786(this, com_google_android_gms_internal_zzatd, str, str2)).get();
            List<zzauq> arrayList = new ArrayList(list.size());
            for (zzaus com_google_android_gms_internal_zzaus : list) {
                if (z || !zzaut.zzgd(com_google_android_gms_internal_zzaus.mName)) {
                    arrayList.add(new zzauq(com_google_android_gms_internal_zzaus));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzbqc.zzKl().zzLY().zze("Failed to get user attributes. appId", zzatx.zzfE(com_google_android_gms_internal_zzatd.packageName), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.zzbqc.zzKl().zzLY().zze("Failed to get user attributes. appId", zzatx.zzfE(com_google_android_gms_internal_zzatd.packageName), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public void zza(long j, String str, String str2, String str3) {
        this.zzbqc.zzKk().zzm(new AnonymousClass17(this, str2, str3, str, j));
    }

    @BinderThread
    public void zza(zzatd com_google_android_gms_internal_zzatd) {
        zzb(com_google_android_gms_internal_zzatd, false);
        this.zzbqc.zzKk().zzm(new AnonymousClass16(this, com_google_android_gms_internal_zzatd));
    }

    @BinderThread
    public void zza(zzatg com_google_android_gms_internal_zzatg, zzatd com_google_android_gms_internal_zzatd) {
        zzac.zzw(com_google_android_gms_internal_zzatg);
        zzac.zzw(com_google_android_gms_internal_zzatg.zzbqW);
        zzb(com_google_android_gms_internal_zzatd, false);
        zzatg com_google_android_gms_internal_zzatg2 = new zzatg(com_google_android_gms_internal_zzatg);
        com_google_android_gms_internal_zzatg2.packageName = com_google_android_gms_internal_zzatd.packageName;
        if (com_google_android_gms_internal_zzatg.zzbqW.getValue() == null) {
            this.zzbqc.zzKk().zzm(new C10742(this, com_google_android_gms_internal_zzatg2, com_google_android_gms_internal_zzatd));
        } else {
            this.zzbqc.zzKk().zzm(new C10753(this, com_google_android_gms_internal_zzatg2, com_google_android_gms_internal_zzatd));
        }
    }

    @BinderThread
    public void zza(zzatq com_google_android_gms_internal_zzatq, zzatd com_google_android_gms_internal_zzatd) {
        zzac.zzw(com_google_android_gms_internal_zzatq);
        zzb(com_google_android_gms_internal_zzatd, false);
        this.zzbqc.zzKk().zzm(new AnonymousClass10(this, com_google_android_gms_internal_zzatq, com_google_android_gms_internal_zzatd));
    }

    @BinderThread
    public void zza(zzatq com_google_android_gms_internal_zzatq, String str, String str2) {
        zzac.zzw(com_google_android_gms_internal_zzatq);
        zzac.zzdr(str);
        zzm(str, true);
        this.zzbqc.zzKk().zzm(new AnonymousClass11(this, com_google_android_gms_internal_zzatq, str));
    }

    @BinderThread
    public void zza(zzauq com_google_android_gms_internal_zzauq, zzatd com_google_android_gms_internal_zzatd) {
        zzac.zzw(com_google_android_gms_internal_zzauq);
        zzb(com_google_android_gms_internal_zzatd, false);
        if (com_google_android_gms_internal_zzauq.getValue() == null) {
            this.zzbqc.zzKk().zzm(new AnonymousClass13(this, com_google_android_gms_internal_zzauq, com_google_android_gms_internal_zzatd));
        } else {
            this.zzbqc.zzKk().zzm(new AnonymousClass14(this, com_google_android_gms_internal_zzauq, com_google_android_gms_internal_zzatd));
        }
    }

    @BinderThread
    public byte[] zza(zzatq com_google_android_gms_internal_zzatq, String str) {
        Object e;
        zzac.zzdr(str);
        zzac.zzw(com_google_android_gms_internal_zzatq);
        zzm(str, true);
        this.zzbqc.zzKl().zzMd().zzj("Log and bundle. event", com_google_android_gms_internal_zzatq.name);
        long nanoTime = this.zzbqc.zznR().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzbqc.zzKk().zze(new AnonymousClass12(this, com_google_android_gms_internal_zzatq, str)).get();
            if (bArr == null) {
                this.zzbqc.zzKl().zzLY().zzj("Log and bundle returned null. appId", zzatx.zzfE(str));
                bArr = new byte[0];
            }
            this.zzbqc.zzKl().zzMd().zzd("Log and bundle processed. event, size, time_ms", com_google_android_gms_internal_zzatq.name, Integer.valueOf(bArr.length), Long.valueOf((this.zzbqc.zznR().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzbqc.zzKl().zzLY().zzd("Failed to log and bundle. appId, event, error", zzatx.zzfE(str), com_google_android_gms_internal_zzatq.name, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.zzbqc.zzKl().zzLY().zzd("Failed to log and bundle. appId, event, error", zzatx.zzfE(str), com_google_android_gms_internal_zzatq.name, e);
            return null;
        }
    }

    @BinderThread
    public void zzb(zzatd com_google_android_gms_internal_zzatd) {
        zzb(com_google_android_gms_internal_zzatd, false);
        this.zzbqc.zzKk().zzm(new C10731(this, com_google_android_gms_internal_zzatd));
    }

    @BinderThread
    public void zzb(zzatg com_google_android_gms_internal_zzatg) {
        zzac.zzw(com_google_android_gms_internal_zzatg);
        zzac.zzw(com_google_android_gms_internal_zzatg.zzbqW);
        zzm(com_google_android_gms_internal_zzatg.packageName, true);
        zzatg com_google_android_gms_internal_zzatg2 = new zzatg(com_google_android_gms_internal_zzatg);
        if (com_google_android_gms_internal_zzatg.zzbqW.getValue() == null) {
            this.zzbqc.zzKk().zzm(new C10764(this, com_google_android_gms_internal_zzatg2));
        } else {
            this.zzbqc.zzKk().zzm(new C10775(this, com_google_android_gms_internal_zzatg2));
        }
    }

    @BinderThread
    public String zzc(zzatd com_google_android_gms_internal_zzatd) {
        zzb(com_google_android_gms_internal_zzatd, false);
        return this.zzbqc.zzfP(com_google_android_gms_internal_zzatd.packageName);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.BinderThread
    public java.util.List<com.google.android.gms.internal.zzatg> zzn(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
        r3 = this;
        r0 = 1;
        r3.zzm(r4, r0);
        r0 = r3.zzbqc;
        r0 = r0.zzKk();
        r1 = new com.google.android.gms.internal.zzauf$9;
        r1.<init>(r3, r4, r5, r6);
        r0 = r0.zzd(r1);
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x001a, ExecutionException -> 0x002f }
        r0 = (java.util.List) r0;	 Catch:{ InterruptedException -> 0x001a, ExecutionException -> 0x002f }
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = move-exception;
    L_0x001b:
        r1 = r3.zzbqc;
        r1 = r1.zzKl();
        r1 = r1.zzLY();
        r2 = "Failed to get conditional user properties";
        r1.zzj(r2, r0);
        r0 = java.util.Collections.emptyList();
        goto L_0x0019;
    L_0x002f:
        r0 = move-exception;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzauf.zzn(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.zzatg>");
    }

    protected void zzn(String str, boolean z) {
        if (z) {
            if (this.zzbuJ == null) {
                boolean z2 = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(this.zzbuK) || zzy.zzf(this.zzbqc.getContext(), Binder.getCallingUid()) || zzh.zzaN(this.zzbqc.getContext()).zza(this.zzbqc.getContext().getPackageManager(), Binder.getCallingUid());
                this.zzbuJ = Boolean.valueOf(z2);
            }
            if (this.zzbuJ.booleanValue()) {
                return;
            }
        }
        if (this.zzbuK == null && zzg.zzc(this.zzbqc.getContext(), Binder.getCallingUid(), str)) {
            this.zzbuK = str;
        }
        if (!str.equals(this.zzbuK)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }
}
