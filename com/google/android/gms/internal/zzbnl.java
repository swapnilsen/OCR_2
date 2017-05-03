package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import com.google.firebase.crash.FirebaseCrash;

public class zzbnl {
    private final Context mContext;
    private boolean zzbZh;
    private AppMeasurement zzbZi;
    final zzc zzbZj;

    /* renamed from: com.google.android.gms.internal.zzbnl.1 */
    class C11281 implements zzc {
        C11281(zzbnl com_google_android_gms_internal_zzbnl) {
        }

        public void zzc(String str, String str2, Bundle bundle, long j) {
            if (!str.equals("crash")) {
                FirebaseCrash.m5089a(str2, j, bundle);
            }
        }
    }

    public zzbnl(Context context) {
        this.zzbZh = false;
        this.zzbZi = null;
        this.zzbZj = new C11281(this);
        this.mContext = context;
        try {
            this.zzbZi = AppMeasurement.getInstance(this.mContext);
        } catch (NoClassDefFoundError e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseCrashAnalytics", new StringBuilder(String.valueOf(valueOf).length() + 50).append("Unable to log event, missing measurement library: ").append(valueOf).toString());
        }
    }

    private void zzR(Bundle bundle) {
        if (this.zzbZi != null) {
            this.zzbZi.logEventInternal("crash", "_ae", bundle);
        }
    }

    public void zzWB() {
        try {
            if (!this.zzbZh && this.zzbZi != null) {
                this.zzbZi.zza(this.zzbZj);
                this.zzbZh = true;
            }
        } catch (IllegalStateException e) {
            Log.d("FirebaseCrashAnalytics", "Firebase Analytics breadcrumbs is not supported");
        }
    }

    public void zza(boolean z, long j) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("fatal", 1);
        } else {
            bundle.putInt("fatal", 0);
        }
        bundle.putLong("timestamp", j);
        zzR(bundle);
    }
}
