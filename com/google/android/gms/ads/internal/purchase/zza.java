package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.plus.model.people.Person.Urls.Type;
import com.google.firebase.messaging.SendException;

public class zza implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void zza(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int zzaZ = zzc.zzaZ(parcel);
        zzc.zza(parcel, 3, gInAppPurchaseManagerInfoParcel.zziF(), false);
        zzc.zza(parcel, 4, gInAppPurchaseManagerInfoParcel.zziG(), false);
        zzc.zza(parcel, 5, gInAppPurchaseManagerInfoParcel.zziH(), false);
        zzc.zza(parcel, 6, gInAppPurchaseManagerInfoParcel.zziE(), false);
        zzc.zzJ(parcel, zzaZ);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzO(i);
    }

    public GInAppPurchaseManagerInfoParcel[] zzO(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    public GInAppPurchaseManagerInfoParcel zzm(Parcel parcel) {
        IBinder iBinder = null;
        int zzaY = zzb.zzaY(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < zzaY) {
            int zzaX = zzb.zzaX(parcel);
            switch (zzb.zzdc(zzaX)) {
                case SendException.ERROR_TTL_EXCEEDED /*3*/:
                    iBinder4 = zzb.zzr(parcel, zzaX);
                    break;
                case SendException.ERROR_TOO_MANY_MESSAGES /*4*/:
                    iBinder3 = zzb.zzr(parcel, zzaX);
                    break;
                case Type.OTHER_PROFILE /*5*/:
                    iBinder2 = zzb.zzr(parcel, zzaX);
                    break;
                case Type.CONTRIBUTOR /*6*/:
                    iBinder = zzb.zzr(parcel, zzaX);
                    break;
                default:
                    zzb.zzb(parcel, zzaX);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaY) {
            return new GInAppPurchaseManagerInfoParcel(iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaY, parcel);
    }
}
