package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.internal.zzmt.zza;

@zzme
public class zzmj extends zzf<zzmt> {
    final int zzRw;

    public zzmj(Context context, Looper looper, zzb com_google_android_gms_common_internal_zzf_zzb, zzc com_google_android_gms_common_internal_zzf_zzc, int i) {
        super(context, looper, 8, com_google_android_gms_common_internal_zzf_zzb, com_google_android_gms_common_internal_zzf_zzc, null);
        this.zzRw = i;
    }

    protected zzmt zzad(IBinder iBinder) {
        return zza.zzae(iBinder);
    }

    protected String zzeA() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    protected String zzez() {
        return "com.google.android.gms.ads.service.START";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzad(iBinder);
    }

    public zzmt zzjq() {
        return (zzmt) super.zzxD();
    }
}
