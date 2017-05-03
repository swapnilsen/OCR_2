package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzzs.zza;

public class zzzp extends zzl<zzzs> {
    public zzzp(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzzr com_google_android_gms_internal_zzzr, zzzm com_google_android_gms_internal_zzzm) {
        ((zzzs) zzxD()).zza(com_google_android_gms_internal_zzzr, com_google_android_gms_internal_zzzm);
    }

    protected zzzs zzbm(IBinder iBinder) {
        return zza.zzbo(iBinder);
    }

    protected String zzeA() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    protected String zzez() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzbm(iBinder);
    }
}
