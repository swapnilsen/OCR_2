package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzqf;
import java.util.List;

@zzme
public class zzc extends zzpj implements ServiceConnection {
    private Context mContext;
    private zzli zzJv;
    private boolean zzPs;
    private zzb zzPt;
    private zzh zzPu;
    private List<zzf> zzPv;
    private zzk zzPw;
    private final Object zzrJ;

    /* renamed from: com.google.android.gms.ads.internal.purchase.zzc.1 */
    class C09251 implements Runnable {
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ zzf zzPx;
        final /* synthetic */ zzc zzPy;

        C09251(zzc com_google_android_gms_ads_internal_purchase_zzc, zzf com_google_android_gms_ads_internal_purchase_zzf, Intent intent) {
            this.zzPy = com_google_android_gms_ads_internal_purchase_zzc;
            this.zzPx = com_google_android_gms_ads_internal_purchase_zzf;
            this.val$intent = intent;
        }

        public void run() {
            try {
                if (this.zzPy.zzPw.zza(this.zzPx.zzPH, -1, this.val$intent)) {
                    this.zzPy.zzJv.zza(new zzg(this.zzPy.mContext, this.zzPx.zzPI, true, -1, this.val$intent, this.zzPx));
                } else {
                    this.zzPy.zzJv.zza(new zzg(this.zzPy.mContext, this.zzPx.zzPI, false, -1, this.val$intent, this.zzPx));
                }
            } catch (RemoteException e) {
                zzqf.zzbh("Fail to verify and dispatch pending transaction");
            }
        }
    }

    public zzc(Context context, zzli com_google_android_gms_internal_zzli, zzk com_google_android_gms_ads_internal_purchase_zzk) {
        this(context, com_google_android_gms_internal_zzli, com_google_android_gms_ads_internal_purchase_zzk, new zzb(context), zzh.zzu(context.getApplicationContext()));
    }

    zzc(Context context, zzli com_google_android_gms_internal_zzli, zzk com_google_android_gms_ads_internal_purchase_zzk, zzb com_google_android_gms_ads_internal_purchase_zzb, zzh com_google_android_gms_ads_internal_purchase_zzh) {
        this.zzrJ = new Object();
        this.zzPs = false;
        this.zzPv = null;
        this.mContext = context;
        this.zzJv = com_google_android_gms_internal_zzli;
        this.zzPw = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzPt = com_google_android_gms_ads_internal_purchase_zzb;
        this.zzPu = com_google_android_gms_ads_internal_purchase_zzh;
        this.zzPv = this.zzPu.zzg(10);
    }

    private void zze(long j) {
        do {
            if (!zzf(j)) {
                zzpk.m4709v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzPs);
    }

    private boolean zzf(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzrJ.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzqf.zzbh("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzrJ) {
            this.zzPt.zzV(iBinder);
            zziI();
            this.zzPs = true;
            this.zzrJ.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzqf.zzbg("In-app billing service disconnected.");
        this.zzPt.destroy();
    }

    public void onStop() {
        synchronized (this.zzrJ) {
            zza.zzyJ().zza(this.mContext, this);
            this.zzPt.destroy();
        }
    }

    protected void zza(zzf com_google_android_gms_ads_internal_purchase_zzf, String str, String str2) {
        Intent intent = new Intent();
        zzw.zzda();
        intent.putExtra("RESPONSE_CODE", 0);
        zzw.zzda();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzw.zzda();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzpo.zzXC.post(new C09251(this, com_google_android_gms_ads_internal_purchase_zzf, intent));
    }

    public void zzco() {
        synchronized (this.zzrJ) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            zza.zzyJ().zza(this.mContext, intent, (ServiceConnection) this, 1);
            zze(SystemClock.elapsedRealtime());
            zza.zzyJ().zza(this.mContext, this);
            this.zzPt.destroy();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zziI() {
        /*
        r12 = this;
        r0 = r12.zzPv;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = r12.zzPv;
        r1 = r0.iterator();
    L_0x0014:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r1.next();
        r0 = (com.google.android.gms.ads.internal.purchase.zzf) r0;
        r2 = r0.zzPI;
        r6.put(r2, r0);
        goto L_0x0014;
    L_0x0026:
        r0 = 0;
    L_0x0027:
        r1 = r12.zzPt;
        r2 = r12.mContext;
        r2 = r2.getPackageName();
        r0 = r1.zzn(r2, r0);
        if (r0 != 0) goto L_0x0055;
    L_0x0035:
        r0 = r6.keySet();
        r1 = r0.iterator();
    L_0x003d:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0008;
    L_0x0043:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r12.zzPu;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.ads.internal.purchase.zzf) r0;
        r2.zza(r0);
        goto L_0x003d;
    L_0x0055:
        r1 = com.google.android.gms.ads.internal.zzw.zzda();
        r1 = r1.zzd(r0);
        if (r1 != 0) goto L_0x0035;
    L_0x005f:
        r1 = "INAPP_PURCHASE_ITEM_LIST";
        r7 = r0.getStringArrayList(r1);
        r1 = "INAPP_PURCHASE_DATA_LIST";
        r8 = r0.getStringArrayList(r1);
        r1 = "INAPP_DATA_SIGNATURE_LIST";
        r9 = r0.getStringArrayList(r1);
        r1 = "INAPP_CONTINUATION_TOKEN";
        r5 = r0.getString(r1);
        r0 = 0;
        r4 = r0;
    L_0x0079:
        r0 = r7.size();
        if (r4 >= r0) goto L_0x00bb;
    L_0x007f:
        r0 = r7.get(r4);
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x00b7;
    L_0x0089:
        r0 = r7.get(r4);
        r0 = (java.lang.String) r0;
        r1 = r8.get(r4);
        r1 = (java.lang.String) r1;
        r2 = r9.get(r4);
        r2 = (java.lang.String) r2;
        r3 = r6.get(r0);
        r3 = (com.google.android.gms.ads.internal.purchase.zzf) r3;
        r10 = com.google.android.gms.ads.internal.zzw.zzda();
        r10 = r10.zzaE(r1);
        r11 = r3.zzPH;
        r10 = r11.equals(r10);
        if (r10 == 0) goto L_0x00b7;
    L_0x00b1:
        r12.zza(r3, r1, r2);
        r6.remove(r0);
    L_0x00b7:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0079;
    L_0x00bb:
        if (r5 == 0) goto L_0x0035;
    L_0x00bd:
        r0 = r6.isEmpty();
        if (r0 != 0) goto L_0x0035;
    L_0x00c3:
        r0 = r5;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzc.zziI():void");
    }
}
