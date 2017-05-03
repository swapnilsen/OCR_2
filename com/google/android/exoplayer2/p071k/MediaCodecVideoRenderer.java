package com.google.android.exoplayer2.p071k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.p049d.MediaCodecInfo;
import com.google.android.exoplayer2.p049d.MediaCodecRenderer;
import com.google.android.exoplayer2.p049d.MediaCodecSelector;
import com.google.android.exoplayer2.p049d.MediaCodecUtil;
import com.google.android.exoplayer2.p050j.MimeTypes;
import com.google.android.exoplayer2.p050j.TraceUtil;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p051b.DecoderCounters;
import com.google.android.exoplayer2.p071k.VideoRendererEventListener.VideoRendererEventListener;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.k.c */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private final VideoFrameReleaseTimeHelper f3874b;
    private final VideoRendererEventListener f3875c;
    private final long f3876d;
    private final int f3877e;
    private final int f3878f;
    private final boolean f3879g;
    private Format[] f3880h;
    private MediaCodecVideoRenderer f3881i;
    private Surface f3882j;
    private boolean f3883k;
    private long f3884l;
    private long f3885m;
    private int f3886n;
    private int f3887o;
    private int f3888p;
    private float f3889q;
    private int f3890r;
    private int f3891s;
    private int f3892t;
    private float f3893u;
    private int f3894v;
    private int f3895w;
    private int f3896x;
    private float f3897y;

    /* renamed from: com.google.android.exoplayer2.k.c.a */
    private static final class MediaCodecVideoRenderer {
        public final int f3871a;
        public final int f3872b;
        public final int f3873c;

        public MediaCodecVideoRenderer(int i, int i2, int i3) {
            this.f3871a = i;
            this.f3872b = i2;
            this.f3873c = i3;
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, int i, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2) {
        super(2, mediaCodecSelector, drmSessionManager, z);
        this.f3877e = i;
        this.f3876d = j;
        this.f3878f = i2;
        this.f3874b = new VideoFrameReleaseTimeHelper(context);
        this.f3875c = new VideoRendererEventListener(handler, videoRendererEventListener);
        this.f3879g = MediaCodecVideoRenderer.m4535B();
        this.f3884l = -9223372036854775807L;
        this.f3890r = -1;
        this.f3891s = -1;
        this.f3893u = -1.0f;
        this.f3889q = -1.0f;
        this.f3894v = -1;
        this.f3895w = -1;
        this.f3897y = -1.0f;
    }

    protected int m4549a(MediaCodecSelector mediaCodecSelector, Format format) {
        boolean z = false;
        String str = format.f2324e;
        if (!MimeTypes.m4426b(str)) {
            return 0;
        }
        boolean z2;
        DrmInitData drmInitData = format.f2327h;
        if (drmInitData != null) {
            z2 = false;
            for (int i = 0; i < drmInitData.f3305a; i++) {
                z2 |= drmInitData.m3806a(i).f3302c;
            }
        } else {
            z2 = false;
        }
        MediaCodecInfo a = mediaCodecSelector.m3771a(str, z2);
        if (a == null) {
            return 1;
        }
        boolean b = a.m3767b(format.f2322c);
        if (!b || format.f2328i <= 0 || format.f2329j <= 0) {
            z = b;
        } else if (Util.f3855a >= 21) {
            if (format.f2330k > 0.0f) {
                z = a.m3764a(format.f2328i, format.f2329j, (double) format.f2330k);
            } else {
                z = a.m3763a(format.f2328i, format.f2329j);
            }
        } else if (format.f2328i * format.f2329j <= MediaCodecUtil.m3794b()) {
            z = true;
        }
        return (a.f3279b ? 8 : 4) | (z ? 3 : 2);
    }

    protected void m4555a(boolean z) {
        super.m3035a(z);
        this.f3875c.m4583a(this.a);
        this.f3874b.m4575a();
    }

    protected void m4556a(Format[] formatArr) {
        this.f3880h = formatArr;
        super.m2989a(formatArr);
    }

    protected void m4551a(long j, boolean z) {
        super.m3030a(j, z);
        this.f3883k = false;
        this.f3887o = 0;
        long elapsedRealtime = (!z || this.f3876d <= 0) ? -9223372036854775807L : SystemClock.elapsedRealtime() + this.f3876d;
        this.f3884l = elapsedRealtime;
    }

    public boolean m4563r() {
        if ((this.f3883k || super.m3048x()) && super.m3044r()) {
            this.f3884l = -9223372036854775807L;
            return true;
        } else if (this.f3884l == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f3884l) {
                return true;
            }
            this.f3884l = -9223372036854775807L;
            return false;
        }
    }

    protected void m4560m() {
        super.m3041m();
        this.f3886n = 0;
        this.f3885m = SystemClock.elapsedRealtime();
    }

    protected void m4561n() {
        this.f3884l = -9223372036854775807L;
        m4548v();
        super.m3042n();
    }

    protected void m4562o() {
        this.f3890r = -1;
        this.f3891s = -1;
        this.f3893u = -1.0f;
        this.f3889q = -1.0f;
        this.f3894v = -1;
        this.f3895w = -1;
        this.f3897y = -1.0f;
        this.f3874b.m4576b();
        try {
            super.m3043o();
        } finally {
            this.a.m3087a();
            this.f3875c.m4585b(this.a);
        }
    }

    public void m4550a(int i, Object obj) {
        if (i == 1) {
            m4540a((Surface) obj);
        } else {
            super.m2985a(i, obj);
        }
    }

    private void m4540a(Surface surface) {
        if (this.f3882j != surface) {
            this.f3883k = false;
            this.f3882j = surface;
            int d = m2995d();
            if (d == 1 || d == 2) {
                m3049y();
                m3047w();
            }
        }
    }

    protected boolean m4564x() {
        return super.m3048x() && this.f3882j != null && this.f3882j.isValid();
    }

    protected void m4553a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.f3881i = MediaCodecVideoRenderer.m4537a(format, this.f3880h);
        mediaCodec.configure(MediaCodecVideoRenderer.m4536a(format, this.f3881i, this.f3879g), this.f3882j, mediaCrypto, 0);
    }

    protected void m4554a(String str, long j, long j2) {
        this.f3875c.m4584a(str, j, j2);
    }

    protected void m4559b(Format format) {
        super.m3038b(format);
        this.f3875c.m4582a(format);
        this.f3889q = MediaCodecVideoRenderer.m4545d(format);
        this.f3888p = MediaCodecVideoRenderer.m4546e(format);
    }

    protected void m4552a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.f3890r = integer;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer = mediaFormat.getInteger("height");
        }
        this.f3891s = integer;
        this.f3893u = this.f3889q;
        if (Util.f3855a < 21) {
            this.f3892t = this.f3888p;
        } else if (this.f3888p == 90 || this.f3888p == 270) {
            integer = this.f3890r;
            this.f3890r = this.f3891s;
            this.f3891s = integer;
            this.f3893u = 1.0f / this.f3893u;
        }
        mediaCodec.setVideoScalingMode(this.f3877e);
    }

    protected boolean m4558a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return MediaCodecVideoRenderer.m4541a(format, format2) && format2.f2328i <= this.f3881i.f3871a && format2.f2329j <= this.f3881i.f3872b && format2.f2325f <= this.f3881i.f3873c && (z || (format.f2328i == format2.f2328i && format.f2329j == format2.f2329j));
    }

    protected boolean m4557a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (z) {
            m4538a(mediaCodec, i);
            return true;
        } else if (!this.f3883k) {
            if (Util.f3855a >= 21) {
                m4539a(mediaCodec, i, System.nanoTime());
            } else {
                m4544c(mediaCodec, i);
            }
            return true;
        } else if (m2995d() != 2) {
            return false;
        } else {
            long elapsedRealtime = (j3 - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            elapsedRealtime = this.f3874b.m4574a(j3, (elapsedRealtime * 1000) + nanoTime);
            nanoTime = (elapsedRealtime - nanoTime) / 1000;
            if (nanoTime < -30000) {
                m4542b(mediaCodec, i);
                return true;
            }
            if (Util.f3855a >= 21) {
                if (nanoTime < 50000) {
                    m4539a(mediaCodec, i, elapsedRealtime);
                    return true;
                }
            } else if (nanoTime < 30000) {
                if (nanoTime > 11000) {
                    try {
                        Thread.sleep((nanoTime - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                m4544c(mediaCodec, i);
                return true;
            }
            return false;
        }
    }

    private void m4538a(MediaCodec mediaCodec, int i) {
        TraceUtil.m4503a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.m4502a();
        DecoderCounters decoderCounters = this.a;
        decoderCounters.f2498e++;
    }

    private void m4542b(MediaCodec mediaCodec, int i) {
        TraceUtil.m4503a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.m4502a();
        DecoderCounters decoderCounters = this.a;
        decoderCounters.f2499f++;
        this.f3886n++;
        this.f3887o++;
        this.a.f2500g = Math.max(this.f3887o, this.a.f2500g);
        if (this.f3886n == this.f3878f) {
            m4548v();
        }
    }

    private void m4544c(MediaCodec mediaCodec, int i) {
        m4547t();
        TraceUtil.m4503a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.m4502a();
        DecoderCounters decoderCounters = this.a;
        decoderCounters.f2497d++;
        this.f3887o = 0;
        if (!this.f3883k) {
            this.f3883k = true;
            this.f3875c.m4581a(this.f3882j);
        }
    }

    @TargetApi(21)
    private void m4539a(MediaCodec mediaCodec, int i, long j) {
        m4547t();
        TraceUtil.m4503a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        TraceUtil.m4502a();
        DecoderCounters decoderCounters = this.a;
        decoderCounters.f2497d++;
        this.f3887o = 0;
        if (!this.f3883k) {
            this.f3883k = true;
            this.f3875c.m4581a(this.f3882j);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat m4536a(Format format, MediaCodecVideoRenderer mediaCodecVideoRenderer, boolean z) {
        MediaFormat b = format.m2875b();
        b.setInteger("max-width", mediaCodecVideoRenderer.f3871a);
        b.setInteger("max-height", mediaCodecVideoRenderer.f3872b);
        if (mediaCodecVideoRenderer.f3873c != -1) {
            b.setInteger("max-input-size", mediaCodecVideoRenderer.f3873c);
        }
        if (z) {
            b.setInteger("auto-frc", 0);
        }
        return b;
    }

    private static MediaCodecVideoRenderer m4537a(Format format, Format[] formatArr) {
        int i = format.f2328i;
        int i2 = format.f2329j;
        int c = MediaCodecVideoRenderer.m4543c(format);
        int i3 = c;
        c = i2;
        i2 = i;
        for (Format format2 : formatArr) {
            if (MediaCodecVideoRenderer.m4541a(format, format2)) {
                i2 = Math.max(i2, format2.f2328i);
                c = Math.max(c, format2.f2329j);
                i3 = Math.max(i3, MediaCodecVideoRenderer.m4543c(format2));
            }
        }
        return new MediaCodecVideoRenderer(i2, c, i3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m4543c(com.google.android.exoplayer2.Format r6) {
        /*
        r1 = 4;
        r0 = 2;
        r2 = -1;
        r3 = r6.f2325f;
        if (r3 == r2) goto L_0x000a;
    L_0x0007:
        r0 = r6.f2325f;
    L_0x0009:
        return r0;
    L_0x000a:
        r3 = r6.f2328i;
        if (r3 == r2) goto L_0x0012;
    L_0x000e:
        r3 = r6.f2329j;
        if (r3 != r2) goto L_0x0014;
    L_0x0012:
        r0 = r2;
        goto L_0x0009;
    L_0x0014:
        r3 = r6.f2324e;
        r4 = r3.hashCode();
        switch(r4) {
            case -1664118616: goto L_0x0023;
            case -1662541442: goto L_0x004b;
            case 1187890754: goto L_0x002d;
            case 1331836730: goto L_0x0037;
            case 1599127256: goto L_0x0041;
            case 1599127257: goto L_0x0055;
            default: goto L_0x001d;
        };
    L_0x001d:
        r3 = r2;
    L_0x001e:
        switch(r3) {
            case 0: goto L_0x005f;
            case 1: goto L_0x005f;
            case 2: goto L_0x006b;
            case 3: goto L_0x0089;
            case 4: goto L_0x008f;
            case 5: goto L_0x008f;
            default: goto L_0x0021;
        };
    L_0x0021:
        r0 = r2;
        goto L_0x0009;
    L_0x0023:
        r4 = "video/3gpp";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x002b:
        r3 = 0;
        goto L_0x001e;
    L_0x002d:
        r4 = "video/mp4v-es";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0035:
        r3 = 1;
        goto L_0x001e;
    L_0x0037:
        r4 = "video/avc";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x003f:
        r3 = r0;
        goto L_0x001e;
    L_0x0041:
        r4 = "video/x-vnd.on2.vp8";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0049:
        r3 = 3;
        goto L_0x001e;
    L_0x004b:
        r4 = "video/hevc";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0053:
        r3 = r1;
        goto L_0x001e;
    L_0x0055:
        r4 = "video/x-vnd.on2.vp9";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x005d:
        r3 = 5;
        goto L_0x001e;
    L_0x005f:
        r1 = r6.f2328i;
        r2 = r6.f2329j;
        r1 = r1 * r2;
    L_0x0064:
        r1 = r1 * 3;
        r0 = r0 * 2;
        r0 = r1 / r0;
        goto L_0x0009;
    L_0x006b:
        r1 = "BRAVIA 4K 2015";
        r3 = com.google.android.exoplayer2.p050j.Util.f3858d;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0077;
    L_0x0075:
        r0 = r2;
        goto L_0x0009;
    L_0x0077:
        r1 = r6.f2328i;
        r1 = r1 + 15;
        r1 = r1 / 16;
        r2 = r6.f2329j;
        r2 = r2 + 15;
        r2 = r2 / 16;
        r1 = r1 * r2;
        r1 = r1 * 16;
        r1 = r1 * 16;
        goto L_0x0064;
    L_0x0089:
        r1 = r6.f2328i;
        r2 = r6.f2329j;
        r1 = r1 * r2;
        goto L_0x0064;
    L_0x008f:
        r0 = r6.f2328i;
        r2 = r6.f2329j;
        r0 = r0 * r2;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.k.c.c(com.google.android.exoplayer2.Format):int");
    }

    private void m4547t() {
        if (this.f3894v != this.f3890r || this.f3895w != this.f3891s || this.f3896x != this.f3892t || this.f3897y != this.f3893u) {
            this.f3875c.m4579a(this.f3890r, this.f3891s, this.f3892t, this.f3893u);
            this.f3894v = this.f3890r;
            this.f3895w = this.f3891s;
            this.f3896x = this.f3892t;
            this.f3897y = this.f3893u;
        }
    }

    private void m4548v() {
        if (this.f3886n > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f3875c.m4580a(this.f3886n, elapsedRealtime - this.f3885m);
            this.f3886n = 0;
            this.f3885m = elapsedRealtime;
        }
    }

    private static boolean m4535B() {
        return Util.f3855a <= 22 && "foster".equals(Util.f3856b) && "NVIDIA".equals(Util.f3857c);
    }

    private static boolean m4541a(Format format, Format format2) {
        return format.f2324e.equals(format2.f2324e) && MediaCodecVideoRenderer.m4546e(format) == MediaCodecVideoRenderer.m4546e(format2);
    }

    private static float m4545d(Format format) {
        return format.f2332m == -1.0f ? 1.0f : format.f2332m;
    }

    private static int m4546e(Format format) {
        return format.f2331l == -1 ? 0 : format.f2331l;
    }
}
