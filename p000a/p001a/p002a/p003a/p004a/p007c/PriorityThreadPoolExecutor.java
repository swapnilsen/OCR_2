package p000a.p001a.p002a.p003a.p004a.p007c;

import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: a.a.a.a.a.c.k */
public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int f143a;
    private static final int f144b;
    private static final int f145c;

    /* renamed from: a.a.a.a.a.c.k.a */
    protected static final class PriorityThreadPoolExecutor implements ThreadFactory {
        private final int f142a;

        public PriorityThreadPoolExecutor(int i) {
            this.f142a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f142a);
            thread.setName("Queue");
            return thread;
        }
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return m187b();
    }

    static {
        f143a = Runtime.getRuntime().availableProcessors();
        f144b = f143a + 1;
        f145c = (f143a * 2) + 1;
    }

    <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor m186a(int i, int i2) {
        return new PriorityThreadPoolExecutor(i, i2, 1, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new PriorityThreadPoolExecutor(10));
    }

    public static PriorityThreadPoolExecutor m185a() {
        return PriorityThreadPoolExecutor.m186a(f144b, f145c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new PriorityFutureTask(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new PriorityFutureTask(callable);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (PriorityTask.isProperDelegate(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        Task task = (Task) runnable;
        task.setFinished(true);
        task.setError(th);
        m187b().m174d();
        super.afterExecute(runnable, th);
    }

    public DependencyPriorityBlockingQueue m187b() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }
}
