package com.google.android.exoplayer2.p064g.p069e;

import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p064g.SubtitleDecoderException;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.g.e.h */
public final class WebvttParserUtil {
    private static final Pattern f3551a;
    private static final Pattern f3552b;

    static {
        f3551a = Pattern.compile("^NOTE(( |\t).*)?$");
        f3552b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");
    }

    public static void m4183a(ParsableByteArray parsableByteArray) {
        Object x = parsableByteArray.m4478x();
        if (x == null || !f3552b.matcher(x).matches()) {
            throw new SubtitleDecoderException("Expected WEBVTT. Got " + x);
        }
    }

    public static long m4182a(String str) {
        int i = 0;
        long j = 0;
        String[] split = str.split("\\.", 2);
        String[] split2 = split[0].split(":");
        while (i < split2.length) {
            j = (j * 60) + Long.parseLong(split2[i]);
            i++;
        }
        return (Long.parseLong(split[1]) + (j * 1000)) * 1000;
    }

    public static float m4184b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
