package com.crashlytics.android.answers;

import java.io.File;
import java.util.List;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.DefaultRetryPolicy;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.ExponentialBackoff;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.RetryState;
import p000a.p001a.p002a.p003a.p004a.p009d.FilesSender;

class AnswersRetryFilesSender implements FilesSender {
    private static final int BACKOFF_MS = 1000;
    private static final int BACKOFF_POWER = 8;
    private static final double JITTER_PERCENT = 0.1d;
    private static final int MAX_RETRIES = 5;
    private final SessionAnalyticsFilesSender filesSender;
    private final RetryManager retryManager;

    public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new RetryState(new RandomBackoff(new ExponentialBackoff(1000, BACKOFF_POWER), JITTER_PERCENT), new DefaultRetryPolicy(MAX_RETRIES))));
    }

    AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager) {
        this.filesSender = sessionAnalyticsFilesSender;
        this.retryManager = retryManager;
    }

    public boolean send(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.retryManager.canRetry(nanoTime)) {
            return false;
        }
        if (this.filesSender.send(list)) {
            this.retryManager.reset();
            return true;
        }
        this.retryManager.recordRetry(nanoTime);
        return false;
    }
}
