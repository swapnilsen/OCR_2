package com.p013a.p014a.p015a.p017b;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* renamed from: com.a.a.a.b.m */
public final class UTF8Writer extends Writer {
    protected final IOContext f463a;
    OutputStream f464b;
    byte[] f465c;
    final int f466d;
    int f467e;
    int f468f;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this.f468f = 0;
        this.f463a = iOContext;
        this.f464b = outputStream;
        this.f465c = iOContext.m577f();
        this.f466d = this.f465c.length - 4;
        this.f467e = 0;
    }

    public Writer append(char c) {
        write((int) c);
        return this;
    }

    public void close() {
        if (this.f464b != null) {
            if (this.f467e > 0) {
                this.f464b.write(this.f465c, 0, this.f467e);
                this.f467e = 0;
            }
            OutputStream outputStream = this.f464b;
            this.f464b = null;
            byte[] bArr = this.f465c;
            if (bArr != null) {
                this.f465c = null;
                this.f463a.m571b(bArr);
            }
            outputStream.close();
            int i = this.f468f;
            this.f468f = 0;
            if (i > 0) {
                m610b(i);
            }
        }
    }

    public void flush() {
        if (this.f464b != null) {
            if (this.f467e > 0) {
                this.f464b.write(this.f465c, 0, this.f467e);
                this.f467e = 0;
            }
            this.f464b.flush();
        }
    }

    public void write(char[] cArr) {
        write(cArr, 0, cArr.length);
    }

    public void write(char[] cArr, int i, int i2) {
        if (i2 >= 2) {
            int i3;
            if (this.f468f > 0) {
                i3 = i + 1;
                i2--;
                write(m609a(cArr[i]));
                i = i3;
            }
            i3 = this.f467e;
            byte[] bArr = this.f465c;
            int i4 = this.f466d;
            int i5 = i2 + i;
            int i6 = i;
            while (i6 < i5) {
                int i7;
                int i8;
                if (i3 >= i4) {
                    this.f464b.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i9 = i6 + 1;
                char c = cArr[i6];
                char c2;
                if (c < '\u0080') {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) c;
                    i6 = i5 - i9;
                    i3 = i4 - i7;
                    if (i6 <= i3) {
                        i3 = i6;
                    }
                    i8 = i3 + i9;
                    i6 = i7;
                    i3 = i9;
                    while (i3 < i8) {
                        i9 = i3 + 1;
                        char c3 = cArr[i3];
                        if (c3 >= '\u0080') {
                            c2 = c3;
                            i3 = i6;
                            i6 = i9;
                            i9 = c2;
                        } else {
                            i7 = i6 + 1;
                            bArr[i6] = (byte) c3;
                            i6 = i7;
                            i3 = i9;
                        }
                    }
                    int i10 = i6;
                    i6 = i3;
                    i3 = i10;
                } else {
                    c2 = c;
                    i6 = i9;
                    char c4 = c2;
                }
                if (i9 < ItemAnimator.FLAG_MOVED) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 6) | 192);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i9 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                } else if (i9 < 55296 || i9 > 57343) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 12) | 224);
                    i8 = i7 + 1;
                    bArr[i7] = (byte) (((i9 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i3 = i8 + 1;
                    bArr[i8] = (byte) ((i9 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                } else {
                    if (i9 > 56319) {
                        this.f467e = i3;
                        m610b(i9);
                    }
                    this.f468f = i9;
                    if (i6 >= i5) {
                        break;
                    }
                    i9 = i6 + 1;
                    i6 = m609a(cArr[i6]);
                    if (i6 > 1114111) {
                        this.f467e = i3;
                        m610b(i6);
                    }
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i6 >> 18) | 240);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) (((i6 >> 12) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i7 = i3 + 1;
                    bArr[i3] = (byte) (((i6 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i6 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i6 = i9;
                }
            }
            this.f467e = i3;
        } else if (i2 == 1) {
            write(cArr[i]);
        }
    }

    public void write(int i) {
        if (this.f468f > 0) {
            i = m609a(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                m610b(i);
            }
            this.f468f = i;
            return;
        }
        if (this.f467e >= this.f466d) {
            this.f464b.write(this.f465c, 0, this.f467e);
            this.f467e = 0;
        }
        if (i < AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            byte[] bArr = this.f465c;
            int i2 = this.f467e;
            this.f467e = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        int i3 = this.f467e;
        int i4;
        if (i < ItemAnimator.FLAG_MOVED) {
            i4 = i3 + 1;
            this.f465c[i3] = (byte) ((i >> 6) | 192);
            i3 = i4 + 1;
            this.f465c[i4] = (byte) ((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else if (i <= SupportMenu.USER_MASK) {
            i4 = i3 + 1;
            this.f465c[i3] = (byte) ((i >> 12) | 224);
            i2 = i4 + 1;
            this.f465c[i4] = (byte) (((i >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            i3 = i2 + 1;
            this.f465c[i2] = (byte) ((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            if (i > 1114111) {
                m610b(i);
            }
            i4 = i3 + 1;
            this.f465c[i3] = (byte) ((i >> 18) | 240);
            i2 = i4 + 1;
            this.f465c[i4] = (byte) (((i >> 12) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            i4 = i2 + 1;
            this.f465c[i2] = (byte) (((i >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            i3 = i4 + 1;
            this.f465c[i4] = (byte) ((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        }
        this.f467e = i3;
    }

    public void write(String str) {
        write(str, 0, str.length());
    }

    public void write(String str, int i, int i2) {
        if (i2 >= 2) {
            int i3;
            if (this.f468f > 0) {
                i3 = i + 1;
                i2--;
                write(m609a(str.charAt(i)));
                i = i3;
            }
            i3 = this.f467e;
            byte[] bArr = this.f465c;
            int i4 = this.f466d;
            int i5 = i2 + i;
            int i6 = i;
            while (i6 < i5) {
                int i7;
                int i8;
                if (i3 >= i4) {
                    this.f464b.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i9 = i6 + 1;
                char charAt = str.charAt(i6);
                char c;
                if (charAt < '\u0080') {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    i6 = i5 - i9;
                    i3 = i4 - i7;
                    if (i6 <= i3) {
                        i3 = i6;
                    }
                    i8 = i3 + i9;
                    i6 = i7;
                    i3 = i9;
                    while (i3 < i8) {
                        i9 = i3 + 1;
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '\u0080') {
                            c = charAt2;
                            i3 = i6;
                            i6 = i9;
                            i9 = c;
                        } else {
                            i7 = i6 + 1;
                            bArr[i6] = (byte) charAt2;
                            i6 = i7;
                            i3 = i9;
                        }
                    }
                    int i10 = i6;
                    i6 = i3;
                    i3 = i10;
                } else {
                    c = charAt;
                    i6 = i9;
                    char c2 = c;
                }
                if (i9 < ItemAnimator.FLAG_MOVED) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 6) | 192);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i9 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                } else if (i9 < 55296 || i9 > 57343) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 12) | 224);
                    i8 = i7 + 1;
                    bArr[i7] = (byte) (((i9 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i3 = i8 + 1;
                    bArr[i8] = (byte) ((i9 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                } else {
                    if (i9 > 56319) {
                        this.f467e = i3;
                        m610b(i9);
                    }
                    this.f468f = i9;
                    if (i6 >= i5) {
                        break;
                    }
                    i9 = i6 + 1;
                    i6 = m609a(str.charAt(i6));
                    if (i6 > 1114111) {
                        this.f467e = i3;
                        m610b(i6);
                    }
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i6 >> 18) | 240);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) (((i6 >> 12) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i7 = i3 + 1;
                    bArr[i3] = (byte) (((i6 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i6 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i6 = i9;
                }
            }
            this.f467e = i3;
        } else if (i2 == 1) {
            write(str.charAt(i));
        }
    }

    private int m609a(int i) {
        int i2 = this.f468f;
        this.f468f = 0;
        if (i >= 56320 && i <= 57343) {
            return (((i2 - 55296) << 10) + AccessibilityNodeInfoCompat.ACTION_CUT) + (i - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    private void m610b(int i) {
        if (i > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        } else if (i < 55296) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        } else if (i <= 56319) {
            throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        } else {
            throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
    }
}
