package com.google.android.exoplayer2.p049d;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.MimeTypes;
import com.google.android.exoplayer2.p050j.Util;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.d.a */
public final class MediaCodecInfo {
    public final String f3278a;
    public final boolean f3279b;
    private final String f3280c;
    private final CodecCapabilities f3281d;

    public static MediaCodecInfo m3758a(String str) {
        return new MediaCodecInfo(str, null, null);
    }

    public static MediaCodecInfo m3759a(String str, String str2, CodecCapabilities codecCapabilities) {
        return new MediaCodecInfo(str, str2, codecCapabilities);
    }

    private MediaCodecInfo(String str, String str2, CodecCapabilities codecCapabilities) {
        this.f3278a = (String) Assertions.m4402a((Object) str);
        this.f3280c = str2;
        this.f3281d = codecCapabilities;
        boolean z = codecCapabilities != null && MediaCodecInfo.m3760a(codecCapabilities);
        this.f3279b = z;
    }

    public CodecProfileLevel[] m3765a() {
        return (this.f3281d == null || this.f3281d.profileLevels == null) ? new CodecProfileLevel[0] : this.f3281d.profileLevels;
    }

    public boolean m3767b(String str) {
        if (str == null || this.f3280c == null) {
            return true;
        }
        String d = MimeTypes.m4428d(str);
        if (d == null) {
            return true;
        }
        if (!this.f3280c.equals(d)) {
            return false;
        }
        Pair a = MediaCodecUtil.m3788a(str);
        if (a == null) {
            return true;
        }
        for (CodecProfileLevel codecProfileLevel : m3765a()) {
            if (codecProfileLevel.profile == ((Integer) a.first).intValue() && codecProfileLevel.level >= ((Integer) a.second).intValue()) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    public boolean m3763a(int i, int i2) {
        if (this.f3281d == null) {
            return false;
        }
        VideoCapabilities videoCapabilities = this.f3281d.getVideoCapabilities();
        if (videoCapabilities == null || !videoCapabilities.isSizeSupported(i, i2)) {
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean m3764a(int i, int i2, double d) {
        if (this.f3281d == null) {
            return false;
        }
        VideoCapabilities videoCapabilities = this.f3281d.getVideoCapabilities();
        if (videoCapabilities == null || !videoCapabilities.areSizeAndRateSupported(i, i2, d)) {
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean m3762a(int i) {
        if (this.f3281d == null) {
            return false;
        }
        AudioCapabilities audioCapabilities = this.f3281d.getAudioCapabilities();
        if (audioCapabilities == null || !audioCapabilities.isSampleRateSupported(i)) {
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean m3766b(int i) {
        if (this.f3281d == null) {
            return false;
        }
        AudioCapabilities audioCapabilities = this.f3281d.getAudioCapabilities();
        if (audioCapabilities == null || audioCapabilities.getMaxInputChannelCount() < i) {
            return false;
        }
        return true;
    }

    private static boolean m3760a(CodecCapabilities codecCapabilities) {
        return Util.f3855a >= 19 && MediaCodecInfo.m3761b(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean m3761b(CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }
}
