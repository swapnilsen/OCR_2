package com.google.android.exoplayer2.p052c.p058f;

import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p052c.ExtractorOutput;

/* renamed from: com.google.android.exoplayer2.c.f.g */
public abstract class ElementaryStreamReader {

    /* renamed from: com.google.android.exoplayer2.c.f.g.b */
    public interface ElementaryStreamReader {
        ElementaryStreamReader m3584a(int i, ElementaryStreamReader elementaryStreamReader);
    }

    /* renamed from: com.google.android.exoplayer2.c.f.g.a */
    public static final class ElementaryStreamReader {
        public final int f3058a;
        public String f3059b;
        public byte[] f3060c;

        public ElementaryStreamReader(int i, String str, byte[] bArr) {
            this.f3058a = i;
            this.f3059b = str;
            this.f3060c = bArr;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.g.c */
    public static final class ElementaryStreamReader {
        private final int f3061a;
        private final int f3062b;
        private int f3063c;

        public ElementaryStreamReader(int i, int i2) {
            this.f3061a = i;
            this.f3062b = i2;
        }

        public int m3594a() {
            int i = this.f3061a;
            int i2 = this.f3062b;
            int i3 = this.f3063c;
            this.f3063c = i3 + 1;
            return i + (i2 * i3);
        }
    }

    public abstract void m3551a();

    public abstract void m3552a(long j, boolean z);

    public abstract void m3553a(ExtractorOutput extractorOutput, ElementaryStreamReader elementaryStreamReader);

    public abstract void m3554a(ParsableByteArray parsableByteArray);

    public abstract void m3555b();
}
