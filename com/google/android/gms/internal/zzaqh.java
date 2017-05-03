package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.internal.zzaqm.zza;

public class zzaqh extends zzf<zzaqm> {
    public zzaqh(Context context, Looper looper, zzb com_google_android_gms_common_internal_zzf_zzb, zzc com_google_android_gms_common_internal_zzf_zzc) {
        super(context, looper, 116, com_google_android_gms_common_internal_zzf_zzb, com_google_android_gms_common_internal_zzf_zzc, null);
    }

    public zzaqm zzGL() {
        return (zzaqm) super.zzxD();
    }

    protected zzaqm zzcT(IBinder iBinder) {
        return zza.zzcU(iBinder);
    }

    protected String zzeA() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    protected String zzez() {
        return "com.google.android.gms.gass.START";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzcT(iBinder);
    }
}
