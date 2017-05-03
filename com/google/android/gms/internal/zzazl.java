package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.internal.zzazf.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazl implements Creator<zzc> {
    static void zza(zzc com_google_android_gms_internal_zzazf_zzc, Parcel parcel, int i) {
        int zzaZ = com.google.android.gms.common.internal.safeparcel.zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf_zzc.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf_zzc.zzaiI);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzc.zza(parcel, 2, com_google_android_gms_internal_zzazf_zzc.zzE, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznh(i);
    }

    public zzc zzjj(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzc(hashSet, i, str);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzc[] zznh(int i) {
        return new zzc[i];
    }
}
