package com.facebook.ads.internal.view.p038c.p043c;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.facebook.ads.C0441e;
import com.facebook.ads.internal.p021m.C0705p;
import com.facebook.ads.internal.p021m.C0706q;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.DefaultExtractorsFactory;
import com.google.android.exoplayer2.p062f.ExtractorMediaSource;
import com.google.android.exoplayer2.p063i.DefaultBandwidthMeter;
import com.google.android.exoplayer2.p063i.DefaultDataSourceFactory;
import com.google.android.exoplayer2.p063i.TransferListener;
import com.google.android.exoplayer2.p070h.AdaptiveVideoTrackSelection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.p070h.DefaultTrackSelector;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

@TargetApi(14)
/* renamed from: com.facebook.ads.internal.view.c.c.a */
public class C0812a extends TextureView implements SurfaceTextureListener, C0811c, ExoPlayer, SimpleExoPlayer {
    private static final String f1935a;
    private Uri f1936b;
    private String f1937c;
    private C0817e f1938d;
    private Handler f1939e;
    private Surface f1940f;
    @Nullable
    private com.google.android.exoplayer2.SimpleExoPlayer f1941g;
    private MediaController f1942h;
    private C0816d f1943i;
    private C0816d f1944j;
    private View f1945k;
    private boolean f1946l;
    private boolean f1947m;
    private long f1948n;
    private long f1949o;
    private long f1950p;
    private int f1951q;
    private int f1952r;
    private float f1953s;
    private int f1954t;

    /* renamed from: com.facebook.ads.internal.view.c.c.a.1 */
    class C08081 implements MediaPlayerControl {
        final /* synthetic */ C0812a f1932a;

        C08081(C0812a c0812a) {
            this.f1932a = c0812a;
        }

        public boolean canPause() {
            return true;
        }

        public boolean canSeekBackward() {
            return true;
        }

        public boolean canSeekForward() {
            return true;
        }

        public int getAudioSessionId() {
            return this.f1932a.f1941g.m4651l();
        }

        public int getBufferPercentage() {
            return this.f1932a.f1941g.m4650k();
        }

        public int getCurrentPosition() {
            return this.f1932a.getCurrentPosition();
        }

        public int getDuration() {
            return this.f1932a.getDuration();
        }

        public boolean isPlaying() {
            return this.f1932a.f1941g.m4641b();
        }

        public void pause() {
            this.f1932a.pause();
        }

        public void seekTo(int i) {
            this.f1932a.seekTo(i);
        }

        public void start() {
            this.f1932a.start();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.c.a.2 */
    class C08092 implements OnTouchListener {
        final /* synthetic */ C0812a f1933a;

        C08092(C0812a c0812a) {
            this.f1933a = c0812a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1933a.f1942h != null && motionEvent.getAction() == 1) {
                if (this.f1933a.f1942h.isShowing()) {
                    this.f1933a.f1942h.hide();
                } else {
                    this.f1933a.f1942h.show();
                }
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.c.a.3 */
    class C08103 implements OnTouchListener {
        final /* synthetic */ C0812a f1934a;

        C08103(C0812a c0812a) {
            this.f1934a = c0812a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1934a.f1942h != null && motionEvent.getAction() == 1) {
                if (this.f1934a.f1942h.isShowing()) {
                    this.f1934a.f1942h.hide();
                } else {
                    this.f1934a.f1942h.show();
                }
            }
            return true;
        }
    }

    static {
        f1935a = C0812a.class.getSimpleName();
    }

    public C0812a(Context context) {
        super(context);
        this.f1943i = C0816d.IDLE;
        this.f1944j = C0816d.IDLE;
        this.f1946l = false;
        this.f1947m = false;
        this.f1953s = 1.0f;
        this.f1954t = -1;
        this.f1939e = new Handler();
    }

    private void m2480f() {
        TransferListener defaultBandwidthMeter = new DefaultBandwidthMeter();
        this.f1941g = ExoPlayerFactory.m3959a(getContext(), new DefaultTrackSelector(this.f1939e, new AdaptiveVideoTrackSelection(defaultBandwidthMeter)), new DefaultLoadControl());
        this.f1941g.m4636a((SimpleExoPlayer) this);
        this.f1941g.m4634a((ExoPlayer) this);
        this.f1941g.m4637a(false);
        if (this.f1947m) {
            this.f1942h = new MediaController(getContext());
            this.f1942h.setAnchorView(this.f1945k == null ? this : this.f1945k);
            this.f1942h.setMediaPlayer(new C08081(this));
            this.f1942h.setEnabled(true);
        }
        if (this.f1937c == null || this.f1937c.length() <= 0 || C0441e.m1055a(getContext())) {
            this.f1941g.m4635a(new ExtractorMediaSource(this.f1936b, new DefaultDataSourceFactory(getContext(), Util.m4511a(getContext(), "ads"), defaultBandwidthMeter), new DefaultExtractorsFactory(), null, null));
        }
        setVideoState(C0816d.PREPARING);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    private void m2481g() {
        if (this.f1940f != null) {
            this.f1940f.release();
            this.f1940f = null;
        }
        if (this.f1941g != null) {
            this.f1941g.m4644e();
            this.f1941g = null;
        }
        this.f1942h = null;
        this.f1946l = false;
        setVideoState(C0816d.IDLE);
    }

    private void setVideoState(C0816d c0816d) {
        if (c0816d != this.f1943i) {
            this.f1943i = c0816d;
            if (this.f1943i == C0816d.STARTED) {
                this.f1946l = true;
            }
            if (this.f1938d != null) {
                this.f1938d.m2500a(c0816d);
            }
        }
    }

    public void m2482a() {
    }

    public void m2483a(int i, int i2, int i3, float f) {
        this.f1951q = i;
        this.f1952r = i2;
        if (this.f1951q != 0 && this.f1952r != 0) {
            requestLayout();
        }
    }

    public void m2484a(ExoPlaybackException exoPlaybackException) {
        setVideoState(C0816d.ERROR);
        exoPlaybackException.printStackTrace();
        C0706q.m2279a(C0705p.m2276a(exoPlaybackException, "[ExoPlayer] Error during playback of ExoPlayer"));
    }

    public void m2485a(Timeline timeline, Object obj) {
    }

    public void m2486a(boolean z) {
    }

    public void m2487a(boolean z, int i) {
        switch (i) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                setVideoState(C0816d.IDLE);
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                if (this.f1954t >= 0) {
                    int i2 = this.f1954t;
                    this.f1954t = -1;
                    this.f1938d.m2499a(i2, getCurrentPosition());
                }
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                if (this.f1948n != 0) {
                    this.f1949o = System.currentTimeMillis() - this.f1948n;
                }
                setRequestedVolume(this.f1953s);
                if (this.f1950p > 0 && this.f1950p < this.f1941g.m4647h()) {
                    this.f1941g.m4632a(this.f1950p);
                    this.f1950p = 0;
                }
                if (this.f1941g.m4648i() != 0 && !z && this.f1946l) {
                    setVideoState(C0816d.PAUSED);
                } else if (!z && this.f1943i != C0816d.PLAYBACK_COMPLETED) {
                    setVideoState(C0816d.PREPARED);
                    if (this.f1944j == C0816d.STARTED) {
                        start();
                        this.f1944j = C0816d.IDLE;
                    }
                }
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                if (z) {
                    setVideoState(C0816d.PLAYBACK_COMPLETED);
                }
                if (this.f1941g != null) {
                    this.f1941g.m4637a(false);
                    if (!z) {
                        this.f1941g.m4642c();
                    }
                }
                this.f1946l = false;
            default:
        }
    }

    public void m2488b() {
    }

    public void m2489b(boolean z) {
    }

    public void m2490c() {
        setVideoState(C0816d.PLAYBACK_COMPLETED);
    }

    public void m2491d() {
        this.f1944j = C0816d.IDLE;
        if (this.f1941g != null) {
            this.f1941g.m4643d();
            this.f1941g.m4644e();
            this.f1941g = null;
        }
        setVideoState(C0816d.IDLE);
    }

    public void m2492e() {
    }

    public int getCurrentPosition() {
        return this.f1941g != null ? (int) this.f1941g.m4648i() : 0;
    }

    public int getDuration() {
        return this.f1941g == null ? 0 : (int) this.f1941g.m4647h();
    }

    public long getInitialBufferTime() {
        return this.f1949o;
    }

    public C0816d getState() {
        return this.f1943i;
    }

    public C0816d getTargetState() {
        return this.f1944j;
    }

    public int getVideoHeight() {
        return this.f1952r;
    }

    public int getVideoWidth() {
        return this.f1951q;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f1953s;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = C0812a.getDefaultSize(this.f1951q, i);
        int defaultSize2 = C0812a.getDefaultSize(this.f1952r, i2);
        if (this.f1951q > 0 && this.f1952r > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f1951q * defaultSize2 < this.f1952r * size) {
                    defaultSize = (this.f1951q * defaultSize2) / this.f1952r;
                } else if (this.f1951q * defaultSize2 > this.f1952r * size) {
                    defaultSize2 = (this.f1952r * size) / this.f1951q;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f1952r * size) / this.f1951q;
                if (mode2 != RtlSpacingHelper.UNDEFINED || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f1951q * defaultSize2) / this.f1952r;
                if (mode == RtlSpacingHelper.UNDEFINED && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f1951q;
                defaultSize = this.f1952r;
                if (mode2 != RtlSpacingHelper.UNDEFINED || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f1951q * defaultSize2) / this.f1952r;
                }
                if (mode == RtlSpacingHelper.UNDEFINED && r1 > size) {
                    defaultSize2 = (this.f1952r * size) / this.f1951q;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f1940f = new Surface(surfaceTexture);
        if (this.f1940f == null) {
            this.f1940f = new Surface(surfaceTexture);
        }
        if (this.f1941g != null) {
            this.f1941g.m4633a(this.f1940f);
            if (this.f1943i == C0816d.PAUSED && this.f1944j != C0816d.PAUSED) {
                start();
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f1940f != null) {
            this.f1940f.release();
            this.f1940f = null;
            if (this.f1941g != null) {
                this.f1941g.m4633a(null);
            }
        }
        if (this.f1943i != C0816d.PAUSED) {
            this.f1944j = this.f1947m ? C0816d.STARTED : this.f1943i;
            pause();
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f1941g != null) {
            if (z) {
                if (this.f1943i == C0816d.PAUSED && this.f1944j != C0816d.PAUSED) {
                    start();
                }
            } else if (this.f1943i != C0816d.PAUSED) {
                this.f1944j = this.f1947m ? C0816d.STARTED : this.f1943i;
                pause();
            }
        }
    }

    public void pause() {
        if (this.f1941g != null) {
            this.f1941g.m4637a(false);
        } else {
            setVideoState(C0816d.IDLE);
        }
    }

    public void seekTo(int i) {
        if (this.f1941g != null) {
            this.f1954t = getCurrentPosition();
            this.f1941g.m4632a((long) i);
            return;
        }
        this.f1950p = (long) i;
    }

    public void setControlsAnchorView(View view) {
        this.f1945k = view;
        view.setOnTouchListener(new C08103(this));
    }

    public void setFullScreen(boolean z) {
        this.f1947m = z;
        if (z) {
            setOnTouchListener(new C08092(this));
        }
    }

    public void setRequestedVolume(float f) {
        this.f1953s = f;
        if (this.f1941g != null && this.f1943i != C0816d.PREPARING && this.f1943i != C0816d.IDLE) {
            this.f1941g.m4630a(f);
        }
    }

    public void setVideoMPD(String str) {
        this.f1937c = str;
    }

    public void setVideoStateChangeListener(C0817e c0817e) {
        this.f1938d = c0817e;
    }

    public void setup(Uri uri) {
        if (!(this.f1941g == null || this.f1943i == C0816d.PLAYBACK_COMPLETED)) {
            m2481g();
        }
        this.f1936b = uri;
        setSurfaceTextureListener(this);
        m2480f();
    }

    public void start() {
        this.f1944j = C0816d.STARTED;
        if (this.f1941g == null) {
            setup(this.f1936b);
        } else if (this.f1943i == C0816d.PREPARED || this.f1943i == C0816d.PAUSED || this.f1943i == C0816d.PLAYBACK_COMPLETED) {
            this.f1941g.m4637a(true);
            setVideoState(C0816d.STARTED);
        }
    }
}
