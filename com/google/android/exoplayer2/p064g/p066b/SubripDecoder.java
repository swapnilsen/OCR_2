package com.google.android.exoplayer2.p064g.p066b;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.p050j.LongArray;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.p064g.Subtitle;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.g.b.a */
public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final Pattern f3439a;
    private static final Pattern f3440b;
    private final StringBuilder f3441c;

    protected /* synthetic */ Subtitle m4031a(byte[] bArr, int i) {
        return m4032b(bArr, i);
    }

    static {
        f3439a = Pattern.compile("(\\S*)\\s*-->\\s*(\\S*)");
        f3440b = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+),(\\d+)");
    }

    public SubripDecoder() {
        super("SubripDecoder");
        this.f3441c = new StringBuilder();
    }

    protected SubripSubtitle m4032b(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        while (true) {
            String x = parsableByteArray.m4478x();
            if (x == null) {
                Cue[] cueArr = new Cue[arrayList.size()];
                arrayList.toArray(cueArr);
                return new SubripSubtitle(cueArr, longArray.m4424b());
            } else if (x.length() != 0) {
                try {
                    Integer.parseInt(x);
                    Object x2 = parsableByteArray.m4478x();
                    Matcher matcher = f3439a.matcher(x2);
                    if (matcher.find()) {
                        int i2;
                        longArray.m4423a(SubripDecoder.m4030a(matcher.group(1)));
                        if (TextUtils.isEmpty(matcher.group(2))) {
                            i2 = 0;
                        } else {
                            longArray.m4423a(SubripDecoder.m4030a(matcher.group(2)));
                            i2 = 1;
                        }
                        this.f3441c.setLength(0);
                        while (true) {
                            Object x3 = parsableByteArray.m4478x();
                            if (TextUtils.isEmpty(x3)) {
                                break;
                            }
                            if (this.f3441c.length() > 0) {
                                this.f3441c.append("<br>");
                            }
                            this.f3441c.append(x3.trim());
                        }
                        arrayList.add(new Cue(Html.fromHtml(this.f3441c.toString())));
                        if (i2 != 0) {
                            arrayList.add(null);
                        }
                    } else {
                        Log.w("SubripDecoder", "Skipping invalid timing: " + x2);
                    }
                } catch (NumberFormatException e) {
                    Log.w("SubripDecoder", "Skipping invalid index: " + x);
                }
            }
        }
    }

    private static long m4030a(String str) {
        Matcher matcher = f3440b.matcher(str);
        if (matcher.matches()) {
            return (Long.parseLong(matcher.group(4)) + (((((Long.parseLong(matcher.group(1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(2)) * 60) * 1000)) + (Long.parseLong(matcher.group(3)) * 1000))) * 1000;
        }
        throw new NumberFormatException("has invalid format");
    }
}
