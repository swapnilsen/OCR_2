package com.google.android.exoplayer2.p052c.p054b;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorInput;

/* renamed from: com.google.android.exoplayer2.c.b.e */
final class Sniffer {
    private final ParsableByteArray f2644a;
    private int f2645b;

    public Sniffer() {
        this.f2644a = new ParsableByteArray(8);
    }

    public boolean m3224a(ExtractorInput extractorInput) {
        long d = extractorInput.m3241d();
        long j = (d == -1 || d > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : d;
        int i = (int) j;
        extractorInput.m3240c(this.f2644a.f3831a, 0, 4);
        j = this.f2644a.m4466l();
        this.f2645b = 4;
        while (j != 440786851) {
            int i2 = this.f2645b + 1;
            this.f2645b = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.m3240c(this.f2644a.f3831a, 0, 1);
            j = ((j << 8) & -256) | ((long) (this.f2644a.f3831a[0] & MotionEventCompat.ACTION_MASK));
        }
        j = m3223b(extractorInput);
        long j2 = (long) this.f2645b;
        if (j == Long.MIN_VALUE) {
            return false;
        }
        if (d != -1 && j2 + j >= d) {
            return false;
        }
        while (((long) this.f2645b) < j2 + j) {
            if (m3223b(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            d = m3223b(extractorInput);
            if (d < 0 || d > 2147483647L) {
                return false;
            }
            if (d != 0) {
                extractorInput.m3239c((int) d);
                this.f2645b = (int) (d + ((long) this.f2645b));
            }
        }
        return ((long) this.f2645b) == j + j2;
    }

    private long m3223b(ExtractorInput extractorInput) {
        int i = 0;
        extractorInput.m3240c(this.f2644a.f3831a, 0, 1);
        int i2 = this.f2644a.f3831a[0] & MotionEventCompat.ACTION_MASK;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i4++;
            i3 >>= 1;
        }
        i3 = (i3 ^ -1) & i2;
        extractorInput.m3240c(this.f2644a.f3831a, 1, i4);
        while (i < i4) {
            i3 = (i3 << 8) + (this.f2644a.f3831a[i + 1] & MotionEventCompat.ACTION_MASK);
            i++;
        }
        this.f2645b += i4 + 1;
        return (long) i3;
    }
}
