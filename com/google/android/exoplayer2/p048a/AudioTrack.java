package com.google.android.exoplayer2.p048a;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.a.d */
public final class AudioTrack {
    public static boolean f2393a;
    public static boolean f2394b;
    private int f2395A;
    private int f2396B;
    private long f2397C;
    private long f2398D;
    private long f2399E;
    private float f2400F;
    private byte[] f2401G;
    private int f2402H;
    private ByteBuffer f2403I;
    private ByteBuffer f2404J;
    private boolean f2405K;
    private final AudioCapabilities f2406c;
    private final int f2407d;
    private final ConditionVariable f2408e;
    private final long[] f2409f;
    private final AudioTrack f2410g;
    private android.media.AudioTrack f2411h;
    private android.media.AudioTrack f2412i;
    private int f2413j;
    private int f2414k;
    private int f2415l;
    private int f2416m;
    private boolean f2417n;
    private int f2418o;
    private int f2419p;
    private long f2420q;
    private int f2421r;
    private int f2422s;
    private long f2423t;
    private long f2424u;
    private boolean f2425v;
    private long f2426w;
    private Method f2427x;
    private long f2428y;
    private long f2429z;

    /* renamed from: com.google.android.exoplayer2.a.d.1 */
    class AudioTrack extends Thread {
        final /* synthetic */ android.media.AudioTrack f2372a;
        final /* synthetic */ AudioTrack f2373b;

        AudioTrack(AudioTrack audioTrack, android.media.AudioTrack audioTrack2) {
            this.f2373b = audioTrack;
            this.f2372a = audioTrack2;
        }

        public void run() {
            try {
                this.f2372a.flush();
                this.f2372a.release();
            } finally {
                this.f2373b.f2408e.open();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.d.2 */
    class AudioTrack extends Thread {
        final /* synthetic */ android.media.AudioTrack f2374a;
        final /* synthetic */ AudioTrack f2375b;

        AudioTrack(AudioTrack audioTrack, android.media.AudioTrack audioTrack2) {
            this.f2375b = audioTrack;
            this.f2374a = audioTrack2;
        }

        public void run() {
            this.f2374a.release();
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.d.a */
    private static class AudioTrack {
        protected android.media.AudioTrack f2376a;
        private boolean f2377b;
        private int f2378c;
        private long f2379d;
        private long f2380e;
        private long f2381f;
        private long f2382g;
        private long f2383h;
        private long f2384i;

        private AudioTrack() {
        }

        public void m2904a(android.media.AudioTrack audioTrack, boolean z) {
            this.f2376a = audioTrack;
            this.f2377b = z;
            this.f2382g = -9223372036854775807L;
            this.f2379d = 0;
            this.f2380e = 0;
            this.f2381f = 0;
            if (audioTrack != null) {
                this.f2378c = audioTrack.getSampleRate();
            }
        }

        public void m2903a(long j) {
            this.f2383h = m2906b();
            this.f2382g = SystemClock.elapsedRealtime() * 1000;
            this.f2384i = j;
            this.f2376a.stop();
        }

        public void m2902a() {
            if (this.f2382g == -9223372036854775807L) {
                this.f2376a.pause();
            }
        }

        public long m2906b() {
            if (this.f2382g != -9223372036854775807L) {
                return Math.min(this.f2384i, ((((SystemClock.elapsedRealtime() * 1000) - this.f2382g) * ((long) this.f2378c)) / 1000000) + this.f2383h);
            }
            int playState = this.f2376a.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = 4294967295L & ((long) this.f2376a.getPlaybackHeadPosition());
            if (this.f2377b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f2381f = this.f2379d;
                }
                playbackHeadPosition += this.f2381f;
            }
            if (this.f2379d > playbackHeadPosition) {
                this.f2380e++;
            }
            this.f2379d = playbackHeadPosition;
            return playbackHeadPosition + (this.f2380e << 32);
        }

        public long m2907c() {
            return (m2906b() * 1000000) / ((long) this.f2378c);
        }

        public boolean m2908d() {
            return false;
        }

        public long m2909e() {
            throw new UnsupportedOperationException();
        }

        public long m2910f() {
            throw new UnsupportedOperationException();
        }

        public void m2905a(PlaybackParams playbackParams) {
            throw new UnsupportedOperationException();
        }

        public float m2911g() {
            return 1.0f;
        }
    }

    @TargetApi(19)
    /* renamed from: com.google.android.exoplayer2.a.d.b */
    private static class AudioTrack extends AudioTrack {
        private final AudioTimestamp f2385b;
        private long f2386c;
        private long f2387d;
        private long f2388e;

        public AudioTrack() {
            super();
            this.f2385b = new AudioTimestamp();
        }

        public void m2912a(android.media.AudioTrack audioTrack, boolean z) {
            super.m2904a(audioTrack, z);
            this.f2386c = 0;
            this.f2387d = 0;
            this.f2388e = 0;
        }

        public boolean m2913d() {
            boolean timestamp = this.a.getTimestamp(this.f2385b);
            if (timestamp) {
                long j = this.f2385b.framePosition;
                if (this.f2387d > j) {
                    this.f2386c++;
                }
                this.f2387d = j;
                this.f2388e = j + (this.f2386c << 32);
            }
            return timestamp;
        }

        public long m2914e() {
            return this.f2385b.nanoTime;
        }

        public long m2915f() {
            return this.f2388e;
        }
    }

    @TargetApi(23)
    /* renamed from: com.google.android.exoplayer2.a.d.c */
    private static class AudioTrack extends AudioTrack {
        private PlaybackParams f2389b;
        private float f2390c;

        public AudioTrack() {
            this.f2390c = 1.0f;
        }

        public void m2917a(android.media.AudioTrack audioTrack, boolean z) {
            super.m2912a(audioTrack, z);
            m2916h();
        }

        public void m2918a(PlaybackParams playbackParams) {
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            PlaybackParams allowDefaults = playbackParams.allowDefaults();
            this.f2389b = allowDefaults;
            this.f2390c = allowDefaults.getSpeed();
            m2916h();
        }

        public float m2919g() {
            return this.f2390c;
        }

        private void m2916h() {
            if (this.a != null && this.f2389b != null) {
                this.a.setPlaybackParams(this.f2389b);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.d.d */
    public static final class AudioTrack extends Exception {
        public final int f2391a;

        public AudioTrack(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.f2391a = i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.d.e */
    public static final class AudioTrack extends RuntimeException {
        public AudioTrack(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.d.f */
    public static final class AudioTrack extends Exception {
        public final int f2392a;

        public AudioTrack(int i) {
            super("AudioTrack write failed: " + i);
            this.f2392a = i;
        }
    }

    static {
        f2393a = false;
        f2394b = false;
    }

    public AudioTrack(AudioCapabilities audioCapabilities, int i) {
        this.f2406c = audioCapabilities;
        this.f2407d = i;
        this.f2408e = new ConditionVariable(true);
        if (Util.f3855a >= 18) {
            try {
                this.f2427x = android.media.AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (Util.f3855a >= 23) {
            this.f2410g = new AudioTrack();
        } else if (Util.f3855a >= 19) {
            this.f2410g = new AudioTrack();
        } else {
            this.f2410g = new AudioTrack();
        }
        this.f2409f = new long[10];
        this.f2400F = 1.0f;
        this.f2396B = 0;
    }

    public boolean m2946a(String str) {
        return this.f2406c != null && this.f2406c.m2888a(AudioTrack.m2926b(str));
    }

    public boolean m2945a() {
        return this.f2412i != null;
    }

    public long m2941a(boolean z) {
        if (!m2932m()) {
            return Long.MIN_VALUE;
        }
        if (this.f2412i.getPlayState() == 3) {
            m2933n();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.f2425v) {
            return m2927b(m2929c((long) (((float) (nanoTime - (this.f2410g.m2909e() / 1000))) * this.f2410g.m2911g())) + this.f2410g.m2910f()) + this.f2397C;
        }
        if (this.f2422s == 0) {
            nanoTime = this.f2410g.m2907c() + this.f2397C;
        } else {
            nanoTime = (nanoTime + this.f2423t) + this.f2397C;
        }
        if (z) {
            return nanoTime;
        }
        return nanoTime - this.f2399E;
    }

    public void m2944a(String str, int i, int i2, int i3, int i4) {
        int i5;
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                i5 = 4;
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                i5 = 12;
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                i5 = 28;
                break;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                i5 = HttpStatusCodes.STATUS_CODE_NO_CONTENT;
                break;
            case Type.OTHER_PROFILE /*5*/:
                i5 = 220;
                break;
            case Type.CONTRIBUTOR /*6*/:
                i5 = 252;
                break;
            case Type.WEBSITE /*7*/:
                i5 = 1276;
                break;
            case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                i5 = C.f2521a;
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel count: " + i);
        }
        boolean z = !"audio/raw".equals(str);
        if (z) {
            i3 = AudioTrack.m2926b(str);
        } else if (!(i3 == 3 || i3 == 2 || i3 == RtlSpacingHelper.UNDEFINED || i3 == 1073741824)) {
            throw new IllegalArgumentException("Unsupported PCM encoding: " + i3);
        }
        if (!m2945a() || this.f2415l != i3 || this.f2413j != i2 || this.f2414k != i5) {
            long j;
            m2954i();
            this.f2415l = i3;
            this.f2417n = z;
            this.f2413j = i2;
            this.f2414k = i5;
            if (!z) {
                i3 = 2;
            }
            this.f2416m = i3;
            this.f2418o = i * 2;
            if (i4 != 0) {
                this.f2419p = i4;
            } else if (!z) {
                int minBufferSize = android.media.AudioTrack.getMinBufferSize(i2, i5, this.f2416m);
                Assertions.m4406b(minBufferSize != -2);
                int i6 = minBufferSize * 4;
                i5 = ((int) m2929c(250000)) * this.f2418o;
                minBufferSize = (int) Math.max((long) minBufferSize, m2929c(750000) * ((long) this.f2418o));
                if (i6 >= i5) {
                    i5 = i6 > minBufferSize ? minBufferSize : i6;
                }
                this.f2419p = i5;
            } else if (this.f2416m == 5 || this.f2416m == 6) {
                this.f2419p = 20480;
            } else {
                this.f2419p = 49152;
            }
            if (z) {
                j = -9223372036854775807L;
            } else {
                j = m2927b(m2922a((long) this.f2419p));
            }
            this.f2420q = j;
        }
    }

    public int m2939a(int i) {
        this.f2408e.block();
        if (i == 0) {
            this.f2412i = new android.media.AudioTrack(this.f2407d, this.f2413j, this.f2414k, this.f2416m, this.f2419p, 1);
        } else {
            this.f2412i = new android.media.AudioTrack(this.f2407d, this.f2413j, this.f2414k, this.f2416m, this.f2419p, 1, i);
        }
        m2934o();
        int audioSessionId = this.f2412i.getAudioSessionId();
        if (f2393a && Util.f3855a < 21) {
            if (!(this.f2411h == null || audioSessionId == this.f2411h.getAudioSessionId())) {
                m2931l();
            }
            if (this.f2411h == null) {
                this.f2411h = new android.media.AudioTrack(this.f2407d, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        this.f2410g.m2904a(this.f2412i, m2937r());
        m2930k();
        return audioSessionId;
    }

    public int m2947b() {
        return this.f2419p;
    }

    public long m2948c() {
        return this.f2420q;
    }

    public void m2949d() {
        if (m2945a()) {
            this.f2398D = System.nanoTime() / 1000;
            this.f2412i.play();
        }
    }

    public void m2950e() {
        if (this.f2396B == 1) {
            this.f2396B = 2;
        }
    }

    public int m2940a(ByteBuffer byteBuffer, long j) {
        boolean z;
        int remaining;
        int i = 1;
        int i2 = 0;
        int i3 = this.f2403I == null ? 1 : 0;
        if (i3 != 0 || this.f2403I == byteBuffer) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m4406b(z);
        this.f2403I = byteBuffer;
        if (m2937r()) {
            if (this.f2412i.getPlayState() == 2) {
                return 0;
            }
            if (this.f2412i.getPlayState() == 1 && this.f2410g.m2906b() != 0) {
                return 0;
            }
        }
        if (i3 == 0) {
            i = 0;
        } else if (this.f2403I.hasRemaining()) {
            this.f2405K = this.f2416m != this.f2415l;
            if (this.f2405K) {
                if (this.f2416m == 2) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.m4406b(z);
                this.f2404J = AudioTrack.m2924a(this.f2403I, this.f2415l, this.f2404J);
                byteBuffer = this.f2404J;
            }
            if (this.f2417n && this.f2395A == 0) {
                this.f2395A = AudioTrack.m2920a(this.f2416m, byteBuffer);
            }
            if (this.f2396B == 0) {
                this.f2397C = Math.max(0, j);
                this.f2396B = 1;
                i = 0;
            } else {
                long b = this.f2397C + m2927b(m2935p());
                if (this.f2396B == 1 && Math.abs(b - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + b + ", got " + j + "]");
                    this.f2396B = 2;
                }
                if (this.f2396B == 2) {
                    this.f2397C = (j - b) + this.f2397C;
                    this.f2396B = 1;
                } else {
                    i = 0;
                }
            }
            if (Util.f3855a < 21) {
                remaining = byteBuffer.remaining();
                if (this.f2401G == null || this.f2401G.length < remaining) {
                    this.f2401G = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.f2401G, 0, remaining);
                byteBuffer.position(position);
                this.f2402H = 0;
            }
        } else {
            this.f2403I = null;
            return 2;
        }
        if (this.f2405K) {
            byteBuffer = this.f2404J;
        }
        remaining = byteBuffer.remaining();
        if (Util.f3855a < 21) {
            position = this.f2419p - ((int) (this.f2428y - (this.f2410g.m2906b() * ((long) this.f2418o))));
            if (position > 0) {
                i2 = this.f2412i.write(this.f2401G, this.f2402H, Math.min(remaining, position));
                if (i2 >= 0) {
                    this.f2402H += i2;
                }
                byteBuffer.position(byteBuffer.position() + i2);
            }
        } else {
            i2 = AudioTrack.m2921a(this.f2412i, byteBuffer, remaining);
        }
        if (i2 < 0) {
            throw new AudioTrack(i2);
        }
        if (!this.f2417n) {
            this.f2428y += (long) i2;
        }
        if (i2 == remaining) {
            if (this.f2417n) {
                this.f2429z += (long) this.f2395A;
            }
            this.f2403I = null;
            i |= 2;
        }
        return i;
    }

    public void m2951f() {
        if (m2945a()) {
            this.f2410g.m2903a(m2935p());
        }
    }

    public boolean m2952g() {
        return m2945a() && (m2935p() > this.f2410g.m2906b() || m2938s());
    }

    public void m2943a(PlaybackParams playbackParams) {
        this.f2410g.m2905a(playbackParams);
    }

    public void m2942a(float f) {
        if (this.f2400F != f) {
            this.f2400F = f;
            m2930k();
        }
    }

    private void m2930k() {
        if (!m2945a()) {
            return;
        }
        if (Util.f3855a >= 21) {
            AudioTrack.m2925a(this.f2412i, this.f2400F);
        } else {
            AudioTrack.m2928b(this.f2412i, this.f2400F);
        }
    }

    public void m2953h() {
        if (m2945a()) {
            m2936q();
            this.f2410g.m2902a();
        }
    }

    public void m2954i() {
        if (m2945a()) {
            this.f2428y = 0;
            this.f2429z = 0;
            this.f2395A = 0;
            this.f2403I = null;
            this.f2396B = 0;
            this.f2399E = 0;
            m2936q();
            if (this.f2412i.getPlayState() == 3) {
                this.f2412i.pause();
            }
            android.media.AudioTrack audioTrack = this.f2412i;
            this.f2412i = null;
            this.f2410g.m2904a(null, false);
            this.f2408e.close();
            new AudioTrack(this, audioTrack).start();
        }
    }

    public void m2955j() {
        m2954i();
        m2931l();
    }

    private void m2931l() {
        if (this.f2411h != null) {
            android.media.AudioTrack audioTrack = this.f2411h;
            this.f2411h = null;
            new AudioTrack(this, audioTrack).start();
        }
    }

    private boolean m2932m() {
        return m2945a() && this.f2396B != 0;
    }

    private void m2933n() {
        long c = this.f2410g.m2907c();
        if (c != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.f2424u >= 30000) {
                this.f2409f[this.f2421r] = c - nanoTime;
                this.f2421r = (this.f2421r + 1) % 10;
                if (this.f2422s < 10) {
                    this.f2422s++;
                }
                this.f2424u = nanoTime;
                this.f2423t = 0;
                for (int i = 0; i < this.f2422s; i++) {
                    this.f2423t += this.f2409f[i] / ((long) this.f2422s);
                }
            }
            if (!m2937r() && nanoTime - this.f2426w >= 500000) {
                this.f2425v = this.f2410g.m2908d();
                if (this.f2425v) {
                    long e = this.f2410g.m2909e() / 1000;
                    long f = this.f2410g.m2910f();
                    if (e < this.f2398D) {
                        this.f2425v = false;
                    } else if (Math.abs(e - nanoTime) > 5000000) {
                        r0 = "Spurious audio timestamp (system clock mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f2394b) {
                            throw new AudioTrack(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f2425v = false;
                    } else if (Math.abs(m2927b(f) - c) > 5000000) {
                        r0 = "Spurious audio timestamp (frame position mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f2394b) {
                            throw new AudioTrack(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f2425v = false;
                    }
                }
                if (!(this.f2427x == null || this.f2417n)) {
                    try {
                        this.f2399E = (((long) ((Integer) this.f2427x.invoke(this.f2412i, (Object[]) null)).intValue()) * 1000) - this.f2420q;
                        this.f2399E = Math.max(this.f2399E, 0);
                        if (this.f2399E > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.f2399E);
                            this.f2399E = 0;
                        }
                    } catch (Exception e2) {
                        this.f2427x = null;
                    }
                }
                this.f2426w = nanoTime;
            }
        }
    }

    private void m2934o() {
        int state = this.f2412i.getState();
        if (state != 1) {
            try {
                this.f2412i.release();
            } catch (Exception e) {
            } finally {
                this.f2412i = null;
            }
            throw new AudioTrack(state, this.f2413j, this.f2414k, this.f2419p);
        }
    }

    private long m2922a(long j) {
        return j / ((long) this.f2418o);
    }

    private long m2927b(long j) {
        return (1000000 * j) / ((long) this.f2413j);
    }

    private long m2929c(long j) {
        return (((long) this.f2413j) * j) / 1000000;
    }

    private long m2935p() {
        return this.f2417n ? this.f2429z : m2922a(this.f2428y);
    }

    private void m2936q() {
        this.f2423t = 0;
        this.f2422s = 0;
        this.f2421r = 0;
        this.f2424u = 0;
        this.f2425v = false;
        this.f2426w = 0;
    }

    private boolean m2937r() {
        return Util.f3855a < 23 && (this.f2416m == 5 || this.f2416m == 6);
    }

    private boolean m2938s() {
        return m2937r() && this.f2412i.getPlayState() == 2 && this.f2412i.getPlaybackHeadPosition() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.ByteBuffer m2924a(java.nio.ByteBuffer r5, int r6, java.nio.ByteBuffer r7) {
        /*
        r4 = 0;
        r0 = r5.position();
        r2 = r5.limit();
        r1 = r2 - r0;
        switch(r6) {
            case -2147483648: goto L_0x0031;
            case 3: goto L_0x0014;
            case 1073741824: goto L_0x0036;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0014:
        r1 = r1 * 2;
    L_0x0016:
        if (r7 == 0) goto L_0x001e;
    L_0x0018:
        r3 = r7.capacity();
        if (r3 >= r1) goto L_0x0022;
    L_0x001e:
        r7 = java.nio.ByteBuffer.allocateDirect(r1);
    L_0x0022:
        r7.position(r4);
        r7.limit(r1);
        switch(r6) {
            case -2147483648: goto L_0x004d;
            case 3: goto L_0x0039;
            case 1073741824: goto L_0x0064;
            default: goto L_0x002b;
        };
    L_0x002b:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0031:
        r1 = r1 / 3;
        r1 = r1 * 2;
        goto L_0x0016;
    L_0x0036:
        r1 = r1 / 2;
        goto L_0x0016;
    L_0x0039:
        if (r0 >= r2) goto L_0x007b;
    L_0x003b:
        r7.put(r4);
        r1 = r5.get(r0);
        r1 = r1 & 255;
        r1 = r1 + -128;
        r1 = (byte) r1;
        r7.put(r1);
        r0 = r0 + 1;
        goto L_0x0039;
    L_0x004d:
        if (r0 >= r2) goto L_0x007b;
    L_0x004f:
        r1 = r0 + 1;
        r1 = r5.get(r1);
        r7.put(r1);
        r1 = r0 + 2;
        r1 = r5.get(r1);
        r7.put(r1);
        r0 = r0 + 3;
        goto L_0x004d;
    L_0x0064:
        if (r0 >= r2) goto L_0x007b;
    L_0x0066:
        r1 = r0 + 2;
        r1 = r5.get(r1);
        r7.put(r1);
        r1 = r0 + 3;
        r1 = r5.get(r1);
        r7.put(r1);
        r0 = r0 + 4;
        goto L_0x0064;
    L_0x007b:
        r7.position(r4);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.d.a(java.nio.ByteBuffer, int, java.nio.ByteBuffer):java.nio.ByteBuffer");
    }

    private static int m2926b(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    i = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    i = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    i = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return 5;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return 6;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return 7;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return 8;
            default:
                return 0;
        }
    }

    private static int m2920a(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return DtsUtil.m2956a(byteBuffer);
        }
        if (i == 5) {
            return Ac3Util.m2876a();
        }
        if (i == 6) {
            return Ac3Util.m2878a(byteBuffer);
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i);
    }

    @TargetApi(21)
    private static int m2921a(android.media.AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    private static void m2925a(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private static void m2928b(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }
}
