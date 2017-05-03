package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: a.a.a.a.a.c.j */
public class PriorityTask implements Dependency<Task>, PriorityProvider, Task {
    private final List<Task> dependencies;
    private final AtomicBoolean hasRun;
    private final AtomicReference<Throwable> throwable;

    public PriorityTask() {
        this.dependencies = new ArrayList();
        this.hasRun = new AtomicBoolean(false);
        this.throwable = new AtomicReference(null);
    }

    public synchronized Collection<Task> getDependencies() {
        return Collections.unmodifiableCollection(this.dependencies);
    }

    public synchronized void addDependency(Task task) {
        this.dependencies.add(task);
    }

    public boolean areDependenciesMet() {
        for (Task isFinished : getDependencies()) {
            if (!isFinished.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void setFinished(boolean z) {
        this.hasRun.set(z);
    }

    public boolean isFinished() {
        return this.hasRun.get();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public void setError(Throwable th) {
        this.throwable.set(th);
    }

    public Throwable getError() {
        return (Throwable) this.throwable.get();
    }

    public int compareTo(Object obj) {
        return Priority.m176a(this, obj);
    }

    public static boolean isProperDelegate(Object obj) {
        try {
            Dependency dependency = (Dependency) obj;
            Task task = (Task) obj;
            PriorityProvider priorityProvider = (PriorityProvider) obj;
            if (dependency == null || task == null || priorityProvider == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
