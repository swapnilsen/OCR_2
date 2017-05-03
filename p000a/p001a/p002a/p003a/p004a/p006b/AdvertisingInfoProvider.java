package p000a.p001a.p002a.p003a.p004a.p006b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStore;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStoreImpl;

/* renamed from: a.a.a.a.a.b.c */
class AdvertisingInfoProvider {
    private final Context f10a;
    private final PreferenceStore f11b;

    /* renamed from: a.a.a.a.a.b.c.1 */
    class AdvertisingInfoProvider extends BackgroundPriorityRunnable {
        final /* synthetic */ AdvertisingInfo f8a;
        final /* synthetic */ AdvertisingInfoProvider f9b;

        AdvertisingInfoProvider(AdvertisingInfoProvider advertisingInfoProvider, AdvertisingInfo advertisingInfo) {
            this.f9b = advertisingInfoProvider;
            this.f8a = advertisingInfo;
        }

        public void onRun() {
            AdvertisingInfo a = this.f9b.m16e();
            if (!this.f8a.equals(a)) {
                Fabric.m397h().m359a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                this.f9b.m14b(a);
            }
        }
    }

    public AdvertisingInfoProvider(Context context) {
        this.f10a = context.getApplicationContext();
        this.f11b = new PreferenceStoreImpl(context, "TwitterAdvertisingInfoPreferences");
    }

    public AdvertisingInfo m17a() {
        AdvertisingInfo b = m18b();
        if (m15c(b)) {
            Fabric.m397h().m359a("Fabric", "Using AdvertisingInfo from Preference Store");
            m12a(b);
            return b;
        }
        b = m16e();
        m14b(b);
        return b;
    }

    private void m12a(AdvertisingInfo advertisingInfo) {
        new Thread(new AdvertisingInfoProvider(this, advertisingInfo)).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m14b(AdvertisingInfo advertisingInfo) {
        if (m15c(advertisingInfo)) {
            this.f11b.m302a(this.f11b.m303b().putString("advertising_id", advertisingInfo.f6a).putBoolean("limit_ad_tracking_enabled", advertisingInfo.f7b));
        } else {
            this.f11b.m302a(this.f11b.m303b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected AdvertisingInfo m18b() {
        return new AdvertisingInfo(this.f11b.m301a().getString("advertising_id", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING), this.f11b.m301a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public AdvertisingInfoStrategy m19c() {
        return new AdvertisingInfoReflectionStrategy(this.f10a);
    }

    public AdvertisingInfoStrategy m20d() {
        return new AdvertisingInfoServiceStrategy(this.f10a);
    }

    private boolean m15c(AdvertisingInfo advertisingInfo) {
        return (advertisingInfo == null || TextUtils.isEmpty(advertisingInfo.f6a)) ? false : true;
    }

    private AdvertisingInfo m16e() {
        AdvertisingInfo a = m19c().m21a();
        if (m15c(a)) {
            Fabric.m397h().m359a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = m20d().m21a();
            if (m15c(a)) {
                Fabric.m397h().m359a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                Fabric.m397h().m359a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
