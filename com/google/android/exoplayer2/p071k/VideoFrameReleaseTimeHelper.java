package com.google.android.exoplayer2.p071k;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.k.d */
public final class VideoFrameReleaseTimeHelper {
    private final VideoFrameReleaseTimeHelper f3904a;
    private final boolean f3905b;
    private final long f3906c;
    private final long f3907d;
    private long f3908e;
    private long f3909f;
    private long f3910g;
    private boolean f3911h;
    private long f3912i;
    private long f3913j;
    private long f3914k;

    /* renamed from: com.google.android.exoplayer2.k.d.a */
    private static final class VideoFrameReleaseTimeHelper implements Callback, FrameCallback {
        private static final VideoFrameReleaseTimeHelper f3898b;
        public volatile long f3899a;
        private final Handler f3900c;
        private final HandlerThread f3901d;
        private Choreographer f3902e;
        private int f3903f;

        static {
            f3898b = new VideoFrameReleaseTimeHelper();
        }

        public static VideoFrameReleaseTimeHelper m4565a() {
            return f3898b;
        }

        private VideoFrameReleaseTimeHelper() {
            this.f3901d = new HandlerThread("ChoreographerOwner:Handler");
            this.f3901d.start();
            this.f3900c = new Handler(this.f3901d.getLooper(), this);
            this.f3900c.sendEmptyMessage(0);
        }

        public void m4569b() {
            this.f3900c.sendEmptyMessage(1);
        }

        public void m4570c() {
            this.f3900c.sendEmptyMessage(2);
        }

        public void doFrame(long j) {
            this.f3899a = j;
            this.f3902e.postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    m4566d();
                    return true;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    m4567e();
                    return true;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    m4568f();
                    return true;
                default:
                    return false;
            }
        }

        private void m4566d() {
            this.f3902e = Choreographer.getInstance();
        }

        private void m4567e() {
            this.f3903f++;
            if (this.f3903f == 1) {
                this.f3902e.postFrameCallback(this);
            }
        }

        private void m4568f() {
            this.f3903f--;
            if (this.f3903f == 0) {
                this.f3902e.removeFrameCallback(this);
                this.f3899a = 0;
            }
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this(-1.0d, false);
    }

    public VideoFrameReleaseTimeHelper(Context context) {
        this((double) VideoFrameReleaseTimeHelper.m4571a(context), true);
    }

    private VideoFrameReleaseTimeHelper(double d, boolean z) {
        this.f3905b = z;
        if (z) {
            this.f3904a = VideoFrameReleaseTimeHelper.m4565a();
            this.f3906c = (long) (1.0E9d / d);
            this.f3907d = (this.f3906c * 80) / 100;
            return;
        }
        this.f3904a = null;
        this.f3906c = -1;
        this.f3907d = -1;
    }

    public void m4575a() {
        this.f3911h = false;
        if (this.f3905b) {
            this.f3904a.m4569b();
        }
    }

    public void m4576b() {
        if (this.f3905b) {
            this.f3904a.m4570c();
        }
    }

    public long m4574a(long j, long j2) {
        long j3;
        long j4;
        long j5 = j * 1000;
        if (this.f3911h) {
            if (j != this.f3908e) {
                this.f3914k++;
                this.f3909f = this.f3910g;
            }
            if (this.f3914k >= 6) {
                j3 = this.f3909f + ((j5 - this.f3913j) / this.f3914k);
                if (m4573b(j3, j2)) {
                    this.f3911h = false;
                    j4 = j2;
                    j3 = j5;
                } else {
                    j4 = (this.f3912i + j3) - this.f3913j;
                }
                if (!this.f3911h) {
                    this.f3913j = j5;
                    this.f3912i = j2;
                    this.f3914k = 0;
                    this.f3911h = true;
                    m4577c();
                }
                this.f3908e = j;
                this.f3910g = j3;
                return (this.f3904a == null || this.f3904a.f3899a == 0) ? j4 : VideoFrameReleaseTimeHelper.m4572a(j4, this.f3904a.f3899a, this.f3906c) - this.f3907d;
            } else if (m4573b(j5, j2)) {
                this.f3911h = false;
            }
        }
        j4 = j2;
        j3 = j5;
        if (this.f3911h) {
            this.f3913j = j5;
            this.f3912i = j2;
            this.f3914k = 0;
            this.f3911h = true;
            m4577c();
        }
        this.f3908e = j;
        this.f3910g = j3;
        if (this.f3904a == null) {
            return j4;
        }
    }

    protected void m4577c() {
    }

    private boolean m4573b(long j, long j2) {
        return Math.abs((j2 - this.f3912i) - (j - this.f3913j)) > 20000000;
    }

    private static long m4572a(long j, long j2, long j3) {
        long j4;
        long j5 = (((j - j2) / j3) * j3) + j2;
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j4 = j5;
            j5 += j3;
        }
        if (j5 - j < j - j4) {
            return j5;
        }
        return j4;
    }

    private static float m4571a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }
}
