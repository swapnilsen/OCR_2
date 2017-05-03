package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzsl implements Parcelable {
    @Deprecated
    public static final Creator<zzsl> CREATOR;
    private String mValue;
    private String zzGV;
    private String zzaeU;

    /* renamed from: com.google.android.gms.internal.zzsl.1 */
    class C14171 implements Creator<zzsl> {
        C14171() {
        }

        @Deprecated
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzx(parcel);
        }

        @Deprecated
        public /* synthetic */ Object[] newArray(int i) {
            return zzaH(i);
        }

        @Deprecated
        public zzsl[] zzaH(int i) {
            return new zzsl[i];
        }

        @Deprecated
        public zzsl zzx(Parcel parcel) {
            return new zzsl(parcel);
        }
    }

    static {
        CREATOR = new C14171();
    }

    @Deprecated
    zzsl(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Deprecated
    private void readFromParcel(Parcel parcel) {
        this.zzGV = parcel.readString();
        this.zzaeU = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzGV;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzGV);
        parcel.writeString(this.zzaeU);
        parcel.writeString(this.mValue);
    }
}
