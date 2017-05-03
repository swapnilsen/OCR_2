package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzme
public class zzfc extends zza {
    public static final Creator<zzfc> CREATOR;
    public final int zzzZ;

    static {
        CREATOR = new zzfd();
    }

    public zzfc(int i) {
        this.zzzZ = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzfd.zza(this, parcel, i);
    }
}
