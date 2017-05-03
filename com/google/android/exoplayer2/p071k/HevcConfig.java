package com.google.android.exoplayer2.p071k;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p050j.NalUnitUtil;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.k.b */
public final class HevcConfig {
    public final List<byte[]> f3869a;
    public final int f3870b;

    public static HevcConfig m4534a(ParsableByteArray parsableByteArray) {
        try {
            int h;
            int i;
            int i2;
            parsableByteArray.m4457d(21);
            int g = parsableByteArray.m4461g() & 3;
            int g2 = parsableByteArray.m4461g();
            int d = parsableByteArray.m4456d();
            int i3 = 0;
            int i4 = 0;
            while (i3 < g2) {
                parsableByteArray.m4457d(1);
                h = parsableByteArray.m4462h();
                i = i4;
                for (i2 = 0; i2 < h; i2++) {
                    i4 = parsableByteArray.m4462h();
                    i += i4 + 4;
                    parsableByteArray.m4457d(i4);
                }
                i3++;
                i4 = i;
            }
            parsableByteArray.m4455c(d);
            Object obj = new byte[i4];
            i3 = 0;
            i2 = 0;
            while (i3 < g2) {
                parsableByteArray.m4457d(1);
                h = parsableByteArray.m4462h();
                i = i2;
                for (i2 = 0; i2 < h; i2++) {
                    int h2 = parsableByteArray.m4462h();
                    System.arraycopy(NalUnitUtil.f3823a, 0, obj, i, NalUnitUtil.f3823a.length);
                    i += NalUnitUtil.f3823a.length;
                    System.arraycopy(parsableByteArray.f3831a, parsableByteArray.m4456d(), obj, i, h2);
                    i += h2;
                    parsableByteArray.m4457d(h2);
                }
                i3++;
                i2 = i;
            }
            return new HevcConfig(i4 == 0 ? null : Collections.singletonList(obj), g + 1);
        } catch (Throwable e) {
            throw new ParserException("Error parsing HEVC config", e);
        }
    }

    private HevcConfig(List<byte[]> list, int i) {
        this.f3869a = list;
        this.f3870b = i;
    }
}
