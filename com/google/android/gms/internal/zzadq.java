package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzadq extends zza {
    public static final Creator<zzadq> CREATOR;
    private final byte[] zzaIQ;

    static {
        CREATOR = new zzadr();
    }

    public zzadq(byte[] bArr) {
        this.zzaIQ = bArr;
    }

    public byte[] getPayload() {
        return this.zzaIQ;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzadr.zza(this, parcel, i);
    }
}
