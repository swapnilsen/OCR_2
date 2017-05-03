package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p050j.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR;
    public final String f2320a;
    public final int f2321b;
    public final String f2322c;
    public final String f2323d;
    public final String f2324e;
    public final int f2325f;
    public final List<byte[]> f2326g;
    public final DrmInitData f2327h;
    public final int f2328i;
    public final int f2329j;
    public final float f2330k;
    public final int f2331l;
    public final float f2332m;
    public final int f2333n;
    public final byte[] f2334o;
    public final int f2335p;
    public final int f2336q;
    public final int f2337r;
    public final int f2338s;
    public final int f2339t;
    public final long f2340u;
    public final int f2341v;
    public final String f2342w;
    private int f2343x;
    private MediaFormat f2344y;

    /* renamed from: com.google.android.exoplayer2.Format.1 */
    static class C08941 implements Creator<Format> {
        C08941() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m2856a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m2857a(i);
        }

        public Format m2856a(Parcel parcel) {
            return new Format(parcel);
        }

        public Format[] m2857a(int i) {
            return new Format[i];
        }
    }

    public static Format m2858a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, DrmInitData drmInitData) {
        return m2859a(str, str2, str3, i, i2, i3, i4, f, (List) list, i5, f2, null, -1, drmInitData);
    }

    public static Format m2859a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, i2, i3, i4, f, i5, f2, bArr, i6, -1, -1, -1, -1, -1, 0, null, Long.MAX_VALUE, list, drmInitData);
    }

    public static Format m2862a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, int i5, String str4) {
        return m2861a(str, str2, str3, i, i2, i3, i4, -1, (List) list, drmInitData, i5, str4);
    }

    public static Format m2861a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return m2860a(str, str2, str3, i, i2, i3, i4, i5, -1, -1, (List) list, drmInitData, i6, str4);
    }

    public static Format m2860a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str4) {
        return new Format(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, i3, i4, i5, i6, i7, i8, str4, Long.MAX_VALUE, list, drmInitData);
    }

    public static Format m2863a(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData) {
        return m2864a(str, str2, str3, i, i2, str4, drmInitData, Long.MAX_VALUE);
    }

    public static Format m2864a(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData, long j) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, i2, str4, j, null, drmInitData);
    }

    public static Format m2866a(String str, String str2, String str3, int i, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, str4, Long.MAX_VALUE, list, drmInitData);
    }

    public static Format m2865a(String str, String str2, String str3, int i, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, null, Long.MAX_VALUE, null, drmInitData);
    }

    Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str5, long j, List<byte[]> list, DrmInitData drmInitData) {
        this.f2320a = str;
        this.f2323d = str2;
        this.f2324e = str3;
        this.f2322c = str4;
        this.f2321b = i;
        this.f2325f = i2;
        this.f2328i = i3;
        this.f2329j = i4;
        this.f2330k = f;
        this.f2331l = i5;
        this.f2332m = f2;
        this.f2334o = bArr;
        this.f2333n = i6;
        this.f2335p = i7;
        this.f2336q = i8;
        this.f2337r = i9;
        this.f2338s = i10;
        this.f2339t = i11;
        this.f2341v = i12;
        this.f2342w = str5;
        this.f2340u = j;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f2326g = list;
        this.f2327h = drmInitData;
    }

    Format(Parcel parcel) {
        this.f2320a = parcel.readString();
        this.f2323d = parcel.readString();
        this.f2324e = parcel.readString();
        this.f2322c = parcel.readString();
        this.f2321b = parcel.readInt();
        this.f2325f = parcel.readInt();
        this.f2328i = parcel.readInt();
        this.f2329j = parcel.readInt();
        this.f2330k = parcel.readFloat();
        this.f2331l = parcel.readInt();
        this.f2332m = parcel.readFloat();
        this.f2334o = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        this.f2333n = parcel.readInt();
        this.f2335p = parcel.readInt();
        this.f2336q = parcel.readInt();
        this.f2337r = parcel.readInt();
        this.f2338s = parcel.readInt();
        this.f2339t = parcel.readInt();
        this.f2341v = parcel.readInt();
        this.f2342w = parcel.readString();
        this.f2340u = parcel.readLong();
        int readInt = parcel.readInt();
        this.f2326g = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f2326g.add(parcel.createByteArray());
        }
        this.f2327h = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
    }

    public Format m2871a(int i) {
        return new Format(this.f2320a, this.f2323d, this.f2324e, this.f2322c, this.f2321b, i, this.f2328i, this.f2329j, this.f2330k, this.f2331l, this.f2332m, this.f2334o, this.f2333n, this.f2335p, this.f2336q, this.f2337r, this.f2338s, this.f2339t, this.f2341v, this.f2342w, this.f2340u, this.f2326g, this.f2327h);
    }

    public Format m2873a(long j) {
        return new Format(this.f2320a, this.f2323d, this.f2324e, this.f2322c, this.f2321b, this.f2325f, this.f2328i, this.f2329j, this.f2330k, this.f2331l, this.f2332m, this.f2334o, this.f2333n, this.f2335p, this.f2336q, this.f2337r, this.f2338s, this.f2339t, this.f2341v, this.f2342w, j, this.f2326g, this.f2327h);
    }

    public Format m2872a(int i, int i2) {
        return new Format(this.f2320a, this.f2323d, this.f2324e, this.f2322c, this.f2321b, this.f2325f, this.f2328i, this.f2329j, this.f2330k, this.f2331l, this.f2332m, this.f2334o, this.f2333n, this.f2335p, this.f2336q, this.f2337r, i, i2, this.f2341v, this.f2342w, this.f2340u, this.f2326g, this.f2327h);
    }

    public Format m2874a(DrmInitData drmInitData) {
        return new Format(this.f2320a, this.f2323d, this.f2324e, this.f2322c, this.f2321b, this.f2325f, this.f2328i, this.f2329j, this.f2330k, this.f2331l, this.f2332m, this.f2334o, this.f2333n, this.f2335p, this.f2336q, this.f2337r, this.f2338s, this.f2339t, this.f2341v, this.f2342w, this.f2340u, this.f2326g, drmInitData);
    }

    public int m2870a() {
        return (this.f2328i == -1 || this.f2329j == -1) ? -1 : this.f2328i * this.f2329j;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat m2875b() {
        if (this.f2344y == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.f2324e);
            m2869a(mediaFormat, "language", this.f2342w);
            m2868a(mediaFormat, "max-input-size", this.f2325f);
            m2868a(mediaFormat, "width", this.f2328i);
            m2868a(mediaFormat, "height", this.f2329j);
            m2867a(mediaFormat, "frame-rate", this.f2330k);
            m2868a(mediaFormat, "rotation-degrees", this.f2331l);
            m2868a(mediaFormat, "channel-count", this.f2335p);
            m2868a(mediaFormat, "sample-rate", this.f2336q);
            m2868a(mediaFormat, "encoder-delay", this.f2338s);
            m2868a(mediaFormat, "encoder-padding", this.f2339t);
            for (int i = 0; i < this.f2326g.size(); i++) {
                mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[]) this.f2326g.get(i)));
            }
            this.f2344y = mediaFormat;
        }
        return this.f2344y;
    }

    public String toString() {
        return "Format(" + this.f2320a + ", " + this.f2323d + ", " + this.f2324e + ", " + this.f2321b + ", , " + this.f2342w + ", [" + this.f2328i + ", " + this.f2329j + ", " + this.f2330k + "], [" + this.f2335p + ", " + this.f2336q + "])";
    }

    public int hashCode() {
        int i = 0;
        if (this.f2343x == 0) {
            int hashCode = ((this.f2342w == null ? 0 : this.f2342w.hashCode()) + (((((((((((((this.f2322c == null ? 0 : this.f2322c.hashCode()) + (((this.f2324e == null ? 0 : this.f2324e.hashCode()) + (((this.f2323d == null ? 0 : this.f2323d.hashCode()) + (((this.f2320a == null ? 0 : this.f2320a.hashCode()) + 527) * 31)) * 31)) * 31)) * 31) + this.f2321b) * 31) + this.f2328i) * 31) + this.f2329j) * 31) + this.f2335p) * 31) + this.f2336q) * 31)) * 31;
            if (this.f2327h != null) {
                i = this.f2327h.hashCode();
            }
            this.f2343x = hashCode + i;
        }
        return this.f2343x;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.f2321b != format.f2321b || this.f2325f != format.f2325f || this.f2328i != format.f2328i || this.f2329j != format.f2329j || this.f2330k != format.f2330k || this.f2331l != format.f2331l || this.f2332m != format.f2332m || this.f2333n != format.f2333n || this.f2335p != format.f2335p || this.f2336q != format.f2336q || this.f2337r != format.f2337r || this.f2338s != format.f2338s || this.f2339t != format.f2339t || this.f2340u != format.f2340u || this.f2341v != format.f2341v || !Util.m4517a(this.f2320a, format.f2320a) || !Util.m4517a(this.f2342w, format.f2342w) || !Util.m4517a(this.f2323d, format.f2323d) || !Util.m4517a(this.f2324e, format.f2324e) || !Util.m4517a(this.f2322c, format.f2322c) || !Util.m4517a(this.f2327h, format.f2327h) || !Arrays.equals(this.f2334o, format.f2334o) || this.f2326g.size() != format.f2326g.size()) {
            return false;
        }
        for (int i = 0; i < this.f2326g.size(); i++) {
            if (!Arrays.equals((byte[]) this.f2326g.get(i), (byte[]) format.f2326g.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private static void m2869a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    @TargetApi(16)
    private static void m2868a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    private static void m2867a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2320a);
        parcel.writeString(this.f2323d);
        parcel.writeString(this.f2324e);
        parcel.writeString(this.f2322c);
        parcel.writeInt(this.f2321b);
        parcel.writeInt(this.f2325f);
        parcel.writeInt(this.f2328i);
        parcel.writeInt(this.f2329j);
        parcel.writeFloat(this.f2330k);
        parcel.writeInt(this.f2331l);
        parcel.writeFloat(this.f2332m);
        parcel.writeInt(this.f2334o != null ? 1 : 0);
        if (this.f2334o != null) {
            parcel.writeByteArray(this.f2334o);
        }
        parcel.writeInt(this.f2333n);
        parcel.writeInt(this.f2335p);
        parcel.writeInt(this.f2336q);
        parcel.writeInt(this.f2337r);
        parcel.writeInt(this.f2338s);
        parcel.writeInt(this.f2339t);
        parcel.writeInt(this.f2341v);
        parcel.writeString(this.f2342w);
        parcel.writeLong(this.f2340u);
        int size = this.f2326g.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray((byte[]) this.f2326g.get(i2));
        }
        parcel.writeParcelable(this.f2327h, 0);
    }

    static {
        CREATOR = new C08941();
    }
}
