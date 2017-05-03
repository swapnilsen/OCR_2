package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.zzc.zza;

public final class zzg extends zzf<zzc> {
    private static final zzg zzbBZ;

    static {
        zzbBZ = new zzg();
    }

    private zzg() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View zza(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) zzd.zzF(((zzc) zzbBZ.zzbl(context)).zza(zzd.zzA(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    protected /* synthetic */ Object zzc(IBinder iBinder) {
        return zzeX(iBinder);
    }

    protected zzc zzeX(IBinder iBinder) {
        return zza.zzeU(iBinder);
    }
}
