package com.p013a.p014a.p015a.p020e;

import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.p017b.NumberInput;
import com.p013a.p014a.p015a.p020e.BufferRecycler.BufferRecycler;
import java.math.BigDecimal;
import java.util.ArrayList;

/* renamed from: com.a.a.a.e.e */
public final class TextBuffer {
    static final char[] f643a;
    private final BufferRecycler f644b;
    private char[] f645c;
    private int f646d;
    private int f647e;
    private ArrayList<char[]> f648f;
    private boolean f649g;
    private int f650h;
    private char[] f651i;
    private int f652j;
    private String f653k;
    private char[] f654l;

    static {
        f643a = new char[0];
    }

    public TextBuffer(BufferRecycler bufferRecycler) {
        this.f649g = false;
        this.f644b = bufferRecycler;
    }

    public void m957a() {
        if (this.f644b == null) {
            m961b();
        } else if (this.f651i != null) {
            m961b();
            char[] cArr = this.f651i;
            this.f651i = null;
            this.f644b.m913a(BufferRecycler.TEXT_BUFFER, cArr);
        }
    }

    public void m961b() {
        this.f646d = -1;
        this.f652j = 0;
        this.f647e = 0;
        this.f645c = null;
        this.f653k = null;
        this.f654l = null;
        if (this.f649g) {
            m955o();
        }
    }

    public void m960a(char[] cArr, int i, int i2) {
        this.f653k = null;
        this.f654l = null;
        this.f645c = cArr;
        this.f646d = i;
        this.f647e = i2;
        if (this.f649g) {
            m955o();
        }
    }

    public void m962b(char[] cArr, int i, int i2) {
        this.f645c = null;
        this.f646d = -1;
        this.f647e = 0;
        this.f653k = null;
        this.f654l = null;
        if (this.f649g) {
            m955o();
        } else if (this.f651i == null) {
            this.f651i = m951b(i2);
        }
        this.f650h = 0;
        this.f652j = 0;
        m964c(cArr, i, i2);
    }

    public void m959a(String str) {
        this.f645c = null;
        this.f646d = -1;
        this.f647e = 0;
        this.f653k = str;
        this.f654l = null;
        if (this.f649g) {
            m955o();
        }
        this.f652j = 0;
    }

    private char[] m951b(int i) {
        if (this.f644b != null) {
            return this.f644b.m916a(BufferRecycler.TEXT_BUFFER, i);
        }
        return new char[Math.max(i, PointerIconCompat.TYPE_DEFAULT)];
    }

    private void m955o() {
        this.f649g = false;
        this.f648f.clear();
        this.f650h = 0;
        this.f652j = 0;
    }

    public int m963c() {
        if (this.f646d >= 0) {
            return this.f647e;
        }
        if (this.f654l != null) {
            return this.f654l.length;
        }
        if (this.f653k != null) {
            return this.f653k.length();
        }
        return this.f650h + this.f652j;
    }

    public int m965d() {
        return this.f646d >= 0 ? this.f646d : 0;
    }

    public char[] m966e() {
        if (this.f646d >= 0) {
            return this.f645c;
        }
        if (this.f654l != null) {
            return this.f654l;
        }
        if (this.f653k != null) {
            char[] toCharArray = this.f653k.toCharArray();
            this.f654l = toCharArray;
            return toCharArray;
        } else if (this.f649g) {
            return m968g();
        } else {
            return this.f651i;
        }
    }

    public String m967f() {
        if (this.f653k == null) {
            if (this.f654l != null) {
                this.f653k = new String(this.f654l);
            } else if (this.f646d < 0) {
                int i = this.f650h;
                int i2 = this.f652j;
                if (i == 0) {
                    this.f653k = i2 == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING : new String(this.f651i, 0, i2);
                } else {
                    StringBuilder stringBuilder = new StringBuilder(i + i2);
                    if (this.f648f != null) {
                        int size = this.f648f.size();
                        for (i2 = 0; i2 < size; i2++) {
                            char[] cArr = (char[]) this.f648f.get(i2);
                            stringBuilder.append(cArr, 0, cArr.length);
                        }
                    }
                    stringBuilder.append(this.f651i, 0, this.f652j);
                    this.f653k = stringBuilder.toString();
                }
            } else if (this.f647e < 1) {
                String str = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
                this.f653k = str;
                return str;
            } else {
                this.f653k = new String(this.f645c, this.f646d, this.f647e);
            }
        }
        return this.f653k;
    }

    public char[] m968g() {
        char[] cArr = this.f654l;
        if (cArr != null) {
            return cArr;
        }
        cArr = m956p();
        this.f654l = cArr;
        return cArr;
    }

    public BigDecimal m969h() {
        if (this.f654l != null) {
            return new BigDecimal(this.f654l);
        }
        if (this.f646d >= 0) {
            return new BigDecimal(this.f645c, this.f646d, this.f647e);
        }
        if (this.f650h == 0) {
            return new BigDecimal(this.f651i, 0, this.f652j);
        }
        return new BigDecimal(m968g());
    }

    public double m970i() {
        return NumberInput.m587a(m967f());
    }

    public void m964c(char[] cArr, int i, int i2) {
        if (this.f646d >= 0) {
            m952c(i2);
        }
        this.f653k = null;
        this.f654l = null;
        Object obj = this.f651i;
        int length = obj.length - this.f652j;
        if (length >= i2) {
            System.arraycopy(cArr, i, obj, this.f652j, i2);
            this.f652j += i2;
            return;
        }
        if (length > 0) {
            System.arraycopy(cArr, i, obj, this.f652j, length);
            i += length;
            i2 -= length;
        }
        do {
            m953d(i2);
            int min = Math.min(this.f651i.length, i2);
            System.arraycopy(cArr, i, this.f651i, 0, min);
            this.f652j += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public char[] m971j() {
        if (this.f646d >= 0) {
            m952c(1);
        } else {
            char[] cArr = this.f651i;
            if (cArr == null) {
                this.f651i = m951b(0);
            } else if (this.f652j >= cArr.length) {
                m953d(1);
            }
        }
        return this.f651i;
    }

    public char[] m972k() {
        this.f646d = -1;
        this.f652j = 0;
        this.f647e = 0;
        this.f645c = null;
        this.f653k = null;
        this.f654l = null;
        if (this.f649g) {
            m955o();
        }
        char[] cArr = this.f651i;
        if (cArr != null) {
            return cArr;
        }
        cArr = m951b(0);
        this.f651i = cArr;
        return cArr;
    }

    public int m973l() {
        return this.f652j;
    }

    public void m958a(int i) {
        this.f652j = i;
    }

    public char[] m974m() {
        if (this.f648f == null) {
            this.f648f = new ArrayList();
        }
        this.f649g = true;
        this.f648f.add(this.f651i);
        int length = this.f651i.length;
        this.f650h += length;
        char[] e = m954e(Math.min(length + (length >> 1), AccessibilityNodeInfoCompat.ACTION_EXPAND));
        this.f652j = 0;
        this.f651i = e;
        return e;
    }

    public char[] m975n() {
        Object obj = this.f651i;
        int length = obj.length;
        this.f651i = m954e(length == AccessibilityNodeInfoCompat.ACTION_EXPAND ? 262145 : Math.min(AccessibilityNodeInfoCompat.ACTION_EXPAND, (length >> 1) + length));
        System.arraycopy(obj, 0, this.f651i, 0, length);
        return this.f651i;
    }

    public String toString() {
        return m967f();
    }

    private void m952c(int i) {
        int i2 = this.f647e;
        this.f647e = 0;
        Object obj = this.f645c;
        this.f645c = null;
        int i3 = this.f646d;
        this.f646d = -1;
        int i4 = i2 + i;
        if (this.f651i == null || i4 > this.f651i.length) {
            this.f651i = m951b(i4);
        }
        if (i2 > 0) {
            System.arraycopy(obj, i3, this.f651i, 0, i2);
        }
        this.f650h = 0;
        this.f652j = i2;
    }

    private void m953d(int i) {
        if (this.f648f == null) {
            this.f648f = new ArrayList();
        }
        Object obj = this.f651i;
        this.f649g = true;
        this.f648f.add(obj);
        this.f650h += obj.length;
        int length = obj.length;
        int i2 = length >> 1;
        if (i2 >= i) {
            i = i2;
        }
        char[] e = m954e(Math.min(AccessibilityNodeInfoCompat.ACTION_EXPAND, length + i));
        this.f652j = 0;
        this.f651i = e;
    }

    private char[] m956p() {
        if (this.f653k != null) {
            return this.f653k.toCharArray();
        }
        char[] cArr;
        if (this.f646d < 0) {
            int c = m963c();
            if (c < 1) {
                return f643a;
            }
            Object e = m954e(c);
            if (this.f648f != null) {
                int size = this.f648f.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    cArr = (char[]) this.f648f.get(i2);
                    int length = cArr.length;
                    System.arraycopy(cArr, 0, e, i, length);
                    i += length;
                }
                c = i;
            } else {
                c = 0;
            }
            System.arraycopy(this.f651i, 0, e, c, this.f652j);
            return e;
        } else if (this.f647e < 1) {
            return f643a;
        } else {
            cArr = m954e(this.f647e);
            System.arraycopy(this.f645c, this.f646d, cArr, 0, this.f647e);
            return cArr;
        }
    }

    private char[] m954e(int i) {
        return new char[i];
    }
}
