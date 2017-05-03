package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzhi.zza;

@zzme
public class zzht extends zzf<zzhi> {
    public zzht() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    protected zzhi zzL(IBinder iBinder) {
        return zza.zzD(iBinder);
    }

    public zzhh zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return zzhh.zza.zzC(((zzhi) zzbl(context)).zza(zzd.zzA(context), zzd.zzA(frameLayout), zzd.zzA(frameLayout2), 10298000));
        } catch (RemoteException e2) {
            e = e2;
            zzqf.zzc("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (zzf.zza e3) {
            e = e3;
            zzqf.zzc("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzL(iBinder);
    }
}
