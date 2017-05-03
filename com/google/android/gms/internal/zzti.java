package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzac;

public final class zzti {
    private static Boolean zzaby;
    private final Context mContext;
    private final Handler mHandler;
    private final zza zzagJ;

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    /* renamed from: com.google.android.gms.internal.zzti.1 */
    class C14211 implements zzsu {
        final /* synthetic */ int zzabA;
        final /* synthetic */ zztd zzabz;
        final /* synthetic */ zzsc zzagK;
        final /* synthetic */ zzti zzagL;

        /* renamed from: com.google.android.gms.internal.zzti.1.1 */
        class C14201 implements Runnable {
            final /* synthetic */ C14211 zzagM;

            C14201(C14211 c14211) {
                this.zzagM = c14211;
            }

            public void run() {
                if (this.zzagM.zzagL.zzagJ.callServiceStopSelfResult(this.zzagM.zzabA)) {
                    this.zzagM.zzabz.zzbP("Local AnalyticsService processed last dispatch request");
                }
            }
        }

        C14211(zzti com_google_android_gms_internal_zzti, int i, zzsc com_google_android_gms_internal_zzsc, zztd com_google_android_gms_internal_zztd) {
            this.zzagL = com_google_android_gms_internal_zzti;
            this.zzabA = i;
            this.zzagK = com_google_android_gms_internal_zzsc;
            this.zzabz = com_google_android_gms_internal_zztd;
        }

        public void zzf(Throwable th) {
            this.zzagL.mHandler.post(new C14201(this));
        }
    }

    public zzti(zza com_google_android_gms_internal_zzti_zza) {
        this.mContext = com_google_android_gms_internal_zzti_zza.getContext();
        zzac.zzw(this.mContext);
        this.zzagJ = com_google_android_gms_internal_zzti_zza;
        this.mHandler = new Handler();
    }

    public static boolean zzal(Context context) {
        zzac.zzw(context);
        if (zzaby != null) {
            return zzaby.booleanValue();
        }
        boolean zzy = zztm.zzy(context, "com.google.android.gms.analytics.AnalyticsService");
        zzaby = Boolean.valueOf(zzy);
        return zzy;
    }

    private void zzmt() {
        try {
            synchronized (zzth.zztX) {
                zzbay com_google_android_gms_internal_zzbay = zzth.zzabw;
                if (com_google_android_gms_internal_zzbay != null && com_google_android_gms_internal_zzbay.isHeld()) {
                    com_google_android_gms_internal_zzbay.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onCreate() {
        zzsc.zzan(this.mContext).zznS().zzbP("Local AnalyticsService is starting up");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzsc.zzan(this.mContext).zznS().zzbP("Local AnalyticsService is shutting down");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int i, int i2) {
        zzmt();
        zzsc zzan = zzsc.zzan(this.mContext);
        zztd zznS = zzan.zznS();
        if (intent == null) {
            zznS.zzbS("AnalyticsService started with null intent");
        } else {
            String action = intent.getAction();
            zznS.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                zzan.zzmA().zza(new C14211(this, i2, zzan, zznS));
            }
        }
        return 2;
    }
}
