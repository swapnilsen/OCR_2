package com.google.api.client.p082b;

/* renamed from: com.google.api.client.b.v */
public interface NanoClock {
    public static final NanoClock f4218a;

    /* renamed from: com.google.api.client.b.v.1 */
    static class NanoClock implements NanoClock {
        NanoClock() {
        }

        public long m4962a() {
            return System.nanoTime();
        }
    }

    long m4961a();

    static {
        f4218a = new NanoClock();
    }
}
