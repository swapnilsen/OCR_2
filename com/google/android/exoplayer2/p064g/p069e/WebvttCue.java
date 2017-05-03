package com.google.android.exoplayer2.p064g.p069e;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.g.e.e */
final class WebvttCue extends Cue {
    public final long f3534i;
    public final long f3535j;

    /* renamed from: com.google.android.exoplayer2.g.e.e.1 */
    static /* synthetic */ class WebvttCue {
        static final /* synthetic */ int[] f3523a;

        static {
            f3523a = new int[Alignment.values().length];
            try {
                f3523a[Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3523a[Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3523a[Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.g.e.e.a */
    public static final class WebvttCue {
        private long f3524a;
        private long f3525b;
        private SpannableStringBuilder f3526c;
        private Alignment f3527d;
        private float f3528e;
        private int f3529f;
        private int f3530g;
        private float f3531h;
        private int f3532i;
        private float f3533j;

        public WebvttCue() {
            m4152a();
        }

        public void m4152a() {
            this.f3524a = 0;
            this.f3525b = 0;
            this.f3526c = null;
            this.f3527d = null;
            this.f3528e = Float.MIN_VALUE;
            this.f3529f = RtlSpacingHelper.UNDEFINED;
            this.f3530g = RtlSpacingHelper.UNDEFINED;
            this.f3531h = Float.MIN_VALUE;
            this.f3532i = RtlSpacingHelper.UNDEFINED;
            this.f3533j = Float.MIN_VALUE;
        }

        public WebvttCue m4156b() {
            if (this.f3531h != Float.MIN_VALUE && this.f3532i == RtlSpacingHelper.UNDEFINED) {
                m4146c();
            }
            return new WebvttCue(this.f3524a, this.f3525b, this.f3526c, this.f3527d, this.f3528e, this.f3529f, this.f3530g, this.f3531h, this.f3532i, this.f3533j);
        }

        public WebvttCue m4149a(long j) {
            this.f3524a = j;
            return this;
        }

        public WebvttCue m4155b(long j) {
            this.f3525b = j;
            return this;
        }

        public WebvttCue m4151a(SpannableStringBuilder spannableStringBuilder) {
            this.f3526c = spannableStringBuilder;
            return this;
        }

        public WebvttCue m4150a(Alignment alignment) {
            this.f3527d = alignment;
            return this;
        }

        public WebvttCue m4147a(float f) {
            this.f3528e = f;
            return this;
        }

        public WebvttCue m4148a(int i) {
            this.f3529f = i;
            return this;
        }

        public WebvttCue m4154b(int i) {
            this.f3530g = i;
            return this;
        }

        public WebvttCue m4153b(float f) {
            this.f3531h = f;
            return this;
        }

        public WebvttCue m4158c(int i) {
            this.f3532i = i;
            return this;
        }

        public WebvttCue m4157c(float f) {
            this.f3533j = f;
            return this;
        }

        private WebvttCue m4146c() {
            if (this.f3527d != null) {
                switch (WebvttCue.f3523a[this.f3527d.ordinal()]) {
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        this.f3532i = 0;
                        break;
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        this.f3532i = 1;
                        break;
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        this.f3532i = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.f3527d);
                        this.f3532i = 0;
                        break;
                }
            }
            this.f3532i = RtlSpacingHelper.UNDEFINED;
            return this;
        }
    }

    public WebvttCue(CharSequence charSequence) {
        this(0, 0, charSequence);
    }

    public WebvttCue(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED, Float.MIN_VALUE, RtlSpacingHelper.UNDEFINED, Float.MIN_VALUE);
    }

    public WebvttCue(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.f3534i = j;
        this.f3535j = j2;
    }

    public boolean m4159a() {
        return this.c == Float.MIN_VALUE && this.f == Float.MIN_VALUE;
    }
}
