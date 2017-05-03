package com.facebook.ads.internal.p024b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.C0439c;
import com.facebook.ads.internal.C0655k;

/* renamed from: com.facebook.ads.internal.b.af */
public class af extends BroadcastReceiver {
    private String f860a;
    private ae f861b;
    private ad f862c;

    public af(String str, ad adVar, ae aeVar) {
        this.f862c = adVar;
        this.f861b = aeVar;
        this.f860a = str;
    }

    public IntentFilter m1235a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C0655k.REWARDED_VIDEO_COMPLETE.m2099a(this.f860a));
        intentFilter.addAction(C0655k.REWARDED_VIDEO_ERROR.m2099a(this.f860a));
        intentFilter.addAction(C0655k.REWARDED_VIDEO_AD_CLICK.m2099a(this.f860a));
        intentFilter.addAction(C0655k.REWARDED_VIDEO_IMPRESSION.m2099a(this.f860a));
        intentFilter.addAction(C0655k.REWARDED_VIDEO_CLOSED.m2099a(this.f860a));
        intentFilter.addAction(C0655k.REWARD_SERVER_SUCCESS.m2099a(this.f860a));
        intentFilter.addAction(C0655k.REWARD_SERVER_FAILED.m2099a(this.f860a));
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (C0655k.REWARDED_VIDEO_COMPLETE.m2099a(this.f860a).equals(action)) {
            this.f861b.m1138d(this.f862c);
        } else if (C0655k.REWARDED_VIDEO_ERROR.m2099a(this.f860a).equals(action)) {
            this.f861b.m1135a(this.f862c, C0439c.f740e);
        } else if (C0655k.REWARDED_VIDEO_AD_CLICK.m2099a(this.f860a).equals(action)) {
            this.f861b.m1136b(this.f862c);
        } else if (C0655k.REWARDED_VIDEO_IMPRESSION.m2099a(this.f860a).equals(action)) {
            this.f861b.m1137c(this.f862c);
        } else if (C0655k.REWARDED_VIDEO_CLOSED.m2099a(this.f860a).equals(action)) {
            this.f861b.m1133a();
        } else if (C0655k.REWARD_SERVER_FAILED.m2099a(this.f860a).equals(action)) {
            this.f861b.m1139e(this.f862c);
        } else if (C0655k.REWARD_SERVER_SUCCESS.m2099a(this.f860a).equals(action)) {
            this.f861b.m1140f(this.f862c);
        }
    }
}
