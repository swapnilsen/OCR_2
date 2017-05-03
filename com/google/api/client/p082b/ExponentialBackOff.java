package com.google.api.client.p082b;

import com.google.api.client.http.ExponentialBackOffPolicy;
import com.google.api.client.http.HttpStatusCodes;

/* renamed from: com.google.api.client.b.m */
public class ExponentialBackOff implements BackOff {
    long f4185c;
    private int f4186d;
    private final int f4187e;
    private final double f4188f;
    private final double f4189g;
    private final int f4190h;
    private final int f4191i;
    private final NanoClock f4192j;

    /* renamed from: com.google.api.client.b.m.a */
    public static class ExponentialBackOff {
        int f4179a;
        double f4180b;
        double f4181c;
        int f4182d;
        int f4183e;
        NanoClock f4184f;

        public ExponentialBackOff() {
            this.f4179a = HttpStatusCodes.STATUS_CODE_SERVER_ERROR;
            this.f4180b = ExponentialBackOffPolicy.DEFAULT_RANDOMIZATION_FACTOR;
            this.f4181c = ExponentialBackOffPolicy.DEFAULT_MULTIPLIER;
            this.f4182d = ExponentialBackOffPolicy.DEFAULT_MAX_INTERVAL_MILLIS;
            this.f4183e = ExponentialBackOffPolicy.DEFAULT_MAX_ELAPSED_TIME_MILLIS;
            this.f4184f = NanoClock.f4218a;
        }

        public ExponentialBackOff m4920a() {
            return new ExponentialBackOff(this);
        }

        public final int m4921b() {
            return this.f4179a;
        }

        public ExponentialBackOff m4918a(int i) {
            this.f4179a = i;
            return this;
        }

        public final double m4924c() {
            return this.f4180b;
        }

        public ExponentialBackOff m4917a(double d) {
            this.f4180b = d;
            return this;
        }

        public final double m4926d() {
            return this.f4181c;
        }

        public ExponentialBackOff m4922b(double d) {
            this.f4181c = d;
            return this;
        }

        public final int m4927e() {
            return this.f4182d;
        }

        public ExponentialBackOff m4923b(int i) {
            this.f4182d = i;
            return this;
        }

        public final int m4928f() {
            return this.f4183e;
        }

        public ExponentialBackOff m4925c(int i) {
            this.f4183e = i;
            return this;
        }

        public final NanoClock m4929g() {
            return this.f4184f;
        }

        public ExponentialBackOff m4919a(NanoClock nanoClock) {
            this.f4184f = (NanoClock) Preconditions.m4968a((Object) nanoClock);
            return this;
        }
    }

    public ExponentialBackOff() {
        this(new ExponentialBackOff());
    }

    protected ExponentialBackOff(ExponentialBackOff exponentialBackOff) {
        boolean z;
        boolean z2 = true;
        this.f4187e = exponentialBackOff.f4179a;
        this.f4188f = exponentialBackOff.f4180b;
        this.f4189g = exponentialBackOff.f4181c;
        this.f4190h = exponentialBackOff.f4182d;
        this.f4191i = exponentialBackOff.f4183e;
        this.f4192j = exponentialBackOff.f4184f;
        Preconditions.m4971a(this.f4187e > 0);
        if (0.0d > this.f4188f || this.f4188f >= 1.0d) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.m4971a(z);
        if (this.f4189g >= 1.0d) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.m4971a(z);
        if (this.f4190h >= this.f4187e) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.m4971a(z);
        if (this.f4191i <= 0) {
            z2 = false;
        }
        Preconditions.m4971a(z2);
        m4933b();
    }

    public final void m4933b() {
        this.f4186d = this.f4187e;
        this.f4185c = this.f4192j.m4961a();
    }

    public long m4932a() {
        if (m4940i() > ((long) this.f4191i)) {
            return -1;
        }
        int a = ExponentialBackOff.m4930a(this.f4188f, Math.random(), this.f4186d);
        m4931j();
        return (long) a;
    }

    static int m4930a(double d, double d2, int i) {
        double d3 = ((double) i) * d;
        double d4 = ((double) i) - d3;
        return (int) (((((d3 + ((double) i)) - d4) + 1.0d) * d2) + d4);
    }

    public final int m4934c() {
        return this.f4187e;
    }

    public final double m4935d() {
        return this.f4188f;
    }

    public final int m4936e() {
        return this.f4186d;
    }

    public final double m4937f() {
        return this.f4189g;
    }

    public final int m4938g() {
        return this.f4190h;
    }

    public final int m4939h() {
        return this.f4191i;
    }

    public final long m4940i() {
        return (this.f4192j.m4961a() - this.f4185c) / 1000000;
    }

    private void m4931j() {
        if (((double) this.f4186d) >= ((double) this.f4190h) / this.f4189g) {
            this.f4186d = this.f4190h;
        } else {
            this.f4186d = (int) (((double) this.f4186d) * this.f4189g);
        }
    }
}
