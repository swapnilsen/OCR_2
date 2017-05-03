package com.google.android.exoplayer2.p064g.p067c;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.g.c.d */
final class TtmlRenderUtil {
    public static TtmlStyle m4063a(TtmlStyle ttmlStyle, String[] strArr, Map<String, TtmlStyle> map) {
        if (ttmlStyle == null && strArr == null) {
            return null;
        }
        if (ttmlStyle == null && strArr.length == 1) {
            return (TtmlStyle) map.get(strArr[0]);
        }
        if (ttmlStyle == null && strArr.length > 1) {
            ttmlStyle = new TtmlStyle();
            for (Object obj : strArr) {
                ttmlStyle.m4072a((TtmlStyle) map.get(obj));
            }
            return ttmlStyle;
        } else if (ttmlStyle != null && strArr != null && strArr.length == 1) {
            return ttmlStyle.m4072a((TtmlStyle) map.get(strArr[0]));
        } else {
            if (ttmlStyle == null || strArr == null || strArr.length <= 1) {
                return ttmlStyle;
            }
            for (Object obj2 : strArr) {
                ttmlStyle.m4072a((TtmlStyle) map.get(obj2));
            }
            return ttmlStyle;
        }
    }

    public static void m4066a(SpannableStringBuilder spannableStringBuilder, int i, int i2, TtmlStyle ttmlStyle) {
        if (ttmlStyle.m4068a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(ttmlStyle.m4068a()), i, i2, 33);
        }
        if (ttmlStyle.m4078b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (ttmlStyle.m4081c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (ttmlStyle.m4085f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ttmlStyle.m4084e()), i, i2, 33);
        }
        if (ttmlStyle.m4087h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(ttmlStyle.m4086g()), i, i2, 33);
        }
        if (ttmlStyle.m4083d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(ttmlStyle.m4083d()), i, i2, 33);
        }
        if (ttmlStyle.m4089j() != null) {
            spannableStringBuilder.setSpan(new Standard(ttmlStyle.m4089j()), i, i2, 33);
        }
        if (ttmlStyle.m4090k() != -1) {
            switch (ttmlStyle.m4090k()) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) ttmlStyle.m4091l(), true), i, i2, 33);
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.m4091l()), i, i2, 33);
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.m4091l() / 100.0f), i, i2, 33);
                default:
            }
        }
    }

    static void m4065a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    static String m4064a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }
}
