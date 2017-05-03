package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.cardview.C0269R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.RelationshipStatus;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.api.client.http.HttpRequest;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class zzate implements Creator<zzatd> {
    static void zza(zzatd com_google_android_gms_internal_zzatd, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzatd.packageName, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzatd.zzbqL, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzatd.zzbhN, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzatd.zzbqM, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzatd.zzbqN);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzatd.zzbqO);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzatd.zzbqP, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzatd.zzbqQ);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzatd.zzbqR);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzatd.zzbqS);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzatd.zzbqT, false);
        zzc.zza(parcel, 13, com_google_android_gms_internal_zzatd.zzbqU);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlz(i);
    }

    public zzatd zzhQ(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = true;
        boolean z2 = false;
        long j3 = -2147483648L;
        String str6 = null;
        long j4 = 0;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    j2 = zzb.zzi(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    str5 = zzb.zzq(parcel, zzaX);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    j3 = zzb.zzi(parcel, zzaX);
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    str6 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    j4 = zzb.zzi(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzatd(str, str2, str3, str4, j, j2, str5, z, z2, j3, str6, j4);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzatd[] zzlz(int i) {
        return new zzatd[i];
    }
}
