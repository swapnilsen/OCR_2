package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzob implements Creator<zzoa> {
    static void zza(zzoa com_google_android_gms_internal_zzoa, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzoa.zzRy, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzoa.zzvl, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzt(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzac(i);
    }

    public zzoa[] zzac(int i) {
        return new zzoa[i];
    }

    public zzoa zzt(Parcel parcel) {
        String str = null;
        int zzaY = zzb.zzaY(parcel);
        zzec com_google_android_gms_internal_zzec = null;
        while (parcel.dataPosition() < zzaY) {
            zzec com_google_android_gms_internal_zzec2;
            String str2;
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    String str3 = str;
                    com_google_android_gms_internal_zzec2 = (zzec) zzb.zza(parcel, zzaX, zzec.CREATOR);
                    str2 = str3;
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    com_google_android_gms_internal_zzec2 = com_google_android_gms_internal_zzec;
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    str2 = str;
                    com_google_android_gms_internal_zzec2 = com_google_android_gms_internal_zzec;
                    break;
            }
            com_google_android_gms_internal_zzec = com_google_android_gms_internal_zzec2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzoa(com_google_android_gms_internal_zzec, str);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }
}
