package p000a.p001a.p002a.p003a.p004a.p012g;

import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.AbstractSpiCall;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpMethod;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequest;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;

/* renamed from: a.a.a.a.a.g.l */
class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(kit, str, str2, httpRequestFactory, HttpMethod.GET);
    }

    DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    public JSONObject m343a(SettingsRequest settingsRequest) {
        HttpRequest httpRequest = null;
        try {
            Map b = m341b(settingsRequest);
            httpRequest = m338a(getHttpRequest(b), settingsRequest);
            Fabric.m397h().m359a("Fabric", "Requesting settings from " + getUrl());
            Fabric.m397h().m359a("Fabric", "Settings query params were: " + b);
            JSONObject a = m342a(httpRequest);
            return a;
        } finally {
            if (httpRequest != null) {
                Fabric.m397h().m359a("Fabric", "Settings request ID: " + httpRequest.m265b(AbstractSpiCall.HEADER_REQUEST_ID));
            }
        }
    }

    JSONObject m342a(HttpRequest httpRequest) {
        int b = httpRequest.m263b();
        Fabric.m397h().m359a("Fabric", "Settings result was: " + b);
        if (m344a(b)) {
            return m339a(httpRequest.m274e());
        }
        Fabric.m397h().m366e("Fabric", "Failed to retrieve settings from " + getUrl());
        return null;
    }

    boolean m344a(int i) {
        return i == HttpStatusCodes.STATUS_CODE_OK || i == 201 || i == 202 || i == 203;
    }

    private JSONObject m339a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            Fabric.m397h().m360a("Fabric", "Failed to parse settings JSON from " + getUrl(), e);
            Fabric.m397h().m359a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> m341b(SettingsRequest settingsRequest) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.f288j);
        hashMap.put("display_version", settingsRequest.f287i);
        hashMap.put(Param.SOURCE, Integer.toString(settingsRequest.f289k));
        if (settingsRequest.f290l != null) {
            hashMap.put("icon_hash", settingsRequest.f290l);
        }
        String str = settingsRequest.f286h;
        if (!CommonUtils.m70c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private HttpRequest m338a(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        m340a(httpRequest, AbstractSpiCall.HEADER_API_KEY, settingsRequest.f279a);
        m340a(httpRequest, AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE);
        m340a(httpRequest, AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
        m340a(httpRequest, AbstractSpiCall.HEADER_ACCEPT, AbstractSpiCall.ACCEPT_JSON_VALUE);
        m340a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f280b);
        m340a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.f281c);
        m340a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.f282d);
        m340a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", settingsRequest.f283e);
        m340a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.f284f);
        m340a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", settingsRequest.f285g);
        return httpRequest;
    }

    private void m340a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.m253a(str, str2);
        }
    }
}
