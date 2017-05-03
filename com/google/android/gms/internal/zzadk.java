package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzadk extends zza {
    public static final Creator<zzadk> CREATOR;
    private final String mName;
    private final String mValue;

    static {
        CREATOR = new zzadl();
    }

    public zzadk(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzadl.zza(this, parcel, i);
    }
}
