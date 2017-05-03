package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.internal.zzadi.zza;
import com.google.android.gms.internal.zzadi.zzb;

public class zzado extends zzc<NoOptions> {
    public zzado(Context context) {
        super(context, zzadh.API, null, new zzzy());
    }

    public PendingResult<zzb> zza(zza com_google_android_gms_internal_zzadi_zza) {
        return zzadh.zzaIB.zza(asGoogleApiClient(), com_google_android_gms_internal_zzadi_zza);
    }
}
