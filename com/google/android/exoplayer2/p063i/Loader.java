package com.google.android.exoplayer2.p063i;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.TraceUtil;
import com.google.android.exoplayer2.p050j.Util;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.i.q */
public final class Loader {
    private final ExecutorService f3788a;
    private Loader<? extends Loader> f3789b;
    private IOException f3790c;

    /* renamed from: com.google.android.exoplayer2.i.q.c */
    public interface Loader {
        void m3858a();

        boolean m3859b();

        void m3860c();
    }

    /* renamed from: com.google.android.exoplayer2.i.q.a */
    public interface Loader<T extends Loader> {
        int m3886a(T t, long j, long j2, IOException iOException);

        void m3887a(T t, long j, long j2);

        void m3888a(T t, long j, long j2, boolean z);
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.exoplayer2.i.q.b */
    private final class Loader<T extends Loader> extends Handler implements Runnable {
        public final int f3779a;
        final /* synthetic */ Loader f3780b;
        private final T f3781c;
        private final Loader<T> f3782d;
        private final long f3783e;
        private IOException f3784f;
        private int f3785g;
        private volatile Thread f3786h;
        private volatile boolean f3787i;

        public Loader(Loader loader, Looper looper, T t, Loader<T> loader2, int i, long j) {
            this.f3780b = loader;
            super(looper);
            this.f3781c = t;
            this.f3782d = loader2;
            this.f3779a = i;
            this.f3783e = j;
        }

        public void m4388a(int i) {
            if (this.f3784f != null && this.f3785g > i) {
                throw this.f3784f;
            }
        }

        public void m4389a(long j) {
            Assertions.m4406b(this.f3780b.f3789b == null);
            this.f3780b.f3789b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                m4385a();
            }
        }

        public void m4390a(boolean z) {
            this.f3787i = z;
            this.f3784f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f3781c.m3858a();
                if (this.f3786h != null) {
                    this.f3786h.interrupt();
                }
            }
            if (z) {
                m4386b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f3782d.m3888a(this.f3781c, elapsedRealtime, elapsedRealtime - this.f3783e, true);
            }
        }

        public void run() {
            try {
                this.f3786h = Thread.currentThread();
                if (!this.f3781c.m3859b()) {
                    TraceUtil.m4503a("load:" + this.f3781c.getClass().getSimpleName());
                    this.f3781c.m3860c();
                    TraceUtil.m4502a();
                }
                if (!this.f3787i) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e) {
                if (!this.f3787i) {
                    obtainMessage(3, e).sendToTarget();
                }
            } catch (InterruptedException e2) {
                Assertions.m4406b(this.f3781c.m3859b());
                if (!this.f3787i) {
                    sendEmptyMessage(2);
                }
            } catch (Throwable e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.f3787i) {
                    obtainMessage(3, new Loader(e3)).sendToTarget();
                }
            } catch (Throwable e32) {
                Log.e("LoadTask", "Unexpected error loading stream", e32);
                if (!this.f3787i) {
                    obtainMessage(4, e32).sendToTarget();
                }
                throw e32;
            } catch (Throwable th) {
                TraceUtil.m4502a();
            }
        }

        public void handleMessage(Message message) {
            if (!this.f3787i) {
                if (message.what == 0) {
                    m4385a();
                } else if (message.what == 4) {
                    throw ((Error) message.obj);
                } else {
                    m4386b();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.f3783e;
                    if (this.f3781c.m3859b()) {
                        this.f3782d.m3888a(this.f3781c, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case NendIconError.ERROR_ICONVIEW /*1*/:
                            this.f3782d.m3888a(this.f3781c, elapsedRealtime, j, false);
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            this.f3782d.m3887a(this.f3781c, elapsedRealtime, j);
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            this.f3784f = (IOException) message.obj;
                            int a = this.f3782d.m3886a(this.f3781c, elapsedRealtime, j, this.f3784f);
                            if (a == 3) {
                                this.f3780b.f3790c = this.f3784f;
                            } else if (a != 2) {
                                if (a == 1) {
                                    a = 1;
                                } else {
                                    a = this.f3785g + 1;
                                }
                                this.f3785g = a;
                                m4389a(m4387c());
                            }
                        default:
                    }
                }
            }
        }

        private void m4385a() {
            this.f3784f = null;
            this.f3780b.f3788a.submit(this.f3780b.f3789b);
        }

        private void m4386b() {
            this.f3780b.f3789b = null;
        }

        private long m4387c() {
            return (long) Math.min((this.f3785g - 1) * PointerIconCompat.TYPE_DEFAULT, 5000);
        }
    }

    /* renamed from: com.google.android.exoplayer2.i.q.d */
    public static final class Loader extends IOException {
        public Loader(Exception exception) {
            super("Unexpected " + exception.getClass().getSimpleName() + ": " + exception.getMessage(), exception);
        }
    }

    public Loader(String str) {
        this.f3788a = Util.m4514a(str);
    }

    public <T extends Loader> long m4395a(T t, Loader<T> loader, int i) {
        Looper myLooper = Looper.myLooper();
        Assertions.m4406b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new Loader(this, myLooper, t, loader, i, elapsedRealtime).m4389a(0);
        return elapsedRealtime;
    }

    public boolean m4398a() {
        return this.f3789b != null;
    }

    public void m4399b() {
        this.f3789b.m4390a(false);
    }

    public void m4397a(Runnable runnable) {
        if (this.f3789b != null) {
            this.f3789b.m4390a(true);
        }
        if (runnable != null) {
            this.f3788a.submit(runnable);
        }
        this.f3788a.shutdown();
    }

    public void m4400c() {
        m4396a((int) RtlSpacingHelper.UNDEFINED);
    }

    public void m4396a(int i) {
        if (this.f3790c != null) {
            throw this.f3790c;
        } else if (this.f3789b != null) {
            Loader loader = this.f3789b;
            if (i == RtlSpacingHelper.UNDEFINED) {
                i = this.f3789b.f3779a;
            }
            loader.m4388a(i);
        }
    }
}
