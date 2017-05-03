package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzqi implements Creator<zzqh> {
    static void zza(zzqh com_google_android_gms_internal_zzqh, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzqh.zzba, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzqh.zzYW);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzqh.zzYX);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzqh.zzYY);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzqh.zzYZ);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzal(i);
    }

    public zzqh[] zzal(int i) {
        return new zzqh[i];
    }

    public zzqh zzw(Parcel parcel) {
        boolean z = false;
        int zzaY = zzb.zzaY(parcel);
        String str = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzqh(str, i2, i, z2, z);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }
}
