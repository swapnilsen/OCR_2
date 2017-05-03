package com.p013a.p014a.p015a.p017b;

import android.support.v4.view.PointerIconCompat;

/* renamed from: com.a.a.a.b.i */
public final class NumberOutput {
    static final String f444a;
    static final char[] f445b;
    static final char[] f446c;
    static final byte[] f447d;
    static final String[] f448e;
    static final String[] f449f;
    private static int f450g;
    private static int f451h;
    private static long f452i;
    private static long f453j;
    private static long f454k;
    private static long f455l;

    static {
        f450g = 1000000;
        f451h = 1000000000;
        f452i = 10000000000L;
        f453j = 1000;
        f454k = -2147483648L;
        f455l = 2147483647L;
        f444a = String.valueOf(Long.MIN_VALUE);
        f445b = new char[4000];
        f446c = new char[4000];
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            char c;
            char c2 = (char) (i2 + 48);
            if (i2 == 0) {
                c = '\u0000';
            } else {
                c = c2;
            }
            int i3 = 0;
            while (i3 < 10) {
                char c3;
                char c4 = (char) (i3 + 48);
                if (i2 == 0 && i3 == 0) {
                    c3 = '\u0000';
                } else {
                    c3 = c4;
                }
                int i4 = i;
                for (i = 0; i < 10; i++) {
                    char c5 = (char) (i + 48);
                    f445b[i4] = c;
                    f445b[i4 + 1] = c3;
                    f445b[i4 + 2] = c5;
                    f446c[i4] = c2;
                    f446c[i4 + 1] = c4;
                    f446c[i4 + 2] = c5;
                    i4 += 4;
                }
                i3++;
                i = i4;
            }
        }
        f447d = new byte[4000];
        for (int i5 = 0; i5 < 4000; i5++) {
            f447d[i5] = (byte) f446c[i5];
        }
        f448e = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        f449f = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int m592a(int i, char[] cArr, int i2) {
        if (i < 0) {
            if (i == RtlSpacingHelper.UNDEFINED) {
                return NumberOutput.m595a((long) i, cArr, i2);
            }
            int i3 = i2 + 1;
            cArr[i2] = '-';
            i = -i;
            i2 = i3;
        }
        if (i >= f450g) {
            Object obj = i >= f451h ? 1 : null;
            if (obj != null) {
                i -= f451h;
                if (i >= f451h) {
                    i -= f451h;
                    i3 = i2 + 1;
                    cArr[i2] = '2';
                    i2 = i3;
                } else {
                    i3 = i2 + 1;
                    cArr[i2] = '1';
                    i2 = i3;
                }
            }
            i3 = i / PointerIconCompat.TYPE_DEFAULT;
            int i4 = i - (i3 * PointerIconCompat.TYPE_DEFAULT);
            int i5 = i3 / PointerIconCompat.TYPE_DEFAULT;
            int i6 = i3 - (i5 * PointerIconCompat.TYPE_DEFAULT);
            if (obj != null) {
                i3 = NumberOutput.m599c(i5, cArr, i2);
            } else {
                i3 = NumberOutput.m597b(i5, cArr, i2);
            }
            return NumberOutput.m599c(i4, cArr, NumberOutput.m599c(i6, cArr, i3));
        } else if (i >= PointerIconCompat.TYPE_DEFAULT) {
            i3 = i / PointerIconCompat.TYPE_DEFAULT;
            return NumberOutput.m599c(i - (i3 * PointerIconCompat.TYPE_DEFAULT), cArr, NumberOutput.m597b(i3, cArr, i2));
        } else if (i >= 10) {
            return NumberOutput.m597b(i, cArr, i2);
        } else {
            i3 = i2 + 1;
            cArr[i2] = (char) (i + 48);
            return i3;
        }
    }

    public static int m591a(int i, byte[] bArr, int i2) {
        if (i < 0) {
            if (i == RtlSpacingHelper.UNDEFINED) {
                return NumberOutput.m594a((long) i, bArr, i2);
            }
            int i3 = i2 + 1;
            bArr[i2] = (byte) 45;
            i = -i;
            i2 = i3;
        }
        if (i >= f450g) {
            Object obj = i >= f451h ? 1 : null;
            if (obj != null) {
                i -= f451h;
                if (i >= f451h) {
                    i -= f451h;
                    i3 = i2 + 1;
                    bArr[i2] = (byte) 50;
                    i2 = i3;
                } else {
                    i3 = i2 + 1;
                    bArr[i2] = (byte) 49;
                    i2 = i3;
                }
            }
            i3 = i / PointerIconCompat.TYPE_DEFAULT;
            int i4 = i - (i3 * PointerIconCompat.TYPE_DEFAULT);
            int i5 = i3 / PointerIconCompat.TYPE_DEFAULT;
            int i6 = i3 - (i5 * PointerIconCompat.TYPE_DEFAULT);
            if (obj != null) {
                i3 = NumberOutput.m598c(i5, bArr, i2);
            } else {
                i3 = NumberOutput.m596b(i5, bArr, i2);
            }
            return NumberOutput.m598c(i4, bArr, NumberOutput.m598c(i6, bArr, i3));
        } else if (i >= PointerIconCompat.TYPE_DEFAULT) {
            i3 = i / PointerIconCompat.TYPE_DEFAULT;
            return NumberOutput.m598c(i - (i3 * PointerIconCompat.TYPE_DEFAULT), bArr, NumberOutput.m596b(i3, bArr, i2));
        } else if (i >= 10) {
            return NumberOutput.m596b(i, bArr, i2);
        } else {
            i3 = i2 + 1;
            bArr[i2] = (byte) (i + 48);
            return i3;
        }
    }

    public static int m595a(long j, char[] cArr, int i) {
        int length;
        if (j < 0) {
            if (j > f454k) {
                return NumberOutput.m592a((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                length = f444a.length();
                f444a.getChars(0, length, cArr, i);
                return i + length;
            }
            length = i + 1;
            cArr[i] = '-';
            j = -j;
            i = length;
        } else if (j <= f455l) {
            return NumberOutput.m592a((int) j, cArr, i);
        }
        int a = i + NumberOutput.m593a(j);
        length = a;
        while (j > f455l) {
            length -= 3;
            long j2 = j / f453j;
            NumberOutput.m599c((int) (j - (f453j * j2)), cArr, length);
            j = j2;
        }
        int i2 = length;
        length = (int) j;
        while (length >= PointerIconCompat.TYPE_DEFAULT) {
            int i3 = i2 - 3;
            i2 = length / PointerIconCompat.TYPE_DEFAULT;
            NumberOutput.m599c(length - (i2 * PointerIconCompat.TYPE_DEFAULT), cArr, i3);
            length = i2;
            i2 = i3;
        }
        NumberOutput.m597b(length, cArr, i);
        return a;
    }

    public static int m594a(long j, byte[] bArr, int i) {
        int length;
        int i2;
        int i3;
        if (j < 0) {
            if (j > f454k) {
                return NumberOutput.m591a((int) j, bArr, i);
            }
            if (j == Long.MIN_VALUE) {
                length = f444a.length();
                i2 = 0;
                i3 = i;
                while (i2 < length) {
                    i = i3 + 1;
                    bArr[i3] = (byte) f444a.charAt(i2);
                    i2++;
                    i3 = i;
                }
                return i3;
            }
            i2 = i + 1;
            bArr[i] = (byte) 45;
            j = -j;
            i = i2;
        } else if (j <= f455l) {
            return NumberOutput.m591a((int) j, bArr, i);
        }
        i3 = i + NumberOutput.m593a(j);
        i2 = i3;
        while (j > f455l) {
            i2 -= 3;
            long j2 = j / f453j;
            NumberOutput.m598c((int) (j - (f453j * j2)), bArr, i2);
            j = j2;
        }
        length = i2;
        i2 = (int) j;
        while (i2 >= PointerIconCompat.TYPE_DEFAULT) {
            int i4 = length - 3;
            length = i2 / PointerIconCompat.TYPE_DEFAULT;
            NumberOutput.m598c(i2 - (length * PointerIconCompat.TYPE_DEFAULT), bArr, i4);
            i2 = length;
            length = i4;
        }
        NumberOutput.m596b(i2, bArr, i);
        return i3;
    }

    private static int m597b(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = f445b[i3];
        if (c != '\u0000') {
            i3 = i2 + 1;
            cArr[i2] = c;
            i2 = i3;
        }
        int i5 = i4 + 1;
        char c2 = f445b[i4];
        if (c2 != '\u0000') {
            i3 = i2 + 1;
            cArr[i2] = c2;
            i2 = i3;
        }
        i3 = i2 + 1;
        cArr[i2] = f445b[i5];
        return i3;
    }

    private static int m596b(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = f445b[i3];
        if (c != '\u0000') {
            i3 = i2 + 1;
            bArr[i2] = (byte) c;
            i2 = i3;
        }
        int i5 = i4 + 1;
        char c2 = f445b[i4];
        if (c2 != '\u0000') {
            i3 = i2 + 1;
            bArr[i2] = (byte) c2;
            i2 = i3;
        }
        i3 = i2 + 1;
        bArr[i2] = (byte) f445b[i5];
        return i3;
    }

    private static int m599c(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        cArr[i2] = f446c[i3];
        i3 = i4 + 1;
        int i6 = i5 + 1;
        cArr[i4] = f446c[i5];
        i4 = i3 + 1;
        cArr[i3] = f446c[i6];
        return i4;
    }

    private static int m598c(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        bArr[i2] = f447d[i3];
        i3 = i4 + 1;
        int i6 = i5 + 1;
        bArr[i4] = f447d[i5];
        i4 = i3 + 1;
        bArr[i3] = f447d[i6];
        return i4;
    }

    private static int m593a(long j) {
        int i = 10;
        for (long j2 = f452i; j >= j2 && i != 19; j2 = (j2 << 1) + (j2 << 3)) {
            i++;
        }
        return i;
    }
}
