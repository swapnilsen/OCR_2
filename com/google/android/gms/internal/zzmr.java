package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzme
public class zzmr extends zza {
    public static final Creator<zzmr> CREATOR;
    public final boolean zzSN;
    public final boolean zzSO;
    public final boolean zzSP;

    static {
        CREATOR = new zzms();
    }

    public zzmr(boolean z, boolean z2, boolean z3) {
        this.zzSN = z;
        this.zzSO = z2;
        this.zzSP = z3;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.zzSN);
        bundle.putBoolean("default_iap_supported", this.zzSO);
        bundle.putBoolean("app_streaming_supported", this.zzSP);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzms.zza(this, parcel, i);
    }
}
