package p000a.p001a.p002a.p003a.p004a.p005a;

import android.content.Context;

/* renamed from: a.a.a.a.a.a.b */
public class MemoryValueCache<T> extends AbstractValueCache<T> {
    private T f5a;

    public MemoryValueCache() {
        this(null);
    }

    public MemoryValueCache(ValueCache<T> valueCache) {
        super(valueCache);
    }

    protected T m9a(Context context) {
        return this.f5a;
    }

    protected void m10a(Context context, T t) {
        this.f5a = t;
    }
}
