package com.google.api.client.p072a.p077b.p078a.p079a.p080a.p081a;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

/* renamed from: com.google.api.client.a.b.a.a.a.a.a */
public class Base64 extends BaseNCodec {
    static final byte[] f4095a;
    private static final byte[] f4096i;
    private static final byte[] f4097j;
    private static final byte[] f4098k;
    private final byte[] f4099l;
    private final byte[] f4100m;
    private final byte[] f4101n;
    private final int f4102o;
    private final int f4103p;
    private int f4104q;

    static {
        f4095a = new byte[]{(byte) 13, (byte) 10};
        f4096i = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        f4097j = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        f4098k = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) 62, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51};
    }

    public Base64() {
        this(0);
    }

    public Base64(boolean z) {
        this(76, f4095a, z);
    }

    public Base64(int i) {
        this(i, f4095a);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        int i2;
        if (bArr == null) {
            i2 = 0;
        } else {
            i2 = bArr.length;
        }
        super(3, 4, i, i2);
        this.f4100m = f4098k;
        if (bArr == null) {
            this.f4103p = 4;
            this.f4101n = null;
        } else if (m4792e(bArr)) {
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.m4804a(bArr) + "]");
        } else if (i > 0) {
            this.f4103p = bArr.length + 4;
            this.f4101n = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f4101n, 0, bArr.length);
        } else {
            this.f4103p = 4;
            this.f4101n = null;
        }
        this.f4102o = this.f4103p - 1;
        this.f4099l = z ? f4097j : f4096i;
    }

    void m4800a(byte[] bArr, int i, int i2) {
        if (!this.f) {
            int i3;
            int i4;
            if (i2 < 0) {
                this.f = true;
                if (this.h != 0 || this.c != 0) {
                    m4783a(this.f4103p);
                    i3 = this.e;
                    byte[] bArr2;
                    switch (this.h) {
                        case NendIconError.ERROR_ICONVIEW /*1*/:
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f4099l[(this.f4104q >> 2) & 63];
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f4099l[(this.f4104q << 4) & 63];
                            if (this.f4099l == f4096i) {
                                bArr2 = this.d;
                                i4 = this.e;
                                this.e = i4 + 1;
                                bArr2[i4] = (byte) 61;
                                bArr2 = this.d;
                                i4 = this.e;
                                this.e = i4 + 1;
                                bArr2[i4] = (byte) 61;
                                break;
                            }
                            break;
                        case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f4099l[(this.f4104q >> 10) & 63];
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f4099l[(this.f4104q >> 4) & 63];
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f4099l[(this.f4104q << 2) & 63];
                            if (this.f4099l == f4096i) {
                                bArr2 = this.d;
                                i4 = this.e;
                                this.e = i4 + 1;
                                bArr2[i4] = (byte) 61;
                                break;
                            }
                            break;
                    }
                    this.g = (this.e - i3) + this.g;
                    if (this.c > 0 && this.g > 0) {
                        System.arraycopy(this.f4101n, 0, this.d, this.e, this.f4101n.length);
                        this.e += this.f4101n.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i5 = 0;
            while (i5 < i2) {
                m4783a(this.f4103p);
                this.h = (this.h + 1) % 3;
                i4 = i + 1;
                i3 = bArr[i];
                if (i3 < 0) {
                    i3 += AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                }
                this.f4104q = i3 + (this.f4104q << 8);
                if (this.h == 0) {
                    byte[] bArr3 = this.d;
                    int i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f4099l[(this.f4104q >> 18) & 63];
                    bArr3 = this.d;
                    i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f4099l[(this.f4104q >> 12) & 63];
                    bArr3 = this.d;
                    i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f4099l[(this.f4104q >> 6) & 63];
                    bArr3 = this.d;
                    i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f4099l[this.f4104q & 63];
                    this.g += 4;
                    if (this.c > 0 && this.c <= this.g) {
                        System.arraycopy(this.f4101n, 0, this.d, this.e, this.f4101n.length);
                        this.e += this.f4101n.length;
                        this.g = 0;
                    }
                }
                i5++;
                i = i4;
            }
        }
    }

    void m4802b(byte[] bArr, int i, int i2) {
        if (!this.f) {
            int i3;
            if (i2 < 0) {
                this.f = true;
            }
            int i4 = 0;
            while (i4 < i2) {
                m4783a(this.f4102o);
                i3 = i + 1;
                byte b = bArr[i];
                if (b == 61) {
                    this.f = true;
                    break;
                }
                if (b >= null && b < f4098k.length) {
                    b = f4098k[b];
                    if (b >= null) {
                        this.h = (this.h + 1) % 4;
                        this.f4104q = b + (this.f4104q << 6);
                        if (this.h == 0) {
                            byte[] bArr2 = this.d;
                            int i5 = this.e;
                            this.e = i5 + 1;
                            bArr2[i5] = (byte) ((this.f4104q >> 16) & MotionEventCompat.ACTION_MASK);
                            bArr2 = this.d;
                            i5 = this.e;
                            this.e = i5 + 1;
                            bArr2[i5] = (byte) ((this.f4104q >> 8) & MotionEventCompat.ACTION_MASK);
                            bArr2 = this.d;
                            i5 = this.e;
                            this.e = i5 + 1;
                            bArr2[i5] = (byte) (this.f4104q & MotionEventCompat.ACTION_MASK);
                        }
                    }
                }
                i4++;
                i = i3;
            }
            if (this.f && this.h != 0) {
                m4783a(this.f4102o);
                byte[] bArr3;
                switch (this.h) {
                    case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                        this.f4104q >>= 4;
                        bArr3 = this.d;
                        i3 = this.e;
                        this.e = i3 + 1;
                        bArr3[i3] = (byte) (this.f4104q & MotionEventCompat.ACTION_MASK);
                    case SendException.ERROR_TTL_EXCEEDED /*3*/:
                        this.f4104q >>= 2;
                        bArr3 = this.d;
                        i3 = this.e;
                        this.e = i3 + 1;
                        bArr3[i3] = (byte) ((this.f4104q >> 8) & MotionEventCompat.ACTION_MASK);
                        bArr3 = this.d;
                        i3 = this.e;
                        this.e = i3 + 1;
                        bArr3[i3] = (byte) (this.f4104q & MotionEventCompat.ACTION_MASK);
                    default:
                }
            }
        }
    }

    public static String m4794a(byte[] bArr) {
        return StringUtils.m4804a(Base64.m4796a(bArr, false));
    }

    public static String m4799b(byte[] bArr) {
        return StringUtils.m4804a(Base64.m4797a(bArr, false, true));
    }

    public static byte[] m4796a(byte[] bArr, boolean z) {
        return Base64.m4797a(bArr, z, false);
    }

    public static byte[] m4797a(byte[] bArr, boolean z, boolean z2) {
        return Base64.m4798a(bArr, z, z2, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static byte[] m4798a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, f4095a, z2);
        long f = base64.m4793f(bArr);
        if (f <= ((long) i)) {
            return base64.m4791d(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + f + ") than the specified maximum size of " + i);
    }

    public static byte[] m4795a(String str) {
        return new Base64().m4788b(str);
    }

    protected boolean m4801a(byte b) {
        return b >= null && b < this.f4100m.length && this.f4100m[b] != -1;
    }
}
