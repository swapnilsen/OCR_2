package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.media.AudioManager;
import com.google.ads.mediation.facebook.FacebookAdapter;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.m.l */
public class C0700l {
    public static float m2266a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume > 0) {
                return (((float) streamVolume) * 1.0f) / ((float) streamMaxVolume);
            }
        }
        return 0.0f;
    }

    public static void m2267a(Map<String, String> map, boolean z, boolean z2) {
        map.put(FacebookAdapter.KEY_AUTOPLAY, z ? "1" : "0");
        map.put("inline", z2 ? "1" : "0");
    }
}
