package com.google.android.exoplayer2.p071k;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.CodecSpecificDataUtil;
import com.google.android.exoplayer2.p050j.NalUnitUtil.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.k.a */
public final class AvcConfig {
    public final List<byte[]> f3864a;
    public final int f3865b;
    public final int f3866c;
    public final int f3867d;
    public final float f3868e;

    public static AvcConfig m4532a(ParsableByteArray parsableByteArray) {
        int i = -1;
        int i2 = 0;
        try {
            parsableByteArray.m4457d(4);
            int g = (parsableByteArray.m4461g() & 3) + 1;
            if (g == 3) {
                throw new IllegalStateException();
            }
            int i3;
            List arrayList = new ArrayList();
            int g2 = parsableByteArray.m4461g() & 31;
            for (i3 = 0; i3 < g2; i3++) {
                arrayList.add(AvcConfig.m4533b(parsableByteArray));
            }
            i3 = parsableByteArray.m4461g();
            while (i2 < i3) {
                arrayList.add(AvcConfig.m4533b(parsableByteArray));
                i2++;
            }
            float f = 1.0f;
            if (g2 > 0) {
                NalUnitUtil a = com.google.android.exoplayer2.p050j.NalUnitUtil.m4432a((byte[]) arrayList.get(0), g, ((byte[]) arrayList.get(0)).length);
                i3 = a.f3814b;
                i = a.f3815c;
                f = a.f3816d;
            } else {
                i3 = -1;
            }
            return new AvcConfig(arrayList, g, i3, i, f);
        } catch (Throwable e) {
            throw new ParserException("Error parsing AVC config", e);
        }
    }

    private AvcConfig(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f3864a = list;
        this.f3865b = i;
        this.f3866c = i2;
        this.f3867d = i3;
        this.f3868e = f;
    }

    private static byte[] m4533b(ParsableByteArray parsableByteArray) {
        int h = parsableByteArray.m4462h();
        int d = parsableByteArray.m4456d();
        parsableByteArray.m4457d(h);
        return CodecSpecificDataUtil.m4410a(parsableByteArray.f3831a, d, h);
    }
}
