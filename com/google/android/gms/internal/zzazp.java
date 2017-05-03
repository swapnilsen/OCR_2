package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzazf.zzh;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazp implements Creator<zzh> {
    static void zza(zzh com_google_android_gms_internal_zzazf_zzh, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf_zzh.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf_zzh.zzaiI);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zzc(parcel, 3, com_google_android_gms_internal_zzazf_zzh.zzPt());
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzazf_zzh.mValue, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzazf_zzh.zzadc, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zzc(parcel, 6, com_google_android_gms_internal_zzazf_zzh.zzakD);
        }
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznl(i);
    }

    public zzh zzjn(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaY = zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    i = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzh(hashSet, i3, str2, i2, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzh[] zznl(int i) {
        return new zzh[i];
    }
}
