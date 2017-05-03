package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer.ExoPlayer;
import com.google.android.exoplayer2.p050j.MediaClock;
import com.google.android.exoplayer2.p062f.SampleStream;

/* renamed from: com.google.android.exoplayer2.m */
public interface Renderer extends ExoPlayer {
    int m2961a();

    void m2962a(int i);

    void m2963a(long j);

    void m2964a(long j, long j2);

    void m2965a(Format[] formatArr, SampleStream sampleStream, long j);

    void m2966a(Format[] formatArr, SampleStream sampleStream, long j, boolean z, long j2);

    RendererCapabilities m2967b();

    MediaClock m2968c();

    int m2969d();

    void m2970e();

    SampleStream m2971f();

    boolean m2972g();

    void m2973h();

    void m2974i();

    void m2975j();

    void m2976k();

    boolean m2977r();

    boolean m2978s();
}
