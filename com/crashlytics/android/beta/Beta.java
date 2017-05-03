package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p005a.MemoryValueCache;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p006b.DeviceIdentifierProvider;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;
import p000a.p001a.p002a.p003a.p004a.p006b.SystemCurrentTimeProvider;
import p000a.p001a.p002a.p003a.p004a.p010e.DefaultHttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStoreImpl;
import p000a.p001a.p002a.p003a.p004a.p012g.BetaSettingsData;
import p000a.p001a.p002a.p003a.p004a.p012g.Settings;
import p000a.p001a.p002a.p003a.p004a.p012g.SettingsData;

public class Beta extends Kit<Boolean> implements DeviceIdentifierProvider {
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
    static final String NO_DEVICE_TOKEN = "";
    public static final String TAG = "Beta";
    private final MemoryValueCache<String> deviceTokenCache;
    private final DeviceTokenLoader deviceTokenLoader;
    private UpdatesController updatesController;

    public Beta() {
        this.deviceTokenCache = new MemoryValueCache();
        this.deviceTokenLoader = new DeviceTokenLoader();
    }

    public static Beta getInstance() {
        return (Beta) Fabric.m389a(Beta.class);
    }

    @TargetApi(14)
    protected boolean onPreExecute() {
        this.updatesController = createUpdatesController(VERSION.SDK_INT, (Application) getContext().getApplicationContext());
        return true;
    }

    protected Boolean doInBackground() {
        Fabric.m397h().m359a(TAG, "Beta kit initializing...");
        Context context = getContext();
        IdManager idManager = getIdManager();
        if (TextUtils.isEmpty(getBetaDeviceToken(context, idManager.m105j()))) {
            Fabric.m397h().m359a(TAG, "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        Fabric.m397h().m359a(TAG, "Beta device token is present, checking for app updates.");
        BetaSettingsData betaSettingsData = getBetaSettingsData();
        BuildProperties loadBuildProperties = loadBuildProperties(context);
        if (canCheckForUpdates(betaSettingsData, loadBuildProperties)) {
            this.updatesController.initialize(context, this, idManager, betaSettingsData, loadBuildProperties, new PreferenceStoreImpl(this), new SystemCurrentTimeProvider(), new DefaultHttpRequestFactory(Fabric.m397h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    UpdatesController createUpdatesController(int i, Application application) {
        if (i >= 14) {
            return new ActivityLifecycleCheckForUpdatesController(getFabric().m408e(), getFabric().m409f());
        }
        return new ImmediateCheckForUpdatesController();
    }

    public Map<IdManager.IdManager, String> getDeviceIdentifiers() {
        CharSequence betaDeviceToken = getBetaDeviceToken(getContext(), getIdManager().m105j());
        Map<IdManager.IdManager, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(betaDeviceToken)) {
            hashMap.put(IdManager.IdManager.FONT_TOKEN, betaDeviceToken);
        }
        return hashMap;
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.2.3.167";
    }

    boolean canCheckForUpdates(BetaSettingsData betaSettingsData, BuildProperties buildProperties) {
        return (betaSettingsData == null || TextUtils.isEmpty(betaSettingsData.f229a) || buildProperties == null) ? false : true;
    }

    private String getBetaDeviceToken(Context context, String str) {
        Object obj;
        try {
            obj = (String) this.deviceTokenCache.m7a(context, this.deviceTokenLoader);
            if (NO_DEVICE_TOKEN.equals(obj)) {
                obj = null;
            }
        } catch (Throwable e) {
            Fabric.m397h().m367e(TAG, "Failed to load the Beta device token", e);
            obj = null;
        }
        Fabric.m397h().m359a(TAG, "Beta device token present: " + (!TextUtils.isEmpty(obj)));
        return obj;
    }

    private BetaSettingsData getBetaSettingsData() {
        SettingsData b = Settings.m347a().m350b();
        if (b != null) {
            return b.f274f;
        }
        return null;
    }

    private BuildProperties loadBuildProperties(Context context) {
        Throwable th;
        Throwable e;
        Throwable th2;
        BuildProperties buildProperties;
        InputStream inputStream = null;
        InputStream open;
        try {
            open = context.getAssets().open(CRASHLYTICS_BUILD_PROPERTIES);
            Object obj;
            if (open != null) {
                BuildProperties fromPropertiesStream;
                try {
                    fromPropertiesStream = BuildProperties.fromPropertiesStream(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        Fabric.m397h().m367e(TAG, "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                Fabric.m397h().m367e(TAG, "Error closing Beta build properties asset", th22);
                            }
                        }
                        return buildProperties;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                Fabric.m397h().m367e(TAG, "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    Fabric.m397h().m359a(TAG, fromPropertiesStream.packageName + " build properties: " + fromPropertiesStream.versionName + " (" + fromPropertiesStream.versionCode + ")" + " - " + fromPropertiesStream.buildId);
                    buildProperties = fromPropertiesStream;
                } catch (Throwable e22) {
                    th = e22;
                    buildProperties = fromPropertiesStream;
                    th222 = th;
                    Fabric.m397h().m367e(TAG, "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return buildProperties;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    Fabric.m397h().m367e(TAG, "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            buildProperties = inputStream2;
            Fabric.m397h().m367e(TAG, "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return buildProperties;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return buildProperties;
    }

    String getOverridenSpiEndpoint() {
        return CommonUtils.m65b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }
}
