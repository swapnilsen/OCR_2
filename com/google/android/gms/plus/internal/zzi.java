package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public class zzi implements Creator<zzh> {
    static void zza(zzh com_google_android_gms_plus_internal_zzh, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_plus_internal_zzh.getAccountName(), false);
        zzc.zza(parcel, 2, com_google_android_gms_plus_internal_zzh.zzPb(), false);
        zzc.zza(parcel, 3, com_google_android_gms_plus_internal_zzh.zzPc(), false);
        zzc.zza(parcel, 4, com_google_android_gms_plus_internal_zzh.zzPd(), false);
        zzc.zza(parcel, 5, com_google_android_gms_plus_internal_zzh.zzPe(), false);
        zzc.zza(parcel, 6, com_google_android_gms_plus_internal_zzh.zzPf(), false);
        zzc.zza(parcel, 7, com_google_android_gms_plus_internal_zzh.zzur(), false);
        zzc.zzc(parcel, PointerIconCompat.TYPE_DEFAULT, com_google_android_gms_plus_internal_zzh.getVersionCode());
        zzc.zza(parcel, 8, com_google_android_gms_plus_internal_zzh.zzPg(), false);
        zzc.zza(parcel, 9, com_google_android_gms_plus_internal_zzh.zzPh(), i, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzjd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zznb(i);
    }

    public zzh zzjd(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    str5 = zzb.zzq(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    strArr3 = zzb.zzC(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    strArr2 = zzb.zzC(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    strArr = zzb.zzC(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    plusCommonExtras = (PlusCommonExtras) zzb.zza(parcel, zzaX, PlusCommonExtras.CREATOR);
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
            return new zzh(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzh[] zznb(int i) {
        return new zzh[i];
    }
}
