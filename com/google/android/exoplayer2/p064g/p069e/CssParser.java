package com.google.android.exoplayer2.p064g.p069e;

import android.support.v7.cardview.C0269R;
import android.text.TextUtils;
import com.google.ads.AdSize;
import com.google.android.exoplayer2.p050j.ColorParser;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.g.e.a */
final class CssParser {
    private static final Pattern f3498a;
    private final ParsableByteArray f3499b;
    private final StringBuilder f3500c;

    static {
        f3498a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    }

    public CssParser() {
        this.f3499b = new ParsableByteArray();
        this.f3500c = new StringBuilder();
    }

    public WebvttCssStyle m4114a(ParsableByteArray parsableByteArray) {
        this.f3500c.setLength(0);
        int d = parsableByteArray.m4456d();
        CssParser.m4109c(parsableByteArray);
        this.f3499b.m4450a(parsableByteArray.f3831a, parsableByteArray.m4456d());
        this.f3499b.m4455c(d);
        String b = CssParser.m4106b(this.f3499b, this.f3500c);
        if (b == null || !"{".equals(CssParser.m4103a(this.f3499b, this.f3500c))) {
            return null;
        }
        WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
        m4104a(webvttCssStyle, b);
        int i = 0;
        Object obj = null;
        while (i == 0) {
            int d2 = this.f3499b.m4456d();
            obj = CssParser.m4103a(this.f3499b, this.f3500c);
            if (obj == null || "}".equals(obj)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                this.f3499b.m4455c(d2);
                CssParser.m4105a(this.f3499b, webvttCssStyle, this.f3500c);
            }
        }
        return !"}".equals(obj) ? null : webvttCssStyle;
    }

    private static String m4106b(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        CssParser.m4107b(parsableByteArray);
        if (parsableByteArray.m4452b() < 5) {
            return null;
        }
        if (!"::cue".equals(parsableByteArray.m4459e(5))) {
            return null;
        }
        int d = parsableByteArray.m4456d();
        String a = CssParser.m4103a(parsableByteArray, stringBuilder);
        if (a == null) {
            return null;
        }
        if ("{".equals(a)) {
            parsableByteArray.m4455c(d);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        String d2;
        if ("(".equals(a)) {
            d2 = CssParser.m4110d(parsableByteArray);
        } else {
            d2 = null;
        }
        a = CssParser.m4103a(parsableByteArray, stringBuilder);
        if (!")".equals(a) || a == null) {
            return null;
        }
        return d2;
    }

    private static String m4110d(ParsableByteArray parsableByteArray) {
        int d = parsableByteArray.m4456d();
        int c = parsableByteArray.m4454c();
        int i = d;
        Object obj = null;
        while (i < c && r0 == null) {
            int i2 = i + 1;
            if (((char) parsableByteArray.f3831a[i]) == ')') {
                obj = 1;
            } else {
                obj = null;
            }
            i = i2;
        }
        return parsableByteArray.m4459e((i - 1) - parsableByteArray.m4456d()).trim();
    }

    private static void m4105a(ParsableByteArray parsableByteArray, WebvttCssStyle webvttCssStyle, StringBuilder stringBuilder) {
        CssParser.m4107b(parsableByteArray);
        String d = CssParser.m4111d(parsableByteArray, stringBuilder);
        if (!FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(d) && ":".equals(CssParser.m4103a(parsableByteArray, stringBuilder))) {
            CssParser.m4107b(parsableByteArray);
            String c = CssParser.m4108c(parsableByteArray, stringBuilder);
            if (c != null && !FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(c)) {
                int d2 = parsableByteArray.m4456d();
                String a = CssParser.m4103a(parsableByteArray, stringBuilder);
                if (!";".equals(a)) {
                    if ("}".equals(a)) {
                        parsableByteArray.m4455c(d2);
                    } else {
                        return;
                    }
                }
                if ("color".equals(d)) {
                    webvttCssStyle.m4124a(ColorParser.m4415b(c));
                } else if ("background-color".equals(d)) {
                    webvttCssStyle.m4130b(ColorParser.m4415b(c));
                } else if ("text-decoration".equals(d)) {
                    if ("underline".equals(c)) {
                        webvttCssStyle.m4125a(true);
                    }
                } else if ("font-family".equals(d)) {
                    webvttCssStyle.m4136d(c);
                } else if ("font-weight".equals(d)) {
                    if ("bold".equals(c)) {
                        webvttCssStyle.m4131b(true);
                    }
                } else if ("font-style".equals(d) && "italic".equals(c)) {
                    webvttCssStyle.m4133c(true);
                }
            }
        }
    }

    static void m4107b(ParsableByteArray parsableByteArray) {
        Object obj = 1;
        while (parsableByteArray.m4452b() > 0 && r0 != null) {
            obj = (CssParser.m4112e(parsableByteArray) || CssParser.m4113f(parsableByteArray)) ? 1 : null;
        }
    }

    static String m4103a(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        CssParser.m4107b(parsableByteArray);
        if (parsableByteArray.m4452b() == 0) {
            return null;
        }
        String d = CssParser.m4111d(parsableByteArray, stringBuilder);
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(d) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING + ((char) parsableByteArray.m4461g()) : d;
    }

    private static boolean m4112e(ParsableByteArray parsableByteArray) {
        switch (CssParser.m4102a(parsableByteArray, parsableByteArray.m4456d())) {
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
            case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
            case CommonStatusCodes.ERROR /*13*/:
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                parsableByteArray.m4457d(1);
                return true;
            default:
                return false;
        }
    }

    static void m4109c(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.m4478x()));
    }

    private static char m4102a(ParsableByteArray parsableByteArray, int i) {
        return (char) parsableByteArray.f3831a[i];
    }

    private static String m4108c(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        Object obj = null;
        while (obj == null) {
            int d = parsableByteArray.m4456d();
            String a = CssParser.m4103a(parsableByteArray, stringBuilder);
            if (a == null) {
                return null;
            }
            if ("}".equals(a) || ";".equals(a)) {
                parsableByteArray.m4455c(d);
                obj = 1;
            } else {
                stringBuilder2.append(a);
            }
        }
        return stringBuilder2.toString();
    }

    private static boolean m4113f(ParsableByteArray parsableByteArray) {
        int d = parsableByteArray.m4456d();
        int c = parsableByteArray.m4454c();
        byte[] bArr = parsableByteArray.f3831a;
        if (d + 2 <= c) {
            int i = d + 1;
            if (bArr[d] == (byte) 47) {
                d = i + 1;
                if (bArr[i] == (byte) 42) {
                    i = d;
                    while (i + 1 < c) {
                        d = i + 1;
                        if (((char) bArr[i]) == '*' && ((char) bArr[d]) == '/') {
                            c = d + 1;
                            d = c;
                        }
                        i = d;
                    }
                    parsableByteArray.m4457d(c - parsableByteArray.m4456d());
                    return true;
                }
            }
        }
        return false;
    }

    private static String m4111d(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        int i = 0;
        stringBuilder.setLength(0);
        int d = parsableByteArray.m4456d();
        int c = parsableByteArray.m4454c();
        while (d < c && r0 == 0) {
            char c2 = (char) parsableByteArray.f3831a[d];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                i = 1;
            } else {
                d++;
                stringBuilder.append(c2);
            }
        }
        parsableByteArray.m4457d(d - parsableByteArray.m4456d());
        return stringBuilder.toString();
    }

    private void m4104a(WebvttCssStyle webvttCssStyle, String str) {
        if (!FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING.equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f3498a.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    webvttCssStyle.m4134c(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                webvttCssStyle.m4132b(str2.substring(0, indexOf2));
                webvttCssStyle.m4127a(str2.substring(indexOf2 + 1));
            } else {
                webvttCssStyle.m4132b(str2);
            }
            if (split.length > 1) {
                webvttCssStyle.m4128a((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
    }
}
