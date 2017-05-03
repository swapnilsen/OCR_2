package p000a.p001a.p002a.p003a.p004a.p012g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.ApiKey;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.DeliveryMechanism;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;
import p000a.p001a.p002a.p003a.p004a.p006b.SystemCurrentTimeProvider;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;

/* renamed from: a.a.a.a.a.g.q */
public class Settings {
    private final AtomicReference<SettingsData> f261a;
    private final CountDownLatch f262b;
    private SettingsController f263c;
    private boolean f264d;

    /* renamed from: a.a.a.a.a.g.q.a */
    static class Settings {
        private static final Settings f260a;

        static {
            f260a = new Settings();
        }
    }

    public static Settings m347a() {
        return Settings.f260a;
    }

    private Settings() {
        this.f261a = new AtomicReference();
        this.f262b = new CountDownLatch(1);
        this.f264d = false;
    }

    public synchronized Settings m349a(Kit kit, IdManager idManager, HttpRequestFactory httpRequestFactory, String str, String str2, String str3) {
        Settings settings;
        if (this.f264d) {
            settings = this;
        } else {
            if (this.f263c == null) {
                Context context = kit.getContext();
                String c = idManager.m98c();
                String a = new ApiKey().m32a(context);
                String j = idManager.m105j();
                SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
                DefaultSettingsJsonTransform defaultSettingsJsonTransform = new DefaultSettingsJsonTransform();
                DefaultCachedSettingsIo defaultCachedSettingsIo = new DefaultCachedSettingsIo(kit);
                String k = CommonUtils.m78k(context);
                Kit kit2 = kit;
                String str4 = str3;
                DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall(kit2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), httpRequestFactory);
                j = str2;
                String str5 = str;
                this.f263c = new DefaultSettingsController(kit, new SettingsRequest(a, idManager.m102g(), idManager.m101f(), idManager.m100e(), idManager.m108m(), idManager.m97b(), idManager.m109n(), CommonUtils.m52a(CommonUtils.m80m(context)), j, str5, DeliveryMechanism.m85a(j).m86a(), k), systemCurrentTimeProvider, defaultSettingsJsonTransform, defaultCachedSettingsIo, defaultSettingsSpiCall);
            }
            this.f264d = true;
            settings = this;
        }
        return settings;
    }

    public SettingsData m350b() {
        try {
            this.f262b.await();
            return (SettingsData) this.f261a.get();
        } catch (InterruptedException e) {
            Fabric.m397h().m366e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean m351c() {
        SettingsData a;
        a = this.f263c.m317a();
        m348a(a);
        return a != null;
    }

    public synchronized boolean m352d() {
        SettingsData a;
        a = this.f263c.m318a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        m348a(a);
        if (a == null) {
            Fabric.m397h().m367e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void m348a(SettingsData settingsData) {
        this.f261a.set(settingsData);
        this.f262b.countDown();
    }
}
