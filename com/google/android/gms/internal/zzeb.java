package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzet.zza;

@zzme
public class zzeb extends zzf<zzeu> {
    public zzeb() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public zzet zza(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzka com_google_android_gms_internal_zzka, int i) {
        Throwable e;
        try {
            return zza.zzq(((zzeu) zzbl(context)).zza(zzd.zzA(context), com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzka, 10298000, i));
        } catch (RemoteException e2) {
            e = e2;
            zzqf.zza("Could not create remote AdManager.", e);
            return null;
        } catch (zzf.zza e3) {
            e = e3;
            zzqf.zza("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzk(iBinder);
    }

    protected zzeu zzk(IBinder iBinder) {
        return zzeu.zza.zzr(iBinder);
    }
}
