package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzlg.zza;

@zzme
public final class zzlk extends zzf<zzlg> {
    public zzlk() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    protected zzlg zzac(IBinder iBinder) {
        return zza.zzZ(iBinder);
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzac(iBinder);
    }

    public zzlf zzg(Activity activity) {
        try {
            return zzlf.zza.zzY(((zzlg) zzbl(activity)).zzq(zzd.zzA(activity)));
        } catch (Throwable e) {
            zzqf.zzc("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            zzqf.zzc("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }
}
