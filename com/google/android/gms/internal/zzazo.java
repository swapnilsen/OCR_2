package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzazf.zzg;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazo implements Creator<zzg> {
    static void zza(zzg com_google_android_gms_internal_zzazf_zzg, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf_zzg.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf_zzg.zzaiI);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzazf_zzg.zzbCU);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzazf_zzg.mValue, true);
        }
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznk(i);
    }

    public zzg zzjm(Parcel parcel) {
        boolean z = false;
        int zzaY = zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    z = zzb.zzc(parcel, zzaX);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzg(hashSet, i, z, str);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzg[] zznk(int i) {
        return new zzg[i];
    }
}
