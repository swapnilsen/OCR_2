package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zznv.zza;

@zzme
public class zzny extends zzf<zznv> {
    public zzny() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    protected zznv zzak(IBinder iBinder) {
        return zza.zzai(iBinder);
    }

    public zznu zzb(Context context, zzka com_google_android_gms_internal_zzka) {
        Throwable e;
        try {
            return zznu.zza.zzah(((zznv) zzbl(context)).zza(zzd.zzA(context), com_google_android_gms_internal_zzka, 10298000));
        } catch (RemoteException e2) {
            e = e2;
            zzqf.zzc("Could not get remote RewardedVideoAd.", e);
            return null;
        } catch (zzf.zza e3) {
            e = e3;
            zzqf.zzc("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzak(iBinder);
    }
}
