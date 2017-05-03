package com.google.android.gms.internal;

import android.content.Context;

public class zzadg {
    private static zzadg zzaIA;
    private zzadf zzayE;

    static {
        zzaIA = new zzadg();
    }

    public zzadg() {
        this.zzayE = null;
    }

    public static zzadf zzbi(Context context) {
        return zzaIA.zzbh(context);
    }

    public synchronized zzadf zzbh(Context context) {
        if (this.zzayE == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzayE = new zzadf(context);
        }
        return this.zzayE;
    }
}
