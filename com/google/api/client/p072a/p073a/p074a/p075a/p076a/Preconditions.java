package com.google.api.client.p072a.p073a.p074a.p075a.p076a;

/* renamed from: com.google.api.client.a.a.a.a.a.d */
public final class Preconditions {
    public static void m4754a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m4755a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m4756a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(Preconditions.m4753a(str, objArr));
        }
    }

    public static void m4758b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m4759b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(Preconditions.m4753a(str, objArr));
        }
    }

    public static <T> T m4750a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T m4751a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T m4752a(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Preconditions.m4753a(str, objArr));
    }

    public static int m4748a(int i, int i2) {
        return Preconditions.m4749a(i, i2, "index");
    }

    public static int m4749a(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(Preconditions.m4757b(i, i2, str));
    }

    private static String m4757b(int i, int i2, String str) {
        if (i < 0) {
            return Preconditions.m4753a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return Preconditions.m4753a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    static String m4753a(String str, Object... objArr) {
        int i = 0;
        String valueOf = String.valueOf(str);
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf.substring(i2, indexOf));
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf.substring(i2));
        if (i < objArr.length) {
            stringBuilder.append(" [");
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            i = i2;
            while (i < objArr.length) {
                stringBuilder.append(", ");
                i2 = i + 1;
                stringBuilder.append(objArr[i]);
                i = i2;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}
