package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.v7.appcompat.C0268R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;

/* renamed from: a.a.a.a.a.b.o */
public class IdManager {
    private static final Pattern f58d;
    private static final String f59e;
    AdvertisingInfoProvider f60a;
    AdvertisingInfo f61b;
    boolean f62c;
    private final ReentrantLock f63f;
    private final InstallerPackageNameProvider f64g;
    private final boolean f65h;
    private final boolean f66i;
    private final Context f67j;
    private final String f68k;
    private final String f69l;
    private final Collection<Kit> f70m;

    /* renamed from: a.a.a.a.a.b.o.a */
    public enum IdManager {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(C0268R.styleable.AppCompatTheme_autoCompleteTextViewStyle),
        ANDROID_SERIAL(C0268R.styleable.AppCompatTheme_buttonStyle),
        ANDROID_ADVERTISING_ID(C0268R.styleable.AppCompatTheme_buttonStyleSmall);
        
        public final int f57h;

        private IdManager(int i) {
            this.f57h = i;
        }
    }

    static {
        f58d = Pattern.compile("[^\\p{Alnum}]");
        f59e = Pattern.quote("/");
    }

    public IdManager(Context context, String str, String str2, Collection<Kit> collection) {
        this.f63f = new ReentrantLock();
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.f67j = context;
            this.f68k = str;
            this.f69l = str2;
            this.f70m = collection;
            this.f64g = new InstallerPackageNameProvider();
            this.f60a = new AdvertisingInfoProvider(context);
            this.f65h = CommonUtils.m60a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f65h) {
                Fabric.m397h().m359a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f66i = CommonUtils.m60a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f66i) {
                Fabric.m397h().m359a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public boolean m96a() {
        return this.f66i;
    }

    private String m93a(String str) {
        return str == null ? null : f58d.matcher(str).replaceAll(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING).toLowerCase(Locale.US);
    }

    public String m97b() {
        String str = this.f69l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = CommonUtils.m43a(this.f67j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m92a(a);
        }
        return str;
    }

    public String m98c() {
        return this.f68k;
    }

    public String m99d() {
        return m100e() + "/" + m101f();
    }

    public String m100e() {
        return m95b(VERSION.RELEASE);
    }

    public String m101f() {
        return m95b(VERSION.INCREMENTAL);
    }

    public String m102g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m95b(Build.MANUFACTURER), m95b(Build.MODEL)});
    }

    private String m95b(String str) {
        return str.replaceAll(f59e, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING);
    }

    public String m103h() {
        String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        if (!this.f65h) {
            return str;
        }
        str = m109n();
        if (str != null) {
            return str;
        }
        SharedPreferences a = CommonUtils.m43a(this.f67j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m92a(a);
        }
        return str;
    }

    private String m92a(SharedPreferences sharedPreferences) {
        this.f63f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m93a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f63f.unlock();
            return string;
        } catch (Throwable th) {
            this.f63f.unlock();
        }
    }

    public Map<IdManager, String> m104i() {
        Map hashMap = new HashMap();
        for (Kit kit : this.f70m) {
            if (kit instanceof DeviceIdentifierProvider) {
                for (Entry entry : ((DeviceIdentifierProvider) kit).getDeviceIdentifiers().entrySet()) {
                    m94a(hashMap, (IdManager) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m94a(hashMap, IdManager.ANDROID_ID, m109n());
        m94a(hashMap, IdManager.ANDROID_ADVERTISING_ID, m108m());
        return Collections.unmodifiableMap(hashMap);
    }

    public String m105j() {
        return this.f64g.m111a(this.f67j);
    }

    synchronized AdvertisingInfo m106k() {
        if (!this.f62c) {
            this.f61b = this.f60a.m17a();
            this.f62c = true;
        }
        return this.f61b;
    }

    public Boolean m107l() {
        if (!this.f65h) {
            return null;
        }
        AdvertisingInfo k = m106k();
        if (k != null) {
            return Boolean.valueOf(k.f7b);
        }
        return null;
    }

    public String m108m() {
        if (!this.f65h) {
            return null;
        }
        AdvertisingInfo k = m106k();
        if (k != null) {
            return k.f6a;
        }
        return null;
    }

    private void m94a(Map<IdManager, String> map, IdManager idManager, String str) {
        if (str != null) {
            map.put(idManager, str);
        }
    }

    public String m109n() {
        if (!this.f65h) {
            return null;
        }
        String string = Secure.getString(this.f67j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return m93a(string);
    }
}
