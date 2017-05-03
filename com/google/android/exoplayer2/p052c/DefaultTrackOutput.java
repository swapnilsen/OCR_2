package com.google.android.exoplayer2.p052c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p051b.DecoderInputBuffer;
import com.google.android.exoplayer2.p063i.Allocation;
import com.google.android.exoplayer2.p063i.Allocator;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.exoplayer2.c.d */
public final class DefaultTrackOutput implements TrackOutput {
    private final Allocator f2894a;
    private final int f2895b;
    private final DefaultTrackOutput f2896c;
    private final LinkedBlockingDeque<Allocation> f2897d;
    private final DefaultTrackOutput f2898e;
    private final ParsableByteArray f2899f;
    private final AtomicInteger f2900g;
    private long f2901h;
    private Format f2902i;
    private long f2903j;
    private long f2904k;
    private Allocation f2905l;
    private int f2906m;
    private boolean f2907n;
    private boolean f2908o;
    private DefaultTrackOutput f2909p;

    /* renamed from: com.google.android.exoplayer2.c.d.a */
    private static final class DefaultTrackOutput {
        public int f2687a;
        public long f2688b;
        public long f2689c;
        public byte[] f2690d;

        private DefaultTrackOutput() {
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b */
    private static final class DefaultTrackOutput {
        private int f2691a;
        private int[] f2692b;
        private long[] f2693c;
        private int[] f2694d;
        private int[] f2695e;
        private long[] f2696f;
        private byte[][] f2697g;
        private Format[] f2698h;
        private int f2699i;
        private int f2700j;
        private int f2701k;
        private int f2702l;
        private long f2703m;
        private long f2704n;
        private boolean f2705o;
        private Format f2706p;
        private int f2707q;

        public DefaultTrackOutput() {
            this.f2691a = PointerIconCompat.TYPE_DEFAULT;
            this.f2692b = new int[this.f2691a];
            this.f2693c = new long[this.f2691a];
            this.f2696f = new long[this.f2691a];
            this.f2695e = new int[this.f2691a];
            this.f2694d = new int[this.f2691a];
            this.f2697g = new byte[this.f2691a][];
            this.f2698h = new Format[this.f2691a];
            this.f2703m = Long.MIN_VALUE;
            this.f2704n = Long.MIN_VALUE;
            this.f2705o = true;
        }

        public void m3299a() {
            this.f2700j = 0;
            this.f2701k = 0;
            this.f2702l = 0;
            this.f2699i = 0;
        }

        public void m3302b() {
            this.f2703m = Long.MIN_VALUE;
            this.f2704n = Long.MIN_VALUE;
        }

        public int m3304c() {
            return this.f2700j + this.f2699i;
        }

        public long m3297a(int i) {
            int c = m3304c() - i;
            boolean z = c >= 0 && c <= this.f2699i;
            Assertions.m4404a(z);
            int i2;
            if (c != 0) {
                this.f2699i -= c;
                this.f2702l = ((this.f2702l + this.f2691a) - c) % this.f2691a;
                this.f2704n = Long.MIN_VALUE;
                for (i2 = this.f2699i - 1; i2 >= 0; i2--) {
                    c = (this.f2701k + i2) % this.f2691a;
                    this.f2704n = Math.max(this.f2704n, this.f2696f[c]);
                    if ((this.f2695e[c] & 1) != 0) {
                        break;
                    }
                }
                return this.f2693c[this.f2702l];
            } else if (this.f2700j == 0) {
                return 0;
            } else {
                i2 = (this.f2702l == 0 ? this.f2691a : this.f2702l) - 1;
                return ((long) this.f2694d[i2]) + this.f2693c[i2];
            }
        }

        public synchronized boolean m3306d() {
            return this.f2699i == 0;
        }

        public synchronized Format m3307e() {
            return this.f2705o ? null : this.f2706p;
        }

        public synchronized long m3308f() {
            return Math.max(this.f2703m, this.f2704n);
        }

        public synchronized int m3296a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, Format format, DefaultTrackOutput defaultTrackOutput) {
            int i = -5;
            synchronized (this) {
                if (this.f2699i == 0) {
                    if (this.f2706p == null || this.f2706p == format) {
                        i = -3;
                    } else {
                        formatHolder.f3791a = this.f2706p;
                    }
                } else if (this.f2698h[this.f2701k] != format) {
                    formatHolder.f3791a = this.f2698h[this.f2701k];
                } else {
                    decoderInputBuffer.f2503c = this.f2696f[this.f2701k];
                    decoderInputBuffer.a_(this.f2695e[this.f2701k]);
                    defaultTrackOutput.f2687a = this.f2694d[this.f2701k];
                    defaultTrackOutput.f2688b = this.f2693c[this.f2701k];
                    defaultTrackOutput.f2690d = this.f2697g[this.f2701k];
                    this.f2703m = Math.max(this.f2703m, decoderInputBuffer.f2503c);
                    this.f2699i--;
                    this.f2701k++;
                    this.f2700j++;
                    if (this.f2701k == this.f2691a) {
                        this.f2701k = 0;
                    }
                    defaultTrackOutput.f2689c = this.f2699i > 0 ? this.f2693c[this.f2701k] : defaultTrackOutput.f2688b + ((long) defaultTrackOutput.f2687a);
                    i = -4;
                }
            }
            return i;
        }

        public synchronized long m3298a(long j) {
            long j2 = -1;
            synchronized (this) {
                if (this.f2699i != 0 && j >= this.f2696f[this.f2701k]) {
                    if (j <= this.f2696f[(this.f2702l == 0 ? this.f2691a : this.f2702l) - 1]) {
                        int i = 0;
                        int i2 = this.f2701k;
                        int i3 = -1;
                        while (i2 != this.f2702l && this.f2696f[i2] <= j) {
                            if ((this.f2695e[i2] & 1) != 0) {
                                i3 = i;
                            }
                            i2 = (i2 + 1) % this.f2691a;
                            i++;
                        }
                        if (i3 != -1) {
                            this.f2699i -= i3;
                            this.f2701k = (this.f2701k + i3) % this.f2691a;
                            this.f2700j += i3;
                            j2 = this.f2693c[this.f2701k];
                        }
                    }
                }
            }
            return j2;
        }

        public synchronized boolean m3301a(Format format) {
            boolean z = false;
            synchronized (this) {
                if (format == null) {
                    this.f2705o = true;
                } else {
                    this.f2705o = false;
                    if (!Util.m4517a((Object) format, this.f2706p)) {
                        this.f2706p = format;
                        z = true;
                    }
                }
            }
            return z;
        }

        public synchronized void m3300a(long j, int i, long j2, int i2, byte[] bArr) {
            Assertions.m4406b(!this.f2705o);
            m3303b(j);
            this.f2696f[this.f2702l] = j;
            this.f2693c[this.f2702l] = j2;
            this.f2694d[this.f2702l] = i2;
            this.f2695e[this.f2702l] = i;
            this.f2697g[this.f2702l] = bArr;
            this.f2698h[this.f2702l] = this.f2706p;
            this.f2692b[this.f2702l] = this.f2707q;
            this.f2699i++;
            if (this.f2699i == this.f2691a) {
                int i3 = this.f2691a + PointerIconCompat.TYPE_DEFAULT;
                Object obj = new int[i3];
                Object obj2 = new long[i3];
                Object obj3 = new long[i3];
                Object obj4 = new int[i3];
                Object obj5 = new int[i3];
                Object obj6 = new byte[i3][];
                Object obj7 = new Format[i3];
                int i4 = this.f2691a - this.f2701k;
                System.arraycopy(this.f2693c, this.f2701k, obj2, 0, i4);
                System.arraycopy(this.f2696f, this.f2701k, obj3, 0, i4);
                System.arraycopy(this.f2695e, this.f2701k, obj4, 0, i4);
                System.arraycopy(this.f2694d, this.f2701k, obj5, 0, i4);
                System.arraycopy(this.f2697g, this.f2701k, obj6, 0, i4);
                System.arraycopy(this.f2698h, this.f2701k, obj7, 0, i4);
                System.arraycopy(this.f2692b, this.f2701k, obj, 0, i4);
                int i5 = this.f2701k;
                System.arraycopy(this.f2693c, 0, obj2, i4, i5);
                System.arraycopy(this.f2696f, 0, obj3, i4, i5);
                System.arraycopy(this.f2695e, 0, obj4, i4, i5);
                System.arraycopy(this.f2694d, 0, obj5, i4, i5);
                System.arraycopy(this.f2697g, 0, obj6, i4, i5);
                System.arraycopy(this.f2698h, 0, obj7, i4, i5);
                System.arraycopy(this.f2692b, 0, obj, i4, i5);
                this.f2693c = obj2;
                this.f2696f = obj3;
                this.f2695e = obj4;
                this.f2694d = obj5;
                this.f2697g = obj6;
                this.f2698h = obj7;
                this.f2692b = obj;
                this.f2701k = 0;
                this.f2702l = this.f2691a;
                this.f2699i = this.f2691a;
                this.f2691a = i3;
            } else {
                this.f2702l++;
                if (this.f2702l == this.f2691a) {
                    this.f2702l = 0;
                }
            }
        }

        public synchronized void m3303b(long j) {
            this.f2704n = Math.max(this.f2704n, j);
        }

        public synchronized boolean m3305c(long j) {
            boolean z;
            if (this.f2703m >= j) {
                z = false;
            } else {
                int i = this.f2699i;
                while (i > 0 && this.f2696f[((this.f2701k + i) - 1) % this.f2691a] >= j) {
                    i--;
                }
                m3297a(i + this.f2700j);
                z = true;
            }
            return z;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.c */
    public interface DefaultTrackOutput {
        void m3309a(Format format);
    }

    public DefaultTrackOutput(Allocator allocator) {
        this.f2894a = allocator;
        this.f2895b = allocator.m4330c();
        this.f2896c = new DefaultTrackOutput();
        this.f2897d = new LinkedBlockingDeque();
        this.f2898e = new DefaultTrackOutput();
        this.f2899f = new ParsableByteArray(32);
        this.f2900g = new AtomicInteger();
        this.f2906m = this.f2895b;
        this.f2907n = true;
    }

    public void m3444a(boolean z) {
        int andSet = this.f2900g.getAndSet(z ? 0 : 2);
        m3436h();
        this.f2896c.m3302b();
        if (andSet == 2) {
            this.f2902i = null;
        }
    }

    public int m3437a() {
        return this.f2896c.m3304c();
    }

    public void m3446b() {
        if (this.f2900g.getAndSet(2) == 0) {
            m3436h();
        }
    }

    public boolean m3447c() {
        return this.f2896c.m3306d();
    }

    public Format m3448d() {
        return this.f2896c.m3307e();
    }

    public long m3449e() {
        return this.f2896c.m3308f();
    }

    public boolean m3445a(long j) {
        long a = this.f2896c.m3298a(j);
        if (a == -1) {
            return false;
        }
        m3433b(a);
        return true;
    }

    public int m3439a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, long j) {
        switch (this.f2896c.m3296a(formatHolder, decoderInputBuffer, this.f2902i, this.f2898e)) {
            case -5:
                this.f2902i = formatHolder.f3791a;
                return -5;
            case -4:
                if (decoderInputBuffer.f2503c < j) {
                    decoderInputBuffer.m3074b(RtlSpacingHelper.UNDEFINED);
                }
                if (decoderInputBuffer.m3090d()) {
                    m3432a(decoderInputBuffer, this.f2898e);
                }
                decoderInputBuffer.m3092e(this.f2898e.f2687a);
                m3430a(this.f2898e.f2688b, decoderInputBuffer.f2502b, this.f2898e.f2687a);
                m3433b(this.f2898e.f2689c);
                return -4;
            case -3:
                if (!z) {
                    return -3;
                }
                decoderInputBuffer.a_(4);
                return -4;
            default:
                throw new IllegalStateException();
        }
    }

    private void m3432a(DecoderInputBuffer decoderInputBuffer, DefaultTrackOutput defaultTrackOutput) {
        long j;
        int i = 0;
        long j2 = defaultTrackOutput.f2688b;
        this.f2899f.m4448a(1);
        m3431a(j2, this.f2899f.f3831a, 1);
        long j3 = 1 + j2;
        byte b = this.f2899f.f3831a[0];
        int i2 = (b & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0 ? 1 : 0;
        int i3 = b & TransportMediator.KEYCODE_MEDIA_PAUSE;
        if (decoderInputBuffer.f2501a.f2487a == null) {
            decoderInputBuffer.f2501a.f2487a = new byte[16];
        }
        m3431a(j3, decoderInputBuffer.f2501a.f2487a, i3);
        j3 += (long) i3;
        if (i2 != 0) {
            this.f2899f.m4448a(2);
            m3431a(j3, this.f2899f.f3831a, 2);
            j3 += 2;
            i3 = this.f2899f.m4462h();
            j = j3;
        } else {
            i3 = 1;
            j = j3;
        }
        int[] iArr = decoderInputBuffer.f2501a.f2490d;
        if (iArr == null || iArr.length < i3) {
            iArr = new int[i3];
        }
        int[] iArr2 = decoderInputBuffer.f2501a.f2491e;
        if (iArr2 == null || iArr2.length < i3) {
            iArr2 = new int[i3];
        }
        if (i2 != 0) {
            i2 = i3 * 6;
            this.f2899f.m4448a(i2);
            m3431a(j, this.f2899f.f3831a, i2);
            j += (long) i2;
            this.f2899f.m4455c(0);
            while (i < i3) {
                iArr[i] = this.f2899f.m4462h();
                iArr2[i] = this.f2899f.m4474t();
                i++;
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = defaultTrackOutput.f2687a - ((int) (j - defaultTrackOutput.f2688b));
        }
        decoderInputBuffer.f2501a.m3081a(i3, iArr, iArr2, defaultTrackOutput.f2690d, decoderInputBuffer.f2501a.f2487a, 1);
        i2 = (int) (j - defaultTrackOutput.f2688b);
        defaultTrackOutput.f2688b += (long) i2;
        defaultTrackOutput.f2687a -= i2;
    }

    private void m3430a(long j, ByteBuffer byteBuffer, int i) {
        while (i > 0) {
            m3433b(j);
            int i2 = (int) (j - this.f2901h);
            int min = Math.min(i, this.f2895b - i2);
            Allocation allocation = (Allocation) this.f2897d.peek();
            byteBuffer.put(allocation.f3694a, allocation.m4325a(i2), min);
            j += (long) min;
            i -= min;
        }
    }

    private void m3431a(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            m3433b(j);
            int i3 = (int) (j - this.f2901h);
            int min = Math.min(i - i2, this.f2895b - i3);
            Allocation allocation = (Allocation) this.f2897d.peek();
            System.arraycopy(allocation.f3694a, allocation.m4325a(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
        }
    }

    private void m3433b(long j) {
        int i = ((int) (j - this.f2901h)) / this.f2895b;
        for (int i2 = 0; i2 < i; i2++) {
            this.f2894a.m4327a((Allocation) this.f2897d.remove());
            this.f2901h += (long) this.f2895b;
        }
    }

    public void m3442a(DefaultTrackOutput defaultTrackOutput) {
        this.f2909p = defaultTrackOutput;
    }

    public void m3441a(Format format) {
        Format a = DefaultTrackOutput.m3429a(format, this.f2903j);
        boolean a2 = this.f2896c.m3301a(a);
        if (this.f2909p != null && a2) {
            this.f2909p.m3309a(a);
        }
    }

    public int m3438a(ExtractorInput extractorInput, int i, boolean z) {
        int a;
        if (m3434f()) {
            try {
                a = extractorInput.m3231a(this.f2905l.f3694a, this.f2905l.m4325a(this.f2906m), m3428a(i));
                if (a != -1) {
                    this.f2906m += a;
                    this.f2904k += (long) a;
                    m3435g();
                    return a;
                } else if (z) {
                    return -1;
                } else {
                    throw new EOFException();
                }
            } finally {
                m3435g();
            }
        } else {
            a = extractorInput.m3230a(i);
            if (a != -1) {
                return a;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
    }

    public void m3443a(ParsableByteArray parsableByteArray, int i) {
        if (m3434f()) {
            while (i > 0) {
                int a = m3428a(i);
                parsableByteArray.m4451a(this.f2905l.f3694a, this.f2905l.m4325a(this.f2906m), a);
                this.f2906m += a;
                this.f2904k += (long) a;
                i -= a;
            }
            m3435g();
            return;
        }
        parsableByteArray.m4457d(i);
    }

    public void m3440a(long j, int i, int i2, int i3, byte[] bArr) {
        if (m3434f()) {
            try {
                if (this.f2908o) {
                    if ((i & 1) == 0 || !this.f2896c.m3305c(j)) {
                        m3435g();
                        return;
                    }
                    this.f2908o = false;
                }
                if (this.f2907n) {
                    if ((i & 1) == 0) {
                        m3435g();
                        return;
                    }
                    this.f2907n = false;
                }
                this.f2896c.m3300a(j + this.f2903j, i, (this.f2904k - ((long) i2)) - ((long) i3), i2, bArr);
                m3435g();
            } catch (Throwable th) {
                m3435g();
            }
        } else {
            this.f2896c.m3303b(j);
        }
    }

    private boolean m3434f() {
        return this.f2900g.compareAndSet(0, 1);
    }

    private void m3435g() {
        if (!this.f2900g.compareAndSet(1, 0)) {
            m3436h();
        }
    }

    private void m3436h() {
        this.f2896c.m3299a();
        this.f2894a.m4328a((Allocation[]) this.f2897d.toArray(new Allocation[this.f2897d.size()]));
        this.f2897d.clear();
        this.f2894a.m4329b();
        this.f2901h = 0;
        this.f2904k = 0;
        this.f2905l = null;
        this.f2906m = this.f2895b;
        this.f2907n = true;
    }

    private int m3428a(int i) {
        if (this.f2906m == this.f2895b) {
            this.f2906m = 0;
            this.f2905l = this.f2894a.m4326a();
            this.f2897d.add(this.f2905l);
        }
        return Math.min(i, this.f2895b - this.f2906m);
    }

    private static Format m3429a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j == 0 || format.f2340u == Long.MAX_VALUE) {
            return format;
        }
        return format.m2873a(format.f2340u + j);
    }
}
