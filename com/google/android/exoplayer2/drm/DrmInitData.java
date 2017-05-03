package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.p050j.Assertions;
import com.google.android.exoplayer2.p050j.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR;
    public final int f3305a;
    private final SchemeData[] f3306b;
    private int f3307c;

    /* renamed from: com.google.android.exoplayer2.drm.DrmInitData.1 */
    static class C08951 implements Creator<DrmInitData> {
        C08951() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m3800a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m3801a(i);
        }

        public DrmInitData m3800a(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        public DrmInitData[] m3801a(int i) {
            return new DrmInitData[i];
        }
    }

    public static final class SchemeData implements Parcelable {
        public static final Creator<SchemeData> CREATOR;
        public final String f3300a;
        public final byte[] f3301b;
        public final boolean f3302c;
        private int f3303d;
        private final UUID f3304e;

        /* renamed from: com.google.android.exoplayer2.drm.DrmInitData.SchemeData.1 */
        static class C08961 implements Creator<SchemeData> {
            C08961() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3802a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3803a(i);
            }

            public SchemeData m3802a(Parcel parcel) {
                return new SchemeData(parcel);
            }

            public SchemeData[] m3803a(int i) {
                return new SchemeData[i];
            }
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f3304e = (UUID) Assertions.m4402a((Object) uuid);
            this.f3300a = (String) Assertions.m4402a((Object) str);
            this.f3301b = (byte[]) Assertions.m4402a((Object) bArr);
            this.f3302c = z;
        }

        SchemeData(Parcel parcel) {
            this.f3304e = new UUID(parcel.readLong(), parcel.readLong());
            this.f3300a = parcel.readString();
            this.f3301b = parcel.createByteArray();
            this.f3302c = parcel.readByte() != null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (this.f3300a.equals(schemeData.f3300a) && Util.m4517a(this.f3304e, schemeData.f3304e) && Arrays.equals(this.f3301b, schemeData.f3301b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            if (this.f3303d == 0) {
                this.f3303d = (((this.f3304e.hashCode() * 31) + this.f3300a.hashCode()) * 31) + Arrays.hashCode(this.f3301b);
            }
            return this.f3303d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f3304e.getMostSignificantBits());
            parcel.writeLong(this.f3304e.getLeastSignificantBits());
            parcel.writeString(this.f3300a);
            parcel.writeByteArray(this.f3301b);
            parcel.writeByte((byte) (this.f3302c ? 1 : 0));
        }

        static {
            CREATOR = new C08961();
        }
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m3805a((SchemeData) obj, (SchemeData) obj2);
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        SchemeData[] schemeDataArr2;
        if (z) {
            schemeDataArr2 = (SchemeData[]) schemeDataArr.clone();
        } else {
            schemeDataArr2 = schemeDataArr;
        }
        Arrays.sort(schemeDataArr2, this);
        for (int i = 1; i < schemeDataArr2.length; i++) {
            if (schemeDataArr2[i - 1].f3304e.equals(schemeDataArr2[i].f3304e)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + schemeDataArr2[i].f3304e);
            }
        }
        this.f3306b = schemeDataArr2;
        this.f3305a = schemeDataArr2.length;
    }

    DrmInitData(Parcel parcel) {
        this.f3306b = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.f3305a = this.f3306b.length;
    }

    public SchemeData m3806a(int i) {
        return this.f3306b[i];
    }

    public int hashCode() {
        if (this.f3307c == 0) {
            this.f3307c = Arrays.hashCode(this.f3306b);
        }
        return this.f3307c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f3306b, ((DrmInitData) obj).f3306b);
    }

    public int m3805a(SchemeData schemeData, SchemeData schemeData2) {
        if (C.f2522b.equals(schemeData.f3304e)) {
            return C.f2522b.equals(schemeData2.f3304e) ? 0 : 1;
        } else {
            return schemeData.f3304e.compareTo(schemeData2.f3304e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f3306b, 0);
    }

    static {
        CREATOR = new C08951();
    }
}
