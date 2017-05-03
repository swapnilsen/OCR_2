package com.p013a.p014a.p015a.p019d;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.p020e.InternCache;
import java.util.Arrays;

/* renamed from: com.a.a.a.d.b */
public final class CharsToNameCanonicalizer {
    static final CharsToNameCanonicalizer f589a;
    protected CharsToNameCanonicalizer f590b;
    protected final boolean f591c;
    protected final boolean f592d;
    protected String[] f593e;
    protected CharsToNameCanonicalizer[] f594f;
    protected int f595g;
    protected int f596h;
    protected int f597i;
    protected int f598j;
    protected boolean f599k;
    private final int f600l;

    /* renamed from: com.a.a.a.d.b.a */
    static final class CharsToNameCanonicalizer {
        private final String f586a;
        private final CharsToNameCanonicalizer f587b;
        private final int f588c;

        public CharsToNameCanonicalizer(String str, CharsToNameCanonicalizer charsToNameCanonicalizer) {
            this.f586a = str;
            this.f587b = charsToNameCanonicalizer;
            this.f588c = charsToNameCanonicalizer == null ? 1 : charsToNameCanonicalizer.f588c + 1;
        }

        public String m871a() {
            return this.f586a;
        }

        public CharsToNameCanonicalizer m873b() {
            return this.f587b;
        }

        public int m874c() {
            return this.f588c;
        }

        public String m872a(char[] cArr, int i, int i2) {
            String str = this.f586a;
            CharsToNameCanonicalizer charsToNameCanonicalizer = this.f587b;
            while (true) {
                if (str.length() == i2) {
                    int i3 = 0;
                    while (str.charAt(i3) == cArr[i + i3]) {
                        i3++;
                        if (i3 >= i2) {
                            break;
                        }
                    }
                    if (i3 == i2) {
                        return str;
                    }
                }
                if (charsToNameCanonicalizer == null) {
                    return null;
                }
                str = charsToNameCanonicalizer.m871a();
                charsToNameCanonicalizer = charsToNameCanonicalizer.m873b();
            }
        }
    }

    static {
        f589a = new CharsToNameCanonicalizer();
    }

    public static CharsToNameCanonicalizer m875a() {
        long currentTimeMillis = System.currentTimeMillis();
        return CharsToNameCanonicalizer.m876a((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static CharsToNameCanonicalizer m876a(int i) {
        return f589a.m880f(i);
    }

    private CharsToNameCanonicalizer() {
        this.f592d = true;
        this.f591c = true;
        this.f599k = true;
        this.f600l = 0;
        this.f598j = 0;
        m878d(64);
    }

    private void m878d(int i) {
        this.f593e = new String[i];
        this.f594f = new CharsToNameCanonicalizer[(i >> 1)];
        this.f597i = i - 1;
        this.f595g = 0;
        this.f598j = 0;
        this.f596h = CharsToNameCanonicalizer.m879e(i);
    }

    private static int m879e(int i) {
        return i - (i >> 2);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2, String[] strArr, CharsToNameCanonicalizer[] charsToNameCanonicalizerArr, int i, int i2, int i3) {
        this.f590b = charsToNameCanonicalizer;
        this.f592d = z;
        this.f591c = z2;
        this.f593e = strArr;
        this.f594f = charsToNameCanonicalizerArr;
        this.f595g = i;
        this.f600l = i2;
        int length = strArr.length;
        this.f596h = CharsToNameCanonicalizer.m879e(length);
        this.f597i = length - 1;
        this.f598j = i3;
        this.f599k = false;
    }

    public CharsToNameCanonicalizer m885a(boolean z, boolean z2) {
        String[] strArr;
        CharsToNameCanonicalizer[] charsToNameCanonicalizerArr;
        int i;
        int i2;
        int i3;
        synchronized (this) {
            strArr = this.f593e;
            charsToNameCanonicalizerArr = this.f594f;
            i = this.f595g;
            i2 = this.f600l;
            i3 = this.f598j;
        }
        return new CharsToNameCanonicalizer(this, z, z2, strArr, charsToNameCanonicalizerArr, i, i2, i3);
    }

    private CharsToNameCanonicalizer m880f(int i) {
        return new CharsToNameCanonicalizer(null, true, true, this.f593e, this.f594f, this.f595g, i, this.f598j);
    }

    private void m877a(CharsToNameCanonicalizer charsToNameCanonicalizer) {
        if (charsToNameCanonicalizer.m889c() > 12000 || charsToNameCanonicalizer.f598j > 63) {
            synchronized (this) {
                m878d(64);
                this.f599k = false;
            }
        } else if (charsToNameCanonicalizer.m889c() > m889c()) {
            synchronized (this) {
                this.f593e = charsToNameCanonicalizer.f593e;
                this.f594f = charsToNameCanonicalizer.f594f;
                this.f595g = charsToNameCanonicalizer.f595g;
                this.f596h = charsToNameCanonicalizer.f596h;
                this.f597i = charsToNameCanonicalizer.f597i;
                this.f598j = charsToNameCanonicalizer.f598j;
                this.f599k = false;
            }
        }
    }

    public void m888b() {
        if (m891d() && this.f590b != null) {
            this.f590b.m877a(this);
            this.f599k = false;
        }
    }

    public int m889c() {
        return this.f595g;
    }

    public boolean m891d() {
        return this.f599k;
    }

    public int m892e() {
        return this.f600l;
    }

    public String m886a(char[] cArr, int i, int i2, int i3) {
        if (i2 < 1) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        }
        if (!this.f592d) {
            return new String(cArr, i, i2);
        }
        int i4;
        int b = m887b(i3);
        String str = this.f593e[b];
        if (str != null) {
            if (str.length() == i2) {
                i4 = 0;
                while (str.charAt(i4) == cArr[i + i4]) {
                    i4++;
                    if (i4 >= i2) {
                        break;
                    }
                }
                if (i4 == i2) {
                    return str;
                }
            }
            CharsToNameCanonicalizer charsToNameCanonicalizer = this.f594f[b >> 1];
            if (charsToNameCanonicalizer != null) {
                String a = charsToNameCanonicalizer.m872a(cArr, i, i2);
                if (a != null) {
                    return a;
                }
            }
        }
        if (!this.f599k) {
            m881f();
            this.f599k = true;
            i4 = b;
        } else if (this.f595g >= this.f596h) {
            m882g();
            i4 = m887b(m884a(cArr, i, i2));
        } else {
            i4 = b;
        }
        String str2 = new String(cArr, i, i2);
        if (this.f591c) {
            str2 = InternCache.f642a.m950a(str2);
        }
        this.f595g++;
        if (this.f593e[i4] == null) {
            this.f593e[i4] = str2;
            return str2;
        }
        i4 >>= 1;
        CharsToNameCanonicalizer charsToNameCanonicalizer2 = new CharsToNameCanonicalizer(str2, this.f594f[i4]);
        this.f594f[i4] = charsToNameCanonicalizer2;
        this.f598j = Math.max(charsToNameCanonicalizer2.m874c(), this.f598j);
        if (this.f598j <= MotionEventCompat.ACTION_MASK) {
            return str2;
        }
        m890c(MotionEventCompat.ACTION_MASK);
        return str2;
    }

    public int m887b(int i) {
        return ((i >>> 15) + i) & this.f597i;
    }

    public int m884a(char[] cArr, int i, int i2) {
        int i3 = this.f600l;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = cArr[i4] + (i3 * 33);
            i4++;
            i3 = i5;
        }
        return i3 == 0 ? 1 : i3;
    }

    public int m883a(String str) {
        int length = str.length();
        int i = this.f600l;
        int i2 = 0;
        while (i2 < length) {
            int charAt = str.charAt(i2) + (i * 33);
            i2++;
            i = charAt;
        }
        return i == 0 ? 1 : i;
    }

    private void m881f() {
        Object obj = this.f593e;
        int length = obj.length;
        this.f593e = new String[length];
        System.arraycopy(obj, 0, this.f593e, 0, length);
        obj = this.f594f;
        length = obj.length;
        this.f594f = new CharsToNameCanonicalizer[length];
        System.arraycopy(obj, 0, this.f594f, 0, length);
    }

    private void m882g() {
        int length = this.f593e.length;
        int i = length + length;
        if (i > AccessibilityNodeInfoCompat.ACTION_CUT) {
            this.f595g = 0;
            Arrays.fill(this.f593e, null);
            Arrays.fill(this.f594f, null);
            this.f599k = true;
            return;
        }
        int i2;
        String[] strArr = this.f593e;
        CharsToNameCanonicalizer[] charsToNameCanonicalizerArr = this.f594f;
        this.f593e = new String[i];
        this.f594f = new CharsToNameCanonicalizer[(i >> 1)];
        this.f597i = i - 1;
        this.f596h = CharsToNameCanonicalizer.m879e(i);
        i = 0;
        int i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            if (str != null) {
                i3++;
                int b = m887b(m883a(str));
                if (this.f593e[b] == null) {
                    this.f593e[b] = str;
                } else {
                    b >>= 1;
                    CharsToNameCanonicalizer charsToNameCanonicalizer = new CharsToNameCanonicalizer(str, this.f594f[b]);
                    this.f594f[b] = charsToNameCanonicalizer;
                    i = Math.max(i, charsToNameCanonicalizer.m874c());
                }
            }
        }
        length >>= 1;
        i2 = 0;
        int i4 = i3;
        i3 = i;
        while (i2 < length) {
            i = i3;
            for (CharsToNameCanonicalizer charsToNameCanonicalizer2 = charsToNameCanonicalizerArr[i2]; charsToNameCanonicalizer2 != null; charsToNameCanonicalizer2 = charsToNameCanonicalizer2.m873b()) {
                i4++;
                String a = charsToNameCanonicalizer2.m871a();
                int b2 = m887b(m883a(a));
                if (this.f593e[b2] == null) {
                    this.f593e[b2] = a;
                } else {
                    b2 >>= 1;
                    CharsToNameCanonicalizer charsToNameCanonicalizer3 = new CharsToNameCanonicalizer(a, this.f594f[b2]);
                    this.f594f[b2] = charsToNameCanonicalizer3;
                    i = Math.max(i, charsToNameCanonicalizer3.m874c());
                }
            }
            i2++;
            i3 = i;
        }
        this.f598j = i3;
        if (i4 != this.f595g) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this.f595g + " entries; now have " + i4 + ".");
        }
    }

    protected void m890c(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f595g + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }
}
