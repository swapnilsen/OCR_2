package com.google.api.client.http;

import com.google.api.client.p082b.ExponentialBackOff;
import com.google.api.client.p082b.NanoClock;

@Deprecated
public class ExponentialBackOffPolicy implements BackOffPolicy {
    public static final int DEFAULT_INITIAL_INTERVAL_MILLIS = 500;
    public static final int DEFAULT_MAX_ELAPSED_TIME_MILLIS = 900000;
    public static final int DEFAULT_MAX_INTERVAL_MILLIS = 60000;
    public static final double DEFAULT_MULTIPLIER = 1.5d;
    public static final double DEFAULT_RANDOMIZATION_FACTOR = 0.5d;
    private final ExponentialBackOff f4321a;

    @Deprecated
    public static class Builder {
        final ExponentialBackOff.ExponentialBackOff f4320a;

        protected Builder() {
            this.f4320a = new ExponentialBackOff.ExponentialBackOff();
        }

        public ExponentialBackOffPolicy build() {
            return new ExponentialBackOffPolicy(this);
        }

        public final int getInitialIntervalMillis() {
            return this.f4320a.m4921b();
        }

        public Builder setInitialIntervalMillis(int i) {
            this.f4320a.m4918a(i);
            return this;
        }

        public final double getRandomizationFactor() {
            return this.f4320a.m4924c();
        }

        public Builder setRandomizationFactor(double d) {
            this.f4320a.m4917a(d);
            return this;
        }

        public final double getMultiplier() {
            return this.f4320a.m4926d();
        }

        public Builder setMultiplier(double d) {
            this.f4320a.m4922b(d);
            return this;
        }

        public final int getMaxIntervalMillis() {
            return this.f4320a.m4927e();
        }

        public Builder setMaxIntervalMillis(int i) {
            this.f4320a.m4923b(i);
            return this;
        }

        public final int getMaxElapsedTimeMillis() {
            return this.f4320a.m4928f();
        }

        public Builder setMaxElapsedTimeMillis(int i) {
            this.f4320a.m4925c(i);
            return this;
        }

        public final NanoClock getNanoClock() {
            return this.f4320a.m4929g();
        }

        public Builder setNanoClock(NanoClock nanoClock) {
            this.f4320a.m4919a(nanoClock);
            return this;
        }
    }

    public ExponentialBackOffPolicy() {
        this(new Builder());
    }

    protected ExponentialBackOffPolicy(Builder builder) {
        this.f4321a = builder.f4320a.m4920a();
    }

    public boolean isBackOffRequired(int i) {
        switch (i) {
            case DEFAULT_INITIAL_INTERVAL_MILLIS /*500*/:
            case HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE /*503*/:
                return true;
            default:
                return false;
        }
    }

    public final void reset() {
        this.f4321a.m4933b();
    }

    public long getNextBackOffMillis() {
        return this.f4321a.m4932a();
    }

    public final int getInitialIntervalMillis() {
        return this.f4321a.m4934c();
    }

    public final double getRandomizationFactor() {
        return this.f4321a.m4935d();
    }

    public final int getCurrentIntervalMillis() {
        return this.f4321a.m4936e();
    }

    public final double getMultiplier() {
        return this.f4321a.m4937f();
    }

    public final int getMaxIntervalMillis() {
        return this.f4321a.m4938g();
    }

    public final int getMaxElapsedTimeMillis() {
        return this.f4321a.m4939h();
    }

    public final long getElapsedTimeMillis() {
        return this.f4321a.m4940i();
    }

    public static Builder builder() {
        return new Builder();
    }
}
