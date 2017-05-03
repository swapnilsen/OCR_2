package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzer.zza;

@zzme
public final class zzea extends zzf<zzes> {
    public zzea() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public zzer zza(Context context, String str, zzka com_google_android_gms_internal_zzka) {
        try {
            return zza.zzo(((zzes) zzbl(context)).zza(zzd.zzA(context), str, com_google_android_gms_internal_zzka, 10298000));
        } catch (Throwable e) {
            zzqf.zzc("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            zzqf.zzc("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzj(iBinder);
    }

    protected zzes zzj(IBinder iBinder) {
        return zzes.zza.zzp(iBinder);
    }
}
