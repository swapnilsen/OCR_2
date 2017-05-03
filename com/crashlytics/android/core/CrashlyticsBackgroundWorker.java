package com.crashlytics.android.core;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002a.p003a.Fabric;

class CrashlyticsBackgroundWorker {
    private final ExecutorService executorService;

    /* renamed from: com.crashlytics.android.core.CrashlyticsBackgroundWorker.1 */
    class C03871 implements Runnable {
        final /* synthetic */ Runnable val$runnable;

        C03871(Runnable runnable) {
            this.val$runnable = runnable;
        }

        public void run() {
            try {
                this.val$runnable.run();
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Failed to execute task.", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsBackgroundWorker.2 */
    class C03882 implements Callable<T> {
        final /* synthetic */ Callable val$callable;

        C03882(Callable callable) {
            this.val$callable = callable;
        }

        public T call() {
            try {
                return this.val$callable.call();
            } catch (Throwable e) {
                Fabric.m397h().m367e(CrashlyticsCore.TAG, "Failed to execute task.", e);
                return null;
            }
        }
    }

    public CrashlyticsBackgroundWorker(ExecutorService executorService) {
        this.executorService = executorService;
    }

    <T> T submitAndWait(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.executorService.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.executorService.submit(callable).get();
        } catch (RejectedExecutionException e) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            Fabric.m397h().m367e(CrashlyticsCore.TAG, "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> submit(Runnable runnable) {
        try {
            return this.executorService.submit(new C03871(runnable));
        } catch (RejectedExecutionException e) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> submit(Callable<T> callable) {
        try {
            return this.executorService.submit(new C03882(callable));
        } catch (RejectedExecutionException e) {
            Fabric.m397h().m359a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
