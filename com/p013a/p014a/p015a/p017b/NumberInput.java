package com.p013a.p014a.p015a.p017b;

/* renamed from: com.a.a.a.b.h */
public final class NumberInput {
    static final String f442a;
    static final String f443b;

    static {
        f442a = String.valueOf(Long.MIN_VALUE).substring(1);
        f443b = String.valueOf(Long.MAX_VALUE);
    }

    public static int m588a(char[] cArr, int i, int i2) {
        int i3 = cArr[i] - 48;
        int i4 = i2 + i;
        int i5 = i + 1;
        if (i5 >= i4) {
            return i3;
        }
        i3 = (i3 * 10) + (cArr[i5] - 48);
        i5++;
        if (i5 >= i4) {
            return i3;
        }
        i3 = (i3 * 10) + (cArr[i5] - 48);
        i5++;
        if (i5 >= i4) {
            return i3;
        }
        i3 = (i3 * 10) + (cArr[i5] - 48);
        i5++;
        if (i5 >= i4) {
            return i3;
        }
        i3 = (i3 * 10) + (cArr[i5] - 48);
        i5++;
        if (i5 >= i4) {
            return i3;
        }
        i3 = (i3 * 10) + (cArr[i5] - 48);
        i5++;
        if (i5 >= i4) {
            return i3;
        }
        i3 = (i3 * 10) + (cArr[i5] - 48);
        i5++;
        if (i5 >= i4) {
            return i3;
        }
        i3 = (i3 * 10) + (cArr[i5] - 48);
        i5++;
        if (i5 < i4) {
            return (i3 * 10) + (cArr[i5] - 48);
        }
        return i3;
    }

    public static long m590b(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return ((long) NumberInput.m588a(cArr, i3 + i, 9)) + (((long) NumberInput.m588a(cArr, i, i3)) * 1000000000);
    }

    public static boolean m589a(char[] cArr, int i, int i2, boolean z) {
        String str = z ? f442a : f443b;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int charAt = cArr[i + i3] - str.charAt(i3);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static double m587a(String str) {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }
}
