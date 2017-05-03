package p000a.p001a.p002a.p003a.p004a.p012g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.CurrentTimeProvider;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStore;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStoreImpl;

/* renamed from: a.a.a.a.a.g.j */
class DefaultSettingsController implements SettingsController {
    private final SettingsRequest f232a;
    private final SettingsJsonTransform f233b;
    private final CurrentTimeProvider f234c;
    private final CachedSettingsIo f235d;
    private final SettingsSpiCall f236e;
    private final Kit f237f;
    private final PreferenceStore f238g;

    public DefaultSettingsController(Kit kit, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonTransform settingsJsonTransform, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall) {
        this.f237f = kit;
        this.f232a = settingsRequest;
        this.f234c = currentTimeProvider;
        this.f233b = settingsJsonTransform;
        this.f235d = cachedSettingsIo;
        this.f236e = settingsSpiCall;
        this.f238g = new PreferenceStoreImpl(this.f237f);
    }

    public SettingsData m321a() {
        return m322a(SettingsCacheBehavior.USE_CACHE);
    }

    public SettingsData m322a(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        SettingsData settingsData;
        Throwable th2;
        SettingsData settingsData2 = null;
        try {
            if (!(Fabric.m398i() || m326d())) {
                settingsData2 = m320b(settingsCacheBehavior);
            }
            if (settingsData2 == null) {
                try {
                    JSONObject a = this.f236e.m337a(this.f232a);
                    if (a != null) {
                        settingsData2 = this.f233b.m327a(this.f234c, a);
                        this.f235d.m313a(settingsData2.f275g, a);
                        m319a(a, "Loaded settings: ");
                        m323a(m324b());
                    }
                } catch (Throwable e) {
                    th = e;
                    settingsData = settingsData2;
                    th2 = th;
                    Fabric.m397h().m367e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return settingsData;
                }
            }
            settingsData = settingsData2;
            if (settingsData == null) {
                try {
                    settingsData = m320b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
                } catch (Exception e2) {
                    th2 = e2;
                    Fabric.m397h().m367e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return settingsData;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            settingsData = null;
            th2 = th;
            Fabric.m397h().m367e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
            return settingsData;
        }
        return settingsData;
    }

    private SettingsData m320b(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject a = this.f235d.m312a();
            if (a != null) {
                SettingsData a2 = this.f233b.m327a(this.f234c, a);
                if (a2 != null) {
                    m319a(a, "Loaded cached settings: ");
                    long a3 = this.f234c.m84a();
                    if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !a2.m353a(a3)) {
                        try {
                            Fabric.m397h().m359a("Fabric", "Returning cached settings.");
                            return a2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            settingsData = a2;
                            th = th2;
                            Fabric.m397h().m367e("Fabric", "Failed to get cached settings", th);
                            return settingsData;
                        }
                    }
                    Fabric.m397h().m359a("Fabric", "Cached settings have expired.");
                    return null;
                }
                Fabric.m397h().m367e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            Fabric.m397h().m359a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            th = e2;
            Fabric.m397h().m367e("Fabric", "Failed to get cached settings", th);
            return settingsData;
        }
    }

    private void m319a(JSONObject jSONObject, String str) {
        Fabric.m397h().m359a("Fabric", str + jSONObject.toString());
    }

    String m324b() {
        return CommonUtils.m52a(CommonUtils.m80m(this.f237f.getContext()));
    }

    String m325c() {
        return this.f238g.m301a().getString("existing_instance_identifier", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean m323a(String str) {
        Editor b = this.f238g.m303b();
        b.putString("existing_instance_identifier", str);
        return this.f238g.m302a(b);
    }

    boolean m326d() {
        return !m325c().equals(m324b());
    }
}
