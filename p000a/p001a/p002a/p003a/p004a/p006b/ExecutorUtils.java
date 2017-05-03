package p000a.p001a.p002a.p003a.p004a.p006b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p000a.p001a.p002a.p003a.Fabric;

/* renamed from: a.a.a.a.a.b.n */
public final class ExecutorUtils {

    /* renamed from: a.a.a.a.a.b.n.1 */
    static class ExecutorUtils implements ThreadFactory {
        final /* synthetic */ String f43a;
        final /* synthetic */ AtomicLong f44b;

        /* renamed from: a.a.a.a.a.b.n.1.1 */
        class ExecutorUtils extends BackgroundPriorityRunnable {
            final /* synthetic */ Runnable f41a;
            final /* synthetic */ ExecutorUtils f42b;

            ExecutorUtils(ExecutorUtils executorUtils, Runnable runnable) {
                this.f42b = executorUtils;
                this.f41a = runnable;
            }

            public void onRun() {
                this.f41a.run();
            }
        }

        ExecutorUtils(String str, AtomicLong atomicLong) {
            this.f43a = str;
            this.f44b = atomicLong;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new ExecutorUtils(this, runnable));
            newThread.setName(this.f43a + this.f44b.getAndIncrement());
            return newThread;
        }
    }

    /* renamed from: a.a.a.a.a.b.n.2 */
    static class ExecutorUtils extends BackgroundPriorityRunnable {
        final /* synthetic */ String f45a;
        final /* synthetic */ ExecutorService f46b;
        final /* synthetic */ long f47c;
        final /* synthetic */ TimeUnit f48d;

        ExecutorUtils(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.f45a = str;
            this.f46b = executorService;
            this.f47c = j;
            this.f48d = timeUnit;
        }

        public void onRun() {
            try {
                Fabric.m397h().m359a("Fabric", "Executing shutdown hook for " + this.f45a);
                this.f46b.shutdown();
                if (!this.f46b.awaitTermination(this.f47c, this.f48d)) {
                    Fabric.m397h().m359a("Fabric", this.f45a + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                    this.f46b.shutdownNow();
                }
            } catch (InterruptedException e) {
                Fabric.m397h().m359a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f45a}));
                this.f46b.shutdownNow();
            }
        }
    }

    public static ExecutorService m87a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(ExecutorUtils.m91c(str));
        ExecutorUtils.m88a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService m90b(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(ExecutorUtils.m91c(str));
        ExecutorUtils.m88a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory m91c(String str) {
        return new ExecutorUtils(str, new AtomicLong(1));
    }

    private static final void m88a(String str, ExecutorService executorService) {
        ExecutorUtils.m89a(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void m89a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new ExecutorUtils(str, executorService, j, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }
}
