package com.facebook.ads.internal.p024b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.internal.view.C0828h;
import com.facebook.ads.internal.view.p038c.p039a.C0739b;
import com.facebook.ads.internal.view.p038c.p039a.C0743f;
import com.facebook.ads.internal.view.p038c.p039a.C0744g;
import com.facebook.ads.internal.view.p038c.p039a.C0745h;
import com.facebook.ads.internal.view.p038c.p039a.C0747j;
import com.facebook.ads.internal.view.p038c.p039a.C0752p;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.Serializable;

/* renamed from: com.facebook.ads.internal.b.g */
public class C0475g extends BroadcastReceiver {
    private Context f863a;
    private C0828h f864b;
    private boolean f865c;

    public void m1241a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f864b.getUniqueId());
        intentFilter.addAction("videoInterstitalEvent:" + this.f864b.getUniqueId());
        LocalBroadcastManager.getInstance(this.f863a).registerReceiver(this, intentFilter);
    }

    public void m1242b() {
        try {
            LocalBroadcastManager.getInstance(this.f863a).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(":");
        if (split.length != 2 || !split[1].equals(this.f864b.getUniqueId())) {
            return;
        }
        if (split[0].equals("com.facebook.ads.interstitial.displayed")) {
            if (this.f864b.getListener() != null) {
                this.f864b.getListener().m2644f(this.f864b.getMediaView());
                this.f864b.getListener().m2639a(this.f864b.getMediaView(), 1.0f);
            }
        } else if (split[0].equals("videoInterstitalEvent")) {
            Serializable serializableExtra = intent.getSerializableExtra(DataLayer.EVENT_KEY);
            if (serializableExtra instanceof C0752p) {
                if (this.f864b.getListener() != null) {
                    this.f864b.getListener().m2643e(this.f864b.getMediaView());
                    this.f864b.getListener().m2639a(this.f864b.getMediaView(), 0.0f);
                }
                if (this.f865c) {
                    this.f864b.m2546a(1);
                } else {
                    this.f864b.m2546a(((C0752p) serializableExtra).m2378b());
                }
                this.f864b.setVisibility(0);
                this.f864b.m2561d();
            } else if (serializableExtra instanceof C0743f) {
                if (this.f864b.getListener() != null) {
                    this.f864b.getListener().m2641c(this.f864b.getMediaView());
                }
            } else if (serializableExtra instanceof C0744g) {
                if (this.f864b.getListener() != null) {
                    this.f864b.getListener().m2642d(this.f864b.getMediaView());
                }
            } else if (serializableExtra instanceof C0739b) {
                if (this.f864b.getListener() != null) {
                    this.f864b.getListener().m2645g(this.f864b.getMediaView());
                }
                this.f865c = true;
            } else if (serializableExtra instanceof C0747j) {
                if (this.f864b.getListener() != null) {
                    this.f864b.getListener().m2640b(this.f864b.getMediaView());
                }
                this.f865c = false;
            } else if ((serializableExtra instanceof C0745h) && this.f864b.getListener() != null) {
                this.f864b.getListener().m2638a(this.f864b.getMediaView());
            }
        }
    }
}
