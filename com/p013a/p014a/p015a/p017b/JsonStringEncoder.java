package com.p013a.p014a.p015a.p017b;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.p013a.p014a.p015a.p020e.ByteArrayBuilder;
import java.lang.ref.SoftReference;

/* renamed from: com.a.a.a.b.f */
public final class JsonStringEncoder {
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> f432a;
    private static final char[] f433d;
    private static final byte[] f434e;
    protected ByteArrayBuilder f435b;
    protected final char[] f436c;

    static {
        f433d = CharTypes.m562g();
        f434e = CharTypes.m563h();
        f432a = new ThreadLocal();
    }

    public JsonStringEncoder() {
        this.f436c = new char[6];
        this.f436c[0] = '\\';
        this.f436c[2] = '0';
        this.f436c[3] = '0';
    }

    public static JsonStringEncoder m583a() {
        SoftReference softReference = (SoftReference) f432a.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : (JsonStringEncoder) softReference.get();
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        jsonStringEncoder = new JsonStringEncoder();
        f432a.set(new SoftReference(jsonStringEncoder));
        return jsonStringEncoder;
    }

    public byte[] m585a(String str) {
        int i;
        ByteArrayBuilder byteArrayBuilder = this.f435b;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder(null);
            this.f435b = byteArrayBuilder;
        }
        int length = str.length();
        byte[] c = byteArrayBuilder.m922c();
        int length2 = c.length;
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (i3 < length) {
            int i4;
            int i5 = i3 + 1;
            i3 = str.charAt(i3);
            int i6 = length2;
            byte[] bArr = c;
            int i7 = i2;
            i2 = i6;
            while (i3 <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.m923d();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) i3;
                if (i5 >= length) {
                    i = i4;
                    break loop0;
                }
                i7 = i5 + 1;
                i3 = str.charAt(i5);
                i5 = i7;
                i7 = i4;
            }
            if (i7 >= i2) {
                bArr = byteArrayBuilder.m923d();
                i2 = bArr.length;
                i4 = 0;
            } else {
                i4 = i7;
            }
            if (i3 < ItemAnimator.FLAG_MOVED) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 6) | 192);
                i4 = i3;
                i3 = i5;
            } else if (i3 < 55296 || i3 > 57343) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 12) | 224);
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.m923d();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                i7 = i4;
                i4 = i3;
                i3 = i5;
            } else {
                if (i3 > 56319) {
                    m584a(i3);
                }
                if (i5 >= length) {
                    m584a(i3);
                }
                int i8 = i5 + 1;
                i3 = m582a(i3, str.charAt(i5));
                if (i3 > 1114111) {
                    m584a(i3);
                }
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 18) | 240);
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.m923d();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 12) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                if (i4 >= i2) {
                    bArr = byteArrayBuilder.m923d();
                    i2 = bArr.length;
                    i7 = 0;
                } else {
                    i7 = i4;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                i7 = i4;
                i4 = i3;
                i3 = i8;
            }
            if (i7 >= i2) {
                bArr = byteArrayBuilder.m923d();
                i2 = bArr.length;
                i7 = 0;
            }
            i5 = i7 + 1;
            bArr[i7] = (byte) ((i4 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            c = bArr;
            length2 = i2;
            i2 = i5;
        }
        i = i2;
        return this.f435b.m921b(i);
    }

    private int m582a(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return (AccessibilityNodeInfoCompat.ACTION_CUT + ((i - 55296) << 10)) + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private void m584a(int i) {
        if (i > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        } else if (i < 55296) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        } else if (i <= 56319) {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        } else {
            throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
    }
}
