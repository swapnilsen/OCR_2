package com.google.android.exoplayer2.p052c.p053a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p053a.TagPayloadReader.TagPayloadReader;
import com.google.android.exoplayer2.p071k.AvcConfig;

/* renamed from: com.google.android.exoplayer2.c.a.e */
final class VideoTagPayloadReader extends TagPayloadReader {
    private final ParsableByteArray f2545b;
    private final ParsableByteArray f2546c;
    private int f2547d;
    private boolean f2548e;
    private int f2549f;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.f2545b = new ParsableByteArray(NalUnitUtil.f3823a);
        this.f2546c = new ParsableByteArray(4);
    }

    protected boolean m3157a(ParsableByteArray parsableByteArray) {
        int g = parsableByteArray.m4461g();
        int i = (g >> 4) & 15;
        g &= 15;
        if (g != 7) {
            throw new TagPayloadReader("Video format not supported: " + g);
        }
        this.f2549f = i;
        return i != 5;
    }

    protected void m3156a(ParsableByteArray parsableByteArray, long j) {
        int g = parsableByteArray.m4461g();
        long k = (((long) parsableByteArray.m4465k()) * 1000) + j;
        if (g == 0 && !this.f2548e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.m4452b()]);
            parsableByteArray.m4451a(parsableByteArray2.f3831a, 0, parsableByteArray.m4452b());
            AvcConfig a = AvcConfig.m4532a(parsableByteArray2);
            this.f2547d = a.f3865b;
            this.a.m3426a(Format.m2858a(null, "video/avc", null, -1, -1, a.f3866c, a.f3867d, -1.0f, a.f3864a, -1, a.f3868e, null));
            this.f2548e = true;
        } else if (g == 1) {
            byte[] bArr = this.f2546c.f3831a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            g = 4 - this.f2547d;
            int i = 0;
            while (parsableByteArray.m4452b() > 0) {
                parsableByteArray.m4451a(this.f2546c.f3831a, g, this.f2547d);
                this.f2546c.m4455c(0);
                int t = this.f2546c.m4474t();
                this.f2545b.m4455c(0);
                this.a.m3427a(this.f2545b, 4);
                int i2 = i + 4;
                this.a.m3427a(parsableByteArray, t);
                i = i2 + t;
            }
            this.a.m3425a(k, this.f2549f == 1 ? 1 : 0, i, 0, null);
        }
    }
}
