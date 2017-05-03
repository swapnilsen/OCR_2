package com.crashlytics.android.answers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.Fabric;

class BackgroundManager {
    private static final int BACKGROUND_DELAY = 5000;
    final AtomicReference<ScheduledFuture<?>> backgroundFutureRef;
    private final ScheduledExecutorService executorService;
    private volatile boolean flushOnBackground;
    boolean inBackground;
    private final List<Listener> listeners;

    /* renamed from: com.crashlytics.android.answers.BackgroundManager.1 */
    class C03741 implements Runnable {
        C03741() {
        }

        public void run() {
            BackgroundManager.this.backgroundFutureRef.set(null);
            BackgroundManager.this.notifyBackground();
        }
    }

    public interface Listener {
        void onBackground();
    }

    public BackgroundManager(ScheduledExecutorService scheduledExecutorService) {
        this.listeners = new ArrayList();
        this.flushOnBackground = true;
        this.backgroundFutureRef = new AtomicReference();
        this.inBackground = true;
        this.executorService = scheduledExecutorService;
    }

    public void setFlushOnBackground(boolean z) {
        this.flushOnBackground = z;
    }

    private void notifyBackground() {
        for (Listener onBackground : this.listeners) {
            onBackground.onBackground();
        }
    }

    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void onActivityResumed() {
        this.inBackground = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.backgroundFutureRef.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void onActivityPaused() {
        if (this.flushOnBackground && !this.inBackground) {
            this.inBackground = true;
            try {
                this.backgroundFutureRef.compareAndSet(null, this.executorService.schedule(new C03741(), 5000, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                Fabric.m397h().m360a(Answers.TAG, "Failed to schedule background detector", e);
            }
        }
    }
}
