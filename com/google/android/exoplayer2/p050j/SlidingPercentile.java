package com.google.android.exoplayer2.p050j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.j.o */
public final class SlidingPercentile {
    private static final Comparator<SlidingPercentile> f3842a;
    private static final Comparator<SlidingPercentile> f3843b;
    private final int f3844c;
    private final ArrayList<SlidingPercentile> f3845d;
    private final SlidingPercentile[] f3846e;
    private int f3847f;
    private int f3848g;
    private int f3849h;
    private int f3850i;

    /* renamed from: com.google.android.exoplayer2.j.o.1 */
    static class SlidingPercentile implements Comparator<SlidingPercentile> {
        SlidingPercentile() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4491a((SlidingPercentile) obj, (SlidingPercentile) obj2);
        }

        public int m4491a(SlidingPercentile slidingPercentile, SlidingPercentile slidingPercentile2) {
            return slidingPercentile.f3839a - slidingPercentile2.f3839a;
        }
    }

    /* renamed from: com.google.android.exoplayer2.j.o.2 */
    static class SlidingPercentile implements Comparator<SlidingPercentile> {
        SlidingPercentile() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4492a((SlidingPercentile) obj, (SlidingPercentile) obj2);
        }

        public int m4492a(SlidingPercentile slidingPercentile, SlidingPercentile slidingPercentile2) {
            if (slidingPercentile.f3841c < slidingPercentile2.f3841c) {
                return -1;
            }
            return slidingPercentile2.f3841c < slidingPercentile.f3841c ? 1 : 0;
        }
    }

    /* renamed from: com.google.android.exoplayer2.j.o.a */
    private static class SlidingPercentile {
        public int f3839a;
        public int f3840b;
        public float f3841c;

        private SlidingPercentile() {
        }
    }

    static {
        f3842a = new SlidingPercentile();
        f3843b = new SlidingPercentile();
    }

    public SlidingPercentile(int i) {
        this.f3844c = i;
        this.f3846e = new SlidingPercentile[5];
        this.f3845d = new ArrayList();
        this.f3847f = -1;
    }

    public void m4496a(int i, float f) {
        int i2;
        SlidingPercentile slidingPercentile;
        m4493a();
        if (this.f3850i > 0) {
            SlidingPercentile[] slidingPercentileArr = this.f3846e;
            i2 = this.f3850i - 1;
            this.f3850i = i2;
            slidingPercentile = slidingPercentileArr[i2];
        } else {
            slidingPercentile = new SlidingPercentile();
        }
        i2 = this.f3848g;
        this.f3848g = i2 + 1;
        slidingPercentile.f3839a = i2;
        slidingPercentile.f3840b = i;
        slidingPercentile.f3841c = f;
        this.f3845d.add(slidingPercentile);
        this.f3849h += i;
        while (this.f3849h > this.f3844c) {
            i2 = this.f3849h - this.f3844c;
            slidingPercentile = (SlidingPercentile) this.f3845d.get(0);
            if (slidingPercentile.f3840b <= i2) {
                this.f3849h -= slidingPercentile.f3840b;
                this.f3845d.remove(0);
                if (this.f3850i < 5) {
                    SlidingPercentile[] slidingPercentileArr2 = this.f3846e;
                    int i3 = this.f3850i;
                    this.f3850i = i3 + 1;
                    slidingPercentileArr2[i3] = slidingPercentile;
                }
            } else {
                slidingPercentile.f3840b -= i2;
                this.f3849h -= i2;
            }
        }
    }

    public float m4495a(float f) {
        m4494b();
        float f2 = f * ((float) this.f3849h);
        int i = 0;
        for (int i2 = 0; i2 < this.f3845d.size(); i2++) {
            SlidingPercentile slidingPercentile = (SlidingPercentile) this.f3845d.get(i2);
            i += slidingPercentile.f3840b;
            if (((float) i) >= f2) {
                return slidingPercentile.f3841c;
            }
        }
        return this.f3845d.isEmpty() ? Float.NaN : ((SlidingPercentile) this.f3845d.get(this.f3845d.size() - 1)).f3841c;
    }

    private void m4493a() {
        if (this.f3847f != 1) {
            Collections.sort(this.f3845d, f3842a);
            this.f3847f = 1;
        }
    }

    private void m4494b() {
        if (this.f3847f != 0) {
            Collections.sort(this.f3845d, f3843b);
            this.f3847f = 0;
        }
    }
}
