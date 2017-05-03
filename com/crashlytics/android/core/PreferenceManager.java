package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStore;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStoreImpl;

@SuppressLint({"CommitPrefEdits"})
class PreferenceManager {
    static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final PreferenceStore preferenceStore;

    public static PreferenceManager create(PreferenceStore preferenceStore, CrashlyticsCore crashlyticsCore) {
        if (!preferenceStore.m301a().getBoolean(PREF_MIGRATION_COMPLETE, false)) {
            PreferenceStore preferenceStoreImpl = new PreferenceStoreImpl(crashlyticsCore);
            boolean z = !preferenceStore.m301a().contains(PREF_ALWAYS_SEND_REPORTS_KEY) && preferenceStoreImpl.m301a().contains(PREF_ALWAYS_SEND_REPORTS_KEY);
            if (z) {
                preferenceStore.m302a(preferenceStore.m303b().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, preferenceStoreImpl.m301a().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false)));
            }
            preferenceStore.m302a(preferenceStore.m303b().putBoolean(PREF_MIGRATION_COMPLETE, true));
        }
        return new PreferenceManager(preferenceStore);
    }

    public PreferenceManager(PreferenceStore preferenceStore) {
        this.preferenceStore = preferenceStore;
    }

    void setShouldAlwaysSendReports(boolean z) {
        this.preferenceStore.m302a(this.preferenceStore.m303b().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    boolean shouldAlwaysSendReports() {
        return this.preferenceStore.m301a().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
    }
}
