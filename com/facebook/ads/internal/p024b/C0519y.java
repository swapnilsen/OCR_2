package com.facebook.ads.internal.p024b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.C0439c;

/* renamed from: com.facebook.ads.internal.b.y */
public class C0519y extends BroadcastReceiver {
    private String f1093a;
    private Context f1094b;
    private C0459e f1095c;
    private C0474d f1096d;

    public C0519y(Context context, String str, C0474d c0474d, C0459e c0459e) {
        this.f1094b = context;
        this.f1093a = str;
        this.f1095c = c0459e;
        this.f1096d = c0474d;
    }

    public void m1555a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.f1093a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f1093a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.f1093a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.f1093a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + this.f1093a);
        LocalBroadcastManager.getInstance(this.f1094b).registerReceiver(this, intentFilter);
    }

    public void m1556b() {
        try {
            LocalBroadcastManager.getInstance(this.f1094b).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        Object obj = intent.getAction().split(":")[0];
        if (this.f1095c != null && obj != null) {
            if ("com.facebook.ads.interstitial.clicked".equals(obj)) {
                this.f1095c.m1159a(this.f1096d, null, true);
            } else if ("com.facebook.ads.interstitial.dismissed".equals(obj)) {
                this.f1095c.m1162d(this.f1096d);
            } else if ("com.facebook.ads.interstitial.displayed".equals(obj)) {
                this.f1095c.m1161c(this.f1096d);
            } else if ("com.facebook.ads.interstitial.impression.logged".equals(obj)) {
                this.f1095c.m1160b(this.f1096d);
            } else if ("com.facebook.ads.interstitial.error".equals(obj)) {
                this.f1095c.m1158a(this.f1096d, C0439c.f740e);
            }
        }
    }
}
