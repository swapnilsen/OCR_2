package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzme
public class zzmy extends zza {
    public static final Creator<zzmy> CREATOR;
    String zzFV;

    static {
        CREATOR = new zzmz();
    }

    public zzmy(String str) {
        this.zzFV = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzmz.zza(this, parcel, i);
    }

    public String zzjt() {
        return this.zzFV;
    }
}
