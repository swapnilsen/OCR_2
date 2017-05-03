package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzac;

public final class zzth {
    static zzbay zzabw;
    static Boolean zzabx;
    static Object zztX;

    static {
        zztX = new Object();
    }

    public static boolean zzak(Context context) {
        zzac.zzw(context);
        if (zzabx != null) {
            return zzabx.booleanValue();
        }
        boolean zza = zztm.zza(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        zzabx = Boolean.valueOf(zza);
        return zza;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zztd zznS = zzsc.zzan(context).zznS();
        if (intent == null) {
            zznS.zzbS("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zznS.zza("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zzal = zzti.zzal(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (zztX) {
                context.startService(intent2);
                if (zzal) {
                    try {
                        if (zzabw == null) {
                            zzabw = new zzbay(context, 1, "Analytics WakeLock");
                            zzabw.setReferenceCounted(false);
                        }
                        zzabw.acquire(1000);
                    } catch (SecurityException e) {
                        zznS.zzbS("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
