package com.crashlytics.android.beta;

import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p006b.CurrentTimeProvider;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p011f.PreferenceStore;
import p000a.p001a.p002a.p003a.p004a.p012g.BetaSettingsData;

interface UpdatesController {
    void initialize(Context context, Beta beta, IdManager idManager, BetaSettingsData betaSettingsData, BuildProperties buildProperties, PreferenceStore preferenceStore, CurrentTimeProvider currentTimeProvider, HttpRequestFactory httpRequestFactory);

    boolean isActivityLifecycleTriggered();
}
