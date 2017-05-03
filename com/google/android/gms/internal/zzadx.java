package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzadx implements Creator<zzadw> {
    static void zza(zzadw com_google_android_gms_internal_zzadw, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzadw.getStatusCode());
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzadw.zzzM(), i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzadw.getThrottleEndTimeMillis());
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzadw.zzzN(), i, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdA(i);
    }

    public zzadw zzbo(Parcel parcel) {
        DataHolder dataHolder = null;
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        long j = 0;
        DataHolder dataHolder2 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    dataHolder2 = (DataHolder) zzb.zza(parcel, zzaX, DataHolder.CREATOR);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaX, DataHolder.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzadw(i, dataHolder2, j, dataHolder);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzadw[] zzdA(int i) {
        return new zzadw[i];
    }
}
