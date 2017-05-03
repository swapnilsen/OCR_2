package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzme
public final class zzqh extends zza {
    public static final Creator<zzqh> CREATOR;
    public int zzYW;
    public int zzYX;
    public boolean zzYY;
    public boolean zzYZ;
    public String zzba;

    static {
        CREATOR = new zzqi();
    }

    public zzqh(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzqh(int i, int i2, boolean z, boolean z2) {
        this(i, i2, z, false, z2);
    }

    public zzqh(int i, int i2, boolean z, boolean z2, boolean z3) {
        String valueOf = String.valueOf("afma-sdk-a-v");
        String str = z ? "0" : z2 ? "2" : "1";
        this(new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(str).length()).append(valueOf).append(i).append(".").append(i2).append(".").append(str).toString(), i, i2, z, z3);
    }

    zzqh(String str, int i, int i2, boolean z, boolean z2) {
        this.zzba = str;
        this.zzYW = i;
        this.zzYX = i2;
        this.zzYY = z;
        this.zzYZ = z2;
    }

    public static zzqh zzlk() {
        return new zzqh(10298208, 10298208, true);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzqi.zza(this, parcel, i);
    }
}
