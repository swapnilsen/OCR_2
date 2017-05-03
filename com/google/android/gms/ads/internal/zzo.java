package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzo implements Creator<zzn> {
    static void zza(zzn com_google_android_gms_ads_internal_zzn, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_ads_internal_zzn.zztK);
        zzc.zza(parcel, 3, com_google_android_gms_ads_internal_zzn.zztL);
        zzc.zza(parcel, 4, com_google_android_gms_ads_internal_zzn.zztM, false);
        zzc.zza(parcel, 5, com_google_android_gms_ads_internal_zzn.zztN);
        zzc.zza(parcel, 6, com_google_android_gms_ads_internal_zzn.zztO);
        zzc.zzc(parcel, 7, com_google_android_gms_ads_internal_zzn.zztP);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzi(i);
    }

    public zzn zzb(Parcel parcel) {
        int i = 0;
        int zzaY = zzb.zzaY(parcel);
        String str = null;
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    z3 = zzb.zzc(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    f = zzb.zzl(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzn(z3, z2, str, z, f, i);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzn[] zzi(int i) {
        return new zzn[i];
    }
}
