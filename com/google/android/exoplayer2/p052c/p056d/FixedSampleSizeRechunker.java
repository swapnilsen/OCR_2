package com.google.android.exoplayer2.p052c.p056d;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.p050j.Util;

/* renamed from: com.google.android.exoplayer2.c.d.d */
final class FixedSampleSizeRechunker {

    /* renamed from: com.google.android.exoplayer2.c.d.d.a */
    public static final class FixedSampleSizeRechunker {
        public final long[] f2795a;
        public final int[] f2796b;
        public final int f2797c;
        public final long[] f2798d;
        public final int[] f2799e;

        private FixedSampleSizeRechunker(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
            this.f2795a = jArr;
            this.f2796b = iArr;
            this.f2797c = i;
            this.f2798d = jArr2;
            this.f2799e = iArr2;
        }
    }

    public static FixedSampleSizeRechunker m3351a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD / i;
        int i3 = 0;
        int i4 = 0;
        while (i3 < iArr.length) {
            i3++;
            i4 = Util.m4507a(iArr[i3], i2) + i4;
        }
        long[] jArr2 = new long[i4];
        int[] iArr2 = new int[i4];
        long[] jArr3 = new long[i4];
        int[] iArr3 = new int[i4];
        i3 = 0;
        i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < iArr.length) {
            int i7 = iArr[i3];
            long j2 = jArr[i3];
            int i8 = i6;
            i6 = i5;
            i5 = i4;
            i4 = i8;
            while (i7 > 0) {
                int min = Math.min(i2, i7);
                jArr2[i4] = j2;
                iArr2[i4] = i * min;
                int max = Math.max(i5, iArr2[i4]);
                jArr3[i4] = ((long) i6) * j;
                iArr3[i4] = 1;
                j2 += (long) iArr2[i4];
                i4++;
                i7 -= min;
                i6 += min;
                i5 = max;
            }
            i3++;
            i8 = i4;
            i4 = i5;
            i5 = i6;
            i6 = i8;
        }
        return new FixedSampleSizeRechunker(iArr2, i4, jArr3, iArr3, null);
    }
}
