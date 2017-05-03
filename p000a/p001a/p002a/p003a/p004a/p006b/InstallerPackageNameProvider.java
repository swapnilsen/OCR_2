package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.p004a.p005a.MemoryValueCache;
import p000a.p001a.p002a.p003a.p004a.p005a.ValueLoader;

/* renamed from: a.a.a.a.a.b.p */
public class InstallerPackageNameProvider {
    private final ValueLoader<String> f72a;
    private final MemoryValueCache<String> f73b;

    /* renamed from: a.a.a.a.a.b.p.1 */
    class InstallerPackageNameProvider implements ValueLoader<String> {
        final /* synthetic */ InstallerPackageNameProvider f71a;

        InstallerPackageNameProvider(InstallerPackageNameProvider installerPackageNameProvider) {
            this.f71a = installerPackageNameProvider;
        }

        public /* synthetic */ Object load(Context context) {
            return m110a(context);
        }

        public String m110a(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : installerPackageName;
        }
    }

    public InstallerPackageNameProvider() {
        this.f72a = new InstallerPackageNameProvider(this);
        this.f73b = new MemoryValueCache();
    }

    public String m111a(Context context) {
        try {
            String str = (String) this.f73b.m7a(context, this.f72a);
            if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(str)) {
                return null;
            }
            return str;
        } catch (Throwable e) {
            Fabric.m397h().m367e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
