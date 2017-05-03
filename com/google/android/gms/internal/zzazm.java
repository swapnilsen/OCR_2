package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzazf.zzd;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazm implements Creator<zzd> {
    static void zza(zzd com_google_android_gms_internal_zzazf_zzd, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf_zzd.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf_zzd.zzaiI);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzazf_zzd.zzajm, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzazf_zzd.zzbCN, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzazf_zzd.zzajl, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzazf_zzd.zzbCO, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zza(parcel, 6, com_google_android_gms_internal_zzazf_zzd.zzbCP, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzc.zza(parcel, 7, com_google_android_gms_internal_zzazf_zzd.zzbCQ, true);
        }
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzni(i);
    }

    public zzd zzjk(Parcel parcel) {
        String str = null;
        int zzaY = zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str6 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str5 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Type.WEBSITE /*7*/:
                    str = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzd(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzd[] zzni(int i) {
        return new zzd[i];
    }
}
