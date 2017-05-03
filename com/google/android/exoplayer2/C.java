package com.google.android.exoplayer2;

import android.support.v4.view.PointerIconCompat;
import com.google.android.exoplayer2.p050j.Util;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.b */
public final class C {
    public static final int f2521a;
    public static final UUID f2522b;
    public static final UUID f2523c;
    public static final UUID f2524d;

    static {
        int i;
        if (Util.f3855a < 23) {
            i = PointerIconCompat.TYPE_GRAB;
        } else {
            i = 6396;
        }
        f2521a = i;
        f2522b = new UUID(0, 0);
        f2523c = new UUID(-1301668207276963122L, -6645017420763422227L);
        f2524d = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long m3114a(long j) {
        return j == -9223372036854775807L ? -9223372036854775807L : j / 1000;
    }

    public static long m3115b(long j) {
        return j == -9223372036854775807L ? -9223372036854775807L : 1000 * j;
    }
}
