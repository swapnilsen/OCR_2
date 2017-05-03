package com.p013a.p014a.p015a.p016a;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.JsonLocation;
import com.p013a.p014a.p015a.JsonToken;
import com.p013a.p014a.p015a.p017b.IOContext;
import com.p013a.p014a.p015a.p017b.NumberInput;
import com.p013a.p014a.p015a.p018c.JsonReadContext;
import com.p013a.p014a.p015a.p020e.ByteArrayBuilder;
import com.p013a.p014a.p015a.p020e.TextBuffer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: com.a.a.a.a.b */
public abstract class ParserBase extends ParserMinimalBase {
    static final BigInteger f359s;
    static final BigInteger f360t;
    static final BigInteger f361u;
    static final BigInteger f362v;
    static final BigDecimal f363w;
    static final BigDecimal f364x;
    static final BigDecimal f365y;
    static final BigDecimal f366z;
    protected int f367A;
    protected int f368B;
    protected long f369C;
    protected double f370D;
    protected BigInteger f371E;
    protected BigDecimal f372F;
    protected boolean f373G;
    protected int f374H;
    protected int f375I;
    protected int f376J;
    protected final IOContext f377b;
    protected boolean f378c;
    protected int f379d;
    protected int f380e;
    protected long f381f;
    protected int f382g;
    protected int f383h;
    protected long f384i;
    protected int f385j;
    protected int f386k;
    protected JsonReadContext f387l;
    protected JsonToken f388m;
    protected final TextBuffer f389n;
    protected char[] f390o;
    protected boolean f391p;
    protected ByteArrayBuilder f392q;
    protected byte[] f393r;

    protected abstract boolean m535p();

    protected abstract void m536q();

    protected abstract void m537r();

    static {
        f359s = BigInteger.valueOf(-2147483648L);
        f360t = BigInteger.valueOf(2147483647L);
        f361u = BigInteger.valueOf(Long.MIN_VALUE);
        f362v = BigInteger.valueOf(Long.MAX_VALUE);
        f363w = new BigDecimal(f361u);
        f364x = new BigDecimal(f362v);
        f365y = new BigDecimal(f359s);
        f366z = new BigDecimal(f360t);
    }

    protected ParserBase(IOContext iOContext, int i) {
        this.f379d = 0;
        this.f380e = 0;
        this.f381f = 0;
        this.f382g = 1;
        this.f383h = 0;
        this.f384i = 0;
        this.f385j = 1;
        this.f386k = 0;
        this.f390o = null;
        this.f391p = false;
        this.f392q = null;
        this.f367A = 0;
        this.a = i;
        this.f377b = iOContext;
        this.f389n = iOContext.m575d();
        this.f387l = JsonReadContext.m647g();
    }

    public String m526d() {
        if (this.K == JsonToken.START_OBJECT || this.K == JsonToken.START_ARRAY) {
            return this.f387l.m654i().m653h();
        }
        return this.f387l.m653h();
    }

    public void close() {
        if (!this.f378c) {
            this.f378c = true;
            try {
                m537r();
            } finally {
                m538s();
            }
        }
    }

    public JsonLocation m527e() {
        return new JsonLocation(this.f377b.m566a(), (this.f381f + ((long) this.f379d)) - 1, this.f382g, (this.f379d - this.f383h) + 1);
    }

    protected final void m534o() {
        if (!m535p()) {
            m498C();
        }
    }

    protected void m538s() {
        this.f389n.m957a();
        char[] cArr = this.f390o;
        if (cArr != null) {
            this.f390o = null;
            this.f377b.m573c(cArr);
        }
    }

    protected void m539t() {
        if (!this.f387l.m642b()) {
            m510c(": expected close marker for " + this.f387l.m644d() + " (from " + this.f387l.m649a(this.f377b.m566a()) + ")");
        }
    }

    protected void m522a(int i, char c) {
        m511d("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this.f387l.m644d() + " starting at " + (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING + this.f387l.m649a(this.f377b.m566a())) + ")");
    }

    protected final JsonToken m520a(boolean z, int i, int i2, int i3) {
        if (i2 >= 1 || i3 >= 1) {
            return m524b(z, i, i2, i3);
        }
        return m519a(z, i);
    }

    protected final JsonToken m519a(boolean z, int i) {
        this.f373G = z;
        this.f374H = i;
        this.f375I = 0;
        this.f376J = 0;
        this.f367A = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    protected final JsonToken m524b(boolean z, int i, int i2, int i3) {
        this.f373G = z;
        this.f374H = i;
        this.f375I = i2;
        this.f376J = i3;
        this.f367A = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    protected final JsonToken m518a(String str, double d) {
        this.f389n.m959a(str);
        this.f370D = d;
        this.f367A = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public int m528i() {
        if ((this.f367A & 1) == 0) {
            if (this.f367A == 0) {
                m521a(1);
            }
            if ((this.f367A & 1) == 0) {
                m540u();
            }
        }
        return this.f368B;
    }

    public long m529j() {
        if ((this.f367A & 2) == 0) {
            if (this.f367A == 0) {
                m521a(2);
            }
            if ((this.f367A & 2) == 0) {
                m541v();
            }
        }
        return this.f369C;
    }

    public BigInteger m530k() {
        if ((this.f367A & 4) == 0) {
            if (this.f367A == 0) {
                m521a(4);
            }
            if ((this.f367A & 4) == 0) {
                m542w();
            }
        }
        return this.f371E;
    }

    public float m531l() {
        return (float) m532m();
    }

    public double m532m() {
        if ((this.f367A & 8) == 0) {
            if (this.f367A == 0) {
                m521a(8);
            }
            if ((this.f367A & 8) == 0) {
                m543x();
            }
        }
        return this.f370D;
    }

    public BigDecimal m533n() {
        if ((this.f367A & 16) == 0) {
            if (this.f367A == 0) {
                m521a(16);
            }
            if ((this.f367A & 16) == 0) {
                m544y();
            }
        }
        return this.f372F;
    }

    protected void m521a(int i) {
        if (this.K == JsonToken.VALUE_NUMBER_INT) {
            char[] e = this.f389n.m966e();
            int d = this.f389n.m965d();
            int i2 = this.f374H;
            if (this.f373G) {
                d++;
            }
            if (i2 <= 9) {
                d = NumberInput.m588a(e, d, i2);
                if (this.f373G) {
                    d = -d;
                }
                this.f368B = d;
                this.f367A = 1;
            } else if (i2 <= 18) {
                long b = NumberInput.m590b(e, d, i2);
                if (this.f373G) {
                    b = -b;
                }
                if (i2 == 10) {
                    if (this.f373G) {
                        if (b >= -2147483648L) {
                            this.f368B = (int) b;
                            this.f367A = 1;
                            return;
                        }
                    } else if (b <= 2147483647L) {
                        this.f368B = (int) b;
                        this.f367A = 1;
                        return;
                    }
                }
                this.f369C = b;
                this.f367A = 2;
            } else {
                m514a(i, e, d, i2);
            }
        } else if (this.K == JsonToken.VALUE_NUMBER_FLOAT) {
            m515d(i);
        } else {
            m511d("Current token (" + this.K + ") not numeric, can not use numeric value accessors");
        }
    }

    private void m515d(int i) {
        if (i == 16) {
            try {
                this.f372F = this.f389n.m969h();
                this.f367A = 16;
                return;
            } catch (Throwable e) {
                m503a("Malformed numeric value '" + this.f389n.m967f() + "'", e);
                return;
            }
        }
        this.f370D = this.f389n.m970i();
        this.f367A = 8;
    }

    private void m514a(int i, char[] cArr, int i2, int i3) {
        String f = this.f389n.m967f();
        try {
            if (NumberInput.m589a(cArr, i2, i3, this.f373G)) {
                this.f369C = Long.parseLong(f);
                this.f367A = 2;
                return;
            }
            this.f371E = new BigInteger(f);
            this.f367A = 4;
        } catch (Throwable e) {
            m503a("Malformed numeric value '" + f + "'", e);
        }
    }

    protected void m540u() {
        if ((this.f367A & 2) != 0) {
            int i = (int) this.f369C;
            if (((long) i) != this.f369C) {
                m511d("Numeric value (" + m512f() + ") out of range of int");
            }
            this.f368B = i;
        } else if ((this.f367A & 4) != 0) {
            if (f359s.compareTo(this.f371E) > 0 || f360t.compareTo(this.f371E) < 0) {
                m545z();
            }
            this.f368B = this.f371E.intValue();
        } else if ((this.f367A & 8) != 0) {
            if (this.f370D < -2.147483648E9d || this.f370D > 2.147483647E9d) {
                m545z();
            }
            this.f368B = (int) this.f370D;
        } else if ((this.f367A & 16) != 0) {
            if (f365y.compareTo(this.f372F) > 0 || f366z.compareTo(this.f372F) < 0) {
                m545z();
            }
            this.f368B = this.f372F.intValue();
        } else {
            m500E();
        }
        this.f367A |= 1;
    }

    protected void m541v() {
        if ((this.f367A & 1) != 0) {
            this.f369C = (long) this.f368B;
        } else if ((this.f367A & 4) != 0) {
            if (f361u.compareTo(this.f371E) > 0 || f362v.compareTo(this.f371E) < 0) {
                m516A();
            }
            this.f369C = this.f371E.longValue();
        } else if ((this.f367A & 8) != 0) {
            if (this.f370D < -9.223372036854776E18d || this.f370D > 9.223372036854776E18d) {
                m516A();
            }
            this.f369C = (long) this.f370D;
        } else if ((this.f367A & 16) != 0) {
            if (f363w.compareTo(this.f372F) > 0 || f364x.compareTo(this.f372F) < 0) {
                m516A();
            }
            this.f369C = this.f372F.longValue();
        } else {
            m500E();
        }
        this.f367A |= 2;
    }

    protected void m542w() {
        if ((this.f367A & 16) != 0) {
            this.f371E = this.f372F.toBigInteger();
        } else if ((this.f367A & 2) != 0) {
            this.f371E = BigInteger.valueOf(this.f369C);
        } else if ((this.f367A & 1) != 0) {
            this.f371E = BigInteger.valueOf((long) this.f368B);
        } else if ((this.f367A & 8) != 0) {
            this.f371E = BigDecimal.valueOf(this.f370D).toBigInteger();
        } else {
            m500E();
        }
        this.f367A |= 4;
    }

    protected void m543x() {
        if ((this.f367A & 16) != 0) {
            this.f370D = this.f372F.doubleValue();
        } else if ((this.f367A & 4) != 0) {
            this.f370D = this.f371E.doubleValue();
        } else if ((this.f367A & 2) != 0) {
            this.f370D = (double) this.f369C;
        } else if ((this.f367A & 1) != 0) {
            this.f370D = (double) this.f368B;
        } else {
            m500E();
        }
        this.f367A |= 8;
    }

    protected void m544y() {
        if ((this.f367A & 8) != 0) {
            this.f372F = new BigDecimal(m512f());
        } else if ((this.f367A & 4) != 0) {
            this.f372F = new BigDecimal(this.f371E);
        } else if ((this.f367A & 2) != 0) {
            this.f372F = BigDecimal.valueOf(this.f369C);
        } else if ((this.f367A & 1) != 0) {
            this.f372F = BigDecimal.valueOf((long) this.f368B);
        } else {
            m500E();
        }
        this.f367A |= 16;
    }

    protected void m523a(int i, String str) {
        String str2 = "Unexpected character (" + ParserMinimalBase.m497c(i) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        m511d(str2);
    }

    protected void m525b(String str) {
        m511d("Invalid numeric value: " + str);
    }

    protected void m545z() {
        m511d("Numeric value (" + m512f() + ") out of range of int (" + RtlSpacingHelper.UNDEFINED + " - " + ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED + ")");
    }

    protected void m516A() {
        m511d("Numeric value (" + m512f() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
    }

    protected char m517B() {
        throw new UnsupportedOperationException();
    }
}
