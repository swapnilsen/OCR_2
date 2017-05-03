package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzms implements Creator<zzmr> {
    static void zza(zzmr com_google_android_gms_internal_zzmr, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzmr.zzSN);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzmr.zzSO);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzmr.zzSP);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzY(i);
    }

    public zzmr[] zzY(int i) {
        return new zzmr[i];
    }

    public zzmr zzq(Parcel parcel) {
        boolean z = false;
        int zzaY = zzb.zzaY(parcel);
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    z3 = zzb.zzc(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzmr(z3, z2, z);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }
}
