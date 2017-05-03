package com.google.android.exoplayer2.p052c.p056d;

import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorInput;

/* renamed from: com.google.android.exoplayer2.c.d.k */
final class TrackFragment {
    public DefaultSampleValues f2869a;
    public long f2870b;
    public long f2871c;
    public long f2872d;
    public int f2873e;
    public int f2874f;
    public long[] f2875g;
    public int[] f2876h;
    public int[] f2877i;
    public int[] f2878j;
    public long[] f2879k;
    public boolean[] f2880l;
    public boolean f2881m;
    public boolean[] f2882n;
    public TrackEncryptionBox f2883o;
    public int f2884p;
    public ParsableByteArray f2885q;
    public boolean f2886r;
    public long f2887s;

    TrackFragment() {
    }

    public void m3416a() {
        this.f2873e = 0;
        this.f2887s = 0;
        this.f2881m = false;
        this.f2886r = false;
        this.f2883o = null;
    }

    public void m3418a(int i, int i2) {
        this.f2873e = i;
        this.f2874f = i2;
        if (this.f2876h == null || this.f2876h.length < i) {
            this.f2875g = new long[i];
            this.f2876h = new int[i];
        }
        if (this.f2877i == null || this.f2877i.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.f2877i = new int[i3];
            this.f2878j = new int[i3];
            this.f2879k = new long[i3];
            this.f2880l = new boolean[i3];
            this.f2882n = new boolean[i3];
        }
    }

    public void m3417a(int i) {
        if (this.f2885q == null || this.f2885q.m4454c() < i) {
            this.f2885q = new ParsableByteArray(i);
        }
        this.f2884p = i;
        this.f2881m = true;
        this.f2886r = true;
    }

    public void m3419a(ExtractorInput extractorInput) {
        extractorInput.m3236b(this.f2885q.f3831a, 0, this.f2884p);
        this.f2885q.m4455c(0);
        this.f2886r = false;
    }

    public void m3420a(ParsableByteArray parsableByteArray) {
        parsableByteArray.m4451a(this.f2885q.f3831a, 0, this.f2884p);
        this.f2885q.m4455c(0);
        this.f2886r = false;
    }

    public long m3421b(int i) {
        return this.f2879k[i] + ((long) this.f2878j[i]);
    }
}
