package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzaqa.zzd;
import java.util.ArrayList;
import java.util.Collection;

public class zzaqb {
    private final Collection<zzaqa> zzAZ;
    private final Collection<zzd> zzBa;
    private final Collection<zzd> zzBb;

    public zzaqb() {
        this.zzAZ = new ArrayList();
        this.zzBa = new ArrayList();
        this.zzBb = new ArrayList();
    }

    public static void initialize(Context context) {
        zzaqe.zzDF().initialize(context);
    }

    public void zza(zzaqa com_google_android_gms_internal_zzaqa) {
        this.zzAZ.add(com_google_android_gms_internal_zzaqa);
    }
}
