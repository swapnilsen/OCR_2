package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public class zzaql implements Creator<zzaqk> {
    static void zza(zzaqk com_google_android_gms_internal_zzaqk, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzaqk.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzaqk.zzGM(), false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjz(i);
    }

    public zzaqk zzgl(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    bArr = zzb.zzt(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzaqk(i, bArr);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzaqk[] zzjz(int i) {
        return new zzaqk[i];
    }
}
