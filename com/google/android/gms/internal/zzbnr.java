package com.google.android.gms.internal;

import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.Thread.UncaughtExceptionHandler;

public class zzbnr implements UncaughtExceptionHandler {
    private final FirebaseCrash zzbZn;
    private final UncaughtExceptionHandler zzbZo;

    public zzbnr(UncaughtExceptionHandler uncaughtExceptionHandler, FirebaseCrash firebaseCrash) {
        this.zzbZn = firebaseCrash;
        this.zzbZo = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("UncaughtException", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, th);
        try {
            this.zzbZn.m5096a(th);
        } catch (zzbnm e) {
            try {
                Log.v("UncaughtException", e.getMessage());
            } catch (Throwable e2) {
                Log.e("UncaughtException", "Ouch!  My own exception handler threw an exception.", e2);
            }
        }
        if (this.zzbZo != null) {
            this.zzbZo.uncaughtException(thread, th);
        }
    }
}
