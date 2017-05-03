package com.google.android.exoplayer2.p071k;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p051b.DecoderCounters;

/* renamed from: com.google.android.exoplayer2.k.e */
public interface VideoRendererEventListener {

    /* renamed from: com.google.android.exoplayer2.k.e.a */
    public static final class VideoRendererEventListener {
        private final Handler f3935a;
        private final VideoRendererEventListener f3936b;

        /* renamed from: com.google.android.exoplayer2.k.e.a.1 */
        class VideoRendererEventListener implements Runnable {
            final /* synthetic */ DecoderCounters f3915a;
            final /* synthetic */ VideoRendererEventListener f3916b;

            VideoRendererEventListener(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
                this.f3916b = videoRendererEventListener;
                this.f3915a = decoderCounters;
            }

            public void run() {
                this.f3916b.f3936b.m4590a(this.f3915a);
            }
        }

        /* renamed from: com.google.android.exoplayer2.k.e.a.2 */
        class VideoRendererEventListener implements Runnable {
            final /* synthetic */ String f3917a;
            final /* synthetic */ long f3918b;
            final /* synthetic */ long f3919c;
            final /* synthetic */ VideoRendererEventListener f3920d;

            VideoRendererEventListener(VideoRendererEventListener videoRendererEventListener, String str, long j, long j2) {
                this.f3920d = videoRendererEventListener;
                this.f3917a = str;
                this.f3918b = j;
                this.f3919c = j2;
            }

            public void run() {
                this.f3920d.f3936b.m4591a(this.f3917a, this.f3918b, this.f3919c);
            }
        }

        /* renamed from: com.google.android.exoplayer2.k.e.a.3 */
        class VideoRendererEventListener implements Runnable {
            final /* synthetic */ Format f3921a;
            final /* synthetic */ VideoRendererEventListener f3922b;

            VideoRendererEventListener(VideoRendererEventListener videoRendererEventListener, Format format) {
                this.f3922b = videoRendererEventListener;
                this.f3921a = format;
            }

            public void run() {
                this.f3922b.f3936b.m4589a(this.f3921a);
            }
        }

        /* renamed from: com.google.android.exoplayer2.k.e.a.4 */
        class VideoRendererEventListener implements Runnable {
            final /* synthetic */ int f3923a;
            final /* synthetic */ long f3924b;
            final /* synthetic */ VideoRendererEventListener f3925c;

            VideoRendererEventListener(VideoRendererEventListener videoRendererEventListener, int i, long j) {
                this.f3925c = videoRendererEventListener;
                this.f3923a = i;
                this.f3924b = j;
            }

            public void run() {
                this.f3925c.f3936b.m4587a(this.f3923a, this.f3924b);
            }
        }

        /* renamed from: com.google.android.exoplayer2.k.e.a.5 */
        class VideoRendererEventListener implements Runnable {
            final /* synthetic */ int f3926a;
            final /* synthetic */ int f3927b;
            final /* synthetic */ int f3928c;
            final /* synthetic */ float f3929d;
            final /* synthetic */ VideoRendererEventListener f3930e;

            VideoRendererEventListener(VideoRendererEventListener videoRendererEventListener, int i, int i2, int i3, float f) {
                this.f3930e = videoRendererEventListener;
                this.f3926a = i;
                this.f3927b = i2;
                this.f3928c = i3;
                this.f3929d = f;
            }

            public void run() {
                this.f3930e.f3936b.m4586a(this.f3926a, this.f3927b, this.f3928c, this.f3929d);
            }
        }

        /* renamed from: com.google.android.exoplayer2.k.e.a.6 */
        class VideoRendererEventListener implements Runnable {
            final /* synthetic */ Surface f3931a;
            final /* synthetic */ VideoRendererEventListener f3932b;

            VideoRendererEventListener(VideoRendererEventListener videoRendererEventListener, Surface surface) {
                this.f3932b = videoRendererEventListener;
                this.f3931a = surface;
            }

            public void run() {
                this.f3932b.f3936b.m4588a(this.f3931a);
            }
        }

        /* renamed from: com.google.android.exoplayer2.k.e.a.7 */
        class VideoRendererEventListener implements Runnable {
            final /* synthetic */ DecoderCounters f3933a;
            final /* synthetic */ VideoRendererEventListener f3934b;

            VideoRendererEventListener(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
                this.f3934b = videoRendererEventListener;
                this.f3933a = decoderCounters;
            }

            public void run() {
                this.f3933a.m3087a();
                this.f3934b.f3936b.m4592b(this.f3933a);
            }
        }

        public VideoRendererEventListener(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            this.f3935a = videoRendererEventListener != null ? (Handler) Assertions.m4402a((Object) handler) : null;
            this.f3936b = videoRendererEventListener;
        }

        public void m4583a(DecoderCounters decoderCounters) {
            if (this.f3936b != null) {
                this.f3935a.post(new VideoRendererEventListener(this, decoderCounters));
            }
        }

        public void m4584a(String str, long j, long j2) {
            if (this.f3936b != null) {
                this.f3935a.post(new VideoRendererEventListener(this, str, j, j2));
            }
        }

        public void m4582a(Format format) {
            if (this.f3936b != null) {
                this.f3935a.post(new VideoRendererEventListener(this, format));
            }
        }

        public void m4580a(int i, long j) {
            if (this.f3936b != null) {
                this.f3935a.post(new VideoRendererEventListener(this, i, j));
            }
        }

        public void m4579a(int i, int i2, int i3, float f) {
            if (this.f3936b != null) {
                this.f3935a.post(new VideoRendererEventListener(this, i, i2, i3, f));
            }
        }

        public void m4581a(Surface surface) {
            if (this.f3936b != null) {
                this.f3935a.post(new VideoRendererEventListener(this, surface));
            }
        }

        public void m4585b(DecoderCounters decoderCounters) {
            if (this.f3936b != null) {
                this.f3935a.post(new VideoRendererEventListener(this, decoderCounters));
            }
        }
    }

    void m4586a(int i, int i2, int i3, float f);

    void m4587a(int i, long j);

    void m4588a(Surface surface);

    void m4589a(Format format);

    void m4590a(DecoderCounters decoderCounters);

    void m4591a(String str, long j, long j2);

    void m4592b(DecoderCounters decoderCounters);
}
