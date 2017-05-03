package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzaub {
    private final zza zzbty;

    /* renamed from: com.google.android.gms.internal.zzaub.1 */
    class C10681 implements Runnable {
        final /* synthetic */ long zzbtA;
        final /* synthetic */ Bundle zzbtB;
        final /* synthetic */ zzatx zzbtC;
        final /* synthetic */ zzaue zzbtz;
        final /* synthetic */ Context zztf;

        C10681(zzaub com_google_android_gms_internal_zzaub, zzaue com_google_android_gms_internal_zzaue, long j, Bundle bundle, Context context, zzatx com_google_android_gms_internal_zzatx) {
            this.zzbtz = com_google_android_gms_internal_zzaue;
            this.zzbtA = j;
            this.zzbtB = bundle;
            this.zztf = context;
            this.zzbtC = com_google_android_gms_internal_zzatx;
        }

        public void run() {
            zzaus zzS = this.zzbtz.zzKg().zzS(this.zzbtz.zzKb().zzke(), "_fot");
            long longValue = (zzS == null || !(zzS.mValue instanceof Long)) ? 0 : ((Long) zzS.mValue).longValue();
            long j = this.zzbtA;
            longValue = (longValue <= 0 || (j < longValue && j > 0)) ? j : longValue - 1;
            if (longValue > 0) {
                this.zzbtB.putLong("click_timestamp", longValue);
            }
            AppMeasurement.getInstance(this.zztf).logEventInternal("auto", "_cmp", this.zzbtB);
            this.zzbtC.zzMe().log("Install campaign recorded");
        }
    }

    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzaub(zza com_google_android_gms_internal_zzaub_zza) {
        zzac.zzw(com_google_android_gms_internal_zzaub_zza);
        this.zzbty = com_google_android_gms_internal_zzaub_zza;
    }

    public static boolean zzi(Context context, boolean z) {
        zzac.zzw(context);
        return zzaut.zza(context, z ? "com.google.android.gms.measurement.PackageMeasurementReceiver" : "com.google.android.gms.measurement.AppMeasurementReceiver", false);
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        zzaue zzbM = zzaue.zzbM(context);
        zzatx zzKl = zzbM.zzKl();
        if (intent == null) {
            zzKl.zzMa().log("Receiver called with null intent");
            return;
        }
        zzbM.zzKn().zzLg();
        String action = intent.getAction();
        zzKl.zzMe().zzj("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzaum.zzj(context, false);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            this.zzbty.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            action = intent.getStringExtra("referrer");
            if (action == null) {
                zzKl.zzMe().log("Install referrer extras are null");
                return;
            }
            Bundle zzu = zzbM.zzKh().zzu(Uri.parse(action));
            if (zzu == null) {
                zzKl.zzMe().log("No campaign defined in install referrer broadcast");
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzKl.zzMa().log("Install referrer is missing timestamp");
            }
            zzbM.zzKk().zzm(new C10681(this, zzbM, longExtra, zzu, context, zzKl));
        }
    }
}
