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

public class zzfq implements Creator<zzfp> {
    static void zza(zzfp com_google_android_gms_internal_zzfp, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzfp.zzAH);
        zzc.zzc(parcel, 3, com_google_android_gms_internal_zzfp.backgroundColor);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzfp.zzAI);
        zzc.zzc(parcel, 5, com_google_android_gms_internal_zzfp.zzAJ);
        zzc.zzc(parcel, 6, com_google_android_gms_internal_zzfp.zzAK);
        zzc.zzc(parcel, 7, com_google_android_gms_internal_zzfp.zzAL);
        zzc.zzc(parcel, 8, com_google_android_gms_internal_zzfp.zzAM);
        zzc.zzc(parcel, 9, com_google_android_gms_internal_zzfp.zzAN);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzfp.zzAO, false);
        zzc.zzc(parcel, 11, com_google_android_gms_internal_zzfp.zzAP);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzfp.zzAQ, false);
        zzc.zzc(parcel, 13, com_google_android_gms_internal_zzfp.zzAR);
        zzc.zzc(parcel, 14, com_google_android_gms_internal_zzfp.zzAS);
        zzc.zza(parcel, 15, com_google_android_gms_internal_zzfp.zzAT, false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzA(i);
    }

    public zzfp[] zzA(int i) {
        return new zzfp[i];
    }

    public zzfp zzh(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        String str = null;
        int i9 = 0;
        String str2 = null;
        int i10 = 0;
        int i11 = 0;
        String str3 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    i4 = zzb.zzg(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    i5 = zzb.zzg(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    i6 = zzb.zzg(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    i7 = zzb.zzg(parcel, zzaX);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    i8 = zzb.zzg(parcel, zzaX);
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i9 = zzb.zzg(parcel, zzaX);
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    i10 = zzb.zzg(parcel, zzaX);
                    break;
                case CommonStatusCodes.INTERRUPTED /*14*/:
                    i11 = zzb.zzg(parcel, zzaX);
                    break;
                case CommonStatusCodes.TIMEOUT /*15*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzfp(i, i2, i3, i4, i5, i6, i7, i8, str, i9, str2, i10, i11, str3);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }
}
