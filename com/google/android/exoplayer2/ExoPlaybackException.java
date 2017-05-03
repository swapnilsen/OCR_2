package com.google.android.exoplayer2;

import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.d */
public final class ExoPlaybackException extends Exception {
    public final int f3298a;
    public final int f3299b;

    public static ExoPlaybackException m3798a(Exception exception, int i) {
        return new ExoPlaybackException(1, null, exception, i);
    }

    public static ExoPlaybackException m3797a(IOException iOException) {
        return new ExoPlaybackException(0, null, iOException, -1);
    }

    static ExoPlaybackException m3799a(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, null, runtimeException, -1);
    }

    private ExoPlaybackException(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.f3298a = i;
        this.f3299b = i2;
    }
}
