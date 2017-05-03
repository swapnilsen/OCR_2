package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: a.a.a.a.a.c.h */
public class PriorityFutureTask<V> extends FutureTask<V> implements Dependency<Task>, PriorityProvider, Task {
    final Object f137b;

    public /* synthetic */ void addDependency(Object obj) {
        m179a((Task) obj);
    }

    public PriorityFutureTask(Callable<V> callable) {
        super(callable);
        this.f137b = m178a((Object) callable);
    }

    public PriorityFutureTask(Runnable runnable, V v) {
        super(runnable, v);
        this.f137b = m178a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((PriorityProvider) m177a()).compareTo(obj);
    }

    public void m179a(Task task) {
        ((Dependency) ((PriorityProvider) m177a())).addDependency(task);
    }

    public Collection<Task> getDependencies() {
        return ((Dependency) ((PriorityProvider) m177a())).getDependencies();
    }

    public boolean areDependenciesMet() {
        return ((Dependency) ((PriorityProvider) m177a())).areDependenciesMet();
    }

    public Priority getPriority() {
        return ((PriorityProvider) m177a()).getPriority();
    }

    public void setFinished(boolean z) {
        ((Task) ((PriorityProvider) m177a())).setFinished(z);
    }

    public boolean isFinished() {
        return ((Task) ((PriorityProvider) m177a())).isFinished();
    }

    public void setError(Throwable th) {
        ((Task) ((PriorityProvider) m177a())).setError(th);
    }

    public <T extends Dependency<Task> & PriorityProvider & Task> T m177a() {
        return (Dependency) this.f137b;
    }

    protected <T extends Dependency<Task> & PriorityProvider & Task> T m178a(Object obj) {
        if (PriorityTask.isProperDelegate(obj)) {
            return (Dependency) obj;
        }
        return new PriorityTask();
    }
}
