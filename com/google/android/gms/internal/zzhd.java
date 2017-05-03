package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public class zzhd implements Creator<zzhc> {
    static void zza(zzhc com_google_android_gms_internal_zzhc, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzhc.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzhc.zzHa);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzhc.zzHb);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzhc.zzHc);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzhc.zzHd);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzhc.zzHe, i, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzD(i);
    }

    public zzhc[] zzD(int i) {
        return new zzhc[i];
    }

    public zzhc zzj(Parcel parcel) {
        int i = 0;
        int zzaY = zzb.zzaY(parcel);
        zzft com_google_android_gms_internal_zzft = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    com_google_android_gms_internal_zzft = (zzft) zzb.zza(parcel, zzaX, zzft.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzhc(i3, z2, i2, z, i, com_google_android_gms_internal_zzft);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }
}
