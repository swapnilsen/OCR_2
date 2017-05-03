package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzme
public final class zzoa extends zza {
    public static final Creator<zzoa> CREATOR;
    public final zzec zzRy;
    public final String zzvl;

    static {
        CREATOR = new zzob();
    }

    public zzoa(zzec com_google_android_gms_internal_zzec, String str) {
        this.zzRy = com_google_android_gms_internal_zzec;
        this.zzvl = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzob.zza(this, parcel, i);
    }
}
