package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.p048a.AudioCapabilities;
import com.google.android.exoplayer2.p048a.AudioRendererEventListener;
import com.google.android.exoplayer2.p048a.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.p049d.MediaCodecSelector;
import com.google.android.exoplayer2.p051b.DecoderCounters;
import com.google.android.exoplayer2.p060e.MetadataRenderer.MetadataRenderer;
import com.google.android.exoplayer2.p060e.p061a.Id3Decoder;
import com.google.android.exoplayer2.p060e.p061a.Id3Frame;
import com.google.android.exoplayer2.p062f.MediaSource;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.TextRenderer.TextRenderer;
import com.google.android.exoplayer2.p070h.TrackSelections;
import com.google.android.exoplayer2.p070h.TrackSelector.TrackSelector;
import com.google.android.exoplayer2.p071k.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.p071k.VideoRendererEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import net.nend.android.NendIconError;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.o */
public final class SimpleExoPlayer implements ExoPlayer {
    private final ExoPlayer f3938a;
    private final Renderer[] f3939b;
    private final SimpleExoPlayer f3940c;
    private final Handler f3941d;
    private final int f3942e;
    private final int f3943f;
    private boolean f3944g;
    private Format f3945h;
    private Format f3946i;
    private Surface f3947j;
    private boolean f3948k;
    private SurfaceHolder f3949l;
    private TextureView f3950m;
    private TextRenderer f3951n;
    private MetadataRenderer<List<Id3Frame>> f3952o;
    private SimpleExoPlayer f3953p;
    private AudioRendererEventListener f3954q;
    private VideoRendererEventListener f3955r;
    private DecoderCounters f3956s;
    private DecoderCounters f3957t;
    private int f3958u;
    private float f3959v;

    /* renamed from: com.google.android.exoplayer2.o.b */
    public interface SimpleExoPlayer {
        void m2475a();

        void m2476a(int i, int i2, int i3, float f);

        void m2477b();
    }

    /* renamed from: com.google.android.exoplayer2.o.a */
    private final class SimpleExoPlayer implements Callback, SurfaceTextureListener, AudioRendererEventListener, MetadataRenderer<List<Id3Frame>>, TextRenderer, TrackSelector<Object>, VideoRendererEventListener {
        final /* synthetic */ SimpleExoPlayer f3937a;

        private SimpleExoPlayer(SimpleExoPlayer simpleExoPlayer) {
            this.f3937a = simpleExoPlayer;
        }

        public /* synthetic */ void m4601a(Object obj) {
            m4607b((List) obj);
        }

        public void m4599a(DecoderCounters decoderCounters) {
            this.f3937a.f3956s = decoderCounters;
            if (this.f3937a.f3955r != null) {
                this.f3937a.f3955r.m4590a(decoderCounters);
            }
        }

        public void m4602a(String str, long j, long j2) {
            if (this.f3937a.f3955r != null) {
                this.f3937a.f3955r.m4591a(str, j, j2);
            }
        }

        public void m4598a(Format format) {
            this.f3937a.f3945h = format;
            if (this.f3937a.f3955r != null) {
                this.f3937a.f3955r.m4589a(format);
            }
        }

        public void m4595a(int i, long j) {
            if (this.f3937a.f3955r != null) {
                this.f3937a.f3955r.m4587a(i, j);
            }
        }

        public void m4594a(int i, int i2, int i3, float f) {
            if (this.f3937a.f3953p != null) {
                this.f3937a.f3953p.m2476a(i, i2, i3, f);
            }
            if (this.f3937a.f3955r != null) {
                this.f3937a.f3955r.m4586a(i, i2, i3, f);
            }
        }

        public void m4597a(Surface surface) {
            if (this.f3937a.f3953p != null && this.f3937a.f3947j == surface) {
                this.f3937a.f3953p.m2475a();
            }
            if (this.f3937a.f3955r != null) {
                this.f3937a.f3955r.m4588a(surface);
            }
        }

        public void m4605b(DecoderCounters decoderCounters) {
            if (this.f3937a.f3955r != null) {
                this.f3937a.f3955r.m4592b(decoderCounters);
            }
            this.f3937a.f3945h = null;
            this.f3937a.f3956s = null;
        }

        public void m4608c(DecoderCounters decoderCounters) {
            this.f3937a.f3957t = decoderCounters;
            if (this.f3937a.f3954q != null) {
                this.f3937a.f3954q.m2900c(decoderCounters);
            }
        }

        public void m4593a(int i) {
            this.f3937a.f3958u = i;
            if (this.f3937a.f3954q != null) {
                this.f3937a.f3954q.m2896a(i);
            }
        }

        public void m4606b(String str, long j, long j2) {
            if (this.f3937a.f3954q != null) {
                this.f3937a.f3954q.m2899b(str, j, j2);
            }
        }

        public void m4604b(Format format) {
            this.f3937a.f3946i = format;
            if (this.f3937a.f3954q != null) {
                this.f3937a.f3954q.m2898b(format);
            }
        }

        public void m4596a(int i, long j, long j2) {
            if (this.f3937a.f3954q != null) {
                this.f3937a.f3954q.m2897a(i, j, j2);
            }
        }

        public void m4609d(DecoderCounters decoderCounters) {
            if (this.f3937a.f3954q != null) {
                this.f3937a.f3954q.m2901d(decoderCounters);
            }
            this.f3937a.f3946i = null;
            this.f3937a.f3957t = null;
            this.f3937a.f3958u = 0;
        }

        public void m4603a(List<Cue> list) {
            if (this.f3937a.f3951n != null) {
                this.f3937a.f3951n.m4195a(list);
            }
        }

        public void m4607b(List<Id3Frame> list) {
            if (this.f3937a.f3952o != null) {
                this.f3937a.f3952o.m3830a(list);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f3937a.m4615a(surfaceHolder.getSurface(), false);
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f3937a.m4615a(null, false);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f3937a.m4615a(new Surface(surfaceTexture), true);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f3937a.m4615a(null, true);
            return true;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void m4600a(TrackSelections<?> trackSelections) {
            boolean z = false;
            int i = 0;
            while (i < this.f3937a.f3939b.length) {
                if (this.f3937a.f3939b[i].m2961a() == 2 && trackSelections.m4280a(i) != null) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!(this.f3937a.f3953p == null || !this.f3937a.f3944g || z)) {
                this.f3937a.f3953p.m2477b();
            }
            this.f3937a.f3944g = z;
        }
    }

    SimpleExoPlayer(Context context, com.google.android.exoplayer2.p070h.TrackSelector<?> trackSelector, LoadControl loadControl, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, long j) {
        this.f3941d = new Handler();
        this.f3940c = new SimpleExoPlayer();
        trackSelector.m4256a(this.f3940c);
        ArrayList arrayList = new ArrayList();
        if (z) {
            m4617a(arrayList, j);
            m4614a(context, drmSessionManager, arrayList, j);
        } else {
            m4614a(context, drmSessionManager, arrayList, j);
            m4617a(arrayList, j);
        }
        this.f3939b = (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
        int i = 0;
        int i2 = 0;
        for (Renderer a : this.f3939b) {
            switch (a.m2961a()) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i++;
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    i2++;
                    break;
                default:
                    break;
            }
        }
        this.f3942e = i2;
        this.f3943f = i;
        this.f3958u = 0;
        this.f3959v = 1.0f;
        this.f3938a = new ExoPlayerImpl(this.f3939b, trackSelector, loadControl);
    }

    public void m4633a(Surface surface) {
        m4628m();
        m4615a(surface, false);
    }

    public void m4630a(float f) {
        this.f3959v = f;
        ExoPlayer[] exoPlayerArr = new ExoPlayer[this.f3943f];
        Renderer[] rendererArr = this.f3939b;
        int length = rendererArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            ExoPlayer exoPlayer = rendererArr[i];
            if (exoPlayer.m2961a() == 1) {
                i3 = i2 + 1;
                exoPlayerArr[i2] = new ExoPlayer(exoPlayer, 2, Float.valueOf(f));
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        this.f3938a.m3845a(exoPlayerArr);
    }

    public int m4651l() {
        return this.f3958u;
    }

    public void m4636a(SimpleExoPlayer simpleExoPlayer) {
        this.f3953p = simpleExoPlayer;
    }

    public void m4634a(ExoPlayer exoPlayer) {
        this.f3938a.m3842a(exoPlayer);
    }

    public void m4639b(ExoPlayer exoPlayer) {
        this.f3938a.m3846b(exoPlayer);
    }

    public int m4629a() {
        return this.f3938a.m3839a();
    }

    public void m4635a(MediaSource mediaSource) {
        this.f3938a.m3843a(mediaSource);
    }

    public void m4637a(boolean z) {
        this.f3938a.m3844a(z);
    }

    public boolean m4641b() {
        return this.f3938a.m3848b();
    }

    public void m4642c() {
        this.f3938a.m3849c();
    }

    public void m4631a(int i) {
        this.f3938a.m3840a(i);
    }

    public void m4632a(long j) {
        this.f3938a.m3841a(j);
    }

    public void m4643d() {
        this.f3938a.m3850d();
    }

    public void m4644e() {
        this.f3938a.m3851e();
        m4628m();
        if (this.f3947j != null) {
            if (this.f3948k) {
                this.f3947j.release();
            }
            this.f3947j = null;
        }
    }

    public void m4638a(ExoPlayer... exoPlayerArr) {
        this.f3938a.m3845a(exoPlayerArr);
    }

    public void m4640b(ExoPlayer... exoPlayerArr) {
        this.f3938a.m3847b(exoPlayerArr);
    }

    public int m4646g() {
        return this.f3938a.m3853g();
    }

    public long m4647h() {
        return this.f3938a.m3854h();
    }

    public long m4648i() {
        return this.f3938a.m3855i();
    }

    public long m4649j() {
        return this.f3938a.m3856j();
    }

    public int m4650k() {
        return this.f3938a.m3857k();
    }

    public Timeline m4645f() {
        return this.f3938a.m3852f();
    }

    private void m4614a(Context context, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, ArrayList<Renderer> arrayList, long j) {
        arrayList.add(new MediaCodecVideoRenderer(context, MediaCodecSelector.f3286a, 1, j, drmSessionManager, false, this.f3941d, this.f3940c, 50));
        arrayList.add(new MediaCodecAudioRenderer(MediaCodecSelector.f3286a, drmSessionManager, true, this.f3941d, this.f3940c, AudioCapabilities.m2886a(context), 3));
        arrayList.add(new com.google.android.exoplayer2.p064g.TextRenderer(this.f3940c, this.f3941d.getLooper()));
        arrayList.add(new com.google.android.exoplayer2.p060e.MetadataRenderer(this.f3940c, this.f3941d.getLooper(), new Id3Decoder()));
    }

    private void m4617a(ArrayList<Renderer> arrayList, long j) {
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE}).newInstance(new Object[]{Boolean.valueOf(true), Long.valueOf(j), this.f3941d, this.f3940c, Integer.valueOf(50)}));
            Log.i("SimpleExoPlayer", "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException e) {
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(new Class[]{Handler.class, AudioRendererEventListener.class}).newInstance(new Object[]{this.f3941d, this.f3940c}));
            Log.i("SimpleExoPlayer", "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException e3) {
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, AudioRendererEventListener.class}).newInstance(new Object[]{this.f3941d, this.f3940c}));
            Log.i("SimpleExoPlayer", "Loaded LibflacAudioRenderer.");
        } catch (ClassNotFoundException e4) {
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        }
        try {
            arrayList.add((Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, AudioRendererEventListener.class}).newInstance(new Object[]{this.f3941d, this.f3940c}));
            Log.i("SimpleExoPlayer", "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException e5) {
        } catch (Throwable e2222) {
            throw new RuntimeException(e2222);
        }
    }

    private void m4628m() {
        if (this.f3950m != null) {
            if (this.f3950m.getSurfaceTextureListener() != this.f3940c) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f3950m.setSurfaceTextureListener(null);
            }
            this.f3950m = null;
        }
        if (this.f3949l != null) {
            this.f3949l.removeCallback(this.f3940c);
            this.f3949l = null;
        }
    }

    private void m4615a(Surface surface, boolean z) {
        ExoPlayer[] exoPlayerArr = new ExoPlayer[this.f3942e];
        Renderer[] rendererArr = this.f3939b;
        int length = rendererArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            ExoPlayer exoPlayer = rendererArr[i];
            if (exoPlayer.m2961a() == 2) {
                i3 = i2 + 1;
                exoPlayerArr[i2] = new ExoPlayer(exoPlayer, 1, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (this.f3947j == null || this.f3947j == surface) {
            this.f3938a.m3845a(exoPlayerArr);
        } else {
            if (this.f3948k) {
                this.f3947j.release();
            }
            this.f3938a.m3847b(exoPlayerArr);
        }
        this.f3947j = surface;
        this.f3948k = z;
    }
}
