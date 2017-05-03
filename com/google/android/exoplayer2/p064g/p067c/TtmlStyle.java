package com.google.android.exoplayer2.p064g.p067c;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p050j.Assertions;

/* renamed from: com.google.android.exoplayer2.g.c.e */
final class TtmlStyle {
    private String f3476a;
    private int f3477b;
    private boolean f3478c;
    private int f3479d;
    private boolean f3480e;
    private int f3481f;
    private int f3482g;
    private int f3483h;
    private int f3484i;
    private int f3485j;
    private float f3486k;
    private String f3487l;
    private TtmlStyle f3488m;
    private Alignment f3489n;

    public TtmlStyle() {
        this.f3481f = -1;
        this.f3482g = -1;
        this.f3483h = -1;
        this.f3484i = -1;
        this.f3485j = -1;
    }

    public int m4068a() {
        int i = 0;
        if (this.f3483h == -1 && this.f3484i == -1) {
            return -1;
        }
        int i2 = this.f3483h == 1 ? 1 : 0;
        if (this.f3484i == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public boolean m4078b() {
        return this.f3481f == 1;
    }

    public TtmlStyle m4074a(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f3488m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.m4406b(z2);
        if (!z) {
            i = 0;
        }
        this.f3481f = i;
        return this;
    }

    public boolean m4081c() {
        return this.f3482g == 1;
    }

    public TtmlStyle m4077b(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f3488m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.m4406b(z2);
        if (!z) {
            i = 0;
        }
        this.f3482g = i;
        return this;
    }

    public TtmlStyle m4080c(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f3488m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.m4406b(z2);
        if (!z) {
            i = 0;
        }
        this.f3483h = i;
        return this;
    }

    public TtmlStyle m4082d(boolean z) {
        boolean z2;
        int i = 1;
        if (this.f3488m == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.m4406b(z2);
        if (!z) {
            i = 0;
        }
        this.f3484i = i;
        return this;
    }

    public String m4083d() {
        return this.f3476a;
    }

    public TtmlStyle m4073a(String str) {
        Assertions.m4406b(this.f3488m == null);
        this.f3476a = str;
        return this;
    }

    public int m4084e() {
        if (this.f3478c) {
            return this.f3477b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public TtmlStyle m4070a(int i) {
        Assertions.m4406b(this.f3488m == null);
        this.f3477b = i;
        this.f3478c = true;
        return this;
    }

    public boolean m4085f() {
        return this.f3478c;
    }

    public int m4086g() {
        if (this.f3480e) {
            return this.f3479d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public TtmlStyle m4075b(int i) {
        this.f3479d = i;
        this.f3480e = true;
        return this;
    }

    public boolean m4087h() {
        return this.f3480e;
    }

    public TtmlStyle m4072a(TtmlStyle ttmlStyle) {
        return m4067a(ttmlStyle, true);
    }

    private TtmlStyle m4067a(TtmlStyle ttmlStyle, boolean z) {
        if (ttmlStyle != null) {
            if (!this.f3478c && ttmlStyle.f3478c) {
                m4070a(ttmlStyle.f3477b);
            }
            if (this.f3483h == -1) {
                this.f3483h = ttmlStyle.f3483h;
            }
            if (this.f3484i == -1) {
                this.f3484i = ttmlStyle.f3484i;
            }
            if (this.f3476a == null) {
                this.f3476a = ttmlStyle.f3476a;
            }
            if (this.f3481f == -1) {
                this.f3481f = ttmlStyle.f3481f;
            }
            if (this.f3482g == -1) {
                this.f3482g = ttmlStyle.f3482g;
            }
            if (this.f3489n == null) {
                this.f3489n = ttmlStyle.f3489n;
            }
            if (this.f3485j == -1) {
                this.f3485j = ttmlStyle.f3485j;
                this.f3486k = ttmlStyle.f3486k;
            }
            if (z && !this.f3480e && ttmlStyle.f3480e) {
                m4075b(ttmlStyle.f3479d);
            }
        }
        return this;
    }

    public TtmlStyle m4076b(String str) {
        this.f3487l = str;
        return this;
    }

    public String m4088i() {
        return this.f3487l;
    }

    public Alignment m4089j() {
        return this.f3489n;
    }

    public TtmlStyle m4071a(Alignment alignment) {
        this.f3489n = alignment;
        return this;
    }

    public TtmlStyle m4069a(float f) {
        this.f3486k = f;
        return this;
    }

    public TtmlStyle m4079c(int i) {
        this.f3485j = i;
        return this;
    }

    public int m4090k() {
        return this.f3485j;
    }

    public float m4091l() {
        return this.f3486k;
    }
}
