package com.google.android.exoplayer2.p070h;

import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.h.g */
public final class TrackSelections<T> {
    public final T f3657a;
    public final int f3658b;
    private final TrackSelection[] f3659c;
    private int f3660d;

    public TrackSelections(T t, TrackSelection... trackSelectionArr) {
        this.f3657a = t;
        this.f3659c = trackSelectionArr;
        this.f3658b = trackSelectionArr.length;
    }

    public TrackSelection m4280a(int i) {
        return this.f3659c[i];
    }

    public TrackSelection[] m4281a() {
        return (TrackSelection[]) this.f3659c.clone();
    }

    public int hashCode() {
        if (this.f3660d == 0) {
            this.f3660d = Arrays.hashCode(this.f3659c) + 527;
        }
        return this.f3660d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f3659c, ((TrackSelections) obj).f3659c);
    }
}
