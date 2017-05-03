package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzac;

public final class zzaum {
    private final Context mContext;
    private final Handler mHandler;
    private final zza zzbvT;

    /* renamed from: com.google.android.gms.internal.zzaum.1 */
    class C11071 implements Runnable {
        final /* synthetic */ int zzabA;
        final /* synthetic */ zzatx zzbtC;
        final /* synthetic */ zzaue zzbtz;
        final /* synthetic */ zzaum zzbvU;

        /* renamed from: com.google.android.gms.internal.zzaum.1.1 */
        class C11061 implements Runnable {
            final /* synthetic */ C11071 zzbvV;

            C11061(C11071 c11071) {
                this.zzbvV = c11071;
            }

            public void run() {
                if (this.zzbvV.zzbvU.zzbvT.callServiceStopSelfResult(this.zzbvV.zzabA)) {
                    this.zzbvV.zzbtz.zzKn().zzLg();
                    this.zzbvV.zzbtC.zzMe().log("Local AppMeasurementService processed last upload request");
                }
            }
        }

        C11071(zzaum com_google_android_gms_internal_zzaum, zzaue com_google_android_gms_internal_zzaue, int i, zzatx com_google_android_gms_internal_zzatx) {
            this.zzbvU = com_google_android_gms_internal_zzaum;
            this.zzbtz = com_google_android_gms_internal_zzaue;
            this.zzabA = i;
            this.zzbtC = com_google_android_gms_internal_zzatx;
        }

        public void run() {
            this.zzbtz.zzML();
            this.zzbtz.zzMG();
            this.zzbvU.mHandler.post(new C11061(this));
        }
    }

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    public zzaum(zza com_google_android_gms_internal_zzaum_zza) {
        this.mContext = com_google_android_gms_internal_zzaum_zza.getContext();
        zzac.zzw(this.mContext);
        this.zzbvT = com_google_android_gms_internal_zzaum_zza;
        this.mHandler = new Handler();
    }

    private zzatx zzKl() {
        return zzaue.zzbM(this.mContext).zzKl();
    }

    public static boolean zzj(Context context, boolean z) {
        zzac.zzw(context);
        return zzaut.zzy(context, z ? "com.google.android.gms.measurement.PackageMeasurementService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    @MainThread
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            zzKl().zzLY().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzauf(zzaue.zzbM(this.mContext));
        }
        zzKl().zzMa().zzj("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public void onCreate() {
        zzaue zzbM = zzaue.zzbM(this.mContext);
        zzatx zzKl = zzbM.zzKl();
        zzbM.zzKn().zzLg();
        zzKl.zzMe().log("Local AppMeasurementService is starting up");
    }

    @MainThread
    public void onDestroy() {
        zzaue zzbM = zzaue.zzbM(this.mContext);
        zzatx zzKl = zzbM.zzKl();
        zzbM.zzKn().zzLg();
        zzKl.zzMe().log("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public void onRebind(Intent intent) {
        if (intent == null) {
            zzKl().zzLY().log("onRebind called with null intent");
            return;
        }
        zzKl().zzMe().zzj("onRebind called. action", intent.getAction());
    }

    @MainThread
    public int onStartCommand(Intent intent, int i, int i2) {
        zzaue zzbM = zzaue.zzbM(this.mContext);
        zzatx zzKl = zzbM.zzKl();
        if (intent == null) {
            zzKl.zzMa().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            zzbM.zzKn().zzLg();
            zzKl.zzMe().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzbM.zzKk().zzm(new C11071(this, zzbM, i2, zzKl));
            }
        }
        return 2;
    }

    @MainThread
    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzKl().zzLY().log("onUnbind called with null intent");
        } else {
            zzKl().zzMe().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
