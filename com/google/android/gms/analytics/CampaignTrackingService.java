package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzbay;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zztm;

public class CampaignTrackingService extends Service {
    private static Boolean zzaby;
    private Handler mHandler;

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.1 */
    class C09671 implements Runnable {
        final /* synthetic */ int zzabA;
        final /* synthetic */ CampaignTrackingService zzabB;
        final /* synthetic */ zztd zzabz;
        final /* synthetic */ Handler zzs;

        C09671(CampaignTrackingService campaignTrackingService, zztd com_google_android_gms_internal_zztd, Handler handler, int i) {
            this.zzabB = campaignTrackingService;
            this.zzabz = com_google_android_gms_internal_zztd;
            this.zzs = handler;
            this.zzabA = i;
        }

        public void run() {
            this.zzabB.zza(this.zzabz, this.zzs, this.zzabA);
        }
    }

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.2 */
    class C09682 implements Runnable {
        final /* synthetic */ int zzabA;
        final /* synthetic */ CampaignTrackingService zzabB;
        final /* synthetic */ zztd zzabz;
        final /* synthetic */ Handler zzs;

        C09682(CampaignTrackingService campaignTrackingService, zztd com_google_android_gms_internal_zztd, Handler handler, int i) {
            this.zzabB = campaignTrackingService;
            this.zzabz = com_google_android_gms_internal_zztd;
            this.zzs = handler;
            this.zzabA = i;
        }

        public void run() {
            this.zzabB.zza(this.zzabz, this.zzs, this.zzabA);
        }
    }

    /* renamed from: com.google.android.gms.analytics.CampaignTrackingService.3 */
    class C09693 implements Runnable {
        final /* synthetic */ int zzabA;
        final /* synthetic */ CampaignTrackingService zzabB;
        final /* synthetic */ zztd zzabz;

        C09693(CampaignTrackingService campaignTrackingService, int i, zztd com_google_android_gms_internal_zztd) {
            this.zzabB = campaignTrackingService;
            this.zzabA = i;
            this.zzabz = com_google_android_gms_internal_zztd;
        }

        public void run() {
            boolean stopSelfResult = this.zzabB.stopSelfResult(this.zzabA);
            if (stopSelfResult) {
                this.zzabz.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
            }
        }
    }

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        handler = new Handler(getMainLooper());
        this.mHandler = handler;
        return handler;
    }

    public static boolean zzal(Context context) {
        zzac.zzw(context);
        if (zzaby != null) {
            return zzaby.booleanValue();
        }
        boolean zzy = zztm.zzy(context, "com.google.android.gms.analytics.CampaignTrackingService");
        zzaby = Boolean.valueOf(zzy);
        return zzy;
    }

    private void zzmt() {
        try {
            synchronized (CampaignTrackingReceiver.zztX) {
                zzbay com_google_android_gms_internal_zzbay = CampaignTrackingReceiver.zzabw;
                if (com_google_android_gms_internal_zzbay != null && com_google_android_gms_internal_zzbay.isHeld()) {
                    com_google_android_gms_internal_zzbay.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onCreate() {
        super.onCreate();
        zzsc.zzan(this).zznS().zzbP("CampaignTrackingService is starting up");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzsc.zzan(this).zznS().zzbP("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int i, int i2) {
        zzmt();
        zzsc zzan = zzsc.zzan(this);
        zztd zznS = zzan.zznS();
        String stringExtra = intent.getStringExtra("referrer");
        Handler handler = getHandler();
        if (TextUtils.isEmpty(stringExtra)) {
            zznS.zzbS("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            zzan.zznU().zzg(new C09671(this, zznS, handler, i2));
        } else {
            int zzoZ = zzan.zznT().zzoZ();
            if (stringExtra.length() > zzoZ) {
                zznS.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(zzoZ));
                stringExtra = stringExtra.substring(0, zzoZ);
            }
            zznS.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), stringExtra);
            zzan.zzmA().zza(stringExtra, new C09682(this, zznS, handler, i2));
        }
        return 2;
    }

    protected void zza(zztd com_google_android_gms_internal_zztd, Handler handler, int i) {
        handler.post(new C09693(this, i, com_google_android_gms_internal_zztd));
    }
}
