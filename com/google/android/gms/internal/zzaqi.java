package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzaqi extends zza {
    public static final Creator<zzaqi> CREATOR;
    public final String packageName;
    public final int versionCode;
    public final String zzbgj;

    static {
        CREATOR = new zzaqj();
    }

    zzaqi(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzbgj = str2;
    }

    public zzaqi(String str, String str2) {
        this(1, str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaqj.zza(this, parcel, i);
    }
}
