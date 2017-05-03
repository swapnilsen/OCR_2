package com.google.android.exoplayer2.p064g.p069e;

import android.text.TextUtils;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p064g.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.p064g.Subtitle;
import com.google.android.exoplayer2.p064g.SubtitleDecoderException;
import com.google.android.exoplayer2.p064g.p069e.WebvttCue.WebvttCue;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.e.g */
public final class WebvttDecoder extends SimpleSubtitleDecoder {
    private final WebvttCueParser f3546a;
    private final ParsableByteArray f3547b;
    private final WebvttCue f3548c;
    private final CssParser f3549d;
    private final List<WebvttCssStyle> f3550e;

    protected /* synthetic */ Subtitle m4180a(byte[] bArr, int i) {
        return m4181b(bArr, i);
    }

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.f3546a = new WebvttCueParser();
        this.f3547b = new ParsableByteArray();
        this.f3548c = new WebvttCue();
        this.f3549d = new CssParser();
        this.f3550e = new ArrayList();
    }

    protected WebvttSubtitle m4181b(byte[] bArr, int i) {
        this.f3547b.m4450a(bArr, i);
        this.f3548c.m4152a();
        this.f3550e.clear();
        WebvttParserUtil.m4183a(this.f3547b);
        do {
        } while (!TextUtils.isEmpty(this.f3547b.m4478x()));
        List arrayList = new ArrayList();
        while (true) {
            int a = WebvttDecoder.m4178a(this.f3547b);
            if (a == 0) {
                return new WebvttSubtitle(arrayList);
            }
            if (a == 1) {
                WebvttDecoder.m4179b(this.f3547b);
            } else if (a == 2) {
                if (!arrayList.isEmpty()) {
                    break;
                }
                this.f3547b.m4478x();
                WebvttCssStyle a2 = this.f3549d.m4114a(this.f3547b);
                if (a2 != null) {
                    this.f3550e.add(a2);
                }
            } else if (a == 3 && this.f3546a.m4177a(this.f3547b, this.f3548c, this.f3550e)) {
                arrayList.add(this.f3548c.m4156b());
                this.f3548c.m4152a();
            }
        }
        throw new SubtitleDecoderException("A style block was found after the first cue.");
    }

    private static int m4178a(ParsableByteArray parsableByteArray) {
        int i = 0;
        int i2 = -1;
        while (i2 == -1) {
            i2 = parsableByteArray.m4456d();
            String x = parsableByteArray.m4478x();
            if (x == null) {
                i = 0;
            } else if ("STYLE".equals(x)) {
                i = 2;
            } else if ("NOTE".startsWith(x)) {
                i = 1;
            } else {
                i = 3;
            }
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        parsableByteArray.m4455c(i);
        return i2;
    }

    private static void m4179b(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.m4478x()));
    }
}
