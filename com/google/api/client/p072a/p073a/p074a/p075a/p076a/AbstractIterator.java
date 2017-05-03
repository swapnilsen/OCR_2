package com.google.api.client.p072a.p073a.p074a.p075a.p076a;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.nend.android.NendIconError;

/* renamed from: com.google.api.client.a.a.a.a.a.a */
abstract class AbstractIterator<T> implements Iterator<T> {
    private AbstractIterator f4047a;
    private T f4048b;

    /* renamed from: com.google.api.client.a.a.a.a.a.a.1 */
    static /* synthetic */ class AbstractIterator {
        static final /* synthetic */ int[] f4041a;

        static {
            f4041a = new int[AbstractIterator.values().length];
            try {
                f4041a[AbstractIterator.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4041a[AbstractIterator.READY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.a.a */
    private enum AbstractIterator {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T m4718a();

    protected AbstractIterator() {
        this.f4047a = AbstractIterator.NOT_READY;
    }

    protected final T m4719b() {
        this.f4047a = AbstractIterator.DONE;
        return null;
    }

    public final boolean hasNext() {
        Preconditions.m4758b(this.f4047a != AbstractIterator.FAILED);
        switch (AbstractIterator.f4041a[this.f4047a.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return false;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return true;
            default:
                return m4717c();
        }
    }

    private boolean m4717c() {
        this.f4047a = AbstractIterator.FAILED;
        this.f4048b = m4718a();
        if (this.f4047a == AbstractIterator.DONE) {
            return false;
        }
        this.f4047a = AbstractIterator.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.f4047a = AbstractIterator.NOT_READY;
            T t = this.f4048b;
            this.f4048b = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
