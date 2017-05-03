package com.p013a.p014a.p015a.p017b;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.CharConversionException;
import java.io.InputStream;

/* renamed from: com.a.a.a.b.l */
public class UTF32Reader extends BaseReader {
    protected final boolean f458g;
    protected char f459h;
    protected int f460i;
    protected int f461j;
    protected final boolean f462k;

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public /* bridge */ /* synthetic */ int read() {
        return super.read();
    }

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        boolean z2 = false;
        super(iOContext, inputStream, bArr, i, i2);
        this.f459h = '\u0000';
        this.f460i = 0;
        this.f461j = 0;
        this.f458g = z;
        if (inputStream != null) {
            z2 = true;
        }
        this.f462k = z2;
    }

    public int read(char[] cArr, int i, int i2) {
        if (this.c == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        int i3;
        int i4;
        if (i < 0 || i + i2 > cArr.length) {
            m552a(cArr, i, i2);
        }
        int i5 = i2 + i;
        if (this.f459h != '\u0000') {
            i3 = i + 1;
            cArr[i] = this.f459h;
            this.f459h = '\u0000';
        } else {
            i4 = this.e - this.d;
            if (i4 < 4 && !m608a(i4)) {
                return -1;
            }
            i3 = i;
        }
        while (i3 < i5) {
            int i6 = this.d;
            if (this.f458g) {
                i6 = (this.c[i6 + 3] & MotionEventCompat.ACTION_MASK) | (((this.c[i6] << 24) | ((this.c[i6 + 1] & MotionEventCompat.ACTION_MASK) << 16)) | ((this.c[i6 + 2] & MotionEventCompat.ACTION_MASK) << 8));
            } else {
                i6 = (this.c[i6 + 3] << 24) | (((this.c[i6] & MotionEventCompat.ACTION_MASK) | ((this.c[i6 + 1] & MotionEventCompat.ACTION_MASK) << 8)) | ((this.c[i6 + 2] & MotionEventCompat.ACTION_MASK) << 16));
            }
            this.d += 4;
            if (i6 > SupportMenu.USER_MASK) {
                if (i6 > 1114111) {
                    m607a(i6, i3 - i, "(above " + Integer.toHexString(1114111) + ") ");
                }
                i6 -= AccessibilityNodeInfoCompat.ACTION_CUT;
                i4 = i3 + 1;
                cArr[i3] = (char) (55296 + (i6 >> 10));
                i6 = (i6 & 1023) | 56320;
                if (i4 >= i5) {
                    this.f459h = (char) i6;
                    break;
                }
            }
            i4 = i3;
            i3 = i4 + 1;
            cArr[i4] = (char) i6;
            if (this.d >= this.e) {
                i4 = i3;
                break;
            }
        }
        i4 = i3;
        i2 = i4 - i;
        this.f460i += i2;
        return i2;
    }

    private void m606a(int i, int i2) {
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.f460i + ", byte #" + (this.f461j + i) + ")");
    }

    private void m607a(int i, int i2, String str) {
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.f460i + i2) + ", byte #" + ((this.f461j + this.d) - 1) + ")");
    }

    private boolean m608a(int i) {
        this.f461j += this.e - i;
        int i2;
        if (i > 0) {
            if (this.d > 0) {
                for (i2 = 0; i2 < i; i2++) {
                    this.c[i2] = this.c[this.d + i2];
                }
                this.d = 0;
            }
            this.e = i;
        } else {
            this.d = 0;
            i2 = this.b == null ? -1 : this.b.read(this.c);
            if (i2 < 1) {
                this.e = 0;
                if (i2 >= 0) {
                    m553b();
                } else if (!this.f462k) {
                    return false;
                } else {
                    m551a();
                    return false;
                }
            }
            this.e = i2;
        }
        while (this.e < 4) {
            int i3;
            if (this.b == null) {
                i3 = -1;
            } else {
                i3 = this.b.read(this.c, this.e, this.c.length - this.e);
            }
            if (i3 < 1) {
                if (i3 < 0) {
                    if (this.f462k) {
                        m551a();
                    }
                    m606a(this.e, 4);
                }
                m553b();
            }
            this.e = i3 + this.e;
        }
        return true;
    }
}
