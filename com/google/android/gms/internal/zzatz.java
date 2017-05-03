package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzac;

class zzatz extends BroadcastReceiver {
    static final String zzagv;
    private boolean zzagw;
    private boolean zzagx;
    private final zzaue zzbqc;

    /* renamed from: com.google.android.gms.internal.zzatz.1 */
    class C10661 implements Runnable {
        final /* synthetic */ boolean zzbsV;
        final /* synthetic */ zzatz zzbsW;

        C10661(zzatz com_google_android_gms_internal_zzatz, boolean z) {
            this.zzbsW = com_google_android_gms_internal_zzatz;
            this.zzbsV = z;
        }

        public void run() {
            this.zzbsW.zzbqc.zzW(this.zzbsV);
        }
    }

    static {
        zzagv = zzatz.class.getName();
    }

    zzatz(zzaue com_google_android_gms_internal_zzaue) {
        zzac.zzw(com_google_android_gms_internal_zzaue);
        this.zzbqc = com_google_android_gms_internal_zzaue;
    }

    private Context getContext() {
        return this.zzbqc.getContext();
    }

    private zzatx zzKl() {
        return this.zzbqc.zzKl();
    }

    @WorkerThread
    public boolean isRegistered() {
        this.zzbqc.zzmR();
        return this.zzagw;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzbqc.zzob();
        String action = intent.getAction();
        zzKl().zzMe().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzqa = this.zzbqc.zzMy().zzqa();
            if (this.zzagx != zzqa) {
                this.zzagx = zzqa;
                this.zzbqc.zzKk().zzm(new C10661(this, zzqa));
                return;
            }
            return;
        }
        zzKl().zzMa().zzj("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public void unregister() {
        this.zzbqc.zzob();
        this.zzbqc.zzmR();
        if (isRegistered()) {
            zzKl().zzMe().log("Unregistering connectivity change receiver");
            this.zzagw = false;
            this.zzagx = false;
            try {
                getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzKl().zzLY().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @WorkerThread
    public void zzpX() {
        this.zzbqc.zzob();
        this.zzbqc.zzmR();
        if (!this.zzagw) {
            getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzagx = this.zzbqc.zzMy().zzqa();
            zzKl().zzMe().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzagx));
            this.zzagw = true;
        }
    }
}
