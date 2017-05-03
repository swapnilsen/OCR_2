package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal.ExoPlayerImplInternal;
import com.google.android.exoplayer2.Timeline.Timeline;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p062f.MediaSource;
import com.google.android.exoplayer2.p070h.TrackSelector;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.g */
final class ExoPlayerImpl implements ExoPlayer {
    private final Handler f3570a;
    private final ExoPlayerImplInternal<?> f3571b;
    private final CopyOnWriteArraySet<ExoPlayer> f3572c;
    private final Timeline f3573d;
    private final Timeline f3574e;
    private boolean f3575f;
    private boolean f3576g;
    private int f3577h;
    private int f3578i;
    private boolean f3579j;
    private Timeline f3580k;
    private Object f3581l;
    private ExoPlayerImplInternal f3582m;
    private int f3583n;
    private long f3584o;

    /* renamed from: com.google.android.exoplayer2.g.1 */
    class ExoPlayerImpl extends Handler {
        final /* synthetic */ ExoPlayerImpl f3408a;

        ExoPlayerImpl(ExoPlayerImpl exoPlayerImpl) {
            this.f3408a = exoPlayerImpl;
        }

        public void handleMessage(Message message) {
            this.f3408a.m4211a(message);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector<?> trackSelector, LoadControl loadControl) {
        Log.i("ExoPlayerImpl", "Init 2.0.3");
        Assertions.m4402a((Object) rendererArr);
        Assertions.m4406b(rendererArr.length > 0);
        this.f3576g = false;
        this.f3577h = 1;
        this.f3572c = new CopyOnWriteArraySet();
        this.f3573d = new Timeline();
        this.f3574e = new Timeline();
        this.f3570a = new ExoPlayerImpl(this);
        this.f3582m = new ExoPlayerImplInternal(0, 0);
        this.f3571b = new ExoPlayerImplInternal(rendererArr, trackSelector, loadControl, this.f3576g, this.f3570a, this.f3582m);
    }

    public void m4212a(ExoPlayer exoPlayer) {
        this.f3572c.add(exoPlayer);
    }

    public void m4217b(ExoPlayer exoPlayer) {
        this.f3572c.remove(exoPlayer);
    }

    public int m4207a() {
        return this.f3577h;
    }

    public void m4213a(MediaSource mediaSource) {
        m4214a(mediaSource, true, true);
    }

    public void m4214a(MediaSource mediaSource, boolean z, boolean z2) {
        if (z2 && !(this.f3580k == null && this.f3581l == null)) {
            this.f3580k = null;
            this.f3581l = null;
            Iterator it = this.f3572c.iterator();
            while (it.hasNext()) {
                ((ExoPlayer) it.next()).m2471a(null, null);
            }
        }
        this.f3571b.m4317a(mediaSource, z);
    }

    public void m4215a(boolean z) {
        if (this.f3576g != z) {
            this.f3576g = z;
            this.f3571b.m4320a(z);
            Iterator it = this.f3572c.iterator();
            while (it.hasNext()) {
                ((ExoPlayer) it.next()).m2472a(z, this.f3577h);
            }
        }
    }

    public boolean m4219b() {
        return this.f3576g;
    }

    public void m4220c() {
        m4208a(m4224g());
    }

    public void m4208a(int i) {
        if (this.f3580k == null) {
            this.f3583n = i;
            this.f3584o = -9223372036854775807L;
            this.f3575f = true;
            return;
        }
        Assertions.m4401a(i, 0, this.f3580k.m3943a());
        this.f3578i++;
        this.f3583n = i;
        this.f3584o = 0;
        this.f3571b.m4315a(this.f3580k.m3947a(i, this.f3573d).f3970f, -9223372036854775807L);
    }

    public void m4210a(long j) {
        m4209a(m4224g(), j);
    }

    public void m4209a(int i, long j) {
        if (j == -9223372036854775807L) {
            m4208a(i);
        } else if (this.f3580k == null) {
            this.f3583n = i;
            this.f3584o = j;
            this.f3575f = true;
        } else {
            Assertions.m4401a(i, 0, this.f3580k.m3943a());
            this.f3578i++;
            this.f3583n = i;
            this.f3584o = j;
            this.f3580k.m3947a(i, this.f3573d);
            int i2 = this.f3573d.f3970f;
            long c = this.f3573d.m4659c() + j;
            long a = this.f3580k.m3945a(i2, this.f3574e).m4652a();
            while (a != -9223372036854775807L && c >= a && i2 < this.f3573d.f3971g) {
                c -= a;
                i2++;
                a = this.f3580k.m3945a(i2, this.f3574e).m4652a();
            }
            this.f3571b.m4315a(i2, C.m3115b(c));
            Iterator it = this.f3572c.iterator();
            while (it.hasNext()) {
                ((ExoPlayer) it.next()).m2474e();
            }
        }
    }

    public void m4221d() {
        this.f3571b.m4314a();
    }

    public void m4222e() {
        this.f3571b.m4322b();
        this.f3570a.removeCallbacksAndMessages(null);
    }

    public void m4216a(ExoPlayer... exoPlayerArr) {
        this.f3571b.m4321a(exoPlayerArr);
    }

    public void m4218b(ExoPlayer... exoPlayerArr) {
        this.f3571b.m4324b(exoPlayerArr);
    }

    public int m4224g() {
        if (this.f3580k == null || this.f3578i > 0) {
            return this.f3583n;
        }
        return this.f3580k.m3945a(this.f3582m.f3603a, this.f3574e).f3962c;
    }

    public long m4225h() {
        if (this.f3580k == null) {
            return -9223372036854775807L;
        }
        return this.f3580k.m3947a(m4224g(), this.f3573d).m4658b();
    }

    public long m4226i() {
        if (this.f3580k == null || this.f3578i > 0) {
            return this.f3584o;
        }
        this.f3580k.m3945a(this.f3582m.f3603a, this.f3574e);
        return this.f3574e.m4655c() + C.m3114a(this.f3582m.f3605c);
    }

    public long m4227j() {
        if (this.f3580k == null || this.f3578i > 0) {
            return this.f3584o;
        }
        this.f3580k.m3945a(this.f3582m.f3603a, this.f3574e);
        return this.f3574e.m4655c() + C.m3114a(this.f3582m.f3606d);
    }

    public int m4228k() {
        long j = 100;
        if (this.f3580k == null) {
            return 0;
        }
        int i;
        long j2 = m4227j();
        long h = m4225h();
        if (j2 == -9223372036854775807L || h == -9223372036854775807L) {
            i = 0;
        } else {
            if (h != 0) {
                j = (100 * j2) / h;
            }
            i = (int) j;
        }
        return i;
    }

    public Timeline m4223f() {
        return this.f3580k;
    }

    void m4211a(Message message) {
        Iterator it;
        switch (message.what) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                this.f3577h = message.arg1;
                it = this.f3572c.iterator();
                while (it.hasNext()) {
                    ((ExoPlayer) it.next()).m2472a(this.f3576g, this.f3577h);
                }
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                boolean z;
                if (message.arg1 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f3579j = z;
                it = this.f3572c.iterator();
                while (it.hasNext()) {
                    ((ExoPlayer) it.next()).m2473b(this.f3579j);
                }
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                int i = this.f3578i - 1;
                this.f3578i = i;
                if (i == 0) {
                    this.f3582m = (ExoPlayerImplInternal) message.obj;
                    it = this.f3572c.iterator();
                    while (it.hasNext()) {
                        ((ExoPlayer) it.next()).m2474e();
                    }
                }
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                if (this.f3578i == 0) {
                    this.f3582m = (ExoPlayerImplInternal) message.obj;
                    it = this.f3572c.iterator();
                    while (it.hasNext()) {
                        ((ExoPlayer) it.next()).m2474e();
                    }
                }
            case Type.OTHER_PROFILE /*5*/:
                Pair pair = (Pair) message.obj;
                this.f3580k = (Timeline) pair.first;
                this.f3581l = pair.second;
                if (this.f3575f) {
                    this.f3575f = false;
                    m4209a(this.f3583n, this.f3584o);
                }
                it = this.f3572c.iterator();
                while (it.hasNext()) {
                    ((ExoPlayer) it.next()).m2471a(this.f3580k, this.f3581l);
                }
            case Type.CONTRIBUTOR /*6*/:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator it2 = this.f3572c.iterator();
                while (it2.hasNext()) {
                    ((ExoPlayer) it2.next()).m2470a(exoPlaybackException);
                }
            default:
        }
    }
}
