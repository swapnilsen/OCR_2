package com.google.api.client.p082b.p083a;

/* renamed from: com.google.api.client.b.a.e */
public abstract class UnicodeEscaper extends Escaper {
    protected abstract int m4818a(CharSequence charSequence, int i, int i2);

    protected abstract char[] m4820a(int i);

    protected final String m4819a(String str, int i) {
        int b;
        int length = str.length();
        char[] a = Platform.m4826a();
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            b = UnicodeEscaper.m4817b(str, i, length);
            if (b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            int i4;
            Object a2 = m4820a(b);
            b = (Character.isSupplementaryCodePoint(b) ? 2 : 1) + i;
            if (a2 != null) {
                int i5 = i - i2;
                int length2 = (i3 + i5) + a2.length;
                if (a.length < length2) {
                    a = UnicodeEscaper.m4816a(a, i3, ((length2 + length) - i) + 32);
                }
                if (i5 > 0) {
                    str.getChars(i2, i, a, i3);
                    i3 += i5;
                }
                if (a2.length > 0) {
                    System.arraycopy(a2, 0, a, i3, a2.length);
                    i3 += a2.length;
                }
                i2 = i3;
                i3 = b;
            } else {
                i4 = i2;
                i2 = i3;
                i3 = i4;
            }
            i = m4818a((CharSequence) str, b, length);
            i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        b = length - i2;
        if (b > 0) {
            b += i3;
            if (a.length < b) {
                a = UnicodeEscaper.m4816a(a, i3, b);
            }
            str.getChars(i2, length, a, i3);
            i3 = b;
        }
        return new String(a, 0, i3);
    }

    protected static int m4817b(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            int charAt = charSequence.charAt(i);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + charAt + "' with value " + charAt + " at index " + (i3 - 1));
            } else if (i3 == i2) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i3);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + charAt2 + " at index " + i3);
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] m4816a(char[] cArr, int i, int i2) {
        Object obj = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, obj, 0, i);
        }
        return obj;
    }
}
