package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzdq implements Creator<zzdp> {
    static void zza(zzdp com_google_android_gms_internal_zzdp, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzdp.zzey(), i, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzt(i);
    }

    public zzdp zzc(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zzb.zza(parcel, zzaX, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzdp(parcelFileDescriptor);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzdp[] zzt(int i) {
        return new zzdp[i];
    }
}
