package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p062f.MediaSource;

/* renamed from: com.google.android.exoplayer2.e */
public interface ExoPlayer {

    /* renamed from: com.google.android.exoplayer2.e.a */
    public interface ExoPlayer {
        void m2470a(ExoPlaybackException exoPlaybackException);

        void m2471a(Timeline timeline, Object obj);

        void m2472a(boolean z, int i);

        void m2473b(boolean z);

        void m2474e();
    }

    /* renamed from: com.google.android.exoplayer2.e.b */
    public interface ExoPlayer {
        void m2960a(int i, Object obj);
    }

    /* renamed from: com.google.android.exoplayer2.e.c */
    public static final class ExoPlayer {
        public final ExoPlayer f3309a;
        public final int f3310b;
        public final Object f3311c;

        public ExoPlayer(ExoPlayer exoPlayer, int i, Object obj) {
            this.f3309a = exoPlayer;
            this.f3310b = i;
            this.f3311c = obj;
        }
    }

    int m3839a();

    void m3840a(int i);

    void m3841a(long j);

    void m3842a(ExoPlayer exoPlayer);

    void m3843a(MediaSource mediaSource);

    void m3844a(boolean z);

    void m3845a(ExoPlayer... exoPlayerArr);

    void m3846b(ExoPlayer exoPlayer);

    void m3847b(ExoPlayer... exoPlayerArr);

    boolean m3848b();

    void m3849c();

    void m3850d();

    void m3851e();

    Timeline m3852f();

    int m3853g();

    long m3854h();

    long m3855i();

    long m3856j();

    int m3857k();
}
