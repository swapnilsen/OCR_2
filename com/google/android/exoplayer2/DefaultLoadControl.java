package com.google.android.exoplayer2;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p062f.TrackGroupArray;
import com.google.android.exoplayer2.p063i.Allocator;
import com.google.android.exoplayer2.p063i.DefaultAllocator;
import com.google.android.exoplayer2.p070h.TrackSelections;

/* renamed from: com.google.android.exoplayer2.c */
public final class DefaultLoadControl implements LoadControl {
    private final DefaultAllocator f3271a;
    private final long f3272b;
    private final long f3273c;
    private final long f3274d;
    private final long f3275e;
    private int f3276f;
    private boolean f3277g;

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, AccessibilityNodeInfoCompat.ACTION_CUT));
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 15000, 30000, 2500, 5000);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, long j, long j2) {
        this.f3271a = defaultAllocator;
        this.f3272b = ((long) i) * 1000;
        this.f3273c = ((long) i2) * 1000;
        this.f3274d = j * 1000;
        this.f3275e = j2 * 1000;
    }

    public void m3751a() {
        m3749a(false);
    }

    public void m3752a(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelections<?> trackSelections) {
        int i = 0;
        this.f3276f = 0;
        while (i < rendererArr.length) {
            if (trackSelections.m4280a(i) != null) {
                this.f3276f += Util.m4519b(rendererArr[i].m2961a());
            }
            i++;
        }
        this.f3271a.m4344a(this.f3276f);
    }

    public void m3755b() {
        m3749a(true);
    }

    public void m3756c() {
        m3749a(true);
    }

    public Allocator m3757d() {
        return this.f3271a;
    }

    public boolean m3754a(long j, boolean z) {
        long j2 = z ? this.f3275e : this.f3274d;
        return j2 <= 0 || j >= j2;
    }

    public boolean m3753a(long j) {
        boolean z = false;
        int b = m3750b(j);
        boolean z2;
        if (this.f3271a.m4350e() >= this.f3276f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (b == 2 || (b == 1 && this.f3277g && !r2)) {
            z = true;
        }
        this.f3277g = z;
        return this.f3277g;
    }

    private int m3750b(long j) {
        if (j > this.f3273c) {
            return 0;
        }
        return j < this.f3272b ? 2 : 1;
    }

    private void m3749a(boolean z) {
        this.f3276f = 0;
        this.f3277g = false;
        if (z) {
            this.f3271a.m4349d();
        }
    }
}
