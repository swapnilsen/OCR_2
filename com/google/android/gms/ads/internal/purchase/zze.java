package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf.zza;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqf;

@zzme
public class zze extends zza implements ServiceConnection {
    private final Activity mActivity;
    private Context zzPB;
    private zzld zzPC;
    private zzf zzPD;
    private zzj zzPE;
    private String zzPF;
    private zzb zzPt;
    zzh zzPu;
    private zzk zzPw;

    public zze(Activity activity) {
        this.zzPF = null;
        this.mActivity = activity;
        this.zzPu = zzh.zzu(this.mActivity.getApplicationContext());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == PointerIconCompat.TYPE_CONTEXT_MENU) {
            boolean z = false;
            try {
                int zzd = zzw.zzda().zzd(intent);
                if (i2 == -1) {
                    zzw.zzda();
                    if (zzd == 0) {
                        if (this.zzPw.zza(this.zzPF, i2, intent)) {
                            z = true;
                        }
                        this.zzPC.recordPlayBillingResolution(zzd);
                        this.mActivity.finish();
                        zza(this.zzPC.getProductId(), z, i2, intent);
                    }
                }
                this.zzPu.zza(this.zzPD);
                this.zzPC.recordPlayBillingResolution(zzd);
                this.mActivity.finish();
                zza(this.zzPC.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                zzqf.zzbh("Fail to process purchase result.");
                this.mActivity.finish();
            } finally {
                this.zzPF = null;
            }
        }
    }

    public void onCreate() {
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzPE = zzc.zzPp;
        this.zzPw = zzc.zzvL;
        this.zzPC = zzc.zzPn;
        this.zzPt = new zzb(this.mActivity.getApplicationContext());
        this.zzPB = zzc.zzPo;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzw.zzcO().zzkQ());
        } else {
            this.mActivity.setRequestedOrientation(zzw.zzcO().zzkR());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        com.google.android.gms.common.stats.zza.zzyJ().zza(this.mActivity, intent, (ServiceConnection) this, 1);
    }

    public void onDestroy() {
        com.google.android.gms.common.stats.zza.zzyJ().zza(this.mActivity, this);
        this.zzPt.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.zzPt.zzV(iBinder);
        try {
            this.zzPF = this.zzPw.zziM();
            Bundle zza = this.zzPt.zza(this.mActivity.getPackageName(), this.zzPC.getProductId(), this.zzPF);
            PendingIntent pendingIntent = (PendingIntent) zza.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzd = zzw.zzda().zzd(zza);
                this.zzPC.recordPlayBillingResolution(zzd);
                zza(this.zzPC.getProductId(), false, zzd, null);
                this.mActivity.finish();
                return;
            }
            this.zzPD = new zzf(this.zzPC.getProductId(), this.zzPF);
            this.zzPu.zzb(this.zzPD);
            this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), PointerIconCompat.TYPE_CONTEXT_MENU, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            zzqf.zzc("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        } catch (SendIntentException e3) {
            e = e3;
            zzqf.zzc("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzqf.zzbg("In-app billing service disconnected.");
        this.zzPt.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzPE != null) {
            this.zzPE.zza(str, z, i, intent, this.zzPD);
        }
    }
}
