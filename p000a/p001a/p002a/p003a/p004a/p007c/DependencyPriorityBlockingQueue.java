package p000a.p001a.p002a.p003a.p004a.p007c;

import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: a.a.a.a.a.c.c */
public class DependencyPriorityBlockingQueue<E extends Dependency & Task & PriorityProvider> extends PriorityBlockingQueue<E> {
    final Queue<E> f130a;
    private final ReentrantLock f131b;

    public /* synthetic */ Object peek() {
        return m171b();
    }

    public /* synthetic */ Object poll() {
        return m173c();
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        return m167a(j, timeUnit);
    }

    public /* synthetic */ Object take() {
        return m165a();
    }

    public DependencyPriorityBlockingQueue() {
        this.f130a = new LinkedList();
        this.f131b = new ReentrantLock();
    }

    public E m165a() {
        return m172b(0, null, null);
    }

    public E m171b() {
        E e = null;
        try {
            e = m172b(1, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public E m167a(long j, TimeUnit timeUnit) {
        return m172b(3, Long.valueOf(j), timeUnit);
    }

    public E m173c() {
        E e = null;
        try {
            e = m172b(2, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public int size() {
        try {
            this.f131b.lock();
            int size = this.f130a.size() + super.size();
            return size;
        } finally {
            this.f131b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f131b.lock();
            T[] a = m170a(super.toArray(tArr), this.f130a.toArray(tArr));
            return a;
        } finally {
            this.f131b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f131b.lock();
            Object[] a = m170a(super.toArray(), this.f130a.toArray());
            return a;
        } finally {
            this.f131b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.f131b.lock();
            int drainTo = super.drainTo(collection) + this.f130a.size();
            while (!this.f130a.isEmpty()) {
                collection.add(this.f130a.poll());
            }
            return drainTo;
        } finally {
            this.f131b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f131b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f130a.isEmpty() && drainTo <= i) {
                collection.add(this.f130a.poll());
                drainTo++;
            }
            this.f131b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.f131b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f131b.lock();
            boolean z = super.contains(obj) || this.f130a.contains(obj);
            this.f131b.unlock();
            return z;
        } catch (Throwable th) {
            this.f131b.unlock();
        }
    }

    public void clear() {
        try {
            this.f131b.lock();
            this.f130a.clear();
            super.clear();
        } finally {
            this.f131b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f131b.lock();
            boolean z = super.remove(obj) || this.f130a.remove(obj);
            this.f131b.unlock();
            return z;
        } catch (Throwable th) {
            this.f131b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f131b.lock();
            boolean removeAll = super.removeAll(collection) | this.f130a.removeAll(collection);
            return removeAll;
        } finally {
            this.f131b.unlock();
        }
    }

    E m166a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return (Dependency) super.take();
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return (Dependency) super.peek();
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return (Dependency) super.poll();
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return (Dependency) super.poll(l.longValue(), timeUnit);
            default:
                return null;
        }
    }

    boolean m168a(int i, E e) {
        try {
            this.f131b.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.f130a.offer(e);
            return offer;
        } finally {
            this.f131b.unlock();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    E m172b(int r3, java.lang.Long r4, java.util.concurrent.TimeUnit r5) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r2.m166a(r3, r4, r5);
        if (r0 == 0) goto L_0x000c;
    L_0x0006:
        r1 = r2.m169a(r0);
        if (r1 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r2.m168a(r3, r0);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.c.c.b(int, java.lang.Long, java.util.concurrent.TimeUnit):E");
    }

    boolean m169a(E e) {
        return e.areDependenciesMet();
    }

    public void m174d() {
        try {
            this.f131b.lock();
            Iterator it = this.f130a.iterator();
            while (it.hasNext()) {
                Dependency dependency = (Dependency) it.next();
                if (m169a(dependency)) {
                    super.offer(dependency);
                    it.remove();
                }
            }
        } finally {
            this.f131b.unlock();
        }
    }

    <T> T[] m170a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
