package p000a.p001a.p002a.p003a.p004a.p007c.p008a;

/* renamed from: a.a.a.a.a.c.a.e */
public class RetryState {
    private final int f113a;
    private final Backoff f114b;
    private final RetryPolicy f115c;

    public RetryState(Backoff backoff, RetryPolicy retryPolicy) {
        this(0, backoff, retryPolicy);
    }

    public RetryState(int i, Backoff backoff, RetryPolicy retryPolicy) {
        this.f113a = i;
        this.f114b = backoff;
        this.f115c = retryPolicy;
    }

    public long m145a() {
        return this.f114b.getDelayMillis(this.f113a);
    }

    public RetryState m146b() {
        return new RetryState(this.f113a + 1, this.f114b, this.f115c);
    }

    public RetryState m147c() {
        return new RetryState(this.f114b, this.f115c);
    }
}
