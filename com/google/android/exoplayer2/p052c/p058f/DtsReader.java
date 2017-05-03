package com.google.android.exoplayer2.p052c.p058f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p048a.DtsUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;
import com.google.android.exoplayer2.p052c.TrackOutput;
import com.google.android.exoplayer2.p052c.p058f.ElementaryStreamReader.ElementaryStreamReader;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.f.f */
final class DtsReader extends ElementaryStreamReader {
    private final ParsableByteArray f3048a;
    private final String f3049b;
    private TrackOutput f3050c;
    private int f3051d;
    private int f3052e;
    private int f3053f;
    private long f3054g;
    private Format f3055h;
    private int f3056i;
    private long f3057j;

    public DtsReader(String str) {
        this.f3048a = new ParsableByteArray(new byte[15]);
        this.f3048a.f3831a[0] = Byte.MAX_VALUE;
        this.f3048a.f3831a[1] = (byte) -2;
        this.f3048a.f3831a[2] = Byte.MIN_VALUE;
        this.f3048a.f3831a[3] = (byte) 1;
        this.f3051d = 0;
        this.f3049b = str;
    }

    public void m3589a() {
        this.f3051d = 0;
        this.f3052e = 0;
        this.f3053f = 0;
    }

    public void m3591a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader) {
        this.f3050c = extractorOutput.m3725a(elementaryStreamReader.m3594a());
    }

    public void m3590a(long j, boolean z) {
        this.f3057j = j;
    }

    public void m3592a(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 0) {
            switch (this.f3051d) {
                case NendAdIconLayout.HORIZONTAL /*0*/:
                    if (!m3587b(parsableByteArray)) {
                        break;
                    }
                    this.f3052e = 4;
                    this.f3051d = 1;
                    break;
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    if (!m3586a(parsableByteArray, this.f3048a.f3831a, 15)) {
                        break;
                    }
                    m3588c();
                    this.f3048a.m4455c(0);
                    this.f3050c.m3427a(this.f3048a, 15);
                    this.f3051d = 2;
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    int min = Math.min(parsableByteArray.m4452b(), this.f3056i - this.f3052e);
                    this.f3050c.m3427a(parsableByteArray, min);
                    this.f3052e = min + this.f3052e;
                    if (this.f3052e != this.f3056i) {
                        break;
                    }
                    this.f3050c.m3425a(this.f3057j, 1, this.f3056i, 0, null);
                    this.f3057j += this.f3054g;
                    this.f3051d = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void m3593b() {
    }

    private boolean m3586a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.m4452b(), i - this.f3052e);
        parsableByteArray.m4451a(bArr, this.f3052e, min);
        this.f3052e = min + this.f3052e;
        return this.f3052e == i;
    }

    private boolean m3587b(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m4452b() > 0) {
            this.f3053f <<= 8;
            this.f3053f |= parsableByteArray.m4461g();
            if (this.f3053f == 2147385345) {
                this.f3053f = 0;
                return true;
            }
        }
        return false;
    }

    private void m3588c() {
        byte[] bArr = this.f3048a.f3831a;
        if (this.f3055h == null) {
            this.f3055h = DtsUtil.m2958a(bArr, null, this.f3049b, null);
            this.f3050c.m3426a(this.f3055h);
        }
        this.f3056i = DtsUtil.m2959b(bArr);
        this.f3054g = (long) ((int) ((((long) DtsUtil.m2957a(bArr)) * 1000000) / ((long) this.f3055h.f2336q)));
    }
}
