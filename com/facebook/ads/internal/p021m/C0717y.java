package com.facebook.ads.internal.p021m;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.m.y */
public class C0717y {
    public final String f1757a;
    public final long f1758b;
    public final long f1759c;
    public final long f1760d;
    public final long f1761e;
    public final long f1762f;
    public final long f1763g;
    public final long f1764h;

    /* renamed from: com.facebook.ads.internal.m.y.a */
    public static class C0716a {
        private final String f1749a;
        private long f1750b;
        private long f1751c;
        private long f1752d;
        private long f1753e;
        private long f1754f;
        private long f1755g;
        private long f1756h;

        public C0716a(String str) {
            this.f1750b = -1;
            this.f1751c = -1;
            this.f1752d = -1;
            this.f1753e = -1;
            this.f1754f = -1;
            this.f1755g = -1;
            this.f1756h = -1;
            this.f1749a = str;
        }

        public C0716a m2321a(long j) {
            this.f1750b = j;
            return this;
        }

        public C0717y m2322a() {
            return new C0717y(this.f1750b, this.f1751c, this.f1752d, this.f1753e, this.f1754f, this.f1755g, this.f1756h, null);
        }

        public C0716a m2323b(long j) {
            this.f1751c = j;
            return this;
        }

        public C0716a m2324c(long j) {
            this.f1752d = j;
            return this;
        }

        public C0716a m2325d(long j) {
            this.f1753e = j;
            return this;
        }

        public C0716a m2326e(long j) {
            this.f1754f = j;
            return this;
        }

        public C0716a m2327f(long j) {
            this.f1755g = j;
            return this;
        }

        public C0716a m2328g(long j) {
            this.f1756h = j;
            return this;
        }
    }

    private C0717y(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.f1757a = str;
        this.f1758b = j;
        this.f1759c = j2;
        this.f1760d = j3;
        this.f1761e = j4;
        this.f1762f = j5;
        this.f1763g = j6;
        this.f1764h = j7;
    }

    public Map<String, String> m2329a() {
        Map<String, String> hashMap = new HashMap(7);
        hashMap.put("initial_url", this.f1757a);
        hashMap.put("handler_time_ms", String.valueOf(this.f1758b));
        hashMap.put("load_start_ms", String.valueOf(this.f1759c));
        hashMap.put("response_end_ms", String.valueOf(this.f1760d));
        hashMap.put("dom_content_loaded_ms", String.valueOf(this.f1761e));
        hashMap.put("scroll_ready_ms", String.valueOf(this.f1762f));
        hashMap.put("load_finish_ms", String.valueOf(this.f1763g));
        hashMap.put("session_finish_ms", String.valueOf(this.f1764h));
        return hashMap;
    }
}
