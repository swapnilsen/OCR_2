package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzzn implements Creator<zzzm> {
    static void zza(zzzm com_google_android_gms_internal_zzzm, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzzm.zzaxI, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzzm.zzaxJ, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzzm.zzaxK, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzzm.zzaxL, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzzm.zzaxM, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzzm.zzaxN, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzzm.zzaxO);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcs(i);
    }

    public zzzm zzaH(Parcel parcel) {
        byte[][] bArr = null;
        int zzaY = zzb.zzaY(parcel);
        boolean z = true;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        zzzu com_google_android_gms_internal_zzzu = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    com_google_android_gms_internal_zzzu = (zzzu) zzb.zza(parcel, zzaX, zzzu.CREATOR);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    bArr2 = zzb.zzt(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    iArr2 = zzb.zzw(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    strArr = zzb.zzC(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    iArr = zzb.zzw(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    bArr = zzb.zzu(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzzm(com_google_android_gms_internal_zzzu, bArr2, iArr2, strArr, iArr, bArr, z);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzzm[] zzcs(int i) {
        return new zzzm[i];
    }
}
