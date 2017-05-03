package p000a.p001a.p002a.p003a.p004a.p005a;

import android.content.Context;

/* renamed from: a.a.a.a.a.a.a */
public abstract class AbstractValueCache<T> implements ValueCache<T> {
    private final ValueCache<T> f4a;

    protected abstract T m6a(Context context);

    protected abstract void m8a(Context context, T t);

    public AbstractValueCache(ValueCache<T> valueCache) {
        this.f4a = valueCache;
    }

    public final synchronized T m7a(Context context, ValueLoader<T> valueLoader) {
        T a;
        a = m6a(context);
        if (a == null) {
            a = this.f4a != null ? this.f4a.m4a(context, valueLoader) : valueLoader.load(context);
            m5b(context, a);
        }
        return a;
    }

    private void m5b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        m8a(context, (Object) t);
    }
}
