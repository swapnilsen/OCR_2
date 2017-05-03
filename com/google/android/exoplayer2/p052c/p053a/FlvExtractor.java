package com.google.android.exoplayer2.p052c.p053a;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.a.b */
public final class FlvExtractor implements Extractor, SeekMap {
    public static final ExtractorsFactory f2529a;
    private static final int f2530e;
    public int f2531b;
    public int f2532c;
    public long f2533d;
    private final ParsableByteArray f2534f;
    private final ParsableByteArray f2535g;
    private final ParsableByteArray f2536h;
    private final ParsableByteArray f2537i;
    private ExtractorOutput f2538j;
    private int f2539k;
    private int f2540l;
    private AudioTagPayloadReader f2541m;
    private VideoTagPayloadReader f2542n;
    private ScriptTagPayloadReader f2543o;

    /* renamed from: com.google.android.exoplayer2.c.a.b.1 */
    static class FlvExtractor implements ExtractorsFactory {
        FlvExtractor() {
        }

        public Extractor[] m3122a() {
            return new Extractor[]{new FlvExtractor()};
        }
    }

    static {
        f2529a = new FlvExtractor();
        f2530e = Util.m4524e("FLV");
    }

    public FlvExtractor() {
        this.f2534f = new ParsableByteArray(4);
        this.f2535g = new ParsableByteArray(9);
        this.f2536h = new ParsableByteArray(11);
        this.f2537i = new ParsableByteArray();
        this.f2539k = 1;
    }

    public boolean m3140a(ExtractorInput extractorInput) {
        extractorInput.m3240c(this.f2534f.f3831a, 0, 3);
        this.f2534f.m4455c(0);
        if (this.f2534f.m4465k() != f2530e) {
            return false;
        }
        extractorInput.m3240c(this.f2534f.f3831a, 0, 2);
        this.f2534f.m4455c(0);
        if ((this.f2534f.m4462h() & Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        extractorInput.m3240c(this.f2534f.f3831a, 0, 4);
        this.f2534f.m4455c(0);
        int n = this.f2534f.m4468n();
        extractorInput.m3232a();
        extractorInput.m3239c(n);
        extractorInput.m3240c(this.f2534f.f3831a, 0, 4);
        this.f2534f.m4455c(0);
        if (this.f2534f.m4468n() == 0) {
            return true;
        }
        return false;
    }

    public void m3138a(ExtractorOutput extractorOutput) {
        this.f2538j = extractorOutput;
    }

    public void m3137a(long j) {
        this.f2539k = 1;
        this.f2540l = 0;
    }

    public void m3143c() {
    }

    public int m3136a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            switch (this.f2539k) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    if (m3131b(extractorInput)) {
                        break;
                    }
                    return -1;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    m3132c(extractorInput);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    if (m3133d(extractorInput)) {
                        break;
                    }
                    return -1;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    if (!m3134e(extractorInput)) {
                        break;
                    }
                    return 0;
                default:
                    break;
            }
        }
    }

    private boolean m3131b(ExtractorInput extractorInput) {
        boolean z = false;
        if (!extractorInput.m3233a(this.f2535g.f3831a, 0, 9, true)) {
            return false;
        }
        this.f2535g.m4455c(0);
        this.f2535g.m4457d(4);
        int g = this.f2535g.m4461g();
        boolean z2 = (g & 4) != 0;
        if ((g & 1) != 0) {
            z = true;
        }
        if (z2 && this.f2541m == null) {
            this.f2541m = new AudioTagPayloadReader(this.f2538j.m3725a(8));
        }
        if (z && this.f2542n == null) {
            this.f2542n = new VideoTagPayloadReader(this.f2538j.m3725a(9));
        }
        if (this.f2543o == null) {
            this.f2543o = new ScriptTagPayloadReader(null);
        }
        this.f2538j.m3726a();
        this.f2538j.m3727a((SeekMap) this);
        this.f2540l = (this.f2535g.m4468n() - 9) + 4;
        this.f2539k = 2;
        return true;
    }

    private void m3132c(ExtractorInput extractorInput) {
        extractorInput.m3235b(this.f2540l);
        this.f2540l = 0;
        this.f2539k = 3;
    }

    private boolean m3133d(ExtractorInput extractorInput) {
        if (!extractorInput.m3233a(this.f2536h.f3831a, 0, 11, true)) {
            return false;
        }
        this.f2536h.m4455c(0);
        this.f2531b = this.f2536h.m4461g();
        this.f2532c = this.f2536h.m4465k();
        this.f2533d = (long) this.f2536h.m4465k();
        this.f2533d = (((long) (this.f2536h.m4461g() << 24)) | this.f2533d) * 1000;
        this.f2536h.m4457d(3);
        this.f2539k = 4;
        return true;
    }

    private boolean m3134e(ExtractorInput extractorInput) {
        boolean z = true;
        if (this.f2531b == 8 && this.f2541m != null) {
            this.f2541m.m3118b(m3135f(extractorInput), this.f2533d);
        } else if (this.f2531b == 9 && this.f2542n != null) {
            this.f2542n.m3118b(m3135f(extractorInput), this.f2533d);
        } else if (this.f2531b != 18 || this.f2543o == null) {
            extractorInput.m3235b(this.f2532c);
            z = false;
        } else {
            this.f2543o.m3118b(m3135f(extractorInput), this.f2533d);
        }
        this.f2540l = 4;
        this.f2539k = 2;
        return z;
    }

    private ParsableByteArray m3135f(ExtractorInput extractorInput) {
        if (this.f2532c > this.f2537i.m4458e()) {
            this.f2537i.m4450a(new byte[Math.max(this.f2537i.m4458e() * 2, this.f2532c)], 0);
        } else {
            this.f2537i.m4455c(0);
        }
        this.f2537i.m4453b(this.f2532c);
        extractorInput.m3236b(this.f2537i.f3831a, 0, this.f2532c);
        return this.f2537i;
    }

    public boolean m3139a() {
        return false;
    }

    public long m3141b() {
        return this.f2543o.m3153a();
    }

    public long m3142b(long j) {
        return 0;
    }
}
