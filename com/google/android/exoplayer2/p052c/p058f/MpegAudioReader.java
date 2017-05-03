package com.google.android.exoplayer2.p052c.p058f;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.MpegAudioHeader;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.f.l */
final class MpegAudioReader extends ElementaryStreamReader {
    private final ParsableByteArray f3160a;
    private final MpegAudioHeader f3161b;
    private final String f3162c;
    private TrackOutput f3163d;
    private int f3164e;
    private int f3165f;
    private boolean f3166g;
    private boolean f3167h;
    private long f3168i;
    private int f3169j;
    private long f3170k;

    public MpegAudioReader() {
        this(null);
    }

    public MpegAudioReader(String str) {
        this.f3164e = 0;
        this.f3160a = new ParsableByteArray(4);
        this.f3160a.f3831a[0] = (byte) -1;
        this.f3161b = new MpegAudioHeader();
        this.f3162c = str;
    }

    public void m3650a() {
        this.f3164e = 0;
        this.f3165f = 0;
        this.f3167h = false;
    }

    public void m3652a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3163d = extractorOutput.m3725a(elementaryStreamReader.m3594a());
    }

    public void m3651a(long j, boolean z) {
        this.f3170k = j;
    }

    public void m3653a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 0) {
            switch (this.f3164e) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    m3647b(parsableByteArray);
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    m3648c(parsableByteArray);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    m3649d(parsableByteArray);
                    break;
                default:
                    break;
            }
        }
    }

    public void m3654b() {
    }

    private void m3647b(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f3831a;
        int d = parsableByteArray.m4456d();
        int c = parsableByteArray.m4454c();
        int i = d;
        while (i < c) {
            boolean z = (bArr[i] & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_MASK;
            if (this.f3167h && (bArr[i] & 224) == 224) {
                int i2 = 1;
            } else {
                boolean z2 = false;
            }
            this.f3167h = z;
            if (i2 != 0) {
                parsableByteArray.m4455c(i + 1);
                this.f3167h = false;
                this.f3160a.f3831a[1] = bArr[i];
                this.f3165f = 2;
                this.f3164e = 1;
                return;
            }
            i++;
        }
        parsableByteArray.m4455c(c);
    }

    private void m3648c(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.m4452b(), 4 - this.f3165f);
        parsableByteArray.m4451a(this.f3160a.f3831a, this.f3165f, min);
        this.f3165f = min + this.f3165f;
        if (this.f3165f >= 4) {
            this.f3160a.m4455c(0);
            if (MpegAudioHeader.m3733a(this.f3160a.m4468n(), this.f3161b)) {
                this.f3169j = this.f3161b.f3261c;
                if (!this.f3166g) {
                    this.f3168i = (1000000 * ((long) this.f3161b.f3265g)) / ((long) this.f3161b.f3262d);
                    this.f3163d.m3426a(Format.m2862a(null, this.f3161b.f3260b, null, -1, CodedOutputStream.DEFAULT_BUFFER_SIZE, this.f3161b.f3263e, this.f3161b.f3262d, null, null, 0, this.f3162c));
                    this.f3166g = true;
                }
                this.f3160a.m4455c(0);
                this.f3163d.m3427a(this.f3160a, 4);
                this.f3164e = 2;
                return;
            }
            this.f3165f = 0;
            this.f3164e = 1;
        }
    }

    private void m3649d(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.m4452b(), this.f3169j - this.f3165f);
        this.f3163d.m3427a(parsableByteArray, min);
        this.f3165f = min + this.f3165f;
        if (this.f3165f >= this.f3169j) {
            this.f3163d.m3425a(this.f3170k, 1, this.f3169j, 0, null);
            this.f3170k += this.f3168i;
            this.f3165f = 0;
            this.f3164e = 0;
        }
    }
}
