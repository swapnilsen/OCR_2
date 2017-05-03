package com.google.android.exoplayer2.p064g.p069e;

import android.support.v7.appcompat.C0268R;
import android.text.Layout.Alignment;
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
import android.util.Log;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p064g.p069e.WebvttCue.WebvttCue;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.g.e.f */
final class WebvttCueParser {
    public static final Pattern f3543a;
    private static final Pattern f3544b;
    private final StringBuilder f3545c;

    /* renamed from: com.google.android.exoplayer2.g.e.f.a */
    private static final class WebvttCueParser {
        private static final String[] f3536e;
        public final String f3537a;
        public final int f3538b;
        public final String f3539c;
        public final String[] f3540d;

        static {
            f3536e = new String[0];
        }

        private WebvttCueParser(String str, int i, String str2, String[] strArr) {
            this.f3538b = i;
            this.f3537a = str;
            this.f3539c = str2;
            this.f3540d = strArr;
        }

        public static WebvttCueParser m4161a(String str, int i) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            String str2;
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = trim;
                trim = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
            } else {
                String trim2 = trim.substring(indexOf).trim();
                str2 = trim.substring(0, indexOf);
                trim = trim2;
            }
            String[] split = str2.split("\\.");
            String str3 = split[0];
            if (split.length > 1) {
                split = (String[]) Arrays.copyOfRange(split, 1, split.length);
            } else {
                split = f3536e;
            }
            return new WebvttCueParser(str3, i, trim, split);
        }

        public static WebvttCueParser m4160a() {
            return new WebvttCueParser(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING, new String[0]);
        }
    }

    /* renamed from: com.google.android.exoplayer2.g.e.f.b */
    private static final class WebvttCueParser implements Comparable<WebvttCueParser> {
        public final int f3541a;
        public final WebvttCssStyle f3542b;

        public /* synthetic */ int compareTo(Object obj) {
            return m4162a((WebvttCueParser) obj);
        }

        public WebvttCueParser(int i, WebvttCssStyle webvttCssStyle) {
            this.f3541a = i;
            this.f3542b = webvttCssStyle;
        }

        public int m4162a(WebvttCueParser webvttCueParser) {
            return this.f3541a - webvttCueParser.f3541a;
        }
    }

    static {
        f3543a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        f3544b = Pattern.compile("(\\S+?):(\\S+)");
    }

    public WebvttCueParser() {
        this.f3545c = new StringBuilder();
    }

    boolean m4177a(ParsableByteArray parsableByteArray, WebvttCue webvttCue, List<WebvttCssStyle> list) {
        Object x = parsableByteArray.m4478x();
        Matcher matcher = f3543a.matcher(x);
        if (matcher.matches()) {
            return WebvttCueParser.m4171a(null, matcher, parsableByteArray, webvttCue, this.f3545c, list);
        }
        matcher = f3543a.matcher(parsableByteArray.m4478x());
        if (!matcher.matches()) {
            return false;
        }
        return WebvttCueParser.m4171a(x.trim(), matcher, parsableByteArray, webvttCue, this.f3545c, list);
    }

    static void m4167a(String str, WebvttCue webvttCue) {
        Matcher matcher = f3544b.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    WebvttCueParser.m4173b(group2, webvttCue);
                } else if ("align".equals(group)) {
                    webvttCue.m4150a(WebvttCueParser.m4172b(group2));
                } else if ("position".equals(group)) {
                    WebvttCueParser.m4174c(group2, webvttCue);
                } else if ("size".equals(group)) {
                    webvttCue.m4157c(WebvttParserUtil.m4184b(group2));
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException e) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static void m4169a(String str, String str2, WebvttCue webvttCue, List<WebvttCssStyle> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        List arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            int indexOf;
            switch (charAt) {
                case C0268R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                    WebvttCueParser.m4166a(str2.substring(i + 1, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i = indexOf + 1;
                    break;
                case C0268R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*60*/:
                    if (i + 1 < str2.length()) {
                        Object obj = str2.charAt(i + 1) == '/' ? 1 : null;
                        indexOf = WebvttCueParser.m4164a(str2, i + 1);
                        Object obj2 = str2.charAt(indexOf + -2) == '/' ? 1 : null;
                        String substring = str2.substring((obj != null ? 2 : 1) + i, obj2 != null ? indexOf - 2 : indexOf - 1);
                        String d = WebvttCueParser.m4176d(substring);
                        if (d != null) {
                            if (WebvttCueParser.m4175c(d)) {
                                if (obj == null) {
                                    if (obj2 == null) {
                                        stack.push(WebvttCueParser.m4161a(substring, spannableStringBuilder.length()));
                                        i = indexOf;
                                        break;
                                    }
                                }
                                while (!stack.isEmpty()) {
                                    WebvttCueParser webvttCueParser = (WebvttCueParser) stack.pop();
                                    WebvttCueParser.m4168a(str, webvttCueParser, spannableStringBuilder, list, arrayList);
                                    if (webvttCueParser.f3537a.equals(d)) {
                                        i = indexOf;
                                        break;
                                    }
                                }
                                i = indexOf;
                            } else {
                                i = indexOf;
                                break;
                            }
                        }
                        i = indexOf;
                        break;
                    }
                    i++;
                    break;
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            WebvttCueParser.m4168a(str, (WebvttCueParser) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        WebvttCueParser.m4168a(str, WebvttCueParser.m4160a(), spannableStringBuilder, list, arrayList);
        webvttCue.m4151a(spannableStringBuilder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4171a(java.lang.String r6, java.util.regex.Matcher r7, com.google.android.exoplayer2.p050j.ParsableByteArray r8, com.google.android.exoplayer2.p064g.p069e.WebvttCue.WebvttCue r9, java.lang.StringBuilder r10, java.util.List<com.google.android.exoplayer2.p064g.p069e.WebvttCssStyle> r11) {
        /*
        r0 = 1;
        r1 = 0;
        r2 = 1;
        r2 = r7.group(r2);	 Catch:{ NumberFormatException -> 0x0045 }
        r2 = com.google.android.exoplayer2.p064g.p069e.WebvttParserUtil.m4182a(r2);	 Catch:{ NumberFormatException -> 0x0045 }
        r2 = r9.m4149a(r2);	 Catch:{ NumberFormatException -> 0x0045 }
        r3 = 2;
        r3 = r7.group(r3);	 Catch:{ NumberFormatException -> 0x0045 }
        r4 = com.google.android.exoplayer2.p064g.p069e.WebvttParserUtil.m4182a(r3);	 Catch:{ NumberFormatException -> 0x0045 }
        r2.m4155b(r4);	 Catch:{ NumberFormatException -> 0x0045 }
        r2 = 3;
        r2 = r7.group(r2);
        com.google.android.exoplayer2.p064g.p069e.WebvttCueParser.m4167a(r2, r9);
        r10.setLength(r1);
    L_0x0026:
        r1 = r8.m4478x();
        if (r1 == 0) goto L_0x0064;
    L_0x002c:
        r2 = r1.isEmpty();
        if (r2 != 0) goto L_0x0064;
    L_0x0032:
        r2 = r10.length();
        if (r2 <= 0) goto L_0x003d;
    L_0x0038:
        r2 = "\n";
        r10.append(r2);
    L_0x003d:
        r1 = r1.trim();
        r10.append(r1);
        goto L_0x0026;
    L_0x0045:
        r0 = move-exception;
        r0 = "WebvttCueParser";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Skipping cue with bad header: ";
        r2 = r2.append(r3);
        r3 = r7.group();
        r2 = r2.append(r3);
        r2 = r2.toString();
        android.util.Log.w(r0, r2);
        r0 = r1;
    L_0x0063:
        return r0;
    L_0x0064:
        r1 = r10.toString();
        com.google.android.exoplayer2.p064g.p069e.WebvttCueParser.m4169a(r6, r1, r9, r11);
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.e.f.a(java.lang.String, java.util.regex.Matcher, com.google.android.exoplayer2.j.k, com.google.android.exoplayer2.g.e.e$a, java.lang.StringBuilder, java.util.List):boolean");
    }

    private static void m4173b(String str, WebvttCue webvttCue) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCue.m4154b(WebvttCueParser.m4163a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            webvttCue.m4154b((int) RtlSpacingHelper.UNDEFINED);
        }
        if (str.endsWith("%")) {
            webvttCue.m4147a(WebvttParserUtil.m4184b(str)).m4148a(0);
        } else {
            webvttCue.m4147a((float) Integer.parseInt(str)).m4148a(1);
        }
    }

    private static void m4174c(String str, WebvttCue webvttCue) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCue.m4158c(WebvttCueParser.m4163a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            webvttCue.m4158c((int) RtlSpacingHelper.UNDEFINED);
        }
        webvttCue.m4153b(WebvttParserUtil.m4184b(str));
    }

    private static int m4163a(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    i = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    i = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    i = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return 0;
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return 1;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return 2;
            default:
                Log.w("WebvttCueParser", "Invalid anchor value: " + str);
                return RtlSpacingHelper.UNDEFINED;
        }
    }

    private static Alignment m4172b(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    obj = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    obj = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    obj = 4;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    obj = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    obj = 5;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return Alignment.ALIGN_NORMAL;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return Alignment.ALIGN_CENTER;
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.OTHER_PROFILE /*5*/:
                return Alignment.ALIGN_OPPOSITE;
            default:
                Log.w("WebvttCueParser", "Invalid alignment value: " + str);
                return null;
        }
    }

    private static int m4164a(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void m4166a(String str, SpannableStringBuilder spannableStringBuilder) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    obj = 1;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    obj = null;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    obj = 3;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                spannableStringBuilder.append('<');
            case NendIconError.ERROR_ICONVIEW /*1*/:
                spannableStringBuilder.append('>');
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                spannableStringBuilder.append(' ');
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                spannableStringBuilder.append('&');
            default:
                Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
        }
    }

    private static boolean m4175c(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case C0268R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                if (str.equals("b")) {
                    z = false;
                    break;
                }
                break;
            case C0268R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /*99*/:
                if (str.equals("c")) {
                    z = true;
                    break;
                }
                break;
            case C0268R.styleable.AppCompatTheme_checkedTextViewStyle /*105*/:
                if (str.equals("i")) {
                    z = true;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    z = true;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    z = true;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
            case NendIconError.ERROR_ICONVIEW /*1*/:
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.OTHER_PROFILE /*5*/:
                return true;
            default:
                return false;
        }
    }

    private static void m4168a(String str, WebvttCueParser webvttCueParser, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list, List<WebvttCueParser> list2) {
        int i = webvttCueParser.f3538b;
        int length = spannableStringBuilder.length();
        String str2 = webvttCueParser.f3537a;
        int i2 = -1;
        switch (str2.hashCode()) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                if (str2.equals(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING)) {
                    i2 = 6;
                    break;
                }
                break;
            case C0268R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                if (str2.equals("b")) {
                    i2 = 0;
                    break;
                }
                break;
            case C0268R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /*99*/:
                if (str2.equals("c")) {
                    i2 = 3;
                    break;
                }
                break;
            case C0268R.styleable.AppCompatTheme_checkedTextViewStyle /*105*/:
                if (str2.equals("i")) {
                    i2 = 1;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    i2 = 2;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    i2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    i2 = 4;
                    break;
                }
                break;
        }
        switch (i2) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case NendIconError.ERROR_ICONVIEW /*1*/:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
            case Type.OTHER_PROFILE /*5*/:
            case Type.CONTRIBUTOR /*6*/:
                break;
            default:
                return;
        }
        list2.clear();
        WebvttCueParser.m4170a((List) list, str, webvttCueParser, (List) list2);
        int size = list2.size();
        for (i2 = 0; i2 < size; i2++) {
            WebvttCueParser.m4165a(spannableStringBuilder, ((WebvttCueParser) list2.get(i2)).f3542b, i, length);
        }
    }

    private static void m4165a(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i, int i2) {
        if (webvttCssStyle != null) {
            if (webvttCssStyle.m4129b() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(webvttCssStyle.m4129b()), i, i2, 33);
            }
            if (webvttCssStyle.m4135c()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
            if (webvttCssStyle.m4137d()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (webvttCssStyle.m4140g()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(webvttCssStyle.m4139f()), i, i2, 33);
            }
            if (webvttCssStyle.m4142i()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(webvttCssStyle.m4141h()), i, i2, 33);
            }
            if (webvttCssStyle.m4138e() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(webvttCssStyle.m4138e()), i, i2, 33);
            }
            if (webvttCssStyle.m4143j() != null) {
                spannableStringBuilder.setSpan(new Standard(webvttCssStyle.m4143j()), i, i2, 33);
            }
            if (webvttCssStyle.m4144k() != -1) {
                switch (webvttCssStyle.m4144k()) {
                    case NendIconError.ERROR_ICONVIEW /*1*/:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) webvttCssStyle.m4145l(), true), i, i2, 33);
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.m4145l()), i, i2, 33);
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.m4145l() / 100.0f), i, i2, 33);
                    default:
                }
            }
        }
    }

    private static String m4176d(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim.split("[ \\.]")[0];
    }

    private static void m4170a(List<WebvttCssStyle> list, String str, WebvttCueParser webvttCueParser, List<WebvttCueParser> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            WebvttCssStyle webvttCssStyle = (WebvttCssStyle) list.get(i);
            int a = webvttCssStyle.m4123a(str, webvttCueParser.f3537a, webvttCueParser.f3540d, webvttCueParser.f3539c);
            if (a > 0) {
                list2.add(new WebvttCueParser(a, webvttCssStyle));
            }
        }
        Collections.sort(list2);
    }
}
