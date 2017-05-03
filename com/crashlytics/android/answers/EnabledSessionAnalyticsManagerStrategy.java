package com.crashlytics.android.answers;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.Fabric;
import p000a.p001a.p002a.p003a.Kit;
import p000a.p001a.p002a.p003a.p004a.p006b.ApiKey;
import p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils;
import p000a.p001a.p002a.p003a.p004a.p009d.FilesSender;
import p000a.p001a.p002a.p003a.p004a.p009d.TimeBasedFileRollOverRunnable;
import p000a.p001a.p002a.p003a.p004a.p010e.HttpRequestFactory;
import p000a.p001a.p002a.p003a.p004a.p012g.AnalyticsSettingsData;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    ApiKey apiKey;
    private final Context context;
    boolean customEventsEnabled;
    EventFilter eventFilter;
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    FilesSender filesSender;
    private final HttpRequestFactory httpRequestFactory;
    private final Kit kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef;
    volatile int rolloverIntervalSeconds;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, HttpRequestFactory httpRequestFactory, SessionEventMetadata sessionEventMetadata) {
        this.rolloverFutureRef = new AtomicReference();
        this.apiKey = new ApiKey();
        this.eventFilter = new KeepAllEventFilter();
        this.customEventsEnabled = true;
        this.predefinedEventsEnabled = true;
        this.rolloverIntervalSeconds = UNDEFINED_ROLLOVER_INTERVAL_SECONDS;
        this.kit = kit;
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = httpRequestFactory;
        this.metadata = sessionEventMetadata;
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, analyticsSettingsData.f200a, this.httpRequestFactory, this.apiKey.m32a(this.context)));
        this.filesManager.setAnalyticsSettingsData(analyticsSettingsData);
        this.customEventsEnabled = analyticsSettingsData.f205f;
        Fabric.m397h().m359a(Answers.TAG, "Custom event tracking " + (this.customEventsEnabled ? "enabled" : "disabled"));
        this.predefinedEventsEnabled = analyticsSettingsData.f206g;
        Fabric.m397h().m359a(Answers.TAG, "Predefined event tracking " + (this.predefinedEventsEnabled ? "enabled" : "disabled"));
        if (analyticsSettingsData.f208i > 1) {
            Fabric.m397h().m359a(Answers.TAG, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(analyticsSettingsData.f208i);
        }
        this.rolloverIntervalSeconds = analyticsSettingsData.f201b;
        scheduleTimeBasedFileRollOver(0, (long) this.rolloverIntervalSeconds);
    }

    public void processEvent(Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        if (!this.customEventsEnabled && Type.CUSTOM.equals(build.type)) {
            Fabric.m397h().m359a(Answers.TAG, "Custom events tracking disabled - skipping event: " + build);
        } else if (!this.predefinedEventsEnabled && Type.PREDEFINED.equals(build.type)) {
            Fabric.m397h().m359a(Answers.TAG, "Predefined events tracking disabled - skipping event: " + build);
        } else if (this.eventFilter.skipEvent(build)) {
            Fabric.m397h().m359a(Answers.TAG, "Skipping filtered event: " + build);
        } else {
            try {
                this.filesManager.writeEvent(build);
            } catch (Throwable e) {
                Fabric.m397h().m367e(Answers.TAG, "Failed to write event: " + build, e);
            }
            scheduleTimeBasedRollOverIfNeeded();
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if ((this.rolloverIntervalSeconds != UNDEFINED_ROLLOVER_INTERVAL_SECONDS ? 1 : null) != null) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendEvents() {
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.filesSender;
        if (r0 != 0) goto L_0x000d;
    L_0x0005:
        r0 = r9.context;
        r1 = "skipping files send because we don't yet know the target endpoint";
        p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils.m54a(r0, r1);
    L_0x000c:
        return;
    L_0x000d:
        r0 = r9.context;
        r2 = "Sending all files";
        p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils.m54a(r0, r2);
        r0 = r9.filesManager;
        r0 = r0.getBatchOfFilesToSend();
        r2 = r0;
        r0 = r1;
    L_0x001c:
        r1 = r2.size();	 Catch:{ Exception -> 0x0062 }
        if (r1 <= 0) goto L_0x0052;
    L_0x0022:
        r1 = r9.context;	 Catch:{ Exception -> 0x0062 }
        r3 = java.util.Locale.US;	 Catch:{ Exception -> 0x0062 }
        r4 = "attempt to send batch of %d files";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0062 }
        r6 = 0;
        r7 = r2.size();	 Catch:{ Exception -> 0x0062 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0062 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x0062 }
        r3 = java.lang.String.format(r3, r4, r5);	 Catch:{ Exception -> 0x0062 }
        p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils.m54a(r1, r3);	 Catch:{ Exception -> 0x0062 }
        r1 = r9.filesSender;	 Catch:{ Exception -> 0x0062 }
        r3 = r1.send(r2);	 Catch:{ Exception -> 0x0062 }
        if (r3 == 0) goto L_0x0050;
    L_0x0045:
        r1 = r2.size();	 Catch:{ Exception -> 0x0062 }
        r1 = r1 + r0;
        r0 = r9.filesManager;	 Catch:{ Exception -> 0x0084 }
        r0.deleteSentFiles(r2);	 Catch:{ Exception -> 0x0084 }
        r0 = r1;
    L_0x0050:
        if (r3 != 0) goto L_0x005a;
    L_0x0052:
        if (r0 != 0) goto L_0x000c;
    L_0x0054:
        r0 = r9.filesManager;
        r0.deleteOldestInRollOverIfOverMax();
        goto L_0x000c;
    L_0x005a:
        r1 = r9.filesManager;	 Catch:{ Exception -> 0x0062 }
        r1 = r1.getBatchOfFilesToSend();	 Catch:{ Exception -> 0x0062 }
        r2 = r1;
        goto L_0x001c;
    L_0x0062:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0066:
        r2 = r9.context;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Failed to send batch of analytics files to server: ";
        r3 = r3.append(r4);
        r4 = r0.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        p000a.p001a.p002a.p003a.p004a.p006b.CommonUtils.m55a(r2, r3, r0);
        r0 = r1;
        goto L_0x0052;
    L_0x0084:
        r0 = move-exception;
        goto L_0x0066;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy.sendEvents():void");
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            CommonUtils.m54a(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.rolloverFutureRef.get()).cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (Throwable e) {
            CommonUtils.m55a(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    void scheduleTimeBasedFileRollOver(long j, long j2) {
        if ((this.rolloverFutureRef.get() == null ? 1 : null) != null) {
            Runnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.context, this);
            CommonUtils.m54a(this.context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                CommonUtils.m55a(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
