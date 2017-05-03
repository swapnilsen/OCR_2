package p000a.p001a.p002a.p003a.p004a.p007c.p008a;

/* renamed from: a.a.a.a.a.c.a.c */
public class ExponentialBackoff implements Backoff {
    private final long f111a;
    private final int f112b;

    public ExponentialBackoff(long j, int i) {
        this.f111a = j;
        this.f112b = i;
    }

    public long getDelayMillis(int i) {
        return (long) (((double) this.f111a) * Math.pow((double) this.f112b, (double) i));
    }
}
