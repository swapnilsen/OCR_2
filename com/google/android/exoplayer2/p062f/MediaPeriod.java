package com.google.android.exoplayer2.p062f;

import com.google.android.exoplayer2.p062f.SequenceableLoader.SequenceableLoader;
import com.google.android.exoplayer2.p070h.TrackSelection;

/* renamed from: com.google.android.exoplayer2.f.c */
public interface MediaPeriod extends SequenceableLoader {

    /* renamed from: com.google.android.exoplayer2.f.c.a */
    public interface MediaPeriod extends SequenceableLoader<MediaPeriod> {
        void m3942a(MediaPeriod mediaPeriod);
    }

    long m3879a(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    void m3880a(MediaPeriod mediaPeriod);

    long m3881b(long j);

    void m3882c();

    TrackGroupArray m3883d();

    long m3884f();

    long m3885g();
}
