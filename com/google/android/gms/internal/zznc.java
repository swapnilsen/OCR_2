package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.zzji.zzb;
import com.google.android.gms.internal.zzmt.zza;
import com.google.android.gms.internal.zzqp.zzc;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzme
public final class zznc extends zza {
    private static zznc zzTv;
    private static final Object zztX;
    private final Context mContext;
    private final zznb zzTw;
    private final zzfw zzTx;
    private final zzji zzTy;

    /* renamed from: com.google.android.gms.internal.zznc.1 */
    class C13261 implements Callable<Void> {
        final /* synthetic */ zzmk zzTA;
        final /* synthetic */ Bundle zzTB;
        final /* synthetic */ zznb zzTz;
        final /* synthetic */ Context zztf;

        C13261(zznb com_google_android_gms_internal_zznb, Context context, zzmk com_google_android_gms_internal_zzmk, Bundle bundle) {
            this.zzTz = com_google_android_gms_internal_zznb;
            this.zztf = context;
            this.zzTA = com_google_android_gms_internal_zzmk;
            this.zzTB = bundle;
        }

        public /* synthetic */ Object call() {
            return zzbk();
        }

        public Void zzbk() {
            String str = this.zzTA.zzRz.packageName;
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zznc.2 */
    class C13292 implements Runnable {
        final /* synthetic */ zzne zzTC;
        final /* synthetic */ zzgj zzTD;
        final /* synthetic */ String zzTE;
        final /* synthetic */ zzgl zzsK;
        final /* synthetic */ zzji zzta;

        /* renamed from: com.google.android.gms.internal.zznc.2.1 */
        class C13271 implements zzc<zzjj> {
            final /* synthetic */ zzgj zzTF;
            final /* synthetic */ C13292 zzTG;

            C13271(C13292 c13292, zzgj com_google_android_gms_internal_zzgj) {
                this.zzTG = c13292;
                this.zzTF = com_google_android_gms_internal_zzgj;
            }

            public void zzb(zzjj com_google_android_gms_internal_zzjj) {
                this.zzTG.zzsK.zza(this.zzTF, "jsf");
                this.zzTG.zzsK.zzfC();
                com_google_android_gms_internal_zzjj.zza("/invalidRequest", this.zzTG.zzTC.zzTN);
                com_google_android_gms_internal_zzjj.zza("/loadAdURL", this.zzTG.zzTC.zzTO);
                com_google_android_gms_internal_zzjj.zza("/loadAd", this.zzTG.zzTC.zzTP);
                try {
                    com_google_android_gms_internal_zzjj.zzj("AFMA_getAd", this.zzTG.zzTE);
                } catch (Throwable e) {
                    zzqf.zzb("Error requesting an ad url", e);
                }
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjj) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zznc.2.2 */
        class C13282 implements zzqp.zza {
            C13282(C13292 c13292) {
            }

            public void run() {
            }
        }

        C13292(zzji com_google_android_gms_internal_zzji, zzne com_google_android_gms_internal_zzne, zzgl com_google_android_gms_internal_zzgl, zzgj com_google_android_gms_internal_zzgj, String str) {
            this.zzta = com_google_android_gms_internal_zzji;
            this.zzTC = com_google_android_gms_internal_zzne;
            this.zzsK = com_google_android_gms_internal_zzgl;
            this.zzTD = com_google_android_gms_internal_zzgj;
            this.zzTE = str;
        }

        public void run() {
            zzji.zzc zzgO = this.zzta.zzgO();
            this.zzTC.zzb(zzgO);
            this.zzsK.zza(this.zzTD, "rwc");
            zzgO.zza(new C13271(this, this.zzsK.zzfB()), new C13282(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zznc.3 */
    class C13303 implements Runnable {
        final /* synthetic */ zzmk zzTA;
        final /* synthetic */ zzne zzTC;
        final /* synthetic */ zznb zzTz;
        final /* synthetic */ Context zztf;

        C13303(zznb com_google_android_gms_internal_zznb, Context context, zzne com_google_android_gms_internal_zzne, zzmk com_google_android_gms_internal_zzmk) {
            this.zzTz = com_google_android_gms_internal_zznb;
            this.zztf = context;
            this.zzTC = com_google_android_gms_internal_zzne;
            this.zzTA = com_google_android_gms_internal_zzmk;
        }

        public void run() {
            this.zzTz.zzTp.zza(this.zztf, this.zzTC, this.zzTA.zzvn);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznc.4 */
    class C13314 implements zzpt<zzjf> {
        C13314(zznc com_google_android_gms_internal_zznc) {
        }

        public void zza(zzjf com_google_android_gms_internal_zzjf) {
            com_google_android_gms_internal_zzjf.zza("/log", zzic.zzHL);
        }

        public /* synthetic */ void zzd(Object obj) {
            zza((zzjf) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznc.5 */
    class C13325 implements Runnable {
        final /* synthetic */ zzmk zzTA;
        final /* synthetic */ zzmu zzTH;
        final /* synthetic */ zznc zzTI;

        C13325(zznc com_google_android_gms_internal_zznc, zzmk com_google_android_gms_internal_zzmk, zzmu com_google_android_gms_internal_zzmu) {
            this.zzTI = com_google_android_gms_internal_zznc;
            this.zzTA = com_google_android_gms_internal_zzmk;
            this.zzTH = com_google_android_gms_internal_zzmu;
        }

        public void run() {
            zzmn zzd;
            try {
                zzd = this.zzTI.zzd(this.zzTA);
            } catch (Throwable e) {
                zzw.zzcQ().zza(e, "AdRequestServiceImpl.loadAdAsync");
                zzqf.zzc("Could not fetch ad response due to an Exception.", e);
                zzd = null;
            }
            if (zzd == null) {
                zzd = new zzmn(0);
            }
            try {
                this.zzTH.zza(zzd);
            } catch (Throwable e2) {
                zzqf.zzc("Fail to forward ad response.", e2);
            }
        }
    }

    static {
        zztX = new Object();
    }

    zznc(Context context, zzfw com_google_android_gms_internal_zzfw, zznb com_google_android_gms_internal_zznb) {
        this.mContext = context;
        this.zzTw = com_google_android_gms_internal_zznb;
        this.zzTx = com_google_android_gms_internal_zzfw;
        this.zzTy = new zzji(context.getApplicationContext() != null ? context.getApplicationContext() : context, zzqh.zzlk(), com_google_android_gms_internal_zzfw.zzfq(), new C13314(this), new zzb());
    }

    private static zzmn zza(Context context, zzji com_google_android_gms_internal_zzji, zzfw com_google_android_gms_internal_zzfw, zznb com_google_android_gms_internal_zznb, zzmk com_google_android_gms_internal_zzmk) {
        Future zza;
        Future zzG;
        Bundle bundle;
        Future future;
        Throwable e;
        String str;
        zzqf.zzbf("Starting ad request from service using: AFMA_getAd");
        zzgd.initialize(context);
        zzgl com_google_android_gms_internal_zzgl = new zzgl(((Boolean) zzgd.zzBZ.get()).booleanValue(), "load_ad", com_google_android_gms_internal_zzmk.zzvr.zzzy);
        if (com_google_android_gms_internal_zzmk.versionCode > 10 && com_google_android_gms_internal_zzmk.zzRO != -1) {
            com_google_android_gms_internal_zzgl.zza(com_google_android_gms_internal_zzgl.zzc(com_google_android_gms_internal_zzmk.zzRO), "cts");
        }
        zzgj zzfB = com_google_android_gms_internal_zzgl.zzfB();
        Future zzt = com_google_android_gms_internal_zznb.zzTt.zzt(context);
        Future zzB = com_google_android_gms_internal_zznb.zzTs.zzB(context);
        Future zzaS = com_google_android_gms_internal_zznb.zzTn.zzaS(com_google_android_gms_internal_zzmk.zzRz.packageName);
        Future zzg = com_google_android_gms_internal_zznb.zzTu.zzg(com_google_android_gms_internal_zzmk);
        Future zzA = zzw.zzcV().zzA(context);
        zzqk com_google_android_gms_internal_zzqk = new zzqk(null);
        Bundle bundle2 = com_google_android_gms_internal_zzmk.zzRy.extras;
        Object obj = (bundle2 == null || bundle2.getString("_ad") == null) ? null : 1;
        if (com_google_android_gms_internal_zzmk.zzRV && obj == null) {
            zza = com_google_android_gms_internal_zznb.zzTq.zza(com_google_android_gms_internal_zzmk.applicationInfo);
        } else {
            Object obj2 = com_google_android_gms_internal_zzqk;
        }
        com_google_android_gms_internal_zzqk = new zzqk(null);
        if (((Boolean) zzgd.zzCS.get()).booleanValue()) {
            zzG = com_google_android_gms_internal_zznb.zzTu.zzG(context);
        } else {
            Object obj3 = com_google_android_gms_internal_zzqk;
        }
        Bundle bundle3 = (com_google_android_gms_internal_zzmk.versionCode < 4 || com_google_android_gms_internal_zzmk.zzRF == null) ? null : com_google_android_gms_internal_zzmk.zzRF;
        if (!((Boolean) zzgd.zzCp.get()).booleanValue() || com_google_android_gms_internal_zznb.zzTl == null) {
            bundle = bundle3;
            future = null;
        } else {
            if (bundle3 == null && ((Boolean) zzgd.zzCq.get()).booleanValue()) {
                zzpk.m4709v("contentInfo is not present, but we'll still launch the app index task");
                bundle3 = new Bundle();
            }
            if (bundle3 != null) {
                bundle = bundle3;
                future = zzpn.zza(new C13261(com_google_android_gms_internal_zznb, context, com_google_android_gms_internal_zzmk, bundle3));
            } else {
                bundle = bundle3;
                future = null;
            }
        }
        if (zzw.zzcM().zze(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
                zzqf.zzbf("Device is offline.");
            }
        }
        String uuid = com_google_android_gms_internal_zzmk.versionCode >= 7 ? com_google_android_gms_internal_zzmk.zzRL : UUID.randomUUID().toString();
        zzne com_google_android_gms_internal_zzne = new zzne(uuid, com_google_android_gms_internal_zzmk.applicationInfo.packageName);
        if (com_google_android_gms_internal_zzmk.zzRy.extras != null) {
            String string = com_google_android_gms_internal_zzmk.zzRy.extras.getString("_ad");
            if (string != null) {
                return zznd.zza(context, com_google_android_gms_internal_zzmk, string);
            }
        }
        List zza2 = com_google_android_gms_internal_zznb.zzTo.zza(com_google_android_gms_internal_zzmk);
        if (future != null) {
            try {
                zzpk.m4709v("Waiting for app index fetching task.");
                future.get(((Long) zzgd.zzCr.get()).longValue(), TimeUnit.MILLISECONDS);
                zzpk.m4709v("App index fetching task completed.");
            } catch (ExecutionException e2) {
                e = e2;
                zzqf.zzc("Failed to fetch app index signal", e);
            } catch (InterruptedException e3) {
                e = e3;
                zzqf.zzc("Failed to fetch app index signal", e);
            } catch (TimeoutException e4) {
                zzqf.zzbf("Timed out waiting for app index fetching task");
            }
        }
        bundle2 = (Bundle) zza(zzt, (Long) zzgd.zzEX.get());
        zznm.zza com_google_android_gms_internal_zznm_zza = (zznm.zza) zza(zzB, (Long) zzgd.zzDH.get());
        Location location = (Location) zza(zza, (Long) zzgd.zzEF.get());
        Info info = (Info) zza(zzG, (Long) zzgd.zzCT.get());
        try {
            str = (String) zzg.get();
        } catch (Throwable e5) {
            zzw.zzcQ().zza(e5, "AdRequestServiceImpl.loadAdAsync.qs");
            zzqf.zzc("Error fetching qs signals. Continuing.", e5);
            str = null;
        }
        String str2 = null;
        try {
            str2 = (String) zzaS.get();
        } catch (Throwable e52) {
            zzw.zzcQ().zza(e52, "AdRequestServiceImpl.loadAdAsync.ds");
            zzqf.zzc("Error fetching drt signals. Continuing.", e52);
        }
        try {
            JSONObject zza3 = zznd.zza(context, new zzna().zzf(com_google_android_gms_internal_zzmk).zza((zzni) zzA.get()).zza(com_google_android_gms_internal_zznm_zza).zzc(location).zze(bundle2).zzaK(str).zzb(info).zzk(zza2).zzf(bundle).zzaL(str2).zzg(com_google_android_gms_internal_zznb.zzTm.zzj(context)));
            if (zza3 == null) {
                return new zzmn(0);
            }
            if (com_google_android_gms_internal_zzmk.versionCode < 7) {
                try {
                    zza3.put("request_id", uuid);
                } catch (JSONException e6) {
                }
            }
            String jSONObject = zza3.toString();
            com_google_android_gms_internal_zzgl.zza(zzfB, "arc");
            zzpo.zzXC.post(new C13292(com_google_android_gms_internal_zzji, com_google_android_gms_internal_zzne, com_google_android_gms_internal_zzgl, com_google_android_gms_internal_zzgl.zzfB(), jSONObject));
            zzmn com_google_android_gms_internal_zzmn;
            try {
                zznh com_google_android_gms_internal_zznh = (zznh) com_google_android_gms_internal_zzne.zzjw().get(10, TimeUnit.SECONDS);
                if (com_google_android_gms_internal_zznh == null) {
                    com_google_android_gms_internal_zzmn = new zzmn(0);
                    return com_google_android_gms_internal_zzmn;
                } else if (com_google_android_gms_internal_zznh.getErrorCode() != -2) {
                    com_google_android_gms_internal_zzmn = new zzmn(com_google_android_gms_internal_zznh.getErrorCode());
                    zzpo.zzXC.post(new C13303(com_google_android_gms_internal_zznb, context, com_google_android_gms_internal_zzne, com_google_android_gms_internal_zzmk));
                    return com_google_android_gms_internal_zzmn;
                } else {
                    if (com_google_android_gms_internal_zzgl.zzfF() != null) {
                        com_google_android_gms_internal_zzgl.zza(com_google_android_gms_internal_zzgl.zzfF(), "rur");
                    }
                    com_google_android_gms_internal_zzmn = null;
                    if (!TextUtils.isEmpty(com_google_android_gms_internal_zznh.zzjB())) {
                        com_google_android_gms_internal_zzmn = zznd.zza(context, com_google_android_gms_internal_zzmk, com_google_android_gms_internal_zznh.zzjB());
                    }
                    if (com_google_android_gms_internal_zzmn == null && !TextUtils.isEmpty(com_google_android_gms_internal_zznh.getUrl())) {
                        com_google_android_gms_internal_zzmn = zza(com_google_android_gms_internal_zzmk, context, com_google_android_gms_internal_zzmk.zzvn.zzba, com_google_android_gms_internal_zznh.getUrl(), str2, com_google_android_gms_internal_zznh, com_google_android_gms_internal_zzgl, com_google_android_gms_internal_zznb);
                    }
                    if (com_google_android_gms_internal_zzmn == null) {
                        com_google_android_gms_internal_zzmn = new zzmn(0);
                    }
                    com_google_android_gms_internal_zzgl.zza(zzfB, "tts");
                    com_google_android_gms_internal_zzmn.zzSA = com_google_android_gms_internal_zzgl.zzfD();
                    zzpo.zzXC.post(new C13303(com_google_android_gms_internal_zznb, context, com_google_android_gms_internal_zzne, com_google_android_gms_internal_zzmk));
                    return com_google_android_gms_internal_zzmn;
                }
            } catch (Exception e7) {
                com_google_android_gms_internal_zzmn = new zzmn(0);
                return com_google_android_gms_internal_zzmn;
            } finally {
                zzpo.zzXC.post(new C13303(com_google_android_gms_internal_zznb, context, com_google_android_gms_internal_zzne, com_google_android_gms_internal_zzmk));
            }
        } catch (Throwable e8) {
            zzw.zzcQ().zza(e8, "AdRequestServiceImpl.loadAdAsync.di");
            zzqf.zzc("Error fetching device info. This is not recoverable.", e8);
            return new zzmn(0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzmn zza(com.google.android.gms.internal.zzmk r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.zznh r18, com.google.android.gms.internal.zzgl r19, com.google.android.gms.internal.zznb r20) {
        /*
        if (r19 == 0) goto L_0x00db;
    L_0x0002:
        r2 = r19.zzfB();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.internal.zznf;	 Catch:{ IOException -> 0x00e6 }
        r2 = r18.zzjy();	 Catch:{ IOException -> 0x00e6 }
        r8.<init>(r13, r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x00e6 }
        r5 = r2.length();	 Catch:{ IOException -> 0x00e6 }
        if (r5 == 0) goto L_0x00df;
    L_0x001c:
        r2 = r4.concat(r2);	 Catch:{ IOException -> 0x00e6 }
    L_0x0020:
        com.google.android.gms.internal.zzqf.zzbf(r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x00e6 }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x00e6 }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.zzw.zzcS();	 Catch:{ IOException -> 0x00e6 }
        r10 = r5.elapsedRealtime();	 Catch:{ IOException -> 0x00e6 }
        r6 = r2;
        r7 = r4;
    L_0x0035:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x00e6 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x00e6 }
        r4 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4.zza(r14, r15, r5, r2);	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0056;
    L_0x0049:
        r4 = r18.zzjA();	 Catch:{ all -> 0x010b }
        if (r4 == 0) goto L_0x0056;
    L_0x004f:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x010b }
    L_0x0056:
        r4 = r13.zzRW;	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 != 0) goto L_0x0068;
    L_0x005e:
        r5 = "Sending webview cookie in ad request header.";
        com.google.android.gms.internal.zzqf.zzbf(r5);	 Catch:{ all -> 0x010b }
        r5 = "Cookie";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x010b }
    L_0x0068:
        if (r18 == 0) goto L_0x0094;
    L_0x006a:
        r4 = r18.zzjz();	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0094;
    L_0x0074:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x010b }
        r4 = r18.zzjz();	 Catch:{ all -> 0x010b }
        r9 = r4.getBytes();	 Catch:{ all -> 0x010b }
        r4 = r9.length;	 Catch:{ all -> 0x010b }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0105 }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x0105 }
        r4.<init>(r12);	 Catch:{ all -> 0x0105 }
        r4.write(r9);	 Catch:{ all -> 0x0197 }
        com.google.android.gms.common.util.zzp.zzb(r4);	 Catch:{ all -> 0x010b }
    L_0x0094:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x010b }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x010b }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x0116;
    L_0x00a0:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x0116;
    L_0x00a4:
        r6 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0110 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0110 }
        r4.<init>(r7);	 Catch:{ all -> 0x0110 }
        r5 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x0194 }
        r5 = r5.zza(r4);	 Catch:{ all -> 0x0194 }
        com.google.android.gms.common.util.zzp.zzb(r4);	 Catch:{ all -> 0x010b }
        zza(r6, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r8.zzb(r6, r12, r5);	 Catch:{ all -> 0x010b }
        if (r19 == 0) goto L_0x00d2;
    L_0x00c5:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x010b }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x010b }
        r0 = r19;
        r0.zza(r3, r4);	 Catch:{ all -> 0x010b }
    L_0x00d2:
        r3 = r8.zzj(r10);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
    L_0x00da:
        return r2;
    L_0x00db:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00df:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x00e6 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x00e6 }
        goto L_0x0020;
    L_0x00e6:
        r2 = move-exception;
        r3 = "Error while connecting to ad server: ";
        r2 = r2.getMessage();
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x018d;
    L_0x00f7:
        r2 = r3.concat(r2);
    L_0x00fb:
        com.google.android.gms.internal.zzqf.zzbh(r2);
        r2 = new com.google.android.gms.internal.zzmn;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00da;
    L_0x0105:
        r3 = move-exception;
        r4 = r5;
    L_0x0107:
        com.google.android.gms.common.util.zzp.zzb(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x010b:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        throw r3;	 Catch:{ IOException -> 0x00e6 }
    L_0x0110:
        r3 = move-exception;
        r4 = r5;
    L_0x0112:
        com.google.android.gms.common.util.zzp.zzb(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x0116:
        r4 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        zza(r4, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x015d;
    L_0x0122:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x015d;
    L_0x0126:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 == 0) goto L_0x0142;
    L_0x0132:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.internal.zzqf.zzbh(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmn;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0142:
        r5 = new java.net.URL;	 Catch:{ all -> 0x010b }
        r5.<init>(r4);	 Catch:{ all -> 0x010b }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x0181;
    L_0x014c:
        r3 = "Too many redirects.";
        com.google.android.gms.internal.zzqf.zzbh(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmn;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x015d:
        r3 = 46;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r4.<init>(r3);	 Catch:{ all -> 0x010b }
        r3 = "Received error HTTP response code: ";
        r3 = r4.append(r3);	 Catch:{ all -> 0x010b }
        r3 = r3.append(r9);	 Catch:{ all -> 0x010b }
        r3 = r3.toString();	 Catch:{ all -> 0x010b }
        com.google.android.gms.internal.zzqf.zzbh(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmn;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0181:
        r8.zzk(r12);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        if (r20 == 0) goto L_0x0189;
    L_0x0189:
        r6 = r4;
        r7 = r5;
        goto L_0x0035;
    L_0x018d:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x00fb;
    L_0x0194:
        r3 = move-exception;
        goto L_0x0112;
    L_0x0197:
        r3 = move-exception;
        goto L_0x0107;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznc.zza(com.google.android.gms.internal.zzmk, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zznh, com.google.android.gms.internal.zzgl, com.google.android.gms.internal.zznb):com.google.android.gms.internal.zzmn");
    }

    public static zznc zza(Context context, zzfw com_google_android_gms_internal_zzfw, zznb com_google_android_gms_internal_zznb) {
        zznc com_google_android_gms_internal_zznc;
        synchronized (zztX) {
            if (zzTv == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzTv = new zznc(context, com_google_android_gms_internal_zzfw, com_google_android_gms_internal_zznb);
            }
            com_google_android_gms_internal_zznc = zzTv;
        }
        return com_google_android_gms_internal_zznc;
    }

    @Nullable
    private static <T> T zza(Future<T> future, Long l) {
        Throwable e;
        try {
            return future.get(l.longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e2) {
            zzqf.zzc("InterruptedException caught while resolving future.", e2);
            Thread.currentThread().interrupt();
            return null;
        } catch (RuntimeException e3) {
            e2 = e3;
            zzqf.zzc("Exception caught while resolving future", e2);
            return null;
        } catch (TimeoutException e4) {
            e2 = e4;
            zzqf.zzc("Exception caught while resolving future", e2);
            return null;
        } catch (ExecutionException e5) {
            e2 = e5;
            zzqf.zzc("Exception caught while resolving future", e2);
            return null;
        }
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzqf.zzak(2)) {
            zzpk.m4709v(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    String str32;
                    zzpk.m4709v(new StringBuilder(String.valueOf(str32).length() + 5).append("    ").append(str32).append(":").toString());
                    for (String str322 : (List) map.get(str322)) {
                        String str4 = "      ";
                        str322 = String.valueOf(str322);
                        zzpk.m4709v(str322.length() != 0 ? str4.concat(str322) : new String(str4));
                    }
                }
            }
            zzpk.m4709v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += PointerIconCompat.TYPE_DEFAULT) {
                    zzpk.m4709v(str2.substring(i2, Math.min(str2.length(), i2 + PointerIconCompat.TYPE_DEFAULT)));
                }
            } else {
                zzpk.m4709v("    null");
            }
            zzpk.m4709v("  Response Code:\n    " + i + "\n}");
        }
    }

    public void zza(zzmk com_google_android_gms_internal_zzmk, zzmu com_google_android_gms_internal_zzmu) {
        zzw.zzcQ().zzc(this.mContext, com_google_android_gms_internal_zzmk.zzvn);
        zzpn.zza(new C13325(this, com_google_android_gms_internal_zzmk, com_google_android_gms_internal_zzmu));
    }

    public zzmn zzd(zzmk com_google_android_gms_internal_zzmk) {
        return zza(this.mContext, this.zzTy, this.zzTx, this.zzTw, com_google_android_gms_internal_zzmk);
    }
}
