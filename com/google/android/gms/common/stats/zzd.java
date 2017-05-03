package com.google.android.gms.common.stats;

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

public class zzd implements Creator<WakeLockEvent> {
    static void zza(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zzc(parcel, 1, wakeLockEvent.zzaiI);
        zzc.zza(parcel, 2, wakeLockEvent.getTimeMillis());
        zzc.zza(parcel, 4, wakeLockEvent.zzyM(), false);
        zzc.zzc(parcel, 5, wakeLockEvent.zzyP());
        zzc.zzb(parcel, 6, wakeLockEvent.zzyQ(), false);
        zzc.zza(parcel, 8, wakeLockEvent.zzyS());
        zzc.zza(parcel, 10, wakeLockEvent.zzyN(), false);
        zzc.zzc(parcel, 11, wakeLockEvent.getEventType());
        zzc.zza(parcel, 12, wakeLockEvent.zzyR(), false);
        zzc.zza(parcel, 13, wakeLockEvent.zzyU(), false);
        zzc.zzc(parcel, 14, wakeLockEvent.zzyT());
        zzc.zza(parcel, 15, wakeLockEvent.zzyV());
        zzc.zza(parcel, 16, wakeLockEvent.zzyW());
        zzc.zza(parcel, 17, wakeLockEvent.zzyO(), false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdn(i);
    }

    public WakeLockEvent zzbj(Parcel parcel) {
        int zzaY = zzb.zzaY(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case NendIconError.ERROR_ICONVIEW /*1*/:
                    i = zzb.zzg(parcel, zzaX);
                    break;
                case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                    j = zzb.zzi(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    str = zzb.zzq(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    i3 = zzb.zzg(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    list = zzb.zzE(parcel, zzaX);
                    break;
                case RelationshipStatus.IN_CIVIL_UNION /*8*/:
                    j2 = zzb.zzi(parcel, zzaX);
                    break;
                case HttpRequest.DEFAULT_NUMBER_OF_RETRIES /*10*/:
                    str3 = zzb.zzq(parcel, zzaX);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i2 = zzb.zzg(parcel, zzaX);
                    break;
                case C0269R.styleable.CardView_contentPaddingBottom /*12*/:
                    str2 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str4 = zzb.zzq(parcel, zzaX);
                    break;
                case CommonStatusCodes.INTERRUPTED /*14*/:
                    i4 = zzb.zzg(parcel, zzaX);
                    break;
                case CommonStatusCodes.TIMEOUT /*15*/:
                    f = zzb.zzl(parcel, zzaX);
                    break;
                case CommonStatusCodes.CANCELED /*16*/:
                    j3 = zzb.zzi(parcel, zzaX);
                    break;
                case CommonStatusCodes.API_NOT_CONNECTED /*17*/:
                    str5 = zzb.zzq(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new zza("Overread allowed size end=" + zzaY, parcel);
    }

    public WakeLockEvent[] zzdn(int i) {
        return new WakeLockEvent[i];
    }
}
