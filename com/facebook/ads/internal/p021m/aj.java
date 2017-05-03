package com.facebook.ads.internal.p021m;

import com.facebook.ads.internal.p024b.C0485k;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.m.aj */
public class aj {

    /* renamed from: com.facebook.ads.internal.m.aj.1 */
    static /* synthetic */ class C06711 {
        static final /* synthetic */ int[] f1599a;

        static {
            f1599a = new int[C0485k.values().length];
            try {
                f1599a[C0485k.ADMOB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1599a[C0485k.YAHOO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1599a[C0485k.INMOBI.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1599a[C0485k.AN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static String m2160a(C0485k c0485k) {
        switch (C06711.f1599a[c0485k.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return "AdMob";
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return "Flurry";
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return "InMobi";
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return "Audience Network";
            default:
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
    }
}
