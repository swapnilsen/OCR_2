package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import java.util.Arrays;

@zzme
class zzja {
    private final Object[] mParams;

    zzja(zzec com_google_android_gms_internal_zzec, String str, int i) {
        this.mParams = zzd.zza((String) zzgd.zzDe.get(), com_google_android_gms_internal_zzec, str, i, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzja)) {
            return false;
        }
        return Arrays.equals(this.mParams, ((zzja) obj).mParams);
    }

    public int hashCode() {
        return Arrays.hashCode(this.mParams);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.mParams));
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("[InterstitialAdPoolKey ").append(valueOf).append("]").toString();
    }
}
