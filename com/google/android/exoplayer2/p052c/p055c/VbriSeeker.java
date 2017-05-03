package com.google.android.exoplayer2.p052c.p055c;

import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p052c.MpegAudioHeader;
import com.google.android.exoplayer2.p052c.p055c.Mp3Extractor.Mp3Extractor;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.c.c.d */
final class VbriSeeker implements Mp3Extractor {
    private final long[] f2677a;
    private final long[] f2678b;
    private final long f2679c;

    public static VbriSeeker m3284a(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        parsableByteArray.m4457d(10);
        int n = parsableByteArray.m4468n();
        if (n <= 0) {
            return null;
        }
        int i = mpegAudioHeader.f3262d;
        long a = Util.m4510a((long) n, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, (long) i);
        int h = parsableByteArray.m4462h();
        int h2 = parsableByteArray.m4462h();
        int h3 = parsableByteArray.m4462h();
        parsableByteArray.m4457d(2);
        long j3 = j + ((long) mpegAudioHeader.f3261c);
        long[] jArr = new long[(h + 1)];
        long[] jArr2 = new long[(h + 1)];
        jArr[0] = 0;
        jArr2[0] = j3;
        for (n = 1; n < jArr.length; n++) {
            int g;
            long j4;
            switch (h3) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    g = parsableByteArray.m4461g();
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    g = parsableByteArray.m4462h();
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    g = parsableByteArray.m4465k();
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    g = parsableByteArray.m4474t();
                    break;
                default:
                    return null;
            }
            j3 += (long) (g * h2);
            jArr[n] = (((long) n) * a) / ((long) h);
            if (j2 == -1) {
                j4 = j3;
            } else {
                j4 = Math.min(j2, j3);
            }
            jArr2[n] = j4;
        }
        return new VbriSeeker(jArr, jArr2, a);
    }

    private VbriSeeker(long[] jArr, long[] jArr2, long j) {
        this.f2677a = jArr;
        this.f2678b = jArr2;
        this.f2679c = j;
    }

    public boolean m3286a() {
        return true;
    }

    public long m3288b(long j) {
        return this.f2678b[Util.m4509a(this.f2677a, j, true, true)];
    }

    public long m3285a(long j) {
        return this.f2677a[Util.m4509a(this.f2678b, j, true, true)];
    }

    public long m3287b() {
        return this.f2679c;
    }
}
