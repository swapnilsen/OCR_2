package com.google.p044a.p046b;

/* renamed from: com.google.a.b.b */
final class GwtWorkarounds {

    /* renamed from: com.google.a.b.b.a */
    interface GwtWorkarounds {
        void m2787a();

        void m2788a(byte b);
    }

    /* renamed from: com.google.a.b.b.b */
    interface GwtWorkarounds {
        void m2802a();

        void m2803a(char c);
    }

    /* renamed from: com.google.a.b.b.1 */
    static class GwtWorkarounds implements GwtWorkarounds {
        final /* synthetic */ StringBuilder f2250a;

        GwtWorkarounds(StringBuilder stringBuilder) {
            this.f2250a = stringBuilder;
        }

        public void m2805a(char c) {
            this.f2250a.append(c);
        }

        public void m2804a() {
        }

        public String toString() {
            return this.f2250a.toString();
        }
    }

    static GwtWorkarounds m2806a(int i) {
        return new GwtWorkarounds(new StringBuilder(i));
    }
}
