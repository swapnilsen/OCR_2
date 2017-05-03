package com.facebook.ads.internal.p021m;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.v7.cardview.C0269R;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.C0441e;
import com.facebook.ads.internal.C0565g;
import com.facebook.ads.internal.p031g.C0564i;
import com.facebook.ads.internal.p033j.p034a.C0599a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import net.nend.android.NendIconError;

/* renamed from: com.facebook.ads.internal.m.ak */
public class ak {
    private static String f1608a;
    private static final Set<String> f1609b;
    private static final Set<String> f1610c;

    /* renamed from: com.facebook.ads.internal.m.ak.a */
    public enum C0672a {
        UNKNOWN(0),
        NONE(0),
        MOBILE_INTERNET(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4);
        
        public final int f1607g;

        private C0672a(int i) {
            this.f1607g = i;
        }
    }

    static {
        f1608a = null;
        f1609b = new HashSet(1);
        f1610c = new HashSet(2);
        f1609b.add("1ww8E0AYsR2oX5lndk2hwp2Uosk=\n");
        f1610c.add("toZ2GRnRjC9P5VVUdCpOrFH8lfQ=\n");
        f1610c.add("3lKvjNsfmrn+WmfDhvr2iVh/yRs=\n");
        f1610c.add("B08QtE4yLCdli4rptyqAEczXOeA=\n");
        f1610c.add("XZXI6anZbdKf+taURdnyUH5ipgM=\n");
    }

    public static C0599a m2161a(Context context) {
        return ak.m2162a(context, null);
    }

    public static C0599a m2162a(Context context, C0565g c0565g) {
        C0599a c0599a = new C0599a();
        ak.m2164a(context, c0599a, c0565g);
        return c0599a;
    }

    private static String m2163a(Context context, String str, String str2) {
        Class cls = Class.forName(str);
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, Class.forName(str2)});
        declaredConstructor.setAccessible(true);
        try {
            String str3 = (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(new Object[]{context, null}), new Object[0]);
            return str3;
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    private static void m2164a(Context context, C0599a c0599a, C0565g c0565g) {
        c0599a.m1895c(30000);
        c0599a.m1893b(3);
        c0599a.m1878a("user-agent", ak.m2170c(context, c0565g) + " [FBAN/AudienceNetworkForAndroid;FBSN/" + "Android" + ";FBSV/" + C0564i.f1299a + ";FBAB/" + C0564i.f1302d + ";FBAV/" + C0564i.f1304f + ";FBBV/" + C0564i.f1305g + ";FBVS/" + "4.21.1" + ";FBLC/" + Locale.getDefault().toString() + "]");
    }

    public static boolean m2165a() {
        Object a = C0441e.m1052a();
        return !TextUtils.isEmpty(a) && a.endsWith(".sb");
    }

    public static C0599a m2166b() {
        return ak.m2161a(null);
    }

    public static C0599a m2167b(Context context) {
        return ak.m2168b(context, null);
    }

    public static C0599a m2168b(Context context, C0565g c0565g) {
        C0599a c0599a = new C0599a();
        ak.m2164a(context, c0599a, c0565g);
        if (!ak.m2165a()) {
            c0599a.m1894b(f1610c);
            c0599a.m1887a(f1609b);
        }
        return c0599a;
    }

    public static C0672a m2169c(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return C0672a.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return C0672a.NONE;
        }
        if (activeNetworkInfo.getType() != 0) {
            return C0672a.MOBILE_INTERNET;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.WEBSITE /*7*/:
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return C0672a.MOBILE_2G;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case Type.OTHER_PROFILE /*5*/:
            case Type.CONTRIBUTOR /*6*/:
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
            case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
            case CommonStatusCodes.INTERRUPTED /*14*/:
            case CommonStatusCodes.TIMEOUT /*15*/:
                return C0672a.MOBILE_3G;
            case CommonStatusCodes.ERROR /*13*/:
                return C0672a.MOBILE_4G;
            default:
                return C0672a.UNKNOWN;
        }
    }

    private static String m2170c(Context context, C0565g c0565g) {
        if (context == null) {
            return "Unknown";
        }
        if (c0565g == C0565g.NATIVE_250 || c0565g == C0565g.NATIVE_UNKNOWN || c0565g == null) {
            return System.getProperty("http.agent");
        }
        if (f1608a != null) {
            return f1608a;
        }
        synchronized (ak.class) {
            if (f1608a != null) {
                String str = f1608a;
                return str;
            }
            if (VERSION.SDK_INT >= 17) {
                try {
                    f1608a = ak.m2171d(context);
                    str = f1608a;
                    return str;
                } catch (Exception e) {
                }
            }
            try {
                f1608a = ak.m2163a(context, "android.webkit.WebSettings", "android.webkit.WebView");
            } catch (Exception e2) {
                try {
                    f1608a = ak.m2163a(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                } catch (Exception e3) {
                    WebView webView = new WebView(context.getApplicationContext());
                    f1608a = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            }
            return f1608a;
        }
    }

    @TargetApi(17)
    private static String m2171d(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
