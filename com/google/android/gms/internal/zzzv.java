package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzzv implements Creator<zzzu> {
    static void zza(zzzu com_google_android_gms_internal_zzzu, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzzu.packageName, false);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzzu.zzaxZ);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzzu.zzaya);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzzu.zzayb, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzzu.zzayc, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzzu.zzayd);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzzu.zzaye, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzzu.zzayf);
        zzc.zzc(parcel, 10, com_google_android_gms_internal_zzzu.zzayg);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzct(i);
    }

    public zzzu zzaI(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaY = zzb.zzaY(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzzu(str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzzu[] zzct(int i) {
        return new zzzu[i];
    }
}
