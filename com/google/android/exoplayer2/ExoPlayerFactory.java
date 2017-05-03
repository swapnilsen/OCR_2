package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.p070h.TrackSelector;

/* renamed from: com.google.android.exoplayer2.f */
public final class ExoPlayerFactory {
    public static SimpleExoPlayer m3959a(Context context, TrackSelector<?> trackSelector, LoadControl loadControl) {
        return ExoPlayerFactory.m3960a(context, trackSelector, loadControl, null);
    }

    public static SimpleExoPlayer m3960a(Context context, TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        return ExoPlayerFactory.m3961a(context, trackSelector, loadControl, drmSessionManager, false);
    }

    public static SimpleExoPlayer m3961a(Context context, TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z) {
        return ExoPlayerFactory.m3962a(context, trackSelector, loadControl, drmSessionManager, z, 5000);
    }

    public static SimpleExoPlayer m3962a(Context context, TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, long j) {
        return new SimpleExoPlayer(context, trackSelector, loadControl, drmSessionManager, z, j);
    }
}
