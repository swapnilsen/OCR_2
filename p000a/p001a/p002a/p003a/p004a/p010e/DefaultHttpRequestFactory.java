package p000a.p001a.p002a.p003a.p004a.p010e;

import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import net.nend.android.NendIconError;
import p000a.p001a.p002a.p003a.DefaultLogger;
import p000a.p001a.p002a.p003a.Logger;

/* renamed from: a.a.a.a.a.e.b */
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    private final Logger f158a;
    private PinningInfoProvider f159b;
    private SSLSocketFactory f160c;
    private boolean f161d;

    /* renamed from: a.a.a.a.a.e.b.1 */
    static /* synthetic */ class DefaultHttpRequestFactory {
        static final /* synthetic */ int[] f157a;

        static {
            f157a = new int[HttpMethod.values().length];
            try {
                f157a[HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f157a[HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f157a[HttpMethod.PUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f157a[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public DefaultHttpRequestFactory() {
        this(new DefaultLogger());
    }

    public DefaultHttpRequestFactory(Logger logger) {
        this.f158a = logger;
    }

    public void m222a(PinningInfoProvider pinningInfoProvider) {
        if (this.f159b != pinningInfoProvider) {
            this.f159b = pinningInfoProvider;
            m216a();
        }
    }

    private synchronized void m216a() {
        this.f161d = false;
        this.f160c = null;
    }

    public HttpRequest m220a(HttpMethod httpMethod, String str) {
        return m221a(httpMethod, str, Collections.emptyMap());
    }

    public HttpRequest m221a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest a;
        switch (DefaultHttpRequestFactory.f157a[httpMethod.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                a = HttpRequest.m235a((CharSequence) str, (Map) map, true);
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                a = HttpRequest.m240b((CharSequence) str, (Map) map, true);
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                a = HttpRequest.m243d((CharSequence) str);
                break;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                a = HttpRequest.m244e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m217a(str) && this.f159b != null) {
            SSLSocketFactory b = m218b();
            if (b != null) {
                ((HttpsURLConnection) a.m262a()).setSSLSocketFactory(b);
            }
        }
        return a;
    }

    private boolean m217a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory m218b() {
        if (this.f160c == null && !this.f161d) {
            this.f160c = m219c();
        }
        return this.f160c;
    }

    private synchronized SSLSocketFactory m219c() {
        SSLSocketFactory a;
        this.f161d = true;
        try {
            a = NetworkUtils.m288a(this.f159b);
            this.f158a.m359a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f158a.m367e("Fabric", "Exception while validating pinned certs", e);
            a = null;
        }
        return a;
    }
}
