package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzsq implements Logger {
    private boolean zzabL;
    private int zzafc;

    zzsq() {
        this.zzafc = 2;
    }

    public void error(Exception exception) {
    }

    public void error(String str) {
    }

    public int getLogLevel() {
        return this.zzafc;
    }

    public void info(String str) {
    }

    public void setLogLevel(int i) {
        this.zzafc = i;
        if (!this.zzabL) {
            String str = (String) zzsw.zzafl.get();
            Log.i((String) zzsw.zzafl.get(), new StringBuilder(String.valueOf(str).length() + 91).append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG").toString());
            this.zzabL = true;
        }
    }

    public void verbose(String str) {
    }

    public void warn(String str) {
    }
}
