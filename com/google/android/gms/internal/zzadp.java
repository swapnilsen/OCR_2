package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzadz.zza;

public class zzadp extends zzl<zzadz> {
    public zzadp(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 64, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzadz zzbC(IBinder iBinder) {
        return zza.zzbE(iBinder);
    }

    protected String zzeA() {
        return "com.google.android.gms.config.internal.IConfigService";
    }

    protected String zzez() {
        return "com.google.android.gms.config.START";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzbC(iBinder);
    }
}
