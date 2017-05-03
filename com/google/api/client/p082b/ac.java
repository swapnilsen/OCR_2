package com.google.api.client.p082b;

/* compiled from: Sleeper */
/* renamed from: com.google.api.client.b.ac */
public interface ac {
    public static final ac f4123a;

    /* renamed from: com.google.api.client.b.ac.1 */
    static class Sleeper implements ac {
        Sleeper() {
        }

        public void m4851a(long j) {
            Thread.sleep(j);
        }
    }

    void m4850a(long j);

    static {
        f4123a = new Sleeper();
    }
}
