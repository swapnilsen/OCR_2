package com.google.p044a.p045a;

/* renamed from: com.google.a.a.c */
public final class Preconditions {
    public static void m2778a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m2780a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(Preconditions.m2776a(str, objArr));
        }
    }

    public static void m2779a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T m2774a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    private static String m2775a(int i, int i2, String str) {
        if (i < 0) {
            return Preconditions.m2776a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return Preconditions.m2776a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void m2777a(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(Preconditions.m2781b(i, i2, i3));
        }
    }

    private static String m2781b(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return Preconditions.m2775a(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return Preconditions.m2775a(i2, i3, "end index");
        }
        return Preconditions.m2776a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String m2776a(String str, Object... objArr) {
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
