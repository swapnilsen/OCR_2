package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.p004a.p006b.ApiKey;
import p000a.p001a.p002a.p003a.p004a.p006b.CurrentTimeProvider;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStore;
import p000a.p001a.p002a.p003a.p004a.p012g.BetaSettingsData;

abstract class AbstractCheckForUpdatesController implements UpdatesController {
    static final long LAST_UPDATE_CHECK_DEFAULT = 0;
    static final String LAST_UPDATE_CHECK_KEY = "last_update_check";
    private static final long MILLIS_PER_SECOND = 1000;
    private Beta beta;
    private BetaSettingsData betaSettings;
    private BuildProperties buildProps;
    private Context context;
    private CurrentTimeProvider currentTimeProvider;
    private final AtomicBoolean externallyReady;
    private HttpRequestFactory httpRequestFactory;
    private IdManager idManager;
    private final AtomicBoolean initialized;
    private long lastCheckTimeMillis;
    private PreferenceStore preferenceStore;

    public AbstractCheckForUpdatesController() {
        this(false);
    }

    public AbstractCheckForUpdatesController(boolean z) {
        this.initialized = new AtomicBoolean();
        this.lastCheckTimeMillis = LAST_UPDATE_CHECK_DEFAULT;
        this.externallyReady = new AtomicBoolean(z);
    }

    public void initialize(Context context, Beta beta, IdManager idManager, BetaSettingsData betaSettingsData, BuildProperties buildProperties, PreferenceStore preferenceStore, CurrentTimeProvider currentTimeProvider, HttpRequestFactory httpRequestFactory) {
        this.context = context;
        this.beta = beta;
        this.idManager = idManager;
        this.betaSettings = betaSettingsData;
        this.buildProps = buildProperties;
        this.preferenceStore = preferenceStore;
        this.currentTimeProvider = currentTimeProvider;
        this.httpRequestFactory = httpRequestFactory;
        if (signalInitialized()) {
            checkForUpdates();
        }
    }

    protected boolean signalExternallyReady() {
        this.externallyReady.set(true);
        return this.initialized.get();
    }

    boolean signalInitialized() {
        this.initialized.set(true);
        return this.externallyReady.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void checkForUpdates() {
        synchronized (this.preferenceStore) {
            if (this.preferenceStore.m301a().contains(LAST_UPDATE_CHECK_KEY)) {
                this.preferenceStore.m302a(this.preferenceStore.m303b().remove(LAST_UPDATE_CHECK_KEY));
            }
        }
        long a = this.currentTimeProvider.m84a();
        long j = ((long) this.betaSettings.f230b) * MILLIS_PER_SECOND;
        Fabric.m397h().m359a(Beta.TAG, "Check for updates delay: " + j);
        Fabric.m397h().m359a(Beta.TAG, "Check for updates last check time: " + getLastCheckTimeMillis());
        j += getLastCheckTimeMillis();
        Fabric.m397h().m359a(Beta.TAG, "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                performUpdateCheck();
            } finally {
                setLastCheckTimeMillis(a);
            }
        } else {
            Fabric.m397h().m359a(Beta.TAG, "Check for updates next check time was not passed");
        }
    }

    private void performUpdateCheck() {
        Fabric.m397h().m359a(Beta.TAG, "Performing update check");
        new CheckForUpdatesRequest(this.beta, this.beta.getOverridenSpiEndpoint(), this.betaSettings.f229a, this.httpRequestFactory, new CheckForUpdatesResponseTransform()).invoke(new ApiKey().m32a(this.context), (String) this.idManager.m104i().get(IdManager.IdManager.FONT_TOKEN), this.buildProps);
    }

    void setLastCheckTimeMillis(long j) {
        this.lastCheckTimeMillis = j;
    }

    long getLastCheckTimeMillis() {
        return this.lastCheckTimeMillis;
    }
}
