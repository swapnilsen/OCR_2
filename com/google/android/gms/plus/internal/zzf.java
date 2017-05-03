package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public class zzf implements Creator<PlusCommonExtras> {
    static void zza(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 1, plusCommonExtras.zzOZ(), false);
        zzc.zza(parcel, 2, plusCommonExtras.zzPa(), false);
        zzc.zzc(parcel, PointerIconCompat.TYPE_DEFAULT, plusCommonExtras.getVersionCode());
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzna(i);
    }

    public PlusCommonExtras zzjc(Parcel parcel) {
        String str = null;
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case PointerIconCompat.TYPE_DEFAULT /*1000*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new PlusCommonExtras(i, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public PlusCommonExtras[] zzna(int i) {
        return new PlusCommonExtras[i];
    }
}
