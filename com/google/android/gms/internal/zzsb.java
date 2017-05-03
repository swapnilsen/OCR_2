package com.google.android.gms.internal;

import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.common.zze;

public class zzsb {
    public static final String VERSION;
    public static final String zzadQ;

    static {
        VERSION = String.valueOf(zze.GOOGLE_PLAY_SERVICES_VERSION_CODE / PointerIconCompat.TYPE_DEFAULT).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        String str = "ma";
        String valueOf = String.valueOf(VERSION);
        zzadQ = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
