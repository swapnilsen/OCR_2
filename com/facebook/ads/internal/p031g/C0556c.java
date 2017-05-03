package com.facebook.ads.internal.p031g;

import com.facebook.ads.internal.C0565g;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.g.c */
public enum C0556c {
    UNKNOWN,
    BANNER,
    INTERSTITIAL,
    NATIVE,
    REWARDED_VIDEO;

    /* renamed from: com.facebook.ads.internal.g.c.1 */
    static /* synthetic */ class C05551 {
        static final /* synthetic */ int[] f1251a;

        static {
            f1251a = new int[C0565g.values().length];
            try {
                f1251a[C0565g.NATIVE_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1251a[C0565g.WEBVIEW_BANNER_50.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1251a[C0565g.WEBVIEW_BANNER_90.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1251a[C0565g.WEBVIEW_BANNER_LEGACY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1251a[C0565g.WEBVIEW_BANNER_250.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1251a[C0565g.WEBVIEW_INTERSTITIAL_HORIZONTAL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1251a[C0565g.WEBVIEW_INTERSTITIAL_VERTICAL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f1251a[C0565g.WEBVIEW_INTERSTITIAL_TABLET.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f1251a[C0565g.WEBVIEW_INTERSTITIAL_UNKNOWN.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f1251a[C0565g.REWARDED_VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static C0556c m1717a(C0565g c0565g) {
        switch (C05551.f1251a[c0565g.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return NATIVE;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.OTHER_PROFILE /*5*/:
                return BANNER;
            case Type.CONTRIBUTOR /*6*/:
            case Type.WEBSITE /*7*/:
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return INTERSTITIAL;
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                return REWARDED_VIDEO;
            default:
                return UNKNOWN;
        }
    }
}
