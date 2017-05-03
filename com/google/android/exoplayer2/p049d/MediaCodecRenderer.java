package com.google.android.exoplayer2.p049d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.p049d.MediaCodecUtil.MediaCodecUtil;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.TraceUtil;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p051b.DecoderCounters;
import com.google.android.exoplayer2.p051b.DecoderInputBuffer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.d.b */
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] f2440b;
    private int f2441A;
    private boolean f2442B;
    private boolean f2443C;
    private int f2444D;
    private int f2445E;
    private boolean f2446F;
    private boolean f2447G;
    private boolean f2448H;
    private boolean f2449I;
    private boolean f2450J;
    protected DecoderCounters f2451a;
    private final MediaCodecSelector f2452c;
    private final DrmSessionManager<FrameworkMediaCrypto> f2453d;
    private final boolean f2454e;
    private final DecoderInputBuffer f2455f;
    private final FormatHolder f2456g;
    private final List<Long> f2457h;
    private final BufferInfo f2458i;
    private Format f2459j;
    private MediaCodec f2460k;
    private DrmSession<FrameworkMediaCrypto> f2461l;
    private DrmSession<FrameworkMediaCrypto> f2462m;
    private boolean f2463n;
    private boolean f2464o;
    private boolean f2465p;
    private boolean f2466q;
    private boolean f2467r;
    private boolean f2468s;
    private boolean f2469t;
    private boolean f2470u;
    private boolean f2471v;
    private ByteBuffer[] f2472w;
    private ByteBuffer[] f2473x;
    private long f2474y;
    private int f2475z;

    /* renamed from: com.google.android.exoplayer2.d.b.a */
    public static class MediaCodecRenderer extends Exception {
        public final String f3282a;
        public final boolean f3283b;
        public final String f3284c;
        public final String f3285d;

        public MediaCodecRenderer(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.f3282a = format.f2324e;
            this.f3283b = z;
            this.f3284c = null;
            this.f3285d = MediaCodecRenderer.m3768a(i);
        }

        public MediaCodecRenderer(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.f3282a = format.f2324e;
            this.f3283b = z;
            this.f3284c = str;
            this.f3285d = Util.f3855a >= 21 ? MediaCodecRenderer.m3769a(th) : null;
        }

        @TargetApi(21)
        private static String m3769a(Throwable th) {
            if (th instanceof CodecException) {
                return ((CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String m3768a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING) + Math.abs(i);
        }
    }

    protected abstract int m3027a(MediaCodecSelector mediaCodecSelector, Format format);

    protected abstract void m3032a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    protected abstract boolean m3036a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    static {
        f2440b = Util.m4525f("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z) {
        super(i);
        Assertions.m4406b(Util.f3855a >= 16);
        this.f2452c = (MediaCodecSelector) Assertions.m4402a((Object) mediaCodecSelector);
        this.f2453d = drmSessionManager;
        this.f2454e = z;
        this.f2455f = new DecoderInputBuffer(0);
        this.f2456g = new FormatHolder();
        this.f2457h = new ArrayList();
        this.f2458i = new BufferInfo();
        this.f2444D = 0;
        this.f2445E = 0;
    }

    public final int m3040l() {
        return 4;
    }

    public final int m3026a(Format format) {
        try {
            return m3027a(this.f2452c, format);
        } catch (Exception e) {
            throw ExoPlaybackException.m3798a(e, m3007p());
        }
    }

    protected MediaCodecInfo m3028a(MediaCodecSelector mediaCodecSelector, Format format, boolean z) {
        return mediaCodecSelector.m3771a(format.f2324e, z);
    }

    protected final void m3047w() {
        MediaCrypto mediaCrypto;
        MediaCodecInfo mediaCodecInfo;
        Throwable th;
        String str;
        long elapsedRealtime;
        long elapsedRealtime2;
        DecoderCounters decoderCounters;
        if (m3048x()) {
            boolean a;
            this.f2461l = this.f2462m;
            String str2 = this.f2459j.f2324e;
            if (this.f2461l != null) {
                int a2 = this.f2461l.m3807a();
                if (a2 == 0) {
                    throw ExoPlaybackException.m3798a(this.f2461l.m3810c(), m3007p());
                } else if (a2 == 3 || a2 == 4) {
                    MediaCrypto a3 = ((FrameworkMediaCrypto) this.f2461l.m3809b()).m3813a();
                    a = this.f2461l.m3808a(str2);
                    mediaCrypto = a3;
                } else {
                    return;
                }
            }
            a = false;
            mediaCrypto = null;
            try {
                MediaCodecInfo a4 = m3028a(this.f2452c, this.f2459j, a);
                if (a4 == null && a) {
                    try {
                        a4 = m3028a(this.f2452c, this.f2459j, false);
                        if (a4 != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str2 + ", but no secure decoder available. Trying to proceed with " + a4.f3278a + ".");
                        }
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        mediaCodecInfo = a4;
                        th = th2;
                        m3013a(new MediaCodecRenderer(this.f2459j, th, a, -49998));
                        if (mediaCodecInfo == null) {
                            m3013a(new MediaCodecRenderer(this.f2459j, null, a, -49999));
                        }
                        str = mediaCodecInfo.f3278a;
                        this.f2463n = mediaCodecInfo.f3279b;
                        this.f2464o = MediaCodecRenderer.m3015a(str, this.f2459j);
                        this.f2465p = MediaCodecRenderer.m3014a(str);
                        this.f2466q = MediaCodecRenderer.m3017b(str);
                        this.f2467r = MediaCodecRenderer.m3020c(str);
                        this.f2468s = MediaCodecRenderer.m3022d(str);
                        this.f2469t = MediaCodecRenderer.m3018b(str, this.f2459j);
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        TraceUtil.m4503a("createCodec:" + str);
                        this.f2460k = MediaCodec.createByCodecName(str);
                        TraceUtil.m4502a();
                        TraceUtil.m4503a("configureCodec");
                        m3032a(this.f2460k, this.f2459j, mediaCrypto);
                        TraceUtil.m4502a();
                        TraceUtil.m4503a("startCodec");
                        this.f2460k.start();
                        TraceUtil.m4502a();
                        elapsedRealtime2 = SystemClock.elapsedRealtime();
                        m3034a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.f2472w = this.f2460k.getInputBuffers();
                        this.f2473x = this.f2460k.getOutputBuffers();
                        this.f2474y = m2995d() == 2 ? -9223372036854775807L : SystemClock.elapsedRealtime() + 1000;
                        this.f2475z = -1;
                        this.f2441A = -1;
                        decoderCounters = this.f2451a;
                        decoderCounters.f2494a++;
                    }
                }
                mediaCodecInfo = a4;
            } catch (MediaCodecUtil e2) {
                th = e2;
                mediaCodecInfo = null;
                m3013a(new MediaCodecRenderer(this.f2459j, th, a, -49998));
                if (mediaCodecInfo == null) {
                    m3013a(new MediaCodecRenderer(this.f2459j, null, a, -49999));
                }
                str = mediaCodecInfo.f3278a;
                this.f2463n = mediaCodecInfo.f3279b;
                this.f2464o = MediaCodecRenderer.m3015a(str, this.f2459j);
                this.f2465p = MediaCodecRenderer.m3014a(str);
                this.f2466q = MediaCodecRenderer.m3017b(str);
                this.f2467r = MediaCodecRenderer.m3020c(str);
                this.f2468s = MediaCodecRenderer.m3022d(str);
                this.f2469t = MediaCodecRenderer.m3018b(str, this.f2459j);
                elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.m4503a("createCodec:" + str);
                this.f2460k = MediaCodec.createByCodecName(str);
                TraceUtil.m4502a();
                TraceUtil.m4503a("configureCodec");
                m3032a(this.f2460k, this.f2459j, mediaCrypto);
                TraceUtil.m4502a();
                TraceUtil.m4503a("startCodec");
                this.f2460k.start();
                TraceUtil.m4502a();
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                m3034a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f2472w = this.f2460k.getInputBuffers();
                this.f2473x = this.f2460k.getOutputBuffers();
                if (m2995d() == 2) {
                }
                this.f2474y = m2995d() == 2 ? -9223372036854775807L : SystemClock.elapsedRealtime() + 1000;
                this.f2475z = -1;
                this.f2441A = -1;
                decoderCounters = this.f2451a;
                decoderCounters.f2494a++;
            }
            if (mediaCodecInfo == null) {
                m3013a(new MediaCodecRenderer(this.f2459j, null, a, -49999));
            }
            str = mediaCodecInfo.f3278a;
            this.f2463n = mediaCodecInfo.f3279b;
            this.f2464o = MediaCodecRenderer.m3015a(str, this.f2459j);
            this.f2465p = MediaCodecRenderer.m3014a(str);
            this.f2466q = MediaCodecRenderer.m3017b(str);
            this.f2467r = MediaCodecRenderer.m3020c(str);
            this.f2468s = MediaCodecRenderer.m3022d(str);
            this.f2469t = MediaCodecRenderer.m3018b(str, this.f2459j);
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.m4503a("createCodec:" + str);
                this.f2460k = MediaCodec.createByCodecName(str);
                TraceUtil.m4502a();
                TraceUtil.m4503a("configureCodec");
                m3032a(this.f2460k, this.f2459j, mediaCrypto);
                TraceUtil.m4502a();
                TraceUtil.m4503a("startCodec");
                this.f2460k.start();
                TraceUtil.m4502a();
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                m3034a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f2472w = this.f2460k.getInputBuffers();
                this.f2473x = this.f2460k.getOutputBuffers();
            } catch (Throwable e3) {
                m3013a(new MediaCodecRenderer(this.f2459j, e3, a, str));
            }
            if (m2995d() == 2) {
            }
            this.f2474y = m2995d() == 2 ? -9223372036854775807L : SystemClock.elapsedRealtime() + 1000;
            this.f2475z = -1;
            this.f2441A = -1;
            decoderCounters = this.f2451a;
            decoderCounters.f2494a++;
        }
    }

    private void m3013a(MediaCodecRenderer mediaCodecRenderer) {
        throw ExoPlaybackException.m3798a(mediaCodecRenderer, m3007p());
    }

    protected boolean m3048x() {
        return this.f2460k == null && this.f2459j != null;
    }

    protected void m3035a(boolean z) {
        this.f2451a = new DecoderCounters();
    }

    protected void m3030a(long j, boolean z) {
        this.f2448H = false;
        this.f2449I = false;
        if (this.f2460k != null) {
            m3050z();
        }
    }

    protected void m3043o() {
        this.f2459j = null;
        try {
            m3049y();
            try {
                if (this.f2461l != null) {
                    this.f2453d.m3812a(this.f2461l);
                }
                try {
                    if (!(this.f2462m == null || this.f2462m == this.f2461l)) {
                        this.f2453d.m3812a(this.f2462m);
                    }
                    this.f2461l = null;
                    this.f2462m = null;
                } catch (Throwable th) {
                    this.f2461l = null;
                    this.f2462m = null;
                }
            } catch (Throwable th2) {
                this.f2461l = null;
                this.f2462m = null;
            }
        } catch (Throwable th3) {
            this.f2461l = null;
            this.f2462m = null;
        }
    }

    protected void m3049y() {
        if (this.f2460k != null) {
            this.f2474y = -9223372036854775807L;
            this.f2475z = -1;
            this.f2441A = -1;
            this.f2450J = false;
            this.f2442B = false;
            this.f2457h.clear();
            this.f2472w = null;
            this.f2473x = null;
            this.f2443C = false;
            this.f2446F = false;
            this.f2463n = false;
            this.f2464o = false;
            this.f2465p = false;
            this.f2466q = false;
            this.f2467r = false;
            this.f2468s = false;
            this.f2469t = false;
            this.f2470u = false;
            this.f2471v = false;
            this.f2447G = false;
            this.f2444D = 0;
            this.f2445E = 0;
            DecoderCounters decoderCounters = this.f2451a;
            decoderCounters.f2495b++;
            try {
                this.f2460k.stop();
                try {
                    this.f2460k.release();
                    this.f2460k = null;
                    if (this.f2461l != null && this.f2462m != this.f2461l) {
                        try {
                            this.f2453d.m3812a(this.f2461l);
                        } finally {
                            this.f2461l = null;
                        }
                    }
                } catch (Throwable th) {
                    this.f2460k = null;
                    if (!(this.f2461l == null || this.f2462m == this.f2461l)) {
                        this.f2453d.m3812a(this.f2461l);
                    }
                } finally {
                    this.f2461l = null;
                }
            } catch (Throwable th2) {
                this.f2460k = null;
                if (!(this.f2461l == null || this.f2462m == this.f2461l)) {
                    try {
                        this.f2453d.m3812a(this.f2461l);
                    } finally {
                        this.f2461l = null;
                    }
                }
            } finally {
                this.f2461l = null;
            }
        }
    }

    protected void m3041m() {
    }

    protected void m3042n() {
    }

    public void m3029a(long j, long j2) {
        if (this.f2459j == null) {
            m3023t();
        }
        m3047w();
        if (this.f2460k != null) {
            TraceUtil.m4503a("drainAndFeed");
            do {
            } while (m3016b(j, j2));
            do {
            } while (m3024v());
            TraceUtil.m4502a();
        } else if (this.f2459j != null) {
            m2993b(j);
        }
        this.f2451a.m3087a();
    }

    private void m3023t() {
        if (m2983a(this.f2456g, null) == -5) {
            m3038b(this.f2456g.f3791a);
        }
    }

    protected void m3050z() {
        this.f2474y = -9223372036854775807L;
        this.f2475z = -1;
        this.f2441A = -1;
        this.f2450J = false;
        this.f2442B = false;
        this.f2457h.clear();
        this.f2470u = false;
        this.f2471v = false;
        if (this.f2465p || (this.f2468s && this.f2447G)) {
            m3049y();
            m3047w();
        } else if (this.f2445E != 0) {
            m3049y();
            m3047w();
        } else {
            this.f2460k.flush();
            this.f2446F = false;
        }
        if (this.f2443C && this.f2459j != null) {
            this.f2444D = 1;
        }
    }

    private boolean m3024v() {
        if (this.f2448H || this.f2445E == 2) {
            return false;
        }
        if (this.f2475z < 0) {
            this.f2475z = this.f2460k.dequeueInputBuffer(0);
            if (this.f2475z < 0) {
                return false;
            }
            this.f2455f.f2502b = this.f2472w[this.f2475z];
            this.f2455f.m3089a();
        }
        if (this.f2445E == 1) {
            if (!this.f2467r) {
                this.f2447G = true;
                this.f2460k.queueInputBuffer(this.f2475z, 0, 0, 0, 4);
                this.f2475z = -1;
            }
            this.f2445E = 2;
            return false;
        } else if (this.f2470u) {
            this.f2470u = false;
            this.f2455f.f2502b.put(f2440b);
            this.f2460k.queueInputBuffer(this.f2475z, 0, f2440b.length, 0, 0);
            this.f2475z = -1;
            this.f2446F = true;
            return true;
        } else {
            int i;
            int i2;
            if (this.f2450J) {
                i = -4;
                i2 = 0;
            } else {
                if (this.f2444D == 1) {
                    for (i = 0; i < this.f2459j.f2326g.size(); i++) {
                        this.f2455f.f2502b.put((byte[]) this.f2459j.f2326g.get(i));
                    }
                    this.f2444D = 2;
                }
                i2 = this.f2455f.f2502b.position();
                i = m2983a(this.f2456g, this.f2455f);
            }
            if (i == -3) {
                return false;
            }
            if (i == -5) {
                if (this.f2444D == 2) {
                    this.f2455f.m3089a();
                    this.f2444D = 1;
                }
                m3038b(this.f2456g.f3791a);
                return true;
            } else if (this.f2455f.m3076c()) {
                if (this.f2444D == 2) {
                    this.f2455f.m3089a();
                    this.f2444D = 1;
                }
                this.f2448H = true;
                if (this.f2446F) {
                    try {
                        if (this.f2467r) {
                            return false;
                        }
                        this.f2447G = true;
                        this.f2460k.queueInputBuffer(this.f2475z, 0, 0, 0, 4);
                        this.f2475z = -1;
                        return false;
                    } catch (Exception e) {
                        throw ExoPlaybackException.m3798a(e, m3007p());
                    }
                }
                m3011D();
                return false;
            } else {
                boolean d = this.f2455f.m3090d();
                this.f2450J = m3019b(d);
                if (this.f2450J) {
                    return false;
                }
                if (this.f2464o && !d) {
                    NalUnitUtil.m4434a(this.f2455f.f2502b);
                    if (this.f2455f.f2502b.position() == 0) {
                        return true;
                    }
                    this.f2464o = false;
                }
                try {
                    long j = this.f2455f.f2503c;
                    if (this.f2455f.b_()) {
                        this.f2457h.add(Long.valueOf(j));
                    }
                    this.f2455f.m3091e();
                    m3033a(this.f2455f);
                    if (d) {
                        this.f2460k.queueSecureInputBuffer(this.f2475z, 0, MediaCodecRenderer.m3012a(this.f2455f, i2), j, 0);
                    } else {
                        this.f2460k.queueInputBuffer(this.f2475z, 0, this.f2455f.f2502b.limit(), j, 0);
                    }
                    this.f2475z = -1;
                    this.f2446F = true;
                    this.f2444D = 0;
                    DecoderCounters decoderCounters = this.f2451a;
                    decoderCounters.f2496c++;
                    return true;
                } catch (Exception e2) {
                    throw ExoPlaybackException.m3798a(e2, m3007p());
                }
            }
        }
    }

    private static CryptoInfo m3012a(DecoderInputBuffer decoderInputBuffer, int i) {
        CryptoInfo a = decoderInputBuffer.f2501a.m3080a();
        if (i != 0) {
            if (a.numBytesOfClearData == null) {
                a.numBytesOfClearData = new int[1];
            }
            int[] iArr = a.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return a;
    }

    private boolean m3019b(boolean z) {
        if (this.f2461l == null) {
            return false;
        }
        int a = this.f2461l.m3807a();
        if (a == 0) {
            throw ExoPlaybackException.m3798a(this.f2461l.m3810c(), m3007p());
        } else if (a == 4) {
            return false;
        } else {
            if (z || !this.f2454e) {
                return true;
            }
            return false;
        }
    }

    protected void m3034a(String str, long j, long j2) {
    }

    protected void m3038b(Format format) {
        Format format2 = this.f2459j;
        this.f2459j = format;
        if (!Util.m4517a(this.f2459j.f2327h, format2 == null ? null : format2.f2327h)) {
            if (this.f2459j.f2327h == null) {
                this.f2462m = null;
            } else if (this.f2453d == null) {
                throw ExoPlaybackException.m3798a(new IllegalStateException("Media requires a DrmSessionManager"), m3007p());
            } else {
                this.f2462m = this.f2453d.m3811a(Looper.myLooper(), this.f2459j.f2327h);
                if (this.f2462m == this.f2461l) {
                    this.f2453d.m3812a(this.f2462m);
                }
            }
        }
        if (this.f2462m == this.f2461l && this.f2460k != null && m3037a(this.f2460k, this.f2463n, format2, this.f2459j)) {
            boolean z;
            this.f2443C = true;
            this.f2444D = 1;
            if (this.f2466q && this.f2459j.f2328i == format2.f2328i && this.f2459j.f2329j == format2.f2329j) {
                z = true;
            } else {
                z = false;
            }
            this.f2470u = z;
        } else if (this.f2446F) {
            this.f2445E = 1;
        } else {
            m3049y();
            m3047w();
        }
    }

    protected void m3031a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void m3046u() {
    }

    protected void m3033a(DecoderInputBuffer decoderInputBuffer) {
    }

    protected void m3039c(long j) {
    }

    protected boolean m3037a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    public boolean m3045s() {
        return this.f2449I;
    }

    public boolean m3044r() {
        return (this.f2459j == null || this.f2450J || (!m3008q() && this.f2441A < 0 && (this.f2474y == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.f2474y))) ? false : true;
    }

    protected long m3025A() {
        return 0;
    }

    private boolean m3016b(long j, long j2) {
        if (this.f2449I) {
            return false;
        }
        if (this.f2441A < 0) {
            this.f2441A = this.f2460k.dequeueOutputBuffer(this.f2458i, m3025A());
            if (this.f2441A >= 0) {
                if (this.f2471v) {
                    this.f2471v = false;
                    this.f2460k.releaseOutputBuffer(this.f2441A, false);
                    this.f2441A = -1;
                    return true;
                } else if ((this.f2458i.flags & 4) != 0) {
                    m3011D();
                    this.f2441A = -1;
                    return true;
                } else {
                    ByteBuffer byteBuffer = this.f2473x[this.f2441A];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.f2458i.offset);
                        byteBuffer.limit(this.f2458i.offset + this.f2458i.size);
                    }
                    this.f2442B = m3021d(this.f2458i.presentationTimeUs);
                }
            } else if (this.f2441A == -2) {
                m3009B();
                return true;
            } else if (this.f2441A == -3) {
                m3010C();
                return true;
            } else if (!this.f2467r || (!this.f2448H && this.f2445E != 2)) {
                return false;
            } else {
                m3011D();
                return true;
            }
        }
        if (!m3036a(j, j2, this.f2460k, this.f2473x[this.f2441A], this.f2441A, this.f2458i.flags, this.f2458i.presentationTimeUs, this.f2442B)) {
            return false;
        }
        m3039c(this.f2458i.presentationTimeUs);
        this.f2441A = -1;
        return true;
    }

    private void m3009B() {
        MediaFormat outputFormat = this.f2460k.getOutputFormat();
        if (this.f2466q && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.f2471v = true;
            return;
        }
        if (this.f2469t) {
            outputFormat.setInteger("channel-count", 1);
        }
        m3031a(this.f2460k, outputFormat);
    }

    private void m3010C() {
        this.f2473x = this.f2460k.getOutputBuffers();
    }

    private void m3011D() {
        if (this.f2445E == 2) {
            m3049y();
            m3047w();
            return;
        }
        this.f2449I = true;
        m3046u();
    }

    private boolean m3021d(long j) {
        int size = this.f2457h.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.f2457h.get(i)).longValue() == j) {
                this.f2457h.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean m3014a(String str) {
        return Util.f3855a < 18 || ((Util.f3855a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (Util.f3855a == 19 && Util.f3858d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str))));
    }

    private static boolean m3017b(String str) {
        return Util.f3855a < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(Util.f3856b) || "flounder_lte".equals(Util.f3856b) || "grouper".equals(Util.f3856b) || "tilapia".equals(Util.f3856b)));
    }

    private static boolean m3015a(String str, Format format) {
        return Util.f3855a < 21 && format.f2326g.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean m3020c(String str) {
        return Util.f3855a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean m3022d(String str) {
        return Util.f3855a <= 23 && "OMX.google.vorbis.decoder".equals(str);
    }

    private static boolean m3018b(String str, Format format) {
        if (Util.f3855a <= 18 && format.f2335p == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return true;
        }
        return false;
    }
}
