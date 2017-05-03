package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.drm.a */
public interface DrmSession<T extends ExoMediaCrypto> {
    int m3807a();

    boolean m3808a(String str);

    T m3809b();

    Exception m3810c();
}
