package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@zzme
public final class zzpk extends zzqf {
    public static void m4709v(String str) {
        if (zzkI()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzkH() {
        return ((Boolean) zzgd.zzDr.get()).booleanValue();
    }

    public static boolean zzkI() {
        return zzqf.zzak(2) && zzkH();
    }
}
