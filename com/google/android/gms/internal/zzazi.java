package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzazf.zzb;
import com.google.android.gms.internal.zzazf.zzb.zza;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazi implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_internal_zzazf_zzb, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf_zzb.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf_zzb.zzaiI);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzazf_zzb.zzbCI, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzazf_zzb.zzbCJ, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zzc(parcel, 4, com_google_android_gms_internal_zzazf_zzb.zzbCK);
        }
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjg(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzne(i);
    }

    public zzb zzjg(Parcel parcel) {
        zzb.zzb com_google_android_gms_internal_zzazf_zzb_zzb = null;
        int i = 0;
        int zzaY = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        zza com_google_android_gms_internal_zzazf_zzb_zza = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = com.google.android.gms.common.internal.safeparcel.zzb.zzaX(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    zza com_google_android_gms_internal_zzazf_zzb_zza2 = (zza) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaX, zza.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    com_google_android_gms_internal_zzazf_zzb_zza = com_google_android_gms_internal_zzazf_zzb_zza2;
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    zzb.zzb com_google_android_gms_internal_zzazf_zzb_zzb2 = (zzb.zzb) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, zzaX, zzb.zzb.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    com_google_android_gms_internal_zzazf_zzb_zzb = com_google_android_gms_internal_zzazf_zzb_zzb2;
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzb(hashSet, i2, com_google_android_gms_internal_zzazf_zzb_zza, com_google_android_gms_internal_zzazf_zzb_zzb, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzb[] zzne(int i) {
        return new zzb[i];
    }
}
