package com.p013a.p014a.p015a.p018c;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonGenerator.JsonGenerator;
import com.p013a.p014a.p015a.JsonStreamContext;
import com.p013a.p014a.p015a.ObjectCodec;
import com.p013a.p014a.p015a.SerializableString;
import com.p013a.p014a.p015a.p017b.CharTypes;
import com.p013a.p014a.p015a.p017b.CharacterEscapes;
import com.p013a.p014a.p015a.p017b.IOContext;
import com.p013a.p014a.p015a.p017b.NumberOutput;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.c.h */
public final class WriterBasedJsonGenerator extends JsonGeneratorImpl {
    protected static final char[] f540m;
    protected final Writer f541n;
    protected char[] f542o;
    protected int f543p;
    protected int f544q;
    protected int f545r;
    protected char[] f546s;
    protected SerializableString f547t;

    static {
        f540m = CharTypes.m562g();
    }

    public WriterBasedJsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer) {
        super(iOContext, i, objectCodec);
        this.f543p = 0;
        this.f544q = 0;
        this.f541n = writer;
        this.f542o = iOContext.m579h();
        this.f545r = this.f542o.length;
    }

    public void m817a(String str) {
        boolean z = true;
        int a = this.e.m658a(str);
        if (a == 4) {
            m477f("Can not write a field name, expecting a value");
        }
        if (a != 1) {
            z = false;
        }
        m819a(str, z);
    }

    public void m828c() {
        m833e("start an array");
        this.e = this.e.m660h();
        if (this.a != null) {
            this.a.m936e(this);
            return;
        }
        if (this.f544q >= this.f545r) {
            m837k();
        }
        char[] cArr = this.f542o;
        int i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '[';
    }

    public void m830d() {
        if (!this.e.m641a()) {
            m477f("Current context not an ARRAY but " + this.e.m644d());
        }
        if (this.a != null) {
            this.a.m933b(this, this.e.m645e());
        } else {
            if (this.f544q >= this.f545r) {
                m837k();
            }
            char[] cArr = this.f542o;
            int i = this.f544q;
            this.f544q = i + 1;
            cArr[i] = ']';
        }
        this.e = this.e.m662j();
    }

    public void m832e() {
        m833e("start an object");
        this.e = this.e.m661i();
        if (this.a != null) {
            this.a.m932b(this);
            return;
        }
        if (this.f544q >= this.f545r) {
            m837k();
        }
        char[] cArr = this.f542o;
        int i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '{';
    }

    public void m834f() {
        if (!this.e.m643c()) {
            m477f("Current context not an object but " + this.e.m644d());
        }
        if (this.a != null) {
            this.a.m931a(this, this.e.m645e());
        } else {
            if (this.f544q >= this.f545r) {
                m837k();
            }
            char[] cArr = this.f542o;
            int i = this.f544q;
            this.f544q = i + 1;
            cArr[i] = '}';
        }
        this.e = this.e.m662j();
    }

    protected void m819a(String str, boolean z) {
        if (this.a != null) {
            m827b(str, z);
            return;
        }
        if (this.f544q + 1 >= this.f545r) {
            m837k();
        }
        if (z) {
            char[] cArr = this.f542o;
            int i = this.f544q;
            this.f544q = i + 1;
            cArr[i] = ',';
        }
        if (m474a(JsonGenerator.QUOTE_FIELD_NAMES)) {
            cArr = this.f542o;
            i = this.f544q;
            this.f544q = i + 1;
            cArr[i] = '\"';
            m809h(str);
            if (this.f544q >= this.f545r) {
                m837k();
            }
            cArr = this.f542o;
            i = this.f544q;
            this.f544q = i + 1;
            cArr[i] = '\"';
            return;
        }
        m809h(str);
    }

    protected void m827b(String str, boolean z) {
        if (z) {
            this.a.m934c(this);
        } else {
            this.a.m939h(this);
        }
        if (m474a(JsonGenerator.QUOTE_FIELD_NAMES)) {
            if (this.f544q >= this.f545r) {
                m837k();
            }
            char[] cArr = this.f542o;
            int i = this.f544q;
            this.f544q = i + 1;
            cArr[i] = '\"';
            m809h(str);
            if (this.f544q >= this.f545r) {
                m837k();
            }
            cArr = this.f542o;
            i = this.f544q;
            this.f544q = i + 1;
            cArr[i] = '\"';
            return;
        }
        m809h(str);
    }

    public void m826b(String str) {
        m833e("write text value");
        if (str == null) {
            m811l();
            return;
        }
        if (this.f544q >= this.f545r) {
            m837k();
        }
        char[] cArr = this.f542o;
        int i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '\"';
        m809h(str);
        if (this.f544q >= this.f545r) {
            m837k();
        }
        cArr = this.f542o;
        i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '\"';
    }

    public void m829c(String str) {
        int length = str.length();
        int i = this.f545r - this.f544q;
        if (i == 0) {
            m837k();
            i = this.f545r - this.f544q;
        }
        if (i >= length) {
            str.getChars(0, length, this.f542o, this.f544q);
            this.f544q += length;
            return;
        }
        m808g(str);
    }

    public void m825b(SerializableString serializableString) {
        m829c(serializableString.m602a());
    }

    public void m823a(char[] cArr, int i, int i2) {
        if (i2 < 32) {
            if (i2 > this.f545r - this.f544q) {
                m837k();
            }
            System.arraycopy(cArr, i, this.f542o, this.f544q, i2);
            this.f544q += i2;
            return;
        }
        m837k();
        this.f541n.write(cArr, i, i2);
    }

    public void m813a(char c) {
        if (this.f544q >= this.f545r) {
            m837k();
        }
        char[] cArr = this.f542o;
        int i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = c;
    }

    private void m808g(String str) {
        int i = this.f545r - this.f544q;
        str.getChars(0, i, this.f542o, this.f544q);
        this.f544q += i;
        m837k();
        int length = str.length() - i;
        while (length > this.f545r) {
            int i2 = this.f545r;
            str.getChars(i, i + i2, this.f542o, 0);
            this.f543p = 0;
            this.f544q = i2;
            m837k();
            i += i2;
            length -= i2;
        }
        str.getChars(i, i + length, this.f542o, 0);
        this.f543p = 0;
        this.f544q = length;
    }

    public void m824b(int i) {
        m833e("write number");
        if (this.d) {
            m803c(i);
            return;
        }
        if (this.f544q + 11 >= this.f545r) {
            m837k();
        }
        this.f544q = NumberOutput.m592a(i, this.f542o, this.f544q);
    }

    private void m803c(int i) {
        if (this.f544q + 13 >= this.f545r) {
            m837k();
        }
        char[] cArr = this.f542o;
        int i2 = this.f544q;
        this.f544q = i2 + 1;
        cArr[i2] = '\"';
        this.f544q = NumberOutput.m592a(i, this.f542o, this.f544q);
        cArr = this.f542o;
        i2 = this.f544q;
        this.f544q = i2 + 1;
        cArr[i2] = '\"';
    }

    public void m816a(long j) {
        m833e("write number");
        if (this.d) {
            m802b(j);
            return;
        }
        if (this.f544q + 21 >= this.f545r) {
            m837k();
        }
        this.f544q = NumberOutput.m595a(j, this.f542o, this.f544q);
    }

    private void m802b(long j) {
        if (this.f544q + 23 >= this.f545r) {
            m837k();
        }
        char[] cArr = this.f542o;
        int i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '\"';
        this.f544q = NumberOutput.m595a(j, this.f542o, this.f544q);
        cArr = this.f542o;
        i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '\"';
    }

    public void m821a(BigInteger bigInteger) {
        m833e("write number");
        if (bigInteger == null) {
            m811l();
        } else if (this.d) {
            m800a((Object) bigInteger);
        } else {
            m829c(bigInteger.toString());
        }
    }

    public void m814a(double d) {
        if (this.d || ((Double.isNaN(d) || Double.isInfinite(d)) && m474a(JsonGenerator.QUOTE_NON_NUMERIC_NUMBERS))) {
            m826b(String.valueOf(d));
            return;
        }
        m833e("write number");
        m829c(String.valueOf(d));
    }

    public void m815a(float f) {
        if (this.d || ((Float.isNaN(f) || Float.isInfinite(f)) && m474a(JsonGenerator.QUOTE_NON_NUMERIC_NUMBERS))) {
            m826b(String.valueOf(f));
            return;
        }
        m833e("write number");
        m829c(String.valueOf(f));
    }

    public void m820a(BigDecimal bigDecimal) {
        m833e("write number");
        if (bigDecimal == null) {
            m811l();
        } else if (this.d) {
            m800a((Object) bigDecimal);
        } else {
            m829c(bigDecimal.toString());
        }
    }

    public void m831d(String str) {
        m833e("write number");
        if (this.d) {
            m800a((Object) str);
        } else {
            m829c(str);
        }
    }

    private void m800a(Object obj) {
        if (this.f544q >= this.f545r) {
            m837k();
        }
        char[] cArr = this.f542o;
        int i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '\"';
        m829c(obj.toString());
        if (this.f544q >= this.f545r) {
            m837k();
        }
        cArr = this.f542o;
        i = this.f544q;
        this.f544q = i + 1;
        cArr[i] = '\"';
    }

    public void m822a(boolean z) {
        m833e("write boolean value");
        if (this.f544q + 5 >= this.f545r) {
            m837k();
        }
        int i = this.f544q;
        char[] cArr = this.f542o;
        if (z) {
            cArr[i] = 't';
            i++;
            cArr[i] = 'r';
            i++;
            cArr[i] = 'u';
            i++;
            cArr[i] = 'e';
        } else {
            cArr[i] = 'f';
            i++;
            cArr[i] = 'a';
            i++;
            cArr[i] = 'l';
            i++;
            cArr[i] = 's';
            i++;
            cArr[i] = 'e';
        }
        this.f544q = i + 1;
    }

    public void m835g() {
        m833e("write null value");
        m811l();
    }

    protected void m833e(String str) {
        int k = this.e.m663k();
        if (k == 5) {
            m477f("Can not " + str + ", expecting field name");
        }
        if (this.a == null) {
            char c;
            switch (k) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    c = ',';
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    c = ':';
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    if (this.l != null) {
                        m829c(this.l.m602a());
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.f544q >= this.f545r) {
                m837k();
            }
            this.f542o[this.f544q] = c;
            this.f544q++;
            return;
        }
        m818a(str, k);
    }

    protected void m818a(String str, int i) {
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                if (this.e.m641a()) {
                    this.a.m938g(this);
                } else if (this.e.m643c()) {
                    this.a.m939h(this);
                }
            case NendIconError.ERROR_ICONVIEW /*1*/:
                this.a.m937f(this);
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                this.a.m935d(this);
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                this.a.m930a(this);
            default:
                m480j();
        }
    }

    public void flush() {
        m837k();
        if (this.f541n != null && m474a(JsonGenerator.FLUSH_PASSED_TO_STREAM)) {
            this.f541n.flush();
        }
    }

    public void close() {
        super.close();
        if (this.f542o != null && m474a(JsonGenerator.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext h = m478h();
                if (!h.m641a()) {
                    if (!h.m643c()) {
                        break;
                    }
                    m834f();
                } else {
                    m830d();
                }
            }
        }
        m837k();
        if (this.f541n != null) {
            if (this.h.m574c() || m474a(JsonGenerator.AUTO_CLOSE_TARGET)) {
                this.f541n.close();
            } else if (m474a(JsonGenerator.FLUSH_PASSED_TO_STREAM)) {
                this.f541n.flush();
            }
        }
        m836i();
    }

    protected void m836i() {
        char[] cArr = this.f542o;
        if (cArr != null) {
            this.f542o = null;
            this.h.m572b(cArr);
        }
    }

    private void m809h(String str) {
        int length = str.length();
        if (length > this.f545r) {
            m810i(str);
            return;
        }
        if (this.f544q + length > this.f545r) {
            m837k();
        }
        str.getChars(0, length, this.f542o, this.f544q);
        if (this.k != null) {
            m806f(length);
        } else if (this.j != 0) {
            m799a(length, this.j);
        } else {
            m804d(length);
        }
    }

    private void m804d(int i) {
        int i2 = this.f544q + i;
        int[] iArr = this.i;
        char length = iArr.length;
        while (this.f544q < i2) {
            char c;
            int i3;
            while (true) {
                c = this.f542o[this.f544q];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i3 = this.f544q + 1;
                this.f544q = i3;
                if (i3 >= i2) {
                    return;
                }
            }
            i3 = this.f544q - this.f543p;
            if (i3 > 0) {
                this.f541n.write(this.f542o, this.f543p, i3);
            }
            char[] cArr = this.f542o;
            int i4 = this.f544q;
            this.f544q = i4 + 1;
            c = cArr[i4];
            m798a(c, iArr[c]);
        }
    }

    private void m810i(String str) {
        m837k();
        int length = str.length();
        int i = 0;
        do {
            int i2 = this.f545r;
            if (i + i2 > length) {
                i2 = length - i;
            }
            str.getChars(i, i + i2, this.f542o, 0);
            if (this.k != null) {
                m807g(i2);
            } else if (this.j != 0) {
                m801b(i2, this.j);
            } else {
                m805e(i2);
            }
            i += i2;
        } while (i < length);
    }

    private void m805e(int i) {
        int[] iArr = this.i;
        char length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            char c;
            do {
                c = this.f542o[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i2++;
            } while (i2 < i);
            int i4 = i2 - i3;
            if (i4 > 0) {
                this.f541n.write(this.f542o, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i4 = i2 + 1;
            i3 = m797a(this.f542o, i4, i, c, iArr[c]);
            i2 = i4;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m799a(int r10, int r11) {
        /*
        r9 = this;
        r0 = r9.f544q;
        r1 = r0 + r10;
        r2 = r9.i;
        r0 = r2.length;
        r3 = r11 + 1;
        r3 = java.lang.Math.min(r0, r3);
    L_0x000d:
        r0 = r9.f544q;
        if (r0 >= r1) goto L_0x0043;
    L_0x0011:
        r0 = r9.f542o;
        r4 = r9.f544q;
        r4 = r0[r4];
        if (r4 >= r3) goto L_0x0037;
    L_0x0019:
        r0 = r2[r4];
        if (r0 == 0) goto L_0x003b;
    L_0x001d:
        r5 = r9.f544q;
        r6 = r9.f543p;
        r5 = r5 - r6;
        if (r5 <= 0) goto L_0x002d;
    L_0x0024:
        r6 = r9.f541n;
        r7 = r9.f542o;
        r8 = r9.f543p;
        r6.write(r7, r8, r5);
    L_0x002d:
        r5 = r9.f544q;
        r5 = r5 + 1;
        r9.f544q = r5;
        r9.m798a(r4, r0);
        goto L_0x000d;
    L_0x0037:
        if (r4 <= r11) goto L_0x003b;
    L_0x0039:
        r0 = -1;
        goto L_0x001d;
    L_0x003b:
        r0 = r9.f544q;
        r0 = r0 + 1;
        r9.f544q = r0;
        if (r0 < r1) goto L_0x0011;
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.h.a(int, int):void");
    }

    private void m801b(int i, int i2) {
        int i3 = 0;
        int[] iArr = this.i;
        char min = Math.min(iArr.length, i2 + 1);
        int i4 = 0;
        int i5 = 0;
        while (i5 < i) {
            char c;
            int i6;
            do {
                c = this.f542o[i5];
                if (c < min) {
                    i6 = iArr[c];
                    if (i6 != 0) {
                        break;
                    }
                    i3 = i6;
                    i5++;
                } else {
                    if (c > i2) {
                        i6 = -1;
                        break;
                    }
                    i5++;
                }
            } while (i5 < i);
            i6 = i3;
            i3 = i5 - i4;
            if (i3 > 0) {
                this.f541n.write(this.f542o, i4, i3);
                if (i5 >= i) {
                    return;
                }
            }
            i4 = i5 + 1;
            i5 = i4;
            i4 = m797a(this.f542o, i4, i, c, i6);
            i3 = i6;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m806f(int r12) {
        /*
        r11 = this;
        r0 = r11.f544q;
        r2 = r0 + r12;
        r3 = r11.i;
        r0 = r11.j;
        r1 = 1;
        if (r0 >= r1) goto L_0x0041;
    L_0x000b:
        r0 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
    L_0x000e:
        r1 = r3.length;
        r4 = r0 + 1;
        r4 = java.lang.Math.min(r1, r4);
        r5 = r11.k;
    L_0x0017:
        r1 = r11.f544q;
        if (r1 >= r2) goto L_0x005a;
    L_0x001b:
        r1 = r11.f542o;
        r6 = r11.f544q;
        r6 = r1[r6];
        if (r6 >= r4) goto L_0x0044;
    L_0x0023:
        r1 = r3[r6];
        if (r1 == 0) goto L_0x0052;
    L_0x0027:
        r7 = r11.f544q;
        r8 = r11.f543p;
        r7 = r7 - r8;
        if (r7 <= 0) goto L_0x0037;
    L_0x002e:
        r8 = r11.f541n;
        r9 = r11.f542o;
        r10 = r11.f543p;
        r8.write(r9, r10, r7);
    L_0x0037:
        r7 = r11.f544q;
        r7 = r7 + 1;
        r11.f544q = r7;
        r11.m798a(r6, r1);
        goto L_0x0017;
    L_0x0041:
        r0 = r11.j;
        goto L_0x000e;
    L_0x0044:
        if (r6 <= r0) goto L_0x0048;
    L_0x0046:
        r1 = -1;
        goto L_0x0027;
    L_0x0048:
        r1 = r5.m564a(r6);
        r11.f547t = r1;
        if (r1 == 0) goto L_0x0052;
    L_0x0050:
        r1 = -2;
        goto L_0x0027;
    L_0x0052:
        r1 = r11.f544q;
        r1 = r1 + 1;
        r11.f544q = r1;
        if (r1 < r2) goto L_0x001b;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.h.f(int):void");
    }

    private void m807g(int i) {
        int i2 = 0;
        int[] iArr = this.i;
        char c = this.j < 1 ? SupportMenu.USER_MASK : this.j;
        char min = Math.min(iArr.length, c + 1);
        CharacterEscapes characterEscapes = this.k;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            char c2;
            int i5;
            do {
                c2 = this.f542o[i2];
                if (c2 < min) {
                    i5 = iArr[c2];
                    if (i5 != 0) {
                        break;
                    }
                    i4 = i5;
                    i2++;
                } else if (c2 > c) {
                    i5 = -1;
                    break;
                } else {
                    SerializableString a = characterEscapes.m564a(c2);
                    this.f547t = a;
                    if (a != null) {
                        i5 = -2;
                        break;
                    }
                    i2++;
                }
            } while (i2 < i);
            i5 = i4;
            i4 = i2 - i3;
            if (i4 > 0) {
                this.f541n.write(this.f542o, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i3 = i2 + 1;
            i2 = i3;
            i3 = m797a(this.f542o, i3, i, c2, i5);
            i4 = i5;
        }
    }

    private void m811l() {
        if (this.f544q + 4 >= this.f545r) {
            m837k();
        }
        int i = this.f544q;
        char[] cArr = this.f542o;
        cArr[i] = 'n';
        i++;
        cArr[i] = 'u';
        i++;
        cArr[i] = 'l';
        i++;
        cArr[i] = 'l';
        this.f544q = i + 1;
    }

    private void m798a(char c, int i) {
        int i2;
        int i3;
        char[] cArr;
        if (i >= 0) {
            if (this.f544q >= 2) {
                i2 = this.f544q - 2;
                this.f543p = i2;
                i3 = i2 + 1;
                this.f542o[i2] = '\\';
                this.f542o[i3] = (char) i;
                return;
            }
            cArr = this.f546s;
            if (cArr == null) {
                cArr = m812m();
            }
            this.f543p = this.f544q;
            cArr[1] = (char) i;
            this.f541n.write(cArr, 0, 2);
        } else if (i == -2) {
            String a;
            if (this.f547t == null) {
                a = this.k.m564a(c).m602a();
            } else {
                a = this.f547t.m602a();
                this.f547t = null;
            }
            r1 = a.length();
            if (this.f544q >= r1) {
                i3 = this.f544q - r1;
                this.f543p = i3;
                a.getChars(0, r1, this.f542o, i3);
                return;
            }
            this.f543p = this.f544q;
            this.f541n.write(a);
        } else if (this.f544q >= 6) {
            char[] cArr2 = this.f542o;
            i2 = this.f544q - 6;
            this.f543p = i2;
            cArr2[i2] = '\\';
            i2++;
            cArr2[i2] = 'u';
            if (c > '\u00ff') {
                i3 = (c >> 8) & MotionEventCompat.ACTION_MASK;
                i2++;
                cArr2[i2] = f540m[i3 >> 4];
                i2++;
                cArr2[i2] = f540m[i3 & 15];
                c = (char) (c & MotionEventCompat.ACTION_MASK);
            } else {
                i2++;
                cArr2[i2] = '0';
                i2++;
                cArr2[i2] = '0';
            }
            i2++;
            cArr2[i2] = f540m[c >> 4];
            cArr2[i2 + 1] = f540m[c & 15];
        } else {
            cArr = this.f546s;
            if (cArr == null) {
                cArr = m812m();
            }
            this.f543p = this.f544q;
            if (c > '\u00ff') {
                r1 = (c >> 8) & MotionEventCompat.ACTION_MASK;
                i3 = c & MotionEventCompat.ACTION_MASK;
                cArr[10] = f540m[r1 >> 4];
                cArr[11] = f540m[r1 & 15];
                cArr[12] = f540m[i3 >> 4];
                cArr[13] = f540m[i3 & 15];
                this.f541n.write(cArr, 8, 6);
                return;
            }
            cArr[6] = f540m[c >> 4];
            cArr[7] = f540m[c & 15];
            this.f541n.write(cArr, 2, 6);
        }
    }

    private int m797a(char[] cArr, int i, int i2, char c, int i3) {
        char[] cArr2;
        if (i3 >= 0) {
            if (i <= 1 || i >= i2) {
                cArr2 = this.f546s;
                if (cArr2 == null) {
                    cArr2 = m812m();
                }
                cArr2[1] = (char) i3;
                this.f541n.write(cArr2, 0, 2);
                return i;
            }
            i -= 2;
            cArr[i] = '\\';
            cArr[i + 1] = (char) i3;
            return i;
        } else if (i3 == -2) {
            String a;
            if (this.f547t == null) {
                a = this.k.m564a(c).m602a();
            } else {
                a = this.f547t.m602a();
                this.f547t = null;
            }
            r1 = a.length();
            if (i < r1 || i >= i2) {
                this.f541n.write(a);
                return i;
            }
            i -= r1;
            a.getChars(0, r1, cArr, i);
            return i;
        } else if (i <= 5 || i >= i2) {
            cArr2 = this.f546s;
            if (cArr2 == null) {
                cArr2 = m812m();
            }
            this.f543p = this.f544q;
            if (c > '\u00ff') {
                r1 = (c >> 8) & MotionEventCompat.ACTION_MASK;
                r2 = c & MotionEventCompat.ACTION_MASK;
                cArr2[10] = f540m[r1 >> 4];
                cArr2[11] = f540m[r1 & 15];
                cArr2[12] = f540m[r2 >> 4];
                cArr2[13] = f540m[r2 & 15];
                this.f541n.write(cArr2, 8, 6);
                return i;
            }
            cArr2[6] = f540m[c >> 4];
            cArr2[7] = f540m[c & 15];
            this.f541n.write(cArr2, 2, 6);
            return i;
        } else {
            int i4 = i - 6;
            r1 = i4 + 1;
            cArr[i4] = '\\';
            i4 = r1 + 1;
            cArr[r1] = 'u';
            if (c > '\u00ff') {
                r1 = (c >> 8) & MotionEventCompat.ACTION_MASK;
                r2 = i4 + 1;
                cArr[i4] = f540m[r1 >> 4];
                i4 = r2 + 1;
                cArr[r2] = f540m[r1 & 15];
                c = (char) (c & MotionEventCompat.ACTION_MASK);
            } else {
                r1 = i4 + 1;
                cArr[i4] = '0';
                i4 = r1 + 1;
                cArr[r1] = '0';
            }
            r1 = i4 + 1;
            cArr[i4] = f540m[c >> 4];
            cArr[r1] = f540m[c & 15];
            return r1 - 5;
        }
    }

    private char[] m812m() {
        char[] cArr = new char[14];
        cArr[0] = '\\';
        cArr[2] = '\\';
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = '\\';
        cArr[9] = 'u';
        this.f546s = cArr;
        return cArr;
    }

    protected void m837k() {
        int i = this.f544q - this.f543p;
        if (i > 0) {
            int i2 = this.f543p;
            this.f543p = 0;
            this.f544q = 0;
            this.f541n.write(this.f542o, i2, i);
        }
    }
}
