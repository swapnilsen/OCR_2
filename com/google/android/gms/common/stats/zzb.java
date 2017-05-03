package com.google.android.gms.common.stats;

import android.content.ComponentName;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class zzb {
    public static int LOG_LEVEL_OFF;
    public static int zzaHA;
    public static int zzaHB;
    public static int zzaHC;
    public static final ComponentName zzaHv;
    public static int zzaHw;
    public static int zzaHx;
    public static int zzaHy;
    public static int zzaHz;

    static {
        zzaHv = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.common.stats.GmsCoreStatsService");
        LOG_LEVEL_OFF = 0;
        zzaHw = 1;
        zzaHx = 2;
        zzaHy = 4;
        zzaHz = 8;
        zzaHA = 16;
        zzaHB = 32;
        zzaHC = 1;
    }
}
