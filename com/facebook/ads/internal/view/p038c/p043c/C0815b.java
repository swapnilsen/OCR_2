package com.facebook.ads.internal.view.p038c.p043c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;

@TargetApi(14)
/* renamed from: com.facebook.ads.internal.view.c.c.b */
public class C0815b extends TextureView implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener, SurfaceTextureListener, MediaPlayerControl, C0811c {
    private static final String f1957o;
    private Uri f1958a;
    private C0817e f1959b;
    private Surface f1960c;
    @Nullable
    private MediaPlayer f1961d;
    private MediaController f1962e;
    private C0816d f1963f;
    private C0816d f1964g;
    private View f1965h;
    private int f1966i;
    private long f1967j;
    private int f1968k;
    private int f1969l;
    private float f1970m;
    private boolean f1971n;
    private int f1972p;
    private boolean f1973q;

    /* renamed from: com.facebook.ads.internal.view.c.c.b.1 */
    class C08131 implements OnTouchListener {
        final /* synthetic */ C0815b f1955a;

        C08131(C0815b c0815b) {
            this.f1955a = c0815b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(this.f1955a.f1973q || this.f1955a.f1962e == null || motionEvent.getAction() != 1)) {
                if (this.f1955a.f1962e.isShowing()) {
                    this.f1955a.f1962e.hide();
                } else {
                    this.f1955a.f1962e.show();
                }
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.c.b.2 */
    class C08142 implements OnTouchListener {
        final /* synthetic */ C0815b f1956a;

        C08142(C0815b c0815b) {
            this.f1956a = c0815b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(this.f1956a.f1973q || this.f1956a.f1962e == null || motionEvent.getAction() != 1)) {
                if (this.f1956a.f1962e.isShowing()) {
                    this.f1956a.f1962e.hide();
                } else {
                    this.f1956a.f1962e.show();
                }
            }
            return true;
        }
    }

    static {
        f1957o = C0815b.class.getSimpleName();
    }

    public C0815b(Context context) {
        super(context);
        this.f1963f = C0816d.IDLE;
        this.f1964g = C0816d.IDLE;
        this.f1966i = 0;
        this.f1968k = 0;
        this.f1969l = 0;
        this.f1970m = 1.0f;
        this.f1971n = false;
        this.f1972p = 0;
        this.f1973q = false;
    }

    private boolean m2493a() {
        return this.f1963f == C0816d.PREPARED || this.f1963f == C0816d.STARTED || this.f1963f == C0816d.PAUSED || this.f1963f == C0816d.PLAYBACK_COMPLETED;
    }

    private void setVideoState(C0816d c0816d) {
        if (c0816d != this.f1963f) {
            this.f1963f = c0816d;
            if (this.f1959b != null) {
                this.f1959b.m2500a(c0816d);
            }
        }
    }

    public void m2496a(boolean z) {
        if (this.f1962e != null) {
            this.f1962e.setVisibility(8);
        }
        this.f1973q = true;
    }

    public void m2497c() {
        setVideoState(C0816d.PLAYBACK_COMPLETED);
        m2498d();
        this.f1966i = 0;
    }

    public boolean canPause() {
        return (this.f1963f == C0816d.PREPARING || this.f1963f == C0816d.PREPARED) ? false : true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public void m2498d() {
        this.f1964g = C0816d.IDLE;
        if (this.f1961d != null) {
            int currentPosition = this.f1961d.getCurrentPosition();
            if (currentPosition > 0) {
                this.f1966i = currentPosition;
            }
            this.f1961d.stop();
            this.f1961d.reset();
            this.f1961d.release();
            this.f1961d = null;
            if (this.f1962e != null) {
                this.f1962e.hide();
                this.f1962e.setEnabled(false);
            }
        }
        setVideoState(C0816d.IDLE);
    }

    public int getAudioSessionId() {
        return this.f1961d != null ? this.f1961d.getAudioSessionId() : 0;
    }

    public int getBufferPercentage() {
        return 0;
    }

    public int getCurrentPosition() {
        return this.f1961d != null ? this.f1961d.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return this.f1961d == null ? 0 : this.f1961d.getDuration();
    }

    public long getInitialBufferTime() {
        return this.f1967j;
    }

    public C0816d getState() {
        return this.f1963f;
    }

    public C0816d getTargetState() {
        return this.f1964g;
    }

    public int getVideoHeight() {
        return this.f1969l;
    }

    public int getVideoWidth() {
        return this.f1968k;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f1970m;
    }

    public boolean isPlaying() {
        return this.f1961d != null && this.f1961d.isPlaying();
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f1961d != null) {
            this.f1961d.pause();
        }
        setVideoState(C0816d.PLAYBACK_COMPLETED);
        seekTo(0);
        this.f1966i = 0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        setVideoState(C0816d.ERROR);
        m2498d();
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        switch (i) {
            case 701:
                setVideoState(C0816d.BUFFERING);
                break;
            case 702:
                setVideoState(C0816d.STARTED);
                break;
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = C0815b.getDefaultSize(this.f1968k, i);
        int defaultSize2 = C0815b.getDefaultSize(this.f1969l, i2);
        if (this.f1968k > 0 && this.f1969l > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f1968k * defaultSize2 < this.f1969l * size) {
                    defaultSize = (this.f1968k * defaultSize2) / this.f1969l;
                } else if (this.f1968k * defaultSize2 > this.f1969l * size) {
                    defaultSize2 = (this.f1969l * size) / this.f1968k;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f1969l * size) / this.f1968k;
                if (mode2 != RtlSpacingHelper.UNDEFINED || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f1968k * defaultSize2) / this.f1969l;
                if (mode == RtlSpacingHelper.UNDEFINED && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f1968k;
                defaultSize = this.f1969l;
                if (mode2 != RtlSpacingHelper.UNDEFINED || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f1968k * defaultSize2) / this.f1969l;
                }
                if (mode == RtlSpacingHelper.UNDEFINED && r1 > size) {
                    defaultSize2 = (this.f1969l * size) / this.f1968k;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        setVideoState(C0816d.PREPARED);
        if (this.f1971n) {
            this.f1962e = new MediaController(getContext());
            this.f1962e.setAnchorView(this.f1965h == null ? this : this.f1965h);
            this.f1962e.setMediaPlayer(this);
            this.f1962e.setEnabled(true);
        }
        setRequestedVolume(this.f1970m);
        this.f1968k = mediaPlayer.getVideoWidth();
        this.f1969l = mediaPlayer.getVideoHeight();
        if (this.f1966i > 0) {
            if (this.f1966i >= this.f1961d.getDuration()) {
                this.f1966i = 0;
            }
            this.f1961d.seekTo(this.f1966i);
            this.f1966i = 0;
        }
        if (this.f1964g == C0816d.STARTED) {
            start();
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.f1959b != null) {
            this.f1959b.m2499a(this.f1972p, this.f1966i);
            this.f1966i = 0;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f1960c == null) {
            this.f1960c = new Surface(surfaceTexture);
        }
        if (this.f1961d != null) {
            this.f1961d.setSurface(this.f1960c);
            if (this.f1963f == C0816d.PAUSED && this.f1964g != C0816d.PAUSED) {
                start();
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f1960c != null) {
            this.f1960c.release();
            this.f1960c = null;
        }
        if (this.f1963f != C0816d.PAUSED) {
            this.f1964g = this.f1971n ? C0816d.STARTED : this.f1963f;
            pause();
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f1968k = mediaPlayer.getVideoWidth();
        this.f1969l = mediaPlayer.getVideoHeight();
        if (this.f1968k != 0 && this.f1969l != 0) {
            requestLayout();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f1961d != null) {
            if (z) {
                if (this.f1963f == C0816d.PAUSED && this.f1964g != C0816d.PAUSED) {
                    start();
                }
            } else if (this.f1963f != C0816d.PAUSED) {
                this.f1964g = this.f1971n ? C0816d.STARTED : this.f1963f;
                pause();
            }
        }
    }

    public void pause() {
        if (this.f1961d == null) {
            setVideoState(C0816d.IDLE);
        } else if (canPause()) {
            this.f1961d.pause();
            if (this.f1963f != C0816d.PLAYBACK_COMPLETED) {
                setVideoState(C0816d.PAUSED);
            }
        }
    }

    public void seekTo(int i) {
        if (this.f1961d == null || !m2493a()) {
            this.f1966i = i;
        } else if (i < getDuration() && i > 0) {
            this.f1972p = getCurrentPosition();
            this.f1966i = i;
            this.f1961d.seekTo(i);
        }
    }

    public void setControlsAnchorView(View view) {
        this.f1965h = view;
        view.setOnTouchListener(new C08142(this));
    }

    public void setFullScreen(boolean z) {
        this.f1971n = z;
        if (this.f1971n) {
            setOnTouchListener(new C08131(this));
        }
    }

    public void setRequestedVolume(float f) {
        this.f1970m = f;
        if (this.f1961d != null && this.f1963f != C0816d.PREPARING && this.f1963f != C0816d.IDLE) {
            this.f1961d.setVolume(f, f);
        }
    }

    public void setVideoMPD(String str) {
    }

    public void setVideoStateChangeListener(C0817e c0817e) {
        this.f1959b = c0817e;
    }

    public void setup(Uri uri) {
        MediaPlayer mediaPlayer;
        Object e;
        Throwable th;
        AssetFileDescriptor assetFileDescriptor = null;
        this.f1958a = uri;
        if (this.f1961d != null) {
            this.f1961d.reset();
            this.f1961d.setSurface(null);
            mediaPlayer = this.f1961d;
        } else {
            mediaPlayer = new MediaPlayer();
        }
        try {
            if (uri.getScheme().equals("asset")) {
                try {
                    AssetFileDescriptor openFd = getContext().getAssets().openFd(uri.getPath().substring(1));
                    try {
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        if (openFd != null) {
                            try {
                                openFd.close();
                            } catch (IOException e2) {
                                Log.w(f1957o, "Unable to close" + e2);
                            }
                        }
                    } catch (SecurityException e3) {
                        e = e3;
                        assetFileDescriptor = openFd;
                        try {
                            Log.w(f1957o, "Failed to open assets " + e);
                            setVideoState(C0816d.ERROR);
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                } catch (IOException e22) {
                                    Log.w(f1957o, "Unable to close" + e22);
                                }
                            }
                            mediaPlayer.setLooping(false);
                            mediaPlayer.setOnBufferingUpdateListener(this);
                            mediaPlayer.setOnCompletionListener(this);
                            mediaPlayer.setOnErrorListener(this);
                            mediaPlayer.setOnInfoListener(this);
                            mediaPlayer.setOnPreparedListener(this);
                            mediaPlayer.setOnVideoSizeChangedListener(this);
                            mediaPlayer.setOnSeekCompleteListener(this);
                            mediaPlayer.prepareAsync();
                            this.f1961d = mediaPlayer;
                            setVideoState(C0816d.PREPARING);
                            setSurfaceTextureListener(this);
                            if (isAvailable()) {
                                onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                } catch (IOException e4) {
                                    Log.w(f1957o, "Unable to close" + e4);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        assetFileDescriptor = openFd;
                        Log.w(f1957o, "Failed to open assets " + e);
                        setVideoState(C0816d.ERROR);
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        mediaPlayer.setLooping(false);
                        mediaPlayer.setOnBufferingUpdateListener(this);
                        mediaPlayer.setOnCompletionListener(this);
                        mediaPlayer.setOnErrorListener(this);
                        mediaPlayer.setOnInfoListener(this);
                        mediaPlayer.setOnPreparedListener(this);
                        mediaPlayer.setOnVideoSizeChangedListener(this);
                        mediaPlayer.setOnSeekCompleteListener(this);
                        mediaPlayer.prepareAsync();
                        this.f1961d = mediaPlayer;
                        setVideoState(C0816d.PREPARING);
                        setSurfaceTextureListener(this);
                        if (isAvailable()) {
                            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        assetFileDescriptor = openFd;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        throw th;
                    }
                } catch (SecurityException e6) {
                    e = e6;
                    Log.w(f1957o, "Failed to open assets " + e);
                    setVideoState(C0816d.ERROR);
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnBufferingUpdateListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnVideoSizeChangedListener(this);
                    mediaPlayer.setOnSeekCompleteListener(this);
                    mediaPlayer.prepareAsync();
                    this.f1961d = mediaPlayer;
                    setVideoState(C0816d.PREPARING);
                    setSurfaceTextureListener(this);
                    if (isAvailable()) {
                        onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                    }
                } catch (IOException e7) {
                    e = e7;
                    Log.w(f1957o, "Failed to open assets " + e);
                    setVideoState(C0816d.ERROR);
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnBufferingUpdateListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnVideoSizeChangedListener(this);
                    mediaPlayer.setOnSeekCompleteListener(this);
                    mediaPlayer.prepareAsync();
                    this.f1961d = mediaPlayer;
                    setVideoState(C0816d.PREPARING);
                    setSurfaceTextureListener(this);
                    if (isAvailable()) {
                        onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                    }
                }
            }
            mediaPlayer.setDataSource(getContext(), uri);
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setOnInfoListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnVideoSizeChangedListener(this);
            mediaPlayer.setOnSeekCompleteListener(this);
            mediaPlayer.prepareAsync();
            this.f1961d = mediaPlayer;
            setVideoState(C0816d.PREPARING);
        } catch (Exception e8) {
            setVideoState(C0816d.ERROR);
            mediaPlayer.release();
            Log.e(f1957o, "Cannot prepare media player with SurfaceTexture: " + e8);
        }
        setSurfaceTextureListener(this);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    public void start() {
        this.f1964g = C0816d.STARTED;
        if (this.f1963f == C0816d.STARTED || this.f1963f == C0816d.PREPARED || this.f1963f == C0816d.IDLE || this.f1963f == C0816d.PAUSED || this.f1963f == C0816d.PLAYBACK_COMPLETED) {
            if (this.f1961d == null) {
                setup(this.f1958a);
            } else {
                if (this.f1966i > 0) {
                    this.f1961d.seekTo(this.f1966i);
                }
                this.f1961d.start();
                setVideoState(C0816d.STARTED);
            }
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }
}
