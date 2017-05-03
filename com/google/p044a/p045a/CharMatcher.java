package com.google.p044a.p045a;

import android.support.v7.cardview.C0269R;
import com.google.a.a.b.AnonymousClass10;
import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.api.client.http.HttpRequest;
import com.google.p044a.p045a.CharMatcher.CharMatcher;
import com.google.p044a.p045a.Preconditions;
import java.util.Arrays;

/* renamed from: com.google.a.a.b */
public abstract class CharMatcher {
    public static final CharMatcher f2206a;
    public static final CharMatcher f2207b;
    public static final CharMatcher f2208c;
    public static final CharMatcher f2209d;
    public static final CharMatcher f2210e;
    public static final CharMatcher f2211f;
    public static final CharMatcher f2212g;
    public static final CharMatcher f2213h;
    public static final CharMatcher f2214i;
    public static final CharMatcher f2215j;
    public static final CharMatcher f2216k;
    public static final CharMatcher f2217l;
    public static final CharMatcher f2218m;
    static final int f2219o;
    public static final CharMatcher f2220p;
    private static final String f2221q;
    final String f2222n;

    /* renamed from: com.google.a.a.b.a */
    static abstract class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }
    }

    /* compiled from: CharMatcher */
    /* renamed from: com.google.a.a.b.10 */
    static class AnonymousClass10 extends CharMatcher {
        AnonymousClass10(String str) {
            super(str);
        }

        public boolean m2760a(char c) {
            return false;
        }

        public com.google.p044a.p045a.CharMatcher m2759a(com.google.p044a.p045a.CharMatcher charMatcher) {
            return (com.google.p044a.p045a.CharMatcher) Preconditions.m2774a((Object) charMatcher);
        }
    }

    /* renamed from: com.google.a.a.b.1 */
    static class CharMatcher extends CharMatcher {
        CharMatcher() {
        }

        public boolean m2761a(char c) {
            switch (c) {
                case ConnectionResult.SERVICE_INVALID /*9*/:
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                case CommonStatusCodes.ERROR /*13*/:
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                case '\u0085':
                case '\u1680':
                case '\u2028':
                case '\u2029':
                case '\u205f':
                case '\u3000':
                    return true;
                case '\u2007':
                    return false;
                default:
                    if (c < '\u2000' || c > '\u200a') {
                        return false;
                    }
                    return true;
            }
        }

        public String toString() {
            return "CharMatcher.BREAKING_WHITESPACE";
        }
    }

    /* renamed from: com.google.a.a.b.2 */
    static class CharMatcher extends CharMatcher {
        final /* synthetic */ char f2223q;
        final /* synthetic */ char f2224r;

        CharMatcher(String str, char c, char c2) {
            this.f2223q = c;
            this.f2224r = c2;
            super(str);
        }

        public boolean m2762a(char c) {
            return this.f2223q <= c && c <= this.f2224r;
        }
    }

    /* renamed from: com.google.a.a.b.3 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m2763a(char c) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f\u00a0\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt((1682554634 * c) >>> o) == c;
        }
    }

    /* renamed from: com.google.a.a.b.4 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m2764a(char c) {
            return Character.isDigit(c);
        }
    }

    /* renamed from: com.google.a.a.b.5 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m2765a(char c) {
            return Character.isLetter(c);
        }
    }

    /* renamed from: com.google.a.a.b.6 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m2766a(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    /* renamed from: com.google.a.a.b.7 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m2767a(char c) {
            return Character.isUpperCase(c);
        }
    }

    /* renamed from: com.google.a.a.b.8 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m2768a(char c) {
            return Character.isLowerCase(c);
        }
    }

    /* renamed from: com.google.a.a.b.9 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m2770a(char c) {
            return true;
        }

        public CharMatcher m2769a(CharMatcher charMatcher) {
            Preconditions.m2774a((Object) charMatcher);
            return this;
        }
    }

    /* renamed from: com.google.a.a.b.b */
    private static class CharMatcher extends CharMatcher {
        final CharMatcher f2225q;
        final CharMatcher f2226r;

        CharMatcher(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.f2225q = (CharMatcher) Preconditions.m2774a((Object) charMatcher);
            this.f2226r = (CharMatcher) Preconditions.m2774a((Object) charMatcher2);
        }

        CharMatcher(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this(charMatcher, charMatcher2, "CharMatcher.or(" + charMatcher + ", " + charMatcher2 + ")");
        }

        public boolean m2772a(char c) {
            return this.f2225q.m2758a(c) || this.f2226r.m2758a(c);
        }

        CharMatcher m2771a(String str) {
            return new CharMatcher(this.f2225q, this.f2226r, str);
        }
    }

    /* renamed from: com.google.a.a.b.c */
    private static class CharMatcher extends CharMatcher {
        private final char[] f2227q;
        private final char[] f2228r;

        CharMatcher(String str, char[] cArr, char[] cArr2) {
            boolean z;
            super(str);
            this.f2227q = cArr;
            this.f2228r = cArr2;
            if (cArr.length == cArr2.length) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.m2778a(z);
            for (int i = 0; i < cArr.length; i++) {
                boolean z2;
                if (cArr[i] <= cArr2[i]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.m2778a(z2);
                if (i + 1 < cArr.length) {
                    if (cArr2[i] < cArr[i + 1]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Preconditions.m2778a(z2);
                }
            }
        }

        public boolean m2773a(char c) {
            int binarySearch = Arrays.binarySearch(this.f2227q, c);
            if (binarySearch >= 0) {
                return true;
            }
            binarySearch = (binarySearch ^ -1) - 1;
            if (binarySearch < 0 || c > this.f2228r[binarySearch]) {
                return false;
            }
            return true;
        }
    }

    public abstract boolean m2758a(char c);

    static {
        f2206a = new CharMatcher();
        f2207b = CharMatcher.m2754a('\u0000', '\u007f', "CharMatcher.ASCII");
        StringBuilder stringBuilder = new StringBuilder("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length());
        for (int i = 0; i < "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length(); i++) {
            stringBuilder.append((char) ("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".charAt(i) + 9));
        }
        f2221q = stringBuilder.toString();
        f2208c = new CharMatcher("CharMatcher.DIGIT", "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray(), f2221q.toCharArray());
        f2209d = new CharMatcher("CharMatcher.JAVA_DIGIT");
        f2210e = new CharMatcher("CharMatcher.JAVA_LETTER");
        f2211f = new CharMatcher("CharMatcher.JAVA_LETTER_OR_DIGIT");
        f2212g = new CharMatcher("CharMatcher.JAVA_UPPER_CASE");
        f2213h = new CharMatcher("CharMatcher.JAVA_LOWER_CASE");
        f2214i = CharMatcher.m2753a('\u0000', '\u001f').m2756a(CharMatcher.m2753a('\u007f', '\u009f')).m2757a("CharMatcher.JAVA_ISO_CONTROL");
        f2215j = new CharMatcher("CharMatcher.INVISIBLE", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), " \u00a0\u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f\u202f\u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        f2216k = new CharMatcher("CharMatcher.SINGLE_WIDTH", "\u0000\u05be\u05d0\u05f3\u0600\u0750\u0e00\u1e00\u2100\ufb50\ufe70\uff61".toCharArray(), "\u04f9\u05be\u05ea\u05f4\u06ff\u077f\u0e7f\u20af\u213a\ufdff\ufeff\uffdc".toCharArray());
        f2217l = new CharMatcher("CharMatcher.ANY");
        f2218m = new AnonymousClass10("CharMatcher.NONE");
        f2219o = Integer.numberOfLeadingZeros("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f\u00a0\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length() - 1);
        f2220p = new CharMatcher("WHITESPACE");
    }

    private static String m2755b(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher m2753a(char c, char c2) {
        Preconditions.m2778a(c2 >= c);
        return CharMatcher.m2754a(c, c2, "CharMatcher.inRange('" + CharMatcher.m2755b(c) + "', '" + CharMatcher.m2755b(c2) + "')");
    }

    static CharMatcher m2754a(char c, char c2, String str) {
        return new CharMatcher(str, c, c2);
    }

    CharMatcher(String str) {
        this.f2222n = str;
    }

    protected CharMatcher() {
        this.f2222n = super.toString();
    }

    public CharMatcher m2756a(CharMatcher charMatcher) {
        return new CharMatcher(this, (CharMatcher) Preconditions.m2774a((Object) charMatcher));
    }

    CharMatcher m2757a(String str) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return this.f2222n;
    }
}
