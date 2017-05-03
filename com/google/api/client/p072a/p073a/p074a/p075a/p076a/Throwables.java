package com.google.api.client.p072a.p073a.p074a.p075a.p076a;

/* renamed from: com.google.api.client.a.a.a.a.a.g */
public final class Throwables {
    public static <X extends Throwable> void m4778a(Throwable th, Class<X> cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void m4777a(Throwable th) {
        Throwables.m4778a(th, Error.class);
        Throwables.m4778a(th, RuntimeException.class);
    }

    public static RuntimeException m4779b(Throwable th) {
        Throwables.m4777a((Throwable) Preconditions.m4750a((Object) th));
        throw new RuntimeException(th);
    }
}
