package com.google.android.exoplayer2.p048a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
/* renamed from: com.google.android.exoplayer2.a.b */
public final class AudioCapabilities {
    public static final AudioCapabilities f2351a;
    private final int[] f2352b;
    private final int f2353c;

    static {
        f2351a = new AudioCapabilities(new int[]{2}, 2);
    }

    public static AudioCapabilities m2886a(Context context) {
        return AudioCapabilities.m2887a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static AudioCapabilities m2887a(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return f2351a;
        }
        return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    AudioCapabilities(int[] iArr, int i) {
        if (iArr != null) {
            this.f2352b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f2352b);
        } else {
            this.f2352b = new int[0];
        }
        this.f2353c = i;
    }

    public boolean m2888a(int i) {
        return Arrays.binarySearch(this.f2352b, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (Arrays.equals(this.f2352b, audioCapabilities.f2352b) && this.f2353c == audioCapabilities.f2353c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f2353c + (Arrays.hashCode(this.f2352b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f2353c + ", supportedEncodings=" + Arrays.toString(this.f2352b) + "]";
    }
}
