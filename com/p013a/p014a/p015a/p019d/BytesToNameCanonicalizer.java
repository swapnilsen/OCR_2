package com.p013a.p014a.p015a.p019d;

import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.p013a.p014a.p015a.p020e.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import net.nend.android.NendIconError;

/* renamed from: com.a.a.a.d.a */
public final class BytesToNameCanonicalizer {
    protected final BytesToNameCanonicalizer f570a;
    protected final AtomicReference<BytesToNameCanonicalizer> f571b;
    protected final boolean f572c;
    protected int f573d;
    protected int f574e;
    protected int f575f;
    protected int[] f576g;
    protected Name[] f577h;
    protected BytesToNameCanonicalizer[] f578i;
    protected int f579j;
    protected int f580k;
    private final int f581l;
    private transient boolean f582m;
    private boolean f583n;
    private boolean f584o;
    private boolean f585p;

    /* renamed from: com.a.a.a.d.a.a */
    static final class BytesToNameCanonicalizer {
        protected final Name f559a;
        protected final BytesToNameCanonicalizer f560b;
        private final int f561c;

        BytesToNameCanonicalizer(Name name, BytesToNameCanonicalizer bytesToNameCanonicalizer) {
            this.f559a = name;
            this.f560b = bytesToNameCanonicalizer;
            this.f561c = bytesToNameCanonicalizer == null ? 1 : bytesToNameCanonicalizer.f561c + 1;
        }

        public int m843a() {
            return this.f561c;
        }

        public Name m844a(int i, int i2, int i3) {
            if (this.f559a.hashCode() == i && this.f559a.m895a(i2, i3)) {
                return this.f559a;
            }
            for (BytesToNameCanonicalizer bytesToNameCanonicalizer = this.f560b; bytesToNameCanonicalizer != null; bytesToNameCanonicalizer = bytesToNameCanonicalizer.f560b) {
                Name name = bytesToNameCanonicalizer.f559a;
                if (name.hashCode() == i && name.m895a(i2, i3)) {
                    return name;
                }
            }
            return null;
        }

        public Name m845a(int i, int[] iArr, int i2) {
            if (this.f559a.hashCode() == i && this.f559a.m896a(iArr, i2)) {
                return this.f559a;
            }
            for (BytesToNameCanonicalizer bytesToNameCanonicalizer = this.f560b; bytesToNameCanonicalizer != null; bytesToNameCanonicalizer = bytesToNameCanonicalizer.f560b) {
                Name name = bytesToNameCanonicalizer.f559a;
                if (name.hashCode() == i && name.m896a(iArr, i2)) {
                    return name;
                }
            }
            return null;
        }
    }

    /* renamed from: com.a.a.a.d.a.b */
    private static final class BytesToNameCanonicalizer {
        public final int f562a;
        public final int f563b;
        public final int[] f564c;
        public final Name[] f565d;
        public final BytesToNameCanonicalizer[] f566e;
        public final int f567f;
        public final int f568g;
        public final int f569h;

        public BytesToNameCanonicalizer(int i, int i2, int[] iArr, Name[] nameArr, BytesToNameCanonicalizer[] bytesToNameCanonicalizerArr, int i3, int i4, int i5) {
            this.f562a = i;
            this.f563b = i2;
            this.f564c = iArr;
            this.f565d = nameArr;
            this.f566e = bytesToNameCanonicalizerArr;
            this.f567f = i3;
            this.f568g = i4;
            this.f569h = i5;
        }

        public BytesToNameCanonicalizer(BytesToNameCanonicalizer bytesToNameCanonicalizer) {
            this.f562a = bytesToNameCanonicalizer.f573d;
            this.f563b = bytesToNameCanonicalizer.f575f;
            this.f564c = bytesToNameCanonicalizer.f576g;
            this.f565d = bytesToNameCanonicalizer.f577h;
            this.f566e = bytesToNameCanonicalizer.f578i;
            this.f567f = bytesToNameCanonicalizer.f579j;
            this.f568g = bytesToNameCanonicalizer.f580k;
            this.f569h = bytesToNameCanonicalizer.f574e;
        }
    }

    private BytesToNameCanonicalizer(int i, boolean z, int i2) {
        int i3 = 16;
        this.f570a = null;
        this.f581l = i2;
        this.f572c = z;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.f571b = new AtomicReference(m852e(i));
    }

    private BytesToNameCanonicalizer(BytesToNameCanonicalizer bytesToNameCanonicalizer, boolean z, int i, BytesToNameCanonicalizer bytesToNameCanonicalizer2) {
        this.f570a = bytesToNameCanonicalizer;
        this.f581l = i;
        this.f572c = z;
        this.f571b = null;
        this.f573d = bytesToNameCanonicalizer2.f562a;
        this.f575f = bytesToNameCanonicalizer2.f563b;
        this.f576g = bytesToNameCanonicalizer2.f564c;
        this.f577h = bytesToNameCanonicalizer2.f565d;
        this.f578i = bytesToNameCanonicalizer2.f566e;
        this.f579j = bytesToNameCanonicalizer2.f567f;
        this.f580k = bytesToNameCanonicalizer2.f568g;
        this.f574e = bytesToNameCanonicalizer2.f569h;
        this.f582m = false;
        this.f583n = true;
        this.f584o = true;
        this.f585p = true;
    }

    private BytesToNameCanonicalizer m852e(int i) {
        return new BytesToNameCanonicalizer(0, i - 1, new int[i], new Name[i], null, 0, 0, 0);
    }

    public static BytesToNameCanonicalizer m846a() {
        long currentTimeMillis = System.currentTimeMillis();
        return BytesToNameCanonicalizer.m847a((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static BytesToNameCanonicalizer m847a(int i) {
        return new BytesToNameCanonicalizer(64, true, i);
    }

    public BytesToNameCanonicalizer m860a(boolean z, boolean z2) {
        return new BytesToNameCanonicalizer(this, z2, this.f581l, (BytesToNameCanonicalizer) this.f571b.get());
    }

    public void m867b() {
        if (this.f570a != null && m869c()) {
            this.f570a.m850a(new BytesToNameCanonicalizer(this));
            this.f583n = true;
            this.f584o = true;
            this.f585p = true;
        }
    }

    private void m850a(BytesToNameCanonicalizer bytesToNameCanonicalizer) {
        int i = bytesToNameCanonicalizer.f562a;
        BytesToNameCanonicalizer bytesToNameCanonicalizer2 = (BytesToNameCanonicalizer) this.f571b.get();
        if (i > bytesToNameCanonicalizer2.f562a) {
            if (i > 6000 || bytesToNameCanonicalizer.f569h > 63) {
                bytesToNameCanonicalizer = m852e(64);
            }
            this.f571b.compareAndSet(bytesToNameCanonicalizer2, bytesToNameCanonicalizer);
        }
    }

    public boolean m869c() {
        return !this.f583n;
    }

    public static Name m851d() {
        return Name1.m897b();
    }

    public Name m866b(int i) {
        int c = m868c(i);
        int i2 = this.f575f & c;
        int i3 = this.f576g[i2];
        if ((((i3 >> 8) ^ c) << 8) == 0) {
            Name name = this.f577h[i2];
            if (name == null) {
                return null;
            }
            if (name.m894a(i)) {
                return name;
            }
        } else if (i3 == 0) {
            return null;
        }
        i2 = i3 & MotionEventCompat.ACTION_MASK;
        if (i2 <= 0) {
            return null;
        }
        BytesToNameCanonicalizer bytesToNameCanonicalizer = this.f578i[i2 - 1];
        if (bytesToNameCanonicalizer != null) {
            return bytesToNameCanonicalizer.m844a(c, i, 0);
        }
        return null;
    }

    public Name m861a(int i, int i2) {
        int c = i2 == 0 ? m868c(i) : m864b(i, i2);
        int i3 = this.f575f & c;
        int i4 = this.f576g[i3];
        if ((((i4 >> 8) ^ c) << 8) == 0) {
            Name name = this.f577h[i3];
            if (name == null) {
                return null;
            }
            if (name.m895a(i, i2)) {
                return name;
            }
        } else if (i4 == 0) {
            return null;
        }
        i3 = i4 & MotionEventCompat.ACTION_MASK;
        if (i3 > 0) {
            BytesToNameCanonicalizer bytesToNameCanonicalizer = this.f578i[i3 - 1];
            if (bytesToNameCanonicalizer != null) {
                return bytesToNameCanonicalizer.m844a(c, i, i2);
            }
        }
        return null;
    }

    public Name m863a(int[] iArr, int i) {
        int i2 = 0;
        if (i < 3) {
            int i3 = iArr[0];
            if (i >= 2) {
                i2 = iArr[1];
            }
            return m861a(i3, i2);
        }
        int b = m865b(iArr, i);
        i2 = this.f575f & b;
        int i4 = this.f576g[i2];
        if ((((i4 >> 8) ^ b) << 8) == 0) {
            Name name = this.f577h[i2];
            if (name == null || name.m896a(iArr, i)) {
                return name;
            }
        } else if (i4 == 0) {
            return null;
        }
        i2 = i4 & MotionEventCompat.ACTION_MASK;
        if (i2 > 0) {
            BytesToNameCanonicalizer bytesToNameCanonicalizer = this.f578i[i2 - 1];
            if (bytesToNameCanonicalizer != null) {
                return bytesToNameCanonicalizer.m845a(b, iArr, i);
            }
        }
        return null;
    }

    public Name m862a(String str, int[] iArr, int i) {
        if (this.f572c) {
            str = InternCache.f642a.m950a(str);
        }
        int c = i < 3 ? i == 1 ? m868c(iArr[0]) : m864b(iArr[0], iArr[1]) : m865b(iArr, i);
        Name a = BytesToNameCanonicalizer.m848a(c, str, iArr, i);
        m849a(c, a);
        return a;
    }

    public int m868c(int i) {
        int i2 = this.f581l ^ i;
        i2 += i2 >>> 15;
        return i2 ^ (i2 >>> 9);
    }

    public int m864b(int i, int i2) {
        int i3 = (((i >>> 15) ^ i) + (i2 * 33)) ^ this.f581l;
        return i3 + (i3 >>> 7);
    }

    public int m865b(int[] iArr, int i) {
        int i2 = 3;
        if (i < 3) {
            throw new IllegalArgumentException();
        }
        int i3 = iArr[0] ^ this.f581l;
        i3 = (((i3 + (i3 >>> 9)) * 33) + iArr[1]) * 65599;
        i3 = (i3 + (i3 >>> 15)) ^ iArr[2];
        i3 += i3 >>> 17;
        while (i2 < i) {
            i3 = (i3 * 31) ^ iArr[i2];
            i3 += i3 >>> 3;
            i3 ^= i3 << 7;
            i2++;
        }
        i2 = (i3 >>> 15) + i3;
        return i2 ^ (i2 << 9);
    }

    private void m849a(int i, Name name) {
        int i2;
        if (this.f583n) {
            m856h();
        }
        if (this.f582m) {
            m853e();
        }
        this.f573d++;
        int i3 = i & this.f575f;
        if (this.f577h[i3] == null) {
            this.f576g[i3] = i << 8;
            if (this.f584o) {
                m858j();
            }
            this.f577h[i3] = name;
        } else {
            if (this.f585p) {
                m857i();
            }
            this.f579j++;
            int i4 = this.f576g[i3];
            i2 = i4 & MotionEventCompat.ACTION_MASK;
            if (i2 == 0) {
                if (this.f580k <= 254) {
                    i2 = this.f580k;
                    this.f580k++;
                    if (i2 >= this.f578i.length) {
                        m859k();
                    }
                } else {
                    i2 = m855g();
                }
                this.f576g[i3] = (i4 & InputDeviceCompat.SOURCE_ANY) | (i2 + 1);
            } else {
                i2--;
            }
            BytesToNameCanonicalizer bytesToNameCanonicalizer = new BytesToNameCanonicalizer(name, this.f578i[i2]);
            this.f578i[i2] = bytesToNameCanonicalizer;
            this.f574e = Math.max(bytesToNameCanonicalizer.m843a(), this.f574e);
            if (this.f574e > MotionEventCompat.ACTION_MASK) {
                m870d(MotionEventCompat.ACTION_MASK);
            }
        }
        i2 = this.f576g.length;
        if (this.f573d > (i2 >> 1)) {
            i3 = i2 >> 2;
            if (this.f573d > i2 - i3) {
                this.f582m = true;
            } else if (this.f579j >= i3) {
                this.f582m = true;
            }
        }
    }

    private void m853e() {
        int i = 0;
        this.f582m = false;
        this.f584o = false;
        int length = this.f576g.length;
        int i2 = length + length;
        if (i2 > AccessibilityNodeInfoCompat.ACTION_CUT) {
            m854f();
            return;
        }
        int i3;
        this.f576g = new int[i2];
        this.f575f = i2 - 1;
        Name[] nameArr = this.f577h;
        this.f577h = new Name[i2];
        i2 = 0;
        for (i3 = 0; i3 < length; i3++) {
            Name name = nameArr[i3];
            if (name != null) {
                i2++;
                int hashCode = name.hashCode();
                int i4 = this.f575f & hashCode;
                this.f577h[i4] = name;
                this.f576g[i4] = hashCode << 8;
            }
        }
        int i5 = this.f580k;
        if (i5 == 0) {
            this.f574e = 0;
            return;
        }
        this.f579j = 0;
        this.f580k = 0;
        this.f585p = false;
        BytesToNameCanonicalizer[] bytesToNameCanonicalizerArr = this.f578i;
        this.f578i = new BytesToNameCanonicalizer[bytesToNameCanonicalizerArr.length];
        int i6 = 0;
        i3 = i2;
        while (i6 < i5) {
            i2 = i3;
            BytesToNameCanonicalizer bytesToNameCanonicalizer = bytesToNameCanonicalizerArr[i6];
            while (bytesToNameCanonicalizer != null) {
                length = i2 + 1;
                Name name2 = bytesToNameCanonicalizer.f559a;
                i2 = name2.hashCode();
                int i7 = this.f575f & i2;
                int i8 = this.f576g[i7];
                if (this.f577h[i7] == null) {
                    this.f576g[i7] = i2 << 8;
                    this.f577h[i7] = name2;
                    i2 = i;
                } else {
                    this.f579j++;
                    i2 = i8 & MotionEventCompat.ACTION_MASK;
                    if (i2 == 0) {
                        if (this.f580k <= 254) {
                            i2 = this.f580k;
                            this.f580k++;
                            if (i2 >= this.f578i.length) {
                                m859k();
                            }
                        } else {
                            i2 = m855g();
                        }
                        this.f576g[i7] = (i8 & InputDeviceCompat.SOURCE_ANY) | (i2 + 1);
                    } else {
                        i2--;
                    }
                    BytesToNameCanonicalizer bytesToNameCanonicalizer2 = new BytesToNameCanonicalizer(name2, this.f578i[i2]);
                    this.f578i[i2] = bytesToNameCanonicalizer2;
                    i2 = Math.max(i, bytesToNameCanonicalizer2.m843a());
                }
                bytesToNameCanonicalizer = bytesToNameCanonicalizer.f560b;
                i = i2;
                i2 = length;
            }
            i6++;
            i3 = i2;
        }
        this.f574e = i;
        if (i3 != this.f573d) {
            throw new RuntimeException("Internal error: count after rehash " + i3 + "; should be " + this.f573d);
        }
    }

    private void m854f() {
        this.f573d = 0;
        this.f574e = 0;
        Arrays.fill(this.f576g, 0);
        Arrays.fill(this.f577h, null);
        Arrays.fill(this.f578i, null);
        this.f579j = 0;
        this.f580k = 0;
    }

    private int m855g() {
        BytesToNameCanonicalizer[] bytesToNameCanonicalizerArr = this.f578i;
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        int i3 = 0;
        int i4 = this.f580k;
        while (i3 < i4) {
            int a = bytesToNameCanonicalizerArr[i3].m843a();
            if (a >= i) {
                a = i;
            } else if (a == 1) {
                return i3;
            } else {
                i2 = i3;
            }
            i3++;
            i = a;
        }
        return i2;
    }

    private void m856h() {
        Object obj = this.f576g;
        int length = this.f576g.length;
        this.f576g = new int[length];
        System.arraycopy(obj, 0, this.f576g, 0, length);
        this.f583n = false;
    }

    private void m857i() {
        Object obj = this.f578i;
        if (obj == null) {
            this.f578i = new BytesToNameCanonicalizer[32];
        } else {
            int length = obj.length;
            this.f578i = new BytesToNameCanonicalizer[length];
            System.arraycopy(obj, 0, this.f578i, 0, length);
        }
        this.f585p = false;
    }

    private void m858j() {
        Object obj = this.f577h;
        int length = obj.length;
        this.f577h = new Name[length];
        System.arraycopy(obj, 0, this.f577h, 0, length);
        this.f584o = false;
    }

    private void m859k() {
        Object obj = this.f578i;
        int length = obj.length;
        this.f578i = new BytesToNameCanonicalizer[(length + length)];
        System.arraycopy(obj, 0, this.f578i, 0, length);
    }

    private static Name m848a(int i, String str, int[] iArr, int i2) {
        if (i2 < 4) {
            switch (i2) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    return new Name1(str, i, iArr[0]);
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    return new Name2(str, i, iArr[0], iArr[1]);
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    return new Name3(str, i, iArr[0], iArr[1], iArr[2]);
            }
        }
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = iArr[i3];
        }
        return new NameN(str, i, iArr2, i2);
    }

    protected void m870d(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f573d + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }
}
