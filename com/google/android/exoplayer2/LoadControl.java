package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p062f.TrackGroupArray;
import com.google.android.exoplayer2.p063i.Allocator;
import com.google.android.exoplayer2.p070h.TrackSelections;

/* renamed from: com.google.android.exoplayer2.j */
public interface LoadControl {
    void m3742a();

    void m3743a(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelections<?> trackSelections);

    boolean m3744a(long j);

    boolean m3745a(long j, boolean z);

    void m3746b();

    void m3747c();

    Allocator m3748d();
}
