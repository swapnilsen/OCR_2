package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbnn extends zza {
    public static final Creator<zzbnn> CREATOR;
    public final int zzaiI;
    private String zzbWN;
    private String zzbZk;

    static {
        CREATOR = new zzbno();
    }

    zzbnn(int i, String str, String str2) {
        this.zzaiI = i;
        this.zzbZk = str;
        this.zzbWN = str2;
    }

    public zzbnn(String str, String str2) {
        this.zzaiI = 1;
        this.zzbZk = str;
        this.zzbWN = str2;
    }

    public String getApiKey() {
        return this.zzbWN;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbno.zza(this, parcel, i);
    }

    public String zzWC() {
        return this.zzbZk;
    }
}
