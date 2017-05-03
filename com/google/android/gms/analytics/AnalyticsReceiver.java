package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zzth;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzth zzabp;

    private zzth zzmp() {
        if (this.zzabp == null) {
            this.zzabp = new zzth();
        }
        return this.zzabp;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zzmp().onReceive(context, intent);
    }
}
