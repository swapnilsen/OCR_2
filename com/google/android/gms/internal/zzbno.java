package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public class zzbno implements Creator<zzbnn> {
    static void zza(zzbnn com_google_android_gms_internal_zzbnn, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzbnn.zzaiI);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzbnn.zzWC(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzbnn.getApiKey(), false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzlN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzqu(i);
    }

    public zzbnn zzlN(Parcel parcel) {
        String str = null;
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzbnn(i, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzbnn[] zzqu(int i) {
        return new zzbnn[i];
    }
}
