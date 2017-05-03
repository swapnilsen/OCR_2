package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.CodecSpecificDataUtil;
import com.google.android.exoplayer2.p050j.ParsableBitArray;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.DummyTrackOutput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.android.gms.ads.AdRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.f.d */
final class AdtsReader extends ElementaryStreamReader {
    private static final byte[] f3030a;
    private final boolean f3031b;
    private final ParsableBitArray f3032c;
    private final ParsableByteArray f3033d;
    private final String f3034e;
    private TrackOutput f3035f;
    private TrackOutput f3036g;
    private int f3037h;
    private int f3038i;
    private int f3039j;
    private boolean f3040k;
    private boolean f3041l;
    private long f3042m;
    private int f3043n;
    private long f3044o;
    private TrackOutput f3045p;
    private long f3046q;

    static {
        f3030a = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    }

    public AdtsReader(boolean z) {
        this(z, null);
    }

    public AdtsReader(boolean z, String str) {
        this.f3032c = new ParsableBitArray(new byte[7]);
        this.f3033d = new ParsableByteArray(Arrays.copyOf(f3030a, 10));
        m3573c();
        this.f3031b = z;
        this.f3034e = str;
    }

    public void m3579a() {
        m3573c();
    }

    public void m3581a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3035f = extractorOutput.m3725a(elementaryStreamReader.m3594a());
        if (this.f3031b) {
            this.f3036g = extractorOutput.m3725a(elementaryStreamReader.m3594a());
            this.f3036g.m3426a(Format.m2865a(null, "application/id3", null, -1, null));
            return;
        }
        this.f3036g = new DummyTrackOutput();
    }

    public void m3580a(long j, boolean z) {
        this.f3044o = j;
    }

    public void m3582a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 0) {
            switch (this.f3037h) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    m3572b(parsableByteArray);
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    if (!m3571a(parsableByteArray, this.f3033d.f3831a, 10)) {
                        break;
                    }
                    m3577f();
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    if (!m3571a(parsableByteArray, this.f3032c.f3827a, this.f3040k ? 7 : 5)) {
                        break;
                    }
                    m3578g();
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    m3574c(parsableByteArray);
                    break;
                default:
                    break;
            }
        }
    }

    public void m3583b() {
    }

    private boolean m3571a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.m4452b(), i - this.f3038i);
        parsableByteArray.m4451a(bArr, this.f3038i, min);
        this.f3038i = min + this.f3038i;
        return this.f3038i == i;
    }

    private void m3573c() {
        this.f3037h = 0;
        this.f3038i = 0;
        this.f3039j = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    private void m3575d() {
        this.f3037h = 1;
        this.f3038i = f3030a.length;
        this.f3043n = 0;
        this.f3033d.m4455c(0);
    }

    private void m3570a(TrackOutput trackOutput, long j, int i, int i2) {
        this.f3037h = 3;
        this.f3038i = i;
        this.f3045p = trackOutput;
        this.f3046q = j;
        this.f3043n = i2;
    }

    private void m3576e() {
        this.f3037h = 2;
        this.f3038i = 0;
    }

    private void m3572b(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f3831a;
        int d = parsableByteArray.m4456d();
        int c = parsableByteArray.m4454c();
        while (d < c) {
            int i = d + 1;
            d = bArr[d] & MotionEventCompat.ACTION_MASK;
            if (this.f3039j != AdRequest.MAX_CONTENT_URL_LENGTH || d < 240 || d == MotionEventCompat.ACTION_MASK) {
                switch (d | this.f3039j) {
                    case 329:
                        this.f3039j = 768;
                        d = i;
                        break;
                    case 511:
                        this.f3039j = AdRequest.MAX_CONTENT_URL_LENGTH;
                        d = i;
                        break;
                    case 836:
                        this.f3039j = AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT;
                        d = i;
                        break;
                    case 1075:
                        m3575d();
                        parsableByteArray.m4455c(i);
                        return;
                    default:
                        if (this.f3039j == AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
                            d = i;
                            break;
                        }
                        this.f3039j = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                        d = i - 1;
                        break;
                }
            }
            this.f3040k = (d & 1) == 0;
            m3576e();
            parsableByteArray.m4455c(i);
            return;
        }
        parsableByteArray.m4455c(d);
    }

    private void m3577f() {
        this.f3036g.m3427a(this.f3033d, 10);
        this.f3033d.m4455c(6);
        m3570a(this.f3036g, 0, 10, this.f3033d.m4473s() + 10);
    }

    private void m3578g() {
        int i = 2;
        this.f3032c.m4442a(0);
        if (this.f3041l) {
            this.f3032c.m4443b(10);
        } else {
            int c = this.f3032c.m4445c(2) + 1;
            if (c != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + c + ", but assuming AAC LC.");
            } else {
                i = c;
            }
            c = this.f3032c.m4445c(4);
            this.f3032c.m4443b(1);
            Object a = CodecSpecificDataUtil.m4409a(i, c, this.f3032c.m4445c(3));
            Pair a2 = CodecSpecificDataUtil.m4408a(a);
            Format a3 = Format.m2862a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(a), null, 0, this.f3034e);
            this.f3042m = 1024000000 / ((long) a3.f2336q);
            this.f3035f.m3426a(a3);
            this.f3041l = true;
        }
        this.f3032c.m4443b(4);
        int c2 = (this.f3032c.m4445c(13) - 2) - 5;
        if (this.f3040k) {
            c2 -= 2;
        }
        m3570a(this.f3035f, this.f3042m, 0, c2);
    }

    private void m3574c(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.m4452b(), this.f3043n - this.f3038i);
        this.f3045p.m3427a(parsableByteArray, min);
        this.f3038i = min + this.f3038i;
        if (this.f3038i == this.f3043n) {
            this.f3045p.m3425a(this.f3044o, 1, this.f3043n, 0, null);
            this.f3044o += this.f3046q;
            m3573c();
        }
    }
}
