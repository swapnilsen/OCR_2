package com.google.android.exoplayer2.p049d;

/* renamed from: com.google.android.exoplayer2.d.c */
public interface MediaCodecSelector {
    public static final MediaCodecSelector f3286a;

    /* renamed from: com.google.android.exoplayer2.d.c.1 */
    static class MediaCodecSelector implements MediaCodecSelector {
        MediaCodecSelector() {
        }

        public MediaCodecInfo m3773a(String str, boolean z) {
            return MediaCodecUtil.m3791a(str, z);
        }

        public MediaCodecInfo m3772a() {
            return MediaCodecUtil.m3790a();
        }
    }

    MediaCodecInfo m3770a();

    MediaCodecInfo m3771a(String str, boolean z);

    static {
        f3286a = new MediaCodecSelector();
    }
}
