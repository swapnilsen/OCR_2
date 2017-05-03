package p000a.p001a.p002a.p003a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p000a.p001a.p002a.p003a.p004a.p006b.ApiKey;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.DeliveryMechanism;
import p000a.p001a.p002a.p003a.p004a.p010e.DefaultHttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p012g.AppRequestData;
import p000a.p001a.p002a.p003a.p004a.p012g.AppSettingsData;
import p000a.p001a.p002a.p003a.p004a.p012g.CreateAppSpiCall;
import p000a.p001a.p002a.p003a.p004a.p012g.IconRequest;
import p000a.p001a.p002a.p003a.p004a.p012g.Settings;
import p000a.p001a.p002a.p003a.p004a.p012g.SettingsData;
import p000a.p001a.p002a.p003a.p004a.p012g.UpdateAppSpiCall;

/* renamed from: a.a.a.a.m */
class Onboarding extends Kit<Boolean> {
    private final HttpRequestFactory f329a;
    private PackageManager f330b;
    private String f331c;
    private PackageInfo f332d;
    private String f333e;
    private String f334f;
    private String f335g;
    private String f336h;
    private String f337i;
    private final Future<Map<String, KitInfo>> f338j;
    private final Collection<Kit> f339k;

    protected /* synthetic */ Object doInBackground() {
        return m431a();
    }

    public Onboarding(Future<Map<String, KitInfo>> future, Collection<Kit> collection) {
        this.f329a = new DefaultHttpRequestFactory();
        this.f338j = future;
        this.f339k = collection;
    }

    public String getVersion() {
        return "1.3.15.167";
    }

    protected boolean onPreExecute() {
        try {
            this.f335g = getIdManager().m105j();
            this.f330b = getContext().getPackageManager();
            this.f331c = getContext().getPackageName();
            this.f332d = this.f330b.getPackageInfo(this.f331c, 0);
            this.f333e = Integer.toString(this.f332d.versionCode);
            this.f334f = this.f332d.versionName == null ? "0.0" : this.f332d.versionName;
            this.f336h = this.f330b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.f337i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            Fabric.m397h().m367e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean m431a() {
        boolean a;
        String k = CommonUtils.m78k(getContext());
        SettingsData c = m429c();
        if (c != null) {
            try {
                Map map;
                if (this.f338j != null) {
                    map = (Map) this.f338j.get();
                } else {
                    map = new HashMap();
                }
                a = m427a(k, c.f269a, m432a(map, this.f339k).values());
            } catch (Throwable e) {
                Fabric.m397h().m367e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private SettingsData m429c() {
        try {
            Settings.m347a().m349a(this, this.idManager, this.f329a, this.f333e, this.f334f, m433b()).m351c();
            return Settings.m347a().m350b();
        } catch (Throwable e) {
            Fabric.m397h().m367e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, KitInfo> m432a(Map<String, KitInfo> map, Collection<Kit> collection) {
        for (Kit kit : collection) {
            if (!map.containsKey(kit.getIdentifier())) {
                map.put(kit.getIdentifier(), new KitInfo(kit.getIdentifier(), kit.getVersion(), "binary"));
            }
        }
        return map;
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean m427a(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        if ("new".equals(appSettingsData.f224b)) {
            if (m428b(str, appSettingsData, collection)) {
                return Settings.m347a().m352d();
            }
            Fabric.m397h().m367e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(appSettingsData.f224b)) {
            return Settings.m347a().m352d();
        } else {
            if (!appSettingsData.f227e) {
                return true;
            }
            Fabric.m397h().m359a("Fabric", "Server says an update is required - forcing a full App update.");
            m430c(str, appSettingsData, collection);
            return true;
        }
    }

    private boolean m428b(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return new CreateAppSpiCall(this, m433b(), appSettingsData.f225c, this.f329a).m314a(m425a(IconRequest.m345a(getContext(), str), (Collection) collection));
    }

    private boolean m430c(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return m426a(appSettingsData, IconRequest.m345a(getContext(), str), (Collection) collection);
    }

    private boolean m426a(AppSettingsData appSettingsData, IconRequest iconRequest, Collection<KitInfo> collection) {
        return new UpdateAppSpiCall(this, m433b(), appSettingsData.f225c, this.f329a).m354a(m425a(iconRequest, (Collection) collection));
    }

    private AppRequestData m425a(IconRequest iconRequest, Collection<KitInfo> collection) {
        return new AppRequestData(new ApiKey().m32a(getContext()), getIdManager().m98c(), this.f334f, this.f333e, CommonUtils.m52a(CommonUtils.m80m(r0)), this.f336h, DeliveryMechanism.m85a(this.f335g).m86a(), this.f337i, "0", iconRequest, collection);
    }

    String m433b() {
        return CommonUtils.m65b(getContext(), "com.crashlytics.ApiEndpoint");
    }
}
