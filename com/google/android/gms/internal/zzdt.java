package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzdt implements Creator<zzds> {
    static void zza(zzds com_google_android_gms_internal_zzds, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzds.url, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzds.zzyL);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzds.zzyM, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzds.zzyN, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzds.zzyO, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzds.zzyP, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzds.zzyQ);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzu(i);
    }

    public zzds zzd(Parcel parcel) {
        Bundle bundle = null;
        int zzaY = zzb.zzaY(parcel);
        long j = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    bundle = zzb.zzs(parcel, zzaX);
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
            return new zzds(str4, j, str3, str2, str, bundle, z);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzds[] zzu(int i) {
        return new zzds[i];
    }
}
