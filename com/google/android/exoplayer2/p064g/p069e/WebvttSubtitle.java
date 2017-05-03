package com.google.android.exoplayer2.p064g.p069e;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Util;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.Subtitle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.g.e.i */
final class WebvttSubtitle implements Subtitle {
    private final List<WebvttCue> f3553a;
    private final int f3554b;
    private final long[] f3555c;
    private final long[] f3556d;

    public WebvttSubtitle(List<WebvttCue> list) {
        this.f3553a = list;
        this.f3554b = list.size();
        this.f3555c = new long[(this.f3554b * 2)];
        for (int i = 0; i < this.f3554b; i++) {
            WebvttCue webvttCue = (WebvttCue) list.get(i);
            int i2 = i * 2;
            this.f3555c[i2] = webvttCue.f3534i;
            this.f3555c[i2 + 1] = webvttCue.f3535j;
        }
        this.f3556d = Arrays.copyOf(this.f3555c, this.f3555c.length);
        Arrays.sort(this.f3556d);
    }

    public int m4185a(long j) {
        int b = Util.m4520b(this.f3556d, j, false, false);
        return b < this.f3556d.length ? b : -1;
    }

    public int m4187b() {
        return this.f3556d.length;
    }

    public long m4186a(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m4404a(z);
        if (i >= this.f3556d.length) {
            z2 = false;
        }
        Assertions.m4404a(z2);
        return this.f3556d[i];
    }

    public List<Cue> m4188b(long j) {
        CharSequence charSequence = null;
        int i = 0;
        WebvttCue webvttCue = null;
        ArrayList arrayList = null;
        while (i < this.f3554b) {
            CharSequence charSequence2;
            WebvttCue webvttCue2;
            ArrayList arrayList2;
            CharSequence charSequence3;
            if (this.f3555c[i * 2] > j || j >= this.f3555c[(i * 2) + 1]) {
                charSequence2 = charSequence;
                webvttCue2 = webvttCue;
                arrayList2 = arrayList;
                charSequence3 = charSequence2;
            } else {
                ArrayList arrayList3;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                } else {
                    arrayList3 = arrayList;
                }
                WebvttCue webvttCue3 = (WebvttCue) this.f3553a.get(i);
                if (!webvttCue3.m4159a()) {
                    arrayList3.add(webvttCue3);
                    charSequence3 = charSequence;
                    webvttCue2 = webvttCue;
                    arrayList2 = arrayList3;
                } else if (webvttCue == null) {
                    arrayList2 = arrayList3;
                    WebvttCue webvttCue4 = webvttCue3;
                    charSequence3 = charSequence;
                    webvttCue2 = webvttCue4;
                } else if (charSequence == null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(webvttCue.a).append("\n").append(webvttCue3.a);
                    Object obj = spannableStringBuilder;
                    webvttCue2 = webvttCue;
                    arrayList2 = arrayList3;
                } else {
                    charSequence.append("\n").append(webvttCue3.a);
                    charSequence3 = charSequence;
                    webvttCue2 = webvttCue;
                    arrayList2 = arrayList3;
                }
            }
            i++;
            charSequence2 = charSequence3;
            arrayList = arrayList2;
            webvttCue = webvttCue2;
            charSequence = charSequence2;
        }
        if (charSequence != null) {
            arrayList.add(new WebvttCue(charSequence));
        } else if (webvttCue != null) {
            arrayList.add(webvttCue);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
