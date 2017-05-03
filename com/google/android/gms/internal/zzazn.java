package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzazf.zzf;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashSet;
import java.util.Set;
import net.nend.android.NendIconError;

public class zzazn implements Creator<zzf> {
    static void zza(zzf com_google_android_gms_internal_zzazf_zzf, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        Set set = com_google_android_gms_internal_zzazf_zzf.zzbCm;
        if (set.contains(Integer.valueOf(1))) {
            zzc.zzc(parcel, 1, com_google_android_gms_internal_zzazf_zzf.zzaiI);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzc.zza(parcel, 2, com_google_android_gms_internal_zzazf_zzf.zzbCR, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzc.zza(parcel, 3, com_google_android_gms_internal_zzazf_zzf.zzade, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzc.zza(parcel, 4, com_google_android_gms_internal_zzazf_zzf.zzbCS, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzc.zza(parcel, 5, com_google_android_gms_internal_zzazf_zzf.zzbCT, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzc.zza(parcel, 6, com_google_android_gms_internal_zzazf_zzf.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzc.zza(parcel, 7, com_google_android_gms_internal_zzazf_zzf.zzbCU);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzc.zza(parcel, 8, com_google_android_gms_internal_zzazf_zzf.zzbCV, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzc.zza(parcel, 9, com_google_android_gms_internal_zzazf_zzf.zzamJ, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzc.zzc(parcel, 10, com_google_android_gms_internal_zzazf_zzf.zzakD);
        }
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznj(i);
    }

    public zzf zzjl(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaY = zzb.zzaY(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str7 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str6 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str5 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Type.WEBSITE /*7*/:
                    z = zzb.zzc(parcel, zzaX);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str = zzb.zzq(parcel, zzaX);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    i = zzb.zzg(parcel, zzaX);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzf(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzf[] zznj(int i) {
        return new zzf[i];
    }
}
