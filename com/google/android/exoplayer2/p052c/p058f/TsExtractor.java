package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.ParsableBitArray;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap.SeekMap;
import com.google.android.exoplayer2.p052c.TimestampAdjuster;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.f.p */
public final class TsExtractor implements Extractor {
    public static final ExtractorsFactory f3218a;
    private static final long f3219b;
    private static final long f3220c;
    private static final long f3221d;
    private final boolean f3222e;
    private final TimestampAdjuster f3223f;
    private final ParsableByteArray f3224g;
    private final ParsableBitArray f3225h;
    private final SparseIntArray f3226i;
    private final ElementaryStreamReader f3227j;
    private final SparseArray<TsExtractor> f3228k;
    private final SparseBooleanArray f3229l;
    private ExtractorOutput f3230m;
    private boolean f3231n;
    private ElementaryStreamReader f3232o;

    /* renamed from: com.google.android.exoplayer2.c.f.p.1 */
    static class TsExtractor implements ExtractorsFactory {
        TsExtractor() {
        }

        public Extractor[] m3671a() {
            return new Extractor[]{new TsExtractor()};
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.p.d */
    private static abstract class TsExtractor {
        public abstract void m3672a();

        public abstract void m3673a(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput);

        private TsExtractor() {
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.p.a */
    private class TsExtractor extends TsExtractor {
        final /* synthetic */ TsExtractor f3193a;
        private final ParsableByteArray f3194b;
        private final ParsableBitArray f3195c;
        private int f3196d;
        private int f3197e;
        private int f3198f;

        public TsExtractor(TsExtractor tsExtractor) {
            this.f3193a = tsExtractor;
            super();
            this.f3194b = new ParsableByteArray();
            this.f3195c = new ParsableBitArray(new byte[4]);
        }

        public void m3674a() {
        }

        public void m3675a(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput) {
            int i = 0;
            if (z) {
                parsableByteArray.m4457d(parsableByteArray.m4461g());
                parsableByteArray.m4449a(this.f3195c, 3);
                this.f3195c.m4443b(12);
                this.f3196d = this.f3195c.m4445c(12);
                this.f3197e = 0;
                this.f3198f = Util.m4508a(this.f3195c.f3827a, 0, 3, -1);
                this.f3194b.m4448a(this.f3196d);
            }
            int min = Math.min(parsableByteArray.m4452b(), this.f3196d - this.f3197e);
            parsableByteArray.m4451a(this.f3194b.f3831a, this.f3197e, min);
            this.f3197e = min + this.f3197e;
            if (this.f3197e >= this.f3196d && Util.m4508a(this.f3194b.f3831a, 0, this.f3196d, this.f3198f) == 0) {
                this.f3194b.m4457d(5);
                min = (this.f3196d - 9) / 4;
                while (i < min) {
                    this.f3194b.m4449a(this.f3195c, 4);
                    int c = this.f3195c.m4445c(16);
                    this.f3195c.m4443b(3);
                    if (c == 0) {
                        this.f3195c.m4443b(13);
                    } else {
                        c = this.f3195c.m4445c(13);
                        this.f3193a.f3228k.put(c, new TsExtractor(this.f3193a, c));
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.p.b */
    private static final class TsExtractor extends TsExtractor {
        private final ElementaryStreamReader f3199a;
        private final TimestampAdjuster f3200b;
        private final ParsableBitArray f3201c;
        private int f3202d;
        private int f3203e;
        private boolean f3204f;
        private boolean f3205g;
        private boolean f3206h;
        private int f3207i;
        private int f3208j;
        private boolean f3209k;
        private long f3210l;

        public TsExtractor(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            super();
            this.f3199a = elementaryStreamReader;
            this.f3200b = timestampAdjuster;
            this.f3201c = new ParsableBitArray(new byte[10]);
            this.f3202d = 0;
        }

        public void m3680a() {
            this.f3202d = 0;
            this.f3203e = 0;
            this.f3206h = false;
            this.f3199a.m3551a();
        }

        public void m3681a(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput) {
            if (z) {
                switch (this.f3202d) {
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        Log.w("TsExtractor", "Unexpected start indicator reading extended header");
                        break;
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        if (this.f3208j != -1) {
                            Log.w("TsExtractor", "Unexpected start indicator: expected " + this.f3208j + " more bytes");
                        }
                        this.f3199a.m3555b();
                        break;
                }
                m3676a(1);
            }
            while (parsableByteArray.m4452b() > 0) {
                switch (this.f3202d) {
                    case NendAdIconLayout.HORIZONTAL /*0*/:
                        parsableByteArray.m4457d(parsableByteArray.m4452b());
                        break;
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        if (!m3677a(parsableByteArray, this.f3201c.f3827a, 9)) {
                            break;
                        }
                        m3676a(m3678b() ? 2 : 0);
                        break;
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        if (m3677a(parsableByteArray, this.f3201c.f3827a, Math.min(10, this.f3207i)) && m3677a(parsableByteArray, null, this.f3207i)) {
                            m3679c();
                            this.f3199a.m3552a(this.f3210l, this.f3209k);
                            m3676a(3);
                            break;
                        }
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        int i;
                        int b = parsableByteArray.m4452b();
                        if (this.f3208j == -1) {
                            i = 0;
                        } else {
                            i = b - this.f3208j;
                        }
                        if (i > 0) {
                            b -= i;
                            parsableByteArray.m4453b(parsableByteArray.m4456d() + b);
                        }
                        this.f3199a.m3554a(parsableByteArray);
                        if (this.f3208j == -1) {
                            break;
                        }
                        this.f3208j -= b;
                        if (this.f3208j != 0) {
                            break;
                        }
                        this.f3199a.m3555b();
                        m3676a(1);
                        break;
                    default:
                        break;
                }
            }
        }

        private void m3676a(int i) {
            this.f3202d = i;
            this.f3203e = 0;
        }

        private boolean m3677a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
            int min = Math.min(parsableByteArray.m4452b(), i - this.f3203e);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                parsableByteArray.m4457d(min);
            } else {
                parsableByteArray.m4451a(bArr, this.f3203e, min);
            }
            this.f3203e = min + this.f3203e;
            if (this.f3203e != i) {
                return false;
            }
            return true;
        }

        private boolean m3678b() {
            this.f3201c.m4442a(0);
            int c = this.f3201c.m4445c(24);
            if (c != 1) {
                Log.w("TsExtractor", "Unexpected start code prefix: " + c);
                this.f3208j = -1;
                return false;
            }
            this.f3201c.m4443b(8);
            int c2 = this.f3201c.m4445c(16);
            this.f3201c.m4443b(5);
            this.f3209k = this.f3201c.m4444b();
            this.f3201c.m4443b(2);
            this.f3204f = this.f3201c.m4444b();
            this.f3205g = this.f3201c.m4444b();
            this.f3201c.m4443b(6);
            this.f3207i = this.f3201c.m4445c(8);
            if (c2 == 0) {
                this.f3208j = -1;
            } else {
                this.f3208j = ((c2 + 6) - 9) - this.f3207i;
            }
            return true;
        }

        private void m3679c() {
            this.f3201c.m4442a(0);
            this.f3210l = -9223372036854775807L;
            if (this.f3204f) {
                this.f3201c.m4443b(4);
                long c = ((long) this.f3201c.m4445c(3)) << 30;
                this.f3201c.m4443b(1);
                c |= (long) (this.f3201c.m4445c(15) << 15);
                this.f3201c.m4443b(1);
                c |= (long) this.f3201c.m4445c(15);
                this.f3201c.m4443b(1);
                if (!this.f3206h && this.f3205g) {
                    this.f3201c.m4443b(4);
                    long c2 = ((long) this.f3201c.m4445c(3)) << 30;
                    this.f3201c.m4443b(1);
                    c2 |= (long) (this.f3201c.m4445c(15) << 15);
                    this.f3201c.m4443b(1);
                    c2 |= (long) this.f3201c.m4445c(15);
                    this.f3201c.m4443b(1);
                    this.f3200b.m3739a(c2);
                    this.f3206h = true;
                }
                this.f3210l = this.f3200b.m3739a(c);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.p.c */
    private class TsExtractor extends TsExtractor {
        final /* synthetic */ TsExtractor f3211a;
        private final ParsableBitArray f3212b;
        private final ParsableByteArray f3213c;
        private final int f3214d;
        private int f3215e;
        private int f3216f;
        private int f3217g;

        public TsExtractor(TsExtractor tsExtractor, int i) {
            this.f3211a = tsExtractor;
            super();
            this.f3212b = new ParsableBitArray(new byte[5]);
            this.f3213c = new ParsableByteArray();
            this.f3214d = i;
        }

        public void m3683a() {
        }

        public void m3684a(ParsableByteArray parsableByteArray, boolean z, ExtractorOutput extractorOutput) {
            if (z) {
                parsableByteArray.m4457d(parsableByteArray.m4461g());
                parsableByteArray.m4449a(this.f3212b, 3);
                this.f3212b.m4443b(12);
                this.f3215e = this.f3212b.m4445c(12);
                this.f3216f = 0;
                this.f3217g = Util.m4508a(this.f3212b.f3827a, 0, 3, -1);
                this.f3213c.m4448a(this.f3215e);
            }
            int min = Math.min(parsableByteArray.m4452b(), this.f3215e - this.f3216f);
            parsableByteArray.m4451a(this.f3213c.f3831a, this.f3216f, min);
            this.f3216f = min + this.f3216f;
            if (this.f3216f >= this.f3215e && Util.m4508a(this.f3213c.f3831a, 0, this.f3215e, this.f3217g) == 0) {
                this.f3213c.m4457d(7);
                this.f3213c.m4449a(this.f3212b, 2);
                this.f3212b.m4443b(4);
                min = this.f3212b.m4445c(12);
                this.f3213c.m4457d(min);
                if (this.f3211a.f3222e && this.f3211a.f3232o == null) {
                    this.f3211a.f3232o = this.f3211a.f3227j.m3584a(21, new ElementaryStreamReader(21, null, new byte[0]));
                    this.f3211a.f3232o.m3553a(extractorOutput, new ElementaryStreamReader(21, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD));
                }
                int i = ((this.f3215e - 9) - min) - 4;
                while (i > 0) {
                    this.f3213c.m4449a(this.f3212b, 5);
                    min = this.f3212b.m4445c(8);
                    this.f3212b.m4443b(3);
                    int c = this.f3212b.m4445c(13);
                    this.f3212b.m4443b(4);
                    int c2 = this.f3212b.m4445c(12);
                    ElementaryStreamReader a = m3682a(this.f3213c, c2);
                    if (min == 6) {
                        min = a.f3058a;
                    }
                    c2 = i - (c2 + 5);
                    if (this.f3211a.f3222e) {
                        i = min;
                    } else {
                        i = c;
                    }
                    if (this.f3211a.f3229l.get(i)) {
                        i = c2;
                    } else {
                        ElementaryStreamReader c3;
                        this.f3211a.f3229l.put(i, true);
                        if (this.f3211a.f3222e && min == 21) {
                            c3 = this.f3211a.f3232o;
                        } else {
                            c3 = this.f3211a.f3227j.m3584a(min, a);
                            c3.m3553a(extractorOutput, new ElementaryStreamReader(i, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD));
                        }
                        if (c3 != null) {
                            this.f3211a.f3228k.put(c, new TsExtractor(c3, this.f3211a.f3223f));
                        }
                        i = c2;
                    }
                }
                if (!this.f3211a.f3222e) {
                    this.f3211a.f3228k.remove(0);
                    this.f3211a.f3228k.remove(this.f3214d);
                    extractorOutput.m3726a();
                } else if (!this.f3211a.f3231n) {
                    extractorOutput.m3726a();
                }
                this.f3211a.f3231n = true;
            }
        }

        private ElementaryStreamReader m3682a(ParsableByteArray parsableByteArray, int i) {
            int d = parsableByteArray.m4456d();
            int i2 = d + i;
            int i3 = -1;
            String str = null;
            while (parsableByteArray.m4456d() < i2) {
                int g = parsableByteArray.m4461g();
                int g2 = parsableByteArray.m4461g() + parsableByteArray.m4456d();
                if (g == 5) {
                    long l = parsableByteArray.m4466l();
                    if (l == TsExtractor.f3219b) {
                        i3 = 129;
                    } else if (l == TsExtractor.f3220c) {
                        i3 = 135;
                    } else if (l == TsExtractor.f3221d) {
                        i3 = 36;
                    }
                } else if (g == C0268R.styleable.AppCompatTheme_editTextStyle) {
                    i3 = 129;
                } else if (g == 122) {
                    i3 = 135;
                } else if (g == 123) {
                    i3 = 138;
                } else if (g == 10) {
                    str = new String(parsableByteArray.f3831a, parsableByteArray.m4456d(), 3).trim();
                }
                parsableByteArray.m4457d(g2 - parsableByteArray.m4456d());
            }
            parsableByteArray.m4455c(i2);
            return new ElementaryStreamReader(i3, str, Arrays.copyOfRange(this.f3213c.f3831a, d, i2));
        }
    }

    static {
        f3218a = new TsExtractor();
        f3219b = (long) Util.m4524e("AC-3");
        f3220c = (long) Util.m4524e("EAC3");
        f3221d = (long) Util.m4524e("HEVC");
    }

    public TsExtractor() {
        this(new TimestampAdjuster(0));
    }

    public TsExtractor(TimestampAdjuster timestampAdjuster) {
        this(timestampAdjuster, new DefaultStreamReaderFactory(), false);
    }

    public TsExtractor(TimestampAdjuster timestampAdjuster, ElementaryStreamReader elementaryStreamReader, boolean z) {
        this.f3223f = timestampAdjuster;
        this.f3227j = (ElementaryStreamReader) Assertions.m4402a((Object) elementaryStreamReader);
        this.f3222e = z;
        this.f3224g = new ParsableByteArray(940);
        this.f3225h = new ParsableBitArray(new byte[3]);
        this.f3229l = new SparseBooleanArray();
        this.f3228k = new SparseArray();
        this.f3226i = new SparseIntArray();
        m3695e();
    }

    public boolean m3701a(ExtractorInput extractorInput) {
        byte[] bArr = this.f3224g.f3831a;
        extractorInput.m3240c(bArr, 0, 940);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 != 5) {
                if (bArr[(i2 * 188) + i] != 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            extractorInput.m3235b(i);
            return true;
        }
        return false;
    }

    public void m3700a(ExtractorOutput extractorOutput) {
        this.f3230m = extractorOutput;
        extractorOutput.m3727a(new SeekMap(-9223372036854775807L));
    }

    public void m3699a(long j) {
        this.f3223f.m3740a();
        this.f3224g.m4447a();
        this.f3226i.clear();
        m3695e();
    }

    public void m3702c() {
    }

    public int m3698a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int b;
        int a;
        byte[] bArr = this.f3224g.f3831a;
        if (940 - this.f3224g.m4456d() < 188) {
            b = this.f3224g.m4452b();
            if (b > 0) {
                System.arraycopy(bArr, this.f3224g.m4456d(), bArr, 0, b);
            }
            this.f3224g.m4450a(bArr, b);
        }
        while (this.f3224g.m4452b() < 188) {
            b = this.f3224g.m4454c();
            a = extractorInput.m3231a(bArr, b, 940 - b);
            if (a == -1) {
                return -1;
            }
            this.f3224g.m4453b(b + a);
        }
        b = this.f3224g.m4454c();
        int d = this.f3224g.m4456d();
        while (d < b && bArr[d] != 71) {
            d++;
        }
        this.f3224g.m4455c(d);
        a = d + 188;
        if (a > b) {
            return 0;
        }
        this.f3224g.m4457d(1);
        this.f3224g.m4449a(this.f3225h, 3);
        if (this.f3225h.m4444b()) {
            this.f3224g.m4455c(a);
            return 0;
        }
        boolean b2 = this.f3225h.m4444b();
        this.f3225h.m4443b(1);
        d = this.f3225h.m4445c(13);
        this.f3225h.m4443b(2);
        boolean b3 = this.f3225h.m4444b();
        boolean b4 = this.f3225h.m4444b();
        int c = this.f3225h.m4445c(4);
        int i = this.f3226i.get(d, c - 1);
        this.f3226i.put(d, c);
        if (i == c) {
            this.f3224g.m4455c(a);
            return 0;
        }
        if (c != (i + 1) % 16) {
            c = 1;
        } else {
            c = 0;
        }
        if (b3) {
            this.f3224g.m4457d(this.f3224g.m4461g());
        }
        if (b4) {
            TsExtractor tsExtractor = (TsExtractor) this.f3228k.get(d);
            if (tsExtractor != null) {
                if (c != 0) {
                    tsExtractor.m3672a();
                }
                this.f3224g.m4453b(a);
                tsExtractor.m3673a(this.f3224g, b2, this.f3230m);
                Assertions.m4406b(this.f3224g.m4456d() <= a);
                this.f3224g.m4453b(b);
            }
        }
        this.f3224g.m4455c(a);
        return 0;
    }

    private void m3695e() {
        this.f3229l.clear();
        this.f3228k.clear();
        this.f3228k.put(0, new TsExtractor(this));
        this.f3232o = null;
    }
}
