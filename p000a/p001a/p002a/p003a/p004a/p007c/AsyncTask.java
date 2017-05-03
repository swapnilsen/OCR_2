package p000a.p001a.p002a.p003a.p004a.p007c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.nend.android.NendIconError;

/* renamed from: a.a.a.a.a.c.a */
public abstract class AsyncTask<Params, Progress, Result> {
    private static final int f116a;
    public static final Executor f117b;
    public static final Executor f118c;
    private static final int f119d;
    private static final int f120e;
    private static final ThreadFactory f121f;
    private static final BlockingQueue<Runnable> f122g;
    private static final AsyncTask f123h;
    private static volatile Executor f124i;
    private final AsyncTask<Params, Result> f125j;
    private final FutureTask<Result> f126k;
    private volatile AsyncTask f127l;
    private final AtomicBoolean f128m;
    private final AtomicBoolean f129n;

    /* renamed from: a.a.a.a.a.c.a.1 */
    static class AsyncTask implements ThreadFactory {
        private final AtomicInteger f95a;

        AsyncTask() {
            this.f95a = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f95a.getAndIncrement());
        }
    }

    /* renamed from: a.a.a.a.a.c.a.e */
    private static abstract class AsyncTask<Params, Result> implements Callable<Result> {
        Params[] f96b;

        private AsyncTask() {
        }
    }

    /* renamed from: a.a.a.a.a.c.a.2 */
    class AsyncTask extends AsyncTask<Params, Result> {
        final /* synthetic */ AsyncTask f97a;

        AsyncTask(AsyncTask asyncTask) {
            this.f97a = asyncTask;
            super();
        }

        public Result call() {
            this.f97a.f129n.set(true);
            Process.setThreadPriority(10);
            return this.f97a.m153d(this.f97a.m156a(this.b));
        }
    }

    /* renamed from: a.a.a.a.a.c.a.3 */
    class AsyncTask extends FutureTask<Result> {
        final /* synthetic */ AsyncTask f98a;

        AsyncTask(AsyncTask asyncTask, Callable callable) {
            this.f98a = asyncTask;
            super(callable);
        }

        protected void done() {
            try {
                this.f98a.m152c(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f98a.m152c(null);
            }
        }
    }

    /* renamed from: a.a.a.a.a.c.a.4 */
    static /* synthetic */ class AsyncTask {
        static final /* synthetic */ int[] f99a;

        static {
            f99a = new int[AsyncTask.values().length];
            try {
                f99a[AsyncTask.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f99a[AsyncTask.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: a.a.a.a.a.c.a.a */
    private static class AsyncTask<Data> {
        final AsyncTask f100a;
        final Data[] f101b;

        AsyncTask(AsyncTask asyncTask, Data... dataArr) {
            this.f100a = asyncTask;
            this.f101b = dataArr;
        }
    }

    /* renamed from: a.a.a.a.a.c.a.b */
    private static class AsyncTask extends Handler {
        public AsyncTask() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTask asyncTask = (AsyncTask) message.obj;
            switch (message.what) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    asyncTask.f100a.m154e(asyncTask.f101b[0]);
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    asyncTask.f100a.m162b(asyncTask.f101b);
                default:
            }
        }
    }

    /* renamed from: a.a.a.a.a.c.a.c */
    private static class AsyncTask implements Executor {
        final LinkedList<Runnable> f104a;
        Runnable f105b;

        /* renamed from: a.a.a.a.a.c.a.c.1 */
        class AsyncTask implements Runnable {
            final /* synthetic */ Runnable f102a;
            final /* synthetic */ AsyncTask f103b;

            AsyncTask(AsyncTask asyncTask, Runnable runnable) {
                this.f103b = asyncTask;
                this.f102a = runnable;
            }

            public void run() {
                try {
                    this.f102a.run();
                } finally {
                    this.f103b.m144a();
                }
            }
        }

        private AsyncTask() {
            this.f104a = new LinkedList();
        }

        public synchronized void execute(Runnable runnable) {
            this.f104a.offer(new AsyncTask(this, runnable));
            if (this.f105b == null) {
                m144a();
            }
        }

        protected synchronized void m144a() {
            Runnable runnable = (Runnable) this.f104a.poll();
            this.f105b = runnable;
            if (runnable != null) {
                AsyncTask.f117b.execute(this.f105b);
            }
        }
    }

    /* renamed from: a.a.a.a.a.c.a.d */
    public enum AsyncTask {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result m156a(Params... paramsArr);

    static {
        f116a = Runtime.getRuntime().availableProcessors();
        f119d = f116a + 1;
        f120e = (f116a * 2) + 1;
        f121f = new AsyncTask();
        f122g = new LinkedBlockingQueue(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        f117b = new ThreadPoolExecutor(f119d, f120e, 1, TimeUnit.SECONDS, f122g, f121f);
        f118c = new AsyncTask();
        f123h = new AsyncTask();
        f124i = f118c;
    }

    public AsyncTask() {
        this.f127l = AsyncTask.PENDING;
        this.f128m = new AtomicBoolean();
        this.f129n = new AtomicBoolean();
        this.f125j = new AsyncTask(this);
        this.f126k = new AsyncTask(this, this.f125j);
    }

    private void m152c(Result result) {
        if (!this.f129n.get()) {
            m153d(result);
        }
    }

    private Result m153d(Result result) {
        f123h.obtainMessage(1, new AsyncTask(this, result)).sendToTarget();
        return result;
    }

    public final AsyncTask m160b() {
        return this.f127l;
    }

    protected void m157a() {
    }

    protected void m158a(Result result) {
    }

    protected void m162b(Progress... progressArr) {
    }

    protected void m161b(Result result) {
        m163c();
    }

    protected void m163c() {
    }

    public final boolean m164d() {
        return this.f128m.get();
    }

    public final boolean m159a(boolean z) {
        this.f128m.set(true);
        return this.f126k.cancel(z);
    }

    public final AsyncTask<Params, Progress, Result> m155a(Executor executor, Params... paramsArr) {
        if (this.f127l != AsyncTask.PENDING) {
            switch (AsyncTask.f99a[this.f127l.ordinal()]) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f127l = AsyncTask.RUNNING;
        m157a();
        this.f125j.f96b = paramsArr;
        executor.execute(this.f126k);
        return this;
    }

    private void m154e(Result result) {
        if (m164d()) {
            m161b((Object) result);
        } else {
            m158a((Object) result);
        }
        this.f127l = AsyncTask.FINISHED;
    }
}
