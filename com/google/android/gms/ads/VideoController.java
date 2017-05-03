package com.google.android.gms.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqf;

@zzme
public final class VideoController {
    private final Object zzrJ;
    @Nullable
    private zzfa zzrK;
    @Nullable
    private VideoLifecycleCallbacks zzrL;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }
    }

    public VideoController() {
        this.zzrJ = new Object();
    }

    public float getAspectRatio() {
        float f = 0.0f;
        synchronized (this.zzrJ) {
            if (this.zzrK == null) {
            } else {
                try {
                    f = this.zzrK.getAspectRatio();
                } catch (Throwable e) {
                    zzqf.zzb("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return f;
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zzrJ) {
            videoLifecycleCallbacks = this.zzrL;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zzrJ) {
            z = this.zzrK != null;
        }
        return z;
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzac.zzb((Object) videoLifecycleCallbacks, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.zzrJ) {
            this.zzrL = videoLifecycleCallbacks;
            if (this.zzrK == null) {
                return;
            }
            try {
                this.zzrK.zza(new zzfs(videoLifecycleCallbacks));
            } catch (Throwable e) {
                zzqf.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void zza(zzfa com_google_android_gms_internal_zzfa) {
        synchronized (this.zzrJ) {
            this.zzrK = com_google_android_gms_internal_zzfa;
            if (this.zzrL != null) {
                setVideoLifecycleCallbacks(this.zzrL);
            }
        }
    }

    public zzfa zzbs() {
        zzfa com_google_android_gms_internal_zzfa;
        synchronized (this.zzrJ) {
            com_google_android_gms_internal_zzfa = this.zzrK;
        }
        return com_google_android_gms_internal_zzfa;
    }
}
