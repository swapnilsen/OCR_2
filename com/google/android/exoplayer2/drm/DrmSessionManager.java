package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.drm.b */
public interface DrmSessionManager<T extends ExoMediaCrypto> {
    DrmSession<T> m3811a(Looper looper, DrmInitData drmInitData);

    void m3812a(DrmSession<T> drmSession);
}
