package com.crashlytics.android.answers;

import android.content.Context;
import java.util.UUID;
import p000a.p001a.p002a.p003a.p004a.p006b.CurrentTimeProvider;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsFilesManager;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsStorage;
import p000a.p001a.p002a.p003a.p004a.p012g.AnalyticsSettingsData;

class SessionAnalyticsFilesManager extends EventsFilesManager<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private AnalyticsSettingsData analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage) {
        super(context, sessionEventTransform, currentTimeProvider, eventsStorage, 100);
    }

    protected String generateUniqueRollOverFileName() {
        return SESSION_ANALYTICS_TO_SEND_FILE_PREFIX + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + UUID.randomUUID().toString() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.currentTimeProvider.m84a() + SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION;
    }

    protected int getMaxFilesToKeep() {
        return this.analyticsSettingsData == null ? super.getMaxFilesToKeep() : this.analyticsSettingsData.f204e;
    }

    protected int getMaxByteSizePerFile() {
        return this.analyticsSettingsData == null ? super.getMaxByteSizePerFile() : this.analyticsSettingsData.f202c;
    }

    void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData) {
        this.analyticsSettingsData = analyticsSettingsData;
    }
}
