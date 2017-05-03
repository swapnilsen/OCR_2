package com.google.p044a.p045a;

/* renamed from: com.google.a.a.a */
public final class Ascii {
    public static char m2750a(char c) {
        return Ascii.m2752c(c) ? (char) (c ^ 32) : c;
    }

    public static boolean m2751b(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean m2752c(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
