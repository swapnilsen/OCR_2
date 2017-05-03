package com.crashlytics.android.answers;

import p000a.p001a.p002a.p003a.p004a.p007c.p008a.RetryState;

class RetryManager {
    private static final long NANOSECONDS_IN_MS = 1000000;
    long lastRetry;
    private RetryState retryState;

    public RetryManager(RetryState retryState) {
        if (retryState == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.retryState = retryState;
    }

    public boolean canRetry(long j) {
        return j - this.lastRetry >= NANOSECONDS_IN_MS * this.retryState.m145a();
    }

    public void recordRetry(long j) {
        this.lastRetry = j;
        this.retryState = this.retryState.m146b();
    }

    public void reset() {
        this.lastRetry = 0;
        this.retryState = this.retryState.m147c();
    }
}
