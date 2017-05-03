package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public class zztc {
    private static volatile Logger zzagr;

    static {
        setLogger(new zzsq());
    }

    public static Logger getLogger() {
        return zzagr;
    }

    public static void setLogger(Logger logger) {
        zzagr = logger;
    }

    public static void m4710v(String str) {
        zztd zzpW = zztd.zzpW();
        if (zzpW != null) {
            zzpW.zzbP(str);
        } else if (zzak(0)) {
            Log.v((String) zzsw.zzafl.get(), str);
        }
        Logger logger = zzagr;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static boolean zzak(int i) {
        return getLogger() != null && getLogger().getLogLevel() <= i;
    }

    public static void zzbh(String str) {
        zztd zzpW = zztd.zzpW();
        if (zzpW != null) {
            zzpW.zzbS(str);
        } else if (zzak(2)) {
            Log.w((String) zzsw.zzafl.get(), str);
        }
        Logger logger = zzagr;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static void zzf(String str, Object obj) {
        zztd zzpW = zztd.zzpW();
        if (zzpW != null) {
            zzpW.zze(str, obj);
        } else if (zzak(3)) {
            String stringBuilder;
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()).append(str).append(":").append(valueOf).toString();
            } else {
                stringBuilder = str;
            }
            Log.e((String) zzsw.zzafl.get(), stringBuilder);
        }
        Logger logger = zzagr;
        if (logger != null) {
            logger.error(str);
        }
    }
}
