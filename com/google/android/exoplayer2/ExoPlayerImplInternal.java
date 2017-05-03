package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayer;
import com.google.android.exoplayer2.Timeline.Timeline;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.MediaClock;
import com.google.android.exoplayer2.p050j.PriorityHandlerThread;
import com.google.android.exoplayer2.p050j.StandaloneMediaClock;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p062f.MediaPeriod.MediaPeriod;
import com.google.android.exoplayer2.p062f.MediaSource.MediaSource;
import com.google.android.exoplayer2.p062f.SampleStream;
import com.google.android.exoplayer2.p062f.SequenceableLoader;
import com.google.android.exoplayer2.p070h.TrackSelection;
import com.google.android.exoplayer2.p070h.TrackSelections;
import com.google.android.exoplayer2.p070h.TrackSelector.TrackSelector;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.h */
final class ExoPlayerImplInternal<T> implements Callback, MediaPeriod, MediaSource, TrackSelector {
    private int f3663A;
    private ExoPlayerImplInternal<T> f3664B;
    private ExoPlayerImplInternal<T> f3665C;
    private ExoPlayerImplInternal<T> f3666D;
    private Timeline f3667E;
    private final Renderer[] f3668a;
    private final RendererCapabilities[] f3669b;
    private final com.google.android.exoplayer2.p070h.TrackSelector<T> f3670c;
    private final LoadControl f3671d;
    private final StandaloneMediaClock f3672e;
    private final Handler f3673f;
    private final HandlerThread f3674g;
    private final Handler f3675h;
    private final Timeline f3676i;
    private final Timeline f3677j;
    private ExoPlayerImplInternal f3678k;
    private Renderer f3679l;
    private MediaClock f3680m;
    private com.google.android.exoplayer2.p062f.MediaSource f3681n;
    private Renderer[] f3682o;
    private boolean f3683p;
    private boolean f3684q;
    private boolean f3685r;
    private boolean f3686s;
    private int f3687t;
    private int f3688u;
    private int f3689v;
    private long f3690w;
    private long f3691x;
    private boolean f3692y;
    private boolean f3693z;

    /* renamed from: com.google.android.exoplayer2.h.a */
    private static final class ExoPlayerImplInternal<T> {
        public final com.google.android.exoplayer2.p062f.MediaPeriod f3585a;
        public final Object f3586b;
        public final SampleStream[] f3587c;
        public final boolean[] f3588d;
        public int f3589e;
        public long f3590f;
        public boolean f3591g;
        public boolean f3592h;
        public boolean f3593i;
        public long f3594j;
        public ExoPlayerImplInternal<T> f3595k;
        public boolean f3596l;
        private final Renderer[] f3597m;
        private final RendererCapabilities[] f3598n;
        private final com.google.android.exoplayer2.p070h.TrackSelector<T> f3599o;
        private final com.google.android.exoplayer2.p062f.MediaSource f3600p;
        private TrackSelections<T> f3601q;
        private TrackSelections<T> f3602r;

        public ExoPlayerImplInternal(Renderer[] rendererArr, RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.p070h.TrackSelector<T> trackSelector, com.google.android.exoplayer2.p062f.MediaSource mediaSource, com.google.android.exoplayer2.p062f.MediaPeriod mediaPeriod, Object obj, long j) {
            this.f3597m = rendererArr;
            this.f3598n = rendererCapabilitiesArr;
            this.f3599o = trackSelector;
            this.f3600p = mediaSource;
            this.f3585a = mediaPeriod;
            this.f3586b = Assertions.m4402a(obj);
            this.f3587c = new SampleStream[rendererArr.length];
            this.f3588d = new boolean[rendererArr.length];
            this.f3590f = j;
        }

        public void m4233a(ExoPlayerImplInternal<T> exoPlayerImplInternal) {
            this.f3595k = exoPlayerImplInternal;
        }

        public void m4234a(Timeline timeline, Timeline timeline2, int i) {
            this.f3589e = i;
            boolean z = this.f3589e == timeline.m3949b() + -1 && !timeline2.f3969e;
            this.f3591g = z;
        }

        public boolean m4235a() {
            return this.f3592h && (!this.f3593i || this.f3585a.m3885g() == Long.MIN_VALUE);
        }

        public void m4232a(long j, LoadControl loadControl) {
            this.f3592h = true;
            m4236b();
            this.f3590f = m4230a(j, loadControl, false);
        }

        public boolean m4236b() {
            TrackSelections a = this.f3599o.m4254a(this.f3598n, this.f3585a.m3883d());
            if (a.equals(this.f3602r)) {
                return false;
            }
            this.f3601q = a;
            return true;
        }

        public long m4230a(long j, LoadControl loadControl, boolean z) {
            return m4231a(j, loadControl, z, new boolean[this.f3597m.length]);
        }

        public long m4231a(long j, LoadControl loadControl, boolean z, boolean[] zArr) {
            int i;
            for (i = 0; i < this.f3601q.f3658b; i++) {
                boolean z2;
                boolean[] zArr2 = this.f3588d;
                if (!z) {
                    Object obj;
                    if (this.f3602r == null) {
                        obj = null;
                    } else {
                        obj = this.f3602r.m4280a(i);
                    }
                    if (Util.m4517a(obj, this.f3601q.m4280a(i))) {
                        z2 = true;
                        zArr2[i] = z2;
                    }
                }
                z2 = false;
                zArr2[i] = z2;
            }
            long a = this.f3585a.m3879a(this.f3601q.m4281a(), this.f3588d, this.f3587c, zArr, j);
            this.f3602r = this.f3601q;
            this.f3593i = false;
            for (i = 0; i < this.f3587c.length; i++) {
                if (this.f3587c[i] != null) {
                    if (this.f3601q.m4280a(i) != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Assertions.m4406b(z2);
                    this.f3593i = true;
                } else {
                    Assertions.m4406b(this.f3601q.m4280a(i) == null);
                }
            }
            loadControl.m3743a(this.f3597m, this.f3585a.m3883d(), this.f3601q);
            return a;
        }

        public void m4237c() {
            try {
                this.f3600p.m3931a(this.f3585a);
            } catch (Throwable e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.b */
    public static final class ExoPlayerImplInternal {
        public final int f3603a;
        public final long f3604b;
        public volatile long f3605c;
        public volatile long f3606d;

        public ExoPlayerImplInternal(int i, long j) {
            this.f3603a = i;
            this.f3604b = j;
            this.f3605c = j;
            this.f3606d = j;
        }
    }

    public /* synthetic */ void m4318a(SequenceableLoader sequenceableLoader) {
        m4323b((com.google.android.exoplayer2.p062f.MediaPeriod) sequenceableLoader);
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, com.google.android.exoplayer2.p070h.TrackSelector<T> trackSelector, LoadControl loadControl, boolean z, Handler handler, ExoPlayerImplInternal exoPlayerImplInternal) {
        this.f3668a = rendererArr;
        this.f3670c = trackSelector;
        this.f3671d = loadControl;
        this.f3684q = z;
        this.f3675h = handler;
        this.f3687t = 1;
        this.f3678k = exoPlayerImplInternal;
        this.f3669b = new RendererCapabilities[rendererArr.length];
        for (int i = 0; i < rendererArr.length; i++) {
            rendererArr[i].m2962a(i);
            this.f3669b[i] = rendererArr[i].m2967b();
        }
        this.f3672e = new StandaloneMediaClock();
        this.f3682o = new Renderer[0];
        this.f3676i = new Timeline();
        this.f3677j = new Timeline();
        trackSelector.m4257a((TrackSelector) this);
        this.f3674g = new PriorityHandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f3674g.start();
        this.f3673f = new Handler(this.f3674g.getLooper(), this);
    }

    public void m4317a(com.google.android.exoplayer2.p062f.MediaSource mediaSource, boolean z) {
        int i;
        Handler handler = this.f3673f;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.obtainMessage(0, i, 0, mediaSource).sendToTarget();
    }

    public void m4320a(boolean z) {
        int i;
        Handler handler = this.f3673f;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.obtainMessage(1, i, 0).sendToTarget();
    }

    public void m4315a(int i, long j) {
        this.f3673f.obtainMessage(3, i, 0, Long.valueOf(j)).sendToTarget();
    }

    public void m4314a() {
        this.f3673f.sendEmptyMessage(4);
    }

    public void m4321a(ExoPlayer... exoPlayerArr) {
        if (this.f3683p) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.f3688u++;
        this.f3673f.obtainMessage(10, exoPlayerArr).sendToTarget();
    }

    public synchronized void m4324b(ExoPlayer... exoPlayerArr) {
        if (this.f3683p) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.f3688u;
            this.f3688u = i + 1;
            this.f3673f.obtainMessage(10, exoPlayerArr).sendToTarget();
            while (this.f3689v <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m4322b() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f3683p;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        r0 = r2.f3673f;	 Catch:{ all -> 0x001e }
        r1 = 5;
        r0.sendEmptyMessage(r1);	 Catch:{ all -> 0x001e }
    L_0x000d:
        r0 = r2.f3683p;	 Catch:{ all -> 0x001e }
        if (r0 != 0) goto L_0x0021;
    L_0x0011:
        r2.wait();	 Catch:{ InterruptedException -> 0x0015 }
        goto L_0x000d;
    L_0x0015:
        r0 = move-exception;
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x001e }
        r0.interrupt();	 Catch:{ all -> 0x001e }
        goto L_0x000d;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0021:
        r0 = r2.f3674g;	 Catch:{ all -> 0x001e }
        r0.quit();	 Catch:{ all -> 0x001e }
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.b():void");
    }

    public void m4319a(Timeline timeline, Object obj) {
        this.f3673f.obtainMessage(6, Pair.create(timeline, obj)).sendToTarget();
    }

    public void m4316a(com.google.android.exoplayer2.p062f.MediaPeriod mediaPeriod) {
        this.f3673f.obtainMessage(7, mediaPeriod).sendToTarget();
    }

    public void m4323b(com.google.android.exoplayer2.p062f.MediaPeriod mediaPeriod) {
        this.f3673f.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        try {
            switch (message.what) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    com.google.android.exoplayer2.p062f.MediaSource mediaSource = (com.google.android.exoplayer2.p062f.MediaSource) message.obj;
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    m4293b(mediaSource, z);
                    return true;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    m4299c(z);
                    return true;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    m4305f();
                    return true;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    m4292b(message.arg1, ((Long) message.obj).longValue());
                    return true;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    m4306g();
                    return true;
                case Type.OTHER_PROFILE /*5*/:
                    m4307h();
                    return true;
                case Type.CONTRIBUTOR /*6*/:
                    m4286a((Pair) message.obj);
                    return true;
                case Type.WEBSITE /*7*/:
                    m4298c((com.google.android.exoplayer2.p062f.MediaPeriod) message.obj);
                    return true;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    m4302d((com.google.android.exoplayer2.p062f.MediaPeriod) message.obj);
                    return true;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    m4309j();
                    return true;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    m4300c((ExoPlayer[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.f3675h.obtainMessage(6, e).sendToTarget();
            m4306g();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.f3675h.obtainMessage(6, ExoPlaybackException.m3797a(e2)).sendToTarget();
            m4306g();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.f3675h.obtainMessage(6, ExoPlaybackException.m3799a(e3)).sendToTarget();
            m4306g();
            return true;
        }
    }

    private void m4283a(int i) {
        if (this.f3687t != i) {
            this.f3687t = i;
            this.f3675h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void m4295b(boolean z) {
        if (this.f3686s != z) {
            int i;
            this.f3686s = z;
            Handler handler = this.f3675h;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void m4293b(com.google.android.exoplayer2.p062f.MediaSource mediaSource, boolean z) {
        m4308i();
        this.f3671d.m3742a();
        if (z) {
            this.f3678k = new ExoPlayerImplInternal(0, -9223372036854775807L);
        }
        this.f3681n = mediaSource;
        mediaSource.m3932a((MediaSource) this);
        m4283a(2);
        this.f3673f.sendEmptyMessage(2);
    }

    private void m4299c(boolean z) {
        this.f3685r = false;
        this.f3684q = z;
        if (!z) {
            m4301d();
            m4304e();
        } else if (this.f3687t == 3) {
            m4297c();
            this.f3673f.sendEmptyMessage(2);
        } else if (this.f3687t == 2) {
            this.f3673f.sendEmptyMessage(2);
        }
    }

    private void m4297c() {
        int i = 0;
        this.f3685r = false;
        this.f3672e.m4498a();
        Renderer[] rendererArr = this.f3682o;
        int length = rendererArr.length;
        while (i < length) {
            rendererArr[i].m2970e();
            i++;
        }
    }

    private void m4301d() {
        this.f3672e.m4500b();
        for (Renderer a : this.f3682o) {
            m4288a(a);
        }
    }

    private void m4304e() {
        if (this.f3664B != null) {
            long f = this.f3664B.f3585a.m3884f();
            if (f != -9223372036854775807L) {
                m4284a(f);
            } else {
                if (this.f3679l == null || this.f3679l.m2978s()) {
                    this.f3691x = this.f3672e.m4501t();
                } else {
                    this.f3691x = this.f3680m.m3051t();
                    this.f3672e.m4499a(this.f3691x);
                }
                f = this.f3691x - this.f3664B.f3594j;
            }
            this.f3678k.f3605c = f;
            this.f3690w = SystemClock.elapsedRealtime() * 1000;
            if (this.f3682o.length == 0) {
                f = Long.MIN_VALUE;
            } else {
                f = this.f3664B.f3585a.m3885g();
            }
            ExoPlayerImplInternal exoPlayerImplInternal = this.f3678k;
            if (f == Long.MIN_VALUE) {
                f = this.f3667E.m3945a(this.f3664B.f3589e, this.f3677j).m4654b();
            }
            exoPlayerImplInternal.f3606d = f;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4305f() {
        /*
        r15 = this;
        r4 = android.os.SystemClock.elapsedRealtime();
        r15.m4311l();
        r0 = r15.f3664B;
        if (r0 != 0) goto L_0x0014;
    L_0x000b:
        r15.m4310k();
        r0 = 10;
        r15.m4285a(r4, r0);
    L_0x0013:
        return;
    L_0x0014:
        r0 = "doSomeWork";
        com.google.android.exoplayer2.p050j.TraceUtil.m4503a(r0);
        r15.m4304e();
        r2 = 1;
        r1 = 1;
        r6 = r15.f3682o;
        r7 = r6.length;
        r0 = 0;
        r3 = r1;
        r14 = r0;
        r0 = r2;
        r2 = r14;
    L_0x0026:
        if (r2 >= r7) goto L_0x005b;
    L_0x0028:
        r8 = r6[r2];
        r10 = r15.f3691x;
        r12 = r15.f3690w;
        r8.m2964a(r10, r12);
        if (r0 == 0) goto L_0x0055;
    L_0x0033:
        r0 = r8.m2978s();
        if (r0 == 0) goto L_0x0055;
    L_0x0039:
        r0 = 1;
    L_0x003a:
        r1 = r8.m2977r();
        if (r1 != 0) goto L_0x0046;
    L_0x0040:
        r1 = r8.m2978s();
        if (r1 == 0) goto L_0x0057;
    L_0x0046:
        r1 = 1;
    L_0x0047:
        if (r1 != 0) goto L_0x004c;
    L_0x0049:
        r8.m2974i();
    L_0x004c:
        if (r3 == 0) goto L_0x0059;
    L_0x004e:
        if (r1 == 0) goto L_0x0059;
    L_0x0050:
        r1 = 1;
    L_0x0051:
        r2 = r2 + 1;
        r3 = r1;
        goto L_0x0026;
    L_0x0055:
        r0 = 0;
        goto L_0x003a;
    L_0x0057:
        r1 = 0;
        goto L_0x0047;
    L_0x0059:
        r1 = 0;
        goto L_0x0051;
    L_0x005b:
        if (r3 != 0) goto L_0x0060;
    L_0x005d:
        r15.m4310k();
    L_0x0060:
        r1 = r15.f3667E;
        r2 = r15.f3664B;
        r2 = r2.f3589e;
        r6 = r15.f3677j;
        r1 = r1.m3945a(r2, r6);
        r6 = r1.m4654b();
        if (r0 == 0) goto L_0x00a1;
    L_0x0072:
        r0 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x0083;
    L_0x007b:
        r0 = r15.f3678k;
        r0 = r0.f3605c;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x00a1;
    L_0x0083:
        r0 = r15.f3693z;
        if (r0 == 0) goto L_0x00a1;
    L_0x0087:
        r0 = 4;
        r15.m4283a(r0);
        r15.m4301d();
    L_0x008e:
        r0 = r15.f3687t;
        r1 = 2;
        if (r0 != r1) goto L_0x00e3;
    L_0x0093:
        r1 = r15.f3682o;
        r2 = r1.length;
        r0 = 0;
    L_0x0097:
        if (r0 >= r2) goto L_0x00e3;
    L_0x0099:
        r3 = r1[r0];
        r3.m2974i();
        r0 = r0 + 1;
        goto L_0x0097;
    L_0x00a1:
        r0 = r15.f3687t;
        r1 = 2;
        if (r0 != r1) goto L_0x00c6;
    L_0x00a6:
        r0 = r15.f3682o;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x00c1;
    L_0x00ab:
        if (r3 == 0) goto L_0x008e;
    L_0x00ad:
        r0 = r15.f3685r;
        r0 = r15.m4303d(r0);
        if (r0 == 0) goto L_0x008e;
    L_0x00b5:
        r0 = 3;
        r15.m4283a(r0);
        r0 = r15.f3684q;
        if (r0 == 0) goto L_0x008e;
    L_0x00bd:
        r15.m4297c();
        goto L_0x008e;
    L_0x00c1:
        r0 = r15.f3692y;
        if (r0 == 0) goto L_0x008e;
    L_0x00c5:
        goto L_0x00b5;
    L_0x00c6:
        r0 = r15.f3687t;
        r1 = 3;
        if (r0 != r1) goto L_0x008e;
    L_0x00cb:
        r0 = r15.f3682o;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x00de;
    L_0x00d0:
        if (r3 != 0) goto L_0x008e;
    L_0x00d2:
        r0 = r15.f3684q;
        r15.f3685r = r0;
        r0 = 2;
        r15.m4283a(r0);
        r15.m4301d();
        goto L_0x008e;
    L_0x00de:
        r0 = r15.f3692y;
        if (r0 != 0) goto L_0x008e;
    L_0x00e2:
        goto L_0x00d2;
    L_0x00e3:
        r0 = r15.f3684q;
        if (r0 == 0) goto L_0x00ec;
    L_0x00e7:
        r0 = r15.f3687t;
        r1 = 3;
        if (r0 == r1) goto L_0x00f1;
    L_0x00ec:
        r0 = r15.f3687t;
        r1 = 2;
        if (r0 != r1) goto L_0x00fb;
    L_0x00f1:
        r0 = 10;
        r15.m4285a(r4, r0);
    L_0x00f6:
        com.google.android.exoplayer2.p050j.TraceUtil.m4502a();
        goto L_0x0013;
    L_0x00fb:
        r0 = r15.f3682o;
        r0 = r0.length;
        if (r0 == 0) goto L_0x0106;
    L_0x0100:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r15.m4285a(r4, r0);
        goto L_0x00f6;
    L_0x0106:
        r0 = r15.f3673f;
        r1 = 2;
        r0.removeMessages(r1);
        goto L_0x00f6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.f():void");
    }

    private void m4285a(long j, long j2) {
        this.f3673f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f3673f.sendEmptyMessage(2);
        } else {
            this.f3673f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private void m4292b(int i, long j) {
        if (j == -9223372036854775807L) {
            try {
                if (this.f3667E != null && i < this.f3667E.m3949b()) {
                    Pair b = m4291b(i);
                    i = ((Integer) b.first).intValue();
                    j = ((Long) b.second).longValue();
                }
            } catch (Throwable th) {
                this.f3678k = new ExoPlayerImplInternal(i, j);
                this.f3675h.obtainMessage(3, this.f3678k).sendToTarget();
            }
        }
        if (i == this.f3678k.f3603a && ((j == -9223372036854775807L && this.f3678k.f3605c == -9223372036854775807L) || j / 1000 == this.f3678k.f3605c / 1000)) {
            this.f3678k = new ExoPlayerImplInternal(i, j);
            this.f3675h.obtainMessage(3, this.f3678k).sendToTarget();
            return;
        }
        this.f3678k = new ExoPlayerImplInternal(i, m4296c(i, j));
        this.f3675h.obtainMessage(3, this.f3678k).sendToTarget();
    }

    private long m4296c(int i, long j) {
        if (this.f3681n != null) {
            ExoPlayerImplInternal exoPlayerImplInternal;
            m4301d();
            this.f3685r = false;
            m4283a(2);
            if (j == -9223372036854775807L || (this.f3665C != this.f3664B && (i == this.f3664B.f3589e || i == this.f3665C.f3589e))) {
                i = -1;
            }
            if (this.f3664B != null) {
                ExoPlayerImplInternal exoPlayerImplInternal2 = this.f3664B;
                exoPlayerImplInternal = null;
                while (exoPlayerImplInternal2 != null) {
                    if (exoPlayerImplInternal2.f3589e == i && exoPlayerImplInternal2.f3592h) {
                        exoPlayerImplInternal = exoPlayerImplInternal2;
                    } else {
                        exoPlayerImplInternal2.m4237c();
                    }
                    exoPlayerImplInternal2 = exoPlayerImplInternal2.f3595k;
                }
            } else if (this.f3666D != null) {
                this.f3666D.m4237c();
                exoPlayerImplInternal = null;
            } else {
                exoPlayerImplInternal = null;
            }
            if (exoPlayerImplInternal != this.f3664B) {
                for (Renderer k : this.f3682o) {
                    k.m2976k();
                }
                this.f3682o = new Renderer[0];
                this.f3680m = null;
                this.f3679l = null;
            }
            this.f3663A = 0;
            if (exoPlayerImplInternal != null) {
                exoPlayerImplInternal.f3595k = null;
                m4294b(exoPlayerImplInternal);
                m4313n();
                this.f3665C = this.f3664B;
                this.f3666D = this.f3664B;
                if (this.f3664B.f3593i) {
                    j = this.f3664B.f3585a.m3881b(j);
                }
                m4284a(j);
                m4312m();
            } else {
                this.f3664B = null;
                this.f3665C = null;
                this.f3666D = null;
                if (j != -9223372036854775807L) {
                    m4284a(j);
                }
            }
            m4304e();
            this.f3673f.sendEmptyMessage(2);
        } else if (j != -9223372036854775807L) {
            m4284a(j);
        }
        return j;
    }

    private void m4284a(long j) {
        this.f3691x = (this.f3664B == null ? 0 : this.f3664B.f3594j) + j;
        this.f3672e.m4499a(this.f3691x);
        for (Renderer a : this.f3682o) {
            a.m2963a(this.f3691x);
        }
    }

    private void m4306g() {
        m4308i();
        this.f3671d.m3746b();
        m4283a(1);
    }

    private void m4307h() {
        m4308i();
        this.f3671d.m3747c();
        m4283a(1);
        synchronized (this) {
            this.f3683p = true;
            notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4308i() {
        /*
        r8 = this;
        r7 = 0;
        r2 = 0;
        r0 = r8.f3673f;
        r1 = 2;
        r0.removeMessages(r1);
        r8.f3685r = r2;
        r0 = r8.f3672e;
        r0.m4500b();
        r8.f3680m = r7;
        r8.f3679l = r7;
        r3 = r8.f3682o;
        r4 = r3.length;
        r1 = r2;
    L_0x0017:
        if (r1 >= r4) goto L_0x002e;
    L_0x0019:
        r0 = r3[r1];
        r8.m4288a(r0);	 Catch:{ d -> 0x005b, RuntimeException -> 0x0025 }
        r0.m2976k();	 Catch:{ d -> 0x005b, RuntimeException -> 0x0025 }
    L_0x0021:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0017;
    L_0x0025:
        r0 = move-exception;
    L_0x0026:
        r5 = "ExoPlayerImplInternal";
        r6 = "Stop failed.";
        android.util.Log.e(r5, r6, r0);
        goto L_0x0021;
    L_0x002e:
        r0 = new com.google.android.exoplayer2.Renderer[r2];
        r8.f3682o = r0;
        r0 = r8.f3664B;
        if (r0 == 0) goto L_0x0058;
    L_0x0036:
        r0 = r8.f3664B;
    L_0x0038:
        r8.m4287a(r0);
        r0 = r8.f3681n;
        if (r0 == 0) goto L_0x0046;
    L_0x003f:
        r0 = r8.f3681n;
        r0.m3933b();
        r8.f3681n = r7;
    L_0x0046:
        r8.f3692y = r2;
        r8.f3693z = r2;
        r8.f3664B = r7;
        r8.f3665C = r7;
        r8.f3666D = r7;
        r8.f3667E = r7;
        r8.f3663A = r2;
        r8.m4295b(r2);
        return;
    L_0x0058:
        r0 = r8.f3666D;
        goto L_0x0038;
    L_0x005b:
        r0 = move-exception;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.i():void");
    }

    private void m4300c(ExoPlayer[] exoPlayerArr) {
        try {
            for (ExoPlayer exoPlayer : exoPlayerArr) {
                exoPlayer.f3309a.m2960a(exoPlayer.f3310b, exoPlayer.f3311c);
            }
            if (this.f3681n != null) {
                this.f3673f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.f3689v++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
            }
            this.f3689v++;
            notifyAll();
        }
    }

    private void m4288a(Renderer renderer) {
        if (renderer.m2969d() == 2) {
            renderer.m2975j();
        }
    }

    private void m4309j() {
        if (this.f3664B != null) {
            ExoPlayerImplInternal exoPlayerImplInternal = this.f3664B;
            boolean z = true;
            while (exoPlayerImplInternal != null && exoPlayerImplInternal.f3592h) {
                if (exoPlayerImplInternal.m4236b()) {
                    if (z) {
                        boolean z2;
                        if (this.f3665C != this.f3664B) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        m4287a(this.f3664B.f3595k);
                        this.f3664B.f3595k = null;
                        this.f3665C = this.f3664B;
                        this.f3666D = this.f3664B;
                        this.f3663A = 0;
                        boolean[] zArr = new boolean[this.f3668a.length];
                        long a = this.f3664B.m4231a(this.f3678k.f3605c, this.f3671d, z2, zArr);
                        if (a != this.f3678k.f3605c) {
                            this.f3678k.f3605c = a;
                            m4284a(a);
                        }
                        boolean[] zArr2 = new boolean[this.f3668a.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.f3668a.length; i2++) {
                            Renderer renderer = this.f3668a[i2];
                            zArr2[i2] = renderer.m2969d() != 0;
                            SampleStream sampleStream = this.f3664B.f3587c[i2];
                            if (sampleStream != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (sampleStream != renderer.m2971f()) {
                                    if (renderer == this.f3679l) {
                                        if (sampleStream == null) {
                                            this.f3672e.m4499a(this.f3680m.m3051t());
                                        }
                                        this.f3680m = null;
                                        this.f3679l = null;
                                    }
                                    m4288a(renderer);
                                    renderer.m2976k();
                                } else if (zArr[i2]) {
                                    renderer.m2963a(this.f3678k.f3605c);
                                }
                            }
                        }
                        this.f3670c.m4255a(this.f3664B.f3601q);
                        m4290a(zArr2, i);
                    } else {
                        this.f3666D = exoPlayerImplInternal;
                        ExoPlayerImplInternal exoPlayerImplInternal2 = this.f3666D.f3595k;
                        while (exoPlayerImplInternal2 != null) {
                            exoPlayerImplInternal2.m4237c();
                            exoPlayerImplInternal2 = exoPlayerImplInternal2.f3595k;
                            this.f3663A--;
                        }
                        this.f3666D.f3595k = null;
                        this.f3666D.m4230a(Math.max(0, this.f3691x - this.f3666D.f3594j), this.f3671d, false);
                    }
                    m4312m();
                    m4304e();
                    this.f3673f.sendEmptyMessage(2);
                    return;
                }
                if (exoPlayerImplInternal == this.f3665C) {
                    z = false;
                }
                exoPlayerImplInternal = exoPlayerImplInternal.f3595k;
            }
        }
    }

    private boolean m4303d(boolean z) {
        if (this.f3666D == null) {
            return false;
        }
        long g;
        long j = this.f3691x - this.f3666D.f3594j;
        if (this.f3666D.f3592h) {
            g = this.f3666D.f3585a.m3885g();
        } else {
            g = 0;
        }
        if (g == Long.MIN_VALUE) {
            if (this.f3666D.f3591g) {
                return true;
            }
            g = this.f3667E.m3945a(this.f3666D.f3589e, this.f3677j).m4654b();
        }
        return this.f3671d.m3745a(g - j, z);
    }

    private void m4310k() {
        if (this.f3666D != null && !this.f3666D.f3592h) {
            if (this.f3665C == null || this.f3665C.f3595k == this.f3666D) {
                Renderer[] rendererArr = this.f3682o;
                int length = rendererArr.length;
                int i = 0;
                while (i < length) {
                    if (rendererArr[i].m2972g()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.f3666D.f3585a.m3882c();
            }
        }
    }

    private void m4286a(Pair<Timeline, Object> pair) {
        int i;
        this.f3675h.obtainMessage(5, pair).sendToTarget();
        Timeline timeline = this.f3667E;
        this.f3667E = (Timeline) pair.first;
        if (this.f3664B != null) {
            int a = this.f3667E.m3944a(this.f3664B.f3586b);
            if (a == -1) {
                m4289a(this.f3667E, timeline, this.f3664B.f3589e);
                return;
            }
            this.f3667E.m3946a(a, this.f3677j, true);
            this.f3664B.m4234a(this.f3667E, this.f3667E.m3947a(this.f3677j.f3962c, this.f3676i), a);
            ExoPlayerImplInternal exoPlayerImplInternal = this.f3664B;
            this.f3663A = 0;
            int i2 = a;
            ExoPlayerImplInternal exoPlayerImplInternal2 = exoPlayerImplInternal;
            i = 0;
            ExoPlayerImplInternal exoPlayerImplInternal3 = exoPlayerImplInternal2;
            while (exoPlayerImplInternal3.f3595k != null) {
                ExoPlayerImplInternal exoPlayerImplInternal4 = exoPlayerImplInternal3.f3595k;
                i2++;
                this.f3667E.m3946a(i2, this.f3677j, true);
                if (exoPlayerImplInternal4.f3586b.equals(this.f3677j.f3961b)) {
                    this.f3663A++;
                    exoPlayerImplInternal4.m4234a(this.f3667E, this.f3667E.m3947a(this.f3667E.m3945a(i2, this.f3677j).f3962c, this.f3676i), i2);
                    if (exoPlayerImplInternal4 == this.f3665C) {
                        i = true;
                    }
                    exoPlayerImplInternal3 = exoPlayerImplInternal4;
                } else if (i == 0) {
                    i = this.f3664B.f3589e;
                    m4287a(this.f3664B);
                    this.f3664B = null;
                    this.f3665C = null;
                    this.f3666D = null;
                    long c = m4296c(i, this.f3678k.f3605c);
                    if (c != this.f3678k.f3605c) {
                        this.f3678k = new ExoPlayerImplInternal(i, c);
                        this.f3675h.obtainMessage(4, this.f3678k).sendToTarget();
                        return;
                    }
                    return;
                } else {
                    this.f3666D = exoPlayerImplInternal3;
                    this.f3666D.f3595k = null;
                    m4287a(exoPlayerImplInternal4);
                }
            }
        } else if (this.f3666D != null) {
            i = this.f3667E.m3944a(this.f3666D.f3586b);
            if (i == -1) {
                m4289a(this.f3667E, timeline, this.f3666D.f3589e);
                return;
            }
            this.f3666D.m4234a(this.f3667E, this.f3667E.m3947a(this.f3667E.m3945a(i, this.f3677j).f3962c, this.f3676i), i);
        }
        if (timeline != null) {
            i = this.f3664B != null ? this.f3664B.f3589e : this.f3666D != null ? this.f3666D.f3589e : -1;
            if (i != -1 && i != this.f3678k.f3603a) {
                this.f3678k = new ExoPlayerImplInternal(i, this.f3678k.f3605c);
                m4304e();
                this.f3675h.obtainMessage(4, this.f3678k).sendToTarget();
            }
        }
    }

    private void m4289a(Timeline timeline, Timeline timeline2, int i) {
        int i2 = -1;
        while (i2 == -1 && i < timeline2.m3949b() - 1) {
            i++;
            i2 = timeline.m3944a(timeline2.m3946a(i, this.f3677j, true).f3961b);
        }
        if (i2 == -1) {
            m4306g();
            return;
        }
        m4287a(this.f3664B != null ? this.f3664B : this.f3666D);
        this.f3663A = 0;
        this.f3664B = null;
        this.f3665C = null;
        this.f3666D = null;
        Pair b = m4291b(i2);
        this.f3678k = new ExoPlayerImplInternal(((Integer) b.first).intValue(), ((Long) b.second).longValue());
        this.f3675h.obtainMessage(4, this.f3678k).sendToTarget();
    }

    private Pair<Integer, Long> m4291b(int i) {
        this.f3667E.m3945a(i, this.f3677j);
        this.f3667E.m3947a(this.f3677j.f3962c, this.f3676i);
        int i2 = this.f3676i.f3970f;
        long d = this.f3676i.m4660d() + this.f3676i.m4656a();
        this.f3667E.m3945a(i2, this.f3677j);
        while (i2 < this.f3676i.f3971g && d > this.f3677j.m4652a()) {
            d -= this.f3677j.m4654b();
            int i3 = i2 + 1;
            this.f3667E.m3945a(i2, this.f3677j);
            i2 = i3;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(d));
    }

    private void m4311l() {
        int i = 0;
        if (this.f3667E == null) {
            this.f3681n.m3930a();
            return;
        }
        int i2;
        if (this.f3666D == null || (this.f3666D.m4235a() && !this.f3666D.f3591g && this.f3663A < 100)) {
            i2 = this.f3666D == null ? this.f3678k.f3603a : this.f3666D.f3589e + 1;
            if (i2 >= this.f3667E.m3949b()) {
                this.f3681n.m3930a();
            } else {
                int i3 = this.f3667E.m3945a(i2, this.f3677j).f3962c;
                long j = this.f3666D == null ? this.f3678k.f3605c : i2 == this.f3667E.m3947a(i3, this.f3676i).f3970f ? -9223372036854775807L : 0;
                if (j == -9223372036854775807L) {
                    Pair b = m4291b(i2);
                    int intValue = ((Integer) b.first).intValue();
                    j = ((Long) b.second).longValue();
                    i2 = intValue;
                }
                Object obj = this.f3667E.m3946a(i2, this.f3677j, true).f3961b;
                com.google.android.exoplayer2.p062f.MediaPeriod a = this.f3681n.m3929a(i2, this.f3671d.m3748d(), j);
                a.m3880a(this);
                ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(this.f3668a, this.f3669b, this.f3670c, this.f3681n, a, obj, j);
                this.f3667E.m3947a(i3, this.f3676i);
                exoPlayerImplInternal.m4234a(this.f3667E, this.f3676i, i2);
                if (this.f3666D != null) {
                    this.f3666D.m4233a(exoPlayerImplInternal);
                    exoPlayerImplInternal.f3594j = this.f3666D.f3594j + this.f3667E.m3945a(this.f3666D.f3589e, this.f3677j).m4654b();
                }
                this.f3663A++;
                this.f3666D = exoPlayerImplInternal;
                m4295b(true);
            }
        }
        if (this.f3666D == null || this.f3666D.m4235a()) {
            m4295b(false);
        } else if (this.f3666D != null && this.f3666D.f3596l) {
            m4312m();
        }
        if (this.f3664B != null) {
            while (this.f3664B != this.f3665C && this.f3664B.f3595k != null && this.f3691x >= this.f3664B.f3595k.f3594j) {
                this.f3664B.m4237c();
                m4294b(this.f3664B.f3595k);
                this.f3663A--;
                this.f3678k = new ExoPlayerImplInternal(this.f3664B.f3589e, this.f3664B.f3590f);
                m4304e();
                this.f3675h.obtainMessage(4, this.f3678k).sendToTarget();
            }
            m4313n();
            if (this.f3665C.f3591g) {
                Renderer[] rendererArr = this.f3682o;
                intValue = rendererArr.length;
                while (i < intValue) {
                    rendererArr[i].m2973h();
                    i++;
                }
                return;
            }
            Renderer[] rendererArr2 = this.f3682o;
            int length = rendererArr2.length;
            i2 = 0;
            while (i2 < length) {
                if (rendererArr2[i2].m2972g()) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.f3665C.f3595k != null && this.f3665C.f3595k.f3592h) {
                TrackSelections b2 = this.f3665C.f3601q;
                this.f3665C = this.f3665C.f3595k;
                TrackSelections b3 = this.f3665C.f3601q;
                for (i2 = 0; i2 < this.f3668a.length; i2++) {
                    Renderer renderer = this.f3668a[i2];
                    TrackSelection a2 = b2.m4280a(i2);
                    TrackSelection a3 = b3.m4280a(i2);
                    if (a2 != null) {
                        if (a3 != null) {
                            Format[] formatArr = new Format[a3.m4243b()];
                            for (intValue = 0; intValue < formatArr.length; intValue++) {
                                formatArr[intValue] = a3.m4241a(intValue);
                            }
                            renderer.m2965a(formatArr, this.f3665C.f3587c[i2], this.f3665C.f3594j);
                        } else {
                            renderer.m2973h();
                        }
                    }
                }
            }
        }
    }

    private void m4298c(com.google.android.exoplayer2.p062f.MediaPeriod mediaPeriod) {
        if (this.f3666D != null && this.f3666D.f3585a == mediaPeriod) {
            this.f3666D.m4232a(this.f3666D.f3590f, this.f3671d);
            if (this.f3664B == null) {
                this.f3665C = this.f3666D;
                m4294b(this.f3665C);
                if (this.f3678k.f3604b == -9223372036854775807L) {
                    this.f3678k = new ExoPlayerImplInternal(this.f3664B.f3589e, this.f3664B.f3590f);
                    m4284a(this.f3678k.f3604b);
                    m4304e();
                    this.f3675h.obtainMessage(4, this.f3678k).sendToTarget();
                }
                m4313n();
            }
            m4312m();
        }
    }

    private void m4302d(com.google.android.exoplayer2.p062f.MediaPeriod mediaPeriod) {
        if (this.f3666D != null && this.f3666D.f3585a == mediaPeriod) {
            m4312m();
        }
    }

    private void m4312m() {
        long e = this.f3666D.f3585a.m3878e();
        if (e != Long.MIN_VALUE) {
            long j = this.f3691x - this.f3666D.f3594j;
            boolean a = this.f3671d.m3744a(e - j);
            m4295b(a);
            if (a) {
                this.f3666D.f3596l = false;
                this.f3666D.f3585a.m3877a(j);
                return;
            }
            this.f3666D.f3596l = true;
            return;
        }
        m4295b(false);
    }

    private void m4287a(ExoPlayerImplInternal<T> exoPlayerImplInternal) {
        while (exoPlayerImplInternal != null) {
            exoPlayerImplInternal.m4237c();
            exoPlayerImplInternal = exoPlayerImplInternal.f3595k;
        }
    }

    private void m4294b(ExoPlayerImplInternal<T> exoPlayerImplInternal) {
        boolean[] zArr = new boolean[this.f3668a.length];
        int i = 0;
        for (int i2 = 0; i2 < this.f3668a.length; i2++) {
            boolean z;
            Renderer renderer = this.f3668a[i2];
            if (renderer.m2969d() != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i2] = z;
            if (exoPlayerImplInternal.f3601q.m4280a(i2) != null) {
                i++;
            } else if (zArr[i2]) {
                if (renderer == this.f3679l) {
                    this.f3672e.m4499a(this.f3680m.m3051t());
                    this.f3680m = null;
                    this.f3679l = null;
                }
                m4288a(renderer);
                renderer.m2976k();
            }
        }
        this.f3670c.m4255a(exoPlayerImplInternal.f3601q);
        this.f3664B = exoPlayerImplInternal;
        m4290a(zArr, i);
    }

    private void m4313n() {
        long b = this.f3667E.m3945a(this.f3664B.f3589e, this.f3677j).m4654b();
        boolean z = b == -9223372036854775807L || this.f3678k.f3605c < b || (this.f3664B.f3595k != null && this.f3664B.f3595k.f3592h);
        this.f3692y = z;
        this.f3693z = this.f3664B.f3591g;
    }

    private void m4290a(boolean[] zArr, int i) {
        this.f3682o = new Renderer[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3668a.length; i3++) {
            Renderer renderer = this.f3668a[i3];
            TrackSelection a = this.f3664B.f3601q.m4280a(i3);
            if (a != null) {
                int i4 = i2 + 1;
                this.f3682o[i2] = renderer;
                if (renderer.m2969d() == 0) {
                    boolean z;
                    Object obj = (this.f3684q && this.f3687t == 3) ? 1 : null;
                    if (zArr[i3] || obj == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Format[] formatArr = new Format[a.m4243b()];
                    for (int i5 = 0; i5 < formatArr.length; i5++) {
                        formatArr[i5] = a.m4241a(i5);
                    }
                    renderer.m2966a(formatArr, this.f3664B.f3587c[i3], this.f3691x, z, this.f3664B.f3594j);
                    MediaClock c = renderer.m2968c();
                    if (c != null) {
                        if (this.f3680m != null) {
                            throw ExoPlaybackException.m3799a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.f3680m = c;
                        this.f3679l = renderer;
                    }
                    if (obj != null) {
                        renderer.m2970e();
                    }
                }
                i2 = i4;
            }
        }
    }
}
