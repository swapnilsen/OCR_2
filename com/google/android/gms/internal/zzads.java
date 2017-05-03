package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzads extends zza {
    public static final Creator<zzads> CREATOR;
    private final String mName;
    private final String mValue;

    static {
        CREATOR = new zzadt();
    }

    public zzads(String str, String str2) {
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
        zzadt.zza(this, parcel, i);
    }
}
