package com.google.android.exoplayer2.p064g.p069e;

import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.p064g.Subtitle;
import com.google.android.exoplayer2.p064g.SubtitleDecoderException;
import com.google.android.exoplayer2.p064g.p069e.WebvttCue.WebvttCue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.e.b */
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    private static final int f3501a;
    private static final int f3502b;
    private static final int f3503c;
    private final ParsableByteArray f3504d;
    private final WebvttCue f3505e;

    protected /* synthetic */ Subtitle m4116a(byte[] bArr, int i) {
        return m4117b(bArr, i);
    }

    static {
        f3501a = Util.m4524e("payl");
        f3502b = Util.m4524e("sttg");
        f3503c = Util.m4524e("vttc");
    }

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.f3504d = new ParsableByteArray();
        this.f3505e = new WebvttCue();
    }

    protected Mp4WebvttSubtitle m4117b(byte[] bArr, int i) {
        this.f3504d.m4450a(bArr, i);
        List arrayList = new ArrayList();
        while (this.f3504d.m4452b() > 0) {
            if (this.f3504d.m4452b() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int n = this.f3504d.m4468n();
            if (this.f3504d.m4468n() == f3503c) {
                arrayList.add(Mp4WebvttDecoder.m4115a(this.f3504d, this.f3505e, n - 8));
            } else {
                this.f3504d.m4457d(n - 8);
            }
        }
        return new Mp4WebvttSubtitle(arrayList);
    }

    private static Cue m4115a(ParsableByteArray parsableByteArray, WebvttCue webvttCue, int i) {
        webvttCue.m4152a();
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int n = parsableByteArray.m4468n();
            int n2 = parsableByteArray.m4468n();
            int i2 = i - 8;
            n -= 8;
            String str = new String(parsableByteArray.f3831a, parsableByteArray.m4456d(), n);
            parsableByteArray.m4457d(n);
            i = i2 - n;
            if (n2 == f3502b) {
                WebvttCueParser.m4167a(str, webvttCue);
            } else if (n2 == f3501a) {
                WebvttCueParser.m4169a(null, str.trim(), webvttCue, Collections.emptyList());
            }
        }
        return webvttCue.m4156b();
    }
}
