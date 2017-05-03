package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.cardview.C0269R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import net.nend.android.NendIconError;

public class zzath implements Creator<zzatg> {
    static void zza(zzatg com_google_android_gms_internal_zzatg, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzatg.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzatg.packageName, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzatg.zzbqV, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzatg.zzbqW, i, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzatg.zzbqX);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzatg.zzbqY);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzatg.zzbqZ, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzatg.zzbra, i, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzatg.zzbrb);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzatg.zzbrc, i, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzatg.zzbrd);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzatg.zzbre, i, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlA(i);
    }

    public zzatg zzhR(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        zzauq com_google_android_gms_internal_zzauq = null;
        long j = 0;
        boolean z = false;
        String str3 = null;
        zzatq com_google_android_gms_internal_zzatq = null;
        long j2 = 0;
        zzatq com_google_android_gms_internal_zzatq2 = null;
        long j3 = 0;
        zzatq com_google_android_gms_internal_zzatq3 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    com_google_android_gms_internal_zzauq = (zzauq) zzb.zza(parcel, zzaX, zzauq.CREATOR);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    com_google_android_gms_internal_zzatq = (zzatq) zzb.zza(parcel, zzaX, zzatq.CREATOR);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    j2 = zzb.zzi(parcel, zzaX);
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    com_google_android_gms_internal_zzatq2 = (zzatq) zzb.zza(parcel, zzaX, zzatq.CREATOR);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    j3 = zzb.zzi(parcel, zzaX);
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    com_google_android_gms_internal_zzatq3 = (zzatq) zzb.zza(parcel, zzaX, zzatq.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzatg(i, str, str2, com_google_android_gms_internal_zzauq, j, z, str3, com_google_android_gms_internal_zzatq, j2, com_google_android_gms_internal_zzatq2, j3, com_google_android_gms_internal_zzatq3);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzatg[] zzlA(int i) {
        return new zzatg[i];
    }
}
