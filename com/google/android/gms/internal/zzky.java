package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzla.zza;

@zzme
public final class zzky extends zzf<zzla> {
    public zzky() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    protected zzla zzS(IBinder iBinder) {
        return zza.zzU(iBinder);
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzS(iBinder);
    }

    public zzkz zzf(Activity activity) {
        try {
            return zzkz.zza.zzT(((zzla) zzbl(activity)).zzp(zzd.zzA(activity)));
        } catch (Throwable e) {
            zzqf.zzc("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            zzqf.zzc("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
