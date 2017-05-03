package p000a.p001a.p002a.p003a.p004a.p012g;

import com.google.api.client.http.HttpMethods;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.KitInfo;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.ResponseParser;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpMethod;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequest;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;

/* renamed from: a.a.a.a.a.g.a */
abstract class AbstractAppSpiCall extends AbstractSpiCall {
    public AbstractAppSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    public boolean m310a(AppRequestData appRequestData) {
        HttpRequest b = m308b(m307a(getHttpRequest(), appRequestData), appRequestData);
        Fabric.m397h().m359a("Fabric", "Sending app info to " + getUrl());
        if (appRequestData.f221j != null) {
            Fabric.m397h().m359a("Fabric", "App icon hash is " + appRequestData.f221j.f243a);
            Fabric.m397h().m359a("Fabric", "App icon size is " + appRequestData.f221j.f245c + "x" + appRequestData.f221j.f246d);
        }
        int b2 = b.m263b();
        Fabric.m397h().m359a("Fabric", (HttpMethods.POST.equals(b.m287p()) ? "Create" : "Update") + " app request ID: " + b.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
        Fabric.m397h().m359a("Fabric", "Result was " + b2);
        if (ResponseParser.m139a(b2) == 0) {
            return true;
        }
        return false;
    }

    private HttpRequest m307a(HttpRequest httpRequest, AppRequestData appRequestData) {
        return httpRequest.m253a(AbstractSpiCall.HEADER_API_KEY, appRequestData.f212a).m253a(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).m253a(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
    }

    private HttpRequest m308b(HttpRequest httpRequest, AppRequestData appRequestData) {
        HttpRequest e = httpRequest.m273e("app[identifier]", appRequestData.f213b).m273e("app[name]", appRequestData.f217f).m273e("app[display_version]", appRequestData.f214c).m273e("app[build_version]", appRequestData.f215d).m252a("app[source]", Integer.valueOf(appRequestData.f218g)).m273e("app[minimum_sdk_version]", appRequestData.f219h).m273e("app[built_sdk_version]", appRequestData.f220i);
        if (!CommonUtils.m70c(appRequestData.f216e)) {
            e.m273e("app[instance_identifier]", appRequestData.f216e);
        }
        if (appRequestData.f221j != null) {
            Closeable closeable = null;
            try {
                closeable = this.kit.getContext().getResources().openRawResource(appRequestData.f221j.f244b);
                e.m273e("app[icon][hash]", appRequestData.f221j.f243a).m257a("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) closeable).m252a("app[icon][width]", Integer.valueOf(appRequestData.f221j.f245c)).m252a("app[icon][height]", Integer.valueOf(appRequestData.f221j.f246d));
            } catch (Throwable e2) {
                Fabric.m397h().m367e("Fabric", "Failed to find app icon with resource ID: " + appRequestData.f221j.f244b, e2);
            } finally {
                String str = "Failed to close app icon InputStream.";
                CommonUtils.m57a(closeable, str);
            }
        }
        if (appRequestData.f222k != null) {
            for (KitInfo kitInfo : appRequestData.f222k) {
                e.m273e(m309a(kitInfo), kitInfo.m423b());
                e.m273e(m311b(kitInfo), kitInfo.m424c());
            }
        }
        return e;
    }

    String m309a(KitInfo kitInfo) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kitInfo.m422a()});
    }

    String m311b(KitInfo kitInfo) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kitInfo.m422a()});
    }
}
