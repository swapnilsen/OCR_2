package com.google.p044a.p046b;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.p044a.p045a.Ascii;
import com.google.p044a.p045a.CharMatcher;
import com.google.p044a.p045a.Preconditions;
import com.google.p044a.p046b.GwtWorkarounds.GwtWorkarounds;
import com.google.p044a.p047c.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

/* renamed from: com.google.a.b.a */
public abstract class BaseEncoding {
    private static final BaseEncoding f2242a;
    private static final BaseEncoding f2243b;
    private static final BaseEncoding f2244c;
    private static final BaseEncoding f2245d;
    private static final BaseEncoding f2246e;

    /* renamed from: com.google.a.b.a.a */
    private static final class BaseEncoding extends CharMatcher {
        final int f2229q;
        final int f2230r;
        final int f2231s;
        final int f2232t;
        private final String f2233u;
        private final char[] f2234v;
        private final byte[] f2235w;
        private final boolean[] f2236x;

        BaseEncoding(String str, char[] cArr) {
            int i = 0;
            this.f2233u = (String) Preconditions.m2774a((Object) str);
            this.f2234v = (char[]) Preconditions.m2774a((Object) cArr);
            try {
                this.f2230r = IntMath.m2809a(cArr.length, RoundingMode.UNNECESSARY);
                int min = Math.min(8, Integer.lowestOneBit(this.f2230r));
                this.f2231s = 8 / min;
                this.f2232t = this.f2230r / min;
                this.f2229q = cArr.length - 1;
                byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS];
                Arrays.fill(bArr, (byte) -1);
                for (min = 0; min < cArr.length; min++) {
                    char c = cArr[min];
                    Preconditions.m2780a(CharMatcher.f2207b.m2758a(c), "Non-ASCII character: %s", Character.valueOf(c));
                    Preconditions.m2780a(bArr[c] == (byte) -1, "Duplicate character: %s", Character.valueOf(c));
                    bArr[c] = (byte) min;
                }
                this.f2235w = bArr;
                boolean[] zArr = new boolean[this.f2231s];
                while (i < this.f2232t) {
                    zArr[IntMath.m2808a(i * 8, this.f2230r, RoundingMode.CEILING)] = true;
                    i++;
                }
                this.f2236x = zArr;
            } catch (Throwable e) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
            }
        }

        char m2784a(int i) {
            return this.f2234v[i];
        }

        private boolean m2782b() {
            for (char b : this.f2234v) {
                if (Ascii.m2751b(b)) {
                    return true;
                }
            }
            return false;
        }

        private boolean m2783c() {
            for (char c : this.f2234v) {
                if (Ascii.m2752c(c)) {
                    return true;
                }
            }
            return false;
        }

        BaseEncoding m2785a() {
            int i = 0;
            if (!m2783c()) {
                return this;
            }
            boolean z;
            if (m2782b()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.m2779a(z, (Object) "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f2234v.length];
            while (i < this.f2234v.length) {
                cArr[i] = Ascii.m2750a(this.f2234v[i]);
                i++;
            }
            return new BaseEncoding(this.f2233u + ".lowerCase()", cArr);
        }

        public boolean m2786a(char c) {
            return CharMatcher.f2207b.m2758a(c) && this.f2235w[c] != -1;
        }

        public String toString() {
            return this.f2233u;
        }
    }

    /* renamed from: com.google.a.b.a.b */
    static final class BaseEncoding extends BaseEncoding {
        private final BaseEncoding f2247a;
        private final Character f2248b;
        private transient BaseEncoding f2249c;

        /* renamed from: com.google.a.b.a.b.1 */
        class BaseEncoding implements GwtWorkarounds {
            int f2237a;
            int f2238b;
            int f2239c;
            final /* synthetic */ GwtWorkarounds f2240d;
            final /* synthetic */ BaseEncoding f2241e;

            BaseEncoding(BaseEncoding baseEncoding, GwtWorkarounds gwtWorkarounds) {
                this.f2241e = baseEncoding;
                this.f2240d = gwtWorkarounds;
                this.f2237a = 0;
                this.f2238b = 0;
                this.f2239c = 0;
            }

            public void m2790a(byte b) {
                this.f2237a <<= 8;
                this.f2237a |= b & MotionEventCompat.ACTION_MASK;
                this.f2238b += 8;
                while (this.f2238b >= this.f2241e.f2247a.f2230r) {
                    this.f2240d.m2803a(this.f2241e.f2247a.m2784a((this.f2237a >> (this.f2238b - this.f2241e.f2247a.f2230r)) & this.f2241e.f2247a.f2229q));
                    this.f2239c++;
                    this.f2238b -= this.f2241e.f2247a.f2230r;
                }
            }

            public void m2789a() {
                if (this.f2238b > 0) {
                    this.f2240d.m2803a(this.f2241e.f2247a.m2784a((this.f2237a << (this.f2241e.f2247a.f2230r - this.f2238b)) & this.f2241e.f2247a.f2229q));
                    this.f2239c++;
                    if (this.f2241e.f2248b != null) {
                        while (this.f2239c % this.f2241e.f2247a.f2231s != 0) {
                            this.f2240d.m2803a(this.f2241e.f2248b.charValue());
                            this.f2239c++;
                        }
                    }
                }
                this.f2240d.m2802a();
            }
        }

        BaseEncoding(String str, String str2, Character ch) {
            this(new BaseEncoding(str, str2.toCharArray()), ch);
        }

        BaseEncoding(BaseEncoding baseEncoding, Character ch) {
            boolean z;
            this.f2247a = (BaseEncoding) Preconditions.m2774a((Object) baseEncoding);
            if (ch == null || !baseEncoding.m2786a(ch.charValue())) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.m2780a(z, "Padding character %s was already in alphabet", ch);
            this.f2248b = ch;
        }

        int m2799a(int i) {
            return this.f2247a.f2231s * IntMath.m2808a(i, this.f2247a.f2232t, RoundingMode.CEILING);
        }

        GwtWorkarounds m2801a(GwtWorkarounds gwtWorkarounds) {
            Preconditions.m2774a((Object) gwtWorkarounds);
            return new BaseEncoding(this, gwtWorkarounds);
        }

        public BaseEncoding m2800a() {
            BaseEncoding baseEncoding = this.f2249c;
            if (baseEncoding == null) {
                BaseEncoding a = this.f2247a.m2785a();
                baseEncoding = a == this.f2247a ? this : new BaseEncoding(a, this.f2248b);
                this.f2249c = baseEncoding;
            }
            return baseEncoding;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
            stringBuilder.append(this.f2247a.toString());
            if (8 % this.f2247a.f2230r != 0) {
                if (this.f2248b == null) {
                    stringBuilder.append(".omitPadding()");
                } else {
                    stringBuilder.append(".withPadChar(").append(this.f2248b).append(')');
                }
            }
            return stringBuilder.toString();
        }
    }

    abstract int m2792a(int i);

    public abstract BaseEncoding m2793a();

    abstract GwtWorkarounds m2794a(GwtWorkarounds gwtWorkarounds);

    BaseEncoding() {
    }

    public String m2795a(byte[] bArr) {
        return m2796a((byte[]) Preconditions.m2774a((Object) bArr), 0, bArr.length);
    }

    public final String m2796a(byte[] bArr, int i, int i2) {
        Preconditions.m2774a((Object) bArr);
        Preconditions.m2777a(i, i + i2, bArr.length);
        GwtWorkarounds a = GwtWorkarounds.m2806a(m2792a(i2));
        GwtWorkarounds a2 = m2794a(a);
        int i3 = 0;
        while (i3 < i2) {
            try {
                a2.m2788a(bArr[i + i3]);
                i3++;
            } catch (IOException e) {
                throw new AssertionError("impossible");
            }
        }
        a2.m2787a();
        return a.toString();
    }

    static {
        f2242a = new BaseEncoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
        f2243b = new BaseEncoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
        f2244c = new BaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
        f2245d = new BaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
        f2246e = new BaseEncoding("base16()", "0123456789ABCDEF", null);
    }

    public static BaseEncoding m2791b() {
        return f2246e;
    }
}
