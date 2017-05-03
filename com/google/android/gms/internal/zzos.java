package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

public class zzos implements Creator<zzor> {
    static void zza(zzor com_google_android_gms_internal_zzor, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzor.zzVQ, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzor.zzVR, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzor.zzVS);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzor.zzVT);
        zzc.zzb(parcel, 6, com_google_android_gms_internal_zzor.zzVU, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzag(i);
    }

    public zzor[] zzag(int i) {
        return new zzor[i];
    }

    public zzor zzv(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzaY = zzb.zzaY(parcel);
        boolean z2 = false;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    list = zzb.zzE(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzor(str2, str, z2, z, list);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }
}
