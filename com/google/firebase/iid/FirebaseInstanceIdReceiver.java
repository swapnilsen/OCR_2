package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzt;
import com.google.firebase.iid.C1491b.C1496b;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private static boolean f4534a;
    private C1496b f4535b;
    private C1496b f4536c;

    static {
        f4534a = false;
    }

    private C1496b m5119a(Context context, String str) {
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (this.f4536c == null) {
                this.f4536c = new C1496b(context, str);
            }
            return this.f4536c;
        }
        if (this.f4535b == null) {
            this.f4535b = new C1496b(context, str);
        }
        return this.f4535b;
    }

    public int m5120a(Context context, String str, Intent intent) {
        if (!zzt.zzzq()) {
            return C1505g.m5191a().m5196a(context, str, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
        m5119a(context, str).m5148a(intent, goAsync());
        return -1;
    }

    public void onReceive(Context context, Intent intent) {
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        stringExtra = intent.getStringExtra("from");
        if ("google.com/iid".equals(stringExtra) || "gcm.googleapis.com/refresh".equals(stringExtra)) {
            stringExtra = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            stringExtra = "com.google.firebase.MESSAGING_EVENT";
        } else {
            Log.d("FirebaseInstanceId", "Unexpected intent");
            stringExtra = null;
        }
        int i = -1;
        if (stringExtra != null) {
            i = m5120a(context, stringExtra, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(i);
        }
    }
}
