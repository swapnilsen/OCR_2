package com.crashlytics.android.answers;

import p000a.p001a.p002a.p003a.p004a.p009d.FileRollOverManager;
import p000a.p001a.p002a.p003a.p004a.p012g.AnalyticsSettingsData;

interface SessionAnalyticsManagerStrategy extends FileRollOverManager {
    void deleteAllEvents();

    void processEvent(Builder builder);

    void sendEvents();

    void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str);
}
