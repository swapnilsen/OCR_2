package com.p013a.p014a.p015a.p018c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.ads.AdRequest;
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
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.c.f */
public class UTF8JsonGenerator extends JsonGeneratorImpl {
    static final byte[] f517m;
    private static final byte[] f518v;
    private static final byte[] f519w;
    private static final byte[] f520x;
    protected final OutputStream f521n;
    protected byte[] f522o;
    protected int f523p;
    protected final int f524q;
    protected final int f525r;
    protected char[] f526s;
    protected final int f527t;
    protected boolean f528u;

    static {
        f517m = CharTypes.m563h();
        f518v = new byte[]{(byte) 110, (byte) 117, (byte) 108, (byte) 108};
        f519w = new byte[]{(byte) 116, (byte) 114, (byte) 117, (byte) 101};
        f520x = new byte[]{(byte) 102, (byte) 97, (byte) 108, (byte) 115, (byte) 101};
    }

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream) {
        super(iOContext, i, objectCodec);
        this.f523p = 0;
        this.f521n = outputStream;
        this.f528u = true;
        this.f522o = iOContext.m577f();
        this.f524q = this.f522o.length;
        this.f525r = this.f524q >> 3;
        this.f526s = iOContext.m579h();
        this.f527t = this.f526s.length;
        if (m474a(JsonGenerator.ESCAPE_NON_ASCII)) {
            m638a((int) TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
    }

    public final void m720a(String str) {
        boolean z = true;
        int a = this.e.m658a(str);
        if (a == 4) {
            m477f("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (a != 1) {
                z = false;
            }
            m722a(str, z);
            return;
        }
        if (a == 1) {
            if (this.f523p >= this.f524q) {
                m741k();
            }
            byte[] bArr = this.f522o;
            a = this.f523p;
            this.f523p = a + 1;
            bArr[a] = (byte) 44;
        }
        m739g(str);
    }

    public final void m731c() {
        m736e("start an array");
        this.e = this.e.m660h();
        if (this.a != null) {
            this.a.m936e(this);
            return;
        }
        if (this.f523p >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 91;
    }

    public final void m733d() {
        if (!this.e.m641a()) {
            m477f("Current context not an ARRAY but " + this.e.m644d());
        }
        if (this.a != null) {
            this.a.m933b(this, this.e.m645e());
        } else {
            if (this.f523p >= this.f524q) {
                m741k();
            }
            byte[] bArr = this.f522o;
            int i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) 93;
        }
        this.e = this.e.m662j();
    }

    public final void m735e() {
        m736e("start an object");
        this.e = this.e.m661i();
        if (this.a != null) {
            this.a.m932b(this);
            return;
        }
        if (this.f523p >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 123;
    }

    public final void m737f() {
        if (!this.e.m643c()) {
            m477f("Current context not an object but " + this.e.m644d());
        }
        if (this.a != null) {
            this.a.m931a(this, this.e.m645e());
        } else {
            if (this.f523p >= this.f524q) {
                m741k();
            }
            byte[] bArr = this.f522o;
            int i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) 125;
        }
        this.e = this.e.m662j();
    }

    protected final void m739g(String str) {
        if (m474a(JsonGenerator.QUOTE_FIELD_NAMES)) {
            if (this.f523p >= this.f524q) {
                m741k();
            }
            byte[] bArr = this.f522o;
            int i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) 34;
            int length = str.length();
            if (length <= this.f527t) {
                str.getChars(0, length, this.f526s, 0);
                if (length <= this.f525r) {
                    if (this.f523p + length > this.f524q) {
                        m741k();
                    }
                    m708e(this.f526s, 0, length);
                } else {
                    m707d(this.f526s, 0, length);
                }
            } else {
                m713i(str);
            }
            if (this.f523p >= this.f524q) {
                m741k();
            }
            bArr = this.f522o;
            i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) 34;
            return;
        }
        m713i(str);
    }

    protected final void m722a(String str, boolean z) {
        if (z) {
            this.a.m934c(this);
        } else {
            this.a.m939h(this);
        }
        if (m474a(JsonGenerator.QUOTE_FIELD_NAMES)) {
            if (this.f523p >= this.f524q) {
                m741k();
            }
            byte[] bArr = this.f522o;
            int i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) 34;
            int length = str.length();
            if (length <= this.f527t) {
                str.getChars(0, length, this.f526s, 0);
                if (length <= this.f525r) {
                    if (this.f523p + length > this.f524q) {
                        m741k();
                    }
                    m708e(this.f526s, 0, length);
                } else {
                    m707d(this.f526s, 0, length);
                }
            } else {
                m713i(str);
            }
            if (this.f523p >= this.f524q) {
                m741k();
            }
            bArr = this.f522o;
            i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) 34;
            return;
        }
        m713i(str);
    }

    public void m730b(String str) {
        m736e("write text value");
        if (str == null) {
            m714l();
            return;
        }
        int length = str.length();
        if (length > this.f527t) {
            m711h(str);
            return;
        }
        str.getChars(0, length, this.f526s, 0);
        if (length > this.f525r) {
            m702b(this.f526s, 0, length);
            return;
        }
        if (this.f523p + length >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 34;
        m708e(this.f526s, 0, length);
        if (this.f523p >= this.f524q) {
            m741k();
        }
        byte[] bArr2 = this.f522o;
        int i2 = this.f523p;
        this.f523p = i2 + 1;
        bArr2[i2] = (byte) 34;
    }

    private void m711h(String str) {
        if (this.f523p >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 34;
        m713i(str);
        if (this.f523p >= this.f524q) {
            m741k();
        }
        bArr = this.f522o;
        i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 34;
    }

    private void m702b(char[] cArr, int i, int i2) {
        if (this.f523p >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i3 = this.f523p;
        this.f523p = i3 + 1;
        bArr[i3] = (byte) 34;
        m707d(this.f526s, 0, i2);
        if (this.f523p >= this.f524q) {
            m741k();
        }
        bArr = this.f522o;
        i3 = this.f523p;
        this.f523p = i3 + 1;
        bArr[i3] = (byte) 34;
    }

    public void m732c(String str) {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this.f526s;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            str.getChars(i, i + length2, cArr, 0);
            m726a(cArr, 0, length2);
            i += length2;
            length -= length2;
        }
    }

    public void m729b(SerializableString serializableString) {
        byte[] b = serializableString.m603b();
        if (b.length > 0) {
            m700a(b);
        }
    }

    public final void m726a(char[] cArr, int i, int i2) {
        int i3 = (i2 + i2) + i2;
        if (this.f523p + i3 > this.f524q) {
            if (this.f524q < i3) {
                m705c(cArr, i, i2);
                return;
            }
            m741k();
        }
        int i4 = i2 + i;
        i3 = i;
        while (i3 < i4) {
            while (true) {
                char c = cArr[i3];
                if (c > '\u007f') {
                    break;
                }
                byte[] bArr = this.f522o;
                int i5 = this.f523p;
                this.f523p = i5 + 1;
                bArr[i5] = (byte) c;
                i3++;
                if (i3 >= i4) {
                    return;
                }
            }
            i = i3 + 1;
            i3 = cArr[i3];
            if (i3 < '\u0800') {
                byte[] bArr2 = this.f522o;
                int i6 = this.f523p;
                this.f523p = i6 + 1;
                bArr2[i6] = (byte) ((i3 >> 6) | 192);
                bArr2 = this.f522o;
                i6 = this.f523p;
                this.f523p = i6 + 1;
                bArr2[i6] = (byte) ((i3 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            } else {
                m696a(i3, cArr, i, i4);
            }
            i3 = i;
        }
    }

    public void m715a(char c) {
        if (this.f523p + 3 >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i;
        if (c <= '\u007f') {
            i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) c;
        } else if (c < '\u0800') {
            i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) ((c >> 6) | 192);
            i = this.f523p;
            this.f523p = i + 1;
            bArr[i] = (byte) ((c & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            m696a((int) c, null, 0, 0);
        }
    }

    private final void m705c(char[] cArr, int i, int i2) {
        int i3 = this.f524q;
        byte[] bArr = this.f522o;
        int i4 = i;
        while (i4 < i2) {
            while (true) {
                char c = cArr[i4];
                if (c >= '\u0080') {
                    break;
                }
                if (this.f523p >= i3) {
                    m741k();
                }
                int i5 = this.f523p;
                this.f523p = i5 + 1;
                bArr[i5] = (byte) c;
                i4++;
                if (i4 >= i2) {
                    return;
                }
            }
            if (this.f523p + 3 >= this.f524q) {
                m741k();
            }
            i = i4 + 1;
            i4 = cArr[i4];
            if (i4 < '\u0800') {
                int i6 = this.f523p;
                this.f523p = i6 + 1;
                bArr[i6] = (byte) ((i4 >> 6) | 192);
                i6 = this.f523p;
                this.f523p = i6 + 1;
                bArr[i6] = (byte) ((i4 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            } else {
                m696a(i4, cArr, i, i2);
            }
            i4 = i;
        }
    }

    public void m728b(int i) {
        m736e("write number");
        if (this.f523p + 11 >= this.f524q) {
            m741k();
        }
        if (this.d) {
            m704c(i);
        } else {
            this.f523p = NumberOutput.m591a(i, this.f522o, this.f523p);
        }
    }

    private void m704c(int i) {
        if (this.f523p + 13 >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i2 = this.f523p;
        this.f523p = i2 + 1;
        bArr[i2] = (byte) 34;
        this.f523p = NumberOutput.m591a(i, this.f522o, this.f523p);
        bArr = this.f522o;
        i2 = this.f523p;
        this.f523p = i2 + 1;
        bArr[i2] = (byte) 34;
    }

    public void m719a(long j) {
        m736e("write number");
        if (this.d) {
            m701b(j);
            return;
        }
        if (this.f523p + 21 >= this.f524q) {
            m741k();
        }
        this.f523p = NumberOutput.m594a(j, this.f522o, this.f523p);
    }

    private void m701b(long j) {
        if (this.f523p + 23 >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 34;
        this.f523p = NumberOutput.m594a(j, this.f522o, this.f523p);
        bArr = this.f522o;
        i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 34;
    }

    public void m724a(BigInteger bigInteger) {
        m736e("write number");
        if (bigInteger == null) {
            m714l();
        } else if (this.d) {
            m699a((Object) bigInteger);
        } else {
            m732c(bigInteger.toString());
        }
    }

    public void m716a(double d) {
        if (this.d || ((Double.isNaN(d) || Double.isInfinite(d)) && m474a(JsonGenerator.QUOTE_NON_NUMERIC_NUMBERS))) {
            m730b(String.valueOf(d));
            return;
        }
        m736e("write number");
        m732c(String.valueOf(d));
    }

    public void m717a(float f) {
        if (this.d || ((Float.isNaN(f) || Float.isInfinite(f)) && m474a(JsonGenerator.QUOTE_NON_NUMERIC_NUMBERS))) {
            m730b(String.valueOf(f));
            return;
        }
        m736e("write number");
        m732c(String.valueOf(f));
    }

    public void m723a(BigDecimal bigDecimal) {
        m736e("write number");
        if (bigDecimal == null) {
            m714l();
        } else if (this.d) {
            m699a((Object) bigDecimal);
        } else {
            m732c(bigDecimal.toString());
        }
    }

    public void m734d(String str) {
        m736e("write number");
        if (this.d) {
            m699a((Object) str);
        } else {
            m732c(str);
        }
    }

    private void m699a(Object obj) {
        if (this.f523p >= this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 34;
        m732c(obj.toString());
        if (this.f523p >= this.f524q) {
            m741k();
        }
        bArr = this.f522o;
        i = this.f523p;
        this.f523p = i + 1;
        bArr[i] = (byte) 34;
    }

    public void m725a(boolean z) {
        m736e("write boolean value");
        if (this.f523p + 5 >= this.f524q) {
            m741k();
        }
        Object obj = z ? f519w : f520x;
        int length = obj.length;
        System.arraycopy(obj, 0, this.f522o, this.f523p, length);
        this.f523p += length;
    }

    public void m738g() {
        m736e("write null value");
        m714l();
    }

    protected final void m736e(String str) {
        int k = this.e.m663k();
        if (k == 5) {
            m477f("Can not " + str + ", expecting field name");
        }
        if (this.a == null) {
            byte b;
            switch (k) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    b = (byte) 44;
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    b = (byte) 58;
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    if (this.l != null) {
                        byte[] b2 = this.l.m603b();
                        if (b2.length > 0) {
                            m700a(b2);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.f523p >= this.f524q) {
                m741k();
            }
            this.f522o[this.f523p] = b;
            this.f523p++;
            return;
        }
        m721a(str, k);
    }

    protected final void m721a(String str, int i) {
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

    public final void flush() {
        m741k();
        if (this.f521n != null && m474a(JsonGenerator.FLUSH_PASSED_TO_STREAM)) {
            this.f521n.flush();
        }
    }

    public void close() {
        super.close();
        if (this.f522o != null && m474a(JsonGenerator.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext h = m478h();
                if (!h.m641a()) {
                    if (!h.m643c()) {
                        break;
                    }
                    m737f();
                } else {
                    m733d();
                }
            }
        }
        m741k();
        if (this.f521n != null) {
            if (this.h.m574c() || m474a(JsonGenerator.AUTO_CLOSE_TARGET)) {
                this.f521n.close();
            } else if (m474a(JsonGenerator.FLUSH_PASSED_TO_STREAM)) {
                this.f521n.flush();
            }
        }
        m740i();
    }

    protected void m740i() {
        byte[] bArr = this.f522o;
        if (bArr != null && this.f528u) {
            this.f522o = null;
            this.h.m571b(bArr);
        }
        char[] cArr = this.f526s;
        if (cArr != null) {
            this.f526s = null;
            this.h.m572b(cArr);
        }
    }

    private final void m700a(byte[] bArr) {
        int length = bArr.length;
        if (this.f523p + length > this.f524q) {
            m741k();
            if (length > AdRequest.MAX_CONTENT_URL_LENGTH) {
                this.f521n.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.f522o, this.f523p, length);
        this.f523p = length + this.f523p;
    }

    private final void m713i(String str) {
        int length = str.length();
        char[] cArr = this.f526s;
        int i = length;
        length = 0;
        while (i > 0) {
            int min = Math.min(this.f525r, i);
            str.getChars(length, length + min, cArr, 0);
            if (this.f523p + min > this.f524q) {
                m741k();
            }
            m708e(cArr, 0, min);
            length += min;
            i -= min;
        }
    }

    private final void m707d(char[] cArr, int i, int i2) {
        do {
            int min = Math.min(this.f525r, i2);
            if (this.f523p + min > this.f524q) {
                m741k();
            }
            m708e(cArr, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m708e(char[] r7, int r8, int r9) {
        /*
        r6 = this;
        r2 = r9 + r8;
        r0 = r6.f523p;
        r3 = r6.f522o;
        r4 = r6.i;
    L_0x0008:
        if (r8 >= r2) goto L_0x0014;
    L_0x000a:
        r5 = r7[r8];
        r1 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r5 > r1) goto L_0x0014;
    L_0x0010:
        r1 = r4[r5];
        if (r1 == 0) goto L_0x0020;
    L_0x0014:
        r6.f523p = r0;
        if (r8 >= r2) goto L_0x001f;
    L_0x0018:
        r0 = r6.k;
        if (r0 == 0) goto L_0x0029;
    L_0x001c:
        r6.m712h(r7, r8, r2);
    L_0x001f:
        return;
    L_0x0020:
        r1 = r0 + 1;
        r5 = (byte) r5;
        r3[r0] = r5;
        r8 = r8 + 1;
        r0 = r1;
        goto L_0x0008;
    L_0x0029:
        r0 = r6.j;
        if (r0 != 0) goto L_0x0031;
    L_0x002d:
        r6.m709f(r7, r8, r2);
        goto L_0x001f;
    L_0x0031:
        r6.m710g(r7, r8, r2);
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.f.e(char[], int, int):void");
    }

    private final void m709f(char[] cArr, int i, int i2) {
        if (this.f523p + ((i2 - i) * 6) > this.f524q) {
            m741k();
        }
        int i3 = this.f523p;
        byte[] bArr = this.f522o;
        int[] iArr = this.i;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            int i5;
            if (c > '\u007f') {
                if (c <= '\u07ff') {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((c & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                } else {
                    i3 = m703c(c, i3);
                }
                i = i4;
            } else if (iArr[c] == 0) {
                i5 = i3 + 1;
                bArr[i3] = (byte) c;
                i3 = i5;
                i = i4;
            } else {
                i5 = iArr[c];
                if (i5 > 0) {
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) 92;
                    i3 = i6 + 1;
                    bArr[i6] = (byte) i5;
                    i = i4;
                } else {
                    i3 = m706d(c, i3);
                    i = i4;
                }
            }
        }
        this.f523p = i3;
    }

    private final void m710g(char[] cArr, int i, int i2) {
        if (this.f523p + ((i2 - i) * 6) > this.f524q) {
            m741k();
        }
        int i3 = this.f523p;
        byte[] bArr = this.f522o;
        int[] iArr = this.i;
        char c = this.j;
        while (i < i2) {
            int i4 = i + 1;
            char c2 = cArr[i];
            int i5;
            if (c2 <= '\u007f') {
                if (iArr[c2] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) c2;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[c2];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        i3 = m706d(c2, i3);
                        i = i4;
                    }
                }
            } else if (c2 > c) {
                i3 = m706d(c2, i3);
                i = i4;
            } else {
                if (c2 <= '\u07ff') {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((c2 >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((c2 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                } else {
                    i3 = m703c(c2, i3);
                }
                i = i4;
            }
        }
        this.f523p = i3;
    }

    private void m712h(char[] cArr, int i, int i2) {
        if (this.f523p + ((i2 - i) * 6) > this.f524q) {
            m741k();
        }
        int i3 = this.f523p;
        byte[] bArr = this.f522o;
        int[] iArr = this.i;
        char c = this.j <= 0 ? '\uffff' : this.j;
        CharacterEscapes characterEscapes = this.k;
        while (i < i2) {
            int i4 = i + 1;
            char c2 = cArr[i];
            int i5;
            SerializableString a;
            if (c2 <= '\u007f') {
                if (iArr[c2] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) c2;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[c2];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else if (i5 == -2) {
                        a = characterEscapes.m564a(c2);
                        if (a == null) {
                            m477f("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c2) + ", although was supposed to have one");
                        }
                        i3 = m698a(bArr, i3, a, i2 - i4);
                        i = i4;
                    } else {
                        i3 = m706d(c2, i3);
                        i = i4;
                    }
                }
            } else if (c2 > c) {
                i3 = m706d(c2, i3);
                i = i4;
            } else {
                a = characterEscapes.m564a(c2);
                if (a != null) {
                    i3 = m698a(bArr, i3, a, i2 - i4);
                    i = i4;
                } else {
                    if (c2 <= '\u07ff') {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) ((c2 >> 6) | 192);
                        i3 = i5 + 1;
                        bArr[i5] = (byte) ((c2 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    } else {
                        i3 = m703c(c2, i3);
                    }
                    i = i4;
                }
            }
        }
        this.f523p = i3;
    }

    private int m698a(byte[] bArr, int i, SerializableString serializableString, int i2) {
        Object b = serializableString.m603b();
        int length = b.length;
        if (length > 6) {
            return m697a(bArr, i, this.f524q, b, i2);
        }
        System.arraycopy(b, 0, bArr, i, length);
        return length + i;
    }

    private int m697a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int length = bArr2.length;
        if (i + length > i2) {
            this.f523p = i;
            m741k();
            i4 = this.f523p;
            if (length > bArr.length) {
                this.f521n.write(bArr2, 0, length);
                return i4;
            }
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        } else {
            i4 = i;
        }
        if ((i3 * 6) + i4 <= i2) {
            return i4;
        }
        m741k();
        return this.f523p;
    }

    private int m696a(int i, char[] cArr, int i2, int i3) {
        if (i < 55296 || i > 57343) {
            byte[] bArr = this.f522o;
            int i4 = this.f523p;
            this.f523p = i4 + 1;
            bArr[i4] = (byte) ((i >> 12) | 224);
            i4 = this.f523p;
            this.f523p = i4 + 1;
            bArr[i4] = (byte) (((i >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            i4 = this.f523p;
            this.f523p = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            return i2;
        }
        if (i2 >= i3) {
            m477f("Split surrogate on writeRaw() input (last character)");
        }
        m718a(i, cArr[i2]);
        return i2 + 1;
    }

    protected final void m718a(int i, int i2) {
        int b = m727b(i, i2);
        if (this.f523p + 4 > this.f524q) {
            m741k();
        }
        byte[] bArr = this.f522o;
        int i3 = this.f523p;
        this.f523p = i3 + 1;
        bArr[i3] = (byte) ((b >> 18) | 240);
        i3 = this.f523p;
        this.f523p = i3 + 1;
        bArr[i3] = (byte) (((b >> 12) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        i3 = this.f523p;
        this.f523p = i3 + 1;
        bArr[i3] = (byte) (((b >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        i3 = this.f523p;
        this.f523p = i3 + 1;
        bArr[i3] = (byte) ((b & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
    }

    private int m703c(int i, int i2) {
        byte[] bArr = this.f522o;
        if (i < 55296 || i > 57343) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((i >> 12) | 224);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((i >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            i3 = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            return i3;
        }
        i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        i3 = i4 + 1;
        bArr[i4] = f517m[(i >> 12) & 15];
        i4 = i3 + 1;
        bArr[i3] = f517m[(i >> 8) & 15];
        int i5 = i4 + 1;
        bArr[i4] = f517m[(i >> 4) & 15];
        i3 = i5 + 1;
        bArr[i5] = f517m[i & 15];
        return i3;
    }

    protected final int m727b(int i, int i2) {
        if (i2 < 56320 || i2 > 57343) {
            m477f("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        return (AccessibilityNodeInfoCompat.ACTION_CUT + ((i - 55296) << 10)) + (i2 - 56320);
    }

    private void m714l() {
        if (this.f523p + 4 >= this.f524q) {
            m741k();
        }
        System.arraycopy(f518v, 0, this.f522o, this.f523p, 4);
        this.f523p += 4;
    }

    private int m706d(int i, int i2) {
        byte[] bArr = this.f522o;
        int i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        int i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        int i5;
        if (i > MotionEventCompat.ACTION_MASK) {
            i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
            int i6 = i4 + 1;
            bArr[i4] = f517m[i5 >> 4];
            i3 = i6 + 1;
            bArr[i6] = f517m[i5 & 15];
            i &= MotionEventCompat.ACTION_MASK;
        } else {
            i5 = i4 + 1;
            bArr[i4] = (byte) 48;
            i3 = i5 + 1;
            bArr[i5] = (byte) 48;
        }
        i4 = i3 + 1;
        bArr[i3] = f517m[i >> 4];
        i3 = i4 + 1;
        bArr[i4] = f517m[i & 15];
        return i3;
    }

    protected final void m741k() {
        int i = this.f523p;
        if (i > 0) {
            this.f523p = 0;
            this.f521n.write(this.f522o, 0, i);
        }
    }
}
