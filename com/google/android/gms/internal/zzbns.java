package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.concurrent.TimeUnit;

public final class zzbns {
    public static final zzaqa<Integer> zzbZA;
    public static final zzaqa<Integer> zzbZB;
    public static final zzaqa<Integer> zzbZC;
    public static final zzaqa<Boolean> zzbZp;
    public static final zzaqa<String> zzbZq;
    public static final zzaqa<Integer> zzbZr;
    public static final zzaqa<Integer> zzbZs;
    public static final zzaqa<Integer> zzbZt;
    public static final zzaqa<Long> zzbZu;
    public static final zzaqa<Long> zzbZv;
    public static final zzaqa<Long> zzbZw;
    public static final zzaqa<Integer> zzbZx;
    public static final zzaqa<Integer> zzbZy;
    public static final zzaqa<Long> zzbZz;

    static {
        zzbZp = zzaqa.zzb(0, "crash:enabled", Boolean.valueOf(true));
        zzbZq = zzaqa.zzc(0, "crash:gateway_url", "https://mobilecrashreporting.googleapis.com/v1/crashes:batchCreate?key=");
        zzbZr = zzaqa.zzb(0, "crash:log_buffer_capacity", 100);
        zzbZs = zzaqa.zzb(0, "crash:log_buffer_max_total_size", (int) AccessibilityNodeInfoCompat.ACTION_PASTE);
        zzbZt = zzaqa.zzb(0, "crash:crash_backlog_capacity", 5);
        zzbZu = zzaqa.zzb(0, "crash:crash_backlog_max_age", 604800000);
        zzbZv = zzaqa.zzb(0, "crash:starting_backoff", TimeUnit.SECONDS.toMillis(1));
        zzbZw = zzaqa.zzb(0, "crash:backoff_limit", TimeUnit.MINUTES.toMillis(60));
        zzbZx = zzaqa.zzb(0, "crash:retry_num_attempts", 12);
        zzbZy = zzaqa.zzb(0, "crash:batch_size", 5);
        zzbZz = zzaqa.zzb(0, "crash:batch_throttle", TimeUnit.MINUTES.toMillis(5));
        zzbZA = zzaqa.zzb(0, "crash:frame_depth", 60);
        zzbZB = zzaqa.zzb(0, "crash:receiver_delay", 100);
        zzbZC = zzaqa.zzb(0, "crash:thread_idle_timeout", 10);
    }

    public static final void initialize(Context context) {
        zzaqe.zzDE();
        zzaqb.initialize(context);
    }
}
