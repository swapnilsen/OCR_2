package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzazf.zza;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazh implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzazf_zza, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf_zza.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf_zza.zzaiI);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zzc(parcel, 2, com_google_android_gms_internal_zzazf_zza.zzbCG);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zzc(parcel, 3, com_google_android_gms_internal_zzazf_zza.zzbCH);
        }
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznd(i);
    }

    public zza zzjf(Parcel parcel) {
        int i = 0;
        int zzaY = zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    i = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zza(hashSet, i3, i2, i);
        }
        throw new zzb.zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zza[] zznd(int i) {
        return new zza[i];
    }
}
