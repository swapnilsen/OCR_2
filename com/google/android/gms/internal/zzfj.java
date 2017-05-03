package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzey.zza;

@zzme
public class zzfj extends zzf<zzez> {
    public zzfj() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzy(iBinder);
    }

    public zzey zzm(Context context) {
        try {
            return zza.zzu(((zzez) zzbl(context)).zza(zzd.zzA(context), 10298000));
        } catch (Throwable e) {
            zzqf.zzc("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (Throwable e2) {
            zzqf.zzc("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    protected zzez zzy(IBinder iBinder) {
        return zzez.zza.zzv(iBinder);
    }
}
