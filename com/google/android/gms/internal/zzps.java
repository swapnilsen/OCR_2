package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONObject;

@zzme
public class zzps {
    private String zzXT;
    private String zzXU;
    private boolean zzXV;
    protected String zzXW;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.internal.zzps.1 */
    class C13711 implements Runnable {
        final /* synthetic */ String zzXX;
        final /* synthetic */ boolean zzXY;
        final /* synthetic */ boolean zzXZ;
        final /* synthetic */ Context zztf;

        /* renamed from: com.google.android.gms.internal.zzps.1.1 */
        class C13701 implements OnClickListener {
            final /* synthetic */ C13711 zzYa;

            C13701(C13711 c13711) {
                this.zzYa = c13711;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                zzw.zzcM().zza(this.zzYa.zztf, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
            }
        }

        C13711(zzps com_google_android_gms_internal_zzps, Context context, String str, boolean z, boolean z2) {
            this.zztf = context;
            this.zzXX = str;
            this.zzXY = z;
            this.zzXZ = z2;
        }

        public void run() {
            Builder builder = new Builder(this.zztf);
            builder.setMessage(this.zzXX);
            if (this.zzXY) {
                builder.setTitle("Error");
            } else {
                builder.setTitle("Info");
            }
            if (this.zzXZ) {
                builder.setNeutralButton("Dismiss", null);
            } else {
                builder.setPositiveButton("Learn More", new C13701(this));
                builder.setNegativeButton("Dismiss", null);
            }
            builder.create().show();
        }
    }

    public zzps() {
        this.zzrJ = new Object();
        this.zzXT = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.zzXU = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.zzXV = false;
        this.zzXW = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    private Uri zzb(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzY(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private void zzm(Context context, String str, String str2) {
        zzw.zzcM().zza(context, zzb(context, (String) zzgd.zzFn.get(), str, str2));
    }

    public void zzJ(boolean z) {
        synchronized (this.zzrJ) {
            this.zzXV = z;
        }
    }

    public String zzY(Context context) {
        String str;
        synchronized (this.zzrJ) {
            if (TextUtils.isEmpty(this.zzXT)) {
                this.zzXT = zzw.zzcM().zzv(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzXT)) {
                    this.zzXT = zzw.zzcM().zzkL();
                    zzw.zzcM().zzg(context, "debug_signals_id.txt", this.zzXT);
                }
            }
            str = this.zzXT;
        }
        return str;
    }

    public void zza(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzb(context, (String) zzgd.zzFq.get(), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzw.zzcM().zzf(context, str, buildUpon.build().toString());
    }

    protected void zza(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzpo.zzXC.post(new C13711(this, context, str, z, z2));
        } else {
            zzqf.zzbg("Can not create dialog without Activity Context");
        }
    }

    public void zzbd(String str) {
        synchronized (this.zzrJ) {
            this.zzXU = str;
        }
    }

    public void zzh(Context context, String str, String str2) {
        if (!zzj(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(this.zzXW)) {
            zzqf.zzbf("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzXW)) {
            zzqf.zzbf("The app is not linked for creative preview.");
            zzm(context, str, str2);
        } else if ("0".equals(this.zzXW)) {
            zzqf.zzbf("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public void zzi(Context context, String str, String str2) {
        if (zzk(context, str, str2)) {
            zzqf.zzbf("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzm(context, str, str2);
    }

    boolean zzj(Context context, String str, String str2) {
        Object zzl = zzl(context, zzb(context, (String) zzgd.zzFo.get(), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzl)) {
            zzqf.zzbf("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzl.trim());
            String optString = jSONObject.optString("gct");
            this.zzXW = jSONObject.optString(NotificationCompatApi24.CATEGORY_STATUS);
            zzbd(optString);
            return true;
        } catch (Throwable e) {
            zzqf.zzc("Fail to get in app preview response json.", e);
            return false;
        }
    }

    boolean zzk(Context context, String str, String str2) {
        Object zzl = zzl(context, zzb(context, (String) zzgd.zzFp.get(), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzl)) {
            zzqf.zzbf("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzl.trim()).optString("debug_mode"));
            zzJ(equals);
            return equals;
        } catch (Throwable e) {
            zzqf.zzc("Fail to get debug mode response json.", e);
            return false;
        }
    }

    public String zzkY() {
        String str;
        synchronized (this.zzrJ) {
            str = this.zzXU;
        }
        return str;
    }

    public boolean zzkZ() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzXV;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String zzl(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
        r6 = this;
        r5 = 1;
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "User-Agent";
        r2 = com.google.android.gms.ads.internal.zzw.zzcM();
        r2 = r2.zzu(r7, r9);
        r0.put(r1, r2);
        r1 = new com.google.android.gms.internal.zzpv;
        r1.<init>(r7);
        r2 = r1.zzc(r8, r0);
        r0 = com.google.android.gms.internal.zzgd.zzFr;	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
        r0 = r0.get();	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
        r0 = (java.lang.Integer) r0;	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
        r0 = r0.intValue();	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
        r0 = (long) r0;	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
        r0 = r2.get(r0, r3);	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
        r0 = (java.lang.String) r0;	 Catch:{ TimeoutException -> 0x0032, InterruptedException -> 0x0052, Exception -> 0x0071 }
    L_0x0031:
        return r0;
    L_0x0032:
        r0 = move-exception;
        r1 = r0;
        r3 = "Timeout while retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r4 = r0.length();
        if (r4 == 0) goto L_0x004c;
    L_0x0040:
        r0 = r3.concat(r0);
    L_0x0044:
        com.google.android.gms.internal.zzqf.zzb(r0, r1);
        r2.cancel(r5);
    L_0x004a:
        r0 = 0;
        goto L_0x0031;
    L_0x004c:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x0044;
    L_0x0052:
        r0 = move-exception;
        r1 = r0;
        r3 = "Interrupted while retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r4 = r0.length();
        if (r4 == 0) goto L_0x006b;
    L_0x0060:
        r0 = r3.concat(r0);
    L_0x0064:
        com.google.android.gms.internal.zzqf.zzb(r0, r1);
        r2.cancel(r5);
        goto L_0x004a;
    L_0x006b:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x0064;
    L_0x0071:
        r0 = move-exception;
        r1 = r0;
        r2 = "Error retriving a response from: ";
        r0 = java.lang.String.valueOf(r8);
        r3 = r0.length();
        if (r3 == 0) goto L_0x0087;
    L_0x007f:
        r0 = r2.concat(r0);
    L_0x0083:
        com.google.android.gms.internal.zzqf.zzb(r0, r1);
        goto L_0x004a;
    L_0x0087:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzps.zzl(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
