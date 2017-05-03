package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.p050j.ParsableBitArray;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.Extractor;
import com.google.android.exoplayer2.p052c.ExtractorInput;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.ExtractorsFactory;
import com.google.android.exoplayer2.p052c.PositionHolder;
import com.google.android.exoplayer2.p052c.SeekMap.SeekMap;
import com.google.android.exoplayer2.p052c.TimestampAdjuster;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;

/* renamed from: com.google.android.exoplayer2.c.f.n */
public final class PsExtractor implements Extractor {
    public static final ExtractorsFactory f3184a;
    private final TimestampAdjuster f3185b;
    private final SparseArray<PsExtractor> f3186c;
    private final ParsableByteArray f3187d;
    private boolean f3188e;
    private boolean f3189f;
    private boolean f3190g;
    private ExtractorOutput f3191h;

    /* renamed from: com.google.android.exoplayer2.c.f.n.1 */
    static class PsExtractor implements ExtractorsFactory {
        PsExtractor() {
        }

        public Extractor[] m3660a() {
            return new Extractor[]{new PsExtractor()};
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.n.a */
    private static final class PsExtractor {
        private final ElementaryStreamReader f3176a;
        private final TimestampAdjuster f3177b;
        private final ParsableBitArray f3178c;
        private boolean f3179d;
        private boolean f3180e;
        private boolean f3181f;
        private int f3182g;
        private long f3183h;

        public PsExtractor(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f3176a = elementaryStreamReader;
            this.f3177b = timestampAdjuster;
            this.f3178c = new ParsableBitArray(new byte[64]);
        }

        public void m3663a() {
            this.f3181f = false;
            this.f3176a.m3551a();
        }

        public void m3664a(ParsableByteArray parsableByteArray) {
            parsableByteArray.m4451a(this.f3178c.f3827a, 0, 3);
            this.f3178c.m4442a(0);
            m3661b();
            parsableByteArray.m4451a(this.f3178c.f3827a, 0, this.f3182g);
            this.f3178c.m4442a(0);
            m3662c();
            this.f3176a.m3552a(this.f3183h, true);
            this.f3176a.m3554a(parsableByteArray);
            this.f3176a.m3555b();
        }

        private void m3661b() {
            this.f3178c.m4443b(8);
            this.f3179d = this.f3178c.m4444b();
            this.f3180e = this.f3178c.m4444b();
            this.f3178c.m4443b(6);
            this.f3182g = this.f3178c.m4445c(8);
        }

        private void m3662c() {
            this.f3183h = 0;
            if (this.f3179d) {
                this.f3178c.m4443b(4);
                long c = ((long) this.f3178c.m4445c(3)) << 30;
                this.f3178c.m4443b(1);
                c |= (long) (this.f3178c.m4445c(15) << 15);
                this.f3178c.m4443b(1);
                c |= (long) this.f3178c.m4445c(15);
                this.f3178c.m4443b(1);
                if (!this.f3181f && this.f3180e) {
                    this.f3178c.m4443b(4);
                    long c2 = ((long) this.f3178c.m4445c(3)) << 30;
                    this.f3178c.m4443b(1);
                    c2 |= (long) (this.f3178c.m4445c(15) << 15);
                    this.f3178c.m4443b(1);
                    c2 |= (long) this.f3178c.m4445c(15);
                    this.f3178c.m4443b(1);
                    this.f3177b.m3739a(c2);
                    this.f3181f = true;
                }
                this.f3183h = this.f3177b.m3739a(c);
            }
        }
    }

    static {
        f3184a = new PsExtractor();
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0));
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.f3185b = timestampAdjuster;
        this.f3187d = new ParsableByteArray((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
        this.f3186c = new SparseArray();
    }

    public boolean m3668a(ExtractorInput extractorInput) {
        boolean z = true;
        byte[] bArr = new byte[14];
        extractorInput.m3240c(bArr, 0, 14);
        if (442 != (((((bArr[0] & MotionEventCompat.ACTION_MASK) << 24) | ((bArr[1] & MotionEventCompat.ACTION_MASK) << 16)) | ((bArr[2] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[3] & MotionEventCompat.ACTION_MASK)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.m3239c(bArr[13] & 7);
        extractorInput.m3240c(bArr, 0, 3);
        if (1 != ((bArr[2] & MotionEventCompat.ACTION_MASK) | (((bArr[0] & MotionEventCompat.ACTION_MASK) << 16) | ((bArr[1] & MotionEventCompat.ACTION_MASK) << 8)))) {
            z = false;
        }
        return z;
    }

    public void m3667a(ExtractorOutput extractorOutput) {
        this.f3191h = extractorOutput;
        extractorOutput.m3727a(new SeekMap(-9223372036854775807L));
    }

    public void m3666a(long j) {
        this.f3185b.m3740a();
        for (int i = 0; i < this.f3186c.size(); i++) {
            ((PsExtractor) this.f3186c.valueAt(i)).m3663a();
        }
    }

    public void m3669c() {
    }

    public int m3665a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        if (!extractorInput.m3237b(this.f3187d.f3831a, 0, 4, true)) {
            return -1;
        }
        this.f3187d.m4455c(0);
        int n = this.f3187d.m4468n();
        if (n == 441) {
            return -1;
        }
        if (n == 442) {
            extractorInput.m3240c(this.f3187d.f3831a, 0, 10);
            this.f3187d.m4455c(9);
            extractorInput.m3235b((this.f3187d.m4461g() & 7) + 14);
            return 0;
        } else if (n == 443) {
            extractorInput.m3240c(this.f3187d.f3831a, 0, 2);
            this.f3187d.m4455c(0);
            extractorInput.m3235b(this.f3187d.m4462h() + 6);
            return 0;
        } else if (((n & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            extractorInput.m3235b(1);
            return 0;
        } else {
            int i = n & MotionEventCompat.ACTION_MASK;
            PsExtractor psExtractor = (PsExtractor) this.f3186c.get(i);
            if (!this.f3188e) {
                if (psExtractor == null) {
                    ElementaryStreamReader elementaryStreamReader = null;
                    if (!this.f3189f && i == 189) {
                        elementaryStreamReader = new Ac3Reader();
                        this.f3189f = true;
                    } else if (!this.f3189f && (i & 224) == 192) {
                        elementaryStreamReader = new MpegAudioReader();
                        this.f3189f = true;
                    } else if (!this.f3190g && (i & 240) == 224) {
                        elementaryStreamReader = new H262Reader();
                        this.f3190g = true;
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.m3553a(this.f3191h, new ElementaryStreamReader(i, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY));
                        psExtractor = new PsExtractor(elementaryStreamReader, this.f3185b);
                        this.f3186c.put(i, psExtractor);
                    }
                }
                if ((this.f3189f && this.f3190g) || extractorInput.m3238c() > 1048576) {
                    this.f3188e = true;
                    this.f3191h.m3726a();
                }
            }
            extractorInput.m3240c(this.f3187d.f3831a, 0, 2);
            this.f3187d.m4455c(0);
            n = this.f3187d.m4462h() + 6;
            if (psExtractor == null) {
                extractorInput.m3235b(n);
            } else {
                this.f3187d.m4448a(n);
                extractorInput.m3236b(this.f3187d.f3831a, 0, n);
                this.f3187d.m4455c(6);
                psExtractor.m3664a(this.f3187d);
                this.f3187d.m4453b(this.f3187d.m4458e());
            }
            return 0;
        }
    }
}
