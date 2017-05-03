package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.zzt;
import com.google.firebase.iid.C1491b.C1496b;

public final class FirebaseInstanceIdInternalReceiver extends WakefulBroadcastReceiver {
    private static boolean f4531a;
    private C1496b f4532b;
    private C1496b f4533c;

    static {
        f4531a = false;
    }

    private C1496b m5118a(Context context, String str) {
        if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
            if (this.f4533c == null) {
                this.f4533c = new C1496b(context, str);
            }
            return this.f4533c;
        }
        if (this.f4532b == null) {
            this.f4532b = new C1496b(context, str);
        }
        return this.f4532b;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (parcelableExtra instanceof Intent) {
                Intent intent2 = (Intent) parcelableExtra;
                if (zzt.zzzq()) {
                    m5118a(context, intent.getAction()).m5148a(intent2, goAsync());
                    return;
                } else {
                    C1505g.m5191a().m5196a(context, intent.getAction(), intent2);
                    return;
                }
            }
            Log.e("FirebaseInstanceId", "Missing or invalid wrapped intent");
        }
    }
}
