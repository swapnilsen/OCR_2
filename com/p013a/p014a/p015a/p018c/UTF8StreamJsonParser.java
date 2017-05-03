package com.p013a.p014a.p015a.p018c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0268R;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.google.ads.AdSize;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonParser.JsonParser;
import com.p013a.p014a.p015a.JsonToken;
import com.p013a.p014a.p015a.ObjectCodec;
import com.p013a.p014a.p015a.p016a.ParserBase;
import com.p013a.p014a.p015a.p017b.CharTypes;
import com.p013a.p014a.p015a.p017b.IOContext;
import com.p013a.p014a.p015a.p019d.BytesToNameCanonicalizer;
import com.p013a.p014a.p015a.p019d.Name;
import java.io.IOException;
import java.io.InputStream;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.c.g */
public final class UTF8StreamJsonParser extends ParserBase {
    private static final int[] f530S;
    private static final int[] f531T;
    protected ObjectCodec f532L;
    protected final BytesToNameCanonicalizer f533M;
    protected int[] f534N;
    protected boolean f535O;
    protected InputStream f536P;
    protected byte[] f537Q;
    protected boolean f538R;
    private int f539U;

    /* renamed from: com.a.a.a.c.g.1 */
    static /* synthetic */ class UTF8StreamJsonParser {
        static final /* synthetic */ int[] f529a;

        static {
            f529a = new int[JsonToken.values().length];
            try {
                f529a[JsonToken.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f529a[JsonToken.VALUE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f529a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f529a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f529a[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f529a[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    static {
        f530S = CharTypes.m557b();
        f531T = CharTypes.m556a();
    }

    public UTF8StreamJsonParser(IOContext iOContext, int i, InputStream inputStream, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, byte[] bArr, int i2, int i3, boolean z) {
        super(iOContext, i);
        this.f534N = new int[16];
        this.f535O = false;
        this.f536P = inputStream;
        this.f532L = objectCodec;
        this.f533M = bytesToNameCanonicalizer;
        this.f537Q = bArr;
        this.d = i2;
        this.e = i3;
        this.f538R = z;
    }

    protected boolean m793p() {
        this.f += (long) this.e;
        this.h -= this.e;
        if (this.f536P == null) {
            return false;
        }
        int read = this.f536P.read(this.f537Q, 0, this.f537Q.length);
        if (read > 0) {
            this.d = 0;
            this.e = read;
            return true;
        }
        m795r();
        if (read != 0) {
            return false;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.f537Q.length + " bytes");
    }

    protected void m795r() {
        if (this.f536P != null) {
            if (this.b.m574c() || m483a(JsonParser.AUTO_CLOSE_SOURCE)) {
                this.f536P.close();
            }
            this.f536P = null;
        }
    }

    protected void m796s() {
        super.m538s();
        if (this.f538R) {
            byte[] bArr = this.f537Q;
            if (bArr != null) {
                this.f537Q = null;
                this.b.m568a(bArr);
            }
        }
    }

    public String m786f() {
        if (this.K != JsonToken.VALUE_STRING) {
            return m779a(this.K);
        }
        if (this.f535O) {
            this.f535O = false;
            m794q();
        }
        return this.n.m967f();
    }

    protected String m779a(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (UTF8StreamJsonParser.f529a[jsonToken.ordinal()]) {
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return this.l.m653h();
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                return this.n.m967f();
            default:
                return jsonToken.m980a();
        }
    }

    public JsonToken m777a() {
        this.A = 0;
        if (this.K == JsonToken.FIELD_NAME) {
            return m742L();
        }
        if (this.f535O) {
            m771H();
        }
        int O = m745O();
        if (O < 0) {
            close();
            this.K = null;
            return null;
        }
        this.i = (this.f + ((long) this.d)) - 1;
        this.j = this.g;
        this.k = (this.d - this.h) - 1;
        this.r = null;
        JsonToken jsonToken;
        if (O == 93) {
            if (!this.l.m641a()) {
                m522a(O, '}');
            }
            this.l = this.l.m654i();
            jsonToken = JsonToken.END_ARRAY;
            this.K = jsonToken;
            return jsonToken;
        } else if (O == 125) {
            if (!this.l.m643c()) {
                m522a(O, ']');
            }
            this.l = this.l.m654i();
            jsonToken = JsonToken.END_OBJECT;
            this.K = jsonToken;
            return jsonToken;
        } else {
            if (this.l.m655j()) {
                if (O != 44) {
                    m507b(O, "was expecting comma to separate " + this.l.m644d() + " entries");
                }
                O = m744N();
            }
            if (!this.l.m643c()) {
                return m760m(O);
            }
            this.l.m651a(m784e(O).m893a());
            this.K = JsonToken.FIELD_NAME;
            O = m744N();
            if (O != 58) {
                m507b(O, "was expecting a colon to separate field name and value");
            }
            O = m744N();
            if (O == 34) {
                this.f535O = true;
                this.m = JsonToken.VALUE_STRING;
                return this.K;
            }
            switch (O) {
                case C0268R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                case C0268R.styleable.AppCompatTheme_homeAsUpIndicator /*49*/:
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                case C0268R.styleable.AppCompatTheme_buttonBarStyle /*51*/:
                case C0268R.styleable.AppCompatTheme_buttonBarButtonStyle /*52*/:
                case C0268R.styleable.AppCompatTheme_selectableItemBackground /*53*/:
                case C0268R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /*54*/:
                case C0268R.styleable.AppCompatTheme_borderlessButtonStyle /*55*/:
                case C0268R.styleable.AppCompatTheme_dividerVertical /*56*/:
                case C0268R.styleable.AppCompatTheme_dividerHorizontal /*57*/:
                    jsonToken = m783d(O);
                    break;
                case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
                    jsonToken = JsonToken.START_ARRAY;
                    break;
                case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                case 125:
                    m507b(O, "expected a value");
                    break;
                case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
                    m781a("false", 1);
                    jsonToken = JsonToken.VALUE_FALSE;
                    break;
                case C0268R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                    m781a("null", 1);
                    jsonToken = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    jsonToken = JsonToken.START_OBJECT;
                    break;
                default:
                    jsonToken = m788h(O);
                    break;
            }
            m781a("true", 1);
            jsonToken = JsonToken.VALUE_TRUE;
            this.m = jsonToken;
            return this.K;
        }
    }

    private JsonToken m760m(int i) {
        if (i == 34) {
            this.f535O = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.K = jsonToken;
            return jsonToken;
        }
        switch (i) {
            case C0268R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
            case C0268R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
            case C0268R.styleable.AppCompatTheme_homeAsUpIndicator /*49*/:
            case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
            case C0268R.styleable.AppCompatTheme_buttonBarStyle /*51*/:
            case C0268R.styleable.AppCompatTheme_buttonBarButtonStyle /*52*/:
            case C0268R.styleable.AppCompatTheme_selectableItemBackground /*53*/:
            case C0268R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /*54*/:
            case C0268R.styleable.AppCompatTheme_borderlessButtonStyle /*55*/:
            case C0268R.styleable.AppCompatTheme_dividerVertical /*56*/:
            case C0268R.styleable.AppCompatTheme_dividerHorizontal /*57*/:
                jsonToken = m783d(i);
                this.K = jsonToken;
                return jsonToken;
            case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
                this.l = this.l.m648a(this.j, this.k);
                jsonToken = JsonToken.START_ARRAY;
                this.K = jsonToken;
                return jsonToken;
            case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
            case 125:
                m507b(i, "expected a value");
                break;
            case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
                m781a("false", 1);
                jsonToken = JsonToken.VALUE_FALSE;
                this.K = jsonToken;
                return jsonToken;
            case C0268R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                m781a("null", 1);
                jsonToken = JsonToken.VALUE_NULL;
                this.K = jsonToken;
                return jsonToken;
            case 116:
                break;
            case 123:
                this.l = this.l.m652b(this.j, this.k);
                jsonToken = JsonToken.START_OBJECT;
                this.K = jsonToken;
                return jsonToken;
            default:
                jsonToken = m788h(i);
                this.K = jsonToken;
                return jsonToken;
        }
        m781a("true", 1);
        jsonToken = JsonToken.VALUE_TRUE;
        this.K = jsonToken;
        return jsonToken;
    }

    private JsonToken m742L() {
        this.p = false;
        JsonToken jsonToken = this.m;
        this.m = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.l = this.l.m648a(this.j, this.k);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.l = this.l.m652b(this.j, this.k);
        }
        this.K = jsonToken;
        return jsonToken;
    }

    public void close() {
        super.close();
        this.f533M.m867b();
    }

    protected JsonToken m783d(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        char[] k = this.n.m972k();
        boolean z = i == 45;
        if (z) {
            k[0] = '-';
            if (this.d >= this.e) {
                m534o();
            }
            byte[] bArr = this.f537Q;
            i2 = this.d;
            this.d = i2 + 1;
            i3 = bArr[i2] & MotionEventCompat.ACTION_MASK;
            if (i3 < 48 || i3 > 57) {
                return m778a(i3, true);
            }
            i4 = 1;
        } else {
            i4 = 0;
            i3 = i;
        }
        if (i3 == 48) {
            i3 = m743M();
        }
        i2 = i4 + 1;
        k[i4] = (char) i3;
        i3 = this.d + k.length;
        if (i3 > this.e) {
            i3 = this.e;
        }
        while (this.d < i3) {
            byte[] bArr2 = this.f537Q;
            int i6 = this.d;
            this.d = i6 + 1;
            i4 = bArr2[i6] & MotionEventCompat.ACTION_MASK;
            if (i4 >= 48 && i4 <= 57) {
                i5++;
                i6 = i2 + 1;
                k[i2] = (char) i4;
                i2 = i6;
            } else if (i4 == 46 || i4 == C0268R.styleable.AppCompatTheme_autoCompleteTextViewStyle || i4 == 69) {
                return m754a(k, i2, i4, z, i5);
            } else {
                this.d--;
                this.n.m958a(i2);
                return m519a(z, i5);
            }
        }
        return m755a(k, i2, z, i5);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.p013a.p014a.p015a.JsonToken m755a(char[] r7, int r8, boolean r9, int r10) {
        /*
        r6 = this;
        r5 = r10;
        r2 = r8;
        r1 = r7;
    L_0x0003:
        r0 = r6.d;
        r3 = r6.e;
        if (r0 < r3) goto L_0x0019;
    L_0x0009:
        r0 = r6.m793p();
        if (r0 != 0) goto L_0x0019;
    L_0x000f:
        r0 = r6.n;
        r0.m958a(r2);
        r0 = r6.m519a(r9, r5);
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = r6.f537Q;
        r3 = r6.d;
        r4 = r3 + 1;
        r6.d = r4;
        r0 = r0[r3];
        r3 = r0 & 255;
        r0 = 57;
        if (r3 > r0) goto L_0x002d;
    L_0x0029:
        r0 = 48;
        if (r3 >= r0) goto L_0x0040;
    L_0x002d:
        r0 = 46;
        if (r3 == r0) goto L_0x0039;
    L_0x0031:
        r0 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 == r0) goto L_0x0039;
    L_0x0035:
        r0 = 69;
        if (r3 != r0) goto L_0x0053;
    L_0x0039:
        r0 = r6;
        r4 = r9;
        r0 = r0.m754a(r1, r2, r3, r4, r5);
        goto L_0x0018;
    L_0x0040:
        r0 = r1.length;
        if (r2 < r0) goto L_0x0063;
    L_0x0043:
        r0 = r6.n;
        r1 = r0.m974m();
        r2 = 0;
        r0 = r2;
    L_0x004b:
        r2 = r0 + 1;
        r3 = (char) r3;
        r1[r0] = r3;
        r5 = r5 + 1;
        goto L_0x0003;
    L_0x0053:
        r0 = r6.d;
        r0 = r0 + -1;
        r6.d = r0;
        r0 = r6.n;
        r0.m958a(r2);
        r0 = r6.m519a(r9, r5);
        goto L_0x0018;
    L_0x0063:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.g.a(char[], int, boolean, int):com.a.a.a.j");
    }

    private int m743M() {
        if (this.d >= this.e && !m793p()) {
            return 48;
        }
        int i = this.f537Q[this.d] & MotionEventCompat.ACTION_MASK;
        if (i < 48 || i > 57) {
            return 48;
        }
        if (!m483a(JsonParser.ALLOW_NUMERIC_LEADING_ZEROS)) {
            m525b("Leading zeroes not allowed");
        }
        this.d++;
        if (i != 48) {
            return i;
        }
        do {
            if (this.d >= this.e && !m793p()) {
                return i;
            }
            i = this.f537Q[this.d] & MotionEventCompat.ACTION_MASK;
            if (i < 48 || i > 57) {
                return 48;
            }
            this.d++;
        } while (i == 48);
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.p013a.p014a.p015a.JsonToken m754a(char[] r10, int r11, int r12, boolean r13, int r14) {
        /*
        r9 = this;
        r0 = 0;
        r4 = 0;
        r1 = 46;
        if (r12 != r1) goto L_0x0109;
    L_0x0006:
        r1 = r11 + 1;
        r2 = (char) r12;
        r10[r11] = r2;
    L_0x000b:
        r2 = r9.d;
        r3 = r9.e;
        if (r2 < r3) goto L_0x00c0;
    L_0x0011:
        r2 = r9.m793p();
        if (r2 != 0) goto L_0x00c0;
    L_0x0017:
        r4 = 1;
    L_0x0018:
        if (r0 != 0) goto L_0x001f;
    L_0x001a:
        r2 = "Decimal point not followed by a digit";
        r9.m523a(r12, r2);
    L_0x001f:
        r6 = r0;
        r0 = r1;
        r1 = r10;
    L_0x0022:
        r3 = 0;
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r12 == r2) goto L_0x002b;
    L_0x0027:
        r2 = 69;
        if (r12 != r2) goto L_0x0103;
    L_0x002b:
        r2 = r1.length;
        if (r0 < r2) goto L_0x0035;
    L_0x002e:
        r0 = r9.n;
        r1 = r0.m974m();
        r0 = 0;
    L_0x0035:
        r2 = r0 + 1;
        r5 = (char) r12;
        r1[r0] = r5;
        r0 = r9.d;
        r5 = r9.e;
        if (r0 < r5) goto L_0x0043;
    L_0x0040:
        r9.m534o();
    L_0x0043:
        r0 = r9.f537Q;
        r5 = r9.d;
        r7 = r5 + 1;
        r9.d = r7;
        r0 = r0[r5];
        r5 = r0 & 255;
        r0 = 45;
        if (r5 == r0) goto L_0x0057;
    L_0x0053:
        r0 = 43;
        if (r5 != r0) goto L_0x00ff;
    L_0x0057:
        r0 = r1.length;
        if (r2 < r0) goto L_0x00fc;
    L_0x005a:
        r0 = r9.n;
        r1 = r0.m974m();
        r0 = 0;
    L_0x0061:
        r2 = r0 + 1;
        r5 = (char) r5;
        r1[r0] = r5;
        r0 = r9.d;
        r5 = r9.e;
        if (r0 < r5) goto L_0x006f;
    L_0x006c:
        r9.m534o();
    L_0x006f:
        r0 = r9.f537Q;
        r5 = r9.d;
        r7 = r5 + 1;
        r9.d = r7;
        r0 = r0[r5];
        r0 = r0 & 255;
        r5 = r0;
        r0 = r2;
        r2 = r3;
    L_0x007e:
        r3 = 57;
        if (r5 > r3) goto L_0x00f7;
    L_0x0082:
        r3 = 48;
        if (r5 < r3) goto L_0x00f7;
    L_0x0086:
        r2 = r2 + 1;
        r3 = r1.length;
        if (r0 < r3) goto L_0x0092;
    L_0x008b:
        r0 = r9.n;
        r1 = r0.m974m();
        r0 = 0;
    L_0x0092:
        r3 = r0 + 1;
        r7 = (char) r5;
        r1[r0] = r7;
        r0 = r9.d;
        r7 = r9.e;
        if (r0 < r7) goto L_0x00e8;
    L_0x009d:
        r0 = r9.m793p();
        if (r0 != 0) goto L_0x00e8;
    L_0x00a3:
        r4 = 1;
        r0 = r2;
        r1 = r4;
        r2 = r3;
    L_0x00a7:
        if (r0 != 0) goto L_0x00ae;
    L_0x00a9:
        r3 = "Exponent indicator not followed by a digit";
        r9.m523a(r5, r3);
    L_0x00ae:
        if (r1 != 0) goto L_0x00b6;
    L_0x00b0:
        r1 = r9.d;
        r1 = r1 + -1;
        r9.d = r1;
    L_0x00b6:
        r1 = r9.n;
        r1.m958a(r2);
        r0 = r9.m524b(r13, r14, r6, r0);
        return r0;
    L_0x00c0:
        r2 = r9.f537Q;
        r3 = r9.d;
        r5 = r3 + 1;
        r9.d = r5;
        r2 = r2[r3];
        r12 = r2 & 255;
        r2 = 48;
        if (r12 < r2) goto L_0x0018;
    L_0x00d0:
        r2 = 57;
        if (r12 > r2) goto L_0x0018;
    L_0x00d4:
        r0 = r0 + 1;
        r2 = r10.length;
        if (r1 < r2) goto L_0x0107;
    L_0x00d9:
        r1 = r9.n;
        r10 = r1.m974m();
        r1 = 0;
        r2 = r1;
    L_0x00e1:
        r1 = r2 + 1;
        r3 = (char) r12;
        r10[r2] = r3;
        goto L_0x000b;
    L_0x00e8:
        r0 = r9.f537Q;
        r5 = r9.d;
        r7 = r5 + 1;
        r9.d = r7;
        r0 = r0[r5];
        r0 = r0 & 255;
        r5 = r0;
        r0 = r3;
        goto L_0x007e;
    L_0x00f7:
        r1 = r4;
        r8 = r2;
        r2 = r0;
        r0 = r8;
        goto L_0x00a7;
    L_0x00fc:
        r0 = r2;
        goto L_0x0061;
    L_0x00ff:
        r0 = r2;
        r2 = r3;
        goto L_0x007e;
    L_0x0103:
        r1 = r4;
        r2 = r0;
        r0 = r3;
        goto L_0x00ae;
    L_0x0107:
        r2 = r1;
        goto L_0x00e1;
    L_0x0109:
        r6 = r0;
        r1 = r10;
        r0 = r11;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.g.a(char[], int, int, boolean, int):com.a.a.a.j");
    }

    protected Name m784e(int i) {
        if (i != 34) {
            return m787g(i);
        }
        if (this.d + 9 > this.e) {
            return m769F();
        }
        byte[] bArr = this.f537Q;
        int[] iArr = f531T;
        int i2 = this.d;
        this.d = i2 + 1;
        i2 = bArr[i2] & MotionEventCompat.ACTION_MASK;
        if (iArr[i2] == 0) {
            int i3 = this.d;
            this.d = i3 + 1;
            i3 = bArr[i3] & MotionEventCompat.ACTION_MASK;
            if (iArr[i3] == 0) {
                i2 = (i2 << 8) | i3;
                i3 = this.d;
                this.d = i3 + 1;
                i3 = bArr[i3] & MotionEventCompat.ACTION_MASK;
                if (iArr[i3] == 0) {
                    i2 = (i2 << 8) | i3;
                    i3 = this.d;
                    this.d = i3 + 1;
                    i3 = bArr[i3] & MotionEventCompat.ACTION_MASK;
                    if (iArr[i3] == 0) {
                        i2 = (i2 << 8) | i3;
                        i3 = this.d;
                        this.d = i3 + 1;
                        int i4 = bArr[i3] & MotionEventCompat.ACTION_MASK;
                        if (iArr[i4] == 0) {
                            this.f539U = i2;
                            return m775a(i4, iArr);
                        } else if (i4 == 34) {
                            return m758b(i2, 4);
                        } else {
                            return m750a(i2, i4, 4);
                        }
                    } else if (i3 == 34) {
                        return m758b(i2, 3);
                    } else {
                        return m750a(i2, i3, 3);
                    }
                } else if (i3 == 34) {
                    return m758b(i2, 2);
                } else {
                    return m750a(i2, i3, 2);
                }
            } else if (i3 == 34) {
                return m758b(i2, 1);
            } else {
                return m750a(i2, i3, 1);
            }
        } else if (i2 == 34) {
            return BytesToNameCanonicalizer.m851d();
        } else {
            return m750a(0, i2, 0);
        }
    }

    protected Name m775a(int i, int[] iArr) {
        byte[] bArr = this.f537Q;
        int i2 = this.d;
        this.d = i2 + 1;
        int i3 = bArr[i2] & MotionEventCompat.ACTION_MASK;
        if (iArr[i3] == 0) {
            i3 |= i << 8;
            byte[] bArr2 = this.f537Q;
            int i4 = this.d;
            this.d = i4 + 1;
            i2 = bArr2[i4] & MotionEventCompat.ACTION_MASK;
            if (iArr[i2] == 0) {
                i3 = (i3 << 8) | i2;
                bArr2 = this.f537Q;
                i4 = this.d;
                this.d = i4 + 1;
                i2 = bArr2[i4] & MotionEventCompat.ACTION_MASK;
                if (iArr[i2] == 0) {
                    i3 = (i3 << 8) | i2;
                    bArr2 = this.f537Q;
                    i4 = this.d;
                    this.d = i4 + 1;
                    i2 = bArr2[i4] & MotionEventCompat.ACTION_MASK;
                    if (iArr[i2] == 0) {
                        this.f534N[0] = this.f539U;
                        this.f534N[1] = i3;
                        return m785f(i2);
                    } else if (i2 == 34) {
                        return m759b(this.f539U, i3, 4);
                    } else {
                        return m751a(this.f539U, i3, i2, 4);
                    }
                } else if (i2 == 34) {
                    return m759b(this.f539U, i3, 3);
                } else {
                    return m751a(this.f539U, i3, i2, 3);
                }
            } else if (i2 == 34) {
                return m759b(this.f539U, i3, 2);
            } else {
                return m751a(this.f539U, i3, i2, 2);
            }
        } else if (i3 == 34) {
            return m759b(this.f539U, i, 1);
        } else {
            return m751a(this.f539U, i, i3, 1);
        }
    }

    protected Name m785f(int i) {
        int[] iArr = f531T;
        int i2 = 2;
        int i3 = i;
        while (this.e - this.d >= 4) {
            byte[] bArr = this.f537Q;
            int i4 = this.d;
            this.d = i4 + 1;
            int i5 = bArr[i4] & MotionEventCompat.ACTION_MASK;
            if (iArr[i5] == 0) {
                i4 = (i3 << 8) | i5;
                bArr = this.f537Q;
                i3 = this.d;
                this.d = i3 + 1;
                i3 = bArr[i3] & MotionEventCompat.ACTION_MASK;
                if (iArr[i3] == 0) {
                    i4 = (i4 << 8) | i3;
                    bArr = this.f537Q;
                    i3 = this.d;
                    this.d = i3 + 1;
                    i3 = bArr[i3] & MotionEventCompat.ACTION_MASK;
                    if (iArr[i3] == 0) {
                        i4 = (i4 << 8) | i3;
                        bArr = this.f537Q;
                        i3 = this.d;
                        this.d = i3 + 1;
                        i3 = bArr[i3] & MotionEventCompat.ACTION_MASK;
                        if (iArr[i3] == 0) {
                            if (i2 >= this.f534N.length) {
                                this.f534N = UTF8StreamJsonParser.m757a(this.f534N, i2);
                            }
                            int i6 = i2 + 1;
                            this.f534N[i2] = i4;
                            i2 = i6;
                        } else if (i3 == 34) {
                            return m753a(this.f534N, i2, i4, 4);
                        } else {
                            return m776a(this.f534N, i2, i4, i3, 4);
                        }
                    } else if (i3 == 34) {
                        return m753a(this.f534N, i2, i4, 3);
                    } else {
                        return m776a(this.f534N, i2, i4, i3, 3);
                    }
                } else if (i3 == 34) {
                    return m753a(this.f534N, i2, i4, 2);
                } else {
                    return m776a(this.f534N, i2, i4, i3, 2);
                }
            } else if (i5 == 34) {
                return m753a(this.f534N, i2, i3, 1);
            } else {
                return m776a(this.f534N, i2, i3, i5, 1);
            }
        }
        return m776a(this.f534N, i2, 0, i3, 0);
    }

    protected Name m769F() {
        if (this.d >= this.e && !m793p()) {
            m510c(": was expecting closing '\"' for name");
        }
        byte[] bArr = this.f537Q;
        int i = this.d;
        this.d = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (i2 == 34) {
            return BytesToNameCanonicalizer.m851d();
        }
        return m776a(this.f534N, 0, 0, i2, 0);
    }

    private Name m750a(int i, int i2, int i3) {
        return m776a(this.f534N, 0, i, i2, i3);
    }

    private Name m751a(int i, int i2, int i3, int i4) {
        this.f534N[0] = i;
        return m776a(this.f534N, 1, i2, i3, i4);
    }

    protected Name m776a(int[] iArr, int i, int i2, int i3, int i4) {
        int[] iArr2 = f531T;
        while (true) {
            int[] iArr3;
            int i5;
            int i6;
            int i7;
            byte[] bArr;
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    m509c(i3, "name");
                } else {
                    i3 = m768B();
                }
                if (i3 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                    int i8;
                    int[] iArr4;
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = UTF8StreamJsonParser.m757a(iArr, iArr.length);
                            this.f534N = iArr;
                        }
                        i8 = i + 1;
                        iArr[i] = i2;
                        i4 = 0;
                        i2 = 0;
                        iArr3 = iArr;
                    } else {
                        i8 = i;
                        iArr3 = iArr;
                    }
                    if (i3 < ItemAnimator.FLAG_MOVED) {
                        i5 = ((i3 >> 6) | 192) | (i2 << 8);
                        iArr4 = iArr3;
                        i6 = i4 + 1;
                    } else {
                        int[] iArr5;
                        int i9;
                        i7 = ((i3 >> 12) | 224) | (i2 << 8);
                        i5 = i4 + 1;
                        if (i5 >= 4) {
                            if (i8 >= iArr3.length) {
                                iArr3 = UTF8StreamJsonParser.m757a(iArr3, iArr3.length);
                                this.f534N = iArr3;
                            }
                            i5 = i8 + 1;
                            iArr3[i8] = i7;
                            i7 = i5;
                            iArr5 = iArr3;
                            i6 = 0;
                            i5 = 0;
                        } else {
                            i9 = i5;
                            i5 = i7;
                            i7 = i8;
                            iArr5 = iArr3;
                            i6 = i9;
                        }
                        i5 = (i5 << 8) | (((i3 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                        i6++;
                        i9 = i7;
                        iArr4 = iArr5;
                        i8 = i9;
                    }
                    i2 = (i3 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
                    i4 = i6;
                    i = i8;
                    iArr3 = iArr4;
                    i7 = i5;
                    if (i4 >= 4) {
                        i4++;
                        i2 |= i7 << 8;
                        iArr = iArr3;
                    } else {
                        if (i >= iArr3.length) {
                            iArr3 = UTF8StreamJsonParser.m757a(iArr3, iArr3.length);
                            this.f534N = iArr3;
                        }
                        i5 = i + 1;
                        iArr3[i] = i7;
                        i4 = 1;
                        i = i5;
                        iArr = iArr3;
                    }
                    if (this.d >= this.e && !m793p()) {
                        m510c(" in field name");
                    }
                    bArr = this.f537Q;
                    i5 = this.d;
                    this.d = i5 + 1;
                    i3 = bArr[i5] & MotionEventCompat.ACTION_MASK;
                }
            }
            i7 = i2;
            iArr3 = iArr;
            i2 = i3;
            if (i4 >= 4) {
                if (i >= iArr3.length) {
                    iArr3 = UTF8StreamJsonParser.m757a(iArr3, iArr3.length);
                    this.f534N = iArr3;
                }
                i5 = i + 1;
                iArr3[i] = i7;
                i4 = 1;
                i = i5;
                iArr = iArr3;
            } else {
                i4++;
                i2 |= i7 << 8;
                iArr = iArr3;
            }
            m510c(" in field name");
            bArr = this.f537Q;
            i5 = this.d;
            this.d = i5 + 1;
            i3 = bArr[i5] & MotionEventCompat.ACTION_MASK;
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = UTF8StreamJsonParser.m757a(iArr, iArr.length);
                this.f534N = iArr;
            }
            i6 = i + 1;
            iArr[i] = i2;
            i = i6;
        }
        Name a = this.f533M.m863a(iArr, i);
        if (a == null) {
            return m752a(iArr, i, i4);
        }
        return a;
    }

    protected Name m787g(int i) {
        if (i == 39 && m483a(JsonParser.ALLOW_SINGLE_QUOTES)) {
            return m770G();
        }
        int[] iArr;
        int i2;
        if (!m483a(JsonParser.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m507b(i, "was expecting double-quote to start field name");
        }
        int[] d = CharTypes.m559d();
        if (d[i] != 0) {
            m507b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        int[] iArr2 = this.f534N;
        while (true) {
            if (i3 < 4) {
                int i7 = i3 + 1;
                i3 = i5 | (i4 << 8);
                i5 = i6;
                iArr = iArr2;
                i2 = i7;
            } else {
                if (i6 >= iArr2.length) {
                    iArr2 = UTF8StreamJsonParser.m757a(iArr2, iArr2.length);
                    this.f534N = iArr2;
                }
                int i8 = i6 + 1;
                iArr2[i6] = i4;
                iArr = iArr2;
                i2 = 1;
                i3 = i5;
                i5 = i8;
            }
            if (this.d >= this.e && !m793p()) {
                m510c(" in field name");
            }
            i = this.f537Q[this.d] & MotionEventCompat.ACTION_MASK;
            if (d[i] != 0) {
                break;
            }
            this.d++;
            i4 = i3;
            i3 = i2;
            iArr2 = iArr;
            i6 = i5;
            i5 = i;
        }
        if (i2 > 0) {
            if (i5 >= iArr.length) {
                iArr = UTF8StreamJsonParser.m757a(iArr, iArr.length);
                this.f534N = iArr;
            }
            i8 = i5 + 1;
            iArr[i5] = i3;
            i5 = i8;
        }
        Name a = this.f533M.m863a(iArr, i5);
        if (a == null) {
            return m752a(iArr, i5, i2);
        }
        return a;
    }

    protected Name m770G() {
        if (this.d >= this.e && !m793p()) {
            m510c(": was expecting closing ''' for name");
        }
        byte[] bArr = this.f537Q;
        int i = this.d;
        this.d = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (i2 == 39) {
            return BytesToNameCanonicalizer.m851d();
        }
        int i3;
        int i4;
        int[] iArr;
        int[] iArr2 = this.f534N;
        int[] iArr3 = f531T;
        int i5 = 0;
        int i6 = 0;
        i = 0;
        while (i2 != 39) {
            int[] iArr4;
            int i7;
            byte[] bArr2;
            if (!(i2 == 34 || iArr3[i2] == 0)) {
                if (i2 != 92) {
                    m509c(i2, "name");
                } else {
                    i2 = m768B();
                }
                if (i2 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                    int[] iArr5;
                    if (i5 >= 4) {
                        if (i >= iArr2.length) {
                            iArr2 = UTF8StreamJsonParser.m757a(iArr2, iArr2.length);
                            this.f534N = iArr2;
                        }
                        i5 = i + 1;
                        iArr2[i] = i6;
                        i = 0;
                        i6 = i5;
                        i5 = 0;
                    } else {
                        i3 = i5;
                        i5 = i6;
                        i6 = i;
                        i = i3;
                    }
                    if (i2 < ItemAnimator.FLAG_MOVED) {
                        i3 = i + 1;
                        i = (i5 << 8) | ((i2 >> 6) | 192);
                        iArr5 = iArr2;
                        i4 = i3;
                    } else {
                        i5 = (i5 << 8) | ((i2 >> 12) | 224);
                        i++;
                        if (i >= 4) {
                            if (i6 >= iArr2.length) {
                                iArr2 = UTF8StreamJsonParser.m757a(iArr2, iArr2.length);
                                this.f534N = iArr2;
                            }
                            i = i6 + 1;
                            iArr2[i6] = i5;
                            i5 = i;
                            iArr4 = iArr2;
                            i4 = 0;
                            i = 0;
                        } else {
                            i3 = i;
                            i = i5;
                            i5 = i6;
                            iArr4 = iArr2;
                            i4 = i3;
                        }
                        i = (i << 8) | (((i2 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                        i4++;
                        i3 = i5;
                        iArr5 = iArr4;
                        i6 = i3;
                    }
                    i7 = i;
                    i = i4;
                    iArr2 = iArr5;
                    i5 = (i2 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
                    if (i >= 4) {
                        i3 = i + 1;
                        i = i5 | (i7 << 8);
                        i5 = i6;
                        iArr4 = iArr2;
                        i4 = i3;
                    } else {
                        if (i6 >= iArr2.length) {
                            iArr2 = UTF8StreamJsonParser.m757a(iArr2, iArr2.length);
                            this.f534N = iArr2;
                        }
                        i2 = i6 + 1;
                        iArr2[i6] = i7;
                        iArr4 = iArr2;
                        i4 = 1;
                        i = i5;
                        i5 = i2;
                    }
                    if (this.d >= this.e && !m793p()) {
                        m510c(" in field name");
                    }
                    bArr2 = this.f537Q;
                    i7 = this.d;
                    this.d = i7 + 1;
                    i2 = bArr2[i7] & MotionEventCompat.ACTION_MASK;
                    i3 = i4;
                    iArr2 = iArr4;
                    i6 = i;
                    i = i5;
                    i5 = i3;
                }
            }
            i7 = i6;
            i6 = i;
            i = i5;
            i5 = i2;
            if (i >= 4) {
                if (i6 >= iArr2.length) {
                    iArr2 = UTF8StreamJsonParser.m757a(iArr2, iArr2.length);
                    this.f534N = iArr2;
                }
                i2 = i6 + 1;
                iArr2[i6] = i7;
                iArr4 = iArr2;
                i4 = 1;
                i = i5;
                i5 = i2;
            } else {
                i3 = i + 1;
                i = i5 | (i7 << 8);
                i5 = i6;
                iArr4 = iArr2;
                i4 = i3;
            }
            m510c(" in field name");
            bArr2 = this.f537Q;
            i7 = this.d;
            this.d = i7 + 1;
            i2 = bArr2[i7] & MotionEventCompat.ACTION_MASK;
            i3 = i4;
            iArr2 = iArr4;
            i6 = i;
            i = i5;
            i5 = i3;
        }
        if (i5 > 0) {
            if (i >= iArr2.length) {
                iArr2 = UTF8StreamJsonParser.m757a(iArr2, iArr2.length);
                this.f534N = iArr2;
            }
            int i8 = i + 1;
            iArr2[i] = i6;
            i3 = i8;
            iArr = iArr2;
            i4 = i3;
        } else {
            iArr = iArr2;
            i4 = i;
        }
        Name a = this.f533M.m863a(iArr, i4);
        if (a == null) {
            return m752a(iArr, i4, i5);
        }
        return a;
    }

    private Name m758b(int i, int i2) {
        Name b = this.f533M.m866b(i);
        if (b != null) {
            return b;
        }
        this.f534N[0] = i;
        return m752a(this.f534N, 1, i2);
    }

    private Name m759b(int i, int i2, int i3) {
        Name a = this.f533M.m861a(i, i2);
        if (a != null) {
            return a;
        }
        this.f534N[0] = i;
        this.f534N[1] = i2;
        return m752a(this.f534N, 2, i3);
    }

    private Name m753a(int[] iArr, int i, int i2, int i3) {
        if (i >= iArr.length) {
            iArr = UTF8StreamJsonParser.m757a(iArr, iArr.length);
            this.f534N = iArr;
        }
        int i4 = i + 1;
        iArr[i] = i2;
        Name a = this.f533M.m863a(iArr, i4);
        if (a == null) {
            return m752a(iArr, i4, i3);
        }
        return a;
    }

    private Name m752a(int[] iArr, int i, int i2) {
        int i3;
        int i4 = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            i3 = iArr[i - 1];
            iArr[i - 1] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] k = this.n.m972k();
        int i5 = 0;
        int i6 = 0;
        while (i6 < i4) {
            char[] cArr;
            int i7;
            int i8 = (iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3)) & MotionEventCompat.ACTION_MASK;
            i6++;
            if (i8 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                int i9;
                if ((i8 & 224) == 192) {
                    i8 &= 31;
                    i9 = 1;
                } else if ((i8 & 240) == 224) {
                    i8 &= 15;
                    i9 = 2;
                } else if ((i8 & 248) == 240) {
                    i8 &= 7;
                    i9 = 3;
                } else {
                    m791k(i8);
                    i8 = 1;
                    i9 = 1;
                }
                if (i6 + i9 > i4) {
                    m510c(" in field name");
                }
                int i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                i6++;
                if ((i10 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                    m792l(i10);
                }
                i8 = (i8 << 6) | (i10 & 63);
                if (i9 > 1) {
                    i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                    i6++;
                    if ((i10 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                        m792l(i10);
                    }
                    i8 = (i8 << 6) | (i10 & 63);
                    if (i9 > 2) {
                        i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                        i6++;
                        if ((i10 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                            m792l(i10 & MotionEventCompat.ACTION_MASK);
                        }
                        i8 = (i8 << 6) | (i10 & 63);
                    }
                }
                if (i9 > 2) {
                    i8 -= AccessibilityNodeInfoCompat.ACTION_CUT;
                    if (i5 >= k.length) {
                        k = this.n.m975n();
                    }
                    i9 = i5 + 1;
                    k[i5] = (char) (55296 + (i8 >> 10));
                    int i11 = (i8 & 1023) | 56320;
                    i8 = i6;
                    i6 = i9;
                    cArr = k;
                    i7 = i11;
                    if (i6 >= cArr.length) {
                        cArr = this.n.m975n();
                    }
                    i5 = i6 + 1;
                    cArr[i6] = (char) i7;
                    i6 = i8;
                    k = cArr;
                }
            }
            cArr = k;
            i7 = i8;
            i8 = i6;
            i6 = i5;
            if (i6 >= cArr.length) {
                cArr = this.n.m975n();
            }
            i5 = i6 + 1;
            cArr[i6] = (char) i7;
            i6 = i8;
            k = cArr;
        }
        String str = new String(k, 0, i5);
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this.f533M.m862a(str, iArr, i);
    }

    protected void m794q() {
        int i = this.d;
        if (i >= this.e) {
            m534o();
            i = this.d;
        }
        char[] k = this.n.m972k();
        int[] iArr = f530S;
        int min = Math.min(this.e, k.length + i);
        byte[] bArr = this.f537Q;
        int i2 = i;
        i = 0;
        while (i2 < min) {
            int i3 = bArr[i2] & MotionEventCompat.ACTION_MASK;
            if (iArr[i3] != 0) {
                if (i3 == 34) {
                    this.d = i2 + 1;
                    this.n.m958a(i);
                    return;
                }
                this.d = i2;
                m756a(k, i);
            }
            int i4 = i2 + 1;
            i2 = i + 1;
            k[i] = (char) i3;
            i = i2;
            i2 = i4;
        }
        this.d = i2;
        m756a(k, i);
    }

    private void m756a(char[] cArr, int i) {
        int[] iArr = f530S;
        byte[] bArr = this.f537Q;
        while (true) {
            int i2 = this.d;
            if (i2 >= this.e) {
                m534o();
                i2 = this.d;
            }
            if (i >= cArr.length) {
                cArr = this.n.m974m();
                i = 0;
            }
            int min = Math.min(this.e, (cArr.length - i) + i2);
            while (i2 < min) {
                int i3 = i2 + 1;
                i2 = bArr[i2] & MotionEventCompat.ACTION_MASK;
                if (iArr[i2] != 0) {
                    this.d = i3;
                    if (i2 == 34) {
                        this.n.m958a(i);
                        return;
                    }
                    switch (iArr[i2]) {
                        case NendIconError.ERROR_ICONVIEW /*1*/:
                            i2 = m768B();
                            break;
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            i2 = m761n(i2);
                            break;
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            if (this.e - this.d < 2) {
                                i2 = m762o(i2);
                                break;
                            } else {
                                i2 = m763p(i2);
                                break;
                            }
                        case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                            i3 = m764q(i2);
                            i2 = i + 1;
                            cArr[i] = (char) (55296 | (i3 >> 10));
                            if (i2 >= cArr.length) {
                                cArr = this.n.m974m();
                                i2 = 0;
                            }
                            i = i2;
                            i2 = (i3 & 1023) | 56320;
                            break;
                        default:
                            if (i2 >= 32) {
                                m790j(i2);
                                break;
                            } else {
                                m509c(i2, "string value");
                                break;
                            }
                    }
                    if (i >= cArr.length) {
                        cArr = this.n.m974m();
                        i3 = 0;
                    } else {
                        i3 = i;
                    }
                    i = i3 + 1;
                    cArr[i3] = (char) i2;
                } else {
                    int i4 = i + 1;
                    cArr[i] = (char) i2;
                    i2 = i3;
                    i = i4;
                }
            }
            this.d = i2;
        }
    }

    protected void m771H() {
        this.f535O = false;
        int[] iArr = f530S;
        byte[] bArr = this.f537Q;
        while (true) {
            int i = this.d;
            int i2 = this.e;
            if (i >= i2) {
                m534o();
                i = this.d;
                i2 = this.e;
            }
            while (i < i2) {
                int i3 = i + 1;
                i = bArr[i] & MotionEventCompat.ACTION_MASK;
                if (iArr[i] != 0) {
                    this.d = i3;
                    if (i != 34) {
                        switch (iArr[i]) {
                            case NendIconError.ERROR_ICONVIEW /*1*/:
                                m768B();
                                break;
                            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                                m765r(i);
                                break;
                            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                                m766s(i);
                                break;
                            case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                                m767t(i);
                                break;
                            default:
                                if (i >= 32) {
                                    m790j(i);
                                    break;
                                } else {
                                    m509c(i, "string value");
                                    break;
                                }
                        }
                    }
                    return;
                }
                i = i3;
            }
            this.d = i;
        }
    }

    protected JsonToken m788h(int i) {
        switch (i) {
            case C0268R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                if (m483a(JsonParser.ALLOW_SINGLE_QUOTES)) {
                    return m772I();
                }
                break;
            case C0268R.styleable.AppCompatTheme_dialogTheme /*43*/:
                if (this.d >= this.e && !m793p()) {
                    m499D();
                }
                byte[] bArr = this.f537Q;
                int i2 = this.d;
                this.d = i2 + 1;
                return m778a(bArr[i2] & MotionEventCompat.ACTION_MASK, false);
            case C0268R.styleable.AppCompatTheme_textAppearanceListItemSmall /*78*/:
                m781a("NaN", 1);
                if (!m483a(JsonParser.ALLOW_NON_NUMERIC_NUMBERS)) {
                    m511d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m518a("NaN", Double.NaN);
        }
        m507b(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.p013a.p014a.p015a.JsonToken m772I() {
        /*
        r10 = this;
        r9 = 39;
        r2 = 0;
        r0 = r10.n;
        r0 = r0.m972k();
        r6 = f530S;
        r7 = r10.f537Q;
        r1 = r2;
    L_0x000e:
        r3 = r10.d;
        r4 = r10.e;
        if (r3 < r4) goto L_0x0017;
    L_0x0014:
        r10.m534o();
    L_0x0017:
        r3 = r0.length;
        if (r1 < r3) goto L_0x0021;
    L_0x001a:
        r0 = r10.n;
        r0 = r0.m974m();
        r1 = r2;
    L_0x0021:
        r4 = r10.e;
        r3 = r10.d;
        r5 = r0.length;
        r5 = r5 - r1;
        r3 = r3 + r5;
        if (r3 >= r4) goto L_0x00b5;
    L_0x002a:
        r4 = r10.d;
        if (r4 >= r3) goto L_0x000e;
    L_0x002e:
        r4 = r10.d;
        r5 = r4 + 1;
        r10.d = r5;
        r4 = r7[r4];
        r5 = r4 & 255;
        if (r5 == r9) goto L_0x003e;
    L_0x003a:
        r4 = r6[r5];
        if (r4 == 0) goto L_0x0048;
    L_0x003e:
        if (r5 != r9) goto L_0x004f;
    L_0x0040:
        r0 = r10.n;
        r0.m958a(r1);
        r0 = com.p013a.p014a.p015a.JsonToken.VALUE_STRING;
        return r0;
    L_0x0048:
        r4 = r1 + 1;
        r5 = (char) r5;
        r0[r1] = r5;
        r1 = r4;
        goto L_0x002a;
    L_0x004f:
        r3 = r6[r5];
        switch(r3) {
            case 1: goto L_0x0071;
            case 2: goto L_0x007a;
            case 3: goto L_0x007f;
            case 4: goto L_0x0091;
            default: goto L_0x0054;
        };
    L_0x0054:
        r3 = 32;
        if (r5 >= r3) goto L_0x005d;
    L_0x0058:
        r3 = "string value";
        r10.m509c(r5, r3);
    L_0x005d:
        r10.m790j(r5);
    L_0x0060:
        r3 = r5;
    L_0x0061:
        r4 = r0.length;
        if (r1 < r4) goto L_0x00b1;
    L_0x0064:
        r0 = r10.n;
        r0 = r0.m974m();
        r4 = r2;
    L_0x006b:
        r1 = r4 + 1;
        r3 = (char) r3;
        r0[r4] = r3;
        goto L_0x000e;
    L_0x0071:
        r3 = 34;
        if (r5 == r3) goto L_0x0060;
    L_0x0075:
        r3 = r10.m768B();
        goto L_0x0061;
    L_0x007a:
        r3 = r10.m761n(r5);
        goto L_0x0061;
    L_0x007f:
        r3 = r10.e;
        r4 = r10.d;
        r3 = r3 - r4;
        r4 = 2;
        if (r3 < r4) goto L_0x008c;
    L_0x0087:
        r3 = r10.m763p(r5);
        goto L_0x0061;
    L_0x008c:
        r3 = r10.m762o(r5);
        goto L_0x0061;
    L_0x0091:
        r4 = r10.m764q(r5);
        r3 = r1 + 1;
        r5 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        r8 = r4 >> 10;
        r5 = r5 | r8;
        r5 = (char) r5;
        r0[r1] = r5;
        r1 = r0.length;
        if (r3 < r1) goto L_0x00b3;
    L_0x00a3:
        r0 = r10.n;
        r0 = r0.m974m();
        r1 = r2;
    L_0x00aa:
        r3 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        r4 = r4 & 1023;
        r3 = r3 | r4;
        goto L_0x0061;
    L_0x00b1:
        r4 = r1;
        goto L_0x006b;
    L_0x00b3:
        r1 = r3;
        goto L_0x00aa;
    L_0x00b5:
        r3 = r4;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.g.I():com.a.a.a.j");
    }

    protected JsonToken m778a(int i, boolean z) {
        double d = Double.NEGATIVE_INFINITY;
        if (i == 73) {
            if (this.d >= this.e && !m793p()) {
                m499D();
            }
            byte[] bArr = this.f537Q;
            int i2 = this.d;
            this.d = i2 + 1;
            i = bArr[i2];
            String str;
            if (i == 78) {
                str = z ? "-INF" : "+INF";
                m781a(str, 3);
                if (m483a(JsonParser.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return m518a(str, d);
                }
                m511d("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i == C0268R.styleable.AppCompatTheme_ratingBarStyleSmall) {
                str = z ? "-Infinity" : "+Infinity";
                m781a(str, 3);
                if (m483a(JsonParser.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return m518a(str, d);
                }
                m511d("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        m523a(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected void m781a(String str, int i) {
        int length = str.length();
        do {
            if (this.d >= this.e && !m793p()) {
                m510c(" in a value");
            }
            if (this.f537Q[this.d] != str.charAt(i)) {
                m782a(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            this.d++;
            i++;
        } while (i < length);
        if (this.d < this.e || m793p()) {
            length = this.f537Q[this.d] & MotionEventCompat.ACTION_MASK;
            if (length >= 48 && length != 93 && length != 125 && Character.isJavaIdentifierPart((char) m789i(length))) {
                this.d++;
                m782a(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
        }
    }

    protected void m782a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (true) {
            if (this.d >= this.e && !m793p()) {
                break;
            }
            byte[] bArr = this.f537Q;
            int i = this.d;
            this.d = i + 1;
            char i2 = (char) m789i(bArr[i]);
            if (!Character.isJavaIdentifierPart(i2)) {
                break;
            }
            stringBuilder.append(i2);
        }
        m511d("Unrecognized token '" + stringBuilder.toString() + "': was expecting " + str2);
    }

    private int m744N() {
        while (true) {
            if (this.d >= this.e && !m793p()) {
                break;
            }
            byte[] bArr = this.f537Q;
            int i = this.d;
            this.d = i + 1;
            int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
            if (i2 > 32) {
                if (i2 != 47) {
                    return i2;
                }
                m746P();
            } else if (i2 != 32) {
                if (i2 == 10) {
                    m774K();
                } else if (i2 == 13) {
                    m773J();
                } else if (i2 != 9) {
                    m506b(i2);
                }
            }
        }
        throw m481a("Unexpected end-of-input within/between " + this.l.m644d() + " entries");
    }

    private int m745O() {
        while (true) {
            if (this.d < this.e || m793p()) {
                byte[] bArr = this.f537Q;
                int i = this.d;
                this.d = i + 1;
                int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    m746P();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        m774K();
                    } else if (i2 == 13) {
                        m773J();
                    } else if (i2 != 9) {
                        m506b(i2);
                    }
                }
            } else {
                m539t();
                return -1;
            }
        }
    }

    private void m746P() {
        if (!m483a(JsonParser.ALLOW_COMMENTS)) {
            m507b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.d >= this.e && !m793p()) {
            m510c(" in a comment");
        }
        byte[] bArr = this.f537Q;
        int i = this.d;
        this.d = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (i2 == 47) {
            m748R();
        } else if (i2 == 42) {
            m747Q();
        } else {
            m507b(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private void m747Q() {
        int[] e = CharTypes.m560e();
        while (true) {
            if (this.d < this.e || m793p()) {
                byte[] bArr = this.f537Q;
                int i = this.d;
                this.d = i + 1;
                int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
                i = e[i2];
                if (i != 0) {
                    switch (i) {
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            m765r(i2);
                            continue;
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            m766s(i2);
                            continue;
                        case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                            m767t(i2);
                            continue;
                        case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                            m774K();
                            continue;
                        case CommonStatusCodes.ERROR /*13*/:
                            m773J();
                            continue;
                        case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                            if (this.d >= this.e && !m793p()) {
                                break;
                            } else if (this.f537Q[this.d] == 47) {
                                this.d++;
                                return;
                            } else {
                                continue;
                            }
                        default:
                            m790j(i2);
                            continue;
                    }
                }
            }
            m510c(" in a comment");
            return;
        }
    }

    private void m748R() {
        int[] e = CharTypes.m560e();
        while (true) {
            if (this.d < this.e || m793p()) {
                byte[] bArr = this.f537Q;
                int i = this.d;
                this.d = i + 1;
                int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
                i = e[i2];
                if (i != 0) {
                    switch (i) {
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            m765r(i2);
                            break;
                        case SendException.ERROR_TTL_EXCEEDED /*3*/:
                            m766s(i2);
                            break;
                        case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                            m767t(i2);
                            break;
                        case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                            m774K();
                            return;
                        case CommonStatusCodes.ERROR /*13*/:
                            m773J();
                            return;
                        case C0268R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                            break;
                        default:
                            m790j(i2);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    protected char m768B() {
        int i = 0;
        if (this.d >= this.e && !m793p()) {
            m510c(" in character escape sequence");
        }
        byte[] bArr = this.f537Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        switch (b) {
            case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
            case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
            case C0268R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                return (char) b;
            case C0268R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                return '\b';
            case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
                return '\f';
            case C0268R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                return '\n';
            case C0268R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                return '\r';
            case (byte) 116:
                return '\t';
            case (byte) 117:
                int i3 = 0;
                while (i < 4) {
                    if (this.d >= this.e && !m793p()) {
                        m510c(" in character escape sequence");
                    }
                    byte[] bArr2 = this.f537Q;
                    int i4 = this.d;
                    this.d = i4 + 1;
                    byte b2 = bArr2[i4];
                    i4 = CharTypes.m554a(b2);
                    if (i4 < 0) {
                        m507b((int) b2, "expected a hex-digit for character escape sequence");
                    }
                    i3 = (i3 << 4) | i4;
                    i++;
                }
                return (char) i3;
            default:
                return m501a((char) m789i(b));
        }
    }

    protected int m789i(int i) {
        if (i >= 0) {
            return i;
        }
        Object obj;
        int i2;
        if ((i & 224) == 192) {
            i &= 31;
            obj = 1;
        } else if ((i & 240) == 224) {
            i &= 15;
            i2 = 2;
        } else if ((i & 248) == 240) {
            i &= 7;
            obj = 3;
        } else {
            m791k(i & MotionEventCompat.ACTION_MASK);
            i2 = 1;
        }
        int S = m749S();
        if ((S & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m792l(S & MotionEventCompat.ACTION_MASK);
        }
        i = (i << 6) | (S & 63);
        if (obj <= 1) {
            return i;
        }
        int S2 = m749S();
        if ((S2 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m792l(S2 & MotionEventCompat.ACTION_MASK);
        }
        i = (i << 6) | (S2 & 63);
        if (obj <= 2) {
            return i;
        }
        i2 = m749S();
        if ((i2 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m792l(i2 & MotionEventCompat.ACTION_MASK);
        }
        return (i << 6) | (i2 & 63);
    }

    private int m761n(int i) {
        if (this.d >= this.e) {
            m534o();
        }
        byte[] bArr = this.f537Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        return (b & 63) | ((i & 31) << 6);
    }

    private int m762o(int i) {
        if (this.d >= this.e) {
            m534o();
        }
        int i2 = i & 15;
        byte[] bArr = this.f537Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        i2 = (i2 << 6) | (b & 63);
        if (this.d >= this.e) {
            m534o();
        }
        bArr = this.f537Q;
        i3 = this.d;
        this.d = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        return (i2 << 6) | (b & 63);
    }

    private int m763p(int i) {
        int i2 = i & 15;
        byte[] bArr = this.f537Q;
        int i3 = this.d;
        this.d = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        i2 = (i2 << 6) | (b & 63);
        bArr = this.f537Q;
        i3 = this.d;
        this.d = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        return (i2 << 6) | (b & 63);
    }

    private int m764q(int i) {
        if (this.d >= this.e) {
            m534o();
        }
        byte[] bArr = this.f537Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        int i3 = (b & 63) | ((i & 7) << 6);
        if (this.d >= this.e) {
            m534o();
        }
        byte[] bArr2 = this.f537Q;
        int i4 = this.d;
        this.d = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b2 & MotionEventCompat.ACTION_MASK, this.d);
        }
        i3 = (i3 << 6) | (b2 & 63);
        if (this.d >= this.e) {
            m534o();
        }
        bArr2 = this.f537Q;
        i4 = this.d;
        this.d = i4 + 1;
        b2 = bArr2[i4];
        if ((b2 & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b2 & MotionEventCompat.ACTION_MASK, this.d);
        }
        return ((i3 << 6) | (b2 & 63)) - AccessibilityNodeInfoCompat.ACTION_CUT;
    }

    private void m765r(int i) {
        if (this.d >= this.e) {
            m534o();
        }
        byte[] bArr = this.f537Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
    }

    private void m766s(int i) {
        if (this.d >= this.e) {
            m534o();
        }
        byte[] bArr = this.f537Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        if (this.d >= this.e) {
            m534o();
        }
        bArr = this.f537Q;
        i2 = this.d;
        this.d = i2 + 1;
        b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
    }

    private void m767t(int i) {
        if (this.d >= this.e) {
            m534o();
        }
        byte[] bArr = this.f537Q;
        int i2 = this.d;
        this.d = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        if (this.d >= this.e) {
            m534o();
        }
        bArr = this.f537Q;
        i2 = this.d;
        this.d = i2 + 1;
        b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
        if (this.d >= this.e) {
            m534o();
        }
        bArr = this.f537Q;
        i2 = this.d;
        this.d = i2 + 1;
        b = bArr[i2];
        if ((b & 192) != AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m780a(b & MotionEventCompat.ACTION_MASK, this.d);
        }
    }

    protected void m773J() {
        if ((this.d < this.e || m793p()) && this.f537Q[this.d] == 10) {
            this.d++;
        }
        this.g++;
        this.h = this.d;
    }

    protected void m774K() {
        this.g++;
        this.h = this.d;
    }

    private int m749S() {
        if (this.d >= this.e) {
            m534o();
        }
        byte[] bArr = this.f537Q;
        int i = this.d;
        this.d = i + 1;
        return bArr[i] & MotionEventCompat.ACTION_MASK;
    }

    protected void m790j(int i) {
        if (i < 32) {
            m506b(i);
        }
        m791k(i);
    }

    protected void m791k(int i) {
        m511d("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void m792l(int i) {
        m511d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    protected void m780a(int i, int i2) {
        this.d = i2;
        m792l(i);
    }

    public static int[] m757a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[(length + i)];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }
}
