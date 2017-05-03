package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@KeepName
public class PlusCommonExtras extends zza {
    public static final Creator<PlusCommonExtras> CREATOR;
    private final int zzaiI;
    private String zzbBX;
    private String zzbBY;

    static {
        CREATOR = new zzf();
    }

    public PlusCommonExtras() {
        this.zzaiI = 1;
        this.zzbBX = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
        this.zzbBY = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_STRING;
    }

    PlusCommonExtras(int i, String str, String str2) {
        this.zzaiI = i;
        this.zzbBX = str;
        this.zzbBY = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.zzaiI == plusCommonExtras.zzaiI && zzaa.equal(this.zzbBX, plusCommonExtras.zzbBX) && zzaa.equal(this.zzbBY, plusCommonExtras.zzbBY);
    }

    public int getVersionCode() {
        return this.zzaiI;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzaiI), this.zzbBX, this.zzbBY);
    }

    public String toString() {
        return zzaa.zzv(this).zzg("versionCode", Integer.valueOf(this.zzaiI)).zzg("Gpsrc", this.zzbBX).zzg("ClientCallingPackage", this.zzbBY).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public void zzN(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzd.zza(this));
    }

    public String zzOZ() {
        return this.zzbBX;
    }

    public String zzPa() {
        return this.zzbBY;
    }
}
