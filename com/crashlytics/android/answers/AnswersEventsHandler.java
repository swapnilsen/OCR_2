package com.crashlytics.android.answers;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p009d.EventsStorageListener;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p012g.AnalyticsSettingsData;

class AnswersEventsHandler implements EventsStorageListener {
    private final Context context;
    final ScheduledExecutorService executor;
    private final AnswersFilesManagerProvider filesManagerProvider;
    private final Kit kit;
    private final SessionMetadataCollector metadataCollector;
    private final HttpRequestFactory requestFactory;
    SessionAnalyticsManagerStrategy strategy;

    /* renamed from: com.crashlytics.android.answers.AnswersEventsHandler.1 */
    class C03681 implements Runnable {
        final /* synthetic */ AnalyticsSettingsData val$analyticsSettingsData;
        final /* synthetic */ String val$protocolAndHostOverride;

        C03681(AnalyticsSettingsData analyticsSettingsData, String str) {
            this.val$analyticsSettingsData = analyticsSettingsData;
            this.val$protocolAndHostOverride = str;
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.setAnalyticsSettingsData(this.val$analyticsSettingsData, this.val$protocolAndHostOverride);
            } catch (Throwable e) {
                Fabric.m397h().m367e(Answers.TAG, "Failed to set analytics settings data", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.AnswersEventsHandler.2 */
    class C03692 implements Runnable {
        C03692() {
        }

        public void run() {
            try {
                SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = AnswersEventsHandler.this.strategy;
                AnswersEventsHandler.this.strategy = new DisabledSessionAnalyticsManagerStrategy();
                sessionAnalyticsManagerStrategy.deleteAllEvents();
            } catch (Throwable e) {
                Fabric.m397h().m367e(Answers.TAG, "Failed to disable events", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.AnswersEventsHandler.3 */
    class C03703 implements Runnable {
        C03703() {
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.sendEvents();
            } catch (Throwable e) {
                Fabric.m397h().m367e(Answers.TAG, "Failed to send events files", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.AnswersEventsHandler.4 */
    class C03714 implements Runnable {
        C03714() {
        }

        public void run() {
            try {
                SessionEventMetadata metadata = AnswersEventsHandler.this.metadataCollector.getMetadata();
                SessionAnalyticsFilesManager analyticsFilesManager = AnswersEventsHandler.this.filesManagerProvider.getAnalyticsFilesManager();
                analyticsFilesManager.registerRollOverListener(AnswersEventsHandler.this);
                AnswersEventsHandler.this.strategy = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.this.kit, AnswersEventsHandler.this.context, AnswersEventsHandler.this.executor, analyticsFilesManager, AnswersEventsHandler.this.requestFactory, metadata);
            } catch (Throwable e) {
                Fabric.m397h().m367e(Answers.TAG, "Failed to enable events", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.AnswersEventsHandler.5 */
    class C03725 implements Runnable {
        C03725() {
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.rollFileOver();
            } catch (Throwable e) {
                Fabric.m397h().m367e(Answers.TAG, "Failed to flush events", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.AnswersEventsHandler.6 */
    class C03736 implements Runnable {
        final /* synthetic */ Builder val$eventBuilder;
        final /* synthetic */ boolean val$flush;

        C03736(Builder builder, boolean z) {
            this.val$eventBuilder = builder;
            this.val$flush = z;
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.processEvent(this.val$eventBuilder);
                if (this.val$flush) {
                    AnswersEventsHandler.this.strategy.rollFileOver();
                }
            } catch (Throwable e) {
                Fabric.m397h().m367e(Answers.TAG, "Failed to process event", e);
            }
        }
    }

    public AnswersEventsHandler(Kit kit, Context context, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, HttpRequestFactory httpRequestFactory, ScheduledExecutorService scheduledExecutorService) {
        this.strategy = new DisabledSessionAnalyticsManagerStrategy();
        this.kit = kit;
        this.context = context;
        this.filesManagerProvider = answersFilesManagerProvider;
        this.metadataCollector = sessionMetadataCollector;
        this.requestFactory = httpRequestFactory;
        this.executor = scheduledExecutorService;
    }

    public void processEventAsync(Builder builder) {
        processEvent(builder, false, false);
    }

    public void processEventAsyncAndFlush(Builder builder) {
        processEvent(builder, false, true);
    }

    public void processEventSync(Builder builder) {
        processEvent(builder, true, false);
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        executeAsync(new C03681(analyticsSettingsData, str));
    }

    public void disable() {
        executeAsync(new C03692());
    }

    public void onRollOver(String str) {
        executeAsync(new C03703());
    }

    public void enable() {
        executeAsync(new C03714());
    }

    public void flushEvents() {
        executeAsync(new C03725());
    }

    void processEvent(Builder builder, boolean z, boolean z2) {
        Runnable c03736 = new C03736(builder, z2);
        if (z) {
            executeSync(c03736);
        } else {
            executeAsync(c03736);
        }
    }

    private void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Throwable e) {
            Fabric.m397h().m367e(Answers.TAG, "Failed to run events task", e);
        }
    }

    private void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Throwable e) {
            Fabric.m397h().m367e(Answers.TAG, "Failed to submit events task", e);
        }
    }
}
