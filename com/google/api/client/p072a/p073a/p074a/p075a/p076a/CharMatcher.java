package com.google.api.client.p072a.p073a.p074a.p075a.p076a;

import android.support.v7.cardview.C0269R;
import com.google.ads.AdSize;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.api.client.a.a.a.a.a.b.AnonymousClass10;
import com.google.api.client.a.a.a.a.a.b.AnonymousClass11;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.p072a.p073a.p074a.p075a.p076a.CharMatcher.CharMatcher;
import com.google.api.client.p072a.p073a.p074a.p075a.p076a.Preconditions;
import java.util.Arrays;

/* renamed from: com.google.api.client.a.a.a.a.a.b */
public abstract class CharMatcher {
    public static final CharMatcher f4049a;
    public static final CharMatcher f4050b;
    public static final CharMatcher f4051c;
    public static final CharMatcher f4052d;
    public static final CharMatcher f4053e;
    public static final CharMatcher f4054f;
    public static final CharMatcher f4055g;
    public static final CharMatcher f4056h;
    public static final CharMatcher f4057i;
    public static final CharMatcher f4058j;
    public static final CharMatcher f4059k;
    public static final CharMatcher f4060l;
    public static final CharMatcher f4061m;
    static final int f4062o;
    public static final CharMatcher f4063p;
    private static final String f4064q;
    final String f4065n;

    /* renamed from: com.google.api.client.a.a.a.a.a.b.a */
    static abstract class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }
    }

    /* compiled from: CharMatcher */
    /* renamed from: com.google.api.client.a.a.a.a.a.b.10 */
    static class AnonymousClass10 extends CharMatcher {
        AnonymousClass10(String str) {
            super(str);
        }

        public boolean m4730b(char c) {
            return false;
        }

        public int m4728a(CharSequence charSequence, int i) {
            Preconditions.m4748a(i, charSequence.length());
            return -1;
        }

        public com.google.api.client.p072a.p073a.p074a.p075a.p076a.CharMatcher m4729a(com.google.api.client.p072a.p073a.p074a.p075a.p076a.CharMatcher charMatcher) {
            return (com.google.api.client.p072a.p073a.p074a.p075a.p076a.CharMatcher) Preconditions.m4750a((Object) charMatcher);
        }
    }

    /* compiled from: CharMatcher */
    /* renamed from: com.google.api.client.a.a.a.a.a.b.11 */
    static class AnonymousClass11 extends CharMatcher {
        final /* synthetic */ char f4066q;

        AnonymousClass11(String str, char c) {
            this.f4066q = c;
            super(str);
        }

        public boolean m4732b(char c) {
            return c == this.f4066q;
        }

        public com.google.api.client.p072a.p073a.p074a.p075a.p076a.CharMatcher m4731a(com.google.api.client.p072a.p073a.p074a.p075a.p076a.CharMatcher charMatcher) {
            return charMatcher.m4727b(this.f4066q) ? charMatcher : super.m4725a(charMatcher);
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.1 */
    static class CharMatcher extends CharMatcher {
        CharMatcher() {
        }

        public boolean m4733b(char c) {
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

    /* renamed from: com.google.api.client.a.a.a.a.a.b.2 */
    static class CharMatcher extends CharMatcher {
        final /* synthetic */ char f4067q;
        final /* synthetic */ char f4068r;

        CharMatcher(String str, char c, char c2) {
            this.f4067q = c;
            this.f4068r = c2;
            super(str);
        }

        public boolean m4734b(char c) {
            return this.f4067q <= c && c <= this.f4068r;
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.3 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m4735b(char c) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f\u00a0\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt((1682554634 * c) >>> o) == c;
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.4 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m4736b(char c) {
            return Character.isDigit(c);
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.5 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m4737b(char c) {
            return Character.isLetter(c);
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.6 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m4738b(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.7 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m4739b(char c) {
            return Character.isUpperCase(c);
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.8 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m4740b(char c) {
            return Character.isLowerCase(c);
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.9 */
    static class CharMatcher extends CharMatcher {
        CharMatcher(String str) {
            super(str);
        }

        public boolean m4743b(char c) {
            return true;
        }

        public int m4741a(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.m4748a(i, length);
            return i == length ? -1 : i;
        }

        public CharMatcher m4742a(CharMatcher charMatcher) {
            Preconditions.m4750a((Object) charMatcher);
            return this;
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.b */
    private static class CharMatcher extends CharMatcher {
        final CharMatcher f4069q;
        final CharMatcher f4070r;

        CharMatcher(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.f4069q = (CharMatcher) Preconditions.m4750a((Object) charMatcher);
            this.f4070r = (CharMatcher) Preconditions.m4750a((Object) charMatcher2);
        }

        CharMatcher(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this(charMatcher, charMatcher2, "CharMatcher.or(" + charMatcher + ", " + charMatcher2 + ")");
        }

        public boolean m4745b(char c) {
            return this.f4069q.m4727b(c) || this.f4070r.m4727b(c);
        }

        CharMatcher m4744a(String str) {
            return new CharMatcher(this.f4069q, this.f4070r, str);
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.b.c */
    private static class CharMatcher extends CharMatcher {
        private final char[] f4071q;
        private final char[] f4072r;

        CharMatcher(String str, char[] cArr, char[] cArr2) {
            boolean z;
            super(str);
            this.f4071q = cArr;
            this.f4072r = cArr2;
            if (cArr.length == cArr2.length) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.m4754a(z);
            for (int i = 0; i < cArr.length; i++) {
                boolean z2;
                if (cArr[i] <= cArr2[i]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.m4754a(z2);
                if (i + 1 < cArr.length) {
                    if (cArr2[i] < cArr[i + 1]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Preconditions.m4754a(z2);
                }
            }
        }

        public boolean m4746b(char c) {
            int binarySearch = Arrays.binarySearch(this.f4071q, c);
            if (binarySearch >= 0) {
                return true;
            }
            binarySearch = (binarySearch ^ -1) - 1;
            if (binarySearch < 0 || c > this.f4072r[binarySearch]) {
                return false;
            }
            return true;
        }
    }

    public abstract boolean m4727b(char c);

    static {
        f4049a = new CharMatcher();
        f4050b = CharMatcher.m4722a('\u0000', '\u007f', "CharMatcher.ASCII");
        StringBuilder stringBuilder = new StringBuilder("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length());
        for (int i = 0; i < "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length(); i++) {
            stringBuilder.append((char) ("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".charAt(i) + 9));
        }
        f4064q = stringBuilder.toString();
        f4051c = new CharMatcher("CharMatcher.DIGIT", "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray(), f4064q.toCharArray());
        f4052d = new CharMatcher("CharMatcher.JAVA_DIGIT");
        f4053e = new CharMatcher("CharMatcher.JAVA_LETTER");
        f4054f = new CharMatcher("CharMatcher.JAVA_LETTER_OR_DIGIT");
        f4055g = new CharMatcher("CharMatcher.JAVA_UPPER_CASE");
        f4056h = new CharMatcher("CharMatcher.JAVA_LOWER_CASE");
        f4057i = CharMatcher.m4721a('\u0000', '\u001f').m4725a(CharMatcher.m4721a('\u007f', '\u009f')).m4726a("CharMatcher.JAVA_ISO_CONTROL");
        f4058j = new CharMatcher("CharMatcher.INVISIBLE", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), " \u00a0\u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f\u202f\u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        f4059k = new CharMatcher("CharMatcher.SINGLE_WIDTH", "\u0000\u05be\u05d0\u05f3\u0600\u0750\u0e00\u1e00\u2100\ufb50\ufe70\uff61".toCharArray(), "\u04f9\u05be\u05ea\u05f4\u06ff\u077f\u0e7f\u20af\u213a\ufdff\ufeff\uffdc".toCharArray());
        f4060l = new CharMatcher("CharMatcher.ANY");
        f4061m = new AnonymousClass10("CharMatcher.NONE");
        f4062o = Integer.numberOfLeadingZeros("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f\u00a0\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length() - 1);
        f4063p = new CharMatcher("WHITESPACE");
    }

    private static String m4723c(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher m4720a(char c) {
        return new AnonymousClass11("CharMatcher.is('" + CharMatcher.m4723c(c) + "')", c);
    }

    public static CharMatcher m4721a(char c, char c2) {
        Preconditions.m4754a(c2 >= c);
        return CharMatcher.m4722a(c, c2, "CharMatcher.inRange('" + CharMatcher.m4723c(c) + "', '" + CharMatcher.m4723c(c2) + "')");
    }

    static CharMatcher m4722a(char c, char c2, String str) {
        return new CharMatcher(str, c, c2);
    }

    CharMatcher(String str) {
        this.f4065n = str;
    }

    protected CharMatcher() {
        this.f4065n = super.toString();
    }

    public CharMatcher m4725a(CharMatcher charMatcher) {
        return new CharMatcher(this, (CharMatcher) Preconditions.m4750a((Object) charMatcher));
    }

    CharMatcher m4726a(String str) {
        throw new UnsupportedOperationException();
    }

    public int m4724a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.m4748a(i, length);
        for (int i2 = i; i2 < length; i2++) {
            if (m4727b(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public String toString() {
        return this.f4065n;
    }
}
