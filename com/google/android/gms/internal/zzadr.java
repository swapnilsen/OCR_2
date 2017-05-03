package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzadr implements Creator<zzadq> {
    static void zza(zzadq com_google_android_gms_internal_zzadq, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzadq.getPayload(), false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdx(i);
    }

    public zzadq zzbl(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    bArr = zzb.zzt(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzadq(bArr);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzadq[] zzdx(int i) {
        return new zzadq[i];
    }
}
