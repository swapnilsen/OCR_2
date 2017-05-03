package com.google.android.exoplayer2.p062f;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p063i.Allocator;

/* renamed from: com.google.android.exoplayer2.f.d */
public interface MediaSource {

    /* renamed from: com.google.android.exoplayer2.f.d.a */
    public interface MediaSource {
        void m3934a(Timeline timeline, Object obj);
    }

    MediaPeriod m3929a(int i, Allocator allocator, long j);

    void m3930a();

    void m3931a(MediaPeriod mediaPeriod);

    void m3932a(MediaSource mediaSource);

    void m3933b();
}
