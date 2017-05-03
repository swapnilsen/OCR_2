package com.google.android.exoplayer2.p050j;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.j.i */
public final class NalUnitUtil {
    public static final byte[] f3823a;
    public static final float[] f3824b;
    private static final Object f3825c;
    private static int[] f3826d;

    /* renamed from: com.google.android.exoplayer2.j.i.a */
    public static final class NalUnitUtil {
        public final int f3810a;
        public final int f3811b;
        public final boolean f3812c;

        public NalUnitUtil(int i, int i2, boolean z) {
            this.f3810a = i;
            this.f3811b = i2;
            this.f3812c = z;
        }
    }

    /* renamed from: com.google.android.exoplayer2.j.i.b */
    public static final class NalUnitUtil {
        public final int f3813a;
        public final int f3814b;
        public final int f3815c;
        public final float f3816d;
        public final boolean f3817e;
        public final boolean f3818f;
        public final int f3819g;
        public final int f3820h;
        public final int f3821i;
        public final boolean f3822j;

        public NalUnitUtil(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f3813a = i;
            this.f3814b = i2;
            this.f3815c = i3;
            this.f3816d = f;
            this.f3817e = z;
            this.f3818f = z2;
            this.f3819g = i4;
            this.f3820h = i5;
            this.f3821i = i6;
            this.f3822j = z3;
        }
    }

    static {
        f3823a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
        f3824b = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        f3825c = new Object();
        f3826d = new int[10];
    }

    public static int m4430a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        synchronized (f3825c) {
            int c;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i) {
                c = NalUnitUtil.m4439c(bArr, i5, i);
                if (c < i) {
                    if (f3826d.length <= i4) {
                        f3826d = Arrays.copyOf(f3826d, f3826d.length * 2);
                    }
                    i5 = i4 + 1;
                    f3826d[i4] = c;
                    i4 = i5;
                    i5 = c + 3;
                } else {
                    i5 = c;
                }
            }
            i2 = i - i4;
            i5 = 0;
            c = 0;
            while (i3 < i4) {
                int i6 = f3826d[i3] - c;
                System.arraycopy(bArr, c, bArr, i5, i6);
                i5 += i6;
                int i7 = i5 + 1;
                bArr[i5] = (byte) 0;
                i5 = i7 + 1;
                bArr[i7] = (byte) 0;
                c += i6 + 3;
                i3++;
            }
            System.arraycopy(bArr, c, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void m4434a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (i + 1 < position) {
            int i3 = byteBuffer.get(i) & MotionEventCompat.ACTION_MASK;
            if (i2 == 3) {
                if (i3 == 1 && (byteBuffer.get(i + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i2++;
            }
            if (i3 != 0) {
                i2 = 0;
            }
            i++;
        }
        byteBuffer.clear();
    }

    public static int m4436b(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int m4438c(byte[] bArr, int i) {
        return (bArr[i + 3] & TransportMediator.KEYCODE_MEDIA_PLAY) >> 1;
    }

    public static NalUnitUtil m4432a(byte[] bArr, int i, int i2) {
        int c;
        int i3;
        boolean z;
        int i4;
        float f;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.m4483a(8);
        int c2 = parsableNalUnitBitArray.m4489c(8);
        parsableNalUnitBitArray.m4483a(16);
        int c3 = parsableNalUnitBitArray.m4488c();
        boolean z2 = false;
        if (c2 == 100 || c2 == C0268R.styleable.AppCompatTheme_ratingBarStyleSmall || c2 == 122 || c2 == 244 || c2 == 44 || c2 == 83 || c2 == 86 || c2 == 118 || c2 == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS || c2 == 138) {
            c = parsableNalUnitBitArray.m4488c();
            if (c == 3) {
                z2 = parsableNalUnitBitArray.m4485a();
            }
            parsableNalUnitBitArray.m4488c();
            parsableNalUnitBitArray.m4488c();
            parsableNalUnitBitArray.m4483a(1);
            if (parsableNalUnitBitArray.m4485a()) {
                i3 = c != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i3) {
                    if (parsableNalUnitBitArray.m4485a()) {
                        NalUnitUtil.m4433a(parsableNalUnitBitArray, i5 < 6 ? 16 : 64);
                    }
                    i5++;
                }
            }
            z = z2;
            i4 = c;
        } else {
            z = false;
            i4 = 1;
        }
        int c4 = parsableNalUnitBitArray.m4488c() + 4;
        int c5 = parsableNalUnitBitArray.m4488c();
        int i6 = 0;
        boolean z3 = false;
        if (c5 != 0) {
            if (c5 == 1) {
                z3 = parsableNalUnitBitArray.m4485a();
                parsableNalUnitBitArray.m4490d();
                parsableNalUnitBitArray.m4490d();
                long c6 = (long) parsableNalUnitBitArray.m4488c();
                i3 = 0;
                while (true) {
                    if (((long) i3) >= c6) {
                        break;
                    }
                    parsableNalUnitBitArray.m4488c();
                    i3++;
                }
            }
        } else {
            i6 = parsableNalUnitBitArray.m4488c() + 4;
        }
        parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4483a(1);
        c2 = parsableNalUnitBitArray.m4488c() + 1;
        c = parsableNalUnitBitArray.m4488c() + 1;
        boolean a = parsableNalUnitBitArray.m4485a();
        i3 = (2 - (a ? 1 : 0)) * c;
        if (!a) {
            parsableNalUnitBitArray.m4483a(1);
        }
        parsableNalUnitBitArray.m4483a(1);
        c = c2 * 16;
        c2 = i3 * 16;
        if (parsableNalUnitBitArray.m4485a()) {
            int c7 = parsableNalUnitBitArray.m4488c();
            int c8 = parsableNalUnitBitArray.m4488c();
            int c9 = parsableNalUnitBitArray.m4488c();
            int c10 = parsableNalUnitBitArray.m4488c();
            if (i4 == 0) {
                i3 = 1;
                i4 = 2 - (a ? 1 : 0);
            } else {
                i3 = i4 == 3 ? 1 : 2;
                i4 = (2 - (a ? 1 : 0)) * (i4 == 1 ? 2 : 1);
            }
            i3 = c - (i3 * (c7 + c8));
            c2 -= i4 * (c9 + c10);
        } else {
            i3 = c;
        }
        float f2 = 1.0f;
        if (parsableNalUnitBitArray.m4485a() && parsableNalUnitBitArray.m4485a()) {
            c = parsableNalUnitBitArray.m4489c(8);
            if (c == MotionEventCompat.ACTION_MASK) {
                c = parsableNalUnitBitArray.m4489c(16);
                int c11 = parsableNalUnitBitArray.m4489c(16);
                if (!(c == 0 || c11 == 0)) {
                    f2 = ((float) c) / ((float) c11);
                }
                f = f2;
            } else if (c < f3824b.length) {
                f = f3824b[c];
            } else {
                Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + c);
            }
            return new NalUnitUtil(c3, i3, c2, f, z, a, c4, c5, i6, z3);
        }
        f = 1.0f;
        return new NalUnitUtil(c3, i3, c2, f, z, a, c4, c5, i6, z3);
    }

    public static NalUnitUtil m4437b(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.m4483a(8);
        int c = parsableNalUnitBitArray.m4488c();
        int c2 = parsableNalUnitBitArray.m4488c();
        parsableNalUnitBitArray.m4483a(1);
        return new NalUnitUtil(c, c2, parsableNalUnitBitArray.m4485a());
    }

    public static int m4431a(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z = true;
        int i3 = i2 - i;
        Assertions.m4406b(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                NalUnitUtil.m4435a(zArr);
                return i - 3;
            } else if (i3 > 1 && zArr[1] && bArr[i] == (byte) 1) {
                NalUnitUtil.m4435a(zArr);
                return i - 2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == null && bArr[i + 1] == (byte) 1) {
                NalUnitUtil.m4435a(zArr);
                return i - 1;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                if (bArr[i5 - 2] == null && bArr[i5 - 1] == null && bArr[i5] == (byte) 1) {
                    if (zArr != null) {
                        NalUnitUtil.m4435a(zArr);
                    }
                    return i5 - 2;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr == null) {
            return i2;
        }
        boolean z2 = i3 > 2 ? bArr[i2 + -3] == null && bArr[i2 - 2] == null && bArr[i2 - 1] == (byte) 1 : i3 == 2 ? zArr[2] && bArr[i2 - 2] == null && bArr[i2 - 1] == (byte) 1 : zArr[1] && bArr[i2 - 1] == (byte) 1;
        zArr[0] = z2;
        z2 = i3 > 1 ? bArr[i2 + -2] == null && bArr[i2 - 1] == null : zArr[2] && bArr[i2 - 1] == null;
        zArr[1] = z2;
        if (bArr[i2 - 1] != null) {
            z = false;
        }
        zArr[2] = z;
        return i2;
    }

    public static void m4435a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int m4439c(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i3 < i2 - 2) {
            if (bArr[i3] == null && bArr[i3 + 1] == null && bArr[i3 + 2] == 3) {
                return i3;
            }
            i3++;
        }
        return i2;
    }

    private static void m4433a(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableNalUnitBitArray.m4490d() + i3) + AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }
}
