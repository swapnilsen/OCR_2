package com.google.android.exoplayer2.p064g.p068d;

import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.p064g.Subtitle;

/* renamed from: com.google.android.exoplayer2.g.d.a */
public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private final ParsableByteArray f3494a;

    public Tx3gDecoder() {
        super("Tx3gDecoder");
        this.f3494a = new ParsableByteArray();
    }

    protected Subtitle m4096a(byte[] bArr, int i) {
        this.f3494a.m4450a(bArr, i);
        int h = this.f3494a.m4462h();
        if (h == 0) {
            return Tx3gSubtitle.f3495a;
        }
        return new Tx3gSubtitle(new Cue(this.f3494a.m4459e(h)));
    }
}
