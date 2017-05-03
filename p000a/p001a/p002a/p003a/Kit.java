package p000a.p001a.p002a.p003a;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p000a.p001a.p002a.p003a.p004a.p006b.IdManager;
import p000a.p001a.p002a.p003a.p004a.p007c.DependsOn;
import p000a.p001a.p002a.p003a.p004a.p007c.Task;

/* renamed from: a.a.a.a.i */
public abstract class Kit<Result> implements Comparable<Kit> {
    Context context;
    final DependsOn dependsOnAnnotation;
    Fabric fabric;
    IdManager idManager;
    InitializationCallback<Result> initializationCallback;
    InitializationTask<Result> initializationTask;

    protected abstract Result doInBackground();

    public abstract String getIdentifier();

    public abstract String getVersion();

    public Kit() {
        this.initializationTask = new InitializationTask(this);
        this.dependsOnAnnotation = (DependsOn) getClass().getAnnotation(DependsOn.class);
    }

    void injectParameters(Context context, Fabric fabric, InitializationCallback<Result> initializationCallback, IdManager idManager) {
        this.fabric = fabric;
        this.context = new FabricContext(context, getIdentifier(), getPath());
        this.initializationCallback = initializationCallback;
        this.idManager = idManager;
    }

    final void initialize() {
        this.initializationTask.m183a(this.fabric.m409f(), (Void) null);
    }

    protected boolean onPreExecute() {
        return true;
    }

    protected void onPostExecute(Result result) {
    }

    protected void onCancelled(Result result) {
    }

    protected IdManager getIdManager() {
        return this.idManager;
    }

    public Context getContext() {
        return this.context;
    }

    public Fabric getFabric() {
        return this.fabric;
    }

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public int compareTo(Kit kit) {
        if (containsAnnotatedDependency(kit)) {
            return 1;
        }
        if (kit.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (hasAnnotatedDependency() && !kit.hasAnnotatedDependency()) {
            return 1;
        }
        if (hasAnnotatedDependency() || !kit.hasAnnotatedDependency()) {
            return 0;
        }
        return -1;
    }

    boolean containsAnnotatedDependency(Kit kit) {
        if (!hasAnnotatedDependency()) {
            return false;
        }
        for (Class isAssignableFrom : this.dependsOnAnnotation.m175a()) {
            if (isAssignableFrom.isAssignableFrom(kit.getClass())) {
                return true;
            }
        }
        return false;
    }

    boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    protected Collection<Task> getDependencies() {
        return this.initializationTask.getDependencies();
    }
}
