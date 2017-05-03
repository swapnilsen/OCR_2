package com.facebook.ads.internal.p032i;

import com.facebook.ads.internal.p024b.C0485k;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.i.a */
public class C0594a {
    private static final String[] f1383a;
    private static final String[] f1384b;
    private static final String[] f1385c;

    /* renamed from: com.facebook.ads.internal.i.a.1 */
    static /* synthetic */ class C05931 {
        static final /* synthetic */ int[] f1382a;

        static {
            f1382a = new int[C0485k.values().length];
            try {
                f1382a[C0485k.AN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1382a[C0485k.YAHOO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1382a[C0485k.INMOBI.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1382a[C0485k.ADMOB.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f1383a = new String[]{"com.flurry.android.FlurryAgent", "com.flurry.android.ads.FlurryAdErrorType", "com.flurry.android.ads.FlurryAdNative", "com.flurry.android.ads.FlurryAdNativeAsset", "com.flurry.android.ads.FlurryAdNativeListener"};
        f1384b = new String[]{"com.inmobi.ads.InMobiNative", "com.inmobi.sdk.InMobiSdk"};
        f1385c = new String[]{"com.google.android.gms.ads.formats.NativeAdView"};
    }

    public static boolean m1855a(C0485k c0485k) {
        switch (C05931.f1382a[c0485k.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return true;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return C0594a.m1857a(f1383a);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return C0594a.m1857a(f1384b);
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return C0594a.m1857a(f1385c);
            default:
                return false;
        }
    }

    private static boolean m1856a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean m1857a(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String a : strArr) {
            if (!C0594a.m1856a(a)) {
                return false;
            }
        }
        return true;
    }
}
