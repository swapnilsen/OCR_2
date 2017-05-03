package com.google.android.exoplayer2.p048a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.p048a.AudioRendererEventListener.AudioRendererEventListener;
import com.google.android.exoplayer2.p049d.MediaCodecInfo;
import com.google.android.exoplayer2.p049d.MediaCodecRenderer;
import com.google.android.exoplayer2.p049d.MediaCodecSelector;
import com.google.android.exoplayer2.p050j.MediaClock;
import com.google.android.exoplayer2.p050j.MimeTypes;
import com.google.android.exoplayer2.p050j.Util;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.a.f */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private final AudioRendererEventListener f2476b;
    private final AudioTrack f2477c;
    private boolean f2478d;
    private MediaFormat f2479e;
    private int f2480f;
    private int f2481g;
    private long f2482h;
    private boolean f2483i;
    private boolean f2484j;
    private long f2485k;

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, int i) {
        super(1, mediaCodecSelector, drmSessionManager, z);
        this.f2481g = 0;
        this.f2477c = new AudioTrack(audioCapabilities, i);
        this.f2476b = new AudioRendererEventListener(handler, audioRendererEventListener);
    }

    protected int m3052a(MediaCodecSelector mediaCodecSelector, Format format) {
        boolean z = false;
        String str = format.f2324e;
        if (!MimeTypes.m4425a(str)) {
            return 0;
        }
        if (m3061a(str) && mediaCodecSelector.m3770a() != null) {
            return 7;
        }
        MediaCodecInfo a = mediaCodecSelector.m3771a(str, false);
        if (a == null) {
            return 1;
        }
        if (Util.f3855a < 21 || ((format.f2336q == -1 || a.m3762a(format.f2336q)) && (format.f2335p == -1 || a.m3766b(format.f2335p)))) {
            z = true;
        }
        return (z ? 3 : 2) | 4;
    }

    protected MediaCodecInfo m3053a(MediaCodecSelector mediaCodecSelector, Format format, boolean z) {
        if (m3061a(format.f2324e)) {
            MediaCodecInfo a = mediaCodecSelector.m3770a();
            if (a != null) {
                this.f2478d = true;
                return a;
            }
        }
        this.f2478d = false;
        return super.m3028a(mediaCodecSelector, format, z);
    }

    protected boolean m3061a(String str) {
        return this.f2477c.m2946a(str);
    }

    protected void m3057a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        if (this.f2478d) {
            this.f2479e = format.m2875b();
            this.f2479e.setString("mime", "audio/raw");
            mediaCodec.configure(this.f2479e, null, mediaCrypto, 0);
            this.f2479e.setString("mime", format.f2324e);
            return;
        }
        mediaCodec.configure(format.m2875b(), null, mediaCrypto, 0);
        this.f2479e = null;
    }

    public MediaClock m3064c() {
        return this;
    }

    protected void m3058a(String str, long j, long j2) {
        this.f2476b.m2894a(str, j, j2);
    }

    protected void m3063b(Format format) {
        super.m3038b(format);
        this.f2476b.m2892a(format);
        this.f2480f = "audio/raw".equals(format.f2324e) ? format.f2337r : 2;
    }

    protected void m3056a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i = this.f2479e != null ? 1 : 0;
        String string = i != 0 ? this.f2479e.getString("mime") : "audio/raw";
        if (i != 0) {
            mediaFormat = this.f2479e;
        }
        this.f2477c.m2944a(string, mediaFormat.getInteger("channel-count"), mediaFormat.getInteger("sample-rate"), this.f2480f, 0);
    }

    protected void m3062b(int i) {
    }

    protected void m3059a(boolean z) {
        super.m3035a(z);
        this.f2476b.m2893a(this.a);
    }

    protected void m3055a(long j, boolean z) {
        super.m3030a(j, z);
        this.f2477c.m2954i();
        this.f2482h = j;
        this.f2483i = true;
    }

    protected void m3065m() {
        super.m3041m();
        this.f2477c.m2949d();
    }

    protected void m3066n() {
        this.f2477c.m2953h();
        super.m3042n();
    }

    protected void m3067o() {
        this.f2481g = 0;
        try {
            this.f2477c.m2955j();
            try {
                super.m3043o();
            } finally {
                this.a.m3087a();
                this.f2476b.m2895b(this.a);
            }
        } catch (Throwable th) {
            super.m3043o();
        } finally {
            this.a.m3087a();
            this.f2476b.m2895b(this.a);
        }
    }

    public boolean m3069s() {
        return super.m3045s() && !this.f2477c.m2952g();
    }

    public boolean m3068r() {
        return this.f2477c.m2952g() || super.m3044r();
    }

    public long m3070t() {
        long a = this.f2477c.m2941a(m3069s());
        if (a != Long.MIN_VALUE) {
            if (!this.f2483i) {
                a = Math.max(this.f2482h, a);
            }
            this.f2482h = a;
            this.f2483i = false;
        }
        return this.f2482h;
    }

    protected boolean m3060a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.f2478d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            r2 = this.a;
            r2.f2498e++;
            this.f2477c.m2950e();
            return true;
        } else {
            if (this.f2477c.m2945a()) {
                boolean z2 = this.f2484j;
                this.f2484j = this.f2477c.m2952g();
                if (z2 && !this.f2484j && m2995d() == 2) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f2485k;
                    this.f2476b.m2891a(this.f2477c.m2947b(), C.m3114a(this.f2477c.m2948c()), elapsedRealtime);
                }
            } else {
                try {
                    if (this.f2481g == 0) {
                        this.f2481g = this.f2477c.m2939a(0);
                        this.f2476b.m2890a(this.f2481g);
                        m3062b(this.f2481g);
                    } else {
                        this.f2477c.m2939a(this.f2481g);
                    }
                    this.f2484j = false;
                    if (m2995d() == 2) {
                        this.f2477c.m2949d();
                    }
                } catch (Exception e) {
                    throw ExoPlaybackException.m3798a(e, m3007p());
                }
            }
            try {
                int a = this.f2477c.m2940a(byteBuffer, j3);
                this.f2485k = SystemClock.elapsedRealtime();
                if ((a & 1) != 0) {
                    m3072v();
                    this.f2483i = true;
                }
                if ((a & 2) == 0) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                r2 = this.a;
                r2.f2497d++;
                return true;
            } catch (Exception e2) {
                throw ExoPlaybackException.m3798a(e2, m3007p());
            }
        }
    }

    protected void m3071u() {
        this.f2477c.m2951f();
    }

    protected void m3072v() {
    }

    public void m3054a(int i, Object obj) {
        switch (i) {
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                this.f2477c.m2942a(((Float) obj).floatValue());
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                this.f2477c.m2943a((PlaybackParams) obj);
            default:
                super.m2985a(i, obj);
        }
    }
}
