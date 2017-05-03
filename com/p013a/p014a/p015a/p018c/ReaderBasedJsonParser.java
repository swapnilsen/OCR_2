package com.p013a.p014a.p015a.p018c;

import android.support.v7.appcompat.C0268R;
import com.google.ads.AdSize;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonParser.JsonParser;
import com.p013a.p014a.p015a.JsonToken;
import com.p013a.p014a.p015a.ObjectCodec;
import com.p013a.p014a.p015a.p016a.ParserBase;
import com.p013a.p014a.p015a.p017b.CharTypes;
import com.p013a.p014a.p015a.p017b.IOContext;
import com.p013a.p014a.p015a.p019d.CharsToNameCanonicalizer;
import com.p013a.p014a.p015a.p020e.TextBuffer;
import java.io.IOException;
import java.io.Reader;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.c.e */
public final class ReaderBasedJsonParser extends ParserBase {
    protected Reader f511L;
    protected char[] f512M;
    protected ObjectCodec f513N;
    protected final CharsToNameCanonicalizer f514O;
    protected final int f515P;
    protected boolean f516Q;

    /* renamed from: com.a.a.a.c.e.1 */
    static /* synthetic */ class ReaderBasedJsonParser {
        static final /* synthetic */ int[] f510a;

        static {
            f510a = new int[JsonToken.values().length];
            try {
                f510a[JsonToken.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f510a[JsonToken.VALUE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f510a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f510a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f510a[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f510a[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public ReaderBasedJsonParser(IOContext iOContext, int i, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer) {
        super(iOContext, i);
        this.f516Q = false;
        this.f511L = reader;
        this.f512M = iOContext.m578g();
        this.f513N = objectCodec;
        this.f514O = charsToNameCanonicalizer;
        this.f515P = charsToNameCanonicalizer.m892e();
    }

    protected boolean m692p() {
        this.f += (long) this.e;
        this.h -= this.e;
        if (this.f511L == null) {
            return false;
        }
        int read = this.f511L.read(this.f512M, 0, this.f512M.length);
        if (read > 0) {
            this.d = 0;
            this.e = read;
            return true;
        }
        m694r();
        if (read != 0) {
            return false;
        }
        throw new IOException("Reader returned 0 characters when trying to read " + this.e);
    }

    protected char m687e(String str) {
        if (this.d >= this.e && !m692p()) {
            m510c(str);
        }
        char[] cArr = this.f512M;
        int i = this.d;
        this.d = i + 1;
        return cArr[i];
    }

    protected void m694r() {
        if (this.f511L != null) {
            if (this.b.m574c() || m483a(JsonParser.AUTO_CLOSE_SOURCE)) {
                this.f511L.close();
            }
            this.f511L = null;
        }
    }

    protected void m695s() {
        super.m538s();
        char[] cArr = this.f512M;
        if (cArr != null) {
            this.f512M = null;
            this.b.m569a(cArr);
        }
    }

    public String m689f() {
        JsonToken jsonToken = this.K;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return m683a(jsonToken);
        }
        if (this.f516Q) {
            this.f516Q = false;
            m693q();
        }
        return this.n.m967f();
    }

    protected String m683a(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (ReaderBasedJsonParser.f510a[jsonToken.ordinal()]) {
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

    public JsonToken m681a() {
        this.A = 0;
        if (this.K == JsonToken.FIELD_NAME) {
            return m664L();
        }
        if (this.f516Q) {
            m678I();
        }
        int O = m667O();
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
                O = m666N();
            }
            boolean c = this.l.m643c();
            if (c) {
                this.l.m651a(m688e(O));
                this.K = JsonToken.FIELD_NAME;
                O = m666N();
                if (O != 58) {
                    m507b(O, "was expecting a colon to separate field name and value");
                }
                O = m666N();
            }
            switch (O) {
                case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.f516Q = true;
                    jsonToken = JsonToken.VALUE_STRING;
                    break;
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
                    jsonToken = m686d(O);
                    break;
                case C0268R.styleable.AppCompatTheme_controlBackground /*91*/:
                    if (!c) {
                        this.l = this.l.m648a(this.j, this.k);
                    }
                    jsonToken = JsonToken.START_ARRAY;
                    break;
                case C0268R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                case 125:
                    m507b(O, "expected a value");
                    break;
                case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
                    m684a("false", 1);
                    jsonToken = JsonToken.VALUE_FALSE;
                    break;
                case C0268R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                    m684a("null", 1);
                    jsonToken = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    if (!c) {
                        this.l = this.l.m652b(this.j, this.k);
                    }
                    jsonToken = JsonToken.START_OBJECT;
                    break;
                default:
                    jsonToken = m691g(O);
                    break;
            }
            m684a("true", 1);
            jsonToken = JsonToken.VALUE_TRUE;
            if (c) {
                this.m = jsonToken;
                return this.K;
            }
            this.K = jsonToken;
            return jsonToken;
        }
    }

    private JsonToken m664L() {
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
        this.f514O.m888b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.p013a.p014a.p015a.JsonToken m686d(int r14) {
        /*
        r13 = this;
        r11 = 45;
        r1 = 1;
        r2 = 0;
        r10 = 57;
        r9 = 48;
        if (r14 != r11) goto L_0x0022;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r4 = r13.d;
        r5 = r4 + -1;
        r7 = r13.e;
        if (r0 == 0) goto L_0x0035;
    L_0x0013:
        r3 = r13.e;
        if (r4 < r3) goto L_0x0024;
    L_0x0017:
        if (r0 == 0) goto L_0x00b4;
    L_0x0019:
        r1 = r5 + 1;
    L_0x001b:
        r13.d = r1;
        r0 = r13.m671a(r0);
    L_0x0021:
        return r0;
    L_0x0022:
        r0 = r2;
        goto L_0x000b;
    L_0x0024:
        r6 = r13.f512M;
        r3 = r4 + 1;
        r14 = r6[r4];
        if (r14 > r10) goto L_0x002e;
    L_0x002c:
        if (r14 >= r9) goto L_0x0036;
    L_0x002e:
        r13.d = r3;
        r0 = r13.m682a(r14, r1);
        goto L_0x0021;
    L_0x0035:
        r3 = r4;
    L_0x0036:
        if (r14 == r9) goto L_0x0017;
    L_0x0038:
        r4 = r13.e;
        if (r3 >= r4) goto L_0x0017;
    L_0x003c:
        r6 = r13.f512M;
        r4 = r3 + 1;
        r3 = r6[r3];
        if (r3 < r9) goto L_0x0046;
    L_0x0044:
        if (r3 <= r10) goto L_0x0093;
    L_0x0046:
        r6 = 46;
        if (r3 != r6) goto L_0x00bb;
    L_0x004a:
        r3 = r2;
        r6 = r4;
    L_0x004c:
        if (r6 >= r7) goto L_0x0017;
    L_0x004e:
        r8 = r13.f512M;
        r4 = r6 + 1;
        r6 = r8[r6];
        if (r6 < r9) goto L_0x0058;
    L_0x0056:
        if (r6 <= r10) goto L_0x0097;
    L_0x0058:
        if (r3 != 0) goto L_0x005f;
    L_0x005a:
        r8 = "Decimal point not followed by a digit";
        r13.m523a(r6, r8);
    L_0x005f:
        r12 = r3;
        r3 = r4;
        r4 = r6;
        r6 = r12;
    L_0x0063:
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r4 == r8) goto L_0x006b;
    L_0x0067:
        r8 = 69;
        if (r4 != r8) goto L_0x00a2;
    L_0x006b:
        if (r3 >= r7) goto L_0x0017;
    L_0x006d:
        r8 = r13.f512M;
        r4 = r3 + 1;
        r3 = r8[r3];
        if (r3 == r11) goto L_0x0079;
    L_0x0075:
        r8 = 43;
        if (r3 != r8) goto L_0x00b7;
    L_0x0079:
        if (r4 >= r7) goto L_0x0017;
    L_0x007b:
        r8 = r13.f512M;
        r3 = r4 + 1;
        r4 = r8[r4];
    L_0x0081:
        if (r4 > r10) goto L_0x009b;
    L_0x0083:
        if (r4 < r9) goto L_0x009b;
    L_0x0085:
        r2 = r2 + 1;
        if (r3 >= r7) goto L_0x0017;
    L_0x0089:
        r8 = r13.f512M;
        r4 = r3 + 1;
        r3 = r8[r3];
        r12 = r4;
        r4 = r3;
        r3 = r12;
        goto L_0x0081;
    L_0x0093:
        r1 = r1 + 1;
        r3 = r4;
        goto L_0x0038;
    L_0x0097:
        r3 = r3 + 1;
        r6 = r4;
        goto L_0x004c;
    L_0x009b:
        if (r2 != 0) goto L_0x00a2;
    L_0x009d:
        r7 = "Exponent indicator not followed by a digit";
        r13.m523a(r4, r7);
    L_0x00a2:
        r3 = r3 + -1;
        r13.d = r3;
        r3 = r3 - r5;
        r4 = r13.n;
        r7 = r13.f512M;
        r4.m960a(r7, r5, r3);
        r0 = r13.m520a(r0, r1, r6, r2);
        goto L_0x0021;
    L_0x00b4:
        r1 = r5;
        goto L_0x001b;
    L_0x00b7:
        r12 = r4;
        r4 = r3;
        r3 = r12;
        goto L_0x0081;
    L_0x00bb:
        r6 = r2;
        r12 = r4;
        r4 = r3;
        r3 = r12;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.e.d(int):com.a.a.a.j");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.p013a.p014a.p015a.JsonToken m671a(boolean r15) {
        /*
        r14 = this;
        r10 = 45;
        r12 = 57;
        r11 = 48;
        r1 = 1;
        r2 = 0;
        r0 = r14.n;
        r4 = r0.m972k();
        if (r15 == 0) goto L_0x01a0;
    L_0x0010:
        r4[r2] = r10;
        r0 = r1;
    L_0x0013:
        r3 = r14.d;
        r5 = r14.e;
        if (r3 >= r5) goto L_0x0126;
    L_0x0019:
        r3 = r14.f512M;
        r5 = r14.d;
        r6 = r5 + 1;
        r14.d = r6;
        r3 = r3[r5];
    L_0x0023:
        if (r3 != r11) goto L_0x0029;
    L_0x0025:
        r3 = r14.m665M();
    L_0x0029:
        r5 = r2;
        r13 = r3;
        r3 = r4;
        r4 = r13;
    L_0x002d:
        if (r4 < r11) goto L_0x0199;
    L_0x002f:
        if (r4 > r12) goto L_0x0199;
    L_0x0031:
        r5 = r5 + 1;
        r6 = r3.length;
        if (r0 < r6) goto L_0x003e;
    L_0x0036:
        r0 = r14.n;
        r0 = r0.m974m();
        r3 = r0;
        r0 = r2;
    L_0x003e:
        r6 = r0 + 1;
        r3[r0] = r4;
        r0 = r14.d;
        r4 = r14.e;
        if (r0 < r4) goto L_0x012e;
    L_0x0048:
        r0 = r14.m692p();
        if (r0 != 0) goto L_0x012e;
    L_0x004e:
        r7 = r1;
        r0 = r2;
        r9 = r5;
        r4 = r3;
        r5 = r6;
    L_0x0053:
        if (r9 != 0) goto L_0x0075;
    L_0x0055:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r6 = "Missing integer part (next char ";
        r3 = r3.append(r6);
        r6 = com.p013a.p014a.p015a.p016a.ParserMinimalBase.m497c(r0);
        r3 = r3.append(r6);
        r6 = ")";
        r3 = r3.append(r6);
        r3 = r3.toString();
        r14.m525b(r3);
    L_0x0075:
        r3 = 46;
        if (r0 != r3) goto L_0x0192;
    L_0x0079:
        r3 = r5 + 1;
        r4[r5] = r0;
        r5 = r4;
        r4 = r3;
        r3 = r0;
        r0 = r2;
    L_0x0081:
        r6 = r14.d;
        r8 = r14.e;
        if (r6 < r8) goto L_0x013b;
    L_0x0087:
        r6 = r14.m692p();
        if (r6 != 0) goto L_0x013b;
    L_0x008d:
        r6 = r3;
        r3 = r1;
    L_0x008f:
        if (r0 != 0) goto L_0x0096;
    L_0x0091:
        r7 = "Decimal point not followed by a digit";
        r14.m523a(r6, r7);
    L_0x0096:
        r8 = r0;
        r0 = r4;
        r13 = r3;
        r3 = r5;
        r5 = r13;
    L_0x009b:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r6 == r4) goto L_0x00a3;
    L_0x009f:
        r4 = 69;
        if (r6 != r4) goto L_0x0189;
    L_0x00a3:
        r4 = r3.length;
        if (r0 < r4) goto L_0x00ae;
    L_0x00a6:
        r0 = r14.n;
        r0 = r0.m974m();
        r3 = r0;
        r0 = r2;
    L_0x00ae:
        r4 = r0 + 1;
        r3[r0] = r6;
        r0 = r14.d;
        r6 = r14.e;
        if (r0 >= r6) goto L_0x015f;
    L_0x00b8:
        r0 = r14.f512M;
        r6 = r14.d;
        r7 = r6 + 1;
        r14.d = r7;
        r6 = r0[r6];
    L_0x00c2:
        if (r6 == r10) goto L_0x00c8;
    L_0x00c4:
        r0 = 43;
        if (r6 != r0) goto L_0x0184;
    L_0x00c8:
        r0 = r3.length;
        if (r4 < r0) goto L_0x0181;
    L_0x00cb:
        r0 = r14.n;
        r3 = r0.m974m();
        r0 = r2;
    L_0x00d2:
        r4 = r0 + 1;
        r3[r0] = r6;
        r0 = r14.d;
        r6 = r14.e;
        if (r0 >= r6) goto L_0x0167;
    L_0x00dc:
        r0 = r14.f512M;
        r6 = r14.d;
        r7 = r6 + 1;
        r14.d = r7;
        r0 = r0[r6];
    L_0x00e6:
        r7 = r0;
        r0 = r4;
        r4 = r2;
    L_0x00e9:
        if (r7 > r12) goto L_0x017d;
    L_0x00eb:
        if (r7 < r11) goto L_0x017d;
    L_0x00ed:
        r4 = r4 + 1;
        r6 = r3.length;
        if (r0 < r6) goto L_0x00fa;
    L_0x00f2:
        r0 = r14.n;
        r0 = r0.m974m();
        r3 = r0;
        r0 = r2;
    L_0x00fa:
        r6 = r0 + 1;
        r3[r0] = r7;
        r0 = r14.d;
        r10 = r14.e;
        if (r0 < r10) goto L_0x016f;
    L_0x0104:
        r0 = r14.m692p();
        if (r0 != 0) goto L_0x016f;
    L_0x010a:
        r2 = r4;
        r0 = r1;
        r1 = r6;
    L_0x010d:
        if (r2 != 0) goto L_0x0114;
    L_0x010f:
        r3 = "Exponent indicator not followed by a digit";
        r14.m523a(r7, r3);
    L_0x0114:
        if (r0 != 0) goto L_0x011c;
    L_0x0116:
        r0 = r14.d;
        r0 = r0 + -1;
        r14.d = r0;
    L_0x011c:
        r0 = r14.n;
        r0.m958a(r1);
        r0 = r14.m520a(r15, r9, r8, r2);
        return r0;
    L_0x0126:
        r3 = "No digit following minus sign";
        r3 = r14.m687e(r3);
        goto L_0x0023;
    L_0x012e:
        r0 = r14.f512M;
        r4 = r14.d;
        r7 = r4 + 1;
        r14.d = r7;
        r4 = r0[r4];
        r0 = r6;
        goto L_0x002d;
    L_0x013b:
        r3 = r14.f512M;
        r6 = r14.d;
        r8 = r6 + 1;
        r14.d = r8;
        r3 = r3[r6];
        if (r3 < r11) goto L_0x018e;
    L_0x0147:
        if (r3 <= r12) goto L_0x014d;
    L_0x0149:
        r6 = r3;
        r3 = r7;
        goto L_0x008f;
    L_0x014d:
        r0 = r0 + 1;
        r6 = r5.length;
        if (r4 < r6) goto L_0x018c;
    L_0x0152:
        r4 = r14.n;
        r5 = r4.m974m();
        r6 = r2;
    L_0x0159:
        r4 = r6 + 1;
        r5[r6] = r3;
        goto L_0x0081;
    L_0x015f:
        r0 = "expected a digit for number exponent";
        r6 = r14.m687e(r0);
        goto L_0x00c2;
    L_0x0167:
        r0 = "expected a digit for number exponent";
        r0 = r14.m687e(r0);
        goto L_0x00e6;
    L_0x016f:
        r0 = r14.f512M;
        r7 = r14.d;
        r10 = r7 + 1;
        r14.d = r10;
        r0 = r0[r7];
        r7 = r0;
        r0 = r6;
        goto L_0x00e9;
    L_0x017d:
        r2 = r4;
        r1 = r0;
        r0 = r5;
        goto L_0x010d;
    L_0x0181:
        r0 = r4;
        goto L_0x00d2;
    L_0x0184:
        r7 = r6;
        r0 = r4;
        r4 = r2;
        goto L_0x00e9;
    L_0x0189:
        r1 = r0;
        r0 = r5;
        goto L_0x0114;
    L_0x018c:
        r6 = r4;
        goto L_0x0159;
    L_0x018e:
        r6 = r3;
        r3 = r7;
        goto L_0x008f;
    L_0x0192:
        r8 = r2;
        r6 = r0;
        r3 = r4;
        r0 = r5;
        r5 = r7;
        goto L_0x009b;
    L_0x0199:
        r7 = r2;
        r9 = r5;
        r5 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0053;
    L_0x01a0:
        r0 = r2;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.e.a(boolean):com.a.a.a.j");
    }

    private char m665M() {
        if (this.d >= this.e && !m692p()) {
            return '0';
        }
        char c = this.f512M[this.d];
        if (c < '0' || c > '9') {
            return '0';
        }
        if (!m483a(JsonParser.ALLOW_NUMERIC_LEADING_ZEROS)) {
            m525b("Leading zeroes not allowed");
        }
        this.d++;
        if (c != '0') {
            return c;
        }
        do {
            if (this.d >= this.e && !m692p()) {
                return c;
            }
            c = this.f512M[this.d];
            if (c < '0' || c > '9') {
                return '0';
            }
            this.d++;
        } while (c == '0');
        return c;
    }

    protected JsonToken m682a(int i, boolean z) {
        double d = Double.NEGATIVE_INFINITY;
        if (i == 73) {
            if (this.d >= this.e && !m692p()) {
                m499D();
            }
            char[] cArr = this.f512M;
            int i2 = this.d;
            this.d = i2 + 1;
            i = cArr[i2];
            String str;
            if (i == 78) {
                str = z ? "-INF" : "+INF";
                m684a(str, 3);
                if (m483a(JsonParser.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return m518a(str, d);
                }
                m511d("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i == C0268R.styleable.AppCompatTheme_ratingBarStyleSmall) {
                str = z ? "-Infinity" : "+Infinity";
                m684a(str, 3);
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

    protected String m688e(int i) {
        if (i != 34) {
            return m690f(i);
        }
        int i2 = this.d;
        int i3 = this.f515P;
        int i4 = this.e;
        if (i2 < i4) {
            int[] a = CharTypes.m556a();
            char length = a.length;
            do {
                char c = this.f512M[i2];
                if (c >= length || a[c] == 0) {
                    i3 = (i3 * 33) + c;
                    i2++;
                } else if (c == '\"') {
                    i4 = this.d;
                    this.d = i2 + 1;
                    return this.f514O.m886a(this.f512M, i4, i2 - i4, i3);
                }
            } while (i2 < i4);
        }
        i4 = this.d;
        this.d = i2;
        return m672a(i4, i3, 34);
    }

    private String m672a(int i, int i2, int i3) {
        this.n.m960a(this.f512M, i, this.d - i);
        char[] j = this.n.m971j();
        int l = this.n.m973l();
        while (true) {
            char B;
            if (this.d >= this.e && !m692p()) {
                m510c(": was expecting closing '" + ((char) i3) + "' for name");
            }
            char[] cArr = this.f512M;
            int i4 = this.d;
            this.d = i4 + 1;
            char c = cArr[i4];
            if (c <= '\\') {
                if (c == '\\') {
                    B = m674B();
                    i2 = (i2 * 33) + c;
                    i4 = l + 1;
                    j[l] = B;
                    if (i4 < j.length) {
                        j = this.n.m974m();
                        l = 0;
                    } else {
                        l = i4;
                    }
                } else if (c <= i3) {
                    if (c == i3) {
                        this.n.m958a(l);
                        TextBuffer textBuffer = this.n;
                        return this.f514O.m886a(textBuffer.m966e(), textBuffer.m965d(), textBuffer.m963c(), i2);
                    } else if (c < ' ') {
                        m509c(c, "name");
                    }
                }
            }
            B = c;
            i2 = (i2 * 33) + c;
            i4 = l + 1;
            j[l] = B;
            if (i4 < j.length) {
                l = i4;
            } else {
                j = this.n.m974m();
                l = 0;
            }
        }
    }

    protected String m690f(int i) {
        if (i == 39 && m483a(JsonParser.ALLOW_SINGLE_QUOTES)) {
            return m675F();
        }
        if (!m483a(JsonParser.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m507b(i, "was expecting double-quote to start field name");
        }
        int[] c = CharTypes.m558c();
        char length = c.length;
        boolean isJavaIdentifierPart = i < length ? c[i] == 0 && (i < 48 || i > 57) : Character.isJavaIdentifierPart((char) i);
        if (!isJavaIdentifierPart) {
            m507b(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i2 = this.d;
        int i3 = this.f515P;
        int i4 = this.e;
        if (i2 < i4) {
            do {
                char c2 = this.f512M[i2];
                int i5;
                if (c2 < length) {
                    if (c[c2] != 0) {
                        i5 = this.d - 1;
                        this.d = i2;
                        return this.f514O.m886a(this.f512M, i5, i2 - i5, i3);
                    }
                } else if (!Character.isJavaIdentifierPart((char) c2)) {
                    i5 = this.d - 1;
                    this.d = i2;
                    return this.f514O.m886a(this.f512M, i5, i2 - i5, i3);
                }
                i3 = (i3 * 33) + c2;
                i2++;
            } while (i2 < i4);
        }
        int i6 = this.d - 1;
        this.d = i2;
        return m673a(i6, i3, c);
    }

    protected String m675F() {
        int i = this.d;
        int i2 = this.f515P;
        int i3 = this.e;
        if (i < i3) {
            int[] a = CharTypes.m556a();
            char length = a.length;
            do {
                char c = this.f512M[i];
                if (c != '\'') {
                    if (c < length && a[c] != 0) {
                        break;
                    }
                    i2 = (i2 * 33) + c;
                    i++;
                } else {
                    i3 = this.d;
                    this.d = i + 1;
                    return this.f514O.m886a(this.f512M, i3, i - i3, i2);
                }
            } while (i < i3);
        }
        i3 = this.d;
        this.d = i;
        return m672a(i3, i2, 39);
    }

    protected JsonToken m691g(int i) {
        switch (i) {
            case C0268R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                if (m483a(JsonParser.ALLOW_SINGLE_QUOTES)) {
                    return m676G();
                }
                break;
            case C0268R.styleable.AppCompatTheme_dialogTheme /*43*/:
                if (this.d >= this.e && !m692p()) {
                    m499D();
                }
                char[] cArr = this.f512M;
                int i2 = this.d;
                this.d = i2 + 1;
                return m682a(cArr[i2], false);
            case C0268R.styleable.AppCompatTheme_textAppearanceListItemSmall /*78*/:
                m684a("NaN", 1);
                if (!m483a(JsonParser.ALLOW_NON_NUMERIC_NUMBERS)) {
                    m511d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m518a("NaN", Double.NaN);
        }
        m507b(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    protected JsonToken m676G() {
        char[] k = this.n.m972k();
        int l = this.n.m973l();
        while (true) {
            if (this.d >= this.e && !m692p()) {
                m510c(": was expecting closing quote for a string value");
            }
            char[] cArr = this.f512M;
            int i = this.d;
            this.d = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = m674B();
                } else if (c <= '\'') {
                    if (c == '\'') {
                        this.n.m958a(l);
                        return JsonToken.VALUE_STRING;
                    } else if (c < ' ') {
                        m509c(c, "string value");
                    }
                }
            }
            if (l >= k.length) {
                k = this.n.m974m();
                i = 0;
            } else {
                i = l;
            }
            l = i + 1;
            k[i] = c;
        }
    }

    private String m673a(int i, int i2, int[] iArr) {
        this.n.m960a(this.f512M, i, this.d - i);
        char[] j = this.n.m971j();
        int l = this.n.m973l();
        char length = iArr.length;
        while (true) {
            if (this.d >= this.e && !m692p()) {
                break;
            }
            char c = this.f512M[this.d];
            if (c > length) {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
            } else if (iArr[c] != 0) {
                break;
            }
            this.d++;
            i2 = (i2 * 33) + c;
            int i3 = l + 1;
            j[l] = c;
            if (i3 >= j.length) {
                j = this.n.m974m();
                l = 0;
            } else {
                l = i3;
            }
        }
        this.n.m958a(l);
        TextBuffer textBuffer = this.n;
        return this.f514O.m886a(textBuffer.m966e(), textBuffer.m965d(), textBuffer.m963c(), i2);
    }

    protected void m693q() {
        int i = this.d;
        int i2 = this.e;
        if (i < i2) {
            int[] a = CharTypes.m556a();
            char length = a.length;
            do {
                char c = this.f512M[i];
                if (c >= length || a[c] == 0) {
                    i++;
                } else if (c == '\"') {
                    this.n.m960a(this.f512M, this.d, i - this.d);
                    this.d = i + 1;
                    return;
                }
            } while (i < i2);
        }
        this.n.m962b(this.f512M, this.d, i - this.d);
        this.d = i;
        m677H();
    }

    protected void m677H() {
        char[] j = this.n.m971j();
        int l = this.n.m973l();
        while (true) {
            if (this.d >= this.e && !m692p()) {
                m510c(": was expecting closing quote for a string value");
            }
            char[] cArr = this.f512M;
            int i = this.d;
            this.d = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = m674B();
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.n.m958a(l);
                        return;
                    } else if (c < ' ') {
                        m509c(c, "string value");
                    }
                }
            }
            if (l >= j.length) {
                j = this.n.m974m();
                i = 0;
            } else {
                i = l;
            }
            l = i + 1;
            j[i] = c;
        }
    }

    protected void m678I() {
        this.f516Q = false;
        int i = this.d;
        int i2 = this.e;
        char[] cArr = this.f512M;
        while (true) {
            if (i >= i2) {
                this.d = i;
                if (!m692p()) {
                    m510c(": was expecting closing quote for a string value");
                }
                i = this.d;
                i2 = this.e;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this.d = i3;
                    m674B();
                    i = this.d;
                    i2 = this.e;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.d = i3;
                        return;
                    } else if (c < ' ') {
                        this.d = i3;
                        m509c(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    protected void m679J() {
        if ((this.d < this.e || m692p()) && this.f512M[this.d] == '\n') {
            this.d++;
        }
        this.g++;
        this.h = this.d;
    }

    protected void m680K() {
        this.g++;
        this.h = this.d;
    }

    private int m666N() {
        while (true) {
            if (this.d >= this.e && !m692p()) {
                break;
            }
            char[] cArr = this.f512M;
            int i = this.d;
            this.d = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                if (c != '/') {
                    return c;
                }
                m668P();
            } else if (c != ' ') {
                if (c == '\n') {
                    m680K();
                } else if (c == '\r') {
                    m679J();
                } else if (c != '\t') {
                    m506b(c);
                }
            }
        }
        throw m481a("Unexpected end-of-input within/between " + this.l.m644d() + " entries");
    }

    private int m667O() {
        while (true) {
            if (this.d < this.e || m692p()) {
                char[] cArr = this.f512M;
                int i = this.d;
                this.d = i + 1;
                int i2 = cArr[i];
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    m668P();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        m680K();
                    } else if (i2 == 13) {
                        m679J();
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

    private void m668P() {
        if (!m483a(JsonParser.ALLOW_COMMENTS)) {
            m507b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.d >= this.e && !m692p()) {
            m510c(" in a comment");
        }
        char[] cArr = this.f512M;
        int i = this.d;
        this.d = i + 1;
        char c = cArr[i];
        if (c == '/') {
            m670R();
        } else if (c == '*') {
            m669Q();
        } else {
            m507b((int) c, "was expecting either '*' or '/' for a comment");
        }
    }

    private void m669Q() {
        while (true) {
            if (this.d >= this.e && !m692p()) {
                break;
            }
            char[] cArr = this.f512M;
            int i = this.d;
            this.d = i + 1;
            char c = cArr[i];
            if (c <= '*') {
                if (c == '*') {
                    if (this.d >= this.e && !m692p()) {
                        break;
                    } else if (this.f512M[this.d] == '/') {
                        this.d++;
                        return;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        m680K();
                    } else if (c == '\r') {
                        m679J();
                    } else if (c != '\t') {
                        m506b(c);
                    }
                }
            }
        }
        m510c(" in a comment");
    }

    private void m670R() {
        while (true) {
            if (this.d < this.e || m692p()) {
                char[] cArr = this.f512M;
                int i = this.d;
                this.d = i + 1;
                char c = cArr[i];
                if (c < ' ') {
                    if (c == '\n') {
                        m680K();
                        return;
                    } else if (c == '\r') {
                        m679J();
                        return;
                    } else if (c != '\t') {
                        m506b(c);
                    }
                }
            } else {
                return;
            }
        }
    }

    protected char m674B() {
        int i = 0;
        if (this.d >= this.e && !m692p()) {
            m510c(" in character escape sequence");
        }
        char[] cArr = this.f512M;
        int i2 = this.d;
        this.d = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case C0268R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
            case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
            case C0268R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                return c;
            case C0268R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                return '\b';
            case C0268R.styleable.AppCompatTheme_buttonStyle /*102*/:
                return '\f';
            case C0268R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                return '\n';
            case C0268R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                return '\r';
            case 't':
                return '\t';
            case 'u':
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.d >= this.e && !m692p()) {
                        m510c(" in character escape sequence");
                    }
                    char[] cArr2 = this.f512M;
                    int i4 = this.d;
                    this.d = i4 + 1;
                    char c2 = cArr2[i4];
                    i4 = CharTypes.m554a(c2);
                    if (i4 < 0) {
                        m507b((int) c2, "expected a hex-digit for character escape sequence");
                    }
                    i = (i << 4) | i4;
                }
                return (char) i;
            default:
                return m501a(c);
        }
    }

    protected void m684a(String str, int i) {
        int length = str.length();
        do {
            if (this.d >= this.e && !m692p()) {
                m499D();
            }
            if (this.f512M[this.d] != str.charAt(i)) {
                m685a(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            this.d++;
            i++;
        } while (i < length);
        if (this.d < this.e || m692p()) {
            char c = this.f512M[this.d];
            if (c >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
                m685a(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
        }
    }

    protected void m685a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (true) {
            if (this.d >= this.e && !m692p()) {
                break;
            }
            char c = this.f512M[this.d];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this.d++;
            stringBuilder.append(c);
        }
        m511d("Unrecognized token '" + stringBuilder.toString() + "': was expecting ");
    }
}
