package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class DevicePowerStateListener {
    private static final IntentFilter FILTER_BATTERY_CHANGED;
    private static final IntentFilter FILTER_POWER_CONNECTED;
    private static final IntentFilter FILTER_POWER_DISCONNECTED;
    private final Context context;
    private boolean isPowerConnected;
    private final BroadcastReceiver powerConnectedReceiver;
    private final BroadcastReceiver powerDisconnectedReceiver;
    private final AtomicBoolean receiversRegistered;

    /* renamed from: com.crashlytics.android.core.DevicePowerStateListener.1 */
    class C04041 extends BroadcastReceiver {
        C04041() {
        }

        public void onReceive(Context context, Intent intent) {
            DevicePowerStateListener.this.isPowerConnected = true;
        }
    }

    /* renamed from: com.crashlytics.android.core.DevicePowerStateListener.2 */
    class C04052 extends BroadcastReceiver {
        C04052() {
        }

        public void onReceive(Context context, Intent intent) {
            DevicePowerStateListener.this.isPowerConnected = false;
        }
    }

    static {
        FILTER_BATTERY_CHANGED = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        FILTER_POWER_CONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        FILTER_POWER_DISCONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    }

    public DevicePowerStateListener(Context context) {
        int i = -1;
        this.context = context;
        Intent registerReceiver = context.registerReceiver(null, FILTER_BATTERY_CHANGED);
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra(NotificationCompatApi24.CATEGORY_STATUS, -1);
        }
        boolean z = i == 2 || i == 5;
        this.isPowerConnected = z;
        this.powerConnectedReceiver = new C04041();
        this.powerDisconnectedReceiver = new C04052();
        context.registerReceiver(this.powerConnectedReceiver, FILTER_POWER_CONNECTED);
        context.registerReceiver(this.powerDisconnectedReceiver, FILTER_POWER_DISCONNECTED);
        this.receiversRegistered = new AtomicBoolean(true);
    }

    public boolean isPowerConnected() {
        return this.isPowerConnected;
    }

    public void dispose() {
        if (this.receiversRegistered.getAndSet(false)) {
            this.context.unregisterReceiver(this.powerConnectedReceiver);
            this.context.unregisterReceiver(this.powerDisconnectedReceiver);
        }
    }
}
