package com.google.android.exoplayer2.p048a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p051b.DecoderCounters;

/* renamed from: com.google.android.exoplayer2.a.c */
public interface AudioRendererEventListener {

    /* renamed from: com.google.android.exoplayer2.a.c.a */
    public static final class AudioRendererEventListener {
        private final Handler f2370a;
        private final AudioRendererEventListener f2371b;

        /* renamed from: com.google.android.exoplayer2.a.c.a.1 */
        class AudioRendererEventListener implements Runnable {
            final /* synthetic */ DecoderCounters f2354a;
            final /* synthetic */ AudioRendererEventListener f2355b;

            AudioRendererEventListener(AudioRendererEventListener audioRendererEventListener, DecoderCounters decoderCounters) {
                this.f2355b = audioRendererEventListener;
                this.f2354a = decoderCounters;
            }

            public void run() {
                this.f2355b.f2371b.m2900c(this.f2354a);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.c.a.2 */
        class AudioRendererEventListener implements Runnable {
            final /* synthetic */ String f2356a;
            final /* synthetic */ long f2357b;
            final /* synthetic */ long f2358c;
            final /* synthetic */ AudioRendererEventListener f2359d;

            AudioRendererEventListener(AudioRendererEventListener audioRendererEventListener, String str, long j, long j2) {
                this.f2359d = audioRendererEventListener;
                this.f2356a = str;
                this.f2357b = j;
                this.f2358c = j2;
            }

            public void run() {
                this.f2359d.f2371b.m2899b(this.f2356a, this.f2357b, this.f2358c);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.c.a.3 */
        class AudioRendererEventListener implements Runnable {
            final /* synthetic */ Format f2360a;
            final /* synthetic */ AudioRendererEventListener f2361b;

            AudioRendererEventListener(AudioRendererEventListener audioRendererEventListener, Format format) {
                this.f2361b = audioRendererEventListener;
                this.f2360a = format;
            }

            public void run() {
                this.f2361b.f2371b.m2898b(this.f2360a);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.c.a.4 */
        class AudioRendererEventListener implements Runnable {
            final /* synthetic */ int f2362a;
            final /* synthetic */ long f2363b;
            final /* synthetic */ long f2364c;
            final /* synthetic */ AudioRendererEventListener f2365d;

            AudioRendererEventListener(AudioRendererEventListener audioRendererEventListener, int i, long j, long j2) {
                this.f2365d = audioRendererEventListener;
                this.f2362a = i;
                this.f2363b = j;
                this.f2364c = j2;
            }

            public void run() {
                this.f2365d.f2371b.m2897a(this.f2362a, this.f2363b, this.f2364c);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.c.a.5 */
        class AudioRendererEventListener implements Runnable {
            final /* synthetic */ DecoderCounters f2366a;
            final /* synthetic */ AudioRendererEventListener f2367b;

            AudioRendererEventListener(AudioRendererEventListener audioRendererEventListener, DecoderCounters decoderCounters) {
                this.f2367b = audioRendererEventListener;
                this.f2366a = decoderCounters;
            }

            public void run() {
                this.f2366a.m3087a();
                this.f2367b.f2371b.m2901d(this.f2366a);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.c.a.6 */
        class AudioRendererEventListener implements Runnable {
            final /* synthetic */ int f2368a;
            final /* synthetic */ AudioRendererEventListener f2369b;

            AudioRendererEventListener(AudioRendererEventListener audioRendererEventListener, int i) {
                this.f2369b = audioRendererEventListener;
                this.f2368a = i;
            }

            public void run() {
                this.f2369b.f2371b.m2896a(this.f2368a);
            }
        }

        public AudioRendererEventListener(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.f2370a = audioRendererEventListener != null ? (Handler) Assertions.m4402a((Object) handler) : null;
            this.f2371b = audioRendererEventListener;
        }

        public void m2893a(DecoderCounters decoderCounters) {
            if (this.f2371b != null) {
                this.f2370a.post(new AudioRendererEventListener(this, decoderCounters));
            }
        }

        public void m2894a(String str, long j, long j2) {
            if (this.f2371b != null) {
                this.f2370a.post(new AudioRendererEventListener(this, str, j, j2));
            }
        }

        public void m2892a(Format format) {
            if (this.f2371b != null) {
                this.f2370a.post(new AudioRendererEventListener(this, format));
            }
        }

        public void m2891a(int i, long j, long j2) {
            if (this.f2371b != null) {
                this.f2370a.post(new AudioRendererEventListener(this, i, j, j2));
            }
        }

        public void m2895b(DecoderCounters decoderCounters) {
            if (this.f2371b != null) {
                this.f2370a.post(new AudioRendererEventListener(this, decoderCounters));
            }
        }

        public void m2890a(int i) {
            if (this.f2371b != null) {
                this.f2370a.post(new AudioRendererEventListener(this, i));
            }
        }
    }

    void m2896a(int i);

    void m2897a(int i, long j, long j2);

    void m2898b(Format format);

    void m2899b(String str, long j, long j2);

    void m2900c(DecoderCounters decoderCounters);

    void m2901d(DecoderCounters decoderCounters);
}
