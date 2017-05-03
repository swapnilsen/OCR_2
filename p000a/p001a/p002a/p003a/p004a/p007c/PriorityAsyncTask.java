package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.p003a.p004a.p007c.AsyncTask.AsyncTask;

/* renamed from: a.a.a.a.a.c.f */
public abstract class PriorityAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements Dependency<Task>, PriorityProvider, Task {
    private final PriorityTask f141a;

    /* renamed from: a.a.a.a.a.c.f.a */
    private static class PriorityAsyncTask<Result> implements Executor {
        private final Executor f139a;
        private final PriorityAsyncTask f140b;

        /* renamed from: a.a.a.a.a.c.f.a.1 */
        class PriorityAsyncTask extends PriorityFutureTask<Result> {
            final /* synthetic */ PriorityAsyncTask f138a;

            PriorityAsyncTask(PriorityAsyncTask priorityAsyncTask, Runnable runnable, Object obj) {
                this.f138a = priorityAsyncTask;
                super(runnable, obj);
            }

            public <T extends Dependency<Task> & PriorityProvider & Task> T m180a() {
                return this.f138a.f140b;
            }
        }

        public PriorityAsyncTask(Executor executor, PriorityAsyncTask priorityAsyncTask) {
            this.f139a = executor;
            this.f140b = priorityAsyncTask;
        }

        public void execute(Runnable runnable) {
            this.f139a.execute(new PriorityAsyncTask(this, runnable, null));
        }
    }

    public /* synthetic */ void addDependency(Object obj) {
        m182a((Task) obj);
    }

    public PriorityAsyncTask() {
        this.f141a = new PriorityTask();
    }

    public final void m183a(ExecutorService executorService, Params... paramsArr) {
        super.m155a(new PriorityAsyncTask(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return Priority.m176a(this, obj);
    }

    public void m182a(Task task) {
        if (m160b() != AsyncTask.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((Dependency) ((PriorityProvider) m184e())).addDependency(task);
    }

    public Collection<Task> getDependencies() {
        return ((Dependency) ((PriorityProvider) m184e())).getDependencies();
    }

    public boolean areDependenciesMet() {
        return ((Dependency) ((PriorityProvider) m184e())).areDependenciesMet();
    }

    public Priority getPriority() {
        return ((PriorityProvider) m184e()).getPriority();
    }

    public void setFinished(boolean z) {
        ((Task) ((PriorityProvider) m184e())).setFinished(z);
    }

    public boolean isFinished() {
        return ((Task) ((PriorityProvider) m184e())).isFinished();
    }

    public void setError(Throwable th) {
        ((Task) ((PriorityProvider) m184e())).setError(th);
    }

    public <T extends Dependency<Task> & PriorityProvider & Task> T m184e() {
        return this.f141a;
    }
}
