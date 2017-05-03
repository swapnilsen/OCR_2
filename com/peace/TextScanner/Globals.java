package com.peace.TextScanner;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.analytics.Tracker;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.peace.TextScanner.a */
class Globals implements UncaughtExceptionHandler {
    private Context f5053a;
    private UncaughtExceptionHandler f5054b;
    private Tracker f5055c;

    public Globals(Context context) {
        this.f5053a = context;
        this.f5054b = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        SharedPreferences sharedPreferences = this.f5053a.getSharedPreferences("info", 0);
        int i = sharedPreferences.getInt("uncaughtException", 0);
        if (i < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            Editor edit = sharedPreferences.edit();
            edit.putInt("uncaughtException", i + 1);
            edit.commit();
        }
        this.f5054b.uncaughtException(thread, th);
    }

    void m5567a(Tracker tracker) {
        this.f5055c = tracker;
    }
}
