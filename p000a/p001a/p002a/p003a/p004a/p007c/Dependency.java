package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.Collection;

/* renamed from: a.a.a.a.a.c.b */
public interface Dependency<T> {
    void addDependency(T t);

    boolean areDependenciesMet();

    Collection<T> getDependencies();
}
