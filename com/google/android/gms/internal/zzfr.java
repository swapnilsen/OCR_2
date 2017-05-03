package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzc;

@zzme
public class zzfr extends zzeg {
    public zzfr(zzeg com_google_android_gms_internal_zzeg) {
        super(com_google_android_gms_internal_zzeg.zzzy, com_google_android_gms_internal_zzeg.height, com_google_android_gms_internal_zzeg.heightPixels, com_google_android_gms_internal_zzeg.zzzz, com_google_android_gms_internal_zzeg.width, com_google_android_gms_internal_zzeg.widthPixels, com_google_android_gms_internal_zzeg.zzzA, com_google_android_gms_internal_zzeg.zzzB, com_google_android_gms_internal_zzeg.zzzC, com_google_android_gms_internal_zzeg.zzzD);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, this.zzzy, false);
        zzc.zzc(parcel, 3, this.height);
        zzc.zzc(parcel, 6, this.width);
        zzc.zzJ(parcel, zzaZ);
    }
}
