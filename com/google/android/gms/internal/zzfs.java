package com.google.android.gms.internal;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import com.google.android.gms.internal.zzfb.zza;

public final class zzfs extends zza {
    private final VideoLifecycleCallbacks zzrL;

    public zzfs(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzrL = videoLifecycleCallbacks;
    }

    public void onVideoEnd() {
        this.zzrL.onVideoEnd();
    }

    public void zzeY() {
    }

    public void zzeZ() {
    }

    public void zzfa() {
    }
}
