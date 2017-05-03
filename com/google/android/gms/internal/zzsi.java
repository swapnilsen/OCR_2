package com.google.android.gms.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zze;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class zzsi extends zzsa {
    private boolean mStarted;
    private final zzsg zzaeA;
    private final zztf zzaeB;
    private final zzte zzaeC;
    private final zzsf zzaeD;
    private long zzaeE;
    private final zzsr zzaeF;
    private final zzsr zzaeG;
    private final zztj zzaeH;
    private long zzaeI;
    private boolean zzaeJ;

    /* renamed from: com.google.android.gms.internal.zzsi.1 */
    class C14111 extends zzsr {
        final /* synthetic */ zzsi zzaeK;

        C14111(zzsi com_google_android_gms_internal_zzsi, zzsc com_google_android_gms_internal_zzsc) {
            this.zzaeK = com_google_android_gms_internal_zzsi;
            super(com_google_android_gms_internal_zzsc);
        }

        public void run() {
            this.zzaeK.zzoB();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsi.2 */
    class C14122 extends zzsr {
        final /* synthetic */ zzsi zzaeK;

        C14122(zzsi com_google_android_gms_internal_zzsi, zzsc com_google_android_gms_internal_zzsc) {
            this.zzaeK = com_google_android_gms_internal_zzsi;
            super(com_google_android_gms_internal_zzsc);
        }

        public void run() {
            this.zzaeK.zzoC();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsi.3 */
    class C14133 implements Runnable {
        final /* synthetic */ zzsi zzaeK;

        C14133(zzsi com_google_android_gms_internal_zzsi) {
            this.zzaeK = com_google_android_gms_internal_zzsi;
        }

        public void run() {
            this.zzaeK.zzoA();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsi.4 */
    class C14144 implements zzsu {
        final /* synthetic */ zzsi zzaeK;

        C14144(zzsi com_google_android_gms_internal_zzsi) {
            this.zzaeK = com_google_android_gms_internal_zzsi;
        }

        public void zzf(Throwable th) {
            this.zzaeK.zzoH();
        }
    }

    protected zzsi(zzsc com_google_android_gms_internal_zzsc, zzsd com_google_android_gms_internal_zzsd) {
        super(com_google_android_gms_internal_zzsc);
        zzac.zzw(com_google_android_gms_internal_zzsd);
        this.zzaeE = Long.MIN_VALUE;
        this.zzaeC = com_google_android_gms_internal_zzsd.zzk(com_google_android_gms_internal_zzsc);
        this.zzaeA = com_google_android_gms_internal_zzsd.zzm(com_google_android_gms_internal_zzsc);
        this.zzaeB = com_google_android_gms_internal_zzsd.zzn(com_google_android_gms_internal_zzsc);
        this.zzaeD = com_google_android_gms_internal_zzsd.zzo(com_google_android_gms_internal_zzsc);
        this.zzaeH = new zztj(zznR());
        this.zzaeF = new C14111(this, com_google_android_gms_internal_zzsc);
        this.zzaeG = new C14122(this, com_google_android_gms_internal_zzsc);
    }

    private void zza(zzse com_google_android_gms_internal_zzse, zzrl com_google_android_gms_internal_zzrl) {
        zzac.zzw(com_google_android_gms_internal_zzse);
        zzac.zzw(com_google_android_gms_internal_zzrl);
        zza com_google_android_gms_analytics_zza = new zza(zznQ());
        com_google_android_gms_analytics_zza.zzbo(com_google_android_gms_internal_zzse.zzok());
        com_google_android_gms_analytics_zza.enableAdvertisingIdCollection(com_google_android_gms_internal_zzse.zzol());
        zze zzmo = com_google_android_gms_analytics_zza.zzmo();
        zzrt com_google_android_gms_internal_zzrt = (zzrt) zzmo.zzb(zzrt.class);
        com_google_android_gms_internal_zzrt.zzbE("data");
        com_google_android_gms_internal_zzrt.zzT(true);
        zzmo.zza((zzf) com_google_android_gms_internal_zzrl);
        zzro com_google_android_gms_internal_zzro = (zzro) zzmo.zzb(zzro.class);
        zzrk com_google_android_gms_internal_zzrk = (zzrk) zzmo.zzb(zzrk.class);
        for (Entry entry : com_google_android_gms_internal_zzse.zzfE().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                com_google_android_gms_internal_zzrk.setAppName(str2);
            } else if ("av".equals(str)) {
                com_google_android_gms_internal_zzrk.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                com_google_android_gms_internal_zzrk.setAppId(str2);
            } else if ("aiid".equals(str)) {
                com_google_android_gms_internal_zzrk.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                com_google_android_gms_internal_zzrt.setUserId(str2);
            } else {
                com_google_android_gms_internal_zzro.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", com_google_android_gms_internal_zzse.zzok(), com_google_android_gms_internal_zzrl);
        zzmo.zzq(zznW().zzqe());
        zzmo.zzmG();
    }

    private boolean zzbW(String str) {
        return zzadg.zzbi(getContext()).checkCallingOrSelfPermission(str) == 0;
    }

    private void zzoB() {
        zzb(new C14144(this));
    }

    private void zzoC() {
        try {
            this.zzaeA.zzot();
            zzoH();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzaeG.zzy(86400000);
    }

    private boolean zzoI() {
        return !this.zzaeJ && zzoO() > 0;
    }

    private void zzoJ() {
        zzst zznV = zznV();
        if (zznV.zzpD() && !zznV.zzcy()) {
            long zzou = zzou();
            if (zzou != 0 && Math.abs(zznR().currentTimeMillis() - zzou) <= zznT().zzpf()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zznT().zzpe()));
                zznV.schedule();
            }
        }
    }

    private void zzoK() {
        zzoJ();
        long zzoO = zzoO();
        long zzqg = zznW().zzqg();
        if (zzqg != 0) {
            zzqg = zzoO - Math.abs(zznR().currentTimeMillis() - zzqg);
            if (zzqg <= 0) {
                zzqg = Math.min(zznT().zzpc(), zzoO);
            }
        } else {
            zzqg = Math.min(zznT().zzpc(), zzoO);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(zzqg));
        if (this.zzaeF.zzcy()) {
            this.zzaeF.zzz(Math.max(1, zzqg + this.zzaeF.zzpA()));
            return;
        }
        this.zzaeF.zzy(zzqg);
    }

    private void zzoL() {
        zzoM();
        zzoN();
    }

    private void zzoM() {
        if (this.zzaeF.zzcy()) {
            zzbP("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzaeF.cancel();
    }

    private void zzoN() {
        zzst zznV = zznV();
        if (zznV.zzcy()) {
            zznV.cancel();
        }
    }

    private void zzoz() {
        zzmR();
        Context context = zznQ().getContext();
        if (!zzth.zzak(context)) {
            zzbS("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzti.zzal(context)) {
            zzbT("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzak(context)) {
            zzbS("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.zzal(context)) {
            zzbS("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    protected void onServiceConnected() {
        zzmR();
        zzoE();
    }

    void start() {
        zzob();
        zzac.zza(!this.mStarted, (Object) "Analytics backend already started");
        this.mStarted = true;
        zznU().zzg(new C14133(this));
    }

    public void zzW(boolean z) {
        zzoH();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long zza(com.google.android.gms.internal.zzse r6, boolean r7) {
        /*
        r5 = this;
        com.google.android.gms.common.internal.zzac.zzw(r6);
        r5.zzob();
        r5.zzmR();
        r0 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x0049 }
        r0.beginTransaction();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.zzoj();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.zzmy();	 Catch:{ SQLiteException -> 0x0049 }
        r0.zza(r2, r1);	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.zzoj();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.zzmy();	 Catch:{ SQLiteException -> 0x0049 }
        r4 = r6.zzok();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r0.zza(r2, r1, r4);	 Catch:{ SQLiteException -> 0x0049 }
        if (r7 != 0) goto L_0x0042;
    L_0x002f:
        r6.zzs(r0);	 Catch:{ SQLiteException -> 0x0049 }
    L_0x0032:
        r2 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x0049 }
        r2.zzb(r6);	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x0049 }
        r2.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x0057 }
        r2.endTransaction();	 Catch:{ SQLiteException -> 0x0057 }
    L_0x0041:
        return r0;
    L_0x0042:
        r2 = 1;
        r2 = r2 + r0;
        r6.zzs(r2);	 Catch:{ SQLiteException -> 0x0049 }
        goto L_0x0032;
    L_0x0049:
        r0 = move-exception;
        r1 = "Failed to update Analytics property";
        r5.zze(r1, r0);	 Catch:{ all -> 0x0065 }
        r0 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x005e }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x005e }
    L_0x0054:
        r0 = -1;
        goto L_0x0041;
    L_0x0057:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.zze(r3, r2);
        goto L_0x0041;
    L_0x005e:
        r0 = move-exception;
        r1 = "Failed to end transaction";
        r5.zze(r1, r0);
        goto L_0x0054;
    L_0x0065:
        r0 = move-exception;
        r1 = r5.zzaeA;	 Catch:{ SQLiteException -> 0x006c }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x006c }
    L_0x006b:
        throw r0;
    L_0x006c:
        r1 = move-exception;
        r2 = "Failed to end transaction";
        r5.zze(r2, r1);
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsi.zza(com.google.android.gms.internal.zzse, boolean):long");
    }

    public void zza(zzsu com_google_android_gms_internal_zzsu, long j) {
        zzh.zzmR();
        zzob();
        long j2 = -1;
        long zzqg = zznW().zzqg();
        if (zzqg != 0) {
            j2 = Math.abs(zznR().currentTimeMillis() - zzqg);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        zzoD();
        try {
            zzoF();
            zznW().zzqh();
            zzoH();
            if (com_google_android_gms_internal_zzsu != null) {
                com_google_android_gms_internal_zzsu.zzf(null);
            }
            if (this.zzaeI != j) {
                this.zzaeC.zzpZ();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zznW().zzqh();
            zzoH();
            if (com_google_android_gms_internal_zzsu != null) {
                com_google_android_gms_internal_zzsu.zzf(th);
            }
        }
    }

    public void zza(zzsz com_google_android_gms_internal_zzsz) {
        zzac.zzw(com_google_android_gms_internal_zzsz);
        zzh.zzmR();
        zzob();
        if (this.zzaeJ) {
            zzbQ("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", com_google_android_gms_internal_zzsz);
        }
        zzsz zzf = zzf(com_google_android_gms_internal_zzsz);
        zzoD();
        if (this.zzaeD.zzb(zzf)) {
            zzbQ("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.zzaeA.zzc(zzf);
            zzoH();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zznS().zza(zzf, "deliver: failed to insert hit to database");
        }
    }

    public void zzb(zzsu com_google_android_gms_internal_zzsu) {
        zza(com_google_android_gms_internal_zzsu, this.zzaeI);
    }

    public void zzbX(String str) {
        zzac.zzdr(str);
        zzmR();
        zzrl zza = zztm.zza(zznS(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence zzqi = zznW().zzqi();
        if (str.equals(zzqi)) {
            zzbS("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(zzqi)) {
            zznW().zzcb(str);
            if (zznW().zzqf().zzA(zznT().zzpy())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzse zza2 : this.zzaeA.zzw(0)) {
                zza(zza2, zza);
            }
        } else {
            zzd("Ignoring multiple install campaigns. original, new", zzqi, str);
        }
    }

    protected void zzc(zzse com_google_android_gms_internal_zzse) {
        zzmR();
        zzb("Sending first hit to property", com_google_android_gms_internal_zzse.zzok());
        if (!zznW().zzqf().zzA(zznT().zzpy())) {
            String zzqi = zznW().zzqi();
            if (!TextUtils.isEmpty(zzqi)) {
                zzrl zza = zztm.zza(zznS(), zzqi);
                zzb("Found relevant installation campaign", zza);
                zza(com_google_android_gms_internal_zzse, zza);
            }
        }
    }

    zzsz zzf(zzsz com_google_android_gms_internal_zzsz) {
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzsz.zzpU())) {
            return com_google_android_gms_internal_zzsz;
        }
        Pair zzqm = zznW().zzqj().zzqm();
        if (zzqm == null) {
            return com_google_android_gms_internal_zzsz;
        }
        Long l = (Long) zzqm.second;
        String str = (String) zzqm.first;
        String valueOf = String.valueOf(l);
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
        Map hashMap = new HashMap(com_google_android_gms_internal_zzsz.zzfE());
        hashMap.put("_m", valueOf);
        return zzsz.zza(this, com_google_android_gms_internal_zzsz, hashMap);
    }

    protected void zzmS() {
        this.zzaeA.initialize();
        this.zzaeB.initialize();
        this.zzaeD.initialize();
    }

    public void zznK() {
        zzh.zzmR();
        zzob();
        zzbP("Delete all hits from local store");
        try {
            this.zzaeA.zzor();
            this.zzaeA.zzos();
            zzoH();
        } catch (SQLiteException e) {
            zzd("Failed to delete hits from store", e);
        }
        zzoD();
        if (this.zzaeD.zzon()) {
            zzbP("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zznN() {
        zzh.zzmR();
        zzob();
        zzbP("Service disconnected");
    }

    void zznP() {
        zzmR();
        this.zzaeI = zznR().currentTimeMillis();
    }

    protected void zzoA() {
        zzob();
        zzoz();
        zznW().zzqe();
        if (!zzbW("android.permission.ACCESS_NETWORK_STATE")) {
            zzbT("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzoP();
        }
        if (!zzbW("android.permission.INTERNET")) {
            zzbT("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzoP();
        }
        if (zzti.zzal(getContext())) {
            zzbP("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzbS("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.zzaeJ || this.zzaeA.isEmpty())) {
            zzoD();
        }
        zzoH();
    }

    protected void zzoD() {
        if (!this.zzaeJ && zznT().zzoX() && !this.zzaeD.isConnected()) {
            if (this.zzaeH.zzA(zznT().zzps())) {
                this.zzaeH.start();
                zzbP("Connecting to service");
                if (this.zzaeD.connect()) {
                    zzbP("Connected to service");
                    this.zzaeH.clear();
                    onServiceConnected();
                }
            }
        }
    }

    public void zzoE() {
        zzh.zzmR();
        zzob();
        if (!zznT().zzoX()) {
            zzbS("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zzaeD.isConnected()) {
            zzbP("Service not connected");
        } else if (!this.zzaeA.isEmpty()) {
            zzbP("Dispatching local hits to device AnalyticsService");
            while (true) {
                try {
                    break;
                    List zzu = this.zzaeA.zzu((long) zznT().zzpg());
                    if (zzu.isEmpty()) {
                        zzsz com_google_android_gms_internal_zzsz;
                        while (true) {
                            if (!zzu.isEmpty()) {
                                com_google_android_gms_internal_zzsz = (zzsz) zzu.get(0);
                                if (this.zzaeD.zzb(com_google_android_gms_internal_zzsz)) {
                                    zzoH();
                                    return;
                                }
                                zzu.remove(com_google_android_gms_internal_zzsz);
                                try {
                                    this.zzaeA.zzv(com_google_android_gms_internal_zzsz.zzpP());
                                } catch (SQLiteException e) {
                                    zze("Failed to remove hit that was send for delivery", e);
                                    zzoL();
                                    return;
                                }
                            }
                        }
                        List zzu2 = this.zzaeA.zzu((long) zznT().zzpg());
                        if (zzu2.isEmpty()) {
                            while (true) {
                                if (zzu2.isEmpty()) {
                                    com_google_android_gms_internal_zzsz = (zzsz) zzu2.get(0);
                                    if (this.zzaeD.zzb(com_google_android_gms_internal_zzsz)) {
                                        zzu2.remove(com_google_android_gms_internal_zzsz);
                                        this.zzaeA.zzv(com_google_android_gms_internal_zzsz.zzpP());
                                    } else {
                                        zzoH();
                                        return;
                                    }
                                }
                            }
                        }
                        zzoH();
                        return;
                    }
                    zzoH();
                    return;
                } catch (SQLiteException e2) {
                    zze("Failed to read hits from store", e2);
                    zzoL();
                    return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean zzoF() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.analytics.zzh.zzmR();
        r12.zzob();
        r0 = "Dispatching a batch of local hits";
        r12.zzbP(r0);
        r0 = r12.zzaeD;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0028;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        r3 = r12.zzaeB;
        r3 = r3.zzqa();
        if (r3 != 0) goto L_0x002a;
    L_0x001e:
        if (r0 == 0) goto L_0x002c;
    L_0x0020:
        if (r1 == 0) goto L_0x002c;
    L_0x0022:
        r0 = "No network or service available. Will retry later";
        r12.zzbP(r0);
    L_0x0027:
        return r2;
    L_0x0028:
        r0 = r2;
        goto L_0x0016;
    L_0x002a:
        r1 = r2;
        goto L_0x001e;
    L_0x002c:
        r0 = r12.zznT();
        r0 = r0.zzpg();
        r1 = r12.zznT();
        r1 = r1.zzph();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x0048:
        r0 = r12.zzaeA;	 Catch:{ all -> 0x01d7 }
        r0.beginTransaction();	 Catch:{ all -> 0x01d7 }
        r3.clear();	 Catch:{ all -> 0x01d7 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x00c9 }
        r8 = r0.zzu(r6);	 Catch:{ SQLiteException -> 0x00c9 }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00c9 }
        if (r0 == 0) goto L_0x0079;
    L_0x005c:
        r0 = "Store is empty, nothing to dispatch";
        r12.zzbP(r0);	 Catch:{ SQLiteException -> 0x00c9 }
        r12.zzoL();	 Catch:{ SQLiteException -> 0x00c9 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x006f }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x006f }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x006f }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x006f }
        goto L_0x0027;
    L_0x006f:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x0079:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00c9 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00c9 }
        r12.zza(r0, r1);	 Catch:{ SQLiteException -> 0x00c9 }
        r1 = r8.iterator();	 Catch:{ all -> 0x01d7 }
    L_0x008a:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01d7 }
        if (r0 == 0) goto L_0x00e9;
    L_0x0090:
        r0 = r1.next();	 Catch:{ all -> 0x01d7 }
        r0 = (com.google.android.gms.internal.zzsz) r0;	 Catch:{ all -> 0x01d7 }
        r10 = r0.zzpP();	 Catch:{ all -> 0x01d7 }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x008a;
    L_0x009e:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01d7 }
        r3 = r8.size();	 Catch:{ all -> 0x01d7 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01d7 }
        r12.zzd(r0, r1, r3);	 Catch:{ all -> 0x01d7 }
        r12.zzoL();	 Catch:{ all -> 0x01d7 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x00be }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00be }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x00be }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00be }
        goto L_0x0027;
    L_0x00be:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x00c9:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.zzd(r1, r0);	 Catch:{ all -> 0x01d7 }
        r12.zzoL();	 Catch:{ all -> 0x01d7 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x00de }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00de }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x00de }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00de }
        goto L_0x0027;
    L_0x00de:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x00e9:
        r0 = r12.zzaeD;	 Catch:{ all -> 0x01d7 }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01d7 }
        if (r0 == 0) goto L_0x01ee;
    L_0x00f1:
        r0 = "Service connected, sending hits to the service";
        r12.zzbP(r0);	 Catch:{ all -> 0x01d7 }
    L_0x00f6:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01d7 }
        if (r0 != 0) goto L_0x01ee;
    L_0x00fc:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01d7 }
        r0 = (com.google.android.gms.internal.zzsz) r0;	 Catch:{ all -> 0x01d7 }
        r1 = r12.zzaeD;	 Catch:{ all -> 0x01d7 }
        r1 = r1.zzb(r0);	 Catch:{ all -> 0x01d7 }
        if (r1 != 0) goto L_0x0134;
    L_0x010b:
        r0 = r4;
    L_0x010c:
        r4 = r12.zzaeB;	 Catch:{ all -> 0x01d7 }
        r4 = r4.zzqa();	 Catch:{ all -> 0x01d7 }
        if (r4 == 0) goto L_0x0182;
    L_0x0114:
        r4 = r12.zzaeB;	 Catch:{ all -> 0x01d7 }
        r8 = r4.zzt(r8);	 Catch:{ all -> 0x01d7 }
        r9 = r8.iterator();	 Catch:{ all -> 0x01d7 }
        r4 = r0;
    L_0x011f:
        r0 = r9.hasNext();	 Catch:{ all -> 0x01d7 }
        if (r0 == 0) goto L_0x0179;
    L_0x0125:
        r0 = r9.next();	 Catch:{ all -> 0x01d7 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01d7 }
        r0 = r0.longValue();	 Catch:{ all -> 0x01d7 }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01d7 }
        goto L_0x011f;
    L_0x0134:
        r10 = r0.zzpP();	 Catch:{ all -> 0x01d7 }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01d7 }
        r8.remove(r0);	 Catch:{ all -> 0x01d7 }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.zzb(r1, r0);	 Catch:{ all -> 0x01d7 }
        r1 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x0159 }
        r10 = r0.zzpP();	 Catch:{ SQLiteException -> 0x0159 }
        r1.zzv(r10);	 Catch:{ SQLiteException -> 0x0159 }
        r0 = r0.zzpP();	 Catch:{ SQLiteException -> 0x0159 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0159 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0159 }
        goto L_0x00f6;
    L_0x0159:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01d7 }
        r12.zzoL();	 Catch:{ all -> 0x01d7 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x016e }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x016e }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x016e }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x016e }
        goto L_0x0027;
    L_0x016e:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x0179:
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x019f }
        r0.zzr(r8);	 Catch:{ SQLiteException -> 0x019f }
        r3.addAll(r8);	 Catch:{ SQLiteException -> 0x019f }
        r0 = r4;
    L_0x0182:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01d7 }
        if (r4 == 0) goto L_0x01bf;
    L_0x0188:
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x0194 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0194 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x0194 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0194 }
        goto L_0x0027;
    L_0x0194:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x019f:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01d7 }
        r12.zzoL();	 Catch:{ all -> 0x01d7 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x01b4 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01b4 }
        r0 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x01b4 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01b4 }
        goto L_0x0027;
    L_0x01b4:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x01bf:
        r4 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x01cc }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01cc }
        r4 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x01cc }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01cc }
        r4 = r0;
        goto L_0x0048;
    L_0x01cc:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x01d7:
        r0 = move-exception;
        r1 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x01e3 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01e3 }
        r1 = r12.zzaeA;	 Catch:{ SQLiteException -> 0x01e3 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01e3 }
        throw r0;
    L_0x01e3:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzoL();
        goto L_0x0027;
    L_0x01ee:
        r0 = r4;
        goto L_0x010c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsi.zzoF():boolean");
    }

    public void zzoG() {
        zzh.zzmR();
        zzob();
        zzbQ("Sync dispatching local hits");
        long j = this.zzaeI;
        zzoD();
        try {
            zzoF();
            zznW().zzqh();
            zzoH();
            if (this.zzaeI != j) {
                this.zzaeC.zzpZ();
            }
        } catch (Throwable th) {
            zze("Sync local dispatch failed", th);
            zzoH();
        }
    }

    public void zzoH() {
        zznQ().zzmR();
        zzob();
        if (!zzoI()) {
            this.zzaeC.unregister();
            zzoL();
        } else if (this.zzaeA.isEmpty()) {
            this.zzaeC.unregister();
            zzoL();
        } else {
            boolean z;
            if (((Boolean) zzsw.zzafS.get()).booleanValue()) {
                z = true;
            } else {
                this.zzaeC.zzpX();
                z = this.zzaeC.isConnected();
            }
            if (z) {
                zzoK();
                return;
            }
            zzoL();
            zzoJ();
        }
    }

    public long zzoO() {
        if (this.zzaeE != Long.MIN_VALUE) {
            return this.zzaeE;
        }
        return zzmB().zzpK() ? ((long) zzmB().zzqB()) * 1000 : zznT().zzpd();
    }

    public void zzoP() {
        zzob();
        zzmR();
        this.zzaeJ = true;
        this.zzaeD.disconnect();
        zzoH();
    }

    public long zzou() {
        zzh.zzmR();
        zzob();
        try {
            return this.zzaeA.zzou();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    public void zzx(long j) {
        zzh.zzmR();
        zzob();
        if (j < 0) {
            j = 0;
        }
        this.zzaeE = j;
        zzoH();
    }
}
