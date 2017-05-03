package com.google.api.client.p082b;

/* renamed from: com.google.api.client.b.c */
public interface BackOff {
    public static final BackOff f4134a;
    public static final BackOff f4135b;

    /* renamed from: com.google.api.client.b.c.1 */
    static class BackOff implements BackOff {
        BackOff() {
        }

        public long m4881a() {
            return 0;
        }
    }

    /* renamed from: com.google.api.client.b.c.2 */
    static class BackOff implements BackOff {
        BackOff() {
        }

        public long m4882a() {
            return -1;
        }
    }

    long m4880a();

    static {
        f4134a = new BackOff();
        f4135b = new BackOff();
    }
}
