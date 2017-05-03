package com.google.android.gms.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.zzac;

public class zzst extends zzsa {
    private boolean zzafg;
    private boolean zzafh;
    private AlarmManager zzafi;

    protected zzst(zzsc com_google_android_gms_internal_zzsc) {
        super(com_google_android_gms_internal_zzsc);
        this.zzafi = (AlarmManager) getContext().getSystemService(NotificationCompatApi24.CATEGORY_ALARM);
    }

    private PendingIntent zzpE() {
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public void cancel() {
        zzob();
        this.zzafh = false;
        this.zzafi.cancel(zzpE());
    }

    public void schedule() {
        zzob();
        zzac.zza(zzpD(), (Object) "Receiver not registered");
        long zzpe = zznT().zzpe();
        if (zzpe > 0) {
            cancel();
            long elapsedRealtime = zznR().elapsedRealtime() + zzpe;
            this.zzafh = true;
            this.zzafi.setInexactRepeating(2, elapsedRealtime, 0, zzpE());
        }
    }

    public boolean zzcy() {
        return this.zzafh;
    }

    protected void zzmS() {
        try {
            this.zzafi.cancel(zzpE());
            if (zznT().zzpe() > 0) {
                ActivityInfo receiverInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    zzbP("Receiver registered. Using alarm for local dispatch.");
                    this.zzafg = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public boolean zzpD() {
        return this.zzafg;
    }
}
