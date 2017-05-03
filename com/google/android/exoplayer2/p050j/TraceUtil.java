package com.google.android.exoplayer2.p050j;

import android.annotation.TargetApi;
import android.os.Trace;

/* renamed from: com.google.android.exoplayer2.j.q */
public final class TraceUtil {
    public static void m4503a(String str) {
        if (Util.f3855a >= 18) {
            TraceUtil.m4505b(str);
        }
    }

    public static void m4502a() {
        if (Util.f3855a >= 18) {
            TraceUtil.m4504b();
        }
    }

    @TargetApi(18)
    private static void m4505b(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void m4504b() {
        Trace.endSection();
    }
}
