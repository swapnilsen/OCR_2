package com.google.android.exoplayer2;

/* renamed from: com.google.android.exoplayer2.p */
public abstract class Timeline {

    /* renamed from: com.google.android.exoplayer2.p.a */
    public static final class Timeline {
        public Object f3960a;
        public Object f3961b;
        public int f3962c;
        private long f3963d;
        private long f3964e;

        public Timeline m4653a(Object obj, Object obj2, int i, long j, long j2) {
            this.f3960a = obj;
            this.f3961b = obj2;
            this.f3962c = i;
            this.f3963d = j;
            this.f3964e = j2;
            return this;
        }

        public long m4652a() {
            return C.m3114a(this.f3963d);
        }

        public long m4654b() {
            return this.f3963d;
        }

        public long m4655c() {
            return C.m3114a(this.f3964e);
        }
    }

    /* renamed from: com.google.android.exoplayer2.p.b */
    public static final class Timeline {
        public Object f3965a;
        public long f3966b;
        public long f3967c;
        public boolean f3968d;
        public boolean f3969e;
        public int f3970f;
        public int f3971g;
        private long f3972h;
        private long f3973i;
        private long f3974j;

        public Timeline m4657a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.f3965a = obj;
            this.f3966b = j;
            this.f3967c = j2;
            this.f3968d = z;
            this.f3969e = z2;
            this.f3972h = j3;
            this.f3973i = j4;
            this.f3970f = i;
            this.f3971g = i2;
            this.f3974j = j5;
            return this;
        }

        public long m4656a() {
            return this.f3972h;
        }

        public long m4658b() {
            return C.m3114a(this.f3973i);
        }

        public long m4659c() {
            return C.m3114a(this.f3974j);
        }

        public long m4660d() {
            return this.f3974j;
        }
    }

    public abstract int m3943a();

    public abstract int m3944a(Object obj);

    public abstract Timeline m3946a(int i, Timeline timeline, boolean z);

    public abstract Timeline m3948a(int i, Timeline timeline, boolean z);

    public abstract int m3949b();

    public final Timeline m3947a(int i, Timeline timeline) {
        return m3948a(i, timeline, false);
    }

    public final Timeline m3945a(int i, Timeline timeline) {
        return m3946a(i, timeline, false);
    }
}
