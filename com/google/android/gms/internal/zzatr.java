package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzatr implements Creator<zzatq> {
    static void zza(zzatq com_google_android_gms_internal_zzatq, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzatq.name, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzatq.zzbrG, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzatq.zzbqV, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzatq.zzbrH);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlC(i);
    }

    public zzatq zzhT(Parcel parcel) {
        String str = null;
        int zzaY = zzb.zzaY(parcel);
        long j = 0;
        zzato com_google_android_gms_internal_zzato = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    com_google_android_gms_internal_zzato = (zzato) zzb.zza(parcel, zzaX, zzato.CREATOR);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzatq(str2, com_google_android_gms_internal_zzato, str, j);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzatq[] zzlC(int i) {
        return new zzatq[i];
    }
}
