package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.MediaClock;
import com.google.android.exoplayer2.p051b.DecoderInputBuffer;
import com.google.android.exoplayer2.p062f.SampleStream;

/* renamed from: com.google.android.exoplayer2.a */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private final int f2433a;
    private int f2434b;
    private int f2435c;
    private SampleStream f2436d;
    private long f2437e;
    private boolean f2438f;
    private boolean f2439g;

    public BaseRenderer(int i) {
        this.f2433a = i;
        this.f2438f = true;
    }

    public final int m2982a() {
        return this.f2433a;
    }

    public final RendererCapabilities m2992b() {
        return this;
    }

    public final void m2984a(int i) {
        this.f2434b = i;
    }

    public MediaClock m2994c() {
        return null;
    }

    public final int m2995d() {
        return this.f2435c;
    }

    public final void m2991a(Format[] formatArr, SampleStream sampleStream, long j, boolean z, long j2) {
        Assertions.m4406b(this.f2435c == 0);
        this.f2435c = 1;
        m2988a(z);
        m2990a(formatArr, sampleStream, j2);
        m2987a(j, z);
    }

    public final void m2996e() {
        boolean z = true;
        if (this.f2435c != 1) {
            z = false;
        }
        Assertions.m4406b(z);
        this.f2435c = 2;
        m3004m();
    }

    public final void m2990a(Format[] formatArr, SampleStream sampleStream, long j) {
        Assertions.m4406b(!this.f2439g);
        this.f2436d = sampleStream;
        this.f2438f = false;
        this.f2437e = j;
        m2989a(formatArr);
    }

    public final SampleStream m2997f() {
        return this.f2436d;
    }

    public final boolean m2998g() {
        return this.f2438f;
    }

    public final void m2999h() {
        this.f2439g = true;
    }

    public final void m3000i() {
        this.f2436d.m3871b();
    }

    public final void m2986a(long j) {
        this.f2439g = false;
        m2987a(j, false);
    }

    public final void m3001j() {
        Assertions.m4406b(this.f2435c == 2);
        this.f2435c = 1;
        m3005n();
    }

    public final void m3002k() {
        boolean z = true;
        if (this.f2435c != 1) {
            z = false;
        }
        Assertions.m4406b(z);
        this.f2435c = 0;
        m3006o();
        this.f2436d = null;
        this.f2439g = false;
    }

    public int m3003l() {
        return 0;
    }

    public void m2985a(int i, Object obj) {
    }

    protected void m2988a(boolean z) {
    }

    protected void m2989a(Format[] formatArr) {
    }

    protected void m2987a(long j, boolean z) {
    }

    protected void m3004m() {
    }

    protected void m3005n() {
    }

    protected void m3006o() {
    }

    protected final int m3007p() {
        return this.f2434b;
    }

    protected final int m2983a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
        int a = this.f2436d.m3868a(formatHolder, decoderInputBuffer);
        if (a == -4) {
            if (decoderInputBuffer.m3076c()) {
                this.f2438f = true;
                if (this.f2439g) {
                    return -4;
                }
                return -3;
            }
            decoderInputBuffer.f2503c += this.f2437e;
        }
        return a;
    }

    protected final boolean m3008q() {
        return this.f2438f ? this.f2439g : this.f2436d.m3870a();
    }

    protected void m2993b(long j) {
        this.f2436d.m3869a(j);
    }
}
