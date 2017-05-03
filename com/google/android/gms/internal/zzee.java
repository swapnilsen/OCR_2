package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
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
import java.util.List;
import net.nend.android.NendIconError;

public class zzee implements Creator<zzec> {
    static void zza(zzec com_google_android_gms_internal_zzec, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzec.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzec.zzyT);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzec.extras, false);
        zzc.zzc(parcel, 4, com_google_android_gms_internal_zzec.zzyU);
        zzc.zzb(parcel, 5, com_google_android_gms_internal_zzec.zzyV, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzec.zzyW);
        zzc.zzc(parcel, 7, com_google_android_gms_internal_zzec.zzyX);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzec.zzyY);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzec.zzyZ, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzec.zzza, i, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzec.zzzb, i, false);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzec.zzzc, false);
        zzc.zza(parcel, 13, com_google_android_gms_internal_zzec.zzzd, false);
        zzc.zza(parcel, 14, com_google_android_gms_internal_zzec.zzze, false);
        zzc.zzb(parcel, 15, com_google_android_gms_internal_zzec.zzzf, false);
        zzc.zza(parcel, 16, com_google_android_gms_internal_zzec.zzzg, false);
        zzc.zza(parcel, 17, com_google_android_gms_internal_zzec.zzzh, false);
        zzc.zza(parcel, 18, com_google_android_gms_internal_zzec.zzzi);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zze(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzv(i);
    }

    public zzec zze(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        zzfp com_google_android_gms_internal_zzfp = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    bundle = zzb.zzs(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    list = zzb.zzE(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    z = zzb.zzc(parcel, zzaX);
                    break;
                case Type.WEBSITE /*7*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    z2 = zzb.zzc(parcel, zzaX);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    com_google_android_gms_internal_zzfp = (zzfp) zzb.zza(parcel, zzaX, zzfp.CREATOR);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    location = (Location) zzb.zza(parcel, zzaX, Location.CREATOR);
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    bundle2 = zzb.zzs(parcel, zzaX);
                    break;
                case CommonStatusCodes.INTERRUPTED /*14*/:
                    bundle3 = zzb.zzs(parcel, zzaX);
                    break;
                case CommonStatusCodes.TIMEOUT /*15*/:
                    list2 = zzb.zzE(parcel, zzaX);
                    break;
                case CommonStatusCodes.CANCELED /*16*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.DEAD_CLIENT /*18*/:
                    z3 = zzb.zzc(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new zzec(i, j, bundle, i2, list, z, i3, z2, str, com_google_android_gms_internal_zzfp, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public zzec[] zzv(int i) {
        return new zzec[i];
    }
}
